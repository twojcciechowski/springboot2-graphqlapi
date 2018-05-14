package pl.tw.graphqlapi;

import graphql.schema.GraphQLSchema;
import graphql.servlet.DefaultGraphQLSchemaProvider;
import graphql.servlet.GraphQLSchemaProvider;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@SpringBootApplication
@Configuration
public class GraphqlapiApplication {

	public static void main(String[] args) {
		SpringApplication.run(GraphqlapiApplication.class, args);
	}

}


