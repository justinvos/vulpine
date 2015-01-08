package com.github.vulpinejson;

import java.util.HashMap;
import java.util.Set;

public class JSONElement
{
	private JSONString key;
	private JSONType value;

	protected JSONElement(JSONString key, JSONType value)
	{
		this.key = key;
		this.value = value;
	}


	/**
	* Gets the key of this JSON Element.
	*
	* @return	the JSONString key of this JSON Element
	*/
	protected JSONString getKey()
	{
		return this.key;
	}


	/**
	* Gets the value of this JSON Element.
	*
	* @return	the JSONType value of this JSON Element
	*/
	protected JSONType getValue()
	{
		return this.value;
	}


	/**
	* Encodes the JSON Element into JSON string format.
	*
	* @return	a JSON string representation of the JSONElement object
	*/
	public String encode()
	{
		return key.encode() + " : " + value.encode();
	}


	/**
	* Parses JSON string format into a JSONElement.
	*
	* @return	a JSON string representation of the JSONElement object
	* @throws	InvalidJSONException if the seperator of the JSON element is missing
	*/
	public static JSONElement parse(String jsonString)
	{
		if(jsonString.contains(":"))
		{
			String[] components = jsonString.split(":", 2);

			String key = components[0].trim();
			String value = components[1].trim();

			JSONString keyJson = JSONString.parse(key);

			JSONType valueJson = JSONType.parse(value);

			return new JSONElement(keyJson, valueJson);
		}
		else
		{
			throw new InvalidJSONException("Missing seperator in JSON element");
		}
	}
}