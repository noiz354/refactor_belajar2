package norman.hackerrank;

import norman.template.template;

import java.util.Arrays;

/**
 * Created by normansyahputa on 12/6/16.
 */
public class Candies extends template {
    public Candies() {
        super("Candies", "Candies", LINUX, true);
    }

    @Override
    public void doSomething() {
        while(true){
            int N = getInput().nextInt();
            int p[] = new int[N];
            long c[] = new long[N];
            p[0] = getInput().nextInt();
            c[0] =1;
            for(int i=1;i<N;i++){
                p[i] = getInput().nextInt();
                if(p[i]>p[i-1]){
                    c[i]=c[i-1]+1;
                }else{
                    c[i]=1;
                }
            }
            for(int i=N-2;i>=0;i--){
                if(p[i]>p[i+1] && c[i]<=c[i+1]){
                    c[i]=c[i+1]+1;
                }
            }

            int total = 0;
            for(int i=0;i<p.length;i++){
                total += c[i];
            }

            System.out.println(total);

            if(!getInput().hasNext()){
                break;
            }
        }
    }
}
