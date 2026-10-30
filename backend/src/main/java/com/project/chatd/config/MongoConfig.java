package com.project.chatd.config;

import com.mongodb.ConnectionString;
import com.mongodb.MongoClientSettings;
import com.mongodb.MongoCredential;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.MongoDatabaseFactory;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.SimpleMongoClientDatabaseFactory;

@Configuration
public class MongoConfig {

    @Bean
    public MongoClient mongoClient() {
        
        MongoCredential credential = MongoCredential.createCredential("admin", "admin", "elportu123".toCharArray());

        MongoClientSettings settings = MongoClientSettings.builder()
                .applyConnectionString(new ConnectionString("mongodb://localhost:27017/chatd"))
                .credential(credential)
                .build();

        return MongoClients.create(settings);
    }
    
    @Bean
    public MongoDatabaseFactory mongoDataBaseFactory() {
    	return new SimpleMongoClientDatabaseFactory(mongoClient(), "chatd");
    }
    
    @Bean
    public MongoTemplate mongoTemplate() {
    	return new MongoTemplate(mongoDataBaseFactory());
    }
}