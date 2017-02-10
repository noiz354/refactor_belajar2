package norman.uva;

import norman.template.Template2;

import java.io.IOException;
import java.util.Arrays;

/**
 * Created on 2/9/17.
 *
 * @author normansyahputa
 *         <p>
 *         uva 111
 *         failed to read the input.
 */
public class HistoryGrading extends Template2 {
    public HistoryGrading() {
        super("HistoryGrading", "HistoryGrading", LINUX, true);
    }

    @Override
    public void doSomething() {
        String line;

        try {
            line = getInput2().readLine();

            while (line != null) {
                println("#1 " + line);
                int n = Integer.parseInt(line), a, b;

                int ori[] = new int[50];
                line = getInput2().readLine();
                String[] lines = line.split(" ");
                int[] ints1 = convToInt(lines);
                println("#2 " + line);

                for (int i = 0; i < n; i++) {
                    ori[ints1[i] - 1] = i;
                }


                while (true) {
                    int ar[] = new int[50];

                    line = getInput2().readLine();
//                    println("#3 " + line);
                    if (line == null || line.split(" ").length == 1)
                        break;
                    int[] ints = convToInt(line.split(" "));
                    println("#3 " + Arrays.toString(ints));

                    for (int i = 0; i < n; i++) {
                        ar[ints[i] - 1] = i;
                    }

                    int table[][] = new int[50][50];
                    // longest common subsequence
                    for (int i = 1; i <= n; i++) {
                        for (int j = 1; j <= n; j++) {
                            if (ori[i - 1] == ar[j - 1])
                                table[i][j] = table[i - 1][j - 1] + 1;
                            else
                                table[i][j] = Math.max(table[i - 1][j], table[i][j - 1]);
                        }
                    }

                    println(String.format("%d", table[n][n]));
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    int[] convToInt(String[] lines) {
        int[] res = new int[lines.length];
        int c = 0;
        for (String line : lines) {
            res[c] = Integer.parseInt(line);
            c++;
        }
        return res;
    }

    void printArray(int[] array, int length) {
        String emptyEndWord = "", commaEndWord = ",";
        for (int i = 0; i < length; i++) {

            if (i != length - 1)
                System.out.print(array[i] + commaEndWord);
            else
                System.out.print(array[i] + emptyEndWord);
        }
        System.out.println();
    }
}
