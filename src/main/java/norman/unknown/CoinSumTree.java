package norman.unknown;

import norman.template.Template;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by normansyahputa on 7/6/17.
 *
 * based on http://codeforces.com/blog/entry/20935 Problem 1
 */
public class CoinSumTree extends Template {
    public CoinSumTree() {
        super("CoinSumTree", "CoinSumTree", LINUX, true);
    }

    @Override
    public void doSomething() {
        int N = getInput().nextInt();
        C = new int[N+1];
        adj = new ArrayList<>();

        dp1 = new int[N+1];
        dp2 = new int[N+1];

        for (int i = 1; i < N+1; i++) {
            C[i] = getInput().nextInt();
        }

        for (int i = 0; i < N + 1; i++) {
            adj.add(new ArrayList<>());
        }

        for (int i = 0; i < N - 1; i++) {
            int u = getInput().nextInt();
            int v = getInput().nextInt();
            adj.get(u).add(v);
            adj.get(v).add(u);
        }


        dfs(1,0);
        int ans = Math.max(dp1[1], dp2[1]);
        println(String.format("%d", ans));
    }

    // pv is parent of node V
    void dfs(int V, int pV){

        // for storing sums of dp1 and max(dp1,dp2) for all children of V
        int sum1 = 0, sum2 = 0;

        // transverse over all children
        for (Integer v : adj.get(V)) {
            if(v==pV)
                continue;

            dfs(v,V);

            sum1 += dp2[v];
            sum2 += Math.max(dp1[v], dp2[v]);

        }


        dp1[V] = C[V] + sum1;
        dp2[V] = sum2;

    }

    // functions as defined above
    int dp1[], dp2[];

    List<List<Integer>> adj;

    int[] C;
}
