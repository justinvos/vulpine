package github.vulpine.xml;

/**
* Class InvalidXMLException is thrown to indicate that the parsing of a XML data format encountered an error.
*/
public class InvalidXMLException extends RuntimeException
{
	/**
	* Constructs an InvalidXMLException object without using any parameters, without any error message/description.
	*
	*/
	public InvalidXMLException()
	{
	}

	/**
	* Constructs an InvalidXMLException object using a single String parameter.
	*
	* @param	A String value representing a description of the error.
	*/
	public InvalidXMLException(String message)
	{
		super(message);
	}
}
