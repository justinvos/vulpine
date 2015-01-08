package com.github.vulpinejson;

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

	public String encode()
	{
		return new Double(value).toString();
	}

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