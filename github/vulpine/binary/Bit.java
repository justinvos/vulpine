package github.vulpine.binary;

/**
* Class Bit represents a Bit, with of value 0 or 1.
*/
public class Bit
{
  private boolean value;

  /**
  * Constructs a Bit object using the boolean value. The boolean value of true is mapped to 1 and the boolean value of false mapped to 0.
  *
  * @param	A byte value.
  */
  public Bit(boolean value)
  {
    this.value = value;
  }


  /**
  * Constructs a Bit object using a string of one binary digit ("0" or "1").
  *
  * @param A string of one binary digit ("0" or "1").
  */
  public Bit(String value)
  {
    if(value.length() == 1)
    {
      if(value.equals("0"))
      {
        this.value = false;
      }
      else if (value.equals("1"))
      {
        this.value = true;
      }
    }
    else
    {
      throw new IllegalArgumentException("The given binary string is longer than one digit.");
    }
  }

  /**
  * Creates a string representation of the value of this Bit. Will have the value of 0 or 1.
  *
  * @return	a string representation of this Bit object.
  */
  public String toString()
  {
    return value ? "1" : "0";
  }
}
