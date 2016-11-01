package norman.uva;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

import norman.template.template;

/**
 * 
 * @author m.normansyah
 * floodfill, hint : 
 * setiap hieroglyph memiliki jumlah unik dari whie connected component,
 * kemudian ini adalah sebuah latihan implementasi untuk parse input 
 * dan menjalankan floodfill untuk menentukan jumlah white CC dalam 
 * sebuah hieroglyph hitam.
 * 
 * strategi :
 * 1. floodfill nilai 0 dan dapatkan koordinat nilai 1
 * 2. floodfill nilai 1 dan dapatkan koordinat nilai 0
 * 3. floodfill nilai 0 dan dapatkan koordinat nilai 1 untuk menhitung jumlah lingkaran
 * 
 * case 5 : salah, karena ada south east, north east dsb. kalau dijadikan 4 langkah malah tidak benar jawabannya.
 * case 9 : stackoverflow
 *
 * cara saya ada yang salah. hmmm apa ya ?
 * kalau baca codingan orang, yang salah itu adalah directionnya harusnya 4. 
 * diubah 4 malah jawabannya aneh.
 */
public class AncientMessages extends template {

	public AncientMessages() {
		super("AncientMessages", "AncientMessages", WINDOWS);
	}

	@Override
	public void doSomething() {
		int countTest = 1;
		while((H=getInput().nextInt())!=0 &&(W=getInput().nextInt())!=0){
			getInput().nextLine();
			map = new int[H][4*W];
			
			for(int i=0;i<H;i++){
				String temp = getInput().next();
//				System.out.println(temp);
				for(int j=0;j<W;j++){
					for(int k=0;k<hex[hexToInt(temp.charAt(j))].length;k++){
						if(start==null&&hex[hexToInt(temp.charAt(j))][k]==0){
							start = new Pair(i, (j*4)+k);
						}
						map[i][(j*4)+k] = hex[hexToInt(temp.charAt(j))][k];
					}
				}
			}
			printMap();
			System.out.println();
			
//			System.out.print("Case "+countTest++ +": ");
			lvl1 = new HashSet<>();
			color_to_saved = 1;
			level = 1;
			floodfill(start.x, start.y, 0, 2);
			
			printMap();
			System.out.println();
			
			lvl2 = new HashSet<>();
			color_to_saved =0;
			level = 2;
			for(Iterator<Pair> i=lvl1.iterator();i.hasNext();){
				Pair temp = i.next();
				System.out.println(temp);
				if(map[temp.x][temp.y]!=2){
					floodfill(temp.x, temp.y, 1, 2);
					int count = 0;
					for(Iterator<Pair> j=lvl2.iterator();j.hasNext();){
						temp = j.next();
						if(map[temp.x][temp.y]!=2)
							count += (floodfill(temp.x, temp.y, 0, 2)>1?1:0);
					}
					System.out.println("ini hasil akhirnya "+count);
					switch (count) {
					case 0:
						System.out.print("W");
						break;
					case 1:
						System.out.print("A");
						break;
					case 2:
						System.out.print("K");
						break;
					case 3:
						System.out.print("J");
						break;
					case 4:
						System.out.print("S");
						break;
					case 5:
						System.out.print("D");
						break;
					}
				}
				System.out.println();
				printMap();
			}
			System.out.println();
		}// emd of while
	}
	
	void printMap(){
		for(int i=0;i<map.length;i++){
			System.out.println(Arrays.toString(map[i]));
		}
	}
	
	Pair start;
	int H, W;
	int[][] map;
	Set<Pair> lvl1;
	boolean[] visited1;
	Set<Pair> lvl2;
	boolean[] visited2;
	int color_to_saved;
	int level;
	
	class Pair{
		int x, y;

		public Pair(int x, int y) {
			super();
			this.x = x;
			this.y = y;
		}

		@Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			result = prime * result + getOuterType().hashCode();
			result = prime * result + x;
			result = prime * result + y;
			return result;
		}

		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
			Pair other = (Pair) obj;
			if (!getOuterType().equals(other.getOuterType()))
				return false;
			if (x != other.x)
				return false;
			if (y != other.y)
				return false;
			return true;
		}

		private AncientMessages getOuterType() {
			return AncientMessages.this;
		}

		@Override
		public String toString() {
			return "Pair [x=" + x + ", y=" + y + "]";
		}
		
		
	}
	
//	static final int[] dr = {1,1,0,-1,-1,-1,0,1};// trick to explore an implicit 2D Grid
//	static final int[] dc = {0,1,1,1,0,-1,-1,-1}; // S, SE, E, NE, N, NW, W, SW neighbors
	
	static final int[] dr = {-1,0,1,0};// trick to explore an implicit 2D Grid
	static final int[] dc = {0,-1,0,1}; // S, SE, E, NE, N, NW, W, SW neighbors
	
	int floodfill(int r, int c, int c1, int c2 ){// return the size of CC
//		if(r<0||r>=H||c<0||c>=W)// outside grid
		if(r<0||r>=map.length||c<0||c>=map[r].length)
			return 0;
		if(map[r][c]!=c1)// does not have color c1
		{
			if(map[r][c]==color_to_saved){
				if(level==1)
					lvl1.add(new Pair(r, c));
				else if(level==2)
					lvl2.add(new Pair(r, c));
			}
			return 0;
		}
		int ans = 1; // adds 1 ke ans karena vertex (r,c) memiliki c1 sebagai color
		map[r][c] = c2; // now recolors vertex ( r,c ) untuk menghindari cycling
		for(int d=0;d<dr.length;d++)
			ans += floodfill(r+dr[d], c+dc[d], c1, c2);
		return ans;
	}
	
	String toPrintString(int[] map){
		String temp = "";
		for(int i=0;i<map.length;i++){
			temp+=(map[i]==1)?"x":".";
		}
		return temp;
	}
	
	int hexToInt(char in){
		switch (in) {
		case '0':
		case '1':
		case '2':
		case '3':
		case '4':
		case '5':
		case '6':
		case '7':
		case '8':
		case '9':
			return Integer.parseInt(in+"");
		case 'a':
		case 'b':
		case 'c':
		case 'd':
		case 'e':
		case 'f':
			return (in-'a')+10;
		}
		return -99;
	}
	
	static final int[][] hex = {
			{0,0,0,0},// 0
			{0,0,0,1},// 1
			{0,0,1,0},// 2
			{0,0,1,1},// 3
			{0,1,0,0},// 4
			{0,1,0,1},// 5
			{0,1,1,0},// 6
			{0,1,1,1},// 7
			{1,0,0,0},// 8
			{1,0,0,1},// 9
			{1,0,1,0},// 10
			{1,0,1,1},// 11
			{1,1,0,0},// 12
			{1,1,0,1},// 13
			{1,1,1,0},// 14
			{1,1,1,1},// 15
	};
}
