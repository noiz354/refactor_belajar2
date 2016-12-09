package norman.unknown;

import norman.template.template;

/**
 * Created by normansyahputa on 12/8/16.
 */
public class Knapsack extends template {
    public Knapsack() {
        super("Knapsack", "Knapsack", LINUX, true);
    }

    @Override
    public void doSomething() {
        int i, j, T, G, ans;

        T = getInput().nextInt();
        while (T-- > 0) {
            for (i = 0; i < MAX_N; i++)
                for (j = 0; j < MAX_W; j++)
                    memo[i][j] = -1;

            N = getInput().nextInt();
            for (i = 0; i < N; i++) {
                V[i] = getInput().nextInt();
                W[i] = getInput().nextInt();
            }

            ans = 0;
            G = getInput().nextInt();
            while (G-- > 0) {
                MW = getInput().nextInt();
                ans += value(0, MW);
            }
            for(i=0;i<5;i++){
                for(j=0;j<5;j++){
                    if(i==0)
                        System.out.print(memo[i][j]);
                    else
                        System.out.print(" "+memo[i][j]);
                }
                System.out.println();
            }

            System.out.printf("%d\n", ans);
        }
    }

    private static final int MAX_N = 1010;
    private static final int MAX_W = 40;
    private static int N, MW;
    private static int[] V = new int[MAX_N], W = new int[MAX_N];
    private static int[][] memo = new int[MAX_N][MAX_W];

    private int value(int id, int w) {
        if (id == N || w == 0) return 0;
        if (memo[id][w] != -1) return memo[id][w];
        if (W[id] > w)         return memo[id][w] = value(id + 1, w);
        return memo[id][w] = Math.max(value(id + 1, w), V[id] + value(id + 1, w - W[id]));
    }

}
