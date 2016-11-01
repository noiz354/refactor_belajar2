package norman.uva;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import norman.template.template;

/**
 * 
 * @author m.normansyah
 * need to have memoized or something to optimize the code.
 * cannot memoized, instead
 * find cycle to reduce the search 
 * look at 
 * https://uva.onlinejudge.org/board/viewtopic.php?f=62&t=70778&hilit=12442
 * to know the algorithm. 
 * Need to switch to C, currently java not fast.
 */
public class ForwardingEmails extends template {

	public ForwardingEmails() {
		super("ForwardingEmails", "ForwardingEmails", WINDOWS);
	}

	@Override
	public void doSomething() {
		int T = getInput().nextInt();
		int total = T;
		while(T-- > 0){
			// start 1 - end N
			int N = getInput().nextInt();
			adjList = new ArrayList<>();
			Ks = new int[N+1];
			Arrays.fill(Ks, -1);
//			Collections.fill(adjList, new ArrayList<Integer>());
			for(int i=0;i<=N;i++){
				adjList.add(new ArrayList<Integer>());
			}
//			System.out.println(adjList.size());
			for(int i=1;i<=N;i++){
				int x = getInput().nextInt();
				int y = getInput().nextInt();
				adjList.get(x).add(y);
			}
//			for(int i=1;i<=N;i++){
//				System.out.println(i+" : "+adjList.get(i));
//			}
			

			int ans = 0, best_len = 0;
			visited = new boolean[N+1];
			for(int i=1;i<=N;i++){
//				visited = new boolean[N+1];
//				K = 0;
				if(Ks[i] == -1)
					go(i);
				if(Ks[i] > best_len){
					best_len = Ks[i];
					ans = i;
				}
//				System.out.println("i "+i+" K "+K);
			}
			
//			for(int i=1;i<Ks.length;i++){
//				System.out.print(Ks[i]+" ");
//			}
//			System.out.println();
			
			System.out.println("Case "+(total-T)+": "+(ans));
		}// end of while
	}
	
	int go(int i){
		visited[i]=true;
		int tot = 0;
		for(int j=1;j<=adjList.get(i).size();j++){
			if(!visited[adjList.get(i).get(j-1)]){
				tot += 1 + go(adjList.get(i).get(j-1));
			}
		}
		visited[i]=false;
		return Ks[i] = tot;
		
	}
	
	/*
	 * ini salah
	int go(int i){
		Ks[i] = 1;
		visited[i] = true;
		for(int j=1;j<=adjList.get(i).size();j++){
			if(!visited[adjList.get(i).get(j-1)]){
				Ks[i] += go(adjList.get(i).get(j-1));
			}
		}
		return Ks[i];
	}
	*/
	
	/*
	void go(int i){
		visited[i] = true;
//		System.out.println("cur : "+i);
		for(int j=1;j<=adjList.get(i).size();j++){
			if(!visited[adjList.get(i).get(j-1)]){
				++K;
				go(adjList.get(i).get(j-1));
			}
		}
	}
	*/
	
	List<List<Integer>> adjList;
	boolean visited[];
	int K;
	int[] Ks;
}
