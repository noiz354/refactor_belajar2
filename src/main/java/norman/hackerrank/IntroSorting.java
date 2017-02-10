package norman.hackerrank;

import norman.template.Template;
import norman.template.TemplateUtility;

/**
 * problem : https://www.hackerrank.com/challenges/tutorial-intro
 * @author M. Normansyah
 * 1:50:18 PM
 * 
 * try to solve using quicksort. 
 * 
 * salah ngira soal, ini mah gampang
 */
public class IntroSorting extends Template {

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
//				TemplateUtility.print(getOutput(), "before sorting :\n"+Arrays.toString(arr), true);
//			}
//			Quicksort(arr, 0, arrSize-1);
//			if(debug){
//				TemplateUtility.print(getOutput(), "after sorting :\n"+Arrays.toString(arr), true);
//			}
			if(debug){
                TemplateUtility.print(getOutput(), "" + arr[V], true);
            }
        }
	}
}
