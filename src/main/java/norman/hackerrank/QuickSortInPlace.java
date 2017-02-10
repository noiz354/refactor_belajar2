package norman.hackerrank;

import norman.template.Template;
import norman.template.TemplateUtility;

import java.util.Arrays;

/**
 * Print the entire array on a new line at the end of every partitioning method. 
 * https://www.hackerrank.com/challenges/quicksort3, salah bukan itu yang diminta
 * @author M. Normansyah
 * 3:13:21 PM
 */
public class QuickSortInPlace extends Template {

	public QuickSortInPlace() {
		super("QuickSortInPlace", "QuickSortInPlace", LINUX, true);
	}

	@Override
	public void doSomething() {
		while(true){
			if(!getInput().hasNext()){
				break;
			}
			int arrayLength = getInput().nextInt();
			int[] array = new int[arrayLength];
			for(int i=0;i<arrayLength;i++){
				array[i] = getInput().nextInt();
			}
			Quicksort(array, 0, arrayLength-1);
		}
	}

	void Quicksort(int[] array, int low, int high){
		if(low<high){
			int pivot_location = Partition(array, low, high);
			Quicksort(array, low, pivot_location-1);
			if(debug){
                TemplateUtility.print(getOutput(), "" + Arrays.toString(array), true);
            }
            Quicksort(array, pivot_location+1, high);
			if(debug){
                TemplateUtility.print(getOutput(), "" + Arrays.toString(array), true);
            }
        }
	}
	
	int Partition(int[] array, int low, int high){
		int pivot = array[low];
		int leftwall = low;
		
		for(int i=low+1;i<=high;i++){
			if(array[i]<pivot){
				leftwall = leftwall + 1;
				swap(array, i, leftwall);
			}
		}
		
		swap(array, low, leftwall);
		return leftwall;
	}

	void swap(int[] array, int from, int to){
		int temp = array[from];
		array[from] = array[to];
		array[to] = temp;
	}
}
