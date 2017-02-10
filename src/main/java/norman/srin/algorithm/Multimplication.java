package norman.srin.algorithm;

import norman.template.Template;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class Multimplication extends Template {

	int[] values = {3, 5};
	Set<Integer> temp;

	public Multimplication() {
		super("Multimplication", "Multimplication", LINUX);
	}

	@Override
	public void doSomething() {
		int TC = getInput().nextInt();
		int total = TC;
		while(TC-- > 0){
			System.out.println("Case #"+(total-TC));
			int limit = getInput().nextInt();

			int i = 1, temp_values =0, temp_values2 =0;
			// precalculate 3
			temp = new HashSet<Integer>();
			A : for(i=1;i<=1000;i++){
				temp_values = values[0]*i;
				temp_values = values[1]*i;
				if(temp_values>limit-1){
					System.out.println("give me break!!! A "+ temp_values);
					break A;
				}
				temp.add(temp_values);
			}
			// precalculate 4
			temp_values =0;
			B : for(i=1;i<=1000;i++){
				if(temp_values>limit-1){
					System.out.println("give me break!!! B "+ temp_values);
					break B;
				}
				temp.add(temp_values);
			}
			int result = 0;
			for(Iterator<Integer> iter = temp.iterator();iter.hasNext();){
				result += iter.next();
			}
			System.out.println(result);
		}
	}
}
