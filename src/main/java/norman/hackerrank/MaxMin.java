package norman.hackerrank;

import java.io.IOException;
import java.util.Arrays;

import norman.template.template;
import norman.template.template_utility;

/**
 * Greedy problem
 * @author M Normansyah (m.normansyah@samsung.com)
 * https://www.hackerrank.com/challenges/angry-children
 */
public class MaxMin extends template {

	public MaxMin() {
		super("MaxMin", "MaxMin", LINUX);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void doSomething() {
		A: while(true){
			if(!getInput().hasNext()){
				break A;
			}
			N = getInput().nextInt();
			K = getInput().nextInt();
			n = new int[N];
			String printSomething = "";
			for(int i=0;i<N;i++){
				n[i] = getInput().nextInt();
				printSomething += n[i];
				if(i!=(N-1))
					printSomething +=",";
			}
			template_utility.print(getOutput(), printSomething, true);

			Arrays.sort(n);

			int result = Integer.MAX_VALUE;
			for(int i=0;i<=((N-1)-K+1);i++){
//				printSomething = "";
//				printSomething += "index_awal : "+i+" & index_akhir : "+(i+(K-1));
//				Utility.print(getOutput(), printSomething, true);
				int temp = n[i+(K-1)] - n[i];
				result = Math.min(temp, result);
			}

			printSomething = "" + result;
			template_utility.print(getOutput(), printSomething, true);

		}

		try {
			getOutput().close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	int[] n;
	int K, N;

}
