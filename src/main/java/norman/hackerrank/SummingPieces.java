package norman.hackerrank;

import norman.template.Template;

import java.util.Arrays;

/**
 * @author normansyahputa on 6/5/17.
 * https://www.hackerrank.com/challenges/summing-pieces
 *
 * failed at larger test case. (somehow !!)
 */
public class SummingPieces extends Template{

    public static final int MOD = 1000000007;

    public SummingPieces() {
        super("SummingPieces", "SummingPieces", LINUX, true);
    }


    @Override
    public void doSomething() {
        int n = getInput().nextInt();
        println(n);

        double[] T = new double[n+1];
        double[] P = new double[n+1];

        long[] S = new long[n+1];
        long[] arr = new long[n+1];
        for(int i=1;i<=n;i++){
            arr[i] = getInput().nextInt();

            S[i] += arr[i]+S[i-1];
        }

        println(Arrays.toString(S));

        P[1] = 0;
        for(int i=1;i<=n;i++){
            if(P[i]==0){
                P[i] = (long) (Math.pow(2, i-2)*S[i-1] + P[i-1]);
            }
            T[i] = (long) (2*T[i-1] + Math.pow(2, i-1)*S[i] + (Math.pow(2, i-1)-1)*arr[i] - P[i]);
        }

        println(Arrays.toString(P));
        println(Arrays.toString(T));

        print(T[n]% MOD);
    }
}
