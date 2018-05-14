package com.java.mongoDB.projection;

import java.util.Random;

import org.bson.Document;
import org.bson.conversions.Bson;

import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Projections;

import static com.mongodb.client.model.Filters.*;

public class MongoProjection {

	public static void main(String[] args) {

		MongoClient client = new MongoClient();

		MongoDatabase database = client.getDatabase("test");

		MongoCollection<Document> collection = database.getCollection("randomnumbers");

		for (int i = 0; i < 10; i++) {
			collection.insertOne(new Document("x", new Random().nextInt(2)).append("y", new Random().nextInt(100)));
		}

		Bson docFilter = or(eq("x", 0), lte("y", 10), gte("y", 5));

		// Using Document
		// Bson projection = new Document("y",1).append("_id", 0);

		// Using projections
		// Bson projection = Projections.exclude("y","_id");

		Bson projection = Projections.fields(Projections.include("x", "y"), Projections.excludeId());

		MongoCursor<Document> cursor = collection.find(docFilter).projection(projection).iterator();

		try {
			while (cursor.hasNext()) {
				System.out.println(cursor.next().toJson());
			}
		} finally {
			cursor.close();
		}

	}

}
