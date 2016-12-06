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
            int p[] = new int[N], c[] = new int[N];
            for(int i=0;i<N;i++){
                p[i] = getInput().nextInt();
            }

            for(int i=0;i<N;i++){
                c[i] = 1;
            }

            for(int i=1;i+1<p.length;i++){
//                System.out.println((i-1)+" "+(i));
                if(p[i]>p[i-1]){
                    c[i] = c[i-1]+1;
                }
            }

            System.out.println("increase "+Arrays.toString(c));

            for(int i=p.length-2;i>=0;i--){
//                System.out.println((i)+" "+(i+1));
                if(p[i+1]<p[i]){
                    c[i] = Math.max(c[i], c[i+1]+1);
                }
            }

            int total = 0;
            for(int i=0;i<p.length;i++){
                total += c[i];
            }

            System.out.println(total+" "+Arrays.toString(c));

            if(!getInput().hasNext()){
                break;
            }
        }
    }
}
