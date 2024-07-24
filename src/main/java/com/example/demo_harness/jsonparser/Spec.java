package com.example.demo_harness.jsonparser;

import java.util.List;

public class Spec {
    private String type;
    private DefaultVariation defaultVariation;
    private List<Variation> variations;
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public DefaultVariation getDefaultVariation() {
		return defaultVariation;
	}
	public void setDefaultVariation(DefaultVariation defaultVariation) {
		this.defaultVariation = defaultVariation;
	}
	public List<Variation> getVariations() {
		return variations;
	}
	public void setVariations(List<Variation> variations) {
		this.variations = variations;
	}

    
}