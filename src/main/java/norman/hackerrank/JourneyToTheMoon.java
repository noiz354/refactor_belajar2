package norman.hackerrank;

import java.util.ArrayList;
import java.util.List;

import norman.template.template;
import norman.template.template_utility;

/**
 * 
 * @author m.normansyah 28-9-2015
 * https://www.hackerrank.com/challenges/journey-to-the-moon
 * jumlah anggota dari componentnya perlu diperbaiki
 */
public class JourneyToTheMoon extends template {

	public JourneyToTheMoon() {
		super("JourneyToTheMoon", "JourneyToTheMoon", WINDOWS);
	}

	@Override
	public void doSomething() {
		int N = getInput().nextInt();
		int I = getInput().nextInt();
		
		id = new int[N];
		marked = new boolean[N];
		adjList = new ArrayList<List<Integer>>();
		for(int i=0;i<N;i++){
			adjList.add(new ArrayList<Integer>());
		}
		
		compCount3 = new int[100_000];
		
		for(int i=0;i<I;i++){
			int x = getInput().nextInt();
			int y = getInput().nextInt();
			adjList.get(x).add(y);
			adjList.get(y).add(x);
		}
		
		for(int i=0;i<N;i++){
			if(!marked[i]){
				compCount2 = 0;
				dfs(i);
				compCount3[count] = compCount2;
				count++;
			}
		}
		
		long combination = 0;
		for(int i=0;i<count;i++){
			for(int j=i+1;j<count;j++){
				combination += compCount3[i]*compCount3[j];//(compCount.get(i)*compCount.get(j));
			}
		}
		
		template_utility.print(getOutput(), combination+"", true);
	}
	
	void dfs(int v){
//		System.out.println("v "+v+" adjList : "+adjList.get(v));
		marked[v] = true;
		compCount2++;
		id[v] = count;
		for(int w : adjList.get(v)){
//			System.out.println("w "+ w);
			if(!marked[w]){
				dfs(w);
			}
		}
	}
	
	List<List<Integer>> adjList;
	boolean[] marked;
	int[] id;
	int count;
	int compCount2;
	int[] compCount3;
}
