package com.github.vulpinejson;

public class VulpineString extends VulpineElement
{
	public VulpineString(String key, String value)
	{
		super(key, value);
	}

	public String encode()
	{
		return "\"" + getKey() + "\" : \"" + getValue() + "\"";
	}

}