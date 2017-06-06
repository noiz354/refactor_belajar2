package norman.hackerrank;

import norman.template.Template;

import java.util.Arrays;

/**
 * @author normansyahputa on 6/5/17.
 * https://www.hackerrank.com/challenges/summing-pieces
 */
public class SummingPieces extends Template{
    public SummingPieces() {
        super("SummingPieces", "SummingPieces", LINUX, true);
    }

    @Override
    public void doSomething() {
        int n = getInput().nextInt();
        print(n);

        int[] S = new int[n=1];
        int[] arr = new int[n+1];
        for(int i=1;i<=n;i++){
            arr[i] = getInput().nextInt();

            S[i] += arr[i]+S[i-1];
        }

        print(Arrays.toString(S));
    }
}
