package norman.uva;

import java.util.ArrayList;
import java.util.List;

import norman.template.template;

/**
 * @author M Normansyah (m.normansyah@samsung.com)
 * Ternyata yang jadi recursive backtracking itu ternyata permutasi, karena posisi berbeda-beda.
 *
 * Ini yang diambil yang pertama kali ditemui, seharusnya juga dilihat dari jumlah yang diambil.
 */
public class CD extends template{

	public CD() {
		super("CD", "CD", LINUX);
	}

	@Override
	public void doSomething() {
		// + demo code here
		/*
		 * tracks = new int[]{1,3,4}; not = 3; n = 5; calculate(n);
		 */
		// - demo code here

		// + work code here
		A: while (true) {
			n = getInput().nextInt();// exceed limit this, then it the value
			not = getInput().nextInt();// number of tracks
			tracks = new int[not];
			currentHighest = new int[not];// this is save
			data = new ArrayList<>();
			for (int i = 0; i < not; i++)
				data.add(getInput().nextInt());

			calculateCD(0);

			if (!getInput().hasNext()) {
				break A;
			}
			alreadyFind = false;
		}
		// - work code here
	}

	/**
	 * @param n limit dari jumlah tracks
	 * @return
	 */
	void calculateCD(int n){
//		for (int i = data.size()-1; i >= 1; i--) {
		for (int i = 1; i <= data.size(); i++) {
			genPermutation(tracks, n, data, i);
		}
		if(!alreadyFind){
			int total = 0;
			for (int j = 0; j < currentHighestLength; j++) {
				System.out.print(""+ currentHighest[j]+ " ");
				total += currentHighest[j];
			}System.out.println("sum:"+total);
		}
	}


	/**
	 * How to stop this method if it find the result.
	 * @param array
	 * @param k
	 * @param data
	 * @param limit
	 */
	void genPermutation(int[] array, int k, List<Integer> data, int limit){

		if(k==limit){
			int compareTotal = 0, total = 0;
			for (int i = 0; i < array.length; i++) {
				total += array[i];// yang baru
				compareTotal += currentHighest[i];// yang lama
			}
			if(total > compareTotal && total <= n){

				if(total == n){
					if(!alreadyFind){
						alreadyFind = true;
						for (int i = 0; i < limit; i++) {
							System.out.print(""+ array[i]+ " ");
						}System.out.println("sum:"+total);
					}
				}

				// place in instance variable
				currentHighest = new int[array.length];
				for (int i = 0; i < array.length; i++) {
					currentHighest[i] = array[i];
				}
				currentHighestLength = limit;
			}
			return;
		}

		for (int i = 0; i < array.length; i++) {
			if(alreadyFind){
				break;
			}
			boolean used = false;
			for (int j = 0; j < k; j++)
				if(array[j] == data.get(i))
					used = true;

			if(!used){
				array[k] = data.get(i);
				genPermutation(array, k+1, data, limit);
			}
		}
	}

	int not, n;
	int[] tracks;
	List<Integer> data;
	int[] currentHighest;
	int currentHighestLength;
	boolean alreadyFind;
}
