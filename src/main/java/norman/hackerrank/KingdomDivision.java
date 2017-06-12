package norman.hackerrank;

import norman.template.Template;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author  normansyahputa on 6/12/17.
 *
 * https://www.hackerrank.com/challenges/kingdom-division
 */
public class KingdomDivision extends Template {
    public KingdomDivision() {
        super("KingdomDivision", "KingdomDivision", LINUX, true);
    }

    static final int NODE = 100_000;
    List<Integer>[] adj;
    static final int mod = (int) (Math.pow(10,9)+7);
    static int cc=1;

    long memo[][][];
    long done[][][];
    // instead of recording s and c separately, we can simply store adj[s][c] in memo.
    // No need to store p, since it is rooted tree. Parent of a node is always same.

    @Override
    public void doSomething() {
        int n = getInput().nextInt();

        memo = new long[NODE+10][2][2];
        done = new long[NODE+10][2][2];

        adj = new List[NODE+10];
        for(int i=0;i<adj.length;i++){
            adj[i] = new ArrayList<>();
        }

        for(int i=1;i<=n;i++){
            adj[i].clear();
        }

        for(int i=0;i<=n-2;i++){
            int a =getInput().nextInt();
            int b =getInput().nextInt();

            adj[a].add(b);
            adj[b].add(a);
        }

        cc++;
        long res = dp(1,0,0,0);
        res += dp(1,0,1,0);
        res = norm(res);

        println(res);

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
}
