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
 * first attempt. FAILED ( wrong understanding !! )
 *
 * why failed ? failed to calculate height,
 */
public class Mobile extends Template{
    public Mobile() {
        super("Mobile", "Mobile", LINUX, true);
    }

    @Override
    public void doSomething() {
        int N = getInput().nextInt();

        int tmp = N;

        adj = new int[N+1][2];
        leaf = new int[N*2+1];
        height = new int[N*2];
        typ = new int[N*2];
        swapped = new int[N*2];

        for (int i = 0; i < tmp; i++) {
            adj[i][0] = getInput().nextInt();
            adj[i][1] = getInput().nextInt();

            if(adj[i][0]<0){
                adj[i][0] = N;
                leaf[N++] = 1;
            }else{
                --adj[i][0];
            }

            if(adj[i][1]<0){
                adj[i][1] = N;
                leaf[N++] = 1;
            }else{
                --adj[i][1];
            }
        }

        dfs(0);

        print(String.format("%d\n",typ[0] < 0 ? typ[0] : swapped[0]));
    }

    private void dfs(int v){

        if(leaf[v] == 0){
            height[v] = 1;
            return;
        }

        int l = adj[v][0];
        int r = adj[v][0];

        dfs(l);
        dfs(r);

//	cout << l << " " << typ[l] << " " << swapped[l] << " " << height[l] << endl;
//	cout << r << " " << typ[r] << " " << swapped[r] << " " << height[r] << endl;

        height[v] = Math.max(height[l],height[r])+1;
        typ[v] = Math.min(typ[l],typ[r]);
        swapped[v] = swapped[l]+swapped[r];

        if(typ[v] < 0) return;

        if(typ[l] != 0 && typ[r] != 0){		//both incomplete
            typ[v] = -1;
            return;
        }

        if(height[l] == height[r]){			//heights are same then the complete subtree will go first
            swapped[v] += typ[l] < typ[r] ? 1 : 0 ;
            return;
        }

        typ[v] = 0;
        if(height[l] < height[r]){			//height are different then the larger subtree will go first
            int temp = l;
            l = r;
            r = temp;
            swapped[v] += 1;
        }

        if(height[l] > height[r]+1){
            typ[v]  = -1;
            return;
        }

        if(typ[r] != 0){						//if the right subtree is smaller than left and not complete
            typ[v] = -1;
            return;
        }
    }



    private int[][] adj;
    private int[] leaf;
    private int[] height;
    private int[] typ;
    private int swapped[];
}
