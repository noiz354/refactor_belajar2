package norman.uva;

import norman.template.Template;

import java.util.Arrays;

/**
 * Created by normansyahputa on 6/21/17.
 *
 * uva 11566
 */
public class LetsYumCha extends Template{
    public LetsYumCha() {
        super("LetsYumCha", "LetsYumCha", LINUX, true);
    }

    int[] p;
    int N;
    int K;
    double totalFavourValue[];
    int x;
    int T;

    int[][][] dp;

    @Override
    public void doSomething() {

        N = getInput().nextInt();
        x = getInput().nextInt();
        T = getInput().nextInt();
        K = getInput().nextInt();// jenis dimsum

        while(true) {
            p = new int[K];
            totalFavourValue = new double[K];
            int favourValue[][] = new int[K][N + 1];// add to yourself

//        println("N "+N+" x "+x+" T "+T+" K "+K);

            for (int i = 0; i < K; i++) {
                p[i] = getInput().nextInt();

                int tot = 0;
                for (int j = 0; j < N + 1; j++) {
                    favourValue[i][j] = getInput().nextInt();
                    tot += favourValue[i][j];
                }
                totalFavourValue[i] = tot;
            }

            dp = new int[103][1005][23];
            for(int i=0;i<dp.length;i++)
                for(int j=0;j<dp[i].length;j++)
                    for(int k=0;k<dp[i][j].length;k++)
                        dp[i][j][k] = -1;


//        println("p "+Arrays.toString(p));
//        for(int i=0;i<favourValue.length;i++){
//            println("favourValue ke-"+i+" "+Arrays.toString(favourValue[i]));
//        }
//        println("totalFavourValue "+Arrays.toString(totalFavourValue));

//        println("result "+(double)maxFlavour(0, 0, 0)/(double)(N+1));

            double result = (double) maxFlavour(0, 0, 0) / (double) (N + 1);
            println(String.format("%.2f", result));

            N = getInput().nextInt();
            x = getInput().nextInt();
            T = getInput().nextInt();
            K = getInput().nextInt();// jenis dimsum

            if(N==0&&x==0&&T==0&&K==0)
                break;
        }
    }

    private int maxFlavour(int i, int price, int order){
//        printTab(i);
//        println("i "+i+" price "+price+" order "+order);

        int trail = price + (T * (N + 1));
        trail = (int) Math.ceil((double)trail*1.1);

        if(order >2*(N+1) || (trail > (N+1)*x)){
//            printTab(i);
//            println("masuk sini #1");
            return -Integer.MAX_VALUE;
        }

        if(i>=K || order == 2*(N+1) || (trail == (N+1)*x)){
//            printTab(i);
//            println("masuk sini #3");
            return 0;
        }

        if(dp[i][price][order]!=-1)
            return dp[i][price][order];

        int plusOne = (int) totalFavourValue[i] + maxFlavour(i + 1, price + p[i], order + 1);
        int plusTwo = (2 * (int) totalFavourValue[i]) + maxFlavour(i + 1, price + (2 * p[i]), order + 2);
        int plusZero = maxFlavour(i + 1, price, order);

//        printTab(i);
//        println("plusOne "+plusOne+" plusTwo "+plusTwo+" plusZero "+plusZero);

        return dp[i][price][order] = Math.max(plusOne,Math.max(plusTwo,plusZero));
    }
}
