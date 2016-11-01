package norman.srin.algorithm;

import norman.template.template;

public class HighestPeak extends template {

	public HighestPeak() {
		super("HighestPeak", "HighestPeak", LINUX);
	}

	@Override
	public void doSomething() {
		int TC = getInput().nextInt();
		int total = TC;
		while(TC-- > 0){
			System.out.println("Case #"+(total-TC));

			w = getInput().nextInt();

			heights = new int[w][w];
			copyHeights = new int[w][w];

			for(int i=0;i<heights.length;i++){
				String strTemp = getInput().next();
				for(int j=0;j<heights[i].length;j++){
					int temp = Integer.parseInt(strTemp.charAt(j)+"");
//					System.out.println(temp);
					heights[i][j] = temp;
					copyHeights[i][j] = temp;
				}
			}// end of for

			// backtrack positions
			int start = 1;
			int finish = heights.length-2;
//			System.out.println("start "+start+" finish "+finish);
			for(int i=start;i<=finish;i++){
				for(int j=start;j<=finish;j++){
					boolean result = max(i, j, heights);
//					System.out.println(" i "+i+" j "+j+" value "+heights[i][j]+" result "+ result);
					if(result){
						copyHeights[i][j]= -10;
					}
				}
			}

			String res = "";
			for(int i=0;i<copyHeights.length;i++){
				for(int j=0;j<copyHeights[i].length;j++){
					String temp = (copyHeights[i][j] == -10) ? "X":copyHeights[i][j]+"";
					res += temp;
				}
				if(!(i==(copyHeights.length-1)))
					res += "\n";
			}
			System.out.println(res);
		}
	}

	int w;
	int[][] heights;
	int[][] copyHeights;
	private static boolean max(int x, int y, int[][] heights){
		boolean ans = false;
		// x-1 y+1
		ans = heights[x][y] >= heights[x-1][y+1];
//		System.out.println("x-1 y+1 "+ans);
		// x-1 y
		ans = ans && heights[x][y] >= heights[x-1][y];
//		System.out.println("x-1 y "+ans);
		// x-1 y-1
		ans = ans && heights[x][y] >= heights[x-1][y-1];
//		System.out.println("x-1 y-1 "+ans);
		// x y-1
		ans = ans && heights[x][y] >= heights[x][y-1];
//		System.out.println("x y-1 "+ans);
		// x y+1
		ans = ans && heights[x][y] >= heights[x][y+1];
//		System.out.println("x y+1 "+ans);
		// x+1 y-1
		ans = ans && heights[x][y] >= heights[x+1][y-1];
//		System.out.println("x+1 y-1 "+ans);
		// x+1 y
		ans = ans && heights[x][y] >= heights[x+1][y];
//		System.out.println("x+1 y "+ans);
		// x+1 y+1
		ans = ans && heights[x][y] >= heights[x+1][y+1];
//		System.out.println("x+1 y+1 "+ans);
		return ans;
	}
}
