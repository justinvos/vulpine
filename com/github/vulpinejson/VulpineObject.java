package com.github.vulpinejson;

public class VulpineObject extends VulpineElement
{
	private VulpineClass vulpineClass;

	public VulpineObject(String key, VulpineClass vulpineClass)
	{
		super(key, vulpineClass);
		this.vulpineClass = vulpineClass;
	}

	public VulpineClass getValue()
	{
		return vulpineClass;
	}

	public String encode()
	{
		return getKey() + " : " + vulpineClass.encode();
	}

	public static VulpineObject parse(String jsonStr)
	{
		if(jsonStr.contains(":"))
		{
			String[] components = jsonStr.split(":", 2);

			String key = components[0].trim();
			String value = components[1].trim();

			return new VulpineObject(key, VulpineClass.parse(value));
		}
		else
		{
			throw new RuntimeException("No ':' seperator in JSON line.");
		}
	}

	public static boolean isVulpineObject(String jsonStr)
	{
		if(jsonStr.contains(":"))
		{
			String[] components = jsonStr.split(":", 2);

			String key = components[0].trim();
			String value = components[1].trim();

			if(value.startsWith("{") && value.endsWith("}"))
			{
				return true;
			}
		}
		
		return false;
	}
}