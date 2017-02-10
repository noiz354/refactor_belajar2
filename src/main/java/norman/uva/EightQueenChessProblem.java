package norman.uva;

import norman.template.Template;

import java.util.Arrays;

public class EightQueenChessProblem extends Template {

	int row[], TC, a, b, lineCounter;

	public EightQueenChessProblem() {
		super("EightQueenChessProblem", "EightQueenChessProblem", LINUX);
	}

	@Override
	public void doSomething() {
		TC = getInput().nextInt();
		while(TC-- > 0){
			a = getInput().nextInt();// baris
			b = getInput().nextInt();// kolom
			row = new int[9];
			System.out.println("SOLN  COLUMN");
			System.out.println(" #    1 2 3 4 5 6 7 8\n\n");
			backtrack(1);// generate all possible 8! candidate solutions
			if(TC == 0){
				System.out.println();
			}
		}
	}

	boolean place(int col, int tryrow){
		for(int prev=1;prev<col;prev++){
			if(row[prev] == tryrow || (Math.abs(row[prev]-tryrow) == Math.abs(prev-col))){
				return false;
			}
		}
		return true;
	}

	void backtrack(int col){
		if(col == 4)
			return;
		for(int tryrow = 1; tryrow <= 8; tryrow++){
			System.out.println("col : "+col +" & tryrow : "+ tryrow);
			if(place(col, tryrow)){// kalau tidak ada yang bentrok.
				row[col] = tryrow;
				System.out.println(Arrays.toString(row));
				if(col == 8 && row[b] == a){
					System.out.printf("%2d    %d", ++lineCounter, row[1]);
					for(int j=2;j<=8;j++){
						System.out.printf(" %d", row[j]);
					}
					System.out.println();
				}else{
					backtrack(col+1);
				}
			}
		}
	}
}
