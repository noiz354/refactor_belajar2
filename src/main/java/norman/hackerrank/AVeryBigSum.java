package norman.hackerrank;

import norman.template.template;
import norman.template.template_utility;

public class AVeryBigSum extends template {

	public AVeryBigSum() {
		super("AVeryBigSum", "AVeryBigSum", LINUX);
	}
	
	@Override
	public void doSomething() {
		while(true){
			if(!getInput().hasNext()){
				break;
			}
			int numInt = getInput().nextInt();
			long result = 0;
			for(int i=0;i<numInt;i++){
				result += getInput().nextLong();
			}
//			System.out.println(result);
			template_utility.print(getOutput(), result+"", true);// print to a file
		}
	}
}
