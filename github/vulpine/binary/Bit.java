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
  * Creates a string representation of the value of this Bit. Will have the value of 0 or 1.
  *
  * @return	a string representation of this Bit object.
  */
  public String toString()
  {
    return value ? "1" : "0";
  }
}
