package norman.hackerrank;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import norman.template.template;
import norman.template.template_utility;

public class ShortestReach extends template {

	public ShortestReach() {
		super("ShortestReach", "ShortestReach", WINDOWS);
	}

	@Override
	public void doSomething() {
		int tC = getInput().nextInt();
		for(int i=0;i<tC;i++){
			int N = getInput().nextInt();
			int M = getInput().nextInt();
			adjList = new ArrayList<List<Integer>>();
			for(int j=0;j<N;j++){
				adjList.add(new ArrayList<Integer>());
			}
			visited = new boolean[N];
			connected = new int[N];
			distTo = new int[N];
			Arrays.fill(connected, -1);
			for(int j=0;j<M;j++){
				int x = getInput().nextInt()-1;
				int y = getInput().nextInt()-1;
				adjList.get(x).add(y);
				adjList.get(y).add(x);
			}
			// print adjacency list 
//			for(int j=0;j<N;j++){
//				System.out.println(j+" "+adjList.get(j));
//			}
			int S = getInput().nextInt()-1;
			bfs(S);
			// print parent-child connection
//			for(int j=0;j<connected.length;j++){
//				System.out.println("parent "+connected[j]+" child "+j);
//			}
			for(int j=0;j<distTo.length;j++){
				if(j!=S){
					if(distTo[j] == 0){
						template_utility.print(getOutput(), "-1 ", false);
					}else{
						template_utility.print(getOutput(), distTo[j]*6+" ", false);
					}
				}
			}
			template_utility.print(getOutput(), "", true);
		}
	}
	
	void bfs(int S){
		Queue<Integer> queue = new LinkedList<Integer>();
		queue.add(S);
		visited[S] = true;
		while(!queue.isEmpty()){
			int node = queue.remove();
//			System.out.println("node "+node);
			for(int child : adjList.get(node)){
//				System.out.println("parent "+node+" child "+child+" visited "+visited[child]);
				if(!visited[child]){
					connected[child] = node;// connected[child] = parent
					visited[child] = true;
					distTo[child] = distTo[node] + 1;
					queue.add(child);
				}
			}
		}
	}
	
	List<List<Integer>> adjList;
	boolean visited[];
	int connected[];
	int distTo[]; // jarak dari sumber ke tujuan
}
