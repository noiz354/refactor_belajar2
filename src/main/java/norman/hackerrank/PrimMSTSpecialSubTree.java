package norman.hackerrank;

import norman.template.Template;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Vector;

public class PrimMSTSpecialSubTree extends Template {

	List<ArrayList<Pair>> AdjList;

	public PrimMSTSpecialSubTree() {
		super("PrimMSTSpecialSubTree", "PrimMSTSpecialSubTree", LINUX);
	}

	@Override
	public void doSomething() {
		A:while(true){
			if(!getInput().hasNext())
				break A;
			
			int N = getInput().nextInt();
			int E = getInput().nextInt();
			
			AdjList = new ArrayList <ArrayList<Pair>> ();
			for(int i=0;i<N;i++){
				AdjList .add(new ArrayList<>());
			}
			List<PairThird> EdgeList = new ArrayList<PairThird>();
			
			
			for(int b=0;b<E;b++){
				PairThird pairthird = new PairThird();
				pairthird.b.b = getInput().nextInt()-1;
				pairthird.b.c = getInput().nextInt()-1;
				pairthird.a = getInput().nextInt();
				
				EdgeList.add(pairthird);
			}
			
			int start_point = getInput().nextInt();
			
			Collections.sort(EdgeList);
			
			int mst_cost = 0;           // all V are disjoint sets at the beginning
		    UnionFind UF = new UnionFind(N);
		    for (int i = 0; i < EdgeList.size(); i++) {                   // for each edge, O(E)
		    	PairThird front = EdgeList.get(i);
		      if (!UF.isSameSet(front.b.b, front.b.c)) {          // check
		        mst_cost += front.a;            // add the weight of e to MST
		        UF.unionSet(front.b.b, front.b.c);            // link them
		    } }
		    System.out.printf("%d\n", mst_cost);
		}

	}
	
	// Union-Find Disjoint Sets Library written in OOP manner, using both path compression and union by rank heuristics
	public static class UnionFind {                                              // OOP style
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
			if (!isSameSet(i, j)) {
				numSets--;
				int x = findSet(i), y = findSet(j);
				// rank is used to keep the tree short
	    if (rank.get(x) > rank.get(y)) { p.set(y, x); setSize.set(x, setSize.get(x) + setSize.get(y)); }
	    else                           { p.set(x, y); setSize.set(y, setSize.get(y) + setSize.get(x));
	                                     if (rank.get(x) == rank.get(y)) rank.set(y, rank.get(y) + 1); } } }
	  public int numDisjointSets() { return numSets; }
	  public int sizeOfSet(int i) { return setSize.get(findSet(i)); }
	}

	class Pair implements Comparable<Pair> {

		public int b = -1, c = -1;

		public Pair(int b, int c) {
			super();
			this.b = b;
			this.c = c;
		}

		public Pair() {
		}

		@Override
		public int compareTo(Pair o) {
			if (!(this.b == o.b)) {
				return this.b - o.b;
			} else {
				return this.c - o.c;
			}
		}

		@Override
		public String toString() {
			return "Pair [b=" + (b + 1) + ", c=" + (c + 1) + "]";
		}
	}

	class PairThird implements Comparable<PairThird> {
		public int a = -1;
		public Pair b = new Pair();

		@Override
		public int compareTo(PairThird o) {
			if (!(this.a == o.a)) {
				return this.a - o.a;
			} else {
				return this.b.compareTo(o.b);
			}
		}

		@Override
		public String toString() {
			return "PairThird [a=" + a + ", b=" + b + "]";
		}


	}

}
