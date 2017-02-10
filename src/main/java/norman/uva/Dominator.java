package norman.uva;

import norman.template.Template;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * uva 11902
 * @author SRIN
 * started at 15-6-2015, too many PLM to look after, so slowly progress for this
 */
public class Dominator extends Template {

    List<List<Integer>> adjList;
    int adjN;
    boolean vis[];

	public Dominator() {
		super("Dominator", "Dominator", LINUX);
	}

	@Override
	public void doSomething() {
		int TC = getInput().nextInt();
		int cases = 0;
		while(TC-- > 0){
			adjN = getInput().nextInt();// Vertices size
			adjList = new ArrayList<List<Integer>>();
			vis = new boolean[100+3];
			for(int i=0;i<adjN;i++)
				adjList.add(new ArrayList<Integer>());

			for(int i=0;i<adjN;i++)
				for(int j=0;j<adjN;j++){
					if(getInput().nextInt() == 1){
						adjList.get(i).add(j);
						adjList.get(j).add(i);
					}
				}

//			System.out.println("print adjacency list : ");
//			for(int i=0;i<adjN;i++)
//				System.out.println(i+" "+adjList.get(i));

			boolean output[][] = new boolean[103][103];
			boolean firstVis[] = new boolean[100+3];

			Arrays.fill(vis, false);
			dfs(0, -1);
			for(int i=0;i<103;i++) firstVis[i] = vis[i];

			for(int i=0;i<adjN;i++){
				Arrays.fill(vis, false);
				dfs(0, i);// karena inputnya hanya <= 100 maka bisa di dfs terus-terusan
				for(int j=0;j<adjN;j++){
                    output[i][j] = firstVis[j] & !vis[j];
                }
                output[i][i] = firstVis[i];
			}

			System.out.println("Case "+(++cases)+":");
			printLine();// header
			for(int i=0;i<adjN;i++){
				for(int j=0;j<adjN;j++){
					if(j==0)
						System.out.print("|");
					System.out.print((output[i][j]?"Y":"N")+"|");
				}
				System.out.println();
			}
			printLine();// foorter
		}
	}

	void printLine(){
		int length = adjN+(adjN+1);
		for(int i=0;i<length;i++){
			if(i==0||i==(length-1))
				System.out.print("+");
			else
				System.out.print("-");
		}
		System.out.println();
	}

	void dfs(int at, int absent)
	{
//		System.out.println("at "+at);
		if(at == absent) return;
		vis[at] = true;
		for(int i=0;i<adjList.get(at).size();i++)
		{
			if(!vis[adjList.get(at).get(i)])
				dfs(adjList.get(at).get(i), absent);
		}
	}
}
