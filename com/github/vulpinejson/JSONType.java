package com.github.vulpinejson;


public abstract class JSONType
{
	/**
	* The base method for encoding Java JSON objects into JSON strings.
	*
	* @return	a String in JSON format.
	*/
	public abstract String encode();
	
	/**
	* The base method for returning an instance of the content in the JSONType.
	*
	* @return	an instance of the content in the JSONType
	*/
	public abstract Object get();


	/**
	* The base method for returning the JSON string representation of the JSONType object.
	*
	* @return	a JSON string representation of the JSONType object
	*/
	public String toString()
	{
		return this.encode();
	}


	/**
	* Parses a JSON string into a JSONType
	*
	* @return	a JSONType object of the JSON string representation
	*/
	public static JSONType parse(String value)
	{
		if(JSONString.isJSONString(value))
		{
			return JSONString.parse(value);
		}
		else if(JSONBoolean.isJSONBoolean(value))
		{
			return JSONBoolean.parse(value);
		}
		else if(JSONArray.isJSONArray(value))
		{
			return JSONArray.parse(value);
		}
		else if(JSONObject.isJSONObject(value))
		{
			return JSONObject.parse(value);
		}
		else if(JSONNull.isJSONNull(value))
		{
			return JSONNull.parse(value);
		}
		else
		{
			throw new InvalidJSONException("Unknown or incorrect JSON type");
		}
	}
}