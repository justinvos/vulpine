package com.github.vulpinejson;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.Reader;
import java.util.Scanner;

public class VulpineReader
{
	private Scanner in;

	public VulpineReader(Reader reader)
	{
		this.in = new Scanner(reader);
	}

	public VulpineReader(File file)
	{
		try
		{
			this.in = new Scanner(file);
		}
		catch(FileNotFoundException exception)
		{
		}
	}

	public JSONObject read()
	{
		String fileContents = "";

		while(in.hasNextLine())
		{
			fileContents = fileContents + in.nextLine();
		}

		return JSONObject.parse(fileContents);
	}
}