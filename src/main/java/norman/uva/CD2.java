package norman.uva;

import norman.template.Template;
import norman.template.TemplateUtility;

/**
 * Created on 1/27/17.
 *
 * @author normansyahputa
 *         <p>
 *         resource : https://github.com/ackoroa/UVa-Solutions/blob/master/UVa%20624%20-%20CD/src/UVa%20624%20-%20CD.cpp
 */
public class CD2 extends Template {
    int tapeLen, n, trackLen[];
    int ans, nearestTotal;

    public CD2() {
        super("CD", "CD", LINUX, true);
    }

    @Override
    public void doSomething() {
        while (true) {
            if (!getInput().hasNext()) {
                break;
            }

            tapeLen = getInput().nextInt();
            n = getInput().nextInt();

            trackLen = new int[n];
            for (int i = 0; i < n; i++) {
                trackLen[i] = getInput().nextInt();
            }

            ans = -1;
            nearestTotal = -1;
            choose(0, 0, 0);

            for (int i = 0; i < n; i++) {
                if ((ans >> i) % 2 != 0) {
                    TemplateUtility.print(getOutput(), trackLen[i] + " ", false, true);
                }
            }
            TemplateUtility.print(getOutput(), String.format("sum:%d", nearestTotal), true, true);
        }
    }

    private void choose(int total, int mask, int p) {
        if (total > tapeLen)
            return;
        if (total > nearestTotal) {
            nearestTotal = total;
            ans = mask;
        }

        if (p >= n)
            return;

        choose(total + trackLen[p], mask | (1 << p), p + 1);
        choose(total, mask, p + 1);
    }
}
