import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Scanner;


/**
 * hackerrank submit Template
 * @author M. Normansyah
 * 2:56:28 PM
 */
public class Solution {


    static long dp[], v_[], c_[];
    static BufferedReader reader;
    // setup below here
    static Scanner input = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        int T = getInput().nextInt();
        String line = null;
        while (T-- > 0) {
            dp = new long[10_000];

            int n = getInput().nextInt();

            v_ = parseInt(null, n);
            c_ = new long[v_.length];

            c_[0] = v_[0];
            for (int i = 1; i < v_.length; i++) {
                c_[i] = v_[i] + c_[i - 1];
            }
            System.out.println(Arrays.toString(c_));

            dp[0] = v_[0];
            dp[1] = v_[1] + dp[0];
            dp[2] = v_[2] + dp[1];

            for (int i = 3; i < n; i++) {
                long t1 = (c_[i - 1] - dp[i - 1]) + v_[i];
                long t2 = (c_[i - 2] - dp[i - 2]) + (v_[i] + v_[i - 1]);
                long t3 = (c_[i - 3] - dp[i - 3]) + (v_[i] + v_[i - 1] + v_[i - 2]);

                dp[i] = max(t1, max(t2, t3));
            }

            System.out.println(dp[n - 1]);

        }
    }

    public static long max(long x, long y) {
        return x >= y ? x : y;
    }

    static long[] parseInt(String[] input, int n) {
        long[] input2 = new long[n];
        for (int i = 0; i < n; i++) {
            input2[n - i - 1] = getInput().nextLong();
        }
        return input2;
    }

    static BufferedReader getInput2() {
        reader = new BufferedReader(new InputStreamReader(System.in));
        return reader;
    }

    public static Scanner getInput() {
        return input;
	}
}