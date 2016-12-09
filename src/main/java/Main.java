

import java.io.*;
import java.util.*;

import static java.lang.Math.max;
import static java.lang.Math.sqrt;


class Main {

	public static void main(String[] args) throws IOException {
		new Main().go();
	}

	void go() throws IOException {

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

	BufferedReader reader;
	Reader getInput2(){
		reader = new BufferedReader(new InputStreamReader(System.in));
		return reader;
	}

	Scanner input;
	Scanner getInput() {
		if(input==null){
			input = new Scanner(System.in);
		}
		return input;
	}

}
