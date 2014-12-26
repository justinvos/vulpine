package com.github.vulpinejson;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;
import java.util.Stack;

public class VulpineJSON
{
	private String jsonString;

	public VulpineJSON(String jsonString)
	{
		this.jsonString = jsonString;
	}

	public static HashMap<String, Object> parseLine(String jsonString)
	{
		HashMap<String, Object> data = new HashMap<String, Object>();

		if(jsonString.contains(":"))
		{
			String[] components = jsonString.split(":", 2);

			String key = components[0].trim();
			String value = components[1].trim();

			if(isString(value))
			{
				data.put(trimQuotes(key), trimQuotes(value));

				return data;
			}
			else if(isHashMap(value))
			{
				data.put(trimQuotes(key), parseHashMap(trimQuotes(value)));

				return data;
			}
		}
		else
		{
			throw new RuntimeException("No ':' seperator in JSON line.");
		}

		return data;
	}

	public static HashMap<String, Object> parseHashMap(String value)
	{

		HashMap<String, Object> data = new HashMap<String, Object>();

		int bracketLevel = 0;
		int parsedIndex = 0;

		for(int i = 0; i < value.length(); i++)
		{
			if(value.charAt(i) == '{')
			{
				bracketLevel++;
			}
			else if(value.charAt(i) == '}')
			{
				

				if(bracketLevel == 1)
				{
					String[] empty = new String[1];
					HashMap<String, Object> vulpineObj = parseLine(value.substring(++parsedIndex, i));
					data.put(vulpineObj.keySet().toArray(empty)[0], vulpineObj.get(vulpineObj.keySet().toArray(empty)[0]));
					parsedIndex = i;
				}

				bracketLevel--;
			}
			else if(value.charAt(i) == ',')
			{
				if(bracketLevel == 1)
				{
					String[] empty = new String[1];
					HashMap<String, Object> vulpineObj = parseLine(value.substring(++parsedIndex, i));
					data.put(vulpineObj.keySet().toArray(empty)[0], vulpineObj.get(vulpineObj.keySet().toArray(empty)[0]));
					parsedIndex = i;
				}
			}
		}

		return data;
	}

	public static boolean isString(String str)
	{
		return (str.startsWith("\"") && str.endsWith("\""));
	}

	public static boolean isHashMap(String str)
	{
		return (str.startsWith("{") && str.endsWith("}"));
	}

	public static String trimQuotes(String str)
	{
		str.trim();

		if(str.startsWith("\"") && str.endsWith("\""))
		{
			str = str.substring(1, str.length() - 1);
		}
		return str;
	}

	/*

	The main method is used purely for debuging test cases.

	--- Do not use the main method in your implementation. --

	*/
	

	public static boolean debug = false;

	public static void main(String[] args)
	{
		HashMap<String, Object> str = VulpineJSON.parseLine("\"Name\" : \"Justin\" ");

		HashMap<String, Object> hashMap = VulpineJSON.parseHashMap("{\"Name\" : \"Justin\", \"Race\" : \"European \"}");

		//VulpineHashMap map = new VulpineHashMap("MyMap", hashMap);

		System.out.println(hashMap.keySet());

		System.out.println("Name");
		System.out.println(hashMap.get("Name"));
		System.out.println(hashMap.get("Race"));

		

		/*if(args.length > 0)
		{

			if(args.length == 2)
			{
				if(args[1].equals("debug"))
				{
					VulpineJSON.debug = true;
					System.out.println("DEBUG");
				}
			}

			log("VulpineJSON");

			
			log(args[0]);

			//VulpineJSON vulpine = new VulpineJSON(new File(args[0]));
			//VulpineJSON vulpine = new VulpineJSON("{name:justin}");


			log("JSON STR: " + vulpine.jsonString);

			log("Loaded");

			log(vulpine.get("name"));

			//HashMap<String, Object> address = (HashMap<String, Object>)vulpine.get("address");

			//log(address.get("city"));
	
		}
		*/
	}
}