import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.Scanner;

import static java.lang.Math.max;

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

    void go() throws Exception {
        int s, d;
        while (true) {
            s = getInput().nextInt();
            d = getInput().nextInt();
            int ret = solve(s, d);
            if (ret < 0)
                System.out.println("Deficit");
            else
                System.out.println(ret);

			if(!getInput().hasNext()){
				break;
			}
		}
	}

    private int solve(int s, int d) {
        int ret = -1;
        for (int i = 0; i < (1 << 12); ++i) {
            ret = max(ret, compute(i, s, d));
        }
        return ret;
    }

    // 111101111011
    private int compute(int values, int s, int d) {
        int sum = 0;
        int cons = 0;
        for (int i = 0; i < 12; ++i) {
            int b = (values & (1 << i));
            int v = (b != 0) ? s : -d;
            sum += v;
            if (i < 4) {
                cons += v;
            } else {
                cons = cons + v;
                if (cons >= 0)
                    return -1;
                cons -= ((values & (1 << (i - 4))) != 0) ? s : -d;
            }
        }
        return sum;
    }

	Reader getInput2(){
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
