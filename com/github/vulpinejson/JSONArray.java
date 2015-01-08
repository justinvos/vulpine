package com.github.vulpinejson;

import java.util.ArrayList;

public class JSONArray extends JSONType
{
	public ArrayList<JSONType> valueList;

	public JSONArray()
	{
		valueList = new ArrayList<JSONType>();
	}

	public JSONArray(ArrayList<JSONType> valueList)
	{
		this.valueList = valueList;
	}

	public ArrayList<JSONType> get()
	{
		return this.valueList;
	}

	public void set(ArrayList<JSONType> valueList)
	{
		this.valueList = valueList;
	}

	public JSONType get(int index)
	{
		return this.valueList.get(index);
	}

	public void add(JSONType value)
	{
		valueList.add(value);
	}

	public boolean contains(JSONType value)
	{
		for(int i = 0; i < valueList.size(); i++)
		{
			if(valueList.get(i).equals(value))
			{
				return true;
			}
		}
		return false;
	}


	/**
	* Encodes the JSON Array into JSON string format.
	*
	* @return	a JSON string representation of the JSONArray object
	*/
	public String encode()
	{
		String jsonStr = "[";

		for(int i = 0; i < valueList.size(); i++)
		{
			jsonStr = jsonStr + valueList.get(i).encode() + ", ";
		}

		if(jsonStr.length() > 1)
		{
			jsonStr = jsonStr.substring(0, jsonStr.length() - 2);
		}
		

		return jsonStr + "]";
	}


	/**
	* Parses a JSON string into a JSON Array
	*
	* @return	a decoded JSONArray object of the given JSON string
	*/
	public static JSONArray parse(String json)
	{
		JSONArray jsonArr = new JSONArray();

		int bracketLevel = 0;
		int parsedIndex = 0;

		for(int i = 0; i < json.length(); i++)
		{
			if(json.charAt(i) == '{')
			{
				bracketLevel++;
			}
			else if(json.charAt(i) == '}')
			{
				

				if(bracketLevel == 1)
				{
					JSONType value = JSONType.parse(json.substring(++parsedIndex, i));
					jsonArr.add(value);
					parsedIndex = i;
				}

				bracketLevel--;
			}
			else if(json.charAt(i) == ',')
			{
				if(bracketLevel == 1)
				{
					JSONType value = JSONType.parse(json.substring(++parsedIndex, i));
					jsonArr.add(value);
					parsedIndex = i;
				}
			}
		}

		return jsonArr;
	}

	public static boolean isJSONArray(String json)
	{
		json = json.trim();

		return (json.startsWith("[") && json.endsWith("]"));
	}
}