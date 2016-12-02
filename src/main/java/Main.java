
import java.util.*;

import static java.lang.Math.max;
import static java.lang.Math.sqrt;

class Main {
	public static void main(String[] args) {
		new Main().go();
	}

	void go() {
		int T = getInput().nextInt();// 1;
//		getInput().nextLine();
		for(int test=0;test<T;test++){
//		while(T-->=1){
//			System.out.println(T);

			characters = new ArrayList<>();
			adj = new LinkedList<>();

			while(getInput().hasNext("[A-Z]")){
				String character = "";
				character = getInput().next("[A-Z]");
//				System.out.println(character);
				characters.add(character.charAt(0));
			}

			vis = new HashMap<>();

			for(int i='A';i<'Z';i++){
				vis.put((char)i, false);
			}

			//[START] build adjacency list by reading input
//			for(Character c : characters){
			for(int i=0;i<='Z';i++){// 'A'
//				System.out.println(i);
				adj.add(new LinkedList<Character>());
			}
			//[END] build adjacency list by reading input

			String s = getInput().nextLine();
			String e = getInput().nextLine();
//			System.out.println(s+" "+e);

			String[] split = e.split(" ");
			for(String temp : split){
				System.out.println(temp);
				char from = temp.charAt(0);
				char to = temp.charAt(2);
//				System.out.println(from+" > "+ to);
				List<Character> setAgain = adj.get(from);// 'A'
				setAgain.add((char)(to));//-'A'
//				System.out.println(setAgain);
				adj.set(from-'A', setAgain);
			}

			if(!dfs("")){
				System.out.println("NO");
			}


		}
	}

	boolean dfs(String path){
//		printVisited();
//		System.out.println();
		if(path.length() == characters.size()){
			char c = path.charAt(0);
			System.out.print(c);
			for(int i=1;i<path.length();i++){
				System.out.print(" "+path.charAt(i));
			}
			System.out.println();
			return true;
		}
		boolean ans = false;
		for(int i=0;i<characters.size();i++){// iterate semua element.
			if(!vis.get(characters.get(i))){// check apakah sudah divisited atau belum ?
				if(valid(characters.get(i))){
					vis.put(characters.get(i), true);
//					printTab(path.length());
//					System.out.println("path "+ path
//							+" index "+i+" > i ="+(char)characters.get(i));
					ans = dfs(path+characters.get(i)) || ans;
					vis.put(characters.get(i), false);
				}
			}
		}
		return ans;
	}

	boolean valid(char e){
		// iterate semua yang berhubungan dengan e
		for(int i=0;i<adj.get(e).size();i++){
			// check apakah adj list member sudah ada yang ke visited.
			if(vis.get(adj.get(e).get(i)))
				return false;
		}
		return true;
	}

	List<Character> characters;
	List<List<Character>> adj;
	Map<Character, Boolean> vis;
	
	Scanner input;
	
	Scanner getInput() {
		if(input==null){
			input = new Scanner(System.in);
		}
		return input;
	}
	
}
