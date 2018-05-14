package com.java.mongoDB.sort;

import org.bson.Document;
import org.bson.conversions.Bson;

import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.MongoDatabase;
import static com.mongodb.client.model.Sorts.*;

public class SortDocuments {

	public static void main(String[] args) {
		MongoClient client = new MongoClient();

		MongoDatabase database = client.getDatabase("information");

		MongoCollection<Document> collection = database.getCollection("users");

		// Sort using document
		// Document sort = new Document("name", 1);

		// Sort using sorts
		Bson sort = descending("name");

		MongoCursor<Document> results = collection.find().sort(sort).skip(2).limit(3).iterator();

		while (results.hasNext()) {
			System.out.println(results.next());
		}

		client.close();
	}

}
