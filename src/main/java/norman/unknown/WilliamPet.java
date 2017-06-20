package norman.unknown;

import norman.template.Template;

/**
 * Created by normansyahputa on 6/16/17.
 */
public class WilliamPet extends Template {
    public WilliamPet() {
        super("WilliamPet", "WilliamPet", LINUX, true);
    }

    @Override
    public void doSomething() {
        int n = getInput().nextInt();
        int a = getInput().nextInt();
        int b = getInput().nextInt();

        int c = b-a;

        int d = n -2;

        int result = -1;

        if(a > b){
            result = 0;
            println(result);
            return;
        }

        if(c>1 && n==1){
            result = 0;
            println(result);
            return;
        }

        result = (c*d+1);
        println(result);

    }
}
