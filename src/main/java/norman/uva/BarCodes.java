package norman.uva;

import norman.template.Template;

import java.util.Arrays;

/**
 * Created @author normansyahputa  on 12/11/16.
 */
public class BarCodes extends Template {
    int m, k;
    private long[][] dp;

    public BarCodes() {
        super("BarCodes", "BarCodes", LINUX, true);
    }

    @Override
    public void doSomething() {
        while (true) {

            int n = getInput().nextInt();
            k = getInput().nextInt();
            m = getInput().nextInt();
//            System.out.println("m "+m);

            dp = new long[n + 1][k + 1];
            for (int i = 0; i < dp.length; i++)
                Arrays.fill(dp[i], -1);
//            for(int i=0;i<dp.length;i++)
//                System.out.println(Arrays.toString(dp[i]));

//            System.out.println(BC(n, k));
            System.out.println(BC(n, 0));

            if (!getInput().hasNext()) {
                break;
            }
        }
    }

//    int BC(int n, int k){
//        int ret = dp[n][k];
//        if(ret != -1) return ret;
//        if( n ==0 && k == 0) return ret = 1;
//        if( n ==0 ) return ret = 0;
//        if( k ==0 ) return ret = 0;
//        ret = 0;
//        for(int i=1;i<=m;i++){
//            if(n-i<0) break;
//            ret += BC(n-i, k-1);
//        }
//        return ret;
//    }

    /**
     * my tries - failed for some input, but it can be twe
     *
     * @param n
     * @param k
     * @return
     */
    long BC(int n, int k) {
//        System.out.println(n+" "+k);
//        for(int i=0;i<dp.length;i++)
//            System.out.println(Arrays.toString(dp[i]));

        if (n < 0)
            return 0;

        if (n > 0 && k >= this.k)
            return 0;

        if (dp[n][k] != -1)
            return dp[n][k];

        if (n == 0 && k == this.k) {
            return 1;
        }

        long total = 0;
        for (int i = 1; i <= m; i++) {
//            System.out.println("n"+n+" - i "+i);
            if (n - i < 0)
                break;
            total += BC(n - i, k + 1);
        }

        dp[n][k] = total;
//        for(int i=0;i<dp.length;i++)
//            System.out.println(Arrays.toString(dp[i]));
        return dp[n][k];
    }
}
