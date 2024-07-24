package com.example.demo_harness.jsonparser;

import com.fasterxml.jackson.annotation.JsonProperty;

public 

class Environment {
    private String identifier;
    @JsonProperty("default")
    private DefaultVariation defaultVariation;
    private String state;
	public String getIdentifier() {
		return identifier;
	}
	public void setIdentifier(String identifier) {
		this.identifier = identifier;
	}
	public DefaultVariation getDefaultVariation() {
		return defaultVariation;
	}
	public void setDefaultVariation(DefaultVariation defaultVariation) {
		this.defaultVariation = defaultVariation;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}

    
}
