package norman.srin.algorithm;

import norman.template.template;

public class MineSweeper extends template {

	public MineSweeper() {
		super("MineSweeper", "MineSweeper", LINUX);
	}

	@Override
	public void doSomething() {
//		char[] test = new char[]{'.','*'};
//		for(char tmep : test){
//			System.out.println(tmep);
//		}

		int TC = getInput().nextInt();
		int total = TC;
		while(TC-- > 0){
			System.out.println("Test Case #"+(total-TC));
			int w = getInput().nextInt();
			int h = getInput().nextInt();
			map = new char[h][w];
			result = new int[h][w];

			for(int i=0;i<h;i++){
				String h_temp_string = getInput().next();
				System.out.println(h_temp_string);
				for(int j=0;j<w;j++){
//					System.out.println(j);
					map[i][j] = h_temp_string.charAt(j);
				}
			}// end of for

			// start processing
			for(int i=0;i<h;i++){
				for(int j=0;j<w;j++){
					int countMine = -1;
					if(map[i][j] == '.'){
						countMine = countMine(i, j, map);
					}
					result[i][j] = countMine;

					// direct print
					String temp = "";
					if(result[i][j] == 0){
						temp = ".";
					}else if(result[i][j] == -1){
						temp = "*";
					}else{
						temp = (result[i][j]+"");
					}
					System.out.print(temp);
				}
				System.out.println();
			}// end of for

//			for(int i=0;i<h;i++){
////				System.out.println(Arrays.toString(result[i]));
//				for(int j=0;j<w;j++){
//					String temp = "";
//					if(result[i][j] == 0){
//						temp = ".";
//					}else if(result[i][j] == -1){
//						temp = "*";
//					}else{
//						temp = (result[i][j]+"");
//					}
//					System.out.print(temp);
//				}
//				System.out.println();
//			}
		}// end of while

	}

	char[][] map;
	int[][] result;


	private static int countMine(int x, int y, char[][] map){
		int ans = 0;
		// x-1 y+1
		if(outSideZone(x-1, y+1, map.length, map[x].length) &&
				map[x-1][y+1] == '*'){
			ans++;
		}
//		System.out.println("x-1 y+1 "+ans);
		// x-1 y
		if(outSideZone(x-1, y, map.length, map[x].length) &&
				map[x-1][y]== '*'){
			ans++;
		}
//		System.out.println("x-1 y "+ans);
		// x-1 y-1
		if(outSideZone(x-1, y-1, map.length, map[x].length) &&
				map[x-1][y-1]== '*'){
			ans++;
		}
//		System.out.println("x-1 y-1 "+ans);
		// x y-1
		if(outSideZone(x, y-1, map.length, map[x].length) &&
				map[x][y-1]== '*'){
			ans++;
		}
//		System.out.println("x y-1 "+ans);
		// x y+1
		if(outSideZone(x, y+1, map.length, map[x].length) &&
				map[x][y+1]== '*'){
			ans++;
		}
//		System.out.println("x y+1 "+ans);
		// x+1 y-1
		if(outSideZone(x+1, y-1, map.length, map[x].length) &&
				map[x+1][y-1]== '*'){
			ans++;
		}
//		System.out.println("x+1 y-1 "+ans);
		// x+1 y
		if(outSideZone(x+1, y, map.length, map[x].length) &&
				map[x+1][y]== '*'){
			ans++;
		}
//		System.out.println("x+1 y "+ans);
		// x+1 y+1
		if(outSideZone(x+1, y+1, map.length, map[x].length) &&
				map[x+1][y+1]== '*'){
			ans++;
		}
//		System.out.println("x+1 y+1 "+ans);
		return ans;
	}

	private static boolean outSideZone(int x, int y, int x_limit, int y_limit){
		return x>=0&&x<=x_limit-1&&y>=0&&y<=y_limit-1;
	}

}
