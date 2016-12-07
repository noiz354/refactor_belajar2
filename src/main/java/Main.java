

import java.io.*;
import java.util.*;

import static java.lang.Math.max;
import static java.lang.Math.sqrt;


class Main {

	public static void main(String[] args) throws IOException {
		new Main().go();
	}

	void go() throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		Scanner sc = new Scanner(br);
		int[][] dist;
		int[][] weight;
		int row,col,i,j, new_r, new_c;
		PriorityQueue<Vertex> pq;
		Vertex u;

		int tc=sc.nextInt();
		while(tc-->0)
		{
			//input processing
			row=sc.nextInt();
			col=sc.nextInt();

			dist=new int[row+1][col+1];
			weight=new int[row+1][col+1];
			pq = new PriorityQueue<Vertex>();

			for(int r=1;r<=row;r++)
			{
				Arrays.fill(dist[r], INFINITY);
				Arrays.fill(weight[r],INFINITY);
			}

			for(int r=1;r<=row;r++)
				for(int c=1;c<=col;c++)
					weight[r][c] = sc.nextInt();

			//Dijkstra Algorithm - SSSP
			u = new Vertex(1, 1, weight[1][1]);
			dist[1][1] = weight[1][1];
			pq.add(u);
			while(!pq.isEmpty())
			{
				u=pq.poll();
				for(i=0;i<4;i++) //adjacent vertexes
				{
					new_r = u.r + adjR[i];
					new_c = u.c + adjC[i];
					if(new_r >= 1 && new_r <= row && new_c >= 1 && new_c <= col)
						if( u.dist_frm_src + weight[new_r][new_c] < dist[new_r][new_c])
						{
							dist[new_r][new_c] =  u.dist_frm_src + weight[new_r][new_c];
							pq.add(new Vertex(new_r, new_c, dist[new_r][new_c]));
						}

				}
			}
			System.out.println(dist[row][col]);
		}
	}

	class Vertex implements Comparable<Vertex>
	{
		public int r;
		public int c;
		public int dist_frm_src;
		public Vertex(int r, int c, int d)
		{
			this.r=r;
			this.c=c;
			this.dist_frm_src=d;
		}
		@Override
		public int compareTo(Vertex other) {
			return this.dist_frm_src - other.dist_frm_src;
		}
	}

	static final int INFINITY = Integer.MAX_VALUE;
	static final int[] adjR = {-1,0,1,0};
	static final int[] adjC = {0,-1,0,1};


	class IntegerPair{
		public int u, v, weigh;

		public IntegerPair(int u, int v, int weigh) {
			this.u = u;
			this.v = v;
			this.weigh = weigh;
		}
	}

	/** Class for buffered reading int and double values */
	static class Reader {
		static BufferedReader reader;
		static StringTokenizer tokenizer;

		/** call this method to initialize reader for InputStream */
		static void init(InputStream input) {
			reader = new BufferedReader(
					new InputStreamReader(input) );
			tokenizer = new StringTokenizer("");
		}

		/** get next word */
		static String next() throws IOException {
			while ( ! tokenizer.hasMoreTokens() ) {
				//TODO add check for eof if necessary
				tokenizer = new StringTokenizer(
						reader.readLine() );
			}
			return tokenizer.nextToken();
		}

		static int nextInt() throws IOException {
			return Integer.parseInt( next() );
		}

		static double nextDouble() throws IOException {
			return Double.parseDouble( next() );
		}
	}

	BufferedReader reader;
	Reader getInput2(){
		reader = new BufferedReader(new InputStreamReader(System.in));
		return new Reader();
	}

	Scanner input;
	Scanner getInput() {
		if(input==null){
			input = new Scanner(System.in);
		}
		return input;
	}

}
