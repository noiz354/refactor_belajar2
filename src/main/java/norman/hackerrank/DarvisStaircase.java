package norman.hackerrank;

import norman.template.template;

/**
 * Created by normansyahputa on 12/5/16.
 */
public class DarvisStaircase extends template {
    public DarvisStaircase() {
        super("DarvisStaircase", "DarvisStaircase", LINUX, true);
    }

    @Override
    public void doSomething() {
        int T = getInput().nextInt();
        memo = new int[37];
        for(int i=0;i<memo.length;i++){
            memo[i] = -1;
        }
        while (T-->0){
            int climb = getInput().nextInt();

            int numberOfClimb = climb(climb);
            System.out.println(numberOfClimb);
        }
    }

    int[] memo;
    int climb(int cl){
        if(cl < 0)
            return 0;

        if(cl == 0)
            return 1;

        if(memo[cl] != -1){
            return memo[cl];
        }

        int ret = memo[cl] = climb(cl - 1) + climb(cl - 2) + climb(cl - 3);
        return ret;
    }
}
