package com.github.vulpinejson;


public abstract class JSONType
{
	public abstract String encode();
	public abstract Object get();
	public String toString()
	{
		return this.encode();
	}
}