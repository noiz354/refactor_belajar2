package norman.template;

import java.io.BufferedWriter;
import java.io.IOException;

public class TemplateUtility {
	/**
	 * Method to print to file and to console
	 * @param bufferedWriter prefere not null
	 * @param str string default
	 * @param endWithNewLine true if with new line, false if without new line.
	 * @param printToConsole true if still need to print to console, false if not need to print to console.
	 */
	public static void print(BufferedWriter bufferedWriter, String str, boolean endWithNewLine, boolean printToConsole){
		if(endWithNewLine){
			str += "\n";
		}
		try {
			bufferedWriter.write(str);
			if(printToConsole)
				System.out.print(str);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Method to print to file
	 * @param bufferedWriter
	 * @param str
	 * @param endWithNewLine
	 */
	public static void print(BufferedWriter bufferedWriter, String str, boolean endWithNewLine){
		print(bufferedWriter, str, endWithNewLine, false);
	}
	
	/**
	 * Method to print to file and to console 
	 * @param bufferedWriter
	 * @param str
	 * @param endWithNewLine
	 */
	public static void printCon(BufferedWriter bufferedWriter, String str, boolean endWithNewLine){
		print(bufferedWriter, str, endWithNewLine, true);
	}

	public static void printf(BufferedWriter bufferedWriter, String format, Object[] str, boolean endWithNewLine){
		if(endWithNewLine){
			format += "\n";
		}
		String whatToPrint = String.format(format, str);
		try {
			bufferedWriter.write(whatToPrint);
			System.out.print(whatToPrint);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static void f(int a, int b) {
	    if (a == b) {
	        System.out.print(a);
	    }
	    else {
	        System.out.print(a + ",");
	        f(a+1,b);
	        System.out.print("," + a);
	    }
	}
}
