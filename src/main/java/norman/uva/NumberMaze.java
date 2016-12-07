package norman.uva;

import norman.template.template;
import norman.template.template_utility;

import java.util.ArrayList;
import java.util.Deque;
import java.util.List;
import java.util.PriorityQueue;

/**
 * Created by normansyahputa on 12/6/16.
 *
 * uva 929 - djikstra
 * using list is slow
 *
 *
 */
public class NumberMaze extends template {
    public NumberMaze() {
        super("NumberMaze", "NumberMaze", LINUX, true);
    }

    List<List<Integer>> weight;
    static final int INF = 1000000000;

    @Override
    public void doSomething() {
        int N = getInput().nextInt();
        while(N-->0){
            weight = new ArrayList<>();
            int row = getInput().nextInt();
            int col = getInput().nextInt();

            for(int i=0;i<row;i++){
                List<Integer> rowData = new ArrayList<>();
                for(int j=0;j<col;j++){
                    rowData.add(getInput().nextInt());
                }
                weight.add(rowData);
            }
            System.out.println(dijsktra(col, row));
        }

    }

    int dijsktra(int col, int row){
        PriorityQueue<IntegerPair> pq = new PriorityQueue<>((o1,o2)->(o2.weigh-o1.weigh));

        List<List<Integer>> dist = new ArrayList<>();
        for(int i=0;i<row;i++){
            List<Integer> rowInit = new ArrayList<>();
            for(int j=0;j<col;j++){
                rowInit.add(INF);
            }
            dist.add(rowInit);
        }

        // source dist
        put(dist, 0, 0, weight.get(0).get(0));

        pq.add(new IntegerPair(0,0, dist.get(0).get(0)));

        while(!pq.isEmpty()){
            IntegerPair u = pq.peek();
            pq.poll();

            int r = u.u;
            int c = u.v;
            int d = u.weigh;

            println("r "+r+" c "+c+" d "+d);

            for(int i=0;i<4;i++){
                int newr = r + adjR[i];
                int newc = c + adjC[i];
                if(newr >= 0 && newr < row && newc >= 0 && newc < col){
                    println("i "+i+" newr "+newr+" newc "+newc);
                    if(d + weight.get(newr).get(newc) < dist.get(newr).get(newc)){
                        put(dist, newr, newc, d+weight.get(newr).get(newc));
                        pq.add(new IntegerPair(newr, newc, dist.get(newr).get(newc)));
                    }
                }
            }
        }

        return dist.get(row-1).get(col-1);

    }

    static final int adjR[] = {-1,  0, 1, 0};
    static final int adjC[] = { 0, -1, 0, 1};

    void put(List<List<Integer>> data, int src_index_x, int src_index_y, int value){
        List<Integer> datas = data.get(src_index_x);
        datas.set(src_index_y, value);

        data.set(src_index_x, datas);
    }


    class IntegerPair{
        public int u, v, weigh;

        public IntegerPair(int u, int v, int weigh) {
            this.u = u;
            this.v = v;
            this.weigh = weigh;
        }
    }

    void print(Object object){
        if(debug)
            template_utility.print(getOutput(), object.toString(), false, true);
    }

    void println(Object object){
        if(debug)
            template_utility.print(getOutput(), object.toString(), true, true);
    }
}
