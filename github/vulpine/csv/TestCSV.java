package github.vulpine.csv;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

public class TestCSV {
	public static void main(String[] args) {
		System.out.println("CSV Test");

		CSV csv = new CSV();
		test("CSV #1a", "", csv.toString());

		csv = CSV.Parse("1,2\n3,4");
		test("CSV #2a", "1,2\n3,4", csv.toString());

		try {
			File file = new File("./github/vulpine/csv/test3.csv");

			csv = CSV.Parse(file);
			test("CSV #3a", "1,2,3\n4,5,6", csv.toString());

			csv.addLine("7,8,9");
			test("CSV #3b", "1,2,3\n4,5,6\n7,8,9", csv.toString());
			csv.write(file);

			csv = CSV.Parse(file);
			test("CSV #3c", "1,2,3\n4,5,6\n7,8,9", csv.toString());

			csv.removeLine(2);
			test("CSV #3d", "1,2,3\n4,5,6", csv.toString());
			csv.write(file);

			file = new File("./github/vulpine/csv/test4.csv");
			file.createNewFile();

			csv = CSV.Parse(file);
			test("CSV #4a", "", csv.toString());

			file.delete();

		} catch(FileNotFoundException e) {
		} catch(IOException e) {
		}
	}

	public static void test(String testName, String expectedOutput, String actualOutput)
	{
		if(expectedOutput.equals(actualOutput))
		{
			System.out.println("Test " + testName + " was successful.");
		}
		else
		{
			System.out.println("Test " + testName + " failed.");
			System.out.println();
			System.out.println("Expected Output: ");
			System.out.println("  \"" + expectedOutput.toString() + "\"");
			System.out.println("Actual Output: ");
			System.out.println("  \"" + actualOutput.toString() + "\"");
			System.out.println();
		}
	}
}
