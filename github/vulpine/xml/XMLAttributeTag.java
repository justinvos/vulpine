package github.vulpine.xml;

import java.util.HashMap;

public class XMLAttributeTag extends XMLTag
{
  private HashMap<String, Object> attributes;

  public XMLAttributeTag(String name, HashMap<String, Object> attributes)
  {
    super(name);
  }

  public XMLAttributeTag(String name)
  {
    super(name);
    this.attributes = new HashMap<String, Object>();
  }

  public String toString()
  {
    String text = "<";

    text = text + getName() + " ";

    String[] keyArray = new String[0];

    for(int i = 0; i < attributes.size(); i++)
    {
      text = text + attributes;
      text = text + " ";
    }

    return text;
  }
}
