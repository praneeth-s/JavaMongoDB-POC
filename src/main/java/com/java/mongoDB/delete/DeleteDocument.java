package com.java.mongoDB.delete;

import org.bson.Document;

import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Filters;

public class DeleteDocument {

	public static void main(String[] args) {
		MongoClient client = new MongoClient();
		MongoDatabase database = client.getDatabase("datasets");
		MongoCollection<Document> collection = database.getCollection("zips");

		collection.deleteOne(Filters.eq("_id", "01001"));

		client.close();

	}

}
