package norman.uva;
import java.util.*;

// uva 11456
public class TrainSorting
{
	public static void main(String args[]){
		TrainSorting trainsorting = 
		 new TrainSorting();
		 trainsorting.doSomething();
	}
	
	Scanner scanner = new Scanner(System.in);
	
	private void doSomething(){
		
		int T = scanner.nextInt();
		int maxA[], maxB[], A[];
		while(T-- > 0){
			//System.out.println(T);
			
			int n = scanner.nextInt();
			A = new int[n];

			maxA = new int[n];
			maxB = new int[n];
			
			for(int i = 0;i<n;i++){
				A[i] = scanner.nextInt();
			}
			
			for(int i=n-1 ; i>=0 ; i--){
				maxA[i] = 1;
				for(int j=i+1 ; j<n ; j++){
					if(A[i]<A[j]){
						maxA[i] = Math.max(maxA[i], maxA[j]+1);
					}
				}
			}
			
			for(int i=n-1 ; i>=0 ; i--){
				maxB[i] = 1;
				for(int j=i+1 ; j<n ; j++){
					if(A[i]>A[j]){
						maxB[i] = Math.max(maxB[i], maxB[j]+1);
					}
				}
			}
			
			int result =0;
			for(int i=0;i<A.length;i++){
				result = Math.max(maxA[i]+maxB[i]-1, result);
			}
			System.out.println(result);
		}
		
	}
	
	
}
