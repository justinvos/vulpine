package com.github.vulpinejson;

import java.util.HashMap;
import java.util.Set;

public class VulpineElement
{

	private String key;
	private Object value;

	protected VulpineElement(String key, Object value)
	{
		this.key = key;
		this.value = value;
	}

	protected String getKey()
	{
		return this.key;
	}

	protected Object getValue()
	{
		return this.value;
	}

	public String encode()
	{
		return "\"" + key + "\" : " + value.toString();
	}
}