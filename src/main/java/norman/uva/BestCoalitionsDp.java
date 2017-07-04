package norman.uva;

public class BestCoalitionsDp
{
	public static void main(String args[]){
		BestCoalitionsDp bestCoalitionsDp =
			new BestCoalitionsDp();
		bestCoalitionsDp.doSomething();
	}
	
	private void doSomething(){
		int n=5,m=5,i,j;
		int A[] = new int[100],a,b;
		A[0] = 2000;
		A[1] = 1200;
		A[2] = 2900;
		A[3] = 1400;
		A[4] = 2500;
		if (A[m-1] > 5000){
			System.out.println("100.00");
			return;
		}
		
		int dp[] = new int[10001], up = 10000-A[m-1];
		dp[0]=1; 
		for(i=0;i<n;i++){
			if(i == m-1){
				continue;
			}
			for(j=up-A[i]; j>=0; j--){
				if(dp[j]>0){
					dp[j+A[i]]= 1;
				}
			}
		}
		
		up = 5001 - A[m-1]; 
		while(dp[up]==0){
			up++;
		}
		System.out.println("up "+up);
		System.out.printf("%.2f\n", (double)A[m-1]*100/(up+A[m-1]));
    
	}
}
