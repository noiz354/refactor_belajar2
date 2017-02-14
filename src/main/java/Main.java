import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

class Main {

    BufferedReader reader;
    Scanner input;

    public static void main(String[] args) {
        try {
            new Main().go();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void go() throws Exception {
        String line;

        try {
            line = getInput2().readLine();

            while (line != null) {
                int n = Integer.parseInt(line), a, b;

                int ori[] = new int[50];
                line = getInput2().readLine();
                String[] lines = line.split(" ");
                int[] ints1 = convToInt(lines);

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

                    System.out.println(String.format("%d", table[n][n]));
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private int[] convToInt(String[] lines) {
        int[] res = new int[lines.length];
        int c = 0;
        for (String line : lines) {
            res[c] = Integer.parseInt(line);
            c++;
        }
        return res;
    }

    private BufferedReader getInput2() {
        reader = new BufferedReader(new InputStreamReader(System.in));
		return reader;
	}

	Scanner getInput() {
		if(input==null){
			input = new Scanner(System.in);
		}
		return input;
	}

}
