package norman.uva;

import norman.template.template;
import norman.template.template_utility;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by normansyahputa on 11/12/16.
 */
public class ACMAndBlackout extends template {

    private int T,
            N,// number of school in the city 3 < N < 100
            M;// number of possible connections among them

    List<Edge> edges;

    public ACMAndBlackout() {
        super("ACMAndBlackout", "ACMAndBlackout", LINUX, true);
    }

    @Override
    public void doSomething() {
        T = getInput().nextInt();

        while(T-- > 0){
            edges = new ArrayList<>();

            N = getInput().nextInt();
            M = getInput().nextInt();

            for(int i=0;i<M;i++){
                int x = getInput().nextInt();
                int y = getInput().nextInt();
                int cost = getInput().nextInt();

                edges.add(new Edge(cost, x-1,y-1));
            }

            if(debug){
                print("before sorting");
                for (Edge edge : edges) {
                    print(edge);
                }
            }

            // sort based on non-decreasing
            Collections.sort(edges);

            if(debug){
                print("after sorting");
                for (Edge edge : edges) {
                    print(edge);
                }
            }

            bannedEdgeFlag = new int[300][300];// lookup for flag
            bannedEdges = new ArrayList<>();

            // init parent
            p = new int[300];
            for(int i=0;i<p.length;i++){
                p[i] = i;
            }

            int mst = 0, secondMst = Integer.MAX_VALUE;
            for(int i=0;i<edges.size();i++){
                Edge edge = edges.get(i);
                if(!isSameSet(edge.x, edge.y)){
                    unionSet(edge.x, edge.y);
                    mst += edge.weight;

                    bannedEdgeFlag[edge.x][edge.y] = 2;
                    bannedEdges.add(edge);
                }else{
                    bannedEdgeFlag[edge.x][edge.y] = 1;
                }
            }
            print(mst+" ", false);

            // exclude banned edge then rerun the mst without
            for(int i=0;i<bannedEdges.size();i++){
                Edge blEdge = bannedEdges.get(i);
                bannedEdgeFlag[blEdge.x][blEdge.y] = 3;

                // init parent - reset parent - reset mst calc
                int tempMst = 0;
                for(int k=0;k<p.length;k++){
                    p[k] = k;
                }

                for(int j=0;j<edges.size();j++){
                    Edge edge = edges.get(j);
                    if(bannedEdgeFlag[edge.x][edge.y] == 3)
                        continue;

                    if(!isSameSet(edge.x, edge.y)){
                        unionSet(edge.x, edge.y);
                        tempMst += edge.weight;
                    }
                }
                if(tempMst >= mst && tempMst <= secondMst){
                    secondMst = tempMst;
                }
//                print("#"+(i+1)+" : "+mst);
                bannedEdgeFlag[blEdge.x][blEdge.y] = 2;
            }
            print(secondMst);



        }
    }

    List<Edge> bannedEdges;
    int[][] bannedEdgeFlag;
    int[] p;

    int findSet(int i){
        return p[i] == i ? i : (p[i] = findSet(p[i]));
    }

    boolean isSameSet(int i, int j){
//        if(debug){
//            print(i+" "+j);
//        }
        return findSet(i) == findSet(j);
    }

    void unionSet(int i, int j){
        if(!isSameSet(i, j)){
            p[findSet(i)] = findSet(j);
        }
    }

    private void print(Object object, boolean withoutNewLine){
        template_utility.print(getOutput(), object.toString(), withoutNewLine, true);
    }

    private void print(Object object){
        template_utility.print(getOutput(), object.toString(), true, true);
    }

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
