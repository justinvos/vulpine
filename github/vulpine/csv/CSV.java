package github.vulpine.csv;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

public class CSV {
	public static String LINE_SEPARATOR = "\n";
	public static String VALUE_SEPARATOR = ",";

	private ArrayList<ArrayList<String>> lines;

	public CSV() {
		this.lines = new ArrayList<ArrayList<String>>();
	}

	private static ArrayList<String> ParseLine(String[] values) {
		ArrayList<String> output = new ArrayList<String>();
		for(int v = 0; v < values.length; v++) {
			output.add(values[v]);
		}
		return output;
	}

	private static ArrayList<String> ParseLine(String values) {
		return ParseLine(values.split(CSV.VALUE_SEPARATOR));
	}

	public static CSV Parse(String raw) {
		CSV csv = new CSV();

		String[] lines = raw.split(CSV.LINE_SEPARATOR);
		for(int l = 0; l < lines.length; l++) {
			csv.addLine(ParseLine(lines[l]));
		}

		return csv;
	}

	public static CSV Parse(File file) throws FileNotFoundException {
		String raw = "";
		Scanner in = new Scanner(file);
		while(in.hasNextLine()) {
			raw += in.nextLine();
			if(in.hasNextLine()) {
				raw += CSV.LINE_SEPARATOR;
			}
		}
		in.close();
		return CSV.Parse(raw);
	}

	public void addLine() {
		lines.add(new ArrayList<String>());
	}

	public void addLine(ArrayList<String> values) {
		lines.add(values);
	}

	public void addLine(String[] values) {
		addLine(ParseLine(values));
	}

	public void addLine(String values) {
		addLine(ParseLine(values));
	}

	public void addValue(int l, String value) {
		lines.get(l).add(value);
	}

	public void removeLine(int l) {
		lines.remove(l);
	}

	public void removeValue(int l, int v) {
		lines.get(l).remove(v);
	}

	public void setLine(int l, ArrayList<String> values) {
		lines.set(l, values);
	}

	public void setLine(int l, String[] values) {
		setLine(l, ParseLine(values));
	}

	public void setLine(int l, String values) {
		setLine(l, ParseLine(values));
	}

	public void setValue(int l, int v, String value) {
		lines.get(l).set(v, value);
	}

	public String toString() {
		String output = "";
		for(Iterator<ArrayList<String>> linesIterator = lines.iterator(); linesIterator.hasNext(); ) {
			ArrayList<String> line = linesIterator.next();
			for(Iterator<String> valuesIterator = line.iterator(); valuesIterator.hasNext(); ) {
				String value = valuesIterator.next();
				output += value;
				if(valuesIterator.hasNext()) {
					output += CSV.VALUE_SEPARATOR;
				}
			}
			if(linesIterator.hasNext()) {
				output += LINE_SEPARATOR;
			}
		}
		return output;
	}

	public void write(File file) throws FileNotFoundException {
		PrintWriter out = new PrintWriter(file);
		out.print(this.toString());
		out.close();
	}
}
