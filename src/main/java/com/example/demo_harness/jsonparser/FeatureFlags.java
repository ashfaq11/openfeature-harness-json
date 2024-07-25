package com.example.demo_harness.jsonparser;

import java.util.List;

public class FeatureFlags {
    private List<Flag> flags;
    private String projectIdentifier;
    private String orgIdentifier;
	 
	public String getProjectIdentifier() {
		return projectIdentifier;
	}
	public void setProjectIdentifier(String projectIdentifier) {
		this.projectIdentifier = projectIdentifier;
	}
	public String getOrgIdentifier() {
		return orgIdentifier;
	}
	public void setOrgIdentifier(String orgIdentifier) {
		this.orgIdentifier = orgIdentifier;
	}
	public List<Flag> getFlags() {
		return flags;
	}
	public void setFlags(List<Flag> flags) {
		this.flags = flags;
	}

    
}