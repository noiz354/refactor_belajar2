package norman.srin.algorithm;

import norman.template.Template;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Soal latihan so-tong
 * @author M Normansyah (m.normansyah@samsung.com)
 *
 * cara ke-2, simpan dalama list dan sort dari yang paling besar, setiap ngebomb update data-data.
 *
 */
public class Bomberman extends Template {

    char[][] map;
    List<coor> coords;
    int M, N, largest, i_largest, j_largest, real_count, prev, after, enemy_count, bomb_count;

	public Bomberman() {
		super("Bomberman", "Bomberman", LINUX);
	}

	@Override
	public void doSomething() {
		/* Test reverse order
		coords = new ArrayList<>();
		coords.add(new coor(1, 1, 6));
		coords.add(new coor(1, 1, 6));
		coords.add(new coor(1, 1, 7));
		Collections.reverse(coords);
		for (int i = 0; i < coords.size(); i++) {
			System.out.println(coords.get(i));
		}*/
		int TC = getInput().nextInt();
		int total = TC;
		while(TC-->0){
			System.out.println("Test Case #"+(total-TC));
			M = getInput().nextInt();
			N = getInput().nextInt();
			map = new char[N][];
			for(int i=0;i<N;i++){
				map[i] = getInput().next().toCharArray();
//				System.out.println(Arrays.toString(map[i]));
			}
			coords = new ArrayList<coor>();
			enemy_count = 0;
			bomb_count = 0;

			for(int i=0;i<N;i++){
				for(int j=0;j<M;j++){
					int large_temp = -1;
					if(map[i][j]=='.'){
						large_temp = calcVictim(i, j);
						coords.add(new coor(i, j, large_temp));
					}else if(map[i][j]=='x'){// calculate enemy number
						enemy_count++;
					}
				}
			}

			while(true){
//				System.out.println("before reverse : ");
				Collections.sort(coords);
//				for (coor coor : coords) {
//					System.out.println(coor);
//				}
//				System.out.println("after reverse : ");
				coor head = null;
				if(coords.size() > 0 ){
					head = coords.remove(0);
//					System.out.println("bomb "+head);
					bomb(head.x, head.y);
					enemy_count -= head.number;// decrease enemy number
					bomb_count++;
				}

				// update coords list till no point to bomb
				for(int i=0;i<coords.size();i++){
					coor temp = coords.get(i);
//					System.out.println(temp);

					// if '.' update to the list
					if(map[temp.x][temp.y]=='.'){
						int large_temp = calcVictim(temp.x, temp.y);
						coords.set(i, new coor(temp.x, temp.y, large_temp));
					}else if(map[temp.x][temp.y]=='z'||map[temp.x][temp.y]=='x'){// if 'z' remove from list
						coords.remove(i);
					}
				}

//				System.out.println("enemy count : "+ enemy_count);
//				for(int i=0;i<N;i++){
//					System.out.println(Arrays.toString(map[i]));
//				}
				if(enemy_count==0){
					break;
				}
				if(coords.size()<=0){
					break;
				}
			}

			if(bomb_count != 0 && enemy_count == 0){
				System.out.println(bomb_count);
			}else{
				System.out.println("-1");
			}

		}//end of while Test Case
	}

	private void bomb(int i, int j){
//		System.out.println("i_bomb "+i+" j_bomb "+j);

		map[i][j] = 'z';

		// i j+1
		if(detLimit(i, j+1, map)){
			map[i][j+1] = 'z';
			if(detEnemy(i, j+1, map)){
				enemy_count--;
			}
		}

		// i j-1
		if(detLimit(i, j-1, map)){
			map[i][j-1] = 'z';
			if(detEnemy(i, j-1, map)){
				enemy_count--;
			}
		}

		// i-1 j
		if(detLimit(i-1, j, map)){
			map[i-1][j] = 'z';
			if(detEnemy(i-1, j, map)){
				enemy_count--;
			}
		}

		// i+1 j
		if(detLimit(i+1, j, map)){
			map[i+1][j] = 'z';
			if(detEnemy(i+1, j, map)){
				enemy_count--;
			}
		}
	}

	private int calcVictim(int i, int j){
		int ans = 0;

		// i j+1
		if(detLimit(i, j+1, map)){
			if(detEnemy(i, j+1, map)){
				ans++;
			}
		}

		// i j-1
		if(detLimit(i, j-1, map)){
			if(detEnemy(i, j-1, map)){
				ans++;
			}
		}

		// i-1 j
		if(detLimit(i-1, j, map)){
			if(detEnemy(i-1, j, map)){
				ans++;
			}
		}

		// i+1 j
		if(detLimit(i+1, j, map)){
			if(detEnemy(i+1, j, map)){
				ans++;
			}
		}

		return ans;
	}

	private boolean detLimit(int i, int j, char[][] map){
		return i>=0&&i<map.length&&j>=0&&j<map[i].length;
	}

	private boolean detEnemy(int i, int j, char[][] map){
		return map[i][j] == 'x';
	}

	static class coor implements Comparable<coor>{
		int x,y,number;
		public coor(int x,int y, int number){
			this.x = x;
			this.y = y;
			this.number = number;
		}
		@Override
		public int compareTo(coor o) {
			return o.number-number;
		}
		@Override
		public String toString() {
			return "coor [x=" + x + ", y=" + y + ", number=" + number + "]";
		}

	}
}
