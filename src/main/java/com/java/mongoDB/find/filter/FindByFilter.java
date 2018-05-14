package com.java.mongoDB.find.filter;

import java.util.Random;

import org.bson.Document;
import org.bson.conversions.Bson;

import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.MongoDatabase;
import static com.mongodb.client.model.Filters.*;

public class FindByFilter {
	public static void main(String[] args) {

		MongoClient client = new MongoClient();

		MongoDatabase database = client.getDatabase("test");

		MongoCollection<Document> collection = database.getCollection("randomnumbers");

		for (int i = 0; i < 10; i++) {
			collection.insertOne(new Document("x", new Random().nextInt(2)).append("y", new Random().nextInt(100)));
		}

		// Using document as filter
		/*
		 * Document docFilter = new Document("x", 0).append("y", new Document("$gte",
		 * 10)).append("y", new Document("$lte", 90));
		 */

		// Using filters

		Bson docFilter = and(eq("x", 0), gt("y",10), lt("y",20));

		MongoCursor<Document> cursor = collection.find(docFilter).iterator();

		try {
			while (cursor.hasNext()) {
				System.out.println(cursor.next().toJson());
			}
		} finally {
			cursor.close();
		}

	}

}
