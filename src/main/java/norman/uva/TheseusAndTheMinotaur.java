package norman.uva;

import norman.template.Template;
import norman.template.TemplateUtility;

import java.util.ArrayList;
import java.util.List;

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
public class TheseusAndTheMinotaur extends Template {

    public static final int MAX = 300;
    public static final int N = 26;
    static final int LIST_INTEGER = 1, INTEGER = 2, CHAR = 3;
    int K;
    boolean VIS[];
    List<List<Integer>> adj;

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
            TemplateUtility.print(getOutput(), line, true);
            VIS = new boolean[MAX];
            adj = new ArrayList<>();
			for(int i=0;i<MAX;i++){
				adj.add(new ArrayList<Integer>());
			}
			int s, t, i, ei = 0; int[] e = new int[2];
			String tmp = "";
			for(i=0;i<line.length();i++){
				if(line.charAt(i) == '.'){
//					TemplateUtility.print(getOutput(), "line.charAt(i) == '.'", true);
                    break;
                }
				if(line.charAt(i) == ':' || line.charAt(i) == ';'){
					ei = line.charAt(i) == ':' ? 1 : 0;
//					TemplateUtility.print(getOutput(), ei==1?":" : " ; ", true);
                } else {
                    e[ei] = line.charAt(i);
//					TemplateUtility.print(getOutput(), " add "+(char)e[ei], true);
                    if (ei == 1) {
//						TemplateUtility.print(getOutput(), "ei == 1 index ke-"+(char)	e[0]+" dengan nilai "+(char)e[1], true);
                        adj.get(e[0]).add(e[1]);
                    }
				}
			}
			{
				i++;
                while (line.charAt(i) == ' ')
                    i++;
                s = line.charAt(i++);

				while(line.charAt(i) == ' ')
					i++;
				t = line.charAt(i++);

				while(line.charAt(i) == ' ')
					i++;
				K = 0;
				while(i < line.length())
                    K = (line.charAt(i++) - '0');// K * 10 +
//				TemplateUtility.print(getOutput(), "s "+(char)s+" t "+(char)t+" K "+K, true);
            }
            go(s,t,0,adj,VIS);
            TemplateUtility.print(getOutput(), "", true);
        } while (getInput().hasNext());// && !getInput().nextLine().equals("#")
    }

	void go( int M, int T, int step, List<List<Integer>> adj, boolean candle[]){
		/*
		 * tambahkan step, jika kelipatan dari Kth, maka visited true
		 */
        candle[M] = !(((++step) % K) != 0);
//		String str = "step ke-"+step+", M : "+convertTo(INTEGER, CHAR, M)+", T : "+convertTo(INTEGER, CHAR, T)+", adjList : "+convertTo(LIST_INTEGER, CHAR, adj.get(M))
//				+" candle[M] : "+candle[M];
//		TemplateUtility.print(getOutput(), str, true);
        for (int v = 0; v < adj.get(M).size(); v++) {
            int index = adj.get(M).get(v);
//			String str2 = "!(candle[index]) : "+(!(candle[index]))+" && "+convertTo(INTEGER, CHAR, index)+"(index) != "+convertTo(INTEGER, CHAR, T)+"(T)";
//			TemplateUtility.print(getOutput(), str2, true);
            if (!(candle[index]) && index != T) {
                if(candle[M])
                    TemplateUtility.print(getOutput(), (char) M + " ", true);
                go(adj.get(M).get(v), M, step, adj, candle);
                return;
			}
		}
        TemplateUtility.print(getOutput(), "/" + (char) M, true);
        return;
    }

    private final String convertTo(int typeFrom, int typeTo, Object data) {
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
}
