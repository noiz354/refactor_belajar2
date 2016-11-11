package norman.uva;

import norman.template.template;
import norman.template.template_utility;

import java.util.Comparator;
import java.util.PriorityQueue;

import static java.lang.Math.sqrt;

/**
 * Created by normansyahputa on 11/10/16.
 * not correct answer {@link Highways2}
 */
@Deprecated
public class Highways extends template {

    public Highways() {
        super("Highways", "Highways", LINUX, true);
    }

    @Override
    public void doSomething() {
        // -1. read number of test case
        int numberOfTestCase = getInput().nextInt();

        while(numberOfTestCase-- > 0){

            // 0. read number of coordinate
            int N = getInput().nextInt();

            coor = new int[N+1][2];

            // 1. read coordinate
            for(int i=1;i<=N;i++){
                int x = getInput().nextInt();
                int y = getInput().nextInt();

                coor[i] = new int[]{x,y};
            }

            // 2. init parent
            parent = new int[N+1];
            for(int i=0;i<parent.length;i++){
                parent[i] = -1;
            }

            // 3. read existing highways
            existHighway = getInput().nextInt();
            int remainHighways = N;
            for(int h=1;h<=existHighway;h++){
                int src = getInput().nextInt();
                int dst = getInput().nextInt();

                if(union(src, dst, parent)){
                    remainHighways--;
                }
            }

            if(numberOfTestCase != 1){
                if(debug){
                    print("");
                }
            }

            if(remainHighways == 0){
                if(debug){
                    print("No new highways need");
                }
            }else{
                // calculate distance
                PriorityQueue<Edge> edges
                        = new PriorityQueue<>(new EdgeComparator());
                for(int src=1;src<N;src++){
                    for(int dst=src+1;dst<N;dst++){
                        int srcX = coor[src][0];
                        int srcY = coor[src][1];
                        int dstX = coor[dst][0];
                        int dstY = coor[dst][1];
                        int diffX = srcX - dstX;
                        int diffY = srcY - dstY;
                        double dist = sqrt(diffX * diffX + diffY * diffY);
                        edges.add(new Edge(src, dst, dist));
                    }
                }

                // kruskal
                int numEdgeAdded = 0;
                while(numEdgeAdded != remainHighways){
                    Edge edge = edges.peek();
                    if(edges.size()<=0)
                        edges.remove();
                    if(union(edge.x, edge.y, parent)){
                        if(debug){
                            print(edge.x+" "+edge.y);
                            numEdgeAdded++;
                        }
                    }
                }
            }
        }
    }

    private boolean union(int src, int dst, int[] parent) {
        int set1 = find(src, parent);
        int set2 = find(dst, parent);

        if(set1 != set2){
            if(parent[set1] < parent[set2]){
                parent[set1] = parent[set1] + parent[set2];
                parent[set2] = set1;
            }else{
                parent[set2] = parent[set1] + parent[set2];
                parent[set1] = set2;
            }
            return true;
        }else {
            return false;
        }
    }

    private int find(int item, int[] parent){
        if(parent[item]<0){
            return item;
        }else{
            return parent[item] = find(parent[item], parent);
        }
    }

    private int existHighway;
    int[] parent;
    int[][] coor;

    private void print(Object object){
        template_utility.print(getOutput(), object.toString(), true, true);
    }

    private class Edge{
        int x, y;
        double weight;

        public Edge(int x, int y, double weight) {
            this.x = x;
            this.y = y;
            this.weight = weight;
        }
    }

    private class EdgeComparator implements Comparator<Edge>{

        @Override
        public int compare(Edge o1, Edge o2) {
            return (int) (o1.weight - o2.weight);
        }
    }
}
