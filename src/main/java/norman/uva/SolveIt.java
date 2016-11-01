package norman.uva;

import norman.template.template;

public class SolveIt extends template {

	public SolveIt() {
		super("SolveIt", "SolveIt", LINUX);
	}

	@Override
	public void doSomething() {
		while(getInput().hasNext()){
			p = getInput().nextInt();
			q = getInput().nextInt();
			r = getInput().nextInt();
			s = getInput().nextInt();
			t = getInput().nextInt();
			u = getInput().nextInt();

			if(f(0)*f(1)>0){
				System.out.println("No solution");
			}else{
				System.out.printf("%.4f\n",bisection());
			}
		}
	}

	final double EPS = 0.0000001;
	int p,q,r,s,t,u;

	private double f(double x){
		return p*Math.exp(-x)+q*Math.sin(x)+r*Math.cos(x)+s*Math.tan(x)+t*x*x+u;
	}

	private double bisection(){
		double lo = 0, hi = 1;
		while(lo + EPS < hi){
			double x =(lo+hi)/2;
			if(f(lo) * f(x) <= 0){
				hi = x;
			}else{
				lo = x;
			}
		}
		return (lo+hi)/2;
	}

}
