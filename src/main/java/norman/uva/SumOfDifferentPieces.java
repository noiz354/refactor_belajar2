package norman.uva;

import norman.template.Template;

import java.util.Arrays;

/**
 * @author normansyahputa on 6/20/17.
 *
 * using memoization.
 */
public class SumOfDifferentPieces extends Template{
    public SumOfDifferentPieces() {
        super("SumOfDifferentPieces", "SumOfDifferentPieces", LINUX, true);
    }

    final static int N = 5200;// maximal prime number

    private int primes[];
    private int[][][] dp;

    @Override
    public void doSomething() {
        // build prime sequence, sieve
        int i, j, k;
        primes = new int[N];
        primes[0]=0;primes[1]=1;
        char[] mark = new char[10_000];
        int Pt = 0;
        for(i=2;i<10_000;i++){
            if(mark[i] ==0){
                primes[Pt++] = i;
                for(j=2;i*j<10_000;j++){
                    mark[i*j] = 1;
                }
            }
        }
//        print(Arrays.toString(primes));
        // build prime sequence, sieve

        dp = new int[N][187][15];
        for(i=0;i<N;i++){
            for(j=0;j<187;j++){
                for(k=0;k<15;k++){
                    dp[i][j][k]=-1;
                }
            }
        }

        i = getInput().nextInt();
        j = getInput().nextInt();
        while(i != 0 || j != 0){
            println(nWays(i,0,j));

            i = getInput().nextInt();
            j = getInput().nextInt();
        }
    }

    private int nWays(int n, int i, int k) {
        if(n==0&&k==0){
            return 1;
        }else if(n<0||i>=187||k==0){
            return 0;
        }else if(dp[n][i][k]!=-1){
            return dp[n][i][k];
        }else{
            return dp[n][i][k] = nWays(n,i+1, k) + nWays(n-primes[i], i+1, k-1);
        }
    }
}
