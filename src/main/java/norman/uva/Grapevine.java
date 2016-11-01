package norman.uva;

import java.util.Arrays;

import norman.template.template;

public class Grapevine extends template {

	public Grapevine() {
		super("Grapevine", "Grapevine", LINUX);
	}

	@Override
	public void doSomething() {
		while(true){
			int N = getInput().nextInt();
			int M = getInput().nextInt();
//			System.out.println("N "+N+" & M "+M);
			if(N == 0 && M == 0) break;
			int[][] plot = new int[N][M];
			for(int i=0;i<N;i++)
				for(int j=0;j<M;j++)
					plot[i][j] = getInput().nextInt();
			int Q = getInput().nextInt();
			for(int i=0;i<Q;i++){
				int L = getInput().nextInt();
				int U = getInput().nextInt();
//				printMap(plot);
//				System.out.println("L "+L+" & U "+U);
				int curr_max = 0;
				for(int j=0;j<N;j++){
					int lb = Arrays.binarySearch(plot[j], L);
					if(lb < 0)
						lb = (lb*-1) - 1;
//					System.out.println("lb "+lb+" curr_max "+curr_max);
					for(int k =curr_max; k<N;k++){
						int jk = j+k;
						int lbk = lb+k;
						int plot_x_y = -999;
						if(!(j+k>=N || lb + k>=M)){
							plot_x_y = plot[j+k][lb+k];
						}
//						System.out.println("jk "+jk+" j+k>=N "+(j+k>=N)
//								+" & lbk "+lbk+" lb + k>=M "+ (lb + k>=M)
//								+" plot_x_y "+ plot_x_y+ " plot[j+k][lb+k]>U "+ (plot_x_y >U));
						if(j+k>=N || lb + k>=M || plot[j+k][lb+k]>U) break;
						if(k+1>curr_max) curr_max = k +1;
					}
				}
				System.out.println(curr_max);
			}System.out.println("-");
		}
	}

	private void printMap(int[][] map){
		for (int i = 0; i < map.length; i++) {
			System.out.println(Arrays.toString(map[i]));
		}
	}
}
