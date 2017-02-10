package norman.hackerrank;

import norman.template.Template;

/**
 * Created on 12/5/16.
 * @author normansyahputa
 */
public class DarvisStaircase extends Template {
    private int[] memo;

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

    private int climb(int cl) {
        if(cl < 0)
            return 0;

        if(cl == 0)
            return 1;

        if(memo[cl] != -1){
            return memo[cl];
        }

        return memo[cl] = climb(cl - 1) + climb(cl - 2) + climb(cl - 3);
    }
}
