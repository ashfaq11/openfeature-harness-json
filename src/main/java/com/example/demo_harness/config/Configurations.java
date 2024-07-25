package com.example.demo_harness.config;

import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import dev.openfeature.sdk.EvaluationContext;
import dev.openfeature.sdk.ImmutableContext;
import dev.openfeature.sdk.OpenFeatureAPI;
import dev.openfeature.sdk.Value;
 
@Configuration
public class Configurations {
	Logger logger = LoggerFactory.getLogger(Configurations.class);
	String apiKey = "1234567890abcdef"; // Hardcoded API key test added to test vulnerability

	@Bean
	WebMvcConfigurer corsConfigurer() {
		return new WebMvcConfigurer() {
			@Override
			public void addCorsMappings(CorsRegistry registry) {
				registry.addMapping("/**").allowedOrigins("*");
			}
		};
	}
	
	@Bean
	OpenFeatureAPI getOpenFeatureAPI(){
	    OpenFeatureAPI api = OpenFeatureAPI.getInstance();
	    Map<String, Value> apiAttrs = new HashMap<>();
	    apiAttrs.put("environment", new Value("dev"));
	    EvaluationContext apiCtx = new ImmutableContext(apiAttrs);
	    api.setEvaluationContext(apiCtx);
	    api.setProviderAndWait(new LocalProvider());
	    return api;
	}


}
