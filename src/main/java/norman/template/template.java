package norman.template;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public abstract class template implements template_const{


	String root, inputLoc, inputFileName, inputFileExt, outputLoc, outputFileName, outputFileExt;
	String compInputLoc, compOutputLoc;
	String slash;
	File inputFile, outputFile;
	Scanner in;
	BufferedWriter out;
	protected boolean debug = false;// set debug to print to console or file, change it in constructor
	
	/**
	 * default constructor using eclipse input/output with passing debug flag
	 */
	public template(String inputFileName, String outputFileName, int envType, boolean debug){
		this(System.getProperty("user.dir"), "custom_in", inputFileName, "txt", "custom_out", outputFileName, "txt", envType, debug);
	}

	/**
	 * default constructor using eclipse input/output without changing debug flag
	 */
	public template(String inputFileName, String outputFileName, int envType){
		this(System.getProperty("user.dir"), "custom_in", inputFileName, "txt", "custom_out", outputFileName, "txt", envType, false);
	}

	private template(String root, String inputLoc, String inputFileName, String inputFileExt
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

	private final void runSomething(){
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
	private final void readFile() throws IOException{
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
}
