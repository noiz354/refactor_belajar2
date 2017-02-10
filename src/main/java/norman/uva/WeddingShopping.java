package norman.uva;

import norman.template.Template;

import java.util.Arrays;

/**
 * Example of dynamic Programming
 * @author M Normansyah (m.normansyah@samsung.com)
 * started at 31-3-2015, using different approach.
 * started do some at 1-4-2015, use greedy to show that greedy couldn't solve the problem
 * started at 4-42015, using recursive backtracking
 * started at 6-4-2015, using Top-down Dynamic Programming
 */
public class WeddingShopping extends Template {

	int[][] memo;
	private int max = 0, min = 1000;

	public WeddingShopping() {
		super("WeddingShopping", "WeddingShopping", LINUX);
	}

	@Override
	public void doSomething() {
		int testCase = getInput().nextInt();
		while(testCase-->0){
			System.out.println("testCase "+ testCase);
			int M = getInput().nextInt();// available amount of money
			int C = getInput().nextInt();// number of garments have to buy
			int[][] categories = new int[C][];
			for(int i=0;i<categories.length;i++){
				categories[i] = new int[getInput().nextInt()];
				for(int j=0;j<categories[i].length;j++){
					categories[i][j] = getInput().nextInt();
				}
			}
			printArrays(categories);

			// demo using greedy, coin change alike, for some input it succeed but for second input is false
//			greedySolver(M, C, categories);

			// demo using recursive backtracking
//			recBacktrackWithTotal(0, 0, categories,M);// (M, 0, categories);
//			System.out.println("max "+max);

			// demo using book code that minus Dynamic Programming

			// demo using book code that using Dynamic Programming Top-Down
			memo = new int[210][25];
			for(int i=0;i<memo.length;i++){
				for(int j=0;j<memo[i].length;j++){
					memo[i][j] = -1;
				}
			}
			int result = shopDP(M,0,categories,C,M);
			System.out.println("result : "+result);
		}
	}

	/**
	 * recursive backtracking using void using decrement style
	 * @param money
	 * @param g
	 * @param categories
	 * @return
	 */
	private int recBacktrack(int money, int g, int[][] categories){
		if(g == categories.length){
			System.out.println("result "+ money);
			min = (Math.min(min, money) > 0 ? Math.min(min, money) : min );
			return 0;
		}
		for(int i=0;i<categories[g].length;i++){
			System.out.println("money "+money+" - "+categories[g][i]);
			recBacktrack(money-categories[g][i], g+1, categories);
		}
		return 0;
	}

	/**
	 * recursive backtracking using void using increment style
	 * @param money
	 * @param g
	 * @param categories
	 * @return
	 */
	private int recBacktrackWithTotal(int total, int g, int[][] categories, int money){
		if(g == categories.length){
//			max = (Math.max(max, total) >= money ? Math.max(max, total) : money );
			int temp = Math.max(max, total);
			System.out.println("result "+ total+" max "+temp+" money "+ money);
			if(temp >= 0 && temp <= money){
				System.out.println("masuk sini temp "+ temp);
				max = total;
			}
			return 0;
		}
		for(int i=0;i<categories[g].length;i++){
			System.out.println("total "+total+" + "+categories[g][i]);
			recBacktrackWithTotal(total+categories[g][i], g+1, categories, money);
		}
		return 0;
	}

	private void greedySolver(int M, int C, int[][] categories){
		int currentMaxM = M;
		int total = 0;
		for(int i=0;i<categories.length;i++){
			Arrays.sort(categories[i]);
			System.out.println(Arrays.toString(categories[i]));
			if(currentMaxM - categories[i][categories[i].length-1] > 0){
				currentMaxM = currentMaxM - categories[i][categories[i].length-1];
				total += categories[i][categories[i].length-1];
			}
			System.out.println("largest "+categories[i][categories[i].length-1]);
		}
		System.out.println("total : "+ total+ " currentMaxM "+currentMaxM);
	}

	/**
	 *
	 * @param money available money
	 * @param g category that increase when recursive
	 * @param categories price list
	 * @param C number of categories
	 * @return
	 */
	private int shop(int money, int g, int[][] categories, int C, int M){
		if(money < 0){
			return -1_000_000_000;
		}
		if(g == C){
			return M - money;
		}
		int ans = -1;
		for(int model = 0;model<categories[g].length;model++){
			ans = Math.max(ans, shop(money-categories[g][model], g+1, categories, C, M));
		}
		return ans;
	}

	// Bottom Up approach
	private int shopDP(int money, int g, int[][] categories, int C, int M){
//		System.out.println("money "+money+" g "+g+" C "+ C+" M "+M);
		if(money < 0){// fail, return a large -ve number
			System.out.println("minus");
			return -1_000_000_000;
		}
		if(g == C){// we have bought the last one, done
			return M - money;
		}
		// if the line below is commented, top-down DP will become backtracking
		if(memo[money][g] != -1){
			System.out.println("return memo");
			return memo[money][g];
		}
		int ans = -1;
		for(int model = 0;model<categories[g].length;model++){
			ans = Math.max(ans, shopDP(money-categories[g][model], g+1, categories, C, M));
		}
		return ( memo[money][g] = ans);
	}

	// debug purpose
	private void printArrays(int[][] anArray){
		for (int i = 0; i < anArray.length; i++) {
			System.out.println(Arrays.toString(anArray[i]));
		}
	}
}
