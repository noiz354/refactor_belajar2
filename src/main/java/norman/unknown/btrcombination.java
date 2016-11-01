package norman.unknown;

import java.util.ArrayList;
import java.util.List;

/**
 * 
 * @author M Normansyah (m.normansyah@samsung.com)
 * 
 */
public class btrcombination {
	
	/**
	 * buat permutasi, kalau kombinasi artinya jika 10,5,7,4 sama dengan 7,5,4,10
	 * @param array
	 * @param k
	 * @param data
	 */
	static void genPermutation(int[] array, int k, List<Integer> data){
		
		if(k==4){
			for (int i = 0; i < array.length; i++) {
				System.out.print(" "+ array[i]+ " ");
			}System.out.println();
			return;
		}
		
		for (int i = 0; i < array.length; i++) {
			boolean used = false;
			for (int j = 0; j < k; j++)
				if(array[j] == data.get(i))
					used = true;
			
			if(!used){
				array[k] = data.get(i);
				genPermutation(array, k+1, data);
			}
		}
	}
	
	public static void main(String[] args) {
		int[] array = new int[4];// this should be equals with data
		int k = 0;
		List<Integer> data = new ArrayList<>();
		data.add(10);
		data.add(5);
		data.add(7);
		data.add(4);
		genPermutation(array, k, data);
	}
}
