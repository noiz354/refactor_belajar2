package norman.uva;

import java.util.ArrayList;
import java.util.List;

import norman.template.template;
import norman.template.template_utility;

/**
 * https://uva.onlinejudge.org/external/2/280.pdf
 * @author Normansyah Putra
 *
 */
public class Vertex extends template {

	public Vertex() {
		super("Vertex", "Vertex", WINDOWS);
	}

	@Override
	public void doSomething() {
		int v = getInput().nextInt();// number of vertices
		adjList = new ArrayList<>();
		for(int i=0;i<v;i++){
			adjList.add(new ArrayList<Integer>());
		}
		
		int node, next;
		while((node = getInput().nextInt())>0){
			if(node == 0)
				break;
			while((next = getInput().nextInt())>0){
				if(next ==0)
					break;
				adjList.get(node-1).add(next-1);
			}
		}
		
		printAdjList();
		
		int q = getInput().nextInt();
		for(int i=0;i<q;i++){
			visited = new boolean[v];
			int sNode = getInput().nextInt();
			dfs(sNode-1);
			print();
		}
	}
	
	void print()
	{
		int notReach = 0;
		List<Integer> out = new ArrayList<>();
		for(int x=0;x<visited.length;x++){
			if(!visited[x]){
				notReach++;
				out.add(x+1);
			}
		}
		if(notReach==0)
			template_utility.print(getOutput(), "0", true);
		else
			template_utility.print(getOutput(), ""+notReach+" ", false);
		
		for(int x=0;x<out.size();x++){
			if(out.size()-1 == x)
				template_utility.print(getOutput(), ""+out.get(x), true);
			else
				template_utility.print(getOutput(), ""+out.get(x)+" ", false);
		}
	}
	
	void dfs(int node){
		int current;
		for(int x=0;x<adjList.get(node).size();x++){
			current = adjList.get(node).get(x);
			if(!visited[current]){
				visited[current] = true;
				dfs(current);
			}
		}
	}
	
	void wrongCode(){
		// solution by me, wrong way
				// problem was at
//				int tmp = getInput().nextInt();
//				if(tmp==0)
//					break;
				// after inner while true
				// because it read the input and let away that
				
//				do{
//					int count = 0, index_prnt = -1;
//					
//					while(true){
//						int tmp = getInput().nextInt();
//						if(tmp==0)
//							break;
//						if(count++ == 0)
//							index_prnt = tmp;
//						else
//							adjList.get(index_prnt).add(tmp);
//					}
//					int tmp = getInput().nextInt();
//					if(tmp==0)
//						break;
//				}while(true);
				// wrong way to read the input
	}
	
	void printAdjList(){
		for(int i=0;i<adjList.size();i++){
			System.out.println(i+ " : " + adjList.get(i));
		}
	}
	
	
	List<List<Integer>> adjList;
	boolean visited[];
}
