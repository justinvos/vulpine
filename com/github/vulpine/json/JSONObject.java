package com.github.vulpine.json;

import java.util.ArrayList;

public class JSONObject extends JSONType
{
	private ArrayList<JSONElement> elementList;

	public JSONObject()
	{
		this.elementList = new ArrayList<JSONElement>();
	}

	public JSONObject(ArrayList<JSONElement> elementList)
	{
		this.elementList = elementList;
	}

	public ArrayList<JSONElement> get()
	{
		return elementList;
	}

	public JSONElement get(String key)
	{
		for(int i = 0; i < elementList.size(); i++)
		{
			if(elementList.get(i).getKey().get().equals(key))
			{
				return elementList.get(i);
			}
		}

		return null;
	}

	public boolean contains(JSONElement element)
	{
		for(int i = 0; i < elementList.size(); i++)
		{
			if(elementList.get(i).getKey().get().equals(element.getKey().get()))
			{
				return true;
			}
		}
		return false;
	}

	public void put(JSONElement element)
	{
		if(!contains(element))
		{
			elementList.add(element);
		}
	}

	public String[] getKeyArray()
	{
		String[] strArray = new String[elementList.size()];

		for(int i = 0; i < elementList.size(); i++)
		{
			strArray[i] = elementList.get(i).getKey().get();
		}
		return strArray;
	}

	/**
	* Encodes the JSON Object into JSON string format.
	*
	* @return	a JSON string representation of the JSONObject object
	*/
	public String encode()
	{
		String jsonStr = "{";

		for(int i = 0; i < elementList.size(); i++)
		{
			jsonStr = jsonStr + elementList.get(i).encode() + ", ";
		}

		if(jsonStr.length() > 1)
		{
			jsonStr = jsonStr.substring(0, jsonStr.length() - 2);
		}


		return jsonStr + "}";
	}

	/**
	* Parses JSON string format into a JSON Object.
	*
	* @return	a decoded JSONObject object of the given JSON string
	* @throws	InvalidJSONException if the JSON Object is in the incorrect format
	*/
	public static JSONObject parse(String value)
	{
		if(!JSONObject.isJSONObject(value))
		{
			throw new InvalidJSONException("Invalid JSONObject format");
		}

		JSONObject jsonObj = new JSONObject();

		int bracketLevel = 0;
		int parsedIndex = 0;

		for(int i = 0; i < value.length(); i++)
		{
			if(value.charAt(i) == '{')
			{
				bracketLevel++;
			}
			else if(value.charAt(i) == '}')
			{


				if(bracketLevel == 1)
				{
					JSONElement element = JSONElement.parse(value.substring(++parsedIndex, i));
					jsonObj.put(element);
					parsedIndex = i;
				}

				bracketLevel--;
			}
			else if(value.charAt(i) == ',')
			{
				if(bracketLevel == 1)
				{
					JSONElement element = JSONElement.parse(value.substring(++parsedIndex, i));
					jsonObj.put(element);
					parsedIndex = i;
				}
			}
		}

		return jsonObj;
	}

	public static boolean isJSONObject(String json)
	{
		json = json.trim();

		return (json.startsWith("{") && json.endsWith("}"));
	}
}
