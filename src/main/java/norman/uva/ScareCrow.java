package norman.uva;

import norman.template.Template;

public class ScareCrow extends Template {

	public ScareCrow() {
		super("ScareCrow", "ScareCrow", LINUX);
	}

	@Override
	public void doSomething() {
		int testCase = getInput().nextInt();
		int totalTestCase = testCase;
		while(testCase-- > 0){
//			System.out.println("testCase "+ testCase);
			String field = null;
			int nChar = getInput().nextInt();
			field = getInput().next();
//			System.out.println("nChar "+nChar+" field "+ field);
			int total = 0;
			for(int i=0;i<field.length();i++){
				if(field.charAt(i) == '.'){
					i+=2;
					total++;
				}
			}// end of for
			System.out.println("Case "+(totalTestCase-testCase)+": "+total);
		}// end of while testCase
	}

}
