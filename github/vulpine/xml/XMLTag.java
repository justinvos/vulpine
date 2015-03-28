package github.vulpine.xml;


public class XMLTag
{
  private String name;

  public XMLTag(String name)
  {
    this.name = name;
  }

  public String getName()
  {
    return this.name;
  }

  public void setName(String name)
  {
    this.name = name;
  }

  public String toString()
  {
    return "<" + getName() + ">";
  }

  public static XMLTag parse(String tag)
  {
    if(tag.startsWith("<") && tag.endsWith(">"))
    {
      if(tag.contains(" "))
      {
        return new XMLTag(tag.substring(1, tag.indexOf(" ")));
      }
      else if(tag.contains("/"))
      {
        return new XMLTag(tag.substring(1, tag.indexOf("/")));
      }
      else
      {
        return new XMLTag(tag.substring(1, tag.indexOf(">")));
      }
    }
    else
    {
      throw new InvalidXMLException("Tag does not start and end with angle brackets (</>)");
    }
  }
}
