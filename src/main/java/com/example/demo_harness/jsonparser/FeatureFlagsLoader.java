package com.example.demo_harness.jsonparser;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Optional;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;

import dev.openfeature.sdk.ErrorCode;
public class FeatureFlagsLoader {
	public static void main(String[] args) throws Exception {
		System.out.println(getBooleanValue("flag1"));
		System.out.println(getBooleanValue("flag2"));
		// System.out.println(getValue("pipeline2"));

	}

	public static boolean getBooleanValue(String identifier) throws Exception {
		ObjectMapper objectMapper = new ObjectMapper();
		try {
			objectMapper.configure(
					DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
			FeatureFlagContainer featureFlagContainer = objectMapper.readValue(
					new File("./flags.json"), FeatureFlagContainer.class);
			FeatureFlags featureFlags = featureFlagContainer.getFeatureFlags();
			List<FlagContainer> flags = featureFlags.getFlags();
			// System.out.println("flags :");
			//
			// flags.forEach(flagContainer -> {
			// System.out.println(flagContainer.getFlag().getIdentifier());
			// // Process the flags as needed
			// });
			//
			Optional<FlagContainer> flag = flags.stream().filter(flagContainer -> flagContainer.getFlag()
							.getIdentifier().equalsIgnoreCase(identifier)).findAny();
			
			if (flag.isPresent()) {
				return Boolean.valueOf((flag.get().getFlag().getEnvironments()
						.get(0).getState().equalsIgnoreCase("ON")
								? flag.get().getFlag().getEnvironments().get(0)
										.getDefaultVariation().getOnVariation()
								: flag.get().getFlag().getEnvironments().get(0)
										.getDefaultVariation()
										.getOffVariation()));
			} else {
				throw new Exception(ErrorCode.FLAG_NOT_FOUND.name());
			}
		} catch (IOException e) {
			e.printStackTrace();
			throw new Exception("Exception occurred : " + e.getMessage());
		}

	}
}
