package com.example.demo_harness.jsonparser;

import java.util.List;

public class FeatureFlags {
    private List<FlagContainer> flags;
    private String projectIdentifier;
    private String orgIdentifier;
	public List<FlagContainer> getFlags() {
		return flags;
	}
	public void setFlags(List<FlagContainer> flags) {
		this.flags = flags;
	}
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

    
}