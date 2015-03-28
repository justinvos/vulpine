package github.vulpine.json;

/**
* Class InvalidJSONException is thrown to indicate that the parsing of a JSON data format encountered an error.
*/
public class InvalidJSONException extends RuntimeException
{
	/**
	* Constructs an InvalidJSONException object without using any parameters, without any error message/description.
	*
	*/
	public InvalidJSONException()
	{
	}

	/**
	* Constructs an InvalidJSONException object using a single String parameter.
	*
	* @param	A String value representing a description of the error.
	*/
	public InvalidJSONException(String message)
	{
		super(message);
	}
}
