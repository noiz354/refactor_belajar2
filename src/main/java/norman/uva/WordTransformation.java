package norman.uva;

import norman.template.template;
import norman.template.template_utility;

import java.util.*;

/**
 * Created by normansyahputa on 12/5/16.
 */
public class WordTransformation extends template {
    public WordTransformation() {
        super("WordTransformation", "WordTransformation", LINUX, true);
    }

    @Override
    public void doSomething() {

        String s = getInput().nextLine();
        int T = Integer.parseInt(s);
        // read blank line
        getInput().nextLine();

        while(T-->0){
            adjList = new HashMap<>();
            visited = new HashMap<>();

            while(true){
                String dic = getInput().nextLine();
//            println(dic);
                if(dic.equals("*"))
                    break;

                List<String> adj = null;
                if(adjList.get(dic)!=null){
                    adj = adjList.get(dic);
                }else{
                    adj = new ArrayList<>();
                    adjList.put(dic, adj);
                }

                Iterator<String> it = adjList.keySet().iterator();
                while(it.hasNext()){
                    String key = it.next();
                    if(dic.equals(key))
                        continue;

                    int diff = 0;
//                int length = dic.length() > key.length() ? key.length() : dic.length();
                    if(dic.length() == key.length()){
                        for(int i=0;i<dic.length();i++){
                            if(key.charAt(i)!=dic.charAt(i)){
                                diff++;
                            }
                        }

                        if(diff == 1){
                            List<String> adj2 = null;
                            if(adjList.get(key)!=null){
                                adj2 = adjList.get(key);
                            }else{
                                adj2 = new ArrayList<>();
                                adjList.put(key, adj2);
                            }

                            adj.add(key);
                            adjList.put(dic, adj);

                            adj2.add(dic);
                            adjList.put(key, adj2);
                        }
                    }
                }
            }

//            printAdjList();

            String line = getInput().nextLine();
            while(!line.equals("")){
                String[] q = line.split(" ");
//                println(Arrays.toString(q));

                initVisited();
//            visited.clear();
                println(q[0]+" "+q[1]+" "+bfs(q[0],q[1]));

                if(!getInput().hasNext())
                    break;
                line = getInput().nextLine();
                if(line.equals("")){
                    break;
                }
            }

            if(T!=0)
                println("");
        }
    }

    int bfs(String start, String to){
        Queue<String> s = new LinkedList<>();
        s.offer(start);
        visited.put(start, 0);
        while(!s.isEmpty()){
            String top = s.poll();
            if(top.equals(to))
                return visited.get(top);
            int total = adjList.get(top).size();
            for(int i=0;i<total;i++){
                if(visited.get(adjList.get(top).get(i))==0){
                    visited.put(adjList.get(top).get(i), visited.get(top)+1);
                    s.offer(adjList.get(top).get(i));
                }
            }
        }
        return visited.get(to);
    }

    void initVisited(){
        for(Iterator<String> it = adjList.keySet().iterator();it.hasNext();){
            String next = it.next();
            List<String> adj = adjList.get(next);
            visited.put(next, 0);
        }
    }

    Map<String, List<String>> adjList;
    Map<String, Integer> visited;

    void printAdjList(){
        for(Iterator<String> it = adjList.keySet().iterator();it.hasNext();){
            String next = it.next();
            List<String> adj = adjList.get(next);
            println(next+" "+adj);
        }
    }

    void print(Object object){
        template_utility.print(getOutput(), object.toString(), false, true);
    }

    void println(Object object){
        template_utility.print(getOutput(), object.toString(), true, true);
    }
}
