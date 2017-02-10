package norman.uva;

import norman.template.Template;

/**
 * Created @author normansyahputa  on 12/20/16.
 * <p>
 * uva 10943
 */
public class HowToAdd extends Template {
    int[][] dp;

    public HowToAdd() {
        super("HowToAdd", "HowToAdd", LINUX, true);
    }

    @Override
    public void doSomething() {
        int n, k;

        dp = new int[110][110];
        while ((n = getInput().nextInt()) != 0 && (k = getInput().nextInt()) != 0) {
            for (int i = 0; i < dp.length; i++)
                for (int j = 0; j < dp[i].length; j++)
                    dp[i][j] = -1;

            System.out.println(ways(n, k));
        }
    }

    int ways(int n, int k) {

        if (k == 1)
            return 1;

        if (dp[n][k] != -1)
            return dp[n][k];

        int solution = 0;
        for (int x = 0; x <= n; x++) {
            solution = ((solution + ways(n - x, k - 1)) % 1000000);
        }

        return dp[n][k] = solution;
    }
}
