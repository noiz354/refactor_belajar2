import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;


/**
 * hackerrank submit template
 * @author M. Normansyah
 * 2:56:28 PM
 */
public class Solution {


    public static void main(String[] args) throws IOException{
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
		System.out.println(combination);
    }   

    static void dfs(int v){
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
	
	static List<List<Integer>> adjList;
	static boolean[] marked;
	static int[] id;
	static int count;
	static int compCount2;
	static int[] compCount3;
    
	// setup below here
	static Scanner input = new Scanner(System.in);
	
	public static Scanner getInput() {
		return input;
	}
}