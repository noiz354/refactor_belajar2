package norman.uva;

import com.oracle.tools.packager.Log;
import norman.hackerrank.PrimMSTSpecialSubTree;
import norman.template.template;
import norman.template.template_utility;

import java.util.*;

import static norman.uva.TheseusAndTheMinotaur.N;

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
//        print("number of dataset : "+Integer.valueOf(c));
        while(c-- >  0){

            // juction
            int n = getInput().nextInt();
//            print("junction :"+Integer.valueOf(c));

            // road
            int m = getInput().nextInt();
//            print("road :"+Integer.valueOf(c));

            // from 1..n
            int cost = 0;
            for(int i=0;i<m;i++){
                int i1 = getInput().nextInt();
                int i2 = getInput().nextInt();
                int weight = getInput().nextInt();

                Pair<Integer, Pair<Integer, Integer>> edge = new Pair<>(weight, new Pair<>(i1-1, i2-1));
//                print(edge);
                edgeList.add(edge);
                cost += weight;
            }

            Collections.sort(edgeList, comparator);

//            print("setelah sort !! ");
//            for (Pair<Integer, Pair<Integer, Integer>> pair : edgeList) {
//                print(pair);
//            }

            int mst_cost = 0;

            PrimMSTSpecialSubTree.UnionFind UF = new PrimMSTSpecialSubTree.UnionFind(n);
            for (int i = 0; i < edgeList.size(); i++) {                   // for each edge, O(E)
                Pair<Integer, Pair<Integer, Integer>> front = edgeList.get(i);
                if (!UF.isSameSet(front.v.u, front.v.v)) {          // check
                    cost -= front.u;            // add the weight of e to MST
                    UF.unionSet(front.v.u, front.v.v);            // link them
                } }

            /*List<Pair<Integer, Pair<Integer, Integer>>> result = new ArrayList<>();  // Tnis will store the resultant MST

            Subset subsets[] = new Subset[n];
            for(int i=0;i<n;i++){
                subsets[i]= new Subset();
            }

            for(int v =0;v<n;v++){
                subsets[v].parent = v;
                subsets[v].rank = 0;
            }

//            print("start processing !! ");
            for(int i=0;i<m;i++){
                Pair<Integer, Pair<Integer, Integer>> front = edgeList.get(i);

//                print(front);
//                print(Arrays.toString(subsets));

                int x = find(subsets, front.v.u);
//                print(front.v.u+"~"+x);
                int y = find(subsets, front.v.v);
//                print(front.v.v+"~"+y);

                if(x!=y){
                    cost -= front.u;
                    result.add(front);
                    union(subsets, x, y);
                }
            }*/

//            for (Pair<Integer, Pair<Integer, Integer>> integerPairPair : result) {
//                print(integerPairPair);
//            }

            int zero = getInput().nextInt();
            print((cost-mst_cost));
//            print("------"+mst_cost+"-----");
        }


    }

    int find(Subset subsets[], int i){
        if(subsets[i].parent != i)
            subsets[i].parent = find(subsets, subsets[i].parent);

        return subsets[i].parent;
    }

    void union(Subset subsets[], int x, int y){
        int xroot = find(subsets, x);
        int yroot = find(subsets, y);

        if(subsets[xroot].rank < subsets[yroot].rank)
            subsets[xroot].parent = yroot;
        else if (subsets[xroot].rank > subsets[yroot].rank)
            subsets[yroot].parent = xroot;
        else{
            subsets[yroot].parent = xroot;
            subsets[xroot].rank++;
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
            return
//                    "Pair{" +
//                    "u=" +
                    u + ","
//                    ", v=" +
                            +v
//                            +
//                    '}'
                    ;
        }
    }

    // kelas untuk subset dari union find
    private static final class Subset{
        int parent, rank;

        @Override
        public String toString() {
            return
//                    "Subset{" +
//                    "parent=" +
                            parent +
                                    ","+
//                    ", rank=" +
                                    rank
//                    '}'
                    ;
        }
    }


}
