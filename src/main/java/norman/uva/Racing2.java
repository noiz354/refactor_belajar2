package norman.uva;

import norman.template.Template;
import norman.template.TemplateUtility;

/**
 * Created @author normansyahputa  on 11/4/16.
 * replacement of {@link Racing}
 */
public class Racing2 extends Template {
    edge D[], E[];
    int p[], r[];

    public Racing2() {
        super("racing", "racing", LINUX, true);
    }

    @Override
    public void doSomething() {
        D = new edge[100_000];
        E = new edge[100_000];

        p = new int[10_001];
        r = new int[10_001];

        // number of dataset
        int c = getInput().nextInt();
        while(c-- >  0) {

            // juction
            int n = getInput().nextInt();

            // road
            int m = getInput().nextInt();

            // from 1..n
            int sum = 0;
            for (int i = 0; i < m; i++) {
                edge edge = new edge();
                edge.x = getInput().nextInt();
                edge.y = getInput().nextInt();
                edge.v = getInput().nextInt();
                D[i] = edge;
                sum += D[i].v;
            }

            if(debug) {
            // before sorting
                print("before sorting");
                for (edge edge : D) {
                    print(edge);
                }
            }

            sort(m);

            if(debug){
                // after sorting
                print("after sorting");
                for (edge edge : E) {
                    print(edge);
                }
            }

            init(n);

            for(int i =0;i < m; i++){
                if(joint(E[i].x, E[i].y)){
                    sum -= E[i].v;
                }
            }

            print(sum);
        }
        getInput().nextInt();
    }

    boolean joint(int x, int y){
        x = find(x);
        y = find(y);
        if(x != y){
            if(r[x] > r[y]) {
                r[x] += r[y];
                p[y] = x;
            }else{
                r[y] += r[x];
                p[x] = y;
            }
            return true;
        }
        return false;
    }

    int find(int x){
        return p[x] == x ? x : (p[x] = find(p[x]));
    }

    void init(int n){
        int i;
        for(i=0;i<=n;i++){
            p[i] = i;
            r[i] = 1;
        }
    }

    void sort(int n){
        int w[] = new int[1001];
        int i;
        for(i=0;i<n;i++){
            w[D[i].v]++;
        }
        for(i=999; i>=0;i--){
            w[i] += w[i+1];
        }
        for(i=0;i<n;i++){
            E[--w[D[i].v]] = D[i];
        }
    }

    class edge{
        int x,y,v;

        @Override
        public String toString() {
            return x + "," + y +"," + v;
        }
    }
}
