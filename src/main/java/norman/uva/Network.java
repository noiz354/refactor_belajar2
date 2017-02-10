package norman.uva;

import norman.template.Template;

import java.util.ArrayList;
import java.util.List;

/**
 * uva 315
 * @author m.normansyah
 *
 */
public class Network extends Template {

	private static final int UNVISITED = 0;
	private static final int EXPLORED = 1;
	private static final int VISITED = 2;
	
	List<List<Integer>> adjList;
	int[] dfs_num, dfs_low, dfs_parent;
	boolean[] articulation_vertex;
	int dfsNumberCounter, dfsRoot, rootChildren, enterArticulation;

	public Network() {
		super("Network", "Network", LINUX);
	}

	@Override
	public void doSomething() {
		int count = 0;
		A: while(true){
			count++;
			
			int N = getInput().nextInt();
			
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
			
			if(N == 0){
				break A;
			}
			
			B:while(true){
				String temp = getInput().nextLine();
				
				if(temp.equals("0"))
					break B;
				
				String temp2[] = temp.split(" ");
				
				int u = -1 ;
				if(!temp2[0].equals("")){
					u = Integer.parseInt(temp2[0])-1;
					for(int i=1;i<temp2.length;i++){
						int v = Integer.parseInt(temp2[i])-1;
						adjList.get(u).add(v);
						adjList.get(v).add(u);
					}
				}
				
				// wrong adding adjlist 
//				for(int b=0;b<=temp2.length-2;b++){
//					int u = Integer.parseInt(temp2[b])-1;
//					int v = Integer.parseInt(temp2[b+1])-1;
//					if(!adjList.get(u).contains(v))
//						adjList.get(u).add(v);
//					
//					if(!adjList.get(v).contains(u))
//						adjList.get(v).add(u);
//				}
			}
			
			printAdjList();
			
			System.out.println("Bridges:");
			for(int i=0;i<N;i++){
				if(dfs_num[i] == UNVISITED){
					dfsRoot =i;
					rootChildren = 0;
					articulationPointAndBridge(i);
					articulation_vertex[dfsRoot] = (rootChildren > 1);
				}
			}
			System.out.println("Articulation Point:");
			int critical = 0;
			for(int i =0;i<N;i++){
				if(articulation_vertex[i]){
					System.out.println("Vertex "+i);
					critical++;
				}
			}
			System.out.println(critical);
			System.out.println(enterArticulation);
			
			
			//[START] This is for testing
			if(count>=3)
				break A;
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
					System.out.println("[v] "+v+" "+dfs_low[v]+" [u] "+u+" "+dfs_num[u]);
					enterArticulation++;
					articulation_vertex[u] = true;// store this info first
				}
				if(dfs_low[v] > dfs_num[u])// for bridge
					System.out.printf("Edge (%d,%d) is a bridge\n", u,v);
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

}
