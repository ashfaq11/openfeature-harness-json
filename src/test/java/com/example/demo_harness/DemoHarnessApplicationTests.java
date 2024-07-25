package com.example.demo_harness;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.demo_harness.jsonparser.FeatureFlagsLoader;


@SpringBootTest
class DemoHarnessApplicationTests {

	@Mock
	FeatureFlagsLoader featureFlagsLoader;
	@BeforeAll
	 static void context() {
	}

	 
	@Test
	void testBooleanFlagTrue() throws Exception {
		when(featureFlagsLoader.getBooleanValue("flagName", "dev")).thenReturn(true);
		assertEquals(true, featureFlagsLoader.getBooleanValue("flagName", "dev"));
	} 
	
}
