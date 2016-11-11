
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Scanner;
import java.util.Vector;

import static java.lang.Math.sqrt;

class Main {
	public static void main(String[] args) {
		new Main().go();
	}

	void go() {
		T = getInput().nextInt();
		while(T-- > 0){
			edgeList = new ArrayList<>();

			initP();

			N = getInput().nextInt();
			initCoor();
			for(int i=0;i<N;i++){
				cx[i] = getInput().nextInt();
				cy[i] = getInput().nextInt();
			}

			for(int i=0;i<N;i++){
				for( int j=i+1; j<N; j++){
					int srcX = cx[i];
					int srcY = cy[i];
					int dstX = cx[j];
					int dstY = cy[j];
					int diffX = srcX - dstX;
					int diffY = srcY - dstY;
					double dist = sqrt(diffX * diffX + diffY * diffY);
					edgeList.add(new Edge(dist, i, j));
				}
			}

			initSet(N);

			M = getInput().nextInt();

			int d = 0;

			for(int i=0;i<M;i++){
//            while(M-- > 0){
				x = getInput().nextInt();
				y = getInput().nextInt();

				if(!isSameSet(x-1,y-1)) {
					unionSet(x - 1, y - 1);
					d++;
				}
			}

			if(d == N-1) {
				System.out.println("No new highways need\n");
				continue;
			}

			Collections.sort(edgeList);

			for(int i=0;i<edgeList.size() && d < N-1;i++){
				Edge edge = edgeList.get(i);
				if(!isSameSet(edge.x, edge.y)){
					System.out.println((edge.x+1)+" "+(edge.y+1));
					d++;
					unionSet(edge.x, edge.y);
				}
			}
			if(T > 0){
				System.out.println();
			}
		}
	}

	int findSet(int i){
		if(p.get(i)==i){
			return i;
		}else{
			p.set(i, findSet(p.get(i)));
			return p.get(i);
		}
	}

	boolean isSameSet(int i, int j){
//        if(debug){
//            print(i+" "+j);
//        }
		return findSet(i) == findSet(j);
	}

	void unionSet(int i, int j){
		if(!isSameSet(i, j)){
			int set = findSet(j);
			int set1 = findSet(i);
			p.set(set1, set);
		}
		_sc--;
	}

	int T, x, y, N, M;
	List<Integer> p;

	int cx[], cy[];
	private int _sc;

	void initSet(int N){
		for(int i=0;i<N;i++){
			p.set(i, i);
		}
		_sc = N;
	}

	void initCoor(){
		cx = new int[750];
		cy = new int[750];
	}

	void initP(){
		p = new ArrayList<>();
		for(int i=0;i<1000;i++){
			p.add(0);
		}
	}

	List<Edge> edgeList = new ArrayList<>();
	class Edge implements Comparable<Edge>{
		double weight;
		int x, y;

		public Edge(double weight, int x, int y) {
			this.weight = weight;
			this.x = x;
			this.y = y;
		}

		@Override
		public String toString() {
			return
					weight +
							": " + x +
							"," + y;
		}

		@Override
		public int compareTo(Edge o) {
			if(this.weight < o.weight) return -1;
			if(this.weight > o.weight) return 1;
			return 0;
		}
	}

	Scanner input;
	
	Scanner getInput() {
		if(input==null){
			input = new Scanner(System.in);
		}
		return input;
	}
	
}
