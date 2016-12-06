

import java.io.*;
import java.util.*;

import static java.lang.Math.max;
import static java.lang.Math.sqrt;

class Main {

	public static void main(String[] args) throws IOException {
		new Main().go();
	}

	void go() throws IOException {
		Reader.init(System.in);
		String s = getInput().nextLine();
		int T = Integer.parseInt(s);
		// read blank line
		getInput().nextLine();

		while(T-->0){
			adjList = new HashMap<>();
			visited = new HashMap<>();

			while(true){
				String dic = getInput().nextLine();
//            println(dic);
				if(dic.equals("*"))
					break;

				List<String> adj = null;
				if(adjList.get(dic)!=null){
					adj = adjList.get(dic);
				}else{
					adj = new ArrayList<>();
					adjList.put(dic, adj);
				}

				Iterator<String> it = adjList.keySet().iterator();
				while(it.hasNext()){
					String key = it.next();
					if(dic.equals(key))
						continue;

					int diff = 0;
//                int length = dic.length() > key.length() ? key.length() : dic.length();
					if(dic.length() == key.length()){
						for(int i=0;i<dic.length();i++){
							if(key.charAt(i)!=dic.charAt(i)){
								diff++;
							}
						}

						if(diff == 1){
							List<String> adj2 = null;
							if(adjList.get(key)!=null){
								adj2 = adjList.get(key);
							}else{
								adj2 = new ArrayList<>();
								adjList.put(key, adj2);
							}

							adj.add(key);
							adjList.put(dic, adj);

							adj2.add(dic);
							adjList.put(key, adj2);
						}
					}
				}
			}

//            printAdjList();

			String line = getInput().nextLine();
			while(!line.equals("")){
				String[] q = line.split(" ");
//                println(Arrays.toString(q));

				initVisited();
//            visited.clear();
				System.out.println(q[0]+" "+q[1]+" "+bfs(q[0],q[1]));

				if(!getInput().hasNext())
					break;
				line = getInput().nextLine();
				if(line.equals("")){
					break;
				}
			}

			if(T!=0)
				System.out.println("");
		}
	}

	int bfs(String start, String to){
		Queue<String> s = new LinkedList<>();
		s.offer(start);
		visited.put(start, 0);
		while(!s.isEmpty()){
			String top = s.poll();
			if(top.equals(to))
				return visited.get(top);
			int total = adjList.get(top).size();
			for(int i=0;i<total;i++){
				if(visited.get(adjList.get(top).get(i))==0){
					visited.put(adjList.get(top).get(i), visited.get(top)+1);
					s.offer(adjList.get(top).get(i));
				}
			}
		}
		return visited.get(to);
	}

	void initVisited(){
		for(Iterator<String> it = adjList.keySet().iterator();it.hasNext();){
			String next = it.next();
			List<String> adj = adjList.get(next);
			visited.put(next, 0);
		}
	}

	Map<String, List<String>> adjList;
	Map<String, Integer> visited;

	/** Class for buffered reading int and double values */
	static class Reader {
		static BufferedReader reader;
		static StringTokenizer tokenizer;

		/** call this method to initialize reader for InputStream */
		static void init(InputStream input) {
			reader = new BufferedReader(
					new InputStreamReader(input) );
			tokenizer = new StringTokenizer("");
		}

		/** get next word */
		static String next() throws IOException {
			while ( ! tokenizer.hasMoreTokens() ) {
				//TODO add check for eof if necessary
				tokenizer = new StringTokenizer(
						reader.readLine() );
			}
			return tokenizer.nextToken();
		}

		static int nextInt() throws IOException {
			return Integer.parseInt( next() );
		}

		static double nextDouble() throws IOException {
			return Double.parseDouble( next() );
		}
	}

	BufferedReader reader;
	Reader getInput2(){
		reader = new BufferedReader(new InputStreamReader(System.in));
		return new Reader();
	}

	Scanner input;
	Scanner getInput() {
		if(input==null){
			input = new Scanner(System.in);
		}
		return input;
	}

}
