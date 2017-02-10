package norman.uva;

import norman.template.Template;

import java.util.Arrays;

/**
 * Created @author normansyahputa  on 12/13/16.
 * taken from https://gsourcecode.wordpress.com/2012/04/13/10337-flight-planner/
 * <p>
 * just from learning
 */
public class FlightPlanner extends Template {
    final static int INF = 100000000;
    static final int MAX_W = 1000, h = 10;
    static final int[] moveFuel = {60, 30, 20};
    int[][] wind, minFuel;
    int w;

    public FlightPlanner() {
        super("FlightPlanner", "FlightPlanner", LINUX, true);
    }

    @Override
    public void doSomething() {
        int nCases, caseI;
        nCases = getInput().nextInt();

        for (caseI = 0; caseI < nCases; ++caseI) {
            w = getInput().nextInt();
            // setiap 100 miles hitung semuanya
            // sama dengan setiap langkah
            w /= 100;

            wind = new int[h][w + 1];
            minFuel = new int[h][w + 1];

            input();

            if (debug) {
                System.out.println("#### wind ####");
                for (int i = 0; i < wind.length; i++)
                    System.out.println(Arrays.toString(wind[i]));
                System.out.println("#### wind ####");

                System.out.println("#### minFuel ####");
                for (int i = 0; i < minFuel.length; i++)
                    System.out.println(Arrays.toString(minFuel[i]));
                System.out.println("#### minFuel ####");
            }

            System.out.printf("%d\n\n", solve());

            if (debug) {
                System.out.println("#### wind ####");
                for (int i = 0; i < wind.length; i++)
                    System.out.println(Arrays.toString(wind[i]));
                System.out.println("#### wind ####");

                System.out.println("#### minFuel ####");
                for (int i = 0; i < minFuel.length; i++)
                    System.out.println(Arrays.toString(minFuel[i]));
                System.out.println("#### minFuel ####");
            }
        }
    }

    int solve() {
        int y, x, i;
        for (x = 1; x < w; ++x) {
            for (y = 0; y < h - 1; ++y) {
                minFuel[y][x] = INF;
                for (i = -1; i <= 1; ++i) {
                    if (debug)
                        System.out.println(y + "," + x + " [" + (y - i) + "][" + (x - 1) + "]");
                    if (y - i >= 0 && y - i < h) {
                        minFuel[y][x] = min(minFuel[y][x]
                                , minFuel[y - i][x - 1] + moveFuel[i + 1] - wind[y - i][x - 1]);
                    }
                }
            }
        }
        if (debug)
            System.out.println("[" + (h - 2) + "][" + (w - 1) + "] " + minFuel[h - 2][w - 1]);


        x = w - 1;
        y = 9;
//            for(y=0;y<h-1;++y){
        minFuel[y][x] = INF;
        for (i = -1; i <= 1; ++i) {
            if (debug)
                System.out.println(y + "," + x + " [" + (y - i) + "][" + (x - 1) + "]");
            if (y - i >= 0 && y - i < h) {
                minFuel[y][x] = min(minFuel[y][x]
                        , minFuel[y - i][x - 1] + moveFuel[i + 1] - wind[y - i][x - 1]);
            }
        }
//            }

        x = w;
        y = 9;
//            for(y=0;y<h-1;++y){
        minFuel[y][x] = INF;
        for (i = -1; i <= 1; ++i) {
            if (debug)
                System.out.println(y + "," + x + " [" + (y - i) + "][" + (x - 1) + "]");
            if (y - i >= 0 && y - i < h) {
                minFuel[y][x] = min(minFuel[y][x]
                        , minFuel[y - i][x - 1] + moveFuel[i + 1] - wind[y - i][x - 1]);
            }
        }
//            }

//        int a = minFuel[h - 2][w - 1] + moveFuel[2] - wind[h - 2][w - 1];

        return minFuel[9][x];
    }

    int min(int x, int y) {
        return (x < y) ? x : y;
    }

    private void input() {
        int y, x;
        for (y = 0; y < h; ++y)// row
            for (x = 0; x < w; ++x)// col
                wind[y][x] = getInput().nextInt();

        minFuel[h - 1][0] = 0;

        // bottom
        for (x = 1; x < w - 1; ++x) {// col
            wind[h - 1][x] = -INF / 4;
            minFuel[h - 1][x] = INF / 4;
        }

        // right column
        for (y = 0; y < h - 1; ++y) {// row
            wind[y][0] = -INF / 4;
            minFuel[y][0] = INF / 4;
        }

        // left column
        for (y = 0; y < h - 1; y++) {// row
            minFuel[y][w - 1] = INF / 4;
        }
    }
}
