package norman.uva;

import norman.template.template;
import norman.template.template_utility;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import static java.lang.Math.sqrt;

/**
 * Created by normansyahputa on 11/11/16.
 */
public class Highways2 extends template {

    public Highways2() {
        super("Highways", "Highways", LINUX, true);
    }

    @Override
    public void doSomething() {
        T = getInput().nextInt();
        while(T-- > 0){
            edgeList = new ArrayList<>();

            initP();

            N = getInput().nextInt();
            initCoor();
            for(int i=0;i<N;i++){
                cx[i] = getInput().nextInt();
                cy[i] = getInput().nextInt();
            }

            for(int i=0;i<N;i++){
                for( int j=i+1; j<N; j++){
                    int srcX = cx[i];
                    int srcY = cy[i];
                    int dstX = cx[j];
                    int dstY = cy[j];
                    int diffX = srcX - dstX;
                    int diffY = srcY - dstY;
                    double dist = sqrt(diffX * diffX + diffY * diffY);
                    edgeList.add(new Edge(dist, i, j));
                }
            }

//            if(debug){
//                print("before sorting ");
//                for (Edge edge : edgeList) {
//                    print(edge);
//                }
//            }

            // sort menggunakan weight

//            if(debug){
//                print("\nafter sorting ");
//                for (Edge edge : edgeList) {
//                    print(edge);
//                }
//            }
            initSet(N);

            M = getInput().nextInt();

            int d = 0;

            for(int i=0;i<M;i++){
//            while(M-- > 0){
                x = getInput().nextInt();
                y = getInput().nextInt();

                if(!isSameSet(x-1,y-1)) {
                    unionSet(x - 1, y - 1);
                    d++;
                }
            }

            if(d == N-1) {
                if(debug){
                    print("No new highways need\n");
                    continue;
                }
            }

            Collections.sort(edgeList);

            for(int i=0;i<edgeList.size() && d < N-1;i++){
                Edge edge = edgeList.get(i);
                if(!isSameSet(edge.x, edge.y)){
                    if(debug){
                        print((edge.x+1)+" "+(edge.y+1));
                    }
                    d++;
                    unionSet(edge.x, edge.y);
                }
            }
            if(T > 0){
                if(debug){
                    print("\n");
                }
            }
        }
    }

    // ordered is not right too
//    @Override
//    public void doSomething() {
//        T = getInput().nextInt();
//        while(T-- > 0){
//            edgeList = new ArrayList<>();
//
//            initP();
//
//            N = getInput().nextInt();
//            initCoor();
//            for(int i=0;i<N;i++){
//                cx[i] = getInput().nextInt();
//                cy[i] = getInput().nextInt();
//            }
//
//            for(int i=0;i<N;i++){
//                for( int j=i+1; j<N; j++){
//                    int srcX = cx[i];
//                    int srcY = cy[i];
//                    int dstX = cx[j];
//                    int dstY = cy[j];
//                    int diffX = srcX - dstX;
//                    int diffY = srcY - dstY;
//                    double dist = sqrt(diffX * diffX + diffY * diffY);
//                    edgeList.add(new Edge(dist, i, j));
//                }
//            }
//
////            if(debug){
////                print("before sorting ");
////                for (Edge edge : edgeList) {
////                    print(edge);
////                }
////            }
//
//            // sort menggunakan weight
//            Collections.sort(edgeList);
//
////            if(debug){
////                print("\nafter sorting ");
////                for (Edge edge : edgeList) {
////                    print(edge);
////                }
////            }
//            initSet(N);
//
//            M = getInput().nextInt();
//
//            int d = 0;
//
//            while(M-- > 0){
//                x = getInput().nextInt();
//                y = getInput().nextInt();
//
//                if(!isSameSet(x-1,y-1)) {
//                    unionSet(x - 1, y - 1);
//                    d++;
//                }
//            }
//            int y=0;
//
//            for(int i=0;i<edgeList.size()&& _sc > 1;i++){
//                Edge edge = edgeList.get(i);
//                if(!isSameSet(edge.x, edge.y)){
//                    if(debug){
//                        print((edge.x+1)+" "+(edge.y+1));
//                    }
//                    y++;
//                    unionSet(edge.x, edge.y);
//                }
//            }
//
//            if(y==0){
//                if(debug)
//                    print("No new highways need");
//            }
//            if(T > 0){
//                if(debug){
//                    print("");
//                }
//            }
//        }
//    }

    private void print(Object object){
        template_utility.print(getOutput(), object.toString(), true, true);
    }

    int findSet(int i){
        if(p.get(i)==i){
            return i;
        }else{
            p.set(i, findSet(p.get(i)));
            return p.get(i);
        }
    }

    boolean isSameSet(int i, int j){
//        if(debug){
//            print(i+" "+j);
//        }
        return findSet(i) == findSet(j);
    }

    void unionSet(int i, int j){
        if(!isSameSet(i, j)){
            int set = findSet(j);
            int set1 = findSet(i);
            p.set(set1, set);
        }
        _sc--;
    }

    int T, x, y, N, M;
    List<Integer> p;

    int cx[], cy[];
    private int _sc;

    void initSet(int N){
        for(int i=0;i<N;i++){
            p.set(i, i);
        }
        _sc = N;
    }

    void initCoor(){
        cx = new int[750];
        cy = new int[750];
    }

    void initP(){
        p = new ArrayList<>();
        for(int i=0;i<1000;i++){
            p.add(0);
        }
    }

    List<Edge> edgeList = new ArrayList<>();
    private class Edge implements Comparable<Edge>{
        double weight;
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
