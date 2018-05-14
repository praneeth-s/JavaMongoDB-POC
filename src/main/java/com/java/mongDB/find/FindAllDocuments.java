package com.java.mongDB.find;

import org.bson.Document;

import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.MongoDatabase;

public class FindAllDocuments {

	public static void main(String[] args) {

		MongoClient client = new MongoClient();

		MongoDatabase database = client.getDatabase("information");

		MongoCollection<Document> collection = database.getCollection("users");

		// 1st way
		/*
		 * FindIterable<Document> documents = collection.find();
		 * 
		 * Iterator<Document> itr = documents.iterator();
		 * 
		 * while (itr.hasNext()) { System.out.println(itr.next().toJson()); }
		 */

		MongoCursor<Document> cursor = collection.find().iterator();
		try {
			while (cursor.hasNext()) {
				System.out.println(cursor.next());
			}
		} finally {
			cursor.close();
		}

		client.close();
	}

}
