package github.vulpine.binary;

/**
* Class Octet represents an array of Bits of length 8.
* @see Bit
*/
public class Octet
{
  private Bit[] bitArray;


  /**
  * Constructs a Octet object using a Bit array.
  *
  * @param	A Bit array of length 8.
  * @throws IllegalArgumentException if the Bit array is not of length 8.
  */
  public Octet(Bit[] bitArray)
  {
    if(bitArray.length != 8)
    {
      throw new IllegalArgumentException("Bit Array is not of length 8.");
    }
    this.bitArray = bitArray;
  }

  /**
  * Constructs a Octet object by converting from a decimal byte value.
  *
  * @param	A byte value.
  */
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

  /**
  * Constructs a Bit object using a string of up to 8 binary digits ("0"s or "1"s).
  *
  * @param A string of up to eight binary digit ("0"s or "1"s).
  */
  public Octet(String value)
  {
    if(value.length() <= 8)
    {
      bitArray = new Bit[8];

      for(int i = 0; i < 8; i++)
      {
        if(i < (8 - value.length()))
        {
          bitArray[i] = new Bit("0");
        }
        else
        {
          bitArray[i] = new Bit(value.substring(i, i + 1));

        }
      }
    }
    else
    {
      throw new IllegalArgumentException("The given binary string is longer than eight digits.");
    }
  }

  /**
  * Creates a string of 0 and 1 digits representing this Octet.
  *
  * @return	a string representation of this Octet object.
  */
  public String toString()
  {
    String str = "";
    for(int i = 0; i < 8; i++)
    {
      str = str + bitArray[i];
    }
    return str;
  }


  /**
  * Creates byte number representation of this Octet.
  *
  * @return	a byte representation of this Octet object.
  */
  public byte toByte()
  {
    byte sum = 0;

    for(int i = 0; i < 8; i++)
    {
      sum = sum + (bitArray[i] * Math.pow(2, i));
    }

    return sum;
  }
}
