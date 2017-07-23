package norman.unknown;

import norman.template.Template;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author normansyahputa on 7/23/17.
 *
 * this is just code for this.
 * http://www.iarcs.org.in/inoi/online-study-material/problems/mobiles-apio-soln.php#solution
 *
 * real problem
 * http://apio-olympiad.org/2007/apio-en.pdf
 *
 * first attempt.
 */
public class Mobile extends Template{
    public Mobile() {
        super("Mobile", "Mobile", LINUX, true);
    }

    @Override
    public void doSomething() {
        int N = getInput().nextInt();

        depth = new int[N+1];
        m = new int[N+1];
        c = new int[N+1];
        adj = new ArrayList<>();

        for(int i=0;i<N+1;i++){
            adj.add(new ArrayList<>());
        }

        int read_list = getInput().nextInt();
        println(String.format("read_list : %d", read_list));

        for (int i = 0; i < read_list; i++) {
            int a = getInput().nextInt();
            int b = getInput().nextInt();

            println(String.format("%d & %d", a, b));

            adj.get(a).add(b);
        }

        println(Arrays.toString(depth));

        M(1);
        println(m[1]);
    }

    int M(int v){
        if(adj.get(v).size()-1 > 0){
            int leftChild = adj.get(v).get(0);
            int rightChild = adj.get(v).get(1);

            if(depth[leftChild]<depth[rightChild]){
                return m[v] = 1 +  C(leftChild) + M(rightChild);
            }

            if(depth[leftChild]>depth[rightChild]){
                return m[v] = M(leftChild)+C(rightChild);
            }

            if(depth[leftChild]==depth[rightChild]){
                return m[v] = Math.min( 1+ M(leftChild) + C(rightChild), C(leftChild) + M(rightChild));
            }
        }

        return 0;
    }

    int C(int v){
        // if v has complete tree
        if(adj.get(v).size()-1 == 0 || adj.get(v).size()-1 == 2)
            return 0;
        else // otherwise
            return Integer.MAX_VALUE;
    }

    List<List<Integer>> adj;
    int[] depth, m, c;
}
