package com.github.vulpine.json;

public class JSONNull extends JSONType
{
	public JSONNull()
	{
	}

	public Object get()
	{
		return null;
	}

	/**
	* Encodes the JSON Null into JSON string format.
	*
	* @return	a JSON string representation of the JSONNull object
	*/
	public String encode()
	{
		return "null";
	}

	/**
	* Parses a JSON string into a JSON Null
	*
	* @return	a decoded JSONNull object of the given JSON string
	*/
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
