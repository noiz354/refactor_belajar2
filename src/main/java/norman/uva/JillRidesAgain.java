package norman.uva;

import norman.template.Template;

/**
 *
 * @author M Normansyah (m.normansyah@samsung.com)
 * start at 11-5-2015, Max 1D Sum example
 *
 */
public class JillRidesAgain extends Template {

    int[] stops;
    int start, fin;

	public JillRidesAgain() {
		super("JillRidesAgain", "JillRidesAgain", LINUX);
	}

	@Override
	public void doSomething() {
		int TC = getInput().nextInt();
		int total = TC;
		while(TC-->0){
			int s = getInput().nextInt();
			stops = new int[s-1];
			for(int i=0;i<stops.length;i++){
				stops[i] = getInput().nextInt();
			}
			int sum = 0, ans = 0;
			start = -1;
			fin = -1;
			for(int i=0;i<stops.length;i++){
				sum+=stops[i];
				if(sum >= ans){
					ans = sum;
//					System.out.println("ans "+ans+" sum "+sum+" i "+i);
					fin = i;
				}
//				ans = Math.max(ans, sum);
				if(sum <= 0){
					sum = 0;
//					System.out.println("reset sum "+sum+" i "+i);
					start = i;
				}
			}
			if(fin != -1)
				System.out.println("The nicest part of route "+(total-TC)+" is between stops "+(start+2)+" and "+(fin+2));
			else
				System.out.println("Route "+(total-TC)+" has no nice parts");
		}
	}
}
