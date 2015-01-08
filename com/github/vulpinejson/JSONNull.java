package com.github.vulpinejson;

public class JSONNull extends JSONType
{
	public JSONNull()
	{
	}

	public Object get()
	{
		return null;
	}

	public String encode()
	{
		return "null";
	}

	public static JSONNull parse(String json)
	{
		if(json.trim().equals("null"))
		{
			return new JSONNull();
		}
		throw new InvalidJSONException("Invalid JSON for a Null type");
	}

	public static boolean isJSONNull(String json)
	{
		json = json.trim();

		return json.equals("null");
	}
}