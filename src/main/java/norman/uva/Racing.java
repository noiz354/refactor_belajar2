package norman.uva;

import norman.template.template;
import norman.template.template_utility;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * Created by normansyahputa on 11/1/16.
 */
public class Racing extends template{

    public Racing() {
        super("racing", "racing", LINUX);
    }

    @Override
    public void doSomething() {
        edgeList = new ArrayList<>();

        // number of dataset
        int c = getInput().nextInt();
        print("number of dataset : "+Integer.valueOf(c));
        while(c-- >  0){

            // juction
            int n = getInput().nextInt();
            print("junction :"+Integer.valueOf(c));

            // road
            int m = getInput().nextInt();
            print("road :"+Integer.valueOf(c));

            // from 1..n

            for(int i=0;i<m;i++){
                int i1 = getInput().nextInt();
                int i2 = getInput().nextInt();
                int weight = getInput().nextInt();

                Pair<Integer, Pair<Integer, Integer>> edge = new Pair<>(weight, new Pair<Integer, Integer>(i1, i2));
                print(edge);
                edgeList.add(edge);
            }

            Collections.sort(edgeList, comparator);

            print("setelah sort !! ");
            for (Pair<Integer, Pair<Integer, Integer>> pair : edgeList) {
                print(pair);
            }

            int mst_cost = 0;

            Subset subsets[] = new Subset[n];
            for(int i=0;i<n;i++){
                subsets[i]= new Subset();
            }

            for(int v =0;v<n;v++){
                subsets[v].parent = v;
                subsets[v].rank = 0;
            }



            int zero = getInput().nextInt();
            print("------"+zero+"-----");
        }


    }

    List<Pair<Integer, Pair<Integer, Integer>>> edgeList;

    final static Comparator<Pair<Integer, Pair<Integer, Integer>>> comparator = new Comparator<Pair<Integer, Pair<Integer, Integer>>>() {
        @Override
        public int compare(Pair<Integer, Pair<Integer, Integer>> o1, Pair<Integer, Pair<Integer, Integer>> o2) {
            if(o2.u != o1.u)
                return o2.u - o1.u;

            Pair<Integer, Integer> v1 = o2.v;
            Pair<Integer, Integer> v = o1.v;

            if(v1.u != v.u)
                return v1.u - v.u;
            else
                return v1.v - v.v;
        }
    };

    void print(Object object){
        if(object==null || getOutput() == null)
            return;

        template_utility.printCon(getOutput(), object.toString(), true);
    }

    private static class Pair<E, V>{
        E u;
        V v;

        public Pair(E u, V v) {
            this.u = u;
            this.v = v;
        }

        @Override
        public String toString() {
            return "Pair{" +
                    "u=" + u +
                    ", v=" + v +
                    '}';
        }
    }

    // kelas untuk subset dari union find
    private static final class Subset{
        int parent, rank;
    }


}
