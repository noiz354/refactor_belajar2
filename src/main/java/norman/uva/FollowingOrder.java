package norman.uva;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import norman.template.template;

/**
 * 
 * @author m.normansyah
 * https://f0rth3r3c0rd.wordpress.com/2012/01/25/uva-124-following-orders/
 */
public class FollowingOrder extends template {
	
	final static int UNVISITED = -1, VISITED = 2;
	
	int[] dfs_num;
	List<List<Integer>> adjList;
	HashMap<String, Integer> map;
	HashMap<Integer, String> unmap;
	List<Integer> ts; // global vector to store topsort in reverse order

	public FollowingOrder() {
		super("FollowingOrder", "FollowingOrder", LINUX);
	}
	
	void dfs2(int u){
		dfs_num[u] = VISITED;
		for(int j=0;j<adjList.get(u).size();j++){
			int v = adjList.get(u).get(j);
			if(dfs_num[v] == UNVISITED){
				dfs2(v);
			}
		}
		ts.add(u);
	}

	@Override
	public void doSomething() {
		while(getInput().hasNext()){
			String[] symb = getInput().nextLine().split(" ");
			String[] cmp = getInput().nextLine().split(" ");
			
			ts = new ArrayList<>();
			
			dfs_num = new int[symb.length];
			for(int i=0;i<dfs_num.length;i++){
				dfs_num[i] = UNVISITED;
			}
			
			map = new HashMap<>();
			unmap = new HashMap<>();
			for(int i=0;i<symb.length;i++){
				map.put(symb[i], i);
				unmap.put(i, symb[i]);
			}
			
			adjList = new ArrayList<>();
			for(int i=0;i<symb.length;i++)
				adjList.add(new ArrayList<>());
					
			for(int i=0;i<cmp.length;i+=2){
				adjList
					.get(map.get(cmp[i]))
					.add(map.get(cmp[i+1]));
			}
			
			for(int i=0;i<symb.length;i++){
				if(dfs_num[i] == UNVISITED){
					dfs2(i);
				}
			}
			
			// read backwards
			for(int i=ts.size()-1;i>=0;i--){
				System.out.print(unmap.get(ts.get(i))+" ");
			}
			System.out.println();
		}
	}

}
