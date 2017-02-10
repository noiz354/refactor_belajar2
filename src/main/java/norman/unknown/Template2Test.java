package norman.unknown;

import norman.template.Template2;

import java.io.IOException;

/**
 * Created @author normansyahputa  on 12/13/16.
 */
public class Template2Test extends Template2 {
    public Template2Test() {
        super("Template2Test", "Template2Test", LINUX, true);
    }

    @Override
    public void doSomething() {
        String line;

        try {
            while ((line = getInput2().readLine()) != null) {
                System.out.println("\"" + line + "\"");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
