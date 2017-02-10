package norman.uva;

import norman.template.Template;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

/**
 * Created @author normansyahputa  on 12/2/16.
 */
public class Beverages extends Template {
    HashMap<String, Integer> map;
    HashMap<Integer, String> unmap;
    KahnTopSort.KahnTopSortUtil kahnTopSortUtil;
    private ArrayList<List<Integer>> adjList;

    public Beverages() {
        super("Beverages", "Beverages", LINUX, true);
    }

    @Override
    public void doSomething() {
        while(true){
            int V = Integer.valueOf(getInput().nextLine());

            kahnTopSortUtil = new KahnTopSort.KahnTopSortUtil(V);

            map = new HashMap<>();
            unmap = new HashMap<>();
            adjList = new ArrayList<>();
            for(int i=0;i<V;i++){
                String input= getInput().nextLine();
                unmap.put(i, input);
                map.put(input, i);
                adjList.add(new ArrayList<>());
            }

            int E = Integer.valueOf(getInput().nextLine());
            for(int i=0;i<E;i++) {
                String s = getInput().nextLine();
                String[] split = s.split(" ");
                Integer u = map.get(split[0]);
                Integer v = map.get(split[1]);
                List<Integer> integers = adjList.get(u);
                if(!integers.contains(v))
                    integers.add(v);
                Collections.sort(integers);
                adjList.set(u, integers);
            }

            printAdjList();
            if(getInput().hasNext())
                getInput().nextLine();

            kahnTopSortUtil.setAdjList(adjList);
            List<Integer> integers = kahnTopSortUtil.topSort();
            for (Integer integer : integers) {
                String s = unmap.get(integer);
                System.out.print(" "+s);
            }
            System.out.println();


            if(!getInput().hasNext()){
                break;
            }

        }
    }

    void printAdjList(){
        for(int i=0;i<adjList.size();i++){
            if(i!=0)
                System.out.print(" ");
            System.out.print(adjList.get(i));
        }
        System.out.println();
    }
}
