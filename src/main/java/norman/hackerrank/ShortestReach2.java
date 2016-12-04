package norman.hackerrank;

import norman.template.template;
import norman.template.template_utility;

import java.util.*;

/**
 * Created by normansyahputa on 12/3/16.
 */
public class ShortestReach2 extends template {
    public ShortestReach2() {
        super("ShortestReach2", "ShortestReach2", LINUX, true);
    }

    @Override
    public void doSomething() {
        int T = getInput().nextInt();
        while(T-- > 0){
            println(T);

            int N = getInput().nextInt();
            int M = getInput().nextInt();

            adjList = new ArrayList<>();
            for(int i=0;i<N;i++){
                List<IntegerPair> neighbor
                        = new ArrayList<>();
                adjList.add(neighbor);
            }

            for(int i=0;i<M;i++){
                int u = getInput().nextInt()-1;
                int v = getInput().nextInt()-1;
                int w = getInput().nextInt();

//                adjList.get(u).add(new IntegerPair(v,w));
                List<IntegerPair> bef = adjList.get(u);
                bef.add(new IntegerPair(v,w));
                adjList.set(u, bef);

                bef = adjList.get(v);
                bef.add(new IntegerPair(u,w));
                adjList.set(v, bef);
            }

            int s = getInput().nextInt()-1;

            // dijkstra routine
            List<Integer> dist = new ArrayList<>();
            dist.addAll(Collections.nCopies(N, INF));// INF = 1*10^9 not MAX_INT to avoid overflow
            dist.set(s, 0);
            PriorityQueue<IntegerPair> pq = new PriorityQueue<>(1,
                    (i,j)->( i.first - j.first ));

            // sort based on increasing distance
            pq.offer(new IntegerPair(0,s));

            while(!pq.isEmpty()){// main loop
                IntegerPair top = pq.poll();// greedy: pick shortest unvisited vertex
                int d = top.first;
                int u = top.second;

                // we want to process vertex u only once but we can
                if(d > dist.get(u))// This check is importatn !
                    continue;

                Iterator<IntegerPair> it = adjList.get(u).iterator();
                while(it.hasNext()){// all outgoind edges from u
                    IntegerPair p = it.next();
                    int v = p.first;
                    int weight_u_v = p.second;
                    // if can relax
                    if(dist.get(u) + weight_u_v < dist.get(v)){
                        dist.set(v, dist.get(u)+weight_u_v); // relax
                        pq.offer(new IntegerPair(dist.get(v), v));
                    }

                }
            }

            boolean firstPrint = false;
            for(int i=0;i<N;i++){
                if(s==i){
                    continue;
                }else {
                    if(firstPrint){
                        if(dist.get(i)==INF){
                            System.out.print(" -1");
                        }else {
                            System.out.print(dist.get(i));
                        }
                    }else{
                        if(dist.get(i)==INF){
                            System.out.print(" -1");
                        }else {
                            System.out.print(" " + dist.get(i));
                        }
                    }
                    print(String.format("SSSP(%d, %d) = %d\n", s + 1, i + 1, dist.get(i)));
                }
            }
            System.out.println();
        }
    }

    static final int INF = 1000000000;
    List<List<IntegerPair>> adjList;

    static class IntegerPair{
        public int first,second;

        public IntegerPair(int first, int second) {
            this.first = first;
            this.second = second;
        }
    }

    void print(Object object){
        template_utility.print(getOutput(), object.toString(), false, true);
    }

    void println(Object object){
        template_utility.print(getOutput(), object.toString(), true, true);
    }
}

