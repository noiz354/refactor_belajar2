package norman.uva;

import java.util.Arrays;

import norman.template.template;

public class StationBalance extends template {

	public StationBalance() {
		super("StationBalance", "StationBalance", LINUX);
	}

	@Override
	public void doSomething() {
		A : while(true){
			if(!getInput().hasNext()){
				break A;
			}

			int chambers = getInput().nextInt();
			int specimentNumber = getInput().nextInt();
			int additionSpeciment = 0;
			if(specimentNumber<chambers*2){
				additionSpeciment = 2 * chambers - specimentNumber;
			}

			int[] speciments = new int[specimentNumber+additionSpeciment];
			for(int i=0;i<specimentNumber;i++){
				speciments[i] = getInput().nextInt();
			}

			// read input
			System.out.println("number of chamber : "+ chambers);
			System.out.println("number of spciment : "+ specimentNumber);
			System.out.println("before sort -> "+Arrays.toString(speciments));

			// sort array
			Arrays.sort(speciments);
			System.out.println("after sort -> "+Arrays.toString(speciments));

			// calculate average
			int average = 0;
			for(int i=0;i<speciments.length;i++){
				average += speciments[i];
			}
			average = average / chambers;
			System.out.println("average : "+ average);

			// calculate optimal imbalance
			int imbalance = 0;
			for(int i=0, j=-1;i<speciments.length/2;i++,j--){
				System.out.println(speciments[i]+" & "+speciments[speciments.length+j]+" & "+average);
				imbalance += Math.abs(speciments[i]+speciments[speciments.length+j]-average);
			}
			System.out.println("imbalance "+imbalance);

		}
	}

}
