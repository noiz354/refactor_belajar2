package norman.srin.algorithm;

import java.util.ArrayList;
import java.util.List;

import norman.template.template;

public class Primadonuts extends template {

	public Primadonuts() {
		super("Primadonuts", "Primadonuts", LINUX);
	}

	@Override
	public void doSomething() {
		int TC = getInput().nextInt();
		int total = TC;

		int N = 1000;

		// initially assume all integers are prime
		isPrime = new boolean[N + 1];
		isPrime[1] = true;
		for (int i = 2; i <= N; i++) {
            isPrime[i] = true;
        }

		// mark non-primes <= N using Sieve of Eratosthenes
		for (int i = 2; i*i <= N; i++) {

            // if i is prime, then mark multiples of i as nonprime
            // suffices to consider mutiples i, i+1, ..., N/i
            if (isPrime[i]) {
                for (int j = i; i*j <= N; j++) {
                    isPrime[i*j] = false;
                }
            }
        }

		while(TC-->0){
			System.out.print("Case #"+(total-TC)+" : ");

			int N_ = getInput().nextInt();
			int C = getInput().nextInt();
			primesForPrint = new ArrayList<Integer>();

			// count primes
	        int primes = 0, total_primes =0;
	        for (int i = 1; i <= N_; i++) {
	            if (isPrime[i]) {
	            	primes++;
	            	total_primes += i;
	            	primesForPrint.add(i);
	            }
	        }

	        int centerPoint = 0, lastPoint = 0, lastIndex = primes-1, nearCenter = 0, startIndex = 0;

//	        System.out.println("C "+C);
//	        System.out.println("C*2 "+(C*2)+" C*2-1 "+(C*2-1)+" primes "+primes+" total "+total_primes+" last index "+lastIndex);
	        boolean isEven = (primes%2==0);
	        int length = isEven?C*2:C*2-1;
	        int remain = length;
	        centerPoint = (int) Math.floor(lastIndex/2);
	        remain--;
	        lastPoint = centerPoint+length/2;
	        remain -= length/2;
	        startIndex = centerPoint-remain;
//	        System.out.println("start "+ startIndex+" center "+centerPoint+" finish "+ lastPoint);


	        if(startIndex >= 0)
		        for(int i=startIndex;i<=lastPoint;i++){
		        	System.out.print(primesForPrint.get(i)+" ");
		        }
	        else{
	        	for(int i=0;i<primes;i++){
		        	System.out.print(primesForPrint.get(i)+" ");
		        }
	        }
	        System.out.println();
		}
//		System.out.println(prima(8, 7));// unrecommend solution to find prime number
	}

	// Computes the number of primes less than or equal to N using the Sieve of Eratosthenes.
		boolean[] isPrime;
		List<Integer> primesForPrint;

		// unrecommend solution to find prime number
		/*int[] primes;

		boolean prima(int value, int divide){
			System.out.println("value "+value+" divide "+divide);
			if(divide==1){
				return true;
			}
			if(value/1 == value && !(value%divide == 0)){
				return prima(value, divide-1);
			}
			return false;
		}*/

}
