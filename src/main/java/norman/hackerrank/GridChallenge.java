package norman.hackerrank;

import norman.template.Template;

import java.util.Arrays;

/**
 * https://www.hackerrank.com/challenges/grid-challenge
 * @author SRIN
 * started at 11-6-2015
 *
 */
public class GridChallenge extends Template {

    int[][] map;
    boolean[][] bolMap;

	public GridChallenge() {
		super("GridChallenge", "GridChallenge", LINUX);
	}

	@Override
	public void doSomething() {
		int TC = getInput().nextInt();
		for(int i=1;i<=TC;i++){

			// squared size N*N
			int N = getInput().nextInt();
			map = new int[N][N];
			bolMap = new boolean[N][N];
			for(int j=0;j<map.length;j++)
				Arrays.fill(bolMap[j], true);

			// read input
			for(int j=0;j<N;j++){
				String temp = getInput().next();
				for(int k=0;k<temp.length();k++){
					map[j][k] = temp.charAt(k);
				}
			}

			// TODO how to sort while mapping the value

			// sort using default Java
			for(int j=0;j<map.length;j++){
//				Arrays.sort(map[j]);
				new InsertionSorter(map[j]).sort();
//				for(int k=0;k<map[j].length;k++)
//					System.out.print((char)map[j][k]);
//				System.out.println();
			}

			// mapping the value
			boolean res = true;
			for(int j=0;j<map.length;j++){
				for(int k=0;k<map[j].length;k++){
					if(j-1>=0&&j-1<N&&k-1>=0&&k-1<N)
						bolMap[j][k]=map[j-1][k-1]<=map[j-1][k-1];
					if(j+1>=0&&j+1<N)
						bolMap[j][k] = bolMap[j][k]&&(map[j+1][k]>=map[j][k]);

					res = res && bolMap[j][k];
				}
			}

			// show boolean map
//			for(int j=0;j<map.length;j++){
//				System.out.println(Arrays.toString(bolMap[j]));
//			}

			if(res)
				System.out.println("YES");
			else
				System.out.println("NO");



		}
	}

	class InsertionSorter {
		public int[] a;

		public InsertionSorter(int[] anArray){
			a = anArray;
		}

		public void sort(){
			for(int i=1;i<a.length;i++){
				int next = a[i];
				// Find the insertion location
				// Move all larger elements up
				int j = i;
				while(j > 0 && a[j-1] > next){
					a[j] = a[j-1];
					j--;
				}
				// Insert the element
				a[j] = next;
			}
		}
	}

}
