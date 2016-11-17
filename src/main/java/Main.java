
import java.util.*;

import static java.lang.Math.max;
import static java.lang.Math.sqrt;

class Main {
	public static void main(String[] args) {
		new Main().go();
	}

	void go() {
		while(true){
			n = getInput().nextInt();
			m = getInput().nextInt();

			if(n==0&&m==0){
				break;
			}

			edgeList = new ArrayList<>();
			for(int i=0;i<m;i++){
				u = getInput().nextInt();
				v = getInput().nextInt();
				w = getInput().nextInt();

				edgeList.add(new Edge(w, u,v));
			}

			Collections.sort(edgeList);

			par = new int[1_001];
			for(int i=0;i<n;i++){
				par[i] = i;
			}

			rank = new PriorityQueue<>(new Comparator<Double>() {
				@Override
				public int compare(Double o1, Double o2) {
					return Double.compare(o1, o2);
				}
			});

			for(int i=0;i<m;i++){

				Edge edge = edgeList.get(i);
				if(!isSameSet(edge.x, edge.y)){
					par[findPar(edge.y)] = par[findPar(edge.x)];
				}else{
					rank.add(edge.weight);
				}
			}

			int size = rank.size();
			if(size==0){
				System.out.println("forest");
			}else {
				for (int i = 0; i < size; i++) {
					double value = rank.remove();
					System.out.print(((int)value+((i!=size-1)?" ":"")));
				}
				System.out.println();
			}
		}
	}

	boolean isSameSet(int i, int j){
		return findPar(i) == findPar(j);
	}

	int findPar(int x){
		return (par[x]==x)?x:(par[x] = findPar(par[x]));
	}

	private int n, // 1-1_000
			m,// 0-25_000
			u,v,w;
	int par[];
	Queue<Double> rank;

	List<Edge> edgeList = new ArrayList<>();
	private class Edge implements Comparable<Edge>{
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
