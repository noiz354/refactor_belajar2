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


    static BufferedReader reader;
    // setup below here
    static Scanner input = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        int n = getInput().nextInt();

        long[] T = new long[n+1];
        long[] P = new long[n+1];

        long[] S = new long[n+1];
        long[] arr = new long[n+1];
        for(int i=1;i<=n;i++){
            arr[i] = getInput().nextInt();

            S[i] += arr[i]+S[i-1];
        }

        P[1] = 0;
        for(int i=1;i<=n;i++){
            if(P[i]==0){
                P[i] = (long) (Math.pow(2, i-2)*S[i-1] + P[i-1]);
            }
            T[i] = (long) (2*T[i-1] + Math.pow(2, i-1)*S[i] + (Math.pow(2, i-1)-1)*arr[i] - P[i]);
        }

        System.out.println(T[n]%1000000007);
    }

    static BufferedReader getInput2() {
        reader = new BufferedReader(new InputStreamReader(System.in));
        return reader;
    }

    public static Scanner getInput() {
        return input;
	}
}