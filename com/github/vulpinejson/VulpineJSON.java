package com.github.vulpinejson;

public class VulpineJSON
{

	private static VulpineElement parseLine(String jsonString)
	{

		if(jsonString.contains(":"))
		{
			String[] components = jsonString.split(":", 2);

			String key = components[0].trim();
			String value = components[1].trim();

			if(isString(value))
			{
				return new VulpineString(trimQuotes(key), trimQuotes(value));
			}
			else if(isClass(value))
			{
				return VulpineObject.parse(jsonString);
			}
		}
		else
		{
			throw new RuntimeException("No ':' seperator in JSON line.");
		}

		return null;
	}

	protected static VulpineClass parseClass(String value)
	{
		VulpineClass vulpineClass = new VulpineClass();

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
					VulpineElement element = parseLine(value.substring(++parsedIndex, i));
					vulpineClass.put(element);
					parsedIndex = i;
				}

				bracketLevel--;
			}
			else if(value.charAt(i) == ',')
			{
				if(bracketLevel == 1)
				{
					VulpineElement element = parseLine(value.substring(++parsedIndex, i));
					vulpineClass.put(element);
					parsedIndex = i;
				}
			}
		}

		return vulpineClass;
	}

	private static boolean isString(String str)
	{
		return (str.startsWith("\"") && str.endsWith("\""));
	}

	private static boolean isClass(String str)
	{
		return (str.startsWith("{") && str.endsWith("}"));
	}

	private static String trimQuotes(String str)
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

	public static void main(String[] args)
	{
		VulpineElement str = VulpineJSON.parseLine("\"Name\" : \"Justin\" ");

		VulpineClass vClass = VulpineClass.parse("{\"Name\" : \"Justin\", \"Race\" : \"European\"}");

		System.out.println(vClass.getKeyArray()[1]);

		System.out.println("Name");
		System.out.println(vClass.get("Name").getValue());
		System.out.println(vClass.get("Race").getValue());

		System.out.println();
		System.out.println(vClass.encode());
	}
}