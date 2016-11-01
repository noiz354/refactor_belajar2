package norman.uva;

import java.util.Arrays;

import norman.template.template;
import norman.template.template_utility;

/**
 * 
 * @author m.normansyah 28-1-2015
 * parsing the input and coret-coret solusinya di kertas.
 * 
 * jadi ada failed di test case 10 & 17 
 * seharusnya b dan w secara berturut2, kalau dibaca-baca
 * misalkan row 0 sebagai start contoh 0,1 maka 0,2 tidak boleh diakses harus maju kedepan,
 * kayaknya itu yang buat gagal deh, besok lanjut lagi
 */
public class llGiocoDellX extends template {

	public llGiocoDellX() {
		super("llGiocoDellX", "llGiocoDellX", WINDOWS);
	}

	@Override
	public void doSomething() {
		int N = 0, tC = 1;
		while((N = getInput().nextInt())!=0){
			char[][] board = new char[N][N];// 2-200
			processBoard = new char[N][N];
			for(int i=0;i<N;i++){
				String temp = getInput().next();
				for(int j=0;j<N;j++){
					board[i][j]=temp.charAt(j);
				}
			}
			
			// test index checking
//			floodfill(4, -1, 2, 'b', 'c');
//			floodfill(4, 4, 2, 'b', 'c');
//			floodfill(4, 1, -1, 'b', 'c');
//			floodfill(4, 1, 4, 'b', 'c');
//			floodfill(4, -1, 4, 'b', 'c');
//			floodfill(4, 1, 3, 'b', 'c');
			
			template_utility.print(getOutput(), (N + " "), false);
			template_utility.print(getOutput(), (tC++ + " "), false);
			
			row = true;
			for(int i=0;i<N;i++){
//				processBoard = Arrays.copyOf(board, board.length);
				for(int j=0;j<board.length;j++)
					for(int k=0;k<board[j].length;k++)
						processBoard[j][k] = board[j][k];
//				template_utility.print(getOutput(),"start "+0+","+i,true);
//				template_utility.print(getOutput(),"before:",true);
//				printMap();
				floodfill(N, 0, i, board[0][i], '.');
//				template_utility.print(getOutput(),"after:",true);
//				printMap();
			}
			row = false;
//			template_utility.print(getOutput(), (char)winner+"", true);
			if(winner!=0){
				template_utility.print(getOutput(), (char)winner+"", true);
			}else{
				col = true;
				for(int i=0;i<N;i++){
					for(int j=0;j<board.length;j++)
						for(int k=0;k<board[j].length;k++)
							processBoard[j][k] = board[j][k];
	//				template_utility.print(getOutput(),"start "+i+","+0,true);
	//				template_utility.print(getOutput(),"before:",true);
	//				printMap();
					floodfill(N, i, 0, board[i][0], '.');
	//				template_utility.print(getOutput(),"after:",true);
	//				printMap();
				}
				col = false;
				template_utility.print(getOutput(), (char)winner+"", true);
			}
		}
	}
	
	void printMap(){
		for(int i=0;i<processBoard.length;i++){
			for(int j=0;j<processBoard[i].length;j++){
//				System.out.print((char)processBoard[i][j]);
				template_utility.print(getOutput(),(char)processBoard[i][j]+"",false);
			}
//			System.out.println();
			template_utility.print(getOutput(),"",true);
		}
//		System.out.println();
		template_utility.print(getOutput(),"",true);
	}
	
	char[][] board;
	char[][] processBoard;
	boolean row, col;
	char winner;
	
	void floodfill(int N, int r, int c, char c1, char c2){
//		template_utility.print(getOutput(), r+" "+c, true);
//		System.out.println(r+" "+c);
		
//		if((r<0||r>=N)||(c<0||c>=N))
		if(!(r>=0&&r<N&&c>=0&&c<N))
			return;
		
		if(processBoard[r][c]!=c1)
			return;
		
		if(row)
			if(r==processBoard.length-1)
				winner = c1;
		
		if(col)
			if(c==processBoard[r].length-1)
				winner = c1;
		
		processBoard[r][c] = c2;
		
		floodfill(N, r-1, c-1, c1, c2);
		floodfill(N, r-1, c, c1, c2);
		floodfill(N, r, c-1, c1, c2);
		floodfill(N, r, c+1, c1, c2);
		floodfill(N, r+1, c, c1, c2);
		floodfill(N, r+1, c+1, c1, c2);
	}

}
