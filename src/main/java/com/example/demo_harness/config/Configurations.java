package com.example.demo_harness.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import dev.openfeature.sdk.OpenFeatureAPI;
import io.harness.cf.client.api.BaseConfig;
import io.harness.cf.client.api.CfClient;
import io.harness.cf.client.api.FeatureFlagInitializeException;
import io.harness.cf.client.connector.LocalConnector;
 
@Configuration
public class Configurations {
	Logger logger = LoggerFactory.getLogger(Configurations.class);

	@Bean
	WebMvcConfigurer corsConfigurer() {
		return new WebMvcConfigurer() {
			@Override
			public void addCorsMappings(CorsRegistry registry) {
				registry.addMapping("/**").allowedOrigins("*");
			}
		};
	}
	
//	@Bean
//	CfClient getClient() throws InterruptedException, FeatureFlagInitializeException {
//		CfClient cfClient = new CfClient("6fa26cd8-3cc0-422f-be20-1f4c264e6b38");
//		cfClient.waitForInitialization();
		
//		LocalConnector connector = new LocalConnector("./local");  
//		CfClient cfClient = new CfClient(connector, BaseConfig.builder().build());
//		cfClient.waitForInitialization();

				
//		return cfClient;

//	}
	
	@Bean
	OpenFeatureAPI getOpenFeatureAPI(){
	    OpenFeatureAPI api = OpenFeatureAPI.getInstance();
	    api.setProviderAndWait(new LocalProvider());
	    return api;
	}


}
