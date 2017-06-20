import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
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

    static final int NODE = 100_000;
    List<Integer>[] adj;
    static final int mod = (int) (Math.pow(10,9)+7);
    static int cc=1;

    long memo[][][];
    long done[][][];
    // instead of recording s and c separately, we can simply store adj[s][c] in memo.
    // No need to store p, since it is rooted tree. Parent of a node is always same.

    public static void main(String[] args) throws IOException {
        Solution solution = new Solution();
        solution.doSomething();
    }

    private void doSomething() {
        int n = getInput().nextInt();
        int a = getInput().nextInt();
        int b = getInput().nextInt();



        System.out.println((a+b*(n-1)) - (a*(n-1)+b)  + 1);
    }

    // this is f() in editorial
    private long dp(int s, int p, int cur, int ally){
        long res = 0;

        res = dp2(s,p,0,cur,ally); // go and fetch some ally from children

        return res;
    }



    private long dp2(int s, int p, int c, int cur, int ally) {// this is g() in editorial
        long res = 0;

        if( c == adj[s].size()){ // Base case
            return ally;
        }

        int t = adj[s].get(c);

        // ignore back edge to parent of s. Rooted tree is not suppose to have
        // this back edge anyway
        if(t == p){
            res = dp2(s,p,c+1,cur,ally);
            return res;
        }

        if(done[t][cur][ally]==cc)
            return memo[t][cur][ally];

        done[t][cur][ally] = cc;

        // For each child, we can make it ally with its parent
        // and start independent subtree dp
        res = dp(t,s,cur,1)*dp2(s,p,c+1,cur,1);
        res %= mod;

        // Or, make it different
        long temp = dp(t,s,1-cur,0)*dp2(s,p,c+1,cur,ally);
        temp %= mod;

        res += temp;
        res = norm(res);


        return memo[t][cur][ally] = res;
    }

    private long norm(long x){
        return (x>=mod)?x-=mod:x;
    }

    static BufferedReader getInput2() {
        reader = new BufferedReader(new InputStreamReader(System.in));
        return reader;
    }

    public static Scanner getInput() {
        return input;
	}
}