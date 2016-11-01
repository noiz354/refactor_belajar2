package norman.uva;

import java.util.Arrays;

import norman.template.template;
import norman.template.template_utility;

public class KnightInWarGrid extends template {

	public KnightInWarGrid() {
		super("KnightInWarGrid", "KnightInWarGrid", WINDOWS);
	}

	@Override
	public void doSomething() {
		int T = getInput().nextInt();
		int total = T;
		
		while(T-- > 0){
			R = getInput().nextInt();
			C = getInput().nextInt();
			
			visited = new boolean[R][C];
			gomap = new int[R][C];
			oddevenmap = new int[R][C];
			
			M = getInput().nextInt();
			N = getInput().nextInt();
			int W_N = getInput().nextInt();
			W_NArry = new Pair[W_N];
//			template_utility.print(getOutput(), " M "+M+" N "+N, true);
			if(M ==0 || N==0)
				isZeroMN = true;
			
			setupDir();
			
			for(int i=0;i<W_N;i++){
				int x_temp = getInput().nextInt();
				int y_temp = getInput().nextInt();
				W_NArry[i] = new Pair(x_temp, y_temp);
				gomap[x_temp][y_temp] = WATER;
			}
			
			K=1;
			go(new Pair(0, 0));

			int oddNumber = 0, evenNumber = 0;
//			template_utility.print(getOutput(), "hasil", true);
			for(int i=0;i<oddevenmap.length;i++){
//				template_utility.print(getOutput(), Arrays.toString(oddevenmap[i]), true);
				for(int j=0;j<oddevenmap.length;j++){
					if(oddevenmap[i][j] != 0 && oddevenmap[i][j]%2==0)
						evenNumber++;
					else if(oddevenmap[i][j] != 0 && oddevenmap[i][j]%2!=0)
						oddNumber++;
				}
			}
//			template_utility.print(getOutput(), "gomap - ", true);
//			for(int i=0;i<gomap.length;i++){
//				template_utility.print(getOutput(), ""+Arrays.toString(gomap[i]), true);
//			}
			if(K==1){
				evenNumber = 1;
			}
			if(T==0){
				System.out.print("Case "+(total-T)+" "+evenNumber+" "+oddNumber);
			}else{
				System.out.println("Case "+(total-T)+" "+evenNumber+" "+oddNumber);
			}
//			template_utility.print(getOutput(), "Case "+(total-T)+" "+evenNumber+" "+oddNumber, true);
		}
	}
	
	void go(Pair c){
		visited[c.x][c.y] = true;
		if(gomap[c.x][c.y]!=WATER)
			gomap[c.x][c.y] = K;
		
		int dirLength = (M==N || N ==0 || M ==0)?4:8;
		
		Pair[] Coors = new Pair[dirLength];
		for(int i=0;i<dirLength; i++){
			Coors[i] = new Pair(c.x+dir[i][0], c.y+dir[i][1]);
//			System.out.println(Arrays.toString(dir[i]));
		}
		
		for(int i=0;i<dirLength;i++){
			boolean waterZone = false;
			boolean isNotOutsideZone = !isOutsideZone(Coors[i], R, C);
//			template_utility.print(getOutput(), "c "+c+" Coors "+Coors[i]+" isNotOutsideZone "+isNotOutsideZone, false);
			if(isNotOutsideZone){
				waterZone = isWaterZone(Coors[i]);
//				template_utility.print(getOutput(), " waterZone "+waterZone, false);
			}
//			template_utility.print(getOutput(), "", true);
			
			if(isNotOutsideZone && !waterZone){
					oddevenmap[Coors[i].x][Coors[i].y]++;
					if(!visited[Coors[i].x][Coors[i].y]){
						K++;
						go(Coors[i]);
					}
			}
		}
		
	}

	void setupDir() {
		if(M==N){
			dir = new int[4][2];
			dir[0] = new int[]{-M,N};
			dir[1] = new int[]{-M,-N};
			dir[2] = new int[]{M,N};
			dir[3] = new int[]{M,-N};
		}else if(M==0){// ||N==0
			dir = new int[4][2];
			dir[0] = new int[]{M,N};
			dir[1] = new int[]{M,-N};
			dir[2] = new int[]{-N,M};
			dir[3] = new int[]{N,M};
		}else if(N==0){
			dir = new int[4][2];
			dir[0] = new int[]{N,M};
			dir[1] = new int[]{N,-M};
			dir[2] = new int[]{M,N};
			dir[3] = new int[]{-M,N};
		}
		else{
			dir = new int[8][2];
			dir[0] = new int[]{-M,N};
			dir[1] = new int[]{-M,-N};
			dir[2] = new int[]{M,N};
			dir[3] = new int[]{M,-N};
			dir[4] = new int[]{-N,M};
			dir[5] = new int[]{-N,-M};
			dir[6] = new int[]{N,M};
			dir[7] = new int[]{N,-M};
		}
	}
	
	/**
	 * @return true jika keluar zona
	 * false jika tetap dalam zona
	 */
	boolean isOutsideZone(Pair cur, int H, int W){
		return !(cur.x >= 0 && cur.x < H && cur.y >= 0 && cur.y < W);
	}
	
	boolean isWaterZone(Pair cur){
//		template_utility.print(getOutput(), " c "+cur+" gomap "+gomap[cur.x][cur.y]+" WATER "+WATER, true);
		return gomap[cur.x][cur.y] == WATER;
	}
		

	class Pair{
		int x;
		int y;
		public Pair(int x, int y){
			this.x = x;
			this.y = y;
		}
		@Override
		public String toString() {
			return "Pair [x=" + x + ", y=" + y + "]";
		}
	}
	
	Pair[] W_NArry;
	boolean[][] visited;
	int[][] gomap;
	int[][] oddevenmap;
	int M, N, R, C, K;
	boolean isZeroMN = false;
	static final int WATER = -99;
	int[][] dir;
}
