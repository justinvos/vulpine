package github.vulpine.json;

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
