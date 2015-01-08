package com.github.vulpinejson;

public class VulpineJSON
{
	/*

	The main method is used purely for debuging test cases.

	--- Do not use the main method in your implementation. --

	*/

	public static void main(String[] args)
	{
		JSONElement str = JSONElement.parse("\"Name\" : \"Justin\" ");

		JSONObject jsonObj = JSONObject.parse("{\"Name\" : \"Justin\", \"Race\" : \"European\"}");

		System.out.println(jsonObj.getKeyArray()[1]);

		System.out.println("Name");
		System.out.println(jsonObj.get("Name").getValue());
		System.out.println(jsonObj.get("Race").getValue());

		System.out.println();
		System.out.println(jsonObj.encode());

		System.out.println();

		JSONObject jsonObj2 = new JSONObject();

		jsonObj2.put(new JSONElement(new JSONString("Male"), new JSONBoolean(true)));

		String jsonCode = jsonObj2.encode();

		System.out.println(jsonCode);

		JSONObject jsonObj3 = JSONObject.parse(jsonCode);

		System.out.println(jsonObj3);

		System.out.println();

		JSONNumber jsonObj4 = JSONNumber.parse("3.14");

		System.out.println(jsonObj4.encode());

		//JSONArray json4 = JSONArray.parse("[1, 2, 3, 4, 5]");
		//System.out.println(json4.encode());
	}
} 