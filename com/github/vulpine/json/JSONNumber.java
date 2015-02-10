package com.github.vulpine.json;

public class JSONNumber extends JSONType
{
	private double value;

	public JSONNumber(double value)
	{
		this.value = value;
	}

	public Object get()
	{
		return this.value;
	}

	/**
	* Encodes the JSON Number into JSON string format.
	*
	* @return	a JSON string representation of the JSONNumber object
	*/
	public String encode()
	{
		return new Double(value).toString();
	}

	/**
	* Parses a JSON string into a JSONNumber
	*
	* @return	a decoded JSONNumber object of the given JSON string
	*/
	public static JSONNumber parse(String json)
	{
		if(!isJSONNumber(json))
		{
			throw new InvalidJSONException("Invalid JSON for a Number type");
		}

		try
		{
			return new JSONNumber(Double.parseDouble(json));
		}
		catch(NumberFormatException exception)
		{
			throw new InvalidJSONException("Invalid JSON for a Number type");
		}
	}

	public static boolean isJSONNumber(String json)
	{
		try
		{
			double d = Double.parseDouble(json);
		}
		catch(NumberFormatException exception)
		{
			return false;
		}
		return true;
	}
}
