package norman.uva;

import norman.template.Template;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author normansyahputa on 6/20/17.
 *
 * using memoization.
 */
public class SumOfDifferentPrimes extends Template{
    public SumOfDifferentPrimes() {
        super("SumOfDifferentPieces", "SumOfDifferentPieces", LINUX, true);
    }

    /*final static int N = 5200;// maximal prime number

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
    }*/

    @Override
    public void doSomething() {
        boolean[] arr = new boolean[1130];
        int[] primes = new int[189];
        int top = 0;
        arr[0] = arr[1] = true;
        for (int i = 2; i < arr.length; i++)
            if (!arr[i])
                for (int j = i * i; j < arr.length; j += i)
                    arr[j] = true;
        for (int i = 0; i < arr.length; i++)
            if (!arr[i])
                primes[top++] = i;
        while (true) {
            int n = getInput().nextInt();
            int r = getInput().nextInt();
            if (n == 0 && r == 0)
                break;
            int[][] nWays = new int[1121][15];
            nWays[0][0] = 1;
            int i, j, k;
            for(i = 0; i < top; i++) {
                for(j = 1120; j >= primes[i]; j--) {
                    for(k = 14; k >= 1; k--)
                        nWays[j][k] += nWays[j-primes[i]][k-1];
                }
            }
            println(nWays[n][r]);
        }
    }
}
