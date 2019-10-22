package com.test.demo;

import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.MongoDbFactory;
import org.springframework.data.mongodb.config.AbstractMongoClientConfiguration;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.SimpleMongoClientDbFactory;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;

@Configuration
public class SpringMongoConfig extends AbstractMongoClientConfiguration {
	Logger logger = Logger.getLogger(SpringMongoConfig.class.getName());
    @Value("${spring.data.mongodb.host}")
    private String mongoHost;
    @Value("${spring.data.mongodb.port}")
    private String mongoPort;
    @Value("${spring.data.mongodb.database}")
    private String mongoDB;
    
   
    @Override
    @Bean
	public MongoDbFactory mongoDbFactory() {
		return new SimpleMongoClientDbFactory(mongoClient(), getDatabaseName());
	}
    @Override
	@Bean
	public MongoTemplate mongoTemplate() {
		MongoTemplate mongoTemplate = new MongoTemplate(mongoDbFactory());

		return mongoTemplate;

    }

	@Override
	public MongoClient mongoClient() {
		// TODO Auto-generated method stub
		  String myHost = System.getenv("MONGODB_HOST");
    	  logger.info("MONGODB_HOST="+myHost);
    	String connectionString=  "mongodb://"+(myHost==null ? mongoHost : myHost)+ ":" + Integer.parseInt(mongoPort );
    	  logger.info("connectionString="+connectionString);
		return   MongoClients.create(connectionString);
	}

	@Override
	protected String getDatabaseName() {
		// TODO Auto-generated method stub
		return mongoDB;
	}
}