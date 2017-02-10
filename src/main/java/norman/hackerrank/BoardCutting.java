package norman.hackerrank;

import norman.template.Template;
import norman.template.TemplateUtility;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created @author normansyahputa  on 12/6/16.
 */
public class BoardCutting extends Template {
    public BoardCutting() {
        super("BoardCutting", "BoardCutting", LINUX, true);
    }

    @Override
    public void doSomething() {
        int q = getInput().nextInt();
        while(q-- > 0){
            int m = getInput().nextInt();
            int n = getInput().nextInt();

            String s = getInput().nextLine();
            println("\""+s+"\"");

            List<List<Integer>> v = new ArrayList<>();
            v.add(new ArrayList<>());
            v.add(new ArrayList<>());

            List<Integer> cost = new ArrayList<>();
            for(long i=0;i<m-1;i++){
//                List<Integer> integers = v.get(1);
                cost.add(getInput().nextInt());
            }
            Collections.sort(cost, (o1,o2)->(o2-o1));
            v.set(1, cost);

            cost = v.get(0);
            for(long i=0;i<n-1;i++){
                cost.add(getInput().nextInt());
            }
            Collections.sort(cost, (o1,o2)->(o2-o1));
            v.set(0, cost);

            /*int t = 2;
            List<List<Integer>> v = new ArrayList<>();
            while(t-- > 0){
                String[] ss = (s = getInput().nextLine()).split(" ");
                List<Integer> cost = new ArrayList<>();
//                v.add(cost);

                for(int i=0;i<ss.length;i++){
                    cost.add(Integer.parseInt(ss[i]));
                }
                Collections.sort(cost, (o1,o2)->(o2-o1));
                v.add(cost);

                println("\""+cost+"\"");
            }*/


            int ym = 0, xm = 1;
            int y=0,x=0;
            int total = 0;
            while (true){
                if(debug){
                    println("");
                    println("xm "+v.get(xm)+" ym "+v.get(ym));
                    println("x "+x+" y "+y);
                }
                if(v.get(ym).isEmpty() && v.get(xm).isEmpty()){
                    break;
                }else if(v.get(ym).isEmpty() && !v.get(xm).isEmpty()){
//                    println(String.format("xm filled && ym empty %d * %d", v.get(ym).get(0), y+1));
                    total += (v.get(xm).get(0)*(x+1));
                    remove(v, xm, 0);
                    y++;
                }else if(v.get(xm).isEmpty() && !v.get(ym).isEmpty()){
//                    println(String.format("xm empty && ym filled %d * %d", v.get(xm).get(0), x+1));
                    total += (v.get(ym).get(0) * (y+1));
                    remove(v, ym, 0);
                    x++;
                }else if(v.get(ym).get(0) > v.get(xm).get(0)){
                    println(String.format("ym > xm %d * %d index (%d,%d)", v.get(ym).get(0), y+1, ym, y));
                    total += (v.get(ym).get(0) * (y+1));
                    remove(v, ym, 0);
                    x++;
                }else if(v.get(ym).get(0) < v.get(xm).get(0)){
                    println(String.format("ym < xm %d * %d", v.get(xm).get(0), x+1));
                    total += (v.get(xm).get(0)*(x+1));
                    remove(v, xm, 0);
                    y++;
                }else if(v.get(ym).get(0).equals(v.get(xm).get(0))){
                    println(String.format("ym == xm %d * %d", v.get(ym).get(0), y+1));
                    total += (v.get(ym).get(0) * (y+1));
                    remove(v, ym, 0);
                    x++;
                }
            }

            int x1 = (int) (total % (Math.pow(10, 9) + 7));
            System.out.println(x1);
        }
    }

    /**
     * some how not really good looking
     * @param data
     * @param index
     * @param innerIndex
     */
    void remove(List<List<Integer>> data, int index, int innerIndex){
        List<Integer> integers = data.get(index);
        integers.remove(innerIndex);
        data.set(index, integers);
    }

    void print(Object object){
        if(debug)
            TemplateUtility.print(getOutput(), object.toString(), false, true);
    }

    void println(Object object){
        if(debug)
            TemplateUtility.print(getOutput(), object.toString(), true, true);
    }
}
