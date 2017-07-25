package norman.unknown;

/**
 * just input reader for debugging purpose
 * {@link Mobile}
 */
public class MobileInput extends Mobile{
    @Override
    public void doSomething() {
        int n = getInput().nextInt(); // number of rods

        adj = new int[n+10][2];
        leaf = new int[n+10];

        int tmp = n;

        for (int i = 0; i < tmp; i++) {// rod i
            int l = getInput().nextInt();// left node
            int r = getInput().nextInt(); // right node

            if(l < 0){
                leaf[n] = 1;
                adj[i][0] = n++;// increment setelah menyimpan index child leaf
            }else{
                adj[i][0] = --l;
            }

            if(r < 0){
                leaf[n] = 1;
                adj[i][1] = n++;
            }else{
                adj[i][1] = --r;
            }
        }

        println("for debugging purpose");
    }

    int leaf[];

    int adj[][];
}
