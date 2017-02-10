package norman.uva;

import norman.template.Template;

import java.util.Arrays;

/**
 * 
 * @author m.normansyah
 * uva 11094
 */
public class Continents extends Template {

	int ans = 0;
	int N, M, X, Y;
	boolean v[][];
	char field[][], land;

	public Continents() {
		super("Continents", "Continents", LINUX);
	}

	public static void print2D(char[][] dimen) {
		for (int i = 0; i < dimen.length; i++)
			System.out.println(Arrays.toString(dimen[i]));
	}

	@Override
	public void doSomething() {
		int count = 0;
		while(true){

			M = getInput().nextInt();
			N = getInput().nextInt();
			field = new char[M][N];
			v = new boolean[M][N];

			for (int i = 0; i < M; i++) {
				String line = getInput().next();
				for(int j=0;j<N;j++){
					field[i][j] = line.charAt(j);
				}
			}

//			System.out.println(field);
			print2D(field);

			X = getInput().nextInt();
			Y = getInput().nextInt();

			land = field[X][Y];
			floodfill(X, Y);

			ans = 0;
			for(int i=0;i<M;i++){
				for(int j=0;j<N;j++){
					if(field[i][j] == land){
						int t = floodfill(i,j);
						if(t>ans)
							ans = t;
					}
				}
			}

			System.out.println(ans);

			if (++count >= 1)
				break;

			if (!getInput().hasNext()) {
				break;
			}

		}
	}
	
	int floodfill(int x, int y){
		int ret;
		if(y==N) y = 0; else if(y==-1) y = M-1;
		if(x<0||x>=M||y<0||y>=N) return 0;
		if(v[x][y]) return 0;
		if(field[x][y]!=land) return 0;

		v[x][y] = true;
		ret = 1;
		ret += floodfill(x, y-1);
		ret += floodfill(x, y+1);
		ret += floodfill(x+1, y);
		ret += floodfill(x-1, y);
		return ret;
	}
	
//	public static 

	// ini untuk anggapan yang salah
//	public static final char LAND = 'l';
//	public static final char WATER = 'w';
}
