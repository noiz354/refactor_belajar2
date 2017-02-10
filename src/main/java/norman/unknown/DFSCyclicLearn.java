package norman.unknown;

import norman.template.Template;

import java.util.ArrayList;
import java.util.List;

/**
 * 
 * @author m.normansyah 09_10_2015
 * no self-loops atau parallel edges ? not understand yet
 */
public class DFSCyclicLearn extends Template {

	boolean hasCycle;
	List<List<Integer>> adjList;
	boolean[] visited;

	public DFSCyclicLearn() {
		super("DFSCyclicLearn", "DFSCyclicLearn", WINDOWS);
	}

	@Override
	public void doSomething() {
		visited = new boolean[5];
		adjList = new ArrayList<>();
		for(int i=0;i<visited.length;i++){
			adjList.add(new ArrayList<Integer>());
		}
		int NEdge = getInput().nextInt();
		for(int i=0;i<NEdge;i++){
			adjList.get(getInput().nextInt()).add(getInput().nextInt());
		}

		// print adjacency list
//		for(int i=0;i<visited.length;i++){
//			System.out.println(adjList.get(i));
//		}

		dfs(0, 0);
		System.out.println("punya cyclic : "+hasCycle);

	}

	void dfs(int c, int u) {
		System.out.println("c "+c+" u "+u);
		visited[c] = true;
		for(int i=0;i<adjList.get(c).size();i++){
			if(!visited[adjList.get(c).get(i)]){
				System.out.println("baru visit "+adjList.get(c).get(i)+" prev "+c);
				dfs(adjList.get(c).get(i), c);
			}else if( u != adjList.get(c).get(i)){
				hasCycle = true;
			}
		}
	}
}
