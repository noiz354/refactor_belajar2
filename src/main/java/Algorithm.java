/*
You should use the statndard input/output

in order to receive a score properly.

Do not use file input and output

Please be very careful. 
*/

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/*
   As the name of the class should be Algorithm , using Algorithm.java as the filename is recommended.
   In any case, you can execute your program by running 'java Algorithm' command.
 */
class Algorithm {
	static int Answer;

	public static void main(String args[]) throws Exception	{
		/*
		   The method below means that the program will read from input.txt, instead of standard(keyboard) input.
		   To test your program, you may save input data in input.txt file,
		   and call below method to read from the file when using nextInt() method.
		   You may remove the comment symbols(//) in the below statement and use it.
		   But before submission, you must remove the freopen function or rewrite comment symbols(//).
		 */		

		/*
		   Make new scanner from standard input System.in, and read data.
		 */
		Scanner sc = new Scanner(System.in);
		//Scanner sc = new Scanner(new FileInputStream("input.txt"));

		int testcase = sc.nextInt();
		for(int i=1;i<=testcase;i++){
			int nodeC = sc.nextInt();
			int edgeC = sc.nextInt();
			vertexs = new int[nodeC];
			adjLists = new ArrayList<List<Integer>>();
			for(int j=0;j<nodeC;j++){
				adjLists.add(new ArrayList<Integer>());
			}
			for(int j=0;j<edgeC;j++){
				int f = sc.nextInt();
				int n = sc.nextInt();
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
			System.out.print("#"+i+" ");
			System.out.println(possible?"BICOLORABLE.":"NOT BICOLORABLE.");
		}
	}
	
	static List<List<Integer>> adjLists;
	static boolean possible;
	static final int UNKNOWN = -1;
	static final int BLACK = 0, WHITE = 1;
	static int[] vertexs;
	
	static void colorify(int v, int c1, int c2){
		vertexs[v] = c1;
//		System.out.println("v "+v+" color "+color(c1));
		for(int v2 : adjLists.get(v)){
//			System.out.println("v2 "+v2);
			if(vertexs[v2]==c1){
				possible = false;
				return;
			}
			
			if(vertexs[v2]==UNKNOWN)
				colorify(v2, c2, c1);
		}
		return;
	}
}
