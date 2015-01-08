package com.github.vulpinejson;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.Writer;

public class VulpineWriter
{
	private boolean isFirstElement;
	private PrintWriter out;

	public VulpineWriter(Writer writer)
	{
		this.out = new PrintWriter(writer);
		this.isFirstElement = true;
	}

	public VulpineWriter(File file)
	{
		try
		{
			this.out = new PrintWriter(file);
		}
		catch(FileNotFoundException fileNotFoundException)
		{
			try
			{
				file.createNewFile();
			}
			catch(Exception ioException)
			{

			}
		}
		this.isFirstElement = true;
	}

	public void flush()
	{
		out.flush();
	}

	public void printType(JSONType jsonType)
	{
		out.print(jsonType.encode());

		this.isFirstElement = false;
	}

	public void printElement(JSONElement jsonElement)
	{
		if(!this.isFirstElement)
		{
			out.println(",");
		}

		out.print(jsonElement.encode());
		
		this.isFirstElement = false;
	}

	public void beginObject()
	{
		out.println("{");
		this.isFirstElement = true;
	}

	public void endObject()
	{
		out.println();
		out.print("}");
		this.isFirstElement = false;
	}

	public void beginArray()
	{
		out.println("[");
		this.isFirstElement = true;
	}

	public void endArray()
	{
		out.println();
		out.print("]");
		this.isFirstElement = false;
	}

	public void printKey(JSONString jsonString)
	{
		if(!this.isFirstElement)
		{
			out.println(",");
		}

		out.print(jsonString.encode());
		out.print(" : ");
	}

	public void printKey(String key)
	{
		this.printKey(new JSONString(key));
	}

	public void printNumber(double value)
	{
		this.printType(new JSONNumber(value));
	}

	public void printString(String value)
	{
		this.printType(new JSONString(value));
	}

	public void printBoolean(boolean value)
	{
		this.printType(new JSONBoolean(value));
	}

	public void printNull()
	{
		this.printType(new JSONNull());
	}
}