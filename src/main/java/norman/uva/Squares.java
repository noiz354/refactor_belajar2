package norman.uva;

import norman.template.Template;

import java.io.IOException;

/**
 * @author M Normansyah (m.normansyah@samsung.com)
 * 11407 - Squares
 * started at 8-4-2015
 */
public class Squares extends Template {

	int list[];
	int[] dp;

	public Squares() {
		super("Squares", "Squares", LINUX);
	}

	@Override
	public void doSomething() {
		int TC = getInput().nextInt();
		dp = new int[10005];
		while(TC-- > 0){
			// using top-down approach
			int N = getInput().nextInt();
			int solve = -1;
			System.out.println(solve = solve(N));
			printToFile(solve+"");

			// using down-up approach
			/*findSmallN();
			int N = getInput().nextInt();
//			double ans = findSmallN(N, 1, 1);
//			System.out.println("ans "+ans);
			System.out.println(list[N]);*/
		}
	}

	/**
	 * https://kimox2.wordpress.com/2011/10/10/uva-11407-squares/
	 */
	private void findSmallN(){
		list = new int[10005];
		int i,j;
		for(i=0;i<10005;i++){
			list[i] = 4;
		}
		for(i=1;i*i<=10000;i++){
			list[i*i] = 1;
		}
		list[0] = 0;
		for(i=1;i<=18;i++){
			for(int k=1;k<=18;k++){
				System.out.print(list[k]+",");
			}
			System.out.println();
			for(j=1;j<=i;j++){
				System.out.println("i ["+i+"] j ["+j+"]");
				if(list[j]==1){
					System.out.println("list["+i+"] "+list[i]+" 1+list["+(i+"-"+j)+"] = "+(1+list[i-j]));
					list[i] = Math.min(list[i], 1+list[i-j]);
				}
			}
		}
	}

	/**
	 * top-down approach, more readable for me
	 * @param n
	 * @return
	 */
	int solve(int n){
		System.out.println(n);
//		printToFile(n+"");
		if(n==0){
			return 0;
		}else if(dp[n] != 0){
			System.out.println("n "+n+" dp["+n+"] "+dp[n]);
//			printToFile("n "+n+" dp["+n+"] "+dp[n]);
			return dp[n];
		}else
		{
			int i = 0;
			dp[n] = 1_073_741_824;

//			for(i=1;i*i<=n;i++){ // advanced developer
			//+ if it was me,
			//+ unique case, coba for(i=1;i<=n;i++){ diganti menjadi for(i=1;i<n;i++){
			//+ maka untuk nilai 1 yang dibalikan adalah 1_073_741_824
			for(i=1;i<=n;i++){
				if(i*i>n)
					break;
			//- if it was me
				System.out.println("i "+i+" n "+n);
//				printToFile("i "+i+" n "+n);
				dp[n] = Math.min(dp[n], 1+solve(n-i*i));
			}
			System.out.println("else n "+n+" dp["+n+"] "+dp[n]);
//			printToFile("else n "+n+" dp["+n+"] "+dp[n]);
			return dp[n];
		}
	}

	private void printToFile(String text){
		try {
			getOutput().write(text+"\n");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Cannot solve using recursive backtracking, my own
	 * @param N
	 * @param n
	 * @param base
	 * @return
	 */
	private double findSmallN(int N, int n, int base){

		double ans = 0;

		for(int i=0;i<n;i++){
			ans += Math.pow(base, n);
		}

		if(ans == N){
			return n;
		}else if(ans > N){
			ans = findSmallN(N, 1, base+1);
		}else{
			ans = findSmallN(N, n+1, base);
		}

		return ans;
	}

}
