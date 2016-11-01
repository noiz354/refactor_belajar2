package norman.srin.algorithm;

import norman.template.template;

public class Palinsum extends template {

	public Palinsum() {
		super("Palinsum", "Palinsum", LINUX);
	}

	@Override
	public void doSomething() {
		int TC = getInput().nextInt();
		int total = TC;

		while(TC-- > 0){
			System.out.println("Case #"+(total-TC));
			int number = getInput().nextInt();

			int result = 0;
			for(int i=1;i<=number;i++){
				boolean palin = isPalindrome(Integer.toString(i));
				if(palin){
					result++;
				}
			}
			System.out.println("result "+result);
		}
	}

	private boolean isPalindrome(String number){
		boolean result = false;
		if(number.length() == 1 || number.equals("")){
			return ( result = true );
		}
		String head = number.substring(0, 1);
		String tail = number.substring(number.length()-1, number.length());

		if(!head.equals(tail)){
			return ( result = false ) ;
		}else if(head.equals(tail)){
			String newNumber = number.substring(1, number.length()-1);
			return isPalindrome(newNumber);
		}

		return result;
	}
}
