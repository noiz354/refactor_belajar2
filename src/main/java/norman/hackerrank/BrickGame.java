package norman.hackerrank;

import norman.template.Template2;

import java.io.IOException;
import java.util.Arrays;

/**
 * Created @author normansyahputa  on 12/19/16.
 */
public class BrickGame extends Template2 {
    int dp[], v_[], c_[];

    public BrickGame() {
        super("BrickGame", "BrickGame", LINUX, true);
    }

    public static int max(int x, int y) {
        return x >= y ? x : y;
    }

    @Override
    public void doSomething() {
        try {
            int T = Integer.parseInt(getInput2().readLine());
            String line = null;
            while (T-- > 0) {
                dp = new int[10_000];

                int n = Integer.parseInt(getInput2().readLine());

                v_ = parseInt(getInput2().readLine().split(" "), n);
                c_ = new int[v_.length];

                c_[0] = v_[0];
                for (int i = 1; i < v_.length; i++) {
                    c_[i] = v_[i] + c_[i - 1];
                }
                System.out.println(Arrays.toString(c_));

                dp[0] = v_[0];
                dp[1] = v_[1] + dp[0];
                dp[2] = v_[2] + dp[1];

                for (int i = 3; i < n; i++) {
                    int t1 = (c_[i - 1] - dp[i - 1]) + v_[i];
                    int t2 = (c_[i - 2] - dp[i - 2]) + (v_[i] + v_[i - 1]);
                    int t3 = (c_[i - 3] - dp[i - 3]) + (v_[i] + v_[i - 1] + v_[i - 2]);

                    dp[i] = max(t1, max(t2, t3));
                }

                System.out.println(dp[n - 1]);

            }
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }
    }

    int[] parseInt(String[] input, int n) {
        int[] input2 = new int[input.length];
        for (int i = 0; i < input.length; i++) {
            input2[n - i - 1] = Integer.parseInt(input[i]);
        }
        return input2;
    }
}
