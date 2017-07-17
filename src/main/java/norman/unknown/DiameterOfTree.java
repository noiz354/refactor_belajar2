package norman.unknown;

import norman.template.Template;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by normansyahputa on 7/17/17.
 *
 * http://codeforces.com/blog/entry/20935
 *
 * input using Binary Tree.
 *
 * disini menggunakan jumlah node.
 */
public class DiameterOfTree extends Template{
    public DiameterOfTree() {
        super("DiameterOfTree", "DiameterOfTree", LINUX, true);
    }

    @Override
    public void doSomething() {
        int N = getInput().nextInt();

        //[START] init adjList
        adjList = new ArrayList<>();

        for (int i = 0; i < N+1; i++) {
            adjList.add(new ArrayList<>());
        }
        //[END] init adjList

        for (int i = 0; i < N - 1; i++) {
            int a = getInput().nextInt();
            int b = getInput().nextInt();

            adjList.get(a).add(b);
            adjList.get(b).add(a);
        }

        f = new int[N+1];
        g = new int[N+1];

        dfs(1,0);
        println(diameter);
    }

    void dfs(int V, int pV){
        List<Integer> fValues = new ArrayList<>();

        // transverse over all children
        for (Integer v : adjList.get(V)) {
            if(v == pV){
                continue;
            }
            dfs(v, V);
            fValues.add(f[v]);
        }

        // sort ascending - kecil ke besar
        Collections.sort(fValues);

        f[V] = 1;
        if(!fValues.isEmpty()){
            f[V] += fValues.get(fValues.size()-1);
        }

        if(fValues.size()>=2){
            g[V] = 1+fValues.get(fValues.size()-1) + fValues.get(fValues.size()-2);
        }

        diameter = Math.max(diameter, Math.max(f[V], g[V]));

    }

    List<List<Integer>> adjList;

    int f[], g[], diameter;


}
