package norman.uva;

import norman.template.Template;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CriticalLinks extends Template {

    private static final int UNVISITED = 0;
    private static final int EXPLORED = 1;
	private static final int VISITED = 2;
	
	List<List<Integer>> adjList;
	List<Pair> result;
	int[] dfs_num, dfs_low, dfs_parent;
	boolean[] articulation_vertex;
	int dfsNumberCounter, dfsRoot, rootChildren, enterArticulation;

	public CriticalLinks() {
		super("CriticalLinks", "CriticalLinks", LINUX);
	}

	@Override
	public void doSomething() {
		int count = 0;
		A: while(true){
			if(!getInput().hasNext()){
				System.out.println();
				break A;
			}
			count++;
			
			if(count>1){
				System.out.println();
			}
			
			int N = getInput().nextInt();
			
			result = new ArrayList<>();
			
			if(N==0){
				System.out.printf("%d critical links\n", result.size());
				continue;
			}
			
			dfs_num = new int[N];
			dfs_low = new int[N];
			dfs_parent = new int[N];
			articulation_vertex = new boolean[N];
			
			
			adjList = new ArrayList<>();
			for(int a=0;a<N;a++){
				adjList.add(new ArrayList<>());
				
				dfs_num[a] = UNVISITED;
				dfs_low[a] = 0;
				dfs_parent[a] = -1;
				articulation_vertex[a] = false;
			}
			dfsNumberCounter = 0;
			enterArticulation = 0;
			
			getInput().nextLine();
			
			for(int a=0;a<N;a++){
				String temp = getInput().nextLine();
				String temp2[] = temp.split(" ");
				
				int u = Integer.parseInt(temp2[0]);
				int length = Integer.parseInt(temp2[1].replace("(", "")
						.replace(")", "").trim());
				for(int b=0;b<length;b++){
					int v = Integer.parseInt(temp2[2+b]);
					
					adjList.get(u).add(v);
				}
			}
			
//			printAdjList();
			
//			System.out.println("Bridges:");
			for(int i=0;i<N;i++){
				if(dfs_num[i] == UNVISITED){
					dfsRoot =i;
					rootChildren = 0;
					articulationPointAndBridge(i);
					articulation_vertex[dfsRoot] = (rootChildren > 1);
				}
			}
//			System.out.println("Articulation Point:");
			int critical = 0;
			for(int i =0;i<N;i++){
				if(articulation_vertex[i]){
//					System.out.println("Vertex "+i);
					critical++;
				}
			}
//			System.out.println(critical);
//			System.out.println(enterArticulation);
			
			System.out.printf("%d critical links\n", result.size());
			
			Collections.sort(result);
			for (Pair p : result) {
//				System.out.printf("%d - %d\n", Math.min(p.b, p.c), Math.max(p.b, p.c));
				System.out.printf("%d - %d\n", p.b, p.c);
			}
			
//			if(count>=1){
//				break A;
//			}
		}
	}
	
	void articulationPointAndBridge(int u){
		dfs_low[u] = dfs_num[u] = ++dfsNumberCounter;
		for(int j=0;j<adjList.get(u).size();j++){
			int v = adjList.get(u).get(j);
			
			if(dfs_num[v]==UNVISITED){
				dfs_parent[v] = u;
				
				if(u == dfsRoot){// special case if 
					rootChildren++;
				}
				
				articulationPointAndBridge(v);
				
				if(dfs_low[v] >= dfs_num[u]){// for articulation point
//					System.out.println("[v] "+v+" "+dfs_low[v]+" [u] "+u+" "+dfs_num[u]);
					enterArticulation++;
					articulation_vertex[u] = true;// store this info first
				}
				if(dfs_low[v] > dfs_num[u])// for bridge
					{
//					System.out.printf("Edge (%d,%d) is a bridge\n", u,v);
						result.add(new Pair(Math.min(u, v), Math.max(u, v)));
					}
				dfs_low[u] = Math.min(dfs_low[u], dfs_low[v]);// update dfs_low[u]
			}else if(v != dfs_parent[u]){// a back edge and not direct cycle
				dfs_low[u] = Math.min(dfs_low[u], dfs_num[v]);// update dfs_low[u]
			}
		}
	}
	
	private void printAdjList(){
		for(int i=0;i<adjList.size();i++){
			System.out.println(i+" "+adjList.get(i));
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
			}
			else{
				return this.c - o.c;
			}
		}

		@Override
		public String toString() {
			return "Pair [b=" + (b+1) + ", c=" + (c+1) + "]";
		}
	}

}
