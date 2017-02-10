package norman.hackerrank;

import norman.template.Template;

/**
 * Created @author normansyahputa  on 12/15/16.
 * https://www.hackerrank.com/challenges/sam-and-substrings
 */
public class SamAndSubStrings extends Template {
    final static long MOD = (long) (Math.pow(10, 9) + 7);

    public SamAndSubStrings() {
        super("SamAndSubStrings", "SamAndSubStrings", LINUX, true);
    }

    @Override
    public void doSomething() {
        while (true) {
            String in = getInput().next();
            int l = in.length();
            long res = 0;
            long f = 1;

            System.out.println(in);
            System.out.println(MOD);

            for (int i = l - 1; i >= 0; i--) {
                System.out.println((in.charAt(i) - '0'));
                res = (res + ((in.charAt(i) - '0') * f * (i + 1))) % MOD;
                f = (f * 10 + 1) % MOD;
            }
            System.out.println(res);
            if (!getInput().hasNext()) {
                break;
            }
        }
    }
}
