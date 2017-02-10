package norman.uva;

import norman.template.Template;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author M Normansyah (m.normansyah@samsung.com)
 * started at 18-3-2015,
 * modified at 20-3-2015, using sacheem answer
 * default DFS unable to solve the problem, visited flag need to reset after used
 */
public class TheSettler extends Template {

	boolean visited[][];
	boolean visited2[];

	public TheSettler() {
		super("TheSettler", "TheSettler", LINUX);
	}

	private static void dfs_rec(List<List<Integer>> adjLists, boolean[] visited, int v, int move) {
		visited[v] = true;
		System.out.print(v + " ");
		int jumlah_tetangga = 0;
		for (int w : adjLists.get(v)) {
			if (!visited[w]) {
				dfs_rec(adjLists, visited, w, ++move);
				jumlah_tetangga++;
			}
		}

		System.out.println("jumlah tetangga " + jumlah_tetangga);
		if (jumlah_tetangga == 0) {
			System.out.println("move " + move);
		}
	}

	@Override
	public void doSomething() {
		A: while(true){
			int numberOfVertices = getInput().nextInt();
			int numberOfEdges = getInput().nextInt();
//			System.out.println(numberOfVertices+","+numberOfEdges);
			if(numberOfVertices ==0 && numberOfEdges ==0){
				break A;
			}
			if(!getInput().hasNext()){
				break A;
			}
			List<List<Integer>> adjList = new ArrayList<List<Integer>>(numberOfVertices);

			for(int i=0;i<numberOfVertices;i++){
				adjList.add(i, new ArrayList<Integer>());
			}

			for(int i=0;i<numberOfEdges;i++){
				int firstElement = getInput().nextInt();
				int secondElement = getInput().nextInt();
//				System.out.println(firstElement+","+secondElement);

				// for first element
				List<Integer> temp = adjList.get(firstElement);
				temp.add(secondElement);
				adjList.set(firstElement, temp);

				// for second element
				temp = adjList.get(secondElement);
				temp.add(firstElement);
				adjList.set(secondElement, temp);
			}

			// check input
			for(int i=0;i<adjList.size();i++){
				System.out.println(i+","+adjList.get(i));
			}


			// OLD CODE NOT WORKING, ORDINARY DFS CANNOT SOLVE THIS PROBLEMS.
//			dfs(adjList, 0);
//			System.out.println();
//			dfs(adjList, 1);
//			System.out.println();
//			dfs(adjList, 9);

			int ans = 0;
			for(int i=0;i<numberOfVertices;i++){
				ans = Math.max(ans, dfs(adjList, i));
			}
			System.out.println(ans);
		}
	}

	private int dfs_rec(List<List<Integer>> adjLists, int v){
		int cmax = 0;
		System.out.println("enter index : "+ v);
		for(int i=0;i<adjLists.get(v).size();i++){
			if(!visited[v][adjLists.get(v).get(i)]){
				visited[v][adjLists.get(v).get(i)] =  visited[adjLists.get(v).get(i)][v] = true;
				cmax = Math.max(cmax, 1 + dfs_rec(adjLists, adjLists.get(v).get(i)));
				visited[v][adjLists.get(v).get(i)] =  visited[adjLists.get(v).get(i)][v] = false;
			}
		}
		System.out.println("leave index : "+ v+" cmax : "+cmax);
		return cmax;
	}

	private int dfs_rec2(List<List<Integer>> adjLists, int v){
		int cmax = 0;
		System.out.println("enter index : "+ v);
		for(int i=0;i<adjLists.get(v).size();i++){
			if(!visited2[v]){
				visited2[v] = true;
				cmax = Math.max(cmax, 1 + dfs_rec2(adjLists, adjLists.get(v).get(i)));
				visited2[v] = false;
			}
		}
		System.out.println("leave index : "+ v+" cmax : "+cmax);
		return cmax;
	}

    // Usually dfs_rec() would be sufficient. However, if we don't want to pass
    // a boolean array to our function, we can use another function dfs().
    // We only have to pass the adjacency list and the source node to dfs(),
    // as opposed to dfs_rec(), where we have to pass the boolean array additionally.
//    public static void dfs(List<List<Integer>> adjLists, int s){
//        int n = adjLists.size();
//        boolean[] visited = new boolean[n];
//        dfs_rec(adjLists, visited, s, 0);
//    }

    public int dfs(List<List<Integer>> adjLists, int s){
        int n = adjLists.size();

        // with case 1
        visited2 = new boolean[n];
        return dfs_rec2(adjLists, s);

        // with case 2
//        visited = new boolean[30][30];
//        return dfs_rec(adjLists, s);
    }

}
