package norman.srin.algorithm;

import norman.template.Template;

import java.util.ArrayList;
import java.util.List;

public class BiColoring extends Template {

	final int UNKNOWN = -1;
	final int BLACK = 0, WHITE = 1;
	List<List<Integer>> adjLists;
	boolean possible;
	int[] vertexs;

	public BiColoring() {
		super("BiColoring", "BiColoring", WINDOWS);
	}

	@Override
	public void doSomething() {
		int testcase = getInput().nextInt();
		for(int i=1;i<=testcase;i++){
			int nodeC = getInput().nextInt();
			int edgeC = getInput().nextInt();
			vertexs = new int[nodeC];
			adjLists = new ArrayList<List<Integer>>();
			for(int j=0;j<nodeC;j++){
				adjLists.add(new ArrayList<Integer>());
			}
			for(int j=0;j<edgeC;j++){
				int f = getInput().nextInt();
				int n = getInput().nextInt();
				adjLists.get(f).add(n);
				adjLists.get(n).add(f);
			}
			possible = true;
			for(int j=0;j<vertexs.length;j++){
				vertexs[j] = UNKNOWN;
			}
			for(int j=0;j<vertexs.length;j++){
				if(vertexs[j]==UNKNOWN){
					colorify(j, BLACK, WHITE);
				}
			}

			System.out.print("#" + i + " ");
			System.out.println(possible?"BICOLORABLE.":"NOT BICOLORABLE.");
		}
	}

	void colorify(int v, int c1, int c2) {
		vertexs[v] = c1;
//		System.out.println("v "+v+" color "+color(c1));
		for(int v2 : adjLists.get(v)){
//			System.out.println("v2 "+v2);
			if(vertexs[v2]==c1){
				possible = false;
				return;
			}

			if (vertexs[v2] == UNKNOWN)
				colorify(v2, c2, c1);
		}
		return;
	}

	public String color(int color) {
		switch (color) {
		default:
			return "UNKNOWN";
		case BLACK:
			return "BLACK";
		case WHITE:
			return "WHITE";
		}
	}
}
