package norman.hackerrank;

import norman.template.template;

/**
 * Created by normansyahputa on 12/6/16.
 *
 * naive solution
 */
public class SherlockAndTheCost extends template {
    public SherlockAndTheCost() {
        super("SherlockAndTheCost", "SherlockAndTheCost", LINUX, true);
    }

    @Override
    public void doSomething() {
        int T = getInput().nextInt();
        while(T-- > 0){

            int N = getInput().nextInt();
            getInput().nextLine();
            String[] Bs = getInput().nextLine().split(" ");
            int b[] = new int[Bs.length];
            for(int i=0;i<Bs.length;i++){
                b[i] = Integer.parseInt(Bs[i]);
            }

            max = -1;
            int res = calculateMax(b, 0, 0);
            System.out.println(max);
        }
    }

    int max;

    int calculateMax(int b[], int index, int total){
        if(index+1 > b.length-1) {
            max = (max<total)?total:max;
//            System.out.println("total "+total);
            return total;
        }

//        System.out.println(index+" "+(index+1));

        for(int i=1;i<=b[index];i++){
            for(int j=1;j<=b[index+1];j++){
                calculateMax(b, index+1, total + Math.abs(j-i));
            }
        }

        return total;
    }
}
