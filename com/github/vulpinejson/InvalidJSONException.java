package com.github.vulpinejson;

public class InvalidJSONException extends RuntimeException
{
	public InvalidJSONException()
	{

	}

	public InvalidJSONException(String message)
	{
		super(message);
	}
}