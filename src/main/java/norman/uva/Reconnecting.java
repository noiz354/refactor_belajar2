package norman.uva;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Vector;

import norman.template.template;
import norman.template.template_utility;

/**
 * not totally right
 * @author m.normansyah
 *
 */
public class Reconnecting  extends template {
	
	List<ArrayList<Pair>> AdjList;
	List<Boolean> taken;
	PriorityQueue<PairThird> pq; 

	public Reconnecting() {
		super("Reconnecting", "Reconnecting", LINUX);
	}
	
	@Override
	public void doSomething() {
		int count = 0;
		A:while(true){
			count++;
//			System.out.println(count++);
			if(!getInput().hasNext())
				break A;
			
			if(count>1){
				System.out.println();
			}
			
			int N = getInput().nextInt();
			int old_cost = 0;
			
			AdjList = new ArrayList <ArrayList<Pair>> ();
			for(int i=0;i<N;i++){
				AdjList .add(new ArrayList<>());
			}
			List<PairThird> EdgeList = new ArrayList<PairThird>();
			
			PairThird[] pts = new PairThird[N-1];
			for(int a=0;a<pts.length;a++){
				PairThird pairthird = new PairThird();
				pairthird.b.b = getInput().nextInt()-1;
				pairthird.b.c = getInput().nextInt()-1;
				pairthird.a = getInput().nextInt();
				
				pts[a] = pairthird;
				old_cost += pairthird.a;
			}
			
			int K = getInput().nextInt();
			PairThird[] ks = new PairThird[K];
			for(int b=0;b<ks.length;b++){
				PairThird pairthird = new PairThird();
				pairthird.b.b = getInput().nextInt()-1;
				pairthird.b.c = getInput().nextInt()-1;
				pairthird.a = getInput().nextInt();
				
				ks[b] = pairthird;
				EdgeList.add(pairthird);
				AdjList.get(pairthird.b.b).add(new Pair(pairthird.b.c, pairthird.a));
				AdjList.get(pairthird.b.c).add(new Pair(pairthird.b.b, pairthird.a));
			}
			
			int M = getInput().nextInt();
			PairThird[] ms = new PairThird[M];
			for(int c=0;c<ms.length;c++){
				PairThird pairthird = new PairThird();
				pairthird.b.b = getInput().nextInt()-1;
				pairthird.b.c = getInput().nextInt()-1;
				pairthird.a = getInput().nextInt();
				
				ms[c] = pairthird;
				EdgeList.add(pairthird);
				AdjList.get(pairthird.b.b).add(new Pair(pairthird.b.c, pairthird.a));
				AdjList.get(pairthird.b.c).add(new Pair(pairthird.b.b, pairthird.a));
			}
			
			Collections.sort(EdgeList);
			
//			String result = "";
//			for(PairThird pt : EdgeList){
//				result += pt +"\n";
//				System.out.println(pt);
//			}
//			template_utility.print(getOutput(), result+"", true);// print to a file
			
			int mst_cost = 0;           // all V are disjoint sets at the beginning
		    UnionFind UF = new UnionFind(M+K);
		    for (int i = 0; i < EdgeList.size(); i++) {                   // for each edge, O(E)
		    	PairThird front = EdgeList.get(i);
		      if (!UF.isSameSet(front.b.b, front.b.c)) {          // check
		        mst_cost += front.a;            // add the weight of e to MST
		        UF.unionSet(front.b.b, front.b.c);            // link them
		    } }
		    System.out.printf("%d\n", old_cost);
		    System.out.printf("%d\n", mst_cost);

		    // note: the number of disjoint sets must eventually be 1 for a valid MST
//		    System.out.printf("MST cost = %d (Kruskal's)\n", mst_cost);
			
			
//			taken = new Vector<Boolean>(); // global boolean flag to avoid cycle
//			pq = new PriorityQueue<PairThird>(); // priority queue to help choose shorter
//			
//			// inside int main() --- assume the graph is stored in AdjList, pq is empty
//		    for (int i = 0; i < V; i++)
//		      taken.add(false);                // no vertex is taken at the beginning
//		    process(0);   // take vertex 0 and process all edges incident to vertex 0
//		    mst_cost = 0;
//		    while (!pq.isEmpty()) { // repeat until V vertices (E=V-1 edges) are taken
//		      IntegerPair front = pq.peek(); pq.poll();
//		      u = front.second(); w = front.first();   // no need to negate id/weight
//		      if (!taken.get(u)) {           // we have not connected this vertex yet
//		        mst_cost += w;
//		        process(u); // take u, process all edges incident to u
//		      }
//		    }                                        // each edge is in pq only once!
//		System.out.printf("MST cost = %d (Prim's)\n", mst_cost);
		    // TODO Prim Algorithm - 
			
//			if(count ==2){
//				break A;
//			}
		}
	}
	
	class Pair implements Comparable<Pair>{

		public int b = -1,c = -1;

		public Pair(int b, int c) {
			super();
			this.b = b;
			this.c = c;
		}
		
		public Pair(){}

		@Override
		public int compareTo(Pair o) {
			if(!(this.b==o.b)){
				return this.b - o.b;
			}else{
				return this.c - o.c;
			}
		}

		@Override
		public String toString() {
			return "Pair [b=" + (b+1) + ", c=" + (c+1) + "]";
		}
	}
	
	class PairThird implements Comparable<PairThird>{
		public int a = -1;
		public Pair b = new Pair();
		private Reconnecting getOuterType() {
			return Reconnecting.this;
		}
		@Override
		public int compareTo(PairThird o) {
			if(!(this.a==o.a)){
				return this.a - o.a;
			}else{
				return this.b.compareTo(o.b);
			}
		}
		@Override
		public String toString() {
			return "PairThird [a=" + a + ", b=" + b + "]";
		}
		
		
	}
	
	// Union-Find Disjoint Sets Library written in OOP manner, using both path compression and union by rank heuristics
	class UnionFind {                                              // OOP style
	  private Vector<Integer> p, rank, setSize;
	  private int numSets;

	  public UnionFind(int N) {
	    p = new Vector<Integer>(N);
	    rank = new Vector<Integer>(N);
	    setSize = new Vector<Integer>(N);
	    numSets = N;
	    for (int i = 0; i < N; i++) {
	      p.add(i);
	      rank.add(0);
	      setSize.add(1);
	    }
	  }

	  public int findSet(int i) { 
	    if (p.get(i) == i) return i;
	    else {
	      int ret = findSet(p.get(i)); p.set(i, ret);
	      return ret; } }

	  public Boolean isSameSet(int i, int j) { return findSet(i) == findSet(j); }

	  public void unionSet(int i, int j) { 
	    if (!isSameSet(i, j)) { numSets--; 
	    int x = findSet(i), y = findSet(j);
	    // rank is used to keep the tree short
	    if (rank.get(x) > rank.get(y)) { p.set(y, x); setSize.set(x, setSize.get(x) + setSize.get(y)); }
	    else                           { p.set(x, y); setSize.set(y, setSize.get(y) + setSize.get(x));
	                                     if (rank.get(x) == rank.get(y)) rank.set(y, rank.get(y) + 1); } } }
	  public int numDisjointSets() { return numSets; }
	  public int sizeOfSet(int i) { return setSize.get(findSet(i)); }
	}

}
