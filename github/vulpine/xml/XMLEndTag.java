package github.vulpine.xml;

public class XMLEndTag extends XMLTag
{

  public XMLEndTag(String name)
  {
    super(name);
  }

  public static XMLEndTag parse(String tag)
  {
    if(tag.startsWith("<") && tag.endsWith(">"))
    {
      if(tag.startsWith("</"))
      {
        if(tag.contains(" ") && tag.indexOf(" ") == 2)
        {
          throw new InvalidXMLException("Tag name connot start with a space");
        }
        else
        {
          return new XMLEndTag(tag.substring(tag.indexOf("/") + 1, Math.min(tag.indexOf(" "), tag.indexOf(">"))));
        }
      }
      else
      {
        throw new InvalidXMLException("End Tag does not start with a forward slash (/)");
      }
    }
    else
    {
      throw new InvalidXMLException("Tag does not start and end with angle brackets (</>)");
    }
  }

  public String toString()
  {
    return "</" + getName() + ">";
  }
}
