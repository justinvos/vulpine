package com.github.vulpinejson;

import java.util.ArrayList;

public class JSONObject extends JSONType
{
	private ArrayList<VulpineElement> elementList;

	public JSONObject()
	{
		this.elementList = new ArrayList<VulpineElement>();
	}

	public JSONObject(ArrayList<VulpineElement> elementList)
	{
		this.elementList = elementList;
	}

	public ArrayList<VulpineElement> get()
	{
		return elementList;
	}

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

	public VulpineElement get(String key)
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

	public boolean contains(VulpineElement element)
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

	public void put(VulpineElement element)
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

	public static JSONObject parse(String value)
	{
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
					VulpineElement element = VulpineElement.parse(value.substring(++parsedIndex, i));
					jsonObj.put(element);
					parsedIndex = i;
				}

				bracketLevel--;
			}
			else if(value.charAt(i) == ',')
			{
				if(bracketLevel == 1)
				{
					VulpineElement element = VulpineElement.parse(value.substring(++parsedIndex, i));
					jsonObj.put(element);
					parsedIndex = i;
				}
			}
		}

		return jsonObj;
	}
}