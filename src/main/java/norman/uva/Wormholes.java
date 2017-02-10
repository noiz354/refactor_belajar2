package norman.uva;

import norman.template.Template;

import java.util.ArrayList;
import java.util.List;

/**
 * Created @author normansyahputa  on 12/10/16.
 * Bellman Ford - UVa 558
 * slow + for small graph with negative edge
 */
public class Wormholes extends Template {
    static final int INF = 1000000000;
    List<List<Pair<Integer, Integer>>> adjList;
    private int[] dist;

    public Wormholes() {
        super("Wormholes", "Wormholes", LINUX, true);
    }

    @Override
    public void doSomething() {
        int c = getInput().nextInt();

        while (c-- > 0) {
            int n = getInput().nextInt();
            int m = getInput().nextInt();

            dist = new int[n];
            adjList = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                adjList.add(new ArrayList<>());
                dist[i] = INF;
            }

            for (int i = 0; i < m; i++) {
                int x = getInput().nextInt();
                int y = getInput().nextInt();
                int t = getInput().nextInt();

                List<Pair<Integer, Integer>> pairs = adjList.get(x);
                pairs.add(new Pair<>(y, t));
                adjList.set(x, pairs);
            }
            int s = 0;
            dist[s] = 0;

            for (int i = 0; i < n - 1; i++) {
                for (int u = 0; u < n; u++) {
                    for (int j = 0; j < adjList.get(u).size(); j++) {
                        Pair<Integer, Integer> v = adjList.get(u).get(j);
                        dist[v.u] = Math.min(v.u, (dist[u] + v.v));
                    }
                }
            }

            boolean hasNegativeCycle = false;
            for (int u = 0; u < n; u++) {// one more pass to check
                for (int j = 0; j < adjList.get(u).size(); j++) {
                    Pair<Integer, Integer> v = adjList.get(u).get(j);
                    if (dist[v.u] > dist[u] + v.v) {
                        hasNegativeCycle = true;
                    }
                }
            }
            System.out.printf("%s\n", hasNegativeCycle ? "possible" : "not possible");
        }


    }

    private static class Pair<E, V> {
        E u;
        V v;

        public Pair(E u, V v) {
            this.u = u;
            this.v = v;
        }

        @Override
        public String toString() {
            return u + "," + v;
        }
    }
}
