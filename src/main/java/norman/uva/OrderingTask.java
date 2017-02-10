package norman.uva;

import norman.template.Template;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.Stack;

public class OrderingTask extends Template {

	LinkedList<Integer> adj[]; // Adjacency List
	Stack<Integer> stack;
	boolean[] visited;

	public OrderingTask() {
		super("OrderingTask", "OrderingTask", LINUX);
	}

	@Override
	public void doSomething() {
		A: while(true){
			int n = getInput().nextInt();// jumlah vertices
			int m = getInput().nextInt();// jumlah edges yang ingin dibaca.
//			System.out.println(n+" :"+m);

			if(n==0&&m==0){
				break A;
			}

			// this way to create array of linkedlist
			stack = new Stack<>();
			adj = new LinkedList[n + 1];
			visited = new boolean[n + 1];
			for (int i = 1; i < n+1; i++)
	            visited[i] = false;

			for (int i = 0; i < adj.length; i++) {
				adj[i] = new LinkedList<>();
			}
			// this way to create array of linkedlist

			for (int i = 0; i < m; i++) {
				int from = getInput().nextInt();
				int to = getInput().nextInt();
//				System.out.println(from+" : "+to);
				adj[from].add(to);
			}

			for (int i = 1; i < n + 1; i++) {
				if(visited[i]==false)
					topoSort(i);
			}

			while (stack.empty() == false)
				System.out.print(stack.pop() + " ");
			System.out.println();
		}

	}

	void topoSort(int x) {
		visited[x] = true;
		int i;

		Iterator<Integer> it = adj[x].iterator();
		while(it.hasNext()){
			i = it.next();
			if(!visited[i])
				topoSort(i);
		}

		stack.push(new Integer(x));
	}

}
