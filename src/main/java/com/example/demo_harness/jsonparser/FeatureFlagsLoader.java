package com.example.demo_harness.jsonparser;

import java.io.FileReader;
import java.io.IOException;
import java.io.StringWriter;
import java.util.List;
import java.util.Optional;

import org.yaml.snakeyaml.Yaml;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;

import dev.openfeature.sdk.ErrorCode;
public class FeatureFlagsLoader {

	public boolean getBooleanValue(String identifier, String environment) throws Exception {
		try {
			ObjectMapper objectMapper = new ObjectMapper();
			Yaml yaml = new Yaml();
			Gson gson = new Gson();        
			Object obj = yaml.load(new FileReader("./flags.yaml"));
			StringWriter writer = new StringWriter();
			gson.toJson(obj, writer);
			String jsonResult = writer.toString();
			
			objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
			FeatureFlagContainer featureFlagContainer = objectMapper.readValue(jsonResult, FeatureFlagContainer.class);
			FeatureFlags featureFlags = featureFlagContainer.getFeatureFlags();
			
			List<Flag> flags = featureFlags.getFlags();
			Optional<Flag> flagResult = flags.stream().filter(flag -> flag.getIdentifier().equalsIgnoreCase(identifier)).findAny();
			
			
			
			if (flagResult.isPresent()) {
				Optional<Environment> currentEnvironment = flagResult.get().getEnvironments().stream().filter(env -> env.getIdentifier().equalsIgnoreCase(environment)).findAny();
				
				if(currentEnvironment.isPresent()) {
					return Boolean.valueOf(currentEnvironment.get().getState().equalsIgnoreCase("ON")?
							currentEnvironment.get().getDefaultVariation().getOnVariation():
								currentEnvironment.get().getDefaultVariation().getOffVariation());
					
				}else {
					throw new Exception(ErrorCode.INVALID_CONTEXT.name()+" No Environment found");
				}
				
			} else {
				throw new Exception(identifier+" "+ErrorCode.FLAG_NOT_FOUND.name());
			}
		} catch (IOException e) {
			e.printStackTrace();
			throw new Exception("Exception occurred : " + e.getMessage());
		}

	}
}
