package com.github.vulpinejson;


public class JSONString extends JSONType
{
	private String value;

	public JSONString()
	{
		this.value = "";
	}

	public JSONString(String value)
	{
		this.value = value;
	}

	public void set(String value)
	{
		this.value = value;
	}

	public String get()
	{
		return this.value;
	}

	public String encode()
	{
		return "\"" + this.value + "\"";
	}

	public static JSONString parse(String jsonStr)
	{
		String value = jsonStr.trim();

		if(JSONString.isJSONString(jsonStr))
		{
			value = value.substring(1, value.length() - 1);
			return new JSONString(value);
		}

		throw new RuntimeException("Invalid Format");
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

	public static boolean isJSONString(String str)
	{
		return (str.startsWith("\"") && str.endsWith("\""));
	}
}