package com.github.vulpinejson;


public abstract class JSONType
{
	/**
	* The base method for encoding Java JSON objects into JSON strings.
	*
	* @return	A String in JSON format.
	*/
	public abstract String encode();
	
	public abstract Object get();


	public String toString()
	{
		return this.encode();
	}
}