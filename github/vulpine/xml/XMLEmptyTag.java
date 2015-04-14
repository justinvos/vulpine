package github.vulpine.xml;

public class XMLEmptyTag extends XMLStartTag
{
  public XMLEmptyTag(String name)
  {
    this(name, new HashMap<String, Object>());
  }

  public XMLEmptyTag(String name, HashMap<String, Object> attributeMap)
  {
    super(name, attributeMap);
  }

  public static XMLEmptyTag parse(String tag)
  {
    if(tag.startsWith("<") && tag.endsWith(">"))
    {
      if(tag.endsWith(" />"))
      {
        return new XMLEmptyTag(tag.substring(1, tag.indexOf(" ")), parseAttributes(tag.substring(tag.indexOf(" "), tag.indexOf(" ") + 1)));
      }
      else
      {
        throw new InvalidXMLException("Empty Tag does not end with a space followed by a forward slash (\" /\")");
      }
    }
    else
    {
      throw new InvalidXMLException("Tag does not start and end with angle brackets (</>)");
    }
  }

  public String toString()
  {
    String text = "<" + getName();

    String[] keyArray = getKeyArray();

    for(int i = 0; i < keyArray.length; i++)
    {
      text = text + " " + keyArray[i] + "=\"" + valueOf(keyArray[i]) + "\"";
    }

    return text + " />";
  }
}
