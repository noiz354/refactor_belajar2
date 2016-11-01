package norman.srin.algorithm;

import norman.template.template;

public class Evenfibo extends template {

	public Evenfibo() {
		super("Evenfibo", "Evenfibo", LINUX);
	}

	@Override
	public void doSomething() {
		int TC = getInput().nextInt();
		int total = TC;
		while(TC-- > 0){
			tables = new int[2_000_000];// init table here
			System.out.println("Case #"+(total-TC));
			int index = getInput().nextInt();
			System.out.println("index "+index);
			result_total = 0;// only for even
			fib(index);// calculate table, and add to total
			System.out.println(result_total);

		}
	}

	int result_total;
	int[] tables;
	private int fib(int index){
//		System.out.println("index "+index);
		if(index == 1 || index == 2){
			return 1;
		}
		if(tables[index] != 0){
//			System.out.println("index "+index+" tables[index] "+ tables[index]);
			return tables[index];
		}
		int result = fib(index-1)+fib(index-2);
//		System.out.println("result : "+result);
		if(result%2==0){
//			System.out.println("result%2 "+ result);
			result_total += result;
		}
		// just for questions
		tables[index] = result;
		return result;
	}

}
