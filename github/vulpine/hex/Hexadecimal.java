package github.vulpine.hex;

/**
* Class Hexadecimal represents a Hexadecimal value of 2 digits with values ranging from 0-9 and A-F.
*/
public class Hexadecimal
{
  private String[] hexList = {"0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "A", "B", "C", "D", "E", "F"};

  private byte decimal;
  private String hex;

  /**
  * Constructs a Hexadecimal object by converting from a decimal byte value.
  *
  * @param	A byte value.
  */
  public Hexadecimal(byte value)
  {
    decimal = value;

    int second_index = value % 16;
    int first_index = (int)((value - second_index) / 16);

    hex = hexList[second_index] + hexList[first_index];
  }

  /**
  * Creates a string of 2 digits with values ranging from 0-9 and A-F, which representing this Hexadecimal.
  *
  * @return	a string representation of this Hexadecimal object.
  */
  public String toString()
  {
    return hex;
  }
}
