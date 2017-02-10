package norman.uva;

import norman.template.Template;

import java.util.Arrays;
import java.util.Comparator;

/**
 * http://mathcentral.uregina.ca/mp/archives/previous2003/nov03sol.html
 * @author M Normansyah (m.normansyah@samsung.com)
 *
 */
public class TheBusDriverProblem extends Template {

	public TheBusDriverProblem() {
		super("TheBusDriverProblem", "TheBusDriverProblem", LINUX);
	}

	@Override
	public void doSomething() {
		A : while(true){
			int n = getInput().nextInt();
			int d = getInput().nextInt();
			int r = getInput().nextInt();
			if(!getInput().hasNext()){
				break A;
			}
//			System.out.println("n "+n+" d "+d+" r "+r);
			if(n== 0 && d==0&&r==0){
				break A;
			}
			Integer[] morningLength = new Integer[n];
			Integer[] afternoonLength = new Integer[n];
			for(int i=0;i<morningLength.length;i++){
				morningLength[i] = getInput().nextInt();
			}
			for(int i=0;i<afternoonLength.length;i++){
				afternoonLength[i] = getInput().nextInt();
			}
			Arrays.sort(morningLength, new Comparator<Integer>() {
				@Override
				public int compare(Integer arg0, Integer arg1) {
					return arg1.compareTo(arg0);
				}
			});
//			System.out.println("morningLength");
//			printAll(morningLength);
			Arrays.sort(afternoonLength, new Comparator<Integer>() {
				@Override
				public int compare(Integer arg0, Integer arg1) {
					return arg0.compareTo(arg1);
				}
			});
//			System.out.println("afternoonLength");
//			printAll(afternoonLength);
			int overTime = 0;
			for(int i=0;i<n;i++){
				int checkPositif = morningLength[i]+afternoonLength[i]-d;
				if(checkPositif>0)
					overTime += checkPositif*r;
			}
			System.out.println(overTime);// "overTime "+
		}
	}

	private void printAll(Integer[] data){
		for(Integer dataTemp : data){
			System.out.println(dataTemp);
		}
	}

}
