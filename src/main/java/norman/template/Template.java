package norman.template;

import java.io.*;
import java.util.Scanner;

/**
 * some input failed runtime because of unable to detect last line
 * <p>
 * 10-02-2017, remove deprecated annotation, somehow {@link Template2}
 * not for every case.
 */
public abstract class Template implements TemplateConst {


	protected boolean debug = false;// set debug to print to console or file, change it in constructor
	String root, inputLoc, inputFileName, inputFileExt, outputLoc, outputFileName, outputFileExt;
	String compInputLoc, compOutputLoc;
	String slash;
	File inputFile, outputFile;
	Scanner in;
	BufferedWriter out;
	
	/**
	 * default constructor using eclipse input/output with passing debug flag
	 */
	public Template(String inputFileName, String outputFileName, int envType, boolean debug) {
		this(System.getProperty("user.dir"), "custom_in", inputFileName, "txt", "custom_out", outputFileName, "txt", envType, debug);
	}

	/**
	 * default constructor using eclipse input/output without changing debug flag
	 */
	public Template(String inputFileName, String outputFileName, int envType) {
		this(System.getProperty("user.dir"), "custom_in", inputFileName, "txt", "custom_out", outputFileName, "txt", envType, false);
	}

	private Template(String root, String inputLoc, String inputFileName, String inputFileExt
			, String outputLoc, String outputFileName, String outputFileExt, int envType
			, boolean debug
			){
		this.debug = debug;
		/*
		 * if you call directly this than it means custom
		 */
		if(envType==LINUX)
			slash = LINUX_SLASH;
		else
			slash = WINDOWS_SLASH;
		this.root = root;
		this.inputLoc = inputLoc;
		this.inputFileName = inputFileName;
		this.inputFileExt = inputFileExt;
		this.outputLoc = outputLoc;
		this.outputFileName = outputFileName;
		this.outputFileExt = outputFileExt;

		compInputLoc = createCompleteLocation(INPUT);
		compOutputLoc = createCompleteLocation(OUTPUT);

		runSomething();
	}

//	abstract void runSomething2();

	protected void runSomething() {
		try{
			readFile();

			FileInputStream fis = new FileInputStream(inputFile);
			System.setIn(fis);
			in = new Scanner(System.in);

			FileWriter outFw = new FileWriter(outputFile);
			out = new BufferedWriter(outFw);

			doSomething();

//			closeOutput();
		}catch(IOException ioe){
			ioe.printStackTrace();
		}finally{
			try {
				closeOutput();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	protected final void closeOutput() throws IOException{
		if(out!=null)
			out.close();
	}

	/**
	 * read both input file and output file, if not there create one
	 * @throws IOException
	 */
	protected final void readFile() throws IOException {
		inputFile = new File(compInputLoc);
		if(!inputFile.exists()){
			inputFile.createNewFile();
		}
		outputFile = new File(compOutputLoc);
		if(!outputFile.exists()){
			outputFile.createNewFile();
		}
	}

	/**
	 * this is the algorithm implementation
	 */
	public abstract void doSomething();

	private final String createCompleteLocation(int TYPE){
		switch (TYPE) {
		case INPUT:
			return root+ slash
					+ inputLoc + slash
					+ inputFileName + DOT
					+ inputFileExt;
		case OUTPUT:
			return root+ slash
					+ outputLoc + slash
					+ outputFileName + "."
					+ outputFileExt;
		}
		return null;
	}

	// setter and getter below
	public Scanner getInput() {
		return in;
	}

	public BufferedWriter getOutput() {
		return out;
	}

	protected void print(int valueToPrint){
		print(Integer.toString(valueToPrint));
	}

	protected void print(long valueToPrint){
		print(Long.toString(valueToPrint));
	}

	protected void print(double valueToPrint){
		print(Double.toString(valueToPrint));
	}

	protected void print(Object valueToPrint){
		if(valueToPrint==null || getOutput() == null)
			return;

		print(valueToPrint.toString());
	}

	protected void println(int valueToPrint){
		println(Integer.toString(valueToPrint));
	}

	protected void println(long valueToPrint){
		println(Long.toString(valueToPrint));
	}

	protected void println(double valueToPrint){
		println(Double.toString(valueToPrint));
	}

	protected void println(Object valueToPrint){
		if(valueToPrint==null || getOutput() == null)
			return;

		println(valueToPrint.toString());
	}


	protected void printTab(int length){
		length = Math.abs(length);
		while(--length >= 0) {
			print("\t");
		}
	}

	protected void println(String textToPrint) {
		if (debug)
			TemplateUtility.print(getOutput(), textToPrint, true, true);
		else
			System.out.println(textToPrint);
	}

	protected void print(String textToPrint) {
		if (debug)
			TemplateUtility.print(getOutput(), textToPrint, false, true);
		else
			System.out.print(textToPrint);
	}
}
