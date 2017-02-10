package norman.unknown;

import norman.template.Template;

import java.util.Arrays;

/**
 * Created @author normansyahputa  on 12/12/16.
 * taken from http://blueocean-penn.blogspot.co.id/2015/02/text-justification-algorithm-dynamic.html
 * <p>
 * demo of how text justification using dynamic programming
 */
public class WordJustification extends Template {
    static final int INF = 100000000;
    String words[];
    int windowSize;

    public WordJustification() {
        super("WordJustification", "WordJustification", LINUX, true);
    }

    //sample code for badness measurement

    public static void textJustification(String[] words, int width) {
        int len = words.length;
        double[] table = new double[len];
        int[] indices = new int[len];
        table[len - 1] = fullness(words, len - 1, len - 1, width);
        indices[len - 1] = -1;

        for (int k = len - 2; k <= 0; k--) {
            table[k] = Integer.MIN_VALUE;
            for (int i = 0; k + i < len; i++) {
                double fullness = fullness(words, k, k + i, width);
                if (fullness == 0d)
                    break;
                double dp = k + i + 1 < len ? table[k + i + 1] : 0;
                if (fullness + dp > table[k]) {
                    table[k] = fullness + dp;
                    indices[k] = k + i + 1;
                }
            }
        }

        for (int i = 0; i < len; i = indices[i]) {
            System.out.println(i);
        }
    }

    public static double fullness(String[] words, int i, int j, int w) {
        int length = words[i].length();
        for (int m = i + 1; m <= j; m++)
            length += words[i].length() + 1;
        return length <= w ? (double) length / w : 0;
    }

    public static double badness(String[] words, int i, int j, int w) {
        int length = words[i].length();
        for (int m = i + 1; m <= j; m++)
            length += words[i].length() + 1;
        return length <= w ? Math.pow(w - length, 3) : Integer.MAX_VALUE;
    }

    @Override
    public void doSomething() {
        while (true) {

            words = getInput().nextLine().split(" ");
            int[] l = new int[words.length];
            for (int i = 0; i < words.length; i++) {
                l[i] = words[i].length();
            }
            windowSize = getInput().nextInt();
            System.out.println(Arrays.toString(words) + " window size " + windowSize);

//            System.out.println(DP(0));
//            textJustification(words, windowSize);
            solveWordWrap(l, words.length, windowSize);

            if (!getInput().hasNext()) {
                break;
            }
        }
    }

    double DP(int i) {
        if (i == 0) {
            return 0;
        }
        double min = Double.MAX_VALUE;
        for (int j = i + 1; j < windowSize + 1; j++) {
            min = Math.min((DP(j) + badness(words, i, j, windowSize)), min);
        }
        return min;
    }

    // l[] represents lengths of different words in input sequence. For example,
    // l[] = {3, 2, 2, 5} is for a sentence like "aaa bb cc ddddd".  n is size of
    // l[] and M is line width (maximum no. of characters that can fit in a line)
    void solveWordWrap(int l[], int n, int M) {
        // For simplicity, 1 extra space is used in all below arrays

        // extras[i][j] will have number of extra spaces if words from i
        // to j are put in a single line
        int extras[][] = new int[n + 1][n + 1];

        // lc[i][j] will have cost of a line which has words from
        // i to j
        int lc[][] = new int[n + 1][n + 1];

        // c[i] will have total cost of optimal arrangement of words
        // from 1 to i
        int c[] = new int[n + 1];

        // p[] is used to print the solution.
        int p[] = new int[n + 1];

        int i, j;

        // calculate extra spaces in a single line.  The value extra[i][j]
        // indicates extra spaces if words from word number i to j are
        // placed in a single line
        for (i = 1; i <= n; i++) {
            extras[i][i] = M - l[i - 1];
            for (j = i + 1; j <= n; j++)
                extras[i][j] = extras[i][j - 1] - l[j - 1] - 1;
        }

        // Calculate line cost corresponding to the above calculated extra
        // spaces. The value lc[i][j] indicates cost of putting words from
        // word number i to j in a single line
        for (i = 1; i <= n; i++) {
            for (j = i; j <= n; j++) {
                if (extras[i][j] < 0)
                    lc[i][j] = INF;
                else if (j == n && extras[i][j] >= 0)
                    lc[i][j] = 0;
                else
                    lc[i][j] = extras[i][j] * extras[i][j];
            }
        }

        // Calculate minimum cost and find minimum cost arrangement.
        //  The value c[j] indicates optimized cost to arrange words
        // from word number 1 to j.
        c[0] = 0;
        for (j = 1; j <= n; j++) {
            c[j] = INF;
            for (i = 1; i <= j; i++) {
                if (c[i - 1] != INF && lc[i][j] != INF && (c[i - 1] + lc[i][j] < c[j])) {
                    c[j] = c[i - 1] + lc[i][j];
                    p[j] = i;
                }
            }
        }

        printSolution(p, n);
    }

    int printSolution(int p[], int n) {
        int k;
        if (p[n] == 1)
            k = 1;
        else
            k = printSolution(p, p[n] - 1) + 1;
//        System.out.printf ("Line number %d: From word no. %d to %d \n", k, p[n], n);
        int index = p[n] - 1;
        System.out.printf("%s", words[index]);
        for (int i = index + 1; i < n; i++) {
            System.out.printf(" %s", words[i]);
        }
        System.out.println();
        return k;
    }
}
