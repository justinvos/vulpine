package github.vulpine.json;

public class JSONBoolean extends JSONType
{
	public boolean value;

	public JSONBoolean(boolean value)
	{
		this.value = value;
	}

	public void set(boolean value)
	{
		this.value = value;
	}

	public Boolean get()
	{
		return this.value;
	}

	/**
	* Encodes the JSON Boolean into JSON string format.
	*
	* @return	a JSON string representation of the JSONBoolean object
	*/
	public String encode()
	{
		if(this.value)
		{
			return "true";
		}

		return "false";
	}

	/**
	* Parses a JSON string into a JSON Boolean
	*
	* @return	a decoded JSONBoolean object of the given JSON string
	*/
	public static JSONBoolean parse(String json)
	{
		json = json.trim();
		if(json.equals("true"))
		{
			return new JSONBoolean(true);
		}
		else if(json.equals("false"))
		{
			return new JSONBoolean(false);
		}

		throw new InvalidJSONException("Invalid JSON for a Boolean type");
	}

	public static boolean isJSONBoolean(String json)
	{
		json = json.trim();

		return (json.equals("true") || json.equals("false"));
	}
}
