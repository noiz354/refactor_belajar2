package norman.hackerrank;

import norman.template.template;

import java.util.Arrays;

/**
 * Created by normansyahputa on 12/6/16.
 */
public class SherlockAndTheCost2 extends template {
    public SherlockAndTheCost2() {
        super("SherlockAndTheCost", "SherlockAndTheCost", LINUX, true);
    }

    @Override
    public void doSomething() {
        int T = getInput().nextInt();
        while(T-- > 0){

            int N = getInput().nextInt();
            int dp[][] = new int[N][2];
            getInput().nextLine();
            String[] Bs = getInput().nextLine().split(" ");
            int b[] = new int[Bs.length];
            for(int i=0;i<Bs.length;i++){
                b[i] = Integer.parseInt(Bs[i]);
            }

            for(int i=1;i<N;i++){
                System.out.println("1 "+dp[i-1][0]+" "+(dp[i-1][1]+ Math.abs(b[i-1]-1)));
                dp[i][0] = Math.max(dp[i-1][0], dp[i-1][1]+ Math.abs(b[i-1]-1));
                System.out.println("2 "+(dp[i-1][0] + Math.abs(b[i]-1))+" "+dp[i-1][1]);
                dp[i][1] = Math.max(dp[i-1][0] + Math.abs(b[i]-1), dp[i-1][1]);
                print2DArray(dp);
            }

            System.out.println(Math.max(dp[N-1][0], dp[N-1][1]));
        }
    }

    void print2DArray(int[][] array2d){
        System.out.println("####");
        for(int i=0;i<array2d.length;i++){
            System.out.println(Arrays.toString(array2d[i]));
        }
        System.out.println("####");
    }
}
