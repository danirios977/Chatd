package com.project.chatd.config;

import com.mongodb.ConnectionString;
import com.mongodb.MongoClientSettings;
import com.mongodb.MongoCredential;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MongoConfig {

    @Bean
    public MongoClient mongo() {
        
        MongoCredential credential = MongoCredential.createCredential("admin", "admin", "elportu123".toCharArray());

        MongoClientSettings settings = MongoClientSettings.builder()
                .applyConnectionString(new ConnectionString("mongodb://localhost:27017/chatd"))
                .credential(credential)
                .build();

        return MongoClients.create(settings);
    }
}