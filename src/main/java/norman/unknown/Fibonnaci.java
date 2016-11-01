package norman.unknown;

import java.util.Scanner;

/**
 * Generate fibonacci with memoized
 * @author M Normansyah (m.normansyah@samsung.com)
 *
 */
public class Fibonnaci {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int index = 0;
		System.out.print("Enter input : ");
		index = sc.nextInt();
		System.out.println();
		
		Fibonnaci obj = new Fibonnaci();
		obj.initTable();
		System.out.println(obj.fib(index));
		for(int i=0;i<10;i++){
			System.out.println(obj.tables[i]);
		}
	}
	
	int[] tables;
	
	private void initTable(){
		tables = new int[2_000_000];
		tables[1] = 1;
		tables[2] = 1;
	}
	
	private int fib(int index){
//		System.out.println("index "+index);
		if(index == 1 || index == 2){
			return 1;
		}
		if(tables[index] != 0){
//			System.out.println("masuk sini !!!");
			return tables[index];
		}
		int result = fib(index-1)+fib(index-2);
//		System.out.println("index "+ index + " result "+ result);
		tables[index] = result;
		return result;
	}
}
