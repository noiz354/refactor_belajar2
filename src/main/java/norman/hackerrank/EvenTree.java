package norman.hackerrank;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Queue;

import norman.template.template;

public class EvenTree extends template {

	public EvenTree() {
		super("EvenTree", "EvenTree", LINUX);
	}

	@Override
	public void doSomething() {
//		usingTree();
		usingBreathFirstSearch();
	}

	private void usingBreathFirstSearch(){
		A: while(true){
			N = getInput().nextInt();
			M = getInput().nextInt();

			marked = new boolean[N];
			count = new int[N];
			Arrays.fill(count, 1);

			adjList = new ArrayList<List<Integer>>();
			for(int i=1;i<=N;i++){
				adjList.add(new ArrayList<Integer>());
			}

			for(int i=0;i<M;i++){
				int u1 = getInput().nextInt();
				int v1 = getInput().nextInt();
				adjList.get(u1-1).add(v1-1);
				adjList.get(v1-1).add(u1-1);
			}

			System.out.println("hasil adjacency list : "+adjList.size());
			for(int i=0;i<adjList.size();i++){
				System.out.println(adjList.get(i));
			}

			System.out.println("start processing !!");
			Queue<Integer> q = new ArrayDeque<>();
			marked[3] = true;
			q.offer(3);

			while(!q.isEmpty()){
				int v = q.poll();
				for(int w : adjList.get(v)){
					if(!marked[w]){
						marked[w] = true;
						count[v]++;
						q.offer(w);
					}
				}
			}

			System.out.println("count result : "+ Arrays.toString(count));

			if(!getInput().hasNext()){
				break A;
			}
		}
	}

	List<List<Integer>> adjList;
	boolean[] marked;

	/**
	 * using Tree Transversal
	 */
	private void usingTree() {
		A: while(true){
			N = getInput().nextInt();
			M = getInput().nextInt();

			tree = new int[N];
			count = new int[N];
			Arrays.fill(count, 1);

			for(int i=0;i<M;i++){
//			System.out.println("before processing : "+Arrays.toString(count)+" tree "+ Arrays.toString(tree));
				int u1 = getInput().nextInt();
				int v1 = getInput().nextInt();
//			System.out.println("child "+u1+" parent "+v1);

				tree[u1-1] = v1; // simpan parent simpan parent sementara
				count[v1-1] += count[u1-1]; // tambahkan count parent dari count child

				int root = tree[v1-1]; // ambil parent dari parent sementara
//			System.out.println("root "+root+" index(v1-1) "+(v1-1));

				while(root!=0){
					count[root-1] += count[u1-1];// tambahkan count childnya
					root = tree[root-1];
				}
//			System.out.println("after processing : "+Arrays.toString(count)+" tree "+ Arrays.toString(tree));
//			System.out.println();
			}


			int counter = -1;
			for(int i=0;i<count.length;i++){
				if(count[i]%2==0){
					counter++;
				}
			}
			System.out.println(counter);

			if(!getInput().hasNext()){
				break A;
			}
		}
	}

	int tree[];
	int count[];
	int N, M;
}
