package com.java.mongoDB.insert;

import java.util.Arrays;

import org.bson.Document;

import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;

public class InsertManyDocuments {

	public static void main(String[] args) {

		MongoClient client = new MongoClient();

		MongoDatabase database = client.getDatabase("information");

		MongoCollection<Document> collection = database.getCollection("users");

		Document sam = new Document("name", "Sam")
				.append("age", 29)
				.append("profession", "programmer")
				.append("profession tags", Arrays.asList("Programmer Analyst", "Software Developer", "Web Developer"))
				.append("address", new Document("city","Fremont").append("State", "California"));
		
		Document jones = new Document("name", "Jones")
				.append("age", 26)
				.append("profession", ".NET Developer")
				.append("profession tags", Arrays.asList("Programmer Analyst", "Software Developer", "Web Developer"))
				.append("address", new Document("city","Harrisburg").append("State", "PA"));
		
		Document Lisa = new Document("name", "Lisa")
				.append("age", 25)
				.append("profession", "HR")
				.append("address", new Document("city","Chicago").append("State", "IL"));

		collection.insertMany(Arrays.asList(sam,jones,Lisa));
		
		client.close();

	}

}
