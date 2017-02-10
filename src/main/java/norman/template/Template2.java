package norman.template;

import java.io.*;
import java.util.Scanner;

/**
 * Created @author normansyahputa  on 12/13/16.
 */
public abstract class Template2 extends Template {
    private BufferedReader reader;

    public Template2(String inputFileName, String outputFileName, int envType, boolean debug) {
        super(inputFileName, outputFileName, envType, debug);
    }

    public Template2(String inputFileName, String outputFileName, int envType) {
        super(inputFileName, outputFileName, envType);
    }

    @Override
    public Scanner getInput() {
        throw new RuntimeException("dont use this anymore!!");
    }

    @Override
    public void runSomething() {
        runSomething2();
    }

    protected void runSomething2() {
        try {
            readFile();

            FileReader in = new FileReader(inputFile.getAbsolutePath());
            reader = new BufferedReader(in);

            FileWriter outFw = new FileWriter(outputFile);
            out = new BufferedWriter(outFw);

            doSomething();

        } catch (IOException ioe) {
            ioe.printStackTrace();
        } finally {
            try {
                closeOutput();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    protected BufferedReader getInput2() {
        return reader;
    }


}
