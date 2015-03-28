package github.vulpine.binary;

public class Octet
{
  private Bit[] bitArray;

  public Octet(Bit[] bitArray)
  {
    if(bitArray.length != 8)
    {
      throw new IllegalArgumentException("Bit Array is not of length 8.");
    }
    this.bitArray = bitArray;
  }

  public Octet(byte value)
  {
    bitArray = new Bit[8];
    for(int i = 0; i < 8; i++)
    {
      if(value / Math.pow(2, 7 - i) >= 1)
      {
        bitArray[i] = new Bit(true);
        value = (byte)(value - Math.pow(2, 7 - i));
      }
      else
      {
        bitArray[i] = new Bit(false);
      }

    }
  }

  public String toString()
  {
    String str = "";
    for(int i = 0; i < 8; i++)
    {
      str = str + bitArray[i];
    }
    return str;
  }
}
