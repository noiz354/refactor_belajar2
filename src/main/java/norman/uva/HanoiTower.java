package norman.uva;

import norman.template.Template;
import norman.template.TemplateUtility;

import java.util.Locale;

/**
 * Created on 2/1/17.
 *
 * @author normansyahputa
 */
public class HanoiTower extends Template {

    private static final String[] peg = {"A", "B", "C"};

    public HanoiTower() {
        super("HanoiTower", "HanoiTower", LINUX, true);
    }

    @Override
    public void doSomething() {
        int discSize = 0;
        while ((discSize = getInput().nextInt()) != -1) {
            moveDisc(discSize, peg[0], peg[1], peg[2]);
        }
    }

    private void moveDisc(int discSize, String start, String tengah, String akhir) {
        if (discSize == 1) {
            TemplateUtility.print(getOutput(), String.format(Locale.CANADA, "%s -> %s", start, akhir),
                    true, true);
        } else {
            moveDisc(discSize - 1, start, akhir, tengah);
            TemplateUtility.print(getOutput(), String.format(Locale.CANADA, "%s -> %s", start, akhir),
                    true, true);
            moveDisc(discSize - 1, tengah, start, akhir);
        }
    }
}
