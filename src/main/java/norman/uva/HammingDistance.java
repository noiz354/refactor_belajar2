package norman.uva;

import java.util.Arrays;

import norman.template.template;

/**
 * started at 23-3-2015
 * finished at 23-3-2015
 * uva 729
 * @author M Normansyah (m.normansyah@samsung.com)
 * caranya sama dengan print all menggunakan rekursif.
 */
public class HammingDistance extends template {

	public HammingDistance() {
		super("HammingDistance", "HammingDistance", LINUX);
	}

	@Override
	public void doSomething() {
		A: while(true){
			if(!getInput().hasNext()){
				break A;
			}
			int N = getInput().nextInt();
			int H = getInput().nextInt();
			// create origin, already assign 0
			int[] origin = new int[N];
			for(int i=0;i<origin.length;i++){
				origin[i] = 0;
			}
			// create target, values are between 0's and 1's
			int[][] target = new int[N][2];
			for(int i=0;i<target.length;i++){
				for(int j=0;j<target[i].length;j++){
					target[i][j] = j;
				}
			}

			// print the targets
//			for(int[] temp : target){
//				System.out.println(Arrays.toString(temp));
//			}
			int[] result = new int[N];
			hammingDistance(target, origin, result, 0, H);
		}// end of while
	}

	private void hammingDistance(int[][] target, int[] origin, int[] result, int index, int H){
		if(index == origin.length){
			int count = 0;
			for(int i=0;i<origin.length;i++){
				if(origin[i] != result[i]){
					count++;
				}
			}
			if(count == H){
				System.out.println(Arrays.toString(result)+" <-- ini benar");
			}else{
				System.out.println(Arrays.toString(result)+" <-- ini salah");
			}
			return;
		}

		for(int i=0;i<target[index].length;i++){
//			System.out.println("[index] "+index+" [i] "+ i);
			int temp = target[index][i];
			result[index] = temp;
			hammingDistance(target, origin, result, index+1, H);
		}
	}

}
