package com.spring.progetto5.dao;

import java.util.ArrayList;

import java.util.LinkedList;
import java.util.List;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.stereotype.Repository;

import com.spring.progetto5.entity.ContattoEntity;
import com.spring.progetto5.entity.RubricaEntity;

@Repository
public class Dao implements DaoRubrica {

	// connessione al database
	public static Connection connessione() {
		// PUNTO 1 : Carico i driver in memoria
		String driver = "org.postgresql.Driver";
		try {
			Class.forName(driver);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		// PUNTO 2 : Creo url di connessione
		String url = "jdbc:postgresql://localhost:5432/Rubriche?user=postgres&password=postgres&ssl=false";
		Connection conn = null;

		// PUNTO 3 : Connetto al database
		try {
			conn = DriverManager.getConnection(url);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return conn;

	}
	
	public void ChiusuraConnessione(Connection conn, ResultSet result, PreparedStatement prep) {
	        try {
	            if (result != null) {
	                result.close();
	            }else {
	                result = null;
	            }
	            conn.close();
	            prep.close();
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	    }
	

	// inserisci una rubrica (vuota)
	public boolean insert(RubricaEntity r) {
		Connection conn = connessione();
		PreparedStatement prepRubrica = null;
		
		try {

		
			String queryInserisciRubrica = "insert into rubrica (id, annocreazione,proprietario) values (?,?,?)";
			prepRubrica = conn.prepareStatement(queryInserisciRubrica);
			prepRubrica.setInt(1, r.getId());
			prepRubrica.setInt(2, r.getAnnoCreazione());
			prepRubrica.setString(3, r.getProprietario());
			prepRubrica.execute();
			for (ContattoEntity c : r.getLista()) {
				String queryInserimentoContatto = "inserti into contatti(id, nome,cognome,numero,gruppo_appartenza,data_nascita,preferito,rubrica_id) values (?,?,?,?,?,?,?,?)";
				PreparedStatement prep = conn.prepareStatement(queryInserimentoContatto);
				prep.setInt(0, c.getId());
				prep.setString(1, c.getNome());
				prep.setString(2, c.getCognome());
				prep.setString(3, c.getNumero());
				prep.setString(1, c.getGruppo_appartenenza());
				prep.setDate(5, c.getDataNascita());
				prep.setBoolean(6, c.isPreferito());
				prep.setInt(7, r.getId());
				prep.execute();

			}
			return true;
		}

		catch (Exception e) {
			return false;
		}
		finally {
			ChiusuraConnessione(conn, null, prepRubrica);
		}

	}

	// visualizza tutte le rubriche
	public List<RubricaEntity> visualizzaRubriche() {
		Connection conn = connessione();
		PreparedStatement prep = null;
		ResultSet risultato = null;
		
		try {
			List<RubricaEntity> lista = new ArrayList<RubricaEntity>();

			String queryCercaIDRubrica = "select id from rubrica";
			prep = conn.prepareStatement(queryCercaIDRubrica);
			risultato = prep.executeQuery();
			while (risultato.next()) {
				lista.add(cercaId(risultato.getInt("id")));

			}
			return lista;

		}

		catch (Exception e) {
			throw new RuntimeException("errore di connessione");
		}
		
		finally {
			ChiusuraConnessione(conn, risultato, prep);
		}


	}

	// cerca per id una rubrica
	public RubricaEntity cercaId(Integer id) {
		Connection conn = connessione();
		PreparedStatement prep = null;
		ResultSet risultato = null;
		

		try {
			// PUNTO 4
			// PREPAREDSTATEMENT
			String queryCercaIDRubrica = "select * from rubrica where id = " + id + "";
			String queryContattiRubrica = "select * from contatti where rubrica_id =" + id + "";

			 prep = conn.prepareStatement(queryCercaIDRubrica);

			PreparedStatement prepCont = conn.prepareStatement(queryContattiRubrica);

			// PUNTO 5 : eseguire la QUERY
			risultato = prep.executeQuery(); // select
			ResultSet Contatti = prepCont.executeQuery();
			// insert / update / delete ...
			// prep.execute();

			// PUNTO 6 : elaboro i dati
			LinkedList<ContattoEntity> lista = new LinkedList<>();
			while (Contatti.next()) {
				lista.add(new ContattoEntity(Contatti.getInt("id"), Contatti.getString("nome"),
						Contatti.getString("cognome"), Contatti.getString("numero"),
						Contatti.getString("gruppo_appartenenza"), Contatti.getDate("data_nascita"),
						Contatti.getBoolean("preferito")));

			}
			risultato.next();
			RubricaEntity rub = new RubricaEntity(risultato.getInt("id"), lista, risultato.getInt("annocreazione"),
					risultato.getString("proprietario"));

			return rub;

		}

		catch (Exception e) {
			throw new RuntimeException("errore di connessione");
		}
		finally {
			ChiusuraConnessione(conn, risultato, prep);
		}

	}

	// controllo l id della rubrica e la cancella
	public boolean elimina(Integer id) {
		Connection conn = connessione();
		PreparedStatement prep = null;
		try {

			// classe per la connessione
			conn = connessione();
			String queryEliminaRubrica = "DELETE FROM rubrica WHERE id = " + id + "; ";
			String queryEliminaContatti = "DELETE FROM contatti WHERE rubrica_id =" + id + "";

			prep = conn.prepareStatement(queryEliminaRubrica);

			PreparedStatement prepCont = conn.prepareStatement(queryEliminaContatti);
			// PUNTO 5 : eseguire la QUERY
			
			prep.execute(); // select
			prepCont.execute();
			
			return true;


		} catch (Exception e) {
			// TODO: handle exception
			throw new RuntimeException("Id non trovato");
		}
		
		finally {
			ChiusuraConnessione(conn, null, prep);
		}
	}
	
	public boolean update(RubricaEntity rubrica) {
        Connection conn = connessione();
        boolean risultato;
        String miaquery = "UPDATE rubrica SET proprietario = ?, annocreazione= ? WHERE id = ?";
        PreparedStatement prep = null;
        try {
            prep = conn.prepareStatement(miaquery);
            prep.setString(1, rubrica.getProprietario());
            prep.setInt(2, rubrica.getAnnoCreazione());
            prep.setInt(3, rubrica.getId());
            
            risultato  = prep.execute();
            
            return risultato;
            
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            ChiusuraConnessione(conn, null, prep);
        }
		return false;
    }

	
	//DAO CONTATTO
	
		public boolean insert(int idRubrica, ContattoEntity contatto) {
		    Connection conn = connessione();
		    String miaquery = "INSERT INTO public.contatti(\n"
		            + "	id, nome, cognome, numero, gruppo_appartenenza, data_nascita, preferito, rubrica_id)\n"
		            + "	VALUES (?, ?, ?, ?, ?, ?, ?, ?);";
		    PreparedStatement prep = null; 
		    try {
		        prep = conn.prepareStatement(miaquery);
		        prep.setInt(1, contatto.getId());
		        prep.setString(2, contatto.getNome());
		        prep.setString(3, contatto.getCognome());
		        prep.setString(4, contatto.getNumero()); 
		        prep.setString(5, contatto.getGruppo_appartenenza());
		        prep.setDate(6, contatto.getDataNascita());
		        prep.setBoolean(7, contatto.isPreferito());
		        prep.setInt(8, idRubrica);
		        prep.execute();
		    } catch (SQLException e) {
		        e.printStackTrace();  // Stampiamo l'errore per debug
		        return false;
		    } finally {
		        ChiusuraConnessione(conn, null, prep);
		    }
		    return true;
		}
		
		public List<ContattoEntity> selectAllContatti(int idRubrica) {
			Connection conn = connessione();
			String miaquery = "select * from contatti where rubrica_id = ? ";
			ArrayList<ContattoEntity> contatti = new ArrayList<>();
			PreparedStatement prep = null;
			ResultSet ris = null;
			try {	
					prep = conn.prepareStatement(miaquery);
					prep.setInt(1, idRubrica);
					ris = prep.executeQuery();
					while (ris.next()) {
						int id = ris.getInt("id");
						String nome = ris.getString("nome");
						String cognome = ris.getString("cognome");
						String numero = ris.getString("numero");
						String gruppo = ris.getString("gruppo_appartenenza");
						Date data = ris.getDate("data_nascita");
						boolean preferito = ris.getBoolean("preferito");
						contatti.add(new ContattoEntity(id, nome, cognome, numero, gruppo, data, preferito));
					}
				
			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				ChiusuraConnessione(conn, ris, prep);
			}
			return contatti ;
		}
}
