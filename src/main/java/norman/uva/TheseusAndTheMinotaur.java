package norman.uva;

import java.util.ArrayList;
import java.util.List;

import norman.template.template;
import norman.template.template_utility;

/**
 * https://belbesy.wordpress.com/2011/06/26/uva-168-theseus-and-the-minotaur/
 * copy becuase it's better to reserve engineer the program.
 * Type : Constrained DFS
Solution : actually this is a really dirty problem :| :| not only in the input, but I took long time to understand it 
besides i watched a documentary on the Youtube about the legend as well :D 
typically here you will do a DFS but you have to take care of the following.
1. a node is marked as visited only when it has a candle so that happens whenever Theseus passes the Kth cave.
2. this is the most important point; the adjacent nodes should be traversed in the order given in the input.
#include<vector>
 * @author Normansyah Putra
 *
 */
public class TheseusAndTheMinotaur extends template {

	public TheseusAndTheMinotaur() {
		super("TheseusAndTheMinotaur", "TheseusAndTheMinotaur", WINDOWS);
	}

	@Override
	public void doSomething() {
		do{
			String line = getInput().nextLine();
			if(line.equals("#"))
				break;
//			System.out.println(line);
			template_utility.print(getOutput(), line, true);
			VIS = new boolean[MAX];
			adj = new ArrayList<>();
			for(int i=0;i<MAX;i++){
				adj.add(new ArrayList<Integer>());
			}
			int s, t, i, ei = 0; int[] e = new int[2];
			String tmp = "";
			for(i=0;i<line.length();i++){
				if(line.charAt(i) == '.'){
//					template_utility.print(getOutput(), "line.charAt(i) == '.'", true);
					break;
				}
				if(line.charAt(i) == ':' || line.charAt(i) == ';'){
					ei = line.charAt(i) == ':' ? 1 : 0;
//					template_utility.print(getOutput(), ei==1?":" : " ; ", true);
				}else{
					e[ei] = line.charAt(i);
//					template_utility.print(getOutput(), " add "+(char)e[ei], true);
					if(ei == 1){
//						template_utility.print(getOutput(), "ei == 1 index ke-"+(char)	e[0]+" dengan nilai "+(char)e[1], true);
						adj.get(e[0]).add(e[1]);
					}
				}
			}
			{
				i++;
				while(line.charAt(i) == ' ') 
					i++;
				s = line.charAt(i++);
				
				while(line.charAt(i) == ' ')
					i++;
				t = line.charAt(i++);
				
				while(line.charAt(i) == ' ')
					i++;
				K = 0;
				while(i < line.length())
					K = (line.charAt(i++)-'0');// K * 10 + 
//				template_utility.print(getOutput(), "s "+(char)s+" t "+(char)t+" K "+K, true);
			}
			go(s,t,0,adj,VIS);
			template_utility.print(getOutput(), "", true);
		}while(getInput().hasNext() );// && !getInput().nextLine().equals("#")
	}
	
	void go( int M, int T, int step, List<List<Integer>> adj, boolean candle[]){
		/*
		 * tambahkan step, jika kelipatan dari Kth, maka visited true
		 */
		candle[M] = !(((++step)%K)==0?false:true);
//		String str = "step ke-"+step+", M : "+convertTo(INTEGER, CHAR, M)+", T : "+convertTo(INTEGER, CHAR, T)+", adjList : "+convertTo(LIST_INTEGER, CHAR, adj.get(M))
//				+" candle[M] : "+candle[M];
//		template_utility.print(getOutput(), str, true);
		for(int v=0;v<adj.get(M).size();v++){
			int index = adj.get(M).get(v);
//			String str2 = "!(candle[index]) : "+(!(candle[index]))+" && "+convertTo(INTEGER, CHAR, index)+"(index) != "+convertTo(INTEGER, CHAR, T)+"(T)";
//			template_utility.print(getOutput(), str2, true);
			if(!(candle[index]) && index != T){
				if(candle[M])
					template_utility.print(getOutput(), (char)M+" ", true);
				go(adj.get(M).get(v), M, step, adj, candle);
				return;
			}
		}
		template_utility.print(getOutput(), "/"+(char)M, true);
		return;
	}
	static final int LIST_INTEGER = 1, INTEGER = 2, CHAR =3;
	private final String convertTo(int typeFrom, int typeTo, Object data){
		String tmp = "";
		switch (typeFrom) {
		case LIST_INTEGER:
			switch (typeTo) {
			case CHAR:
				tmp+="[";
				for(int i=0;i<((List<Integer>)data).size();i++){
					int tmpInt = ((List<Integer>)data).get(i);
					if (i!= ((List<Integer>)data).size()-1)
						tmp += ((char)tmpInt)+",";
					else
						tmp += ((char)tmpInt);
				}
				tmp+="]";
				break;
			}
			break;
		case INTEGER:
			switch (typeTo) {
			case CHAR:
				int tmpInt = (int)data;
				tmp += (char)tmpInt;
				break;
			}
			break;
		default:
			break;
		}
		return tmp;
	}

	public static final int MAX = 300;
	public static final int N = 26;
	int K;
	boolean VIS[];
	List<List<Integer>> adj;
}
