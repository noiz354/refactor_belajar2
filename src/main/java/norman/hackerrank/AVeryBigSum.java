package norman.hackerrank;

import norman.template.Template;
import norman.template.TemplateUtility;

public class AVeryBigSum extends Template {

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
            TemplateUtility.print(getOutput(), result + "", true);// print to a file
        }
    }
}
