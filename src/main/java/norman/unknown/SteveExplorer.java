package norman.unknown;

import norman.template.Template;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by normansyahputa on 7/21/17.
 *
 * http://codeforces.com/blog/entry/20935
 * Problem 4
 */
public class SteveExplorer extends Template{
    public SteveExplorer() {
        super("SteveExplorer", "SteveExplorer", LINUX, true);
    }

    @Override
    public void doSomething() {
        int N = getInput().nextInt();

        cost = new int[N+1];
        f = new int[N+1];
        g = new int[N+1];
        adj = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            cost[i] = getInput().nextInt();
        }

        for (int i = 0; i < N + 1; i++) {
            adj.add(new ArrayList<>());
        }

        for (int i = 0; i < N - 1; i++) {
            int a = getInput().nextInt();
            int b = getInput().nextInt();

            adj.get(a).add(b);
            adj.get(b).add(a);
        }

        int res = Integer.MAX_VALUE;
        for(int i = 1;i<N+1;i++){
            f(i, 0);
            res = Math.min(res, f[i]);
        }

        println(String.format("%d", res));
    }

    private void f(int V, int pV) {
        println(String.format("f() V %d pV %d", V, pV));
        f[V] = cost[V];

        int sum = 0;

        for (Integer v : adj.get(V)) {
            if(v == pV) continue;

            f(v, V);

            sum += f[v];
        }

        g(V, pV);
        sum += g[V];

        f[V] = sum / ( adj.get(V).size()+1);
    }

    private void g(int V, int pV){
        println(String.format("g() V %d pV %d", V, pV));
        if(pV != 1) {// if not root
            // set g to parent vertex
            g[V] = cost[pV];

            int sum = 0;

            for (Integer v : adj.get(pV)) {
                if(v==pV) continue;
                if(v==V) continue;

                f(v,pV);

                sum += f[v];
            }

            g[V] += (sum / adj.get(pV).size());
        }
    }

    int[] cost, f, g;
    int root;
    List<List<Integer>> adj;
}
