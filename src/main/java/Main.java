import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

class Main {

    BufferedReader reader;
    Scanner input;

    public static void main(String[] args) {
        try {
            new Main().go();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void go() throws Exception {
        int T = getInput().nextInt();
        int maxA[], maxB[], A[];
        while(T-- > 0){
            //System.out.println(T);

            int n = getInput().nextInt();
            A = new int[n];

            maxA = new int[n];
            maxB = new int[n];

            for(int i = 0;i<n;i++){
                A[i] = getInput().nextInt();
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

    private BufferedReader getInput2() {
        reader = new BufferedReader(new InputStreamReader(System.in));
		return reader;
	}

	Scanner getInput() {
		if(input==null){
			input = new Scanner(System.in);
		}
		return input;
	}

}
