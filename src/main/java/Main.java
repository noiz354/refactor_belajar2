

import java.io.*;
import java.util.*;

import static java.lang.Math.max;
import static java.lang.Math.sqrt;

class Main {

	public static void main(String[] args) throws IOException {
		new Main().go();
	}

	void go() throws IOException {
		Reader.init(System.in);
		int T = Reader.nextInt();
		while(T-- > 0){

			int N = Reader.nextInt();
			int M = Reader.nextInt();

			adjList = new ArrayList<>();
			for(int i=0;i<N;i++){
				List<IntegerPair> neighbor
						= new ArrayList<>();
				adjList.add(neighbor);
			}

			for(int i=0;i<M;i++){
				int u = Reader.nextInt()-1;
				int v = Reader.nextInt()-1;
				int w = Reader.nextInt();

//                adjList.get(u).add(new IntegerPair(v,w));
				List<IntegerPair> bef = adjList.get(u);
				bef.add(new IntegerPair(v,w));
				adjList.set(u, bef);

				bef = adjList.get(v);
				bef.add(new IntegerPair(u,w));
				adjList.set(v, bef);
			}

			int s = Reader.nextInt()-1;

			// dijkstra routine
			List<Integer> dist = new ArrayList<>();
			dist.addAll(Collections.nCopies(N, INF));// INF = 1*10^9 not MAX_INT to avoid overflow
			dist.set(s, 0);
			PriorityQueue<IntegerPair> pq = new PriorityQueue<>(1,
					(i,j)->( i.first - j.first ));

			// sort based on increasing distance
			pq.offer(new IntegerPair(0,s));

			while(!pq.isEmpty()){// main loop
				IntegerPair top = pq.poll();// greedy: pick shortest unvisited vertex
				int d = top.first;
				int u = top.second;

				// we want to process vertex u only once but we can
				if(d > dist.get(u))// This check is importatn !
					continue;

				Iterator<IntegerPair> it = adjList.get(u).iterator();
				while(it.hasNext()){// all outgoind edges from u
					IntegerPair p = it.next();
					int v = p.first;
					int weight_u_v = p.second;
					// if can relax
					if(dist.get(u) + weight_u_v < dist.get(v)){
						dist.set(v, dist.get(u)+weight_u_v); // relax
						pq.offer(new IntegerPair(dist.get(v), v));
					}

				}
			}

			boolean firstPrint = false;
			for(int i=0;i<N;i++){
				if(s==i){
					continue;
				}else {
					if(!firstPrint){
						if(dist.get(i)==INF){
							System.out.print("-1");
						}else {
							System.out.print(dist.get(i));
						}
						firstPrint = !firstPrint;
					}else{
						if(dist.get(i)==INF){
							System.out.print(" -1");
						}else {
							System.out.print(" " + dist.get(i));
						}
					}
				}
			}
			System.out.println();
		}
	}

	static final int INF = 1000000000;
	List<List<IntegerPair>> adjList;

	static class IntegerPair{
		public int first,second;

		public IntegerPair(int first, int second) {
			this.first = first;
			this.second = second;
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

	Scanner input;
	BufferedReader reader;
	Reader getInput2(){
		return new Reader();
	}
	
	Scanner getInput() {
		if(input==null){
			input = new Scanner(System.in);
			reader = new BufferedReader(new InputStreamReader(System.in));
		}
		return input;
	}
	
}
