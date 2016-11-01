package norman.uva;

import java.util.Arrays;

import norman.template.template;

/**
 * started at 13-5-2015, using greedy ( uva 10026 )
 * @author M Normansyah (m.normansyah@samsung.com)
 * Question remain :
 * 	why should sort that way ????
 */
public class ShoeMaker extends template {

	public ShoeMaker() {
		super("ShoeMaker", "ShoeMaker", LINUX);
	}

	@Override
	public void doSomething() {
		int TC = getInput().nextInt();
		while(TC-- >0){
			int N = getInput().nextInt();
			fees = new Fee[N];
			for(int i=0;i<N;i++){
				fees[i] = new Fee(getInput().nextInt(), getInput().nextInt(), (i+1));
			}
			Arrays.sort(fees);
			int count = 0;
			for(Fee f : fees){
				System.out.println((count++)+" time "+f.T+" fee : "+f.S);
			}
			System.out.print(fees[0].id);
			for(int i=1;i<N;i++){
				System.out.print(" "+fees[i].id);
			}
			System.out.println();
		}
	}

	Fee[] fees;

	static class Fee implements Comparable<Fee>{
		int T, S, id;
		double ratio;
		/**
		 *
		 * @param T time to finished
		 * @param S unfinished fee
		 */
		public Fee(int T, int S, int id){
			this.T = T;
			this.S = S;
			this.id = id;
			ratio = S/T;
		}
		@Override
		public int compareTo(Fee o) {
			return Double.valueOf(o.ratio).compareTo(ratio);// ascending dari yang besar ke kecil
		}


	}

}
