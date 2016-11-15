package norman.uva;

import norman.template.template;
import norman.template.template_utility;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by normansyahputa on 11/15/16.
 */
public class DarkRoads extends template {

    public DarkRoads() {
        super("DarkRoads", "DarkRoads", LINUX, true);
    }

    @Override
    public void doSomething() {
        while(true){
            m = getInput().nextInt();
            n = getInput().nextInt();

            if(m==0&&n==0)
                break;

            par = new int[200_000];
            for(int i=0;i<m;i++){
                par[i] = i;
            }
            ed = new ArrayList<>();

            total = 0;
            max_save = 0;
            for(int i=0;i<n;i++){
                int x = getInput().nextInt();
                int y = getInput().nextInt();
                int z = getInput().nextInt();

                ed.add(new Edge(z, x, y));

                total += z;
            }

            Collections.sort(ed);

            for(int i=0;i<ed.size();i++){
                int u = findPar(ed.get(i).x);
                int v = findPar(ed.get(i).y);

                if(!isSameSet(ed.get(i).x, ed.get(i).y)){
                    max_save+=ed.get(i).weight;
                    par[v] = par[u];
                }
            }

            print((int)(total-max_save));
        }
    }

    private void print(Object object){
        template_utility.print(getOutput(), object.toString(), true, true);
    }


    boolean isSameSet(int i, int j){
//        if(debug){
//            print(i+" "+j);
//        }
        return findPar(i) == findPar(j);
    }

    int findPar(int x){
        return (par[x]==x)?x:(par[x] = findPar(par[x]));
    }

    private double max_save, total;
    int par[];
    List<Edge> ed;
    int m, n;

    private class Edge implements Comparable<Edge>{

        double weight;// 1 < Cost < 300

        int x, y;
        public Edge(double weight, int x, int y) {
            this.weight = weight;
            this.x = x;
            this.y = y;
        }
        @Override
        public String toString() {
            return
                    weight +
                            ": " + x +
                            "," + y;
        }

        @Override
        public int compareTo(Edge o) {
            if(this.weight < o.weight) return -1;
            if(this.weight > o.weight) return 1;
            return 0;
        }

    }
}
