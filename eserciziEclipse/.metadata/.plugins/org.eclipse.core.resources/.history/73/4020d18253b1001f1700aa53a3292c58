
public class WiFi {
	private String id;
	private String password;
	private String protocollo;
	private Double frequenza;
	
	public static WiFi MakeWifi() {
		WiFi wifi = new WiFi();
		wifi.frequenza=Util.GetFrequenza();
		wifi.id = Util.GetPassword(false);
		wifi.password = Util.GetPassword(true);
		wifi.protocollo = Util.GetRandomAuthProto();
		return wifi;
	}
	
	public WiFi(String id, String password, String protocollo, Double frequenza) {
		super();
		this.id = id;
		this.password = password;
		this.protocollo = protocollo;
		this.frequenza = frequenza;
	}
	public WiFi() {
		super();
	}
	@Override
	public String toString() {
		return "WiFi [id=" + id + ", password=" + password + ", protocollo=" + protocollo + ", frequenza=" + frequenza
				+ "]";
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getProtocollo() {
		return protocollo;
	}
	public void setProtocollo(String protocollo) {
		this.protocollo = protocollo;
	}
	public Double getFrequenza() {
		return frequenza;
	}
	public void setFrequenza(Double frequenza) {
		this.frequenza = frequenza;
	}


}
