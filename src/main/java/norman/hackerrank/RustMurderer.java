package norman.hackerrank;

import norman.template.Template;

import java.util.*;

/**
 * 
 * @author m.normansyah
 * started at 25-8-2015, selasa
 * https://www.hackerrank.com/challenges/rust-murderer
 * got 40.8 dari 50. ada salah kayaknya.
 */
public class RustMurderer extends Template {

	public RustMurderer() {
		super("RustMurderer", "RustMurderer", LINUX);
	}

    private static int[] getEdgelessMinDistances(final List<Set<Integer>> roads, final int origin, final int N) {

        //Initialize distances
        final int[] distances = new int[N];
        for (int i = 0; i < N; distances[i++] = -1) {
        }

        //Create a list of unvisited cities
        final List<Integer> unvisitedCities = new LinkedList<Integer>();
        for (int i = 0; i < origin; unvisitedCities.add(i++)) {
        }
        for (int i = origin; ++i < N; unvisitedCities.add(i)) {
        }

        //Find min distances
        final Queue<Integer> q = new LinkedList<Integer>();
        q.add(origin);
        do {
            final int city = q.poll();
            final int distance = ++distances[city];
            final Set<Integer> cityRoads = roads.get(city);
            for (Iterator<Integer> it = unvisitedCities.iterator(); it.hasNext(); ) {
                final int unvisitedCity = it.next();
                if (!cityRoads.contains(unvisitedCity)) {
                    distances[unvisitedCity] = distance;
                    it.remove();
                    q.add(unvisitedCity);
                }
            }
        } while (!q.isEmpty());

        return distances;
    }

    @Override
    public void doSomething() {
		int TC = getInput().nextInt();
		StringBuffer sb = new StringBuffer();
		for(int tc=0;tc<TC;tc++){
			final int N = getInput().nextInt();// jumlah node
			final int M = getInput().nextInt();// jumlah edge
			//Initialize edges
		      final List<Set<Integer>> roads = new ArrayList<Set<Integer>>(N);
		      for(int i = 0; i < N; ++i){
		        roads.add(new HashSet<Integer>());
		      }

		      //Get edges
		      for(int i=0;i<M;i++){
		    	  int xTemp = getInput().nextInt();
		    	  int yTemp = getInput().nextInt();
		        final int X = xTemp - 1;
		        final int Y = yTemp - 1;
		        roads.get(X).add(Y);
		        roads.get(Y).add(X);
		      }

		    //Get Rust's starting position and find min distances
		      final int S = getInput().nextInt() - 1;
		      final int[] minDistances = getEdgelessMinDistances(roads, S, N);

		      //Print output
		      for(int i = 0; i < S; sb.append(minDistances[i++] + " ")){}
		      for(int i = S; ++i < N; sb.append(minDistances[i] + " ")){}
		      sb.append("\n");

            System.out.println(sb);

//		      TemplateUtility.print(getOutput(), distTo[i]+" ", false);


		}
	}
	
	/*void oldWayComplementusingComplementGraph(){
        int TC = getInput().nextInt();
		for(int tc=0;tc<TC;tc++){
			N = getInput().nextInt();// jumlah node
			int M = getInput().nextInt();// jumlah edge
			adjMatrix = new int[N][N];
			visited = new boolean[N];
			distTo = new int[N];
			for(int i=0;i<N;i++){
				adjMatrix[i][i]= SELF;
			}
			for(int i=0;i<M;i++){
				int xTemp = getInput().nextInt();
				int yTemp = getInput().nextInt();
				adjMatrix[xTemp-1][yTemp-1] = CONNECTED;
				adjMatrix[yTemp-1][xTemp-1] = CONNECTED;
			}
			
			int S = getInput().nextInt()-1;
			bfs(S);
			for(int i=0;i<distTo.length;i++){
				if(i!=S)
					TemplateUtility.print(getOutput(), distTo[i]+" ", false);
			}
			TemplateUtility.print(getOutput(), "", true);
		}
	}
	
	void bfs(int S){
		Queue<Integer> queue = new LinkedList<Integer>();
		queue.add(S);
		visited[S] = true;
		while(!queue.isEmpty()){
			int node = queue.remove();
//			System.out.println("node "+node);
			for(int u=0;u<N;u++){
				if(adjMatrix[node][u] == DISCONNECTED && visited[u] == false){
					queue.add(u);
					distTo[u] = distTo[node] + 1;
					visited[u] = true;
				}
			}
		}
	}

	final static int SELF = 1, CONNECTED = 2, DISCONNECTED = 0;
	int[][] adjMatrix;
	boolean visited[];
	int N;
	int distTo[]; // jarak dari sumber ke tujuan
	*/
}
