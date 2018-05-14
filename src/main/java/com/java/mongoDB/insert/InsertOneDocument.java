package com.java.mongoDB.insert;

import org.bson.Document;

import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;

public class InsertOneDocument {

	public static void main(String[] args) {

		MongoClient client = new MongoClient();

		MongoDatabase database = client.getDatabase("information");

		MongoCollection<Document> documents = database.getCollection("users");

		Document sam = new Document("name", "Sam")
				.append("age", 26)
				.append("location", "USA")
				.append("profession", "Programmer");

		documents.insertOne(sam);
		

		client.close();

	}

}
