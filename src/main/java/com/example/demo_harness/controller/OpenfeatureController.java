package com.example.demo_harness.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import dev.openfeature.sdk.Client;
import dev.openfeature.sdk.OpenFeatureAPI;

 
@RestController
public class OpenfeatureController {

	@Autowired
	OpenFeatureAPI api;

	@GetMapping("/flag/bool-variation")
	public boolean booleanVariation(@RequestParam String flagName,@RequestParam boolean defaultValue) throws InstantiationException {
		Client client = api.getClient();
		return client.getBooleanValue(flagName, defaultValue);
	}
}
