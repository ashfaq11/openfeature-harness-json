package com.example.demo_harness;

import java.io.*;

import java.util.*;
import java.util.stream.Collectors;

import org.json.simple.*;

import org.json.simple.parser.*;

public class Test {

	public static void main(String[] args) {
		JSONParser parser = new JSONParser();  
		try {

			Object obj = parser.parse(new FileReader("./flags.json"));
			JSONObject jsonObject = (JSONObject) obj;
			JSONObject featureFlags = (JSONObject) jsonObject.get("featureFlags");
			System.out.println(featureFlags.get("projectIdentifier"));
			System.out.println(featureFlags.get("orgIdentifier"));
			JSONArray flags = (JSONArray) featureFlags.get("flags");
			Iterator<JSONObject> itr = flags.iterator();
			while (itr.hasNext())  {
				JSONObject obj1 = itr.next();
	        	if(((JSONObject) obj1.get("flag")!=null) && obj1.containsKey("flag")) {
				{
					JSONObject flag = (JSONObject) obj1.get("flag");
					System.out.println(flag.get("identifier"));
//					System.out.println(flag.get("name"));
					System.out.println(flag.get("environments"));


				}
				}
	        	
	        }

		} catch (Exception e) {

			e.printStackTrace();

		}

	}

}
