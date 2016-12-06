package norman.hackerrank;

import norman.template.template;

import java.util.Arrays;

/**
 * Created by normansyahputa on 12/6/16.
 */
public class GreedyFlorist extends template {
    public GreedyFlorist() {
        super("GreedyFlorist", "GreedyFlorist", LINUX, true);
    }

    @Override
    public void doSomething() {

        while (true){
            int N = getInput().nextInt();
            int K = getInput().nextInt();

            Integer f[] = new Integer[N];
            for(int i=0;i<N;i++){
                f[i] = getInput().nextInt();
            }
            Arrays.sort(f, (o1,o2)->(o2-o1));
//            System.out.println(Arrays.toString(f));

            int result =0, m;
            for(int in=0;in<f.length;in++){
                m = (int) (Math.floor(in/K)+1);
                result += f[in]*m;
            }

            System.out.println(result);

            if(!getInput().hasNext()){
                break;
            }
        }

    }
}
