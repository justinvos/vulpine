package com.github.vulpine.json;


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

	/**
	* Encodes the JSON String into JSON string format.
	*
	* @return	a JSON string representation of the JSONString object
	*/
	public String encode()
	{
		return "\"" + this.value + "\"";
	}

	/**
	* Parses a JSON string into a JSON String
	*
	* @return	a decoded JSONString object of the given JSON string
	*/
	public static JSONString parse(String jsonStr)
	{
		if(!JSONString.isJSONString(jsonStr))
		{
			throw new InvalidJSONException("Invalid JSONString format");
		}

		String value = jsonStr.trim();

		value = value.substring(1, value.length() - 1);
		return new JSONString(value);

	}

	public static String trimQuotes(String str)
	{
		str = str.trim();

		if(isJSONString(str))
		{
			str = str.substring(1, str.length() - 1);
		}
		return str;
	}

	public static boolean isJSONString(String str)
	{
		str = str.trim();
		return (str.startsWith("\"") && str.endsWith("\""));
	}
}
