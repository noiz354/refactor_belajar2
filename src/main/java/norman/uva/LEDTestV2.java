package norman.uva;

import java.util.Arrays;

import norman.template.template;

/**
 * 
 * @author m.normansyah
 *
 */
public class LEDTestV2 extends template{

	public LEDTestV2() {
		super("LEDTest", "LEDTest", WINDOWS);
	}

	@Override
	public void doSomething() {
		while((n = getInput().nextInt())!=0){
			Cs = new char[n][];
			CsInt = new int[n][];
			
			for(int i=0;i<n;i++){
				char[] s = getInput().next().toCharArray();
				Cs[i] = s;
				CsInt[i] = new int[7];
				for(int j=0;j<Cs[i].length;j++){
					CsInt[i][j] = (Cs[i][j] == 'Y') ? 1 : 0;
				}
			}
			
			System.out.println("print input");
			for(int i=0;i<n;i++){
				System.out.println(Arrays.toString(Cs[i]));
			}
			
			match = false;
			for(int i=9;i>=n-1;i--){
				System.out.println("i "+i);
				solve(0, i);
			}
			
			System.out.println();
		}
	}
	
	void solve(int lineI, int digitI){
		System.out.println("lineI "+lineI+" ["+Arrays.toString(CsInt[lineI])+"] "
					+" digitI "+digitI+" [ "+Arrays.toString(digitInt[digitI])+" ] ");
		System.out.println("lineI [ "+lineI+" ] == n [ "+n+" ] : "+(lineI == n));
		if(lineI == n){
			match = true;
		}
		
		boolean checkSisa = false;
		for(int i=0;i<digitInt[digitI].length;i++){
			checkSisa = CsInt[lineI][i] == digitInt[digitI][i];
		}
		System.out.println("check sisa : "+checkSisa);
	}
	
	boolean match;
	int n;
	char[][] Cs;
	int[][] CsInt;
	final static int[][] digitInt = {
			{1,1,1,1,1,1,0},// 0
			{0,1,1,0,0,0,0},// 1
			{1,1,0,1,1,0,1},// 2
			{1,1,1,1,0,0,1},// 3
			{0,1,1,0,0,1,1},// 4
			{1,0,1,1,0,1,1},// 5
			{1,0,1,1,1,1,1},// 6
			{1,1,1,0,0,0,0},// 7
			{1,1,1,1,1,1,1},// 8
			{1,1,1,1,0,1,1},// 9
	};
	
}
