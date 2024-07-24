package com.example.demo_harness.config;

import com.example.demo_harness.jsonparser.FeatureFlagsLoader;

import dev.openfeature.sdk.EvaluationContext;
import dev.openfeature.sdk.FeatureProvider;
import dev.openfeature.sdk.Metadata;
import dev.openfeature.sdk.ProviderEvaluation;
import dev.openfeature.sdk.ProviderState;
import dev.openfeature.sdk.Value;

public class LocalProvider implements FeatureProvider {
	@Override
	public Metadata getMetadata() {
		return () -> "My Provider";
	}

	@Override
	public ProviderState getState() {
		return null;
		// optionally indicate your provider's state (assumed to be READY if not
		// implemented)
	}

	@Override
	public void initialize(EvaluationContext evaluationContext)
			throws Exception {
		// start up your provider
	}

	@Override
	public void shutdown() {
		// shut down your provider
	}

	@Override
	public ProviderEvaluation<Boolean> getBooleanEvaluation(String key,
			Boolean defaultValue, EvaluationContext ctx) {
		// resolve a boolean flag value

		try {
			return ProviderEvaluation.<Boolean>builder()
					.value(FeatureFlagsLoader.getBooleanValue(key)).build();
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException(e.getMessage());
		}
	}

	@Override
	public ProviderEvaluation<String> getStringEvaluation(String key,
			String defaultValue, EvaluationContext ctx) {
		return ProviderEvaluation.<String>builder()
				.value(String.valueOf("default")).build();
	}

	@Override
	public ProviderEvaluation<Integer> getIntegerEvaluation(String key,
			Integer defaultValue, EvaluationContext ctx) {
		return ProviderEvaluation.<Integer>builder().value(Integer.valueOf(1))
				.build();
	}

	@Override
	public ProviderEvaluation<Double> getDoubleEvaluation(String key,
			Double defaultValue, EvaluationContext ctx) {
		return ProviderEvaluation.<Double>builder().value(Double.valueOf(1))
				.build();
	}

	@Override
	public ProviderEvaluation<Value> getObjectEvaluation(String key,
			Value defaultValue, EvaluationContext ctx) {
		return ProviderEvaluation.<Value>builder().value(new Value("default"))
				.build();
	}
}
