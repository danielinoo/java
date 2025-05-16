package testMongo;

import org.bson.Document;

import com.mongodb.client.*;

public class Main {
	private final static String DB3 = "BD3";
	private final static String TEST_CALL = "test";

	public static void main(String[] args) {
		String uri = "mongodb+srv://xeyewal413:68Dh9bXsBQPPZani@bd3cluster.857gz.mongodb.net/?retryWrites=true&w=majority&appName=BD3Cluster";

		try (MongoClient mongoClient = MongoClients.create(uri)) {
			MongoDatabase database = mongoClient.getDatabase(DB3);
			MongoCollection<org.bson.Document> collection = database.getCollection(TEST_CALL);
			Document doc = collection.find().first();
			if (doc != null) {
				System.out.println(doc.toJson());
			} else {
				System.out.println("No matching documents found.");

			}
			insert(collection);
			findALL(collection);
		}
	}

	private static void insert(MongoCollection<Document> collection) {
		Document car = new Document("brand", "fiat").append("model", "panda");
		Document newdoc = new Document("name", "Riccardo").append("age", 50).append("car", car);
		collection.insertOne(newdoc);
	}

	private static void findALL(MongoCollection<Document> collection) {
		FindIterable<Document> documents = collection.find();

		for (Document document : documents) {
			System.out.println(document.toJson());
		}

	}
}
