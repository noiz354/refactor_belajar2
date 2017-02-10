package norman.uva;

import norman.template.Template;

import static java.lang.Math.max;

/**
 * Created @author normansyahputa  on 1/31/17.
 */
public class Y2K extends Template {
    public Y2K() {
        super("Y2K", "Y2K", LINUX, true);
    }

    @Override
    public void doSomething() {
        int s, d;
        while (true) {
            s = getInput().nextInt();
            d = getInput().nextInt();
            int ret = solve(s, d);
            if (ret < 0)
                System.out.println("Deficit");
            else
                System.out.println(ret);

            if (!getInput().hasNext()) {
                break;
            }
        }
    }

    private int solve(int s, int d) {
        int ret = -1;
        for (int i = 0; i < (1 << 12); ++i) {
            ret = max(ret, compute(i, s, d));
        }
        return ret;
    }

    // 111101111011
    private int compute(int values, int s, int d) {
        int sum = 0;
        int cons = 0;
        for (int i = 0; i < 12; ++i) {
            int b = (values & (1 << i));
            if (debug)
                System.out.println(b);
            int v = (b != 0) ? s : -d;
            sum += v;
            if (i < 4) {
                cons += v;
            } else {
                cons = cons + v;
                if (cons >= 0)
                    return -1;
                cons -= ((values & (1 << (i - 4))) != 0) ? s : -d;
            }
        }
        if (debug)
            System.out.println("values " + Integer.toBinaryString(values) + " sum" + sum);
        return sum;
    }

    /*@Override
    public void doSomething() {
        int s, d;
        while(true){

            s = getInput().nextInt();
            d = getInput().nextInt();

            System.out.printf("%d %d\n", s, d);

            int ySurplus = -1, year, i, j;
            for(year = (1<<12)-1; year >= 0; year--){
                int tot =0, flag = 1;
//                System.out.println(Integer.toBinaryString(year));

                for(i=0;i<12;i++){
//                    System.out.println(((year>>i)&1));
                    if(((year>>i)&1)==1){
                        tot += s;
                    }else{
                        tot -= d;
                    }

                    if(i < 8){
                        int tmp = 0;
                        for(j=i;j<i+5;j++){
                            if(((year>>j)&1)==1){
                                tmp += s;
                            }else{
                                tmp -= d;
                            }
                            if(tmp >= 0)
                                flag = 0;
                        }
                    }
                }
                if(flag == 1 && ySurplus < tot){
                    ySurplus = tot;
                }
            }

            if(ySurplus < 0){
                System.out.println("Deficit");
            }else{
                System.out.println(ySurplus);
            }

            if(!getInput().hasNext()){
                break;
            }
        }
    }*/
}
