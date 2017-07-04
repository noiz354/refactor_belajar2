package norman.uva;
import java.util.*;

/*
dont use templafe because not readable from android.
*/
public class BestCoalition
{
	public static void main(String[] args){
		BestCoalition bestCoalition = new BestCoalition();
		bestCoalition.doSomething();
		
	}
	
	private Scanner getInput(){
		return new Scanner(System.in);
	}
	
	double[] percen;
	int n,x;
	
	private void doSomething(){
		n = 3; //getInput().nextInt();
		x = 1; //getInput().nextInt();
		
		//double[] percen; //= new double[x];
		
		//A : while (true){
			/*n = getInput().nextInt();
			x = getInput().nextInt();*/
			
			/*for(int i =0;i<x;i++){
				percen[i] = getInput().nextDouble();
			}*/
			percen = new double[]{10.0,45.0,45.0};
			
			System.out.println(dp(0,percen[x-1]));
			
			/*if(n==0&&x==0){
				System.out.println(n+"&&"+x);
				break A;
			}*/
		//}
	}
	
	private double dp(int index, double share){
		printTab(index);
		System.out.printf("masuk sini %d %.2f\n", 
						  index, share);
		// exceed last index

		if(index > n-1) {
			if(share < 50){
				return 0; 
			}else{
				return percen[x-1]/share;
			}

		}else if (index <= n-1 && share >= 50){
			return percen[x-1]/share;
		}

		if (index == x-1)
			return dp(index+1, share);// skip to next
		else
			return Math.max(dp(index+1, share),dp(index+1, share+percen[index]));
	}
	
	/*private double dp(int index, double share){
		if(index>n-1){
			if(share >= 50){
				printTab(index);
				System.out.printf("masuk sini %d %.2f %.2f\n", 
								  index, share, percen[index]);
				return share;
			}
		}
		
		
		printTab(index);
		System.out.printf("%d %.2f %.2f\n", 
						  index, share, percen[index]);
		
		if(index==x-1 && share >= 50){
			printTab(index);
			;System.out.printf("masuk sini y-4 %d %.2f %.2f\n", 
				index, share, percen[index]);
			return share;
		}*/
		
		
		
		/*double result = Math.max(
			dp(index+1, share+percen[index]),
			dp(index+1, share)
			);*/
		/*double result = 0;
		double shareSum = dp(index+1, share+percen[index]);
		double withoutSum = dp(index+1, share);
		if(percen[x-1]/ shareSum
			>= percen[x-1]/withoutSum){
				result = shareSum;
			}else{
				result = withoutSum;
			}
		printTab(index);
		System.out.printf("result %.2f\n", result);
		return result;
	}*/
	
	private void printTab(int index){
		while(--index>=0){
			System.out.print("\t");
		}
	}
}
