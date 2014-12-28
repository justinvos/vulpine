package com.github.vulpinejson;

import java.util.HashMap;
import java.util.Set;

public class VulpineElement
{
	private JSONString key;
	private JSONType value;

	protected VulpineElement(JSONString key, JSONType value)
	{
		this.key = key;
		this.value = value;
	}

	protected JSONString getKey()
	{
		return this.key;
	}

	protected JSONType getValue()
	{
		return this.value;
	}

	public String encode()
	{
		return key.encode() + " : " + value.encode();
	}

	public static VulpineElement parse(String jsonString)
	{
		if(jsonString.contains(":"))
		{
			String[] components = jsonString.split(":", 2);

			String key = components[0].trim();
			String value = components[1].trim();

			JSONString keyJson = JSONString.parse(key);

			if(JSONString.isJSONString(value))
			{
				return new VulpineElement(keyJson, JSONString.parse(value));
			}
			else if(VulpineJSON.isClass(value))
			{
				return new VulpineElement(keyJson, JSONObject.parse(value));
			}
			else
			{
				throw new RuntimeException("Unknown JSON value.");
			}
		}
		else
		{
			throw new RuntimeException("No ':' seperator in JSON line.");
		}
	}
}