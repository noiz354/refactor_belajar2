import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;


/**
 * hackerrank submit template
 * @author M. Normansyah
 * 2:56:28 PM
 */
public class Solution {


    public static void main(String[] args) throws IOException{
		int i, j, T, G, ans;

		T = getInput().nextInt();
		while (T-- > 0) {
			for (i = 0; i < MAX_N; i++)
				for (j = 0; j < MAX_W; j++)
					memo[i][j] = -1;

			N = getInput().nextInt();
			MW = getInput().nextInt();
			for (i = 0; i < N; i++) {
				V[i] = getInput().nextInt();
				W[i] = getInput().nextInt();
			}

			ans = 0;
			ans += value(0, MW);

			System.out.printf("%d\n", ans);

		}
    }

	private static final int MAX_N = 1010;
	private static final int MAX_W = 40;
	private static int N, MW;
	private static int[] V = new int[MAX_N], W = new int[MAX_N];
	private static int[][] memo = new int[MAX_N][MAX_W];

	private static int value(int id, int w) {
		if (id == N || w == 0) return 0;
		if (memo[id][w] != -1) return memo[id][w];
		if (W[id] > w)         return memo[id][w] = value(id + 1, w);
		return memo[id][w] = Math.max(value(id + 1, w), V[id] + value(id + 1, w - W[id]));
	}
    
	// setup below here
	static Scanner input = new Scanner(System.in);
	
	public static Scanner getInput() {
		return input;
	}
}