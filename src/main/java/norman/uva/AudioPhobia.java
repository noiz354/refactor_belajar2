package norman.uva;

import norman.template.template;
import norman.template.template_utility;

import java.util.*;

import static java.lang.Math.max;

/**
 * Created by normansyahputa on 11/13/16.
 */
public class AudioPhobia extends template {

    private int T;

    public AudioPhobia() {
        super("AudioPhobia", "AudioPhobia", LINUX, false);
    }

    @Override
    public void doSomething() {

        T = 1;
        A: while(true){
            C = getInput().nextInt();
            S = getInput().nextInt();
            Q = getInput().nextInt();

            if(C==0&&S==0&&Q==0){
                break A;
            }else{
                if(T>1)
                    print("");
            }

            tree = new ArrayList<>();
            for(i=0;i<C;i++){
                tree.add(new ArrayList<>());
            }

            weightTable = new int[101][101];
            edges = new ArrayList<>();
            for(i=0;i<S;i++){
                c1 = getInput().nextInt();
                c2 = getInput().nextInt();
                d = getInput().nextInt();

                edges.add(new Edge(d, c1-1, c2-1));

            }

            Collections.sort(edges);

            p = new int[101];
            for(i=0;i<p.length;i++){
                p[i] = i;
            }

            // build MST
            for(i=0;i<edges.size();i++){
                Edge edge = edges.get(i);
                if(!isSameSet(edge.x, edge.y)){
                    unionSet(edge.x, edge.y);

                    weightTable[edge.x][edge.y] = (int) edge.weight;
                    weightTable[edge.y][edge.x] = (int) edge.weight;

                    List<Integer> adj = tree.get(edge.x);
                    adj.add(edge.y);
                    tree.set(edge.x, adj);

                    adj = tree.get(edge.y);
                    adj.add(edge.x);
                    tree.set(edge.y, adj);
                }
            }

            // print adjList
            if(debug) {
                i = 0;
                for (List<Integer> integers : tree) {
                    print(i + " " + integers);
                    i++;
                }
            }


            print("Case #"+(T++));
            // transverse tree
            for(i=0;i<Q;i++){
                s = getInput().nextInt()-1;
                e = getInput().nextInt()-1;

                sol = 0;
                findThePath = false;
                visited = new boolean[C];
                edgeRank = new PriorityQueue<>(new Comparator<Integer>() {
                    @Override
                    public int compare(Integer o1, Integer o2) {
                        return o2 - o1;
                    }
                });

//                dfs(s);
                if(query(s, e)){
                    print(sol);
                }else{
                    print("no path");
                }


//                if(findThePath)
//                    print(edgeRank.peek());
//                else
//                    print("no path");

            }
        }
    }

    boolean query(int c1, int c2){
        if(c1 == c2) return true;

        visited[c1] = true;

        boolean found = false;
        for(int i=0;i<tree.get(c1).size() && !found;i++){
            if(!visited[tree.get(c1).get(i)]){
                found = query(tree.get(c1).get(i), c2);
                if(found) {
                    sol = max(sol, weightTable[c1][tree.get(c1).get(i)]);
                }
            }
        }
        return found;
    }

    /*void dfs(int pos){
        visited[pos] = true;

        if(pos == e){
            findThePath = true;
            // set all flag to true
            for(int k=0;k<visited.length;k++){
                visited[k] = true;
            }
            return;
        }

        for(int j=0;j<tree.get(pos).size() && !findThePath;j++){
            int neigh = tree.get(pos).get(j);
            if(debug){
                print(pos+" "+neigh+" try to visited");
            }
            if(!visited[neigh]){

                dfs(neigh);

                if(debug){
                    print(pos+" "+neigh+" not visited ", false);
                    print("weight "+weightTable[pos][neigh]);
                }
                if()
                edgeRank.add(weightTable[pos][neigh]);

//                if(debug){
//                    print(pos+" "+neigh+"xx ", false);
//                    print("weight "+weightTable[pos][neigh]);
//                }
//                edgeRank.add(weightTable[pos][neigh]);
            }else{
                if(debug){
                    print(pos+" "+neigh+" already visited ");
                }
            }
        }
    }*/

    boolean findThePath;
    boolean[] visited;
    List<List<Integer>> tree;

    int[][] weightTable;
    Queue<Integer> edgeRank;
    List<Edge> edges;
    int C, // number of crossing <= 100
        S, // number of street <= 1_000
        Q; // number of queries <= 10_000

    int s,e, sol;
    int i, j;
    int c1, c2, d;
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
