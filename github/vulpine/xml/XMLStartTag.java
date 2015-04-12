package github.vulpine.xml;

import java.util.HashMap;

public class XMLStartTag extends XMLTag
{
  private HashMap<String, Object> attributeMap;

  public XMLStartTag(String name)
  {
    this(name, new HashMap<String, Object>());
  }

  public XMLStartTag(String name, HashMap<String, Object> attributeMap)
  {
    super(name);
    this.attributeMap = attributeMap;
  }

  public static XMLStartTag parse(String tag)
  {
    if(tag.startsWith("<") && tag.endsWith(">"))
    {
      return null;
    }
    else
    {
      throw new InvalidXMLException("Tag does not start and end with angle brackets (</>)");
    }
  }

  public Object valueOf(String key)
  {
    return attributeMap.get(key);
  }

  public String[] getKeyArray()
  {
    String[] arr0 = new String[0];
    return attributeMap.keySet().toArray(arr0);
  }

  public String toString()
  {
    String text = "<" + getName();

    String[] keyArray = getKeyArray();

    for(int i = 0; i < keyArray.length; i++)
    {
      text = text + " " + keyArray[i] + "=\"" + valueOf(keyArray[i]) + "\"";
    }

    return text + ">";
  }
}
