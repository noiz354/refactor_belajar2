package norman.uva;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import norman.template.template;

/**
 * 
 * @author m.normansyah
 * uva 872 
 */
public class Ordering extends template {
	List<Character> characters;
	List<List<Character>> adj;
	Map<Character, Boolean> vis;

	public Ordering() {
		super("Ordering", "Ordering", LINUX);		
	}

	@Override
	public void doSomething() {
		int T = 1;//getInput().nextInt();
		getInput().nextLine();
		while(T-->0){
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
			
			String test = getInput().nextLine();
//			String next = getInput().nextLine();
//			System.out.println(test);// +" : "+next
			
			while(getInput().hasNext("[A-Z]<[A-Z]")){
				String temp = "";
				temp +=getInput().next("[A-Z]<[A-Z]");
//				System.out.println(temp);
				char from = temp.charAt(0);
				char to = temp.charAt(2);
//				System.out.println(from+" > "+ to);
				List<Character> setAgain = adj.get(from);// 'A'
				setAgain.add((char)(to));//-'A'
//				System.out.println(setAgain);
				adj.set(from-'A', setAgain);
			}
			
			print(adj);
			
			dfs("");
			
//			String alphabet = getInput().nextLine();
//			String constraint = getInput().nextLine();
//			getInput().next();
//			System.out.println(alphabet +" "+constraint);
		}
	}
	
	void dfs(String path){
		printVisited();
		System.out.println();
		if(path.length() == characters.size()){
			System.out.println(path);
			return;
		}
		for(int i=0;i<characters.size();i++){// iterate semua element. 
			if(!vis.get(characters.get(i))){// check apakah sudah divisited atau belum ? 
				if(valid(characters.get(i))){
					vis.put(characters.get(i), true);
					System.out.println("path "+ path
							+" index "+i+" > i ="+(char)characters.get(i));
					dfs(path+characters.get(i));
					vis.put(characters.get(i), false);
				}
			}
		}
	}
	
	void printVisited(){
		for(int i=0;i<characters.size();i++){
			System.out.print(vis.get(characters.get(i))+" ");
			// (char)characters.get(i)+" visited : "+
		}
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
	
	void print(List<List<Character>> adjList){
		for(int i='A';i<='Z';i++){
//			for(int j=0;j<adjList.get(i).size(); j++){
				System.out.print(adjList.get(i)+" ");
//			}
			System.out.println((char)i);
		}
	}

}
