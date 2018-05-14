package com.java.mongoDB.count;

import org.bson.Document;

import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;

public class CountOfDocuments {

	public static void main(String[] args) {
		MongoClient client = new MongoClient();

		MongoDatabase database = client.getDatabase("information");

		MongoCollection<Document> collection = database.getCollection("users");

		Long count = collection.count();

		System.out.println("Count is " + count);

		client.close();

	}

}
