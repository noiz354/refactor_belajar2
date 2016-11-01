import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class SolutionEm {
	
	/*
	 * Complete the function below.
	 */

	    static int totalCellsVisited(int n, int m) {
	        movement = new HashMap<>();
			movement.put(ATAS_UP, new Pair(-1, 0, ATAS_RIGHT));
			movement.put(ATAS_RIGHT, new Pair(0, 1, ATAS_BOTTOM));
			movement.put(ATAS_LEFT, new Pair(0, -1, ATAS_UP));
			movement.put(ATAS_BOTTOM, new Pair(1, 0, ATAS_LEFT));
	        grid = new int[n][m];
	        grid[0][0] = 1;
	        transverse(0,0,1, ATAS_UP);
	        return res;
	    }

	    static int res;
		static int[][] grid;
		static final int ATAS_UP = 0, ATAS_RIGHT = 1, ATAS_LEFT = 2, ATAS_BOTTOM=3;
		static Map<Integer, Pair> movement ;
		static class Pair{
			int addX, addY;
			int RIGHT_STATUS;

			public Pair(int addX, int addY, int RIGHT) {
				this.addX = addX;
				this.addY = addY;
				this.RIGHT_STATUS = RIGHT;
			}
			
		}
		static void transverse(int x, int y, int count, int up){
//			if(count == 10){
//				return;
//			}
//			System.out.println("x "+x+" y "+y+" count "+count);
			Pair adder = movement.get(up);
//			whichWay(adder);
//			System.out.println("keluar zona : "+exitZone(x, y, adder));
//			int upTemp =up; 
//			while(exitZone(x, y, adder)){
//				adder = rotate(upTemp);
//				upTemp = rotateStatus(upTemp);
//				whichWay(adder);
//			}
			int counter =0;
			int upTemp =up; 
			while ( exitZone(x, y, adder) || grid[x+adder.addX][y+adder.addY] != 0){// selama tidak 0
				if(counter > 3){
					res = count;
					return;
				}
				adder = rotate(upTemp);
				upTemp = rotateStatus(upTemp);
//				whichWay(adder);
				counter++;
			}
			
			grid[x+adder.addX][y+adder.addY] = ++count;
			transverse(x+adder.addX, y+adder.addY, count, adder.RIGHT_STATUS);
		}
		
		static void printGrid(int[][] grid){
			for(int i=0;i<grid.length;i++){
				System.out.println(Arrays.toString(grid[i]));
			}
		}
		
		static int rotateStatus(int up){
			switch (up) {
			case ATAS_BOTTOM:
				return ATAS_LEFT;
			case ATAS_UP:
				return ATAS_RIGHT;
			case ATAS_LEFT:
				return ATAS_UP;
			case ATAS_RIGHT:
				return ATAS_BOTTOM;
			default:
				return -1;
			}
		}
		
		static Pair rotate(int up){
			switch (up) {
			case ATAS_BOTTOM:
				return movement.get(ATAS_LEFT);
			case ATAS_UP:
				return movement.get(ATAS_RIGHT);
			case ATAS_LEFT:
				return movement.get(ATAS_UP);
			case ATAS_RIGHT:
				return movement.get(ATAS_BOTTOM);
			default:
				return null;
			}
		}
		
		static boolean exitZone(int x, int y, Pair adder){
			int xNext = x+adder.addX;
			int yNext = y+adder.addY;
//			System.out.println("xNext "+xNext+" yNext "+yNext);
			return !(xNext >= 0 && xNext < grid.length && yNext >= 0 && yNext < grid[xNext].length);
		}
		
		/**
		 * nge print arah kanan
		 * @param adder
		 */
		static void whichWay(Pair adder){
			System.out.print("arah kanan : ");
			switch (adder.RIGHT_STATUS) {
			case ATAS_BOTTOM:
				System.out.println("bawah");
				break;

			case ATAS_UP:
				System.out.println("atas");
				break;

			case ATAS_RIGHT:
				System.out.println("kanan");
				break;

			case ATAS_LEFT:
				System.out.println("kiri");
				break;

			default:
				break;
			}
		}

		 public static void main(String[] args){
		        Scanner in = new Scanner(System.in);
		        int res;
		        int _n;
		        _n = Integer.parseInt(in.nextLine());
		        
		        int _m;
		        _m = Integer.parseInt(in.nextLine());
		        
		        res = totalCellsVisited(_n, _m);
		        System.out.println(res);
		        
		    }
	
}
