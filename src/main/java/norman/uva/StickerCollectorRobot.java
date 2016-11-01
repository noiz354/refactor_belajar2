package norman.uva;

import java.util.Arrays;

import norman.template.template;
import norman.template.template_utility;

/**
 * uva 11831
 * @author m.normansyah
 * need to test head of input.
 */
public class StickerCollectorRobot extends template {

	public StickerCollectorRobot() {
		super("StickerCollectorRobot", "StickerCollectorRobot", WINDOWS);
	}

	@Override
	public void doSomething() {
		while(true){
			N = getInput().nextInt();
			M = getInput().nextInt();
			S = getInput().nextInt();
			if(N == 0 && M == 0 && S == 0)
				break;
			counter = 0;
			map = new char[N][M];
			vis = new boolean[N][M];
//			System.out.println("N "+N+" M "+M+" S "+S);
			for(int i=0;i<N;i++){
				String nextLine = getInput().next();
//				System.out.println(i+" "+nextLine);
				map[i] = nextLine.toCharArray();
				// because small just linear search
				for(int j=0;j<map[i].length;j++){
					if(map[i][j]=='N'||map[i][j]== 'S'||map[i][j]== 'L'||map[i][j]== 'O')
					{
						start = new Coor(i, j, map[i][j]); 
					}
				}
//				printCharArray(map[i]);
//				System.out.println();
			}
//			System.out.println("start : "+ start);
			instruction = getInput().next().toCharArray();
//			printCharArray(instruction);
//			System.out.println();
			transverse();
//			System.out.println("counter : "+counter);
//			System.out.println(counter);
			template_utility.print(getOutput(), ""+counter, true);
		}
	}
	
	void transverse(){
		curPos = start;
		for(int i=0;i<instruction.length;i++){
//			System.out.println("before curPos "+curPos+" i "+i);
			switch (instruction[i]) {
			case 'D':// putar 90 derajat kanan
				curPos.dir = rotate(curPos.dir, 'D'); 
				break;
			case 'E':// putar 90 derajat kiri
				curPos.dir = rotate(curPos.dir, 'E'); 
				break;
			case 'F':// maju satu langkah
				if(move(curPos))
					isFlag(curPos);
				break;
			}
//			System.out.println("after curPos "+curPos+" i "+i);
//			System.out.println();
		}
	}
	
	/**
	 * 
	 * @param cur
	 * @return
	 * true jika tidak dihalangi 
	 * false jika dihalangi
	 */
	boolean move(Coor cur){
		boolean isBlocked = false;
		Coor temp = new Coor(cur.x, cur.y, cur.dir);
//		System.out.println("temp move : "+temp);
		switch (cur.dir) {
		case 'N':
			temp.x = temp.x-1;
			if(isBlocked = isBlocked(temp)){
				cur.x = cur.x-1;
			}
			break;
		case 'S':
			temp.x = temp.x+1;
			if(isBlocked = isBlocked(temp)){
				cur.x = cur.x+1;
			}
			break;
		case 'L':
			temp.y = temp.y+1;
			if(isBlocked = isBlocked(temp)){
				cur.y = cur.y+1;
			}
			break;
		default://		case 'O':
			temp.y = temp.y-1;
			if(isBlocked = isBlocked(temp)){
				cur.y = cur.y-1;
			}
			break;
		}
		return isBlocked;
	}
	
	/**
	 * fix this checker wkwkwk 
	 * @param cur
	 * @return
	 * true jika tidak block
	 * false jika di block
	 */
	boolean isBlocked(Coor cur){
		boolean b = cur.x <=N-1;
		boolean c = cur.x >=0;
		boolean c2 = cur.y <=M-1;
		boolean d = cur.y >= 0;
		if(b && c && c2 && d){
//			System.out.println("check if pillar : "+(map[cur.x][cur.y] != '#'));
			return map[cur.x][cur.y] != '#';
		}else{
//			System.out.println("out of range!!! b "+b+" c "+c+" c2 "+c2+" cur.y "+cur.y+" d "+d);
			return false;
		}
	}
	
	/**
	 * counter up up
	 * @return
	 */
	boolean isFlag(Coor cur){
//		System.out.println("isFlag ["+(char)map[cur.x][cur.y]+"] "+ cur);
		if(map[cur.x][cur.y]=='*' && !vis[cur.x][cur.y]){
			counter++;
			vis[cur.x][cur.y] = true;
		}
		return true;
	}
	
	char rotate(char in, char act){
		switch (in) {
		case 'N':
			if(act == 'D')
				return 'L';
			else
				return 'O';
		case 'S':
			if(act == 'D')
				return 'O';
			else
				return 'L';
		case 'L':
			if(act == 'D')
				return 'S';
			else
				return 'N';
//		case 'O':
			default:
			if(act == 'D')
				return 'N';
			else
				return 'S';
		}
		
	}
	

	// baris, kolom, instruksi
	int N,M,S;
	char[][] map;
	boolean[][] vis;
	int counter;
	char[] instruction;
	Coor start;
	Coor curPos;
	
	void printCharArray(char[] array){
		for (int i = 0; i < array.length; i++) {
			System.out.print((char)array[i]);
		}
	}
	
	class Coor{
		int x,y;
		char dir;
		public Coor(int x, int y, char dir){
			this.x = x;
			this.y = y;
			this.dir = dir;
		}
		
		@Override
		public String toString() {
			return " ["+x+","+y+","+arah()+"] ";
		}
		
		String arah(){
			switch (dir) {
			case 'N':
				return "utara";
			case 'S':
				return "selatan";
			case 'L':
				return "timur/kanan";
			default://case 'O':
				return "barat/kiri";
			}
		}
	}
}
