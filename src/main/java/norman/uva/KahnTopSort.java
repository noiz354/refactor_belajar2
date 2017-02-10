package norman.uva;

import norman.template.Template;

import java.util.*;

/**
 * Created @author normansyahputa  on 12/2/16.
 */
public class KahnTopSort extends Template {

//    static final int[][] adjListRawData = {
//            {0,1},
//            {0,2},
//            {2,1},
//            {3,2},
//            {3,1}
//    };

    static final int[][] adjListRawData = {
            {1,4},
            {3,1},
            {3,2},
            {1,2},
            {1,0},
            {0,4}
    };
    int V;
    List<List<Integer>> adjList;
    // for storing in degree of each vertex
    int[] indegree;
    public KahnTopSort() {
        super("KahnTopSort", "KahnTopSort", LINUX, true);
    }

    @Override
    public void doSomething() {
        Queue<Integer> Q = new LinkedList<>();
        List<Integer> order = new ArrayList<>();

        V = 5;
        adjList = new ArrayList<>();
        for(int i=0;i<V;i++){
            adjList.add(new ArrayList<>());
        }

        for(int i=0;i<adjListRawData.length;i++){
            int u = adjListRawData[i][0];
            int v = adjListRawData[i][1];
            List<Integer> integers = adjList.get(u);
            integers.add(v);
            adjList.set(u, integers);
        }

        indegree = new int[V];
        // calculate indegree of each vertex
        calculateInDegree(indegree);

        System.out.println(Arrays.toString(indegree));

        // enqueue 0 indegree vertex
        int i=0;
        for(i=0;i<V;i++){
            if(indegree[i]==0)
                Q.add(i);
        }
        System.out.println(Q);

        if(Q.isEmpty()){
            System.out.println("Graph contains directed cycle, no top sort");
        }

        while(!Q.isEmpty()){
            int u = Q.peek();
            order.add(u);
            Q.poll();
            for(int v=0;v<adjList.get(u).size();v++){
                Integer next = adjList.get(u).get(v);
                indegree[next]--;
                if(indegree[next]==0){
                    Q.add(next);
                }
            }
        }

        for (Integer integer : order) {
            System.out.print(" "+integer);
        }
        System.out.println();

    }

    void calculateInDegree(int indegree[]){
        int i=0;
        int j=0;
        for(i=0;i<V;i++){
            indegree[i] = 0;
        }

        for(i=0;i<adjList.size();i++){
            for(j=0;j<adjList.get(i).size();j++){
                ++indegree[adjList.get(i).get(j)];
            }
        }
    }

    public static class KahnTopSortUtil{
        int V;
        List<List<Integer>> adjList;

        // for storing in degree of each vertex
        int[] indegree;

        public KahnTopSortUtil(int V){
            this.V = V;
        }

        public void setAdjList(List<List<Integer>> adjList) {
            this.adjList = adjList;
        }

        public List<Integer> topSort(){
            Queue<Integer> Q = new PriorityQueue<>();
            List<Integer> order = new ArrayList<>();

//            V = 5;
//            adjList = new ArrayList<>();
//            for(int i=0;i<V;i++){
//                adjList.add(new ArrayList<>());
//            }
//
//            for(int i=0;i<adjListRawData.length;i++){
//                int u = adjListRawData[i][0];
//                int v = adjListRawData[i][1];
//                List<Integer> integers = adjList.get(u);
//                integers.add(v);
//                adjList.set(u, integers);
//            }

            indegree = new int[V];
            // calculate indegree of each vertex
            calculateInDegree(indegree);

            System.out.println("indegree " +Arrays.toString(indegree));

            // enqueue 0 indegree vertex
            int i=0;
            for(i=0;i<V;i++){
                if(indegree[i]==0)
                    Q.add(i);
            }
            System.out.println(Q);

            if(Q.isEmpty()){
                System.out.println("Graph contains directed cycle, no top sort");
            }

            while(!Q.isEmpty()){
                int u = Q.peek();
                order.add(u);
                Q.poll();
                for(int v=0;v<adjList.get(u).size();v++){
                    Integer next = adjList.get(u).get(v);
                    indegree[next]--;
                    if(indegree[next]==0){
                        Q.add(next);
                    }
                }
            }

//            for (Integer integer : order) {
//                System.out.print(" "+integer);
//            }
//            System.out.println();
            return order;
        }

        private void calculateInDegree(int indegree[]){
            int i=0;
            int j=0;
            for(i=0;i<V;i++){
                indegree[i] = 0;
            }

            for(i=0;i<adjList.size();i++){
                for(j=0;j<adjList.get(i).size();j++){
                    ++indegree[adjList.get(i).get(j)];
                }
            }
        }
    }
}
