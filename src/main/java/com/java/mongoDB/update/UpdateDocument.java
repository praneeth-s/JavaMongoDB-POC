package com.java.mongoDB.update;

import org.bson.Document;

import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Filters;
import com.mongodb.client.model.Updates;

public class UpdateDocument {

	public static void main(String[] args) {
		MongoClient client = new MongoClient();

		MongoDatabase database = client.getDatabase("datasets");

		MongoCollection<Document> collection = database.getCollection("zips");
		
		//Updates using new Document
		//collection.updateOne(Filters.eq("_id", "01001"), new Document("$set",new Document("State","MA").append("Updated", true)));
		
		//Updates using Updates.set
		collection.updateOne(Filters.eq("_id","01001"), Updates.set("Country", "USA"));
		
		collection.updateOne(Filters.eq("_id","01001"), Updates.combine(Updates.set("Zip", "00000"),Updates.set("pop", 1240)));
		
		client.close();
	}

}
