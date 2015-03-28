package github.vulpine;

import github.vulpine.binary.Bit;
import github.vulpine.binary.Octet;

import github.vulpine.json.JSONBoolean;
import github.vulpine.json.JSONElement;
import github.vulpine.json.JSONNumber;
import github.vulpine.json.JSONObject;
import github.vulpine.json.JSONString;
import github.vulpine.json.VulpineWriter;
import github.vulpine.json.VulpineReader;

import github.vulpine.xml.XMLTag;
import github.vulpine.xml.XMLAttributeTag;

import java.io.File;

public class VulpineTest
{
	/*

	The main method is used purely for debuging test cases.

	--- Do not use the main method in your implementation. --

	*/

	public static void main(String[] args)
	{
		Bit bit = new Bit(true);

		test("BIN #1.1", "1", bit.toString());

		Octet octet = new Octet((byte)28);

		test("BIN #1.2", "00011100", octet.toString());

		System.out.println();


		JSONElement str = JSONElement.parse("\"Name\" : \"Justin\" ");

		JSONObject jsonObj = JSONObject.parse("{\"Name\" : \"Justin\", \"Race\" : \"Kiwi\"}");

		test("JSON #1.1", "Race", jsonObj.getKeyArray()[1]);
		test("JSON #1.2", "Justin", jsonObj.get("Name").getValue().toString());
		test("JSON #1.3", "Kiwi", jsonObj.get("Race").getValue().toString());
		System.out.println();
		test("JSON #2.1", "{\"Name\" : \"Justin\", \"Race\" : \"Kiwi\"}", jsonObj.encode());
		System.out.println();

		JSONObject jsonObj2 = new JSONObject();

		jsonObj2.put(new JSONElement(new JSONString("Male"), new JSONBoolean(true)));

		String jsonCode = jsonObj2.encode();

		test("JSON #3.1", "{\"Male\" : true}", jsonCode);

		/*JSONObject jsonObj3 = JSONObject.parse(jsonCode);

		test("#3.2", "{\"Male\" : true}", jsonObj3);

		System.out.println();

		JSONNumber jsonObj4 = JSONNumber.parse("3.14");

		test("#4.1", "3.14", jsonObj4.encode());

		System.out.println();

		VulpineWriter writer = new VulpineWriter(new File("debug\\Company.json"));

		writer.beginObject();

		writer.printKey("Member");
		writer.printType(jsonObj);

		writer.printKey("Number");
		writer.printType(jsonObj4);

		writer.endObject();

		writer.flush();

		VulpineReader reader = new VulpineReader(new File("debug\\Company.json"));

		JSONObject jsonObj5 = reader.read();

		System.out.println(jsonObj5.encode());

		VulpineWriter writer2 = new VulpineWriter(new File("debug\\Company2.json"));

		writer2.printType(jsonObj5);
		writer2.flush();

		//JSONArray json4 = JSONArray.parse("[1, 2, 3, 4, 5]");
		//System.out.println(json4.encode());
		*/
		XMLTag tag1 = new XMLTag("p");
		test("XML #1.1", "<p>", tag1.toString());

		XMLTag tag2 = XMLTag.parse("<a href=\"google.com\">");
		test("XML #2.1", "<a href=\"google.com\">", tag2.toString());

		XMLAttributeTag tag3 = new XMLAttributeTag("a");
		test("XML #3.1", "<a>", tag3.toString());
	}

	public static void test(String testName, Object expectedOutput, Object actualOutput)
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
