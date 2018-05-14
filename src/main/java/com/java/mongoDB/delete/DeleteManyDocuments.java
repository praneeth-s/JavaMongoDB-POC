package com.java.mongoDB.delete;

import org.bson.Document;

import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Filters;

public class DeleteManyDocuments {

	public static void main(String[] args) {
		MongoClient client = new MongoClient();
		MongoDatabase database = client.getDatabase("datasets");
		MongoCollection<Document> collection = database.getCollection("zips");

		collection.deleteMany(Filters.gt("_id", "6000"));

		client.close();

	}

}
