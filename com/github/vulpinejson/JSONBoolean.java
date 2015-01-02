package com.github.vulpinejson;

public class JSONBoolean extends JSONType
{
	public boolean value;

	public JSONBoolean(boolean value)
	{
		this.value = value;
	}

	public void set(boolean value)
	{
		this.value = value;
	}

	public Boolean get()
	{
		return this.value;
	}

	public String encode()
	{
		if(this.value)
		{
			return "true";
		}
		
		return "false";
	}

	public static JSONBoolean parse(String json)
	{
		json = json.trim();
		if(json.equals("true"))
		{
			return new JSONBoolean(true);
		}
		else if(json.equals("false"))
		{
			return new JSONBoolean(false);
		}

		throw new InvalidJSONException("Invalid JSON for a Boolean type");
	}

	public static boolean isJSONBoolean(String json)
	{
		json = json.trim();

		return (json.equals("true") || json.equals("false"));
	}
}