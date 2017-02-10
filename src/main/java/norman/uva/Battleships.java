package norman.uva;

import norman.template.Template;

import java.util.Arrays;

/**
 * 
 * @author m.normansyah
 * @since 21-2-2016, 
 * 
 * Awalnya saya berpikir untuk ngebomb di . untuk mendapatkan semua x, nanti semua x atau @ dianggap sama, 
 * terus masing2 itu dibuatin map bentuk array sendiri untuk dihitung jumlahnya. (pemikiran saya terlalu ribet)
 * 
 * yang benar, karena kalau ada jika masih ada x walaupun ada @, artinya ada x -> jadi tidak perlu menghitung jumlah x
 * @ tidak perlu diperhatikan karena tidak perlu dihitung jumlah kerusakan dari masing2. 
 * jadi sebenarnya antara x dan . saja. tinggal O(N^2) dengan n adalah dfs
 *
 */
public class Battleships extends Template {
    static final int dr[] = {-1, -1, 0, 1, 1, 1, 0, -1};
    static final int dc [] = {0, 1, 1, 1, 0, -1, -1, -1};
    int N;
    char[][] map;

	public Battleships() {
		super("Battleships", "Battleships", WINDOWS);
	}

	@Override
	public void doSomething() {
		int T = getInput().nextInt();
		int total = T;
		while(T-->0){
			N = getInput().nextInt();
			map = new char[N][];
			for(int i=0;i<N;i++){
				String temp = getInput().next();
				map[i] = temp.toCharArray();
//				int y = temp.indexOf('.', 0);
//				System.out.println("x : "+i+" y :"+y);
			}
			
//			print(map);
			
			int count = 0;
			for(int i=0;i<N;i++){
				for(int j=0;j<N;j++){
					if(map[i][j]=='x'){
						count++;
						moveAround(i, j);
					}
				}
			}
			
			System.out.println("Case "+(total-T)+": "+count);
		}
	}
	
	void moveAround(int x, int y){
		if(x<0||x>(N-1)||y<0||y>(N-1)||map[x][y]=='.')
			return;
		map[x][y] = '.';
		for(int i=0;i<8;i+=2)
			moveAround(x+dr[i], y+dc[i]);
	}
	
	void print(char[][] map){
		for(int i=0;i<map.length;i++){
			System.out.println(Arrays.toString(map[i]));
		}
	}
	
//	static class Pair{
//		int x,y;
//		public Pair(int x, int y){
//			this.x = x;
//			this.y = y;
//		}
//		public int getX() {
//			return x;
//		}
//		public void setX(int x) {
//			this.x = x;
//		}
//		public int getY() {
//			return y;
//		}
//		public void setY(int y) {
//			this.y = y;
//		}
//	}

}
