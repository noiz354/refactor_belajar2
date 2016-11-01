package norman.hackerrank;

import java.io.IOException;
import java.util.Arrays;

import norman.template.template;
import norman.template.template_utility;

/**
 * problem : https://www.hackerrank.com/challenges/tutorial-intro
 * @author M. Normansyah
 * 1:50:18 PM
 * 
 * try to solve using quicksort. 
 * 
 * salah ngira soal, ini mah gampang
 */
public class IntroSorting extends template {

	public IntroSorting(int envType) {
		super("IntroSorting", "IntroSorting", envType, true);
	}

	@Override
	public void doSomething() {
		while(true){
			if(!getInput().hasNext()){
				break;
			}
			int V = getInput().nextInt();
			int arrSize = getInput().nextInt();
			int[] arr = new int[1005];
			for(int i=0;i<arrSize;i++){
				arr[getInput().nextInt()] = i;
			}
			
//			if(debug){
//				template_utility.print(getOutput(), "before sorting :\n"+Arrays.toString(arr), true);
//			}
//			Quicksort(arr, 0, arrSize-1);
//			if(debug){
//				template_utility.print(getOutput(), "after sorting :\n"+Arrays.toString(arr), true);
//			}
			if(debug){
				template_utility.print(getOutput(), ""+arr[V], true);
			}
		}
	}
}
