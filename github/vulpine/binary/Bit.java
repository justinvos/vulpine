package github.vulpine.binary;

public class Bit
{
  private boolean value;

  public Bit(boolean value)
  {
    this.value = value;
  }

  public String toString()
  {
    return value ? "1" : "0";
  }
}
