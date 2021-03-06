package com.java.mongoDB.find;

import org.bson.Document;

import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;

public class FindOneDocument {

	public static void main(String[] args) {
		MongoClient client = new MongoClient();

		MongoDatabase database = client.getDatabase("datasets");

		MongoCollection<Document> collection = database.getCollection("stocks");

		Document oneDoc = collection.find().first();

		System.out.println(oneDoc.toJson());

		client.close();

	}

}
