package com.github.vulpine;

import com.github.vulpine.json.JSONBoolean;
import com.github.vulpine.json.JSONElement;
import com.github.vulpine.json.JSONNumber;
import com.github.vulpine.json.JSONObject;
import com.github.vulpine.json.JSONString;
import com.github.vulpine.json.VulpineWriter;
import com.github.vulpine.json.VulpineReader;
import java.io.File;

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

		System.out.println();

		VulpineWriter writer = new VulpineWriter(new File("debug\\Company.json"));

		writer.beginObject();

		writer.printKey("Member");
		writer.printType(jsonObj);

		writer.printKey("Number");
		writer.printType(jsonObj4);

		writer.endObject();

		writer.flush();

		VulpineReader reader = new VulpineReader(new File("debug\\Company.json"));

		JSONObject jsonObj5 = reader.read();

		System.out.println(jsonObj5.encode());

		VulpineWriter writer2 = new VulpineWriter(new File("debug\\Company2.json"));

		writer2.printType(jsonObj5);
		writer2.flush();

		//JSONArray json4 = JSONArray.parse("[1, 2, 3, 4, 5]");
		//System.out.println(json4.encode());
	}
}
