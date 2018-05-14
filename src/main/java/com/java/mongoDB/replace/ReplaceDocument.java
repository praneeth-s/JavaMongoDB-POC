package com.java.mongoDB.replace;

import org.bson.Document;

import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Filters;

public class ReplaceDocument {

	public static void main(String[] args) {
		MongoClient client = new MongoClient();

		MongoDatabase database = client.getDatabase("datasets");

		MongoCollection<Document> collection = database.getCollection("zips");

		collection.replaceOne(Filters.eq("_id", "01008"), new Document("city", "Lansing").append("State", "MI"));

		client.close();
	}

}
