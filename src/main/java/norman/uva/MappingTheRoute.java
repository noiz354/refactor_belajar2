package norman.uva;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import norman.template.template;
import norman.template.template_utility;

/**
 * uva 614 dfs i guess
 * @author Normansyah Putra
 * 
 * bug at test case 7
 * 
 * wrong at adding adjacency list. harusnya pengecekan searah jarum jam.
 * Failed at Test Case 7
 *
 */
public class MappingTheRoute extends template {

	public MappingTheRoute() {
		super("MappingTheRoute", "MappingTheRoute", WINDOWS);
	}

	@Override
	public void doSomething() {
		int count = 1;
		while(true){
			h = getInput().nextInt();// height
			w = getInput().nextInt();// width
			sx = getInput().nextInt();
			sy = getInput().nextInt();
			ex = getInput().nextInt();
			ey = getInput().nextInt();
			if((h==0)&&(w==0)&&(sx==0)&&(sy==0)&&(ex==0)&&(ey==0)){
				break;
			}
			
			map_harfiah = new int[h][w];
			blockedmap = new boolean[h][w][5];
			vis = new boolean[h][w];
			vis_count = new int[h][w];
			adjList = new HashMap<Coor, List<Coor>>();
			
			for(int i=0;i<h;i++)
				for(int j=0;j<w;j++){
					map_harfiah[i][j] = getInput().nextInt();
					adjList.put(new Coor(i, j), new ArrayList<Coor>());
					createBlockedMap(new Coor(i,j), map_harfiah[i][j]);
				}
			
			for(int i=0;i<h;i++)
				for(int j=0;j<w;j++)
					for(int k=1;k<=4;k++)
					{
						List<Coor> tmp = adjList.get(new Coor(i, j));
						if(!blockedmap[i][j][k])
						{
							Coor tmp2 = new Coor(i+adding[k-1][0], j+adding[k-1][1]);
							tmp.add(tmp2);
						}
						adjList.put(new Coor(i, j), tmp);
					}
			
			start = new Coor(sx-1, sy-1);
			end = new Coor(ex-1, ey-1);
			go(start,0);

			if(count>1)
				template_utility.print(getOutput(), "", true);
			template_utility.print(getOutput(), "Maze "+count++, true);;
			
			template_utility.print(getOutput(), "", true);
			printBorder();
			for(int i=0;i<h;i++){
				printUpper(i);
				if(i==h-1)
					printBorder();
				else
					printLower(i);
			}
			template_utility.print(getOutput(), "", true);
		}
	}
	
	void printLower(int i){
		for(int j=0;j<w;j++){
			template_utility.print(getOutput(), "+", false);
			if(!blockedmap[i][j][4])
				template_utility.print(getOutput(), "   ", false);
			else
				template_utility.print(getOutput(), "---", false);
			if(j==w-1)
				template_utility.print(getOutput(), "+", false);
		}
		template_utility.print(getOutput(), "", true);
	}

	void printUpper(int i) {
		for(int j=0;j<w;j++){
			boolean b = vis[i][j] && vis_count[i][j]==0;
			boolean c = !vis[i][j] && vis_count[i][j]==0;
			if(c){
				if(blockedmap[i][j][1])
					template_utility.print(getOutput(), "|", false);
				else{
					template_utility.print(getOutput(), " ", false);
				}
				template_utility.print(getOutput(), "   ", false);
				if(j==w-1)
					template_utility.print(getOutput(), "|", false);
			}
			else if(b){
				if(blockedmap[i][j][1])
					template_utility.print(getOutput(), "|", false);
				else{
					template_utility.print(getOutput(), " ", false);
				}
				template_utility.print(getOutput(), "???", false);
				if(j==w-1)
					template_utility.print(getOutput(), "|", false);
			}else{
				if(blockedmap[i][j][1])
					template_utility.print(getOutput(), "|  ", false);
				else
					template_utility.print(getOutput(), "   ", false);
				template_utility.print(getOutput(), vis_count[i][j]+"", false);
				if(j==w-1)
					template_utility.print(getOutput(), "|", false);
				else
					template_utility.print(getOutput(), "", false);
			}
		}
		template_utility.print(getOutput(), "", true);
	}
	
	/**
	 * inspired by https://github.com/thnkndblv/UVa-Online-Judge-Solutions/blob/master/614%20-%20Mapping%20the%20Route/p614.cpp
	 * @param cur
	 * @param K
	 * @return
	 */
	boolean go(Coor cur, int K){
		vis[cur.x][cur.y] = true;
		 
		if(cur.equals(end)){
			vis_count[cur.x][cur.y] = K+1;
			return true;
		}
		for(int i=0;i<adjList.get(cur).size();i++){
			Coor adj = adjList.get(cur).get(i);
			if(!vis[adj.x][adj.y]){
				if(go(adj, K+1)){
					vis_count[cur.x][cur.y] = K+1;
					return true;
				}
			}
		}
		return false;
	}
	
	/**
	 * just print border
	 */
	void printBorder()
	{
	    for (int j=0; j<w; j++)
	    {
	        if ( j == w-1 ) {
	        	template_utility.print(getOutput(),"+",false);
	        }else{
	        	template_utility.print(getOutput(),"+",false);
	        	template_utility.print(getOutput(),"---",false);
	        }
	    }
	    template_utility.print(getOutput(),"---+",true);
	}
	
	void printCharArray(int[] array){
		for (int i = 0; i < array.length; i++) {
			System.out.print(array[i]);
		}
	}
	
	void printBlockedMap(boolean[] map){
		for(int i=1;i<=4;i++){
			if(map[i])
				System.out.print(arah(i)+" ");
		}
	}
	
	/**
	 * create blocked map according to clock-wise
	 * @param cur
	 * @param value
	 */
	void createBlockedMap(Coor cur, int value)
	{
		for(int i=1;i<=4;i++){
		// 1: kiri, 2: utara, 3: kanan, 4: selatan 
			Coor temp = new Coor(cur.x+adding[i-1][0], cur.y+adding[i-1][1]);
			if(isNotOutsideZone(temp)){
				if(isBlocked(value, i)){
					blockedmap[cur.x][cur.y][i]=true;
					blockedmap[temp.x][temp.y][inverse(i)]=true;
				}
			}else{
				blockedmap[cur.x][cur.y][i]=true;
			}
		}
	}
	
	// 1: kiri, 2: utara, 3: kanan, 4: selatan 
	int inverse(int value){
		switch (value) {
		case 1:
			return 3;
		case 2:
			return 4;
		case 3:
			return 1;
		case 4:
			return 2;
		default:
			return -99;
		}
	}
	
	String arah(int value){
		switch (value) {
		case 1:
			return "kiri";
		case 2:
			return "utara";
		case 3:
			return "kanan";
		default:
			return "selatan";
		}
	}
	
	/**
	 * 
	 * @param cur
	 * @return
	 * true jika tidak keluar zona
	 * false jika keluar zona
	 */
	boolean isNotOutsideZone(Coor cur){
		return
				cur.x >= 0 && cur.x < h
				&& cur.y >= 0 && cur.y < w;
	}

	/**
	 * 
	 * @param value 0,1,2,3 lihat comment
	 * @param curDir 1 utara, 2 selatan, 3 kanan, 4 kiri
	 * @return
	 */
	boolean isBlocked(int value, int curDir){
		boolean ret = false;
		switch (value) {
		// 1: kiri, 2: utara, 3: kanan, 4: selatan 
		case 1:// kalau 1 ada kanan
			switch (curDir) {
			case 3:// kanan
				ret = true;
				break;
			}
			break;
		case 2: // kalau 2 ada bawah
			switch (curDir) {
			case 4:// bawah
				ret = true;
				break;
			}
			break;
		case 3:// kalau 3 ada kanan dan bawah
			switch (curDir) {
			case 3:// bawah
			case 4:// kanan
				ret = true;
				break;
			}
			break;
		case 0 : // kalau 0 tidak ada kanan dan bawah
		default:
			// do nothing
			break;
		}
		return ret;
	}
	
	// height, width, starting_x, starting_y, end_x, end_y;
	int h, w, sx, sy, ex, ey;
	Coor start, end;
	
	// map, harfiah
	int[][] map_harfiah;
	boolean[][][] blockedmap;
	boolean[][] vis;
	int[][] vis_count;
	static final int[][] adding = {
		{0,-1},{-1,0},{0,1},{1,0}
	};
	
	// adjacency list
	Map<Coor, List<Coor>> adjList;
	
	class Coor{
		int x,y;
		public Coor(int x,int y){
			this.x = x;
			this.y = y;
		}
		
		@Override
		public String toString() {
			return "["+x+","+y+"]";
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
			Coor other = (Coor) obj;
			if (!getOuterType().equals(other.getOuterType()))
				return false;
			if (x != other.x)
				return false;
			if (y != other.y)
				return false;
			return true;
		}

		private MappingTheRoute getOuterType() {
			return MappingTheRoute.this;
		}
		
		
	}
}
