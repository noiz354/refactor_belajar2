package norman.uva;

import norman.template.Template;
import norman.template.TemplateUtility;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static java.lang.Math.floor;
import static java.lang.Math.sqrt;

/**
 * Created @author normansyahputa  on 11/14/16.
 *
 * uva 11228
 *
 * learn based on this problem :
 * 1. round using floor by adding 0.5
 * 2. check if r is in range or not
 */
public class TransportationSystem extends Template {

    final static int MAX = 500_000;
    final static int MAX_NODE = 1_005;
    List<Pair> co;
    List<Edge> ed;
//    Edge ed[];
    int par[];

    public TransportationSystem() {
        super("TransportationSystem", "TransportationSystem", LINUX, false);
    }

    double sqr(double x) {
        return x * x;
    }

    double round(double d) {
        return floor(d + 0.5);
    }

    @Override
    public void doSomething() {


        int t, counter = 0;
        t = getInput().nextInt();
        while(t-- > 0){
            int n,r;
            co = new ArrayList<>();

            ed = new ArrayList<>();
//        ed = new Edge[MAX];
//        for(int i=0;i<MAX;i++){
//            ed[i] = new Edge(Double.MAX_VALUE,Integer.MAX_VALUE,Integer.MAX_VALUE);
//        }
            par = new int[MAX_NODE];

            counter++;
            n = getInput().nextInt();
            r = getInput().nextInt();

            for(int i=1;i<=n;i++)
                par[i] = i;

            for(int i=0;i<n;i++){
                double x, y;
                x = getInput().nextDouble();
                y = getInput().nextDouble();

                co.add(new Pair(x,y));
            }

            int c=-1;
            for(int i=0;i<co.size();i++)
                for(int j=i+1;j<co.size();j++){
                    c++;
                    double dis = sqrt(sqr(co.get(i).i - co.get(j).i) + sqr(co.get(i).y - co.get(j).y));
//                    ed[c] = new Edge(dis, i+1, j+1);
                    ed.add(new Edge(dis, i+1, j+1));
                }

            Collections.sort(ed);

            int s = n;
            double road =0, rail=0;
//            for(int i=1;i<=c;i++){
//                int u = findPar(ed[i].x);
//                int v = findPar(ed[i].y);
//                if((ed[i].weight - r)>1*Math.pow(Math.E, -9) && u != v){
//                    rail += ed[i].weight;
//                    par[v] = par[u];
//                }else if(u!=v){
//                    road+=ed[i].weight;
//                    par[v] = par[u];
//                    s--;
//                }
//            }
            if(debug){
                print(""+Math.pow(Math.E, -9));
            }
            for(int i=0;i<=c;i++){
                int u = findPar(ed.get(i).x);
                int v = findPar(ed.get(i).y);
                if(debug){
                    print("["+i+"] "+ed.get(i).x +" "+u);
                    print("["+i+"] "+ed.get(i).y+" "+v);
                    print("edge "+ed.get(i));
                }
                if((ed.get(i).weight - r)>1*Math.pow(Math.E, -9) && u != v){
                    rail += ed.get(i).weight;
                    par[v] = par[u];
                }else if(u!=v){
                    road+=ed.get(i).weight;
                    par[v] = par[u];
                    s--;
                }
            }
            road = round(road);
            rail = round(rail);
//            if(debug){
                print("Case #"+counter+": "+s+" "+(int)road+" "+(int)rail);
//            }
        }
    }

    private void print(Object object){
        TemplateUtility.print(getOutput(), object.toString(), true, true);
    }

    int findPar(int x){
        return (par[x]==x)?x:(par[x] = findPar(par[x]));
    }

    class Pair {
        double i, y;

        public Pair(double i, double y) {
            this.i = i;
            this.y = y;
        }
    }

    private class Edge implements Comparable<Edge> {

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
            if (this.weight < o.weight) return -1;
            if (this.weight > o.weight) return 1;
            return 0;
        }

    }


}
