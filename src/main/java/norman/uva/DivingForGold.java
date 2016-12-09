package norman.uva;

import norman.template.template;

/**
 * Created by normansyahputa on 12/9/16.
 */
public class DivingForGold extends template {
    public DivingForGold() {
        super("DivingForGold", "DivingForGold", LINUX, true);
    }

    @Override
    public void doSomething() {
        while(true){
            int T = getInput().nextInt();
            int w = getInput().nextInt();

            N = getInput().nextInt();
            for(int i=0;i<N;i++){
                d[i] = getInput().nextInt();
                int a = getInput().nextInt();

                int td = w*d[i];
                int ta = 2*w*d[i];
                int t = ta + td;
                W[i]= t;
                V[i] = a;
            }

            for (int i = 0; i < MAX_N; i++)
                for (int j = 0; j < MAX_W; j++)
                    memo[i][j] = -1;

//            System.out.println(""+value(0, T));
//            path(N, T, 0);

            int[][] result = bottomUpDP(V, W, T);
            memo = result;
            System.out.println(memo[V.length][T]);
            path(N-1, T, 0);
            if(!getInput().hasNext()){
                break;
            }
        }
    }

    void path(int n, int t, int cnt)
    {
        if ( n == 0 ) System.out.printf("%d\n",cnt);
        else if ( memo[n][t] != -1)
        {
            path( n-1, t-W[n], cnt+1 );
            System.out.printf("%d %d\n",d[n],V[n]);
        }
        else
        {
            path( n-1, t, cnt );
        }
    }

    /**
     * Solves 0/1 knapsack in bottom up dynamic programming
     */
    public int[][] bottomUpDP(int val[], int wt[], int W){
        int K[][] = new int[val.length+1][W+1];
        for(int i=0; i <= val.length; i++){
            for(int j=0; j <= W; j++){
                if(i == 0 || j == 0){
                    K[i][j] = 0;
                    continue;
                }
                if(j - wt[i-1] >= 0){
                    K[i][j] = Math.max(K[i-1][j], K[i-1][j-wt[i-1]] + val[i-1]);
                }else{
                    K[i][j] = K[i-1][j];
                }
            }
        }
        return K;
//        return K[val.length][W];
    }


    static boolean tomar[][] = new boolean[ 33][1003];
    static int d[] = new int[33];
    private static final int MAX_N = 1010;
    private static final int MAX_W = 1000;
    private static int N, MW;
    private static int[] V = new int[MAX_N], W = new int[MAX_N];
    private static int[][] memo = new int[MAX_N][MAX_W];

    private int value(int id, int t) {
        System.out.println("id "+ id+" t "+t);
        if (id == N || t == 0) return 0;
        if (memo[id][t] != -1) return memo[id][t];
        if (W[id] > t)         return memo[id][t] = value(id + 1, t);
        return memo[id][t] = Math.max(value(id + 1, t), V[id] + value(id + 1, t - W[id]));
    }
}
