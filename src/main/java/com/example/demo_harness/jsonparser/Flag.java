package com.example.demo_harness.jsonparser;

import java.util.List;

public class Flag {
    private String name;
    private String identifier;
    private String description;
    private boolean permanent;
    private Spec spec;
    private List<Environment> environments;

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getIdentifier() {
		return identifier;
	}
	public void setIdentifier(String identifier) {
		this.identifier = identifier;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public boolean isPermanent() {
		return permanent;
	}
	public void setPermanent(boolean permanent) {
		this.permanent = permanent;
	}
	public Spec getSpec() {
		return spec;
	}
	public void setSpec(Spec spec) {
		this.spec = spec;
	}
	public List<Environment> getEnvironments() {
		return environments;
	}
	public void setEnvironments(List<Environment> environments) {
		this.environments = environments;
	}

}