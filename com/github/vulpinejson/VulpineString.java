package com.github.vulpinejson;

import java.util.HashMap;
import java.util.Set;

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