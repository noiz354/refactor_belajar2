import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Scanner;


/**
 * hackerrank submit Template
 * @author M. Normansyah
 * 2:56:28 PM
 */
public class Solution {


    static BufferedReader reader;
    // setup below here
    static Scanner input = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        int T = getInput().nextInt();
        while (T-- > 0) {
            s = getInput().next();
            t = getInput().next();

            calculateResult();
        }
    }

    private static void calculateResult() {
        boolean res = dp(s.length()-1, t.length()-1);
//        System.out.println(String.format("\"%s\" convert to \"%s\" : \"%s\"", s, t, Boolean.toString(res)));
        System.out.println(res ? "YES" : "NO");
    }

    static String s = null;
    static String t = null;

    static boolean is_del = false;

    static boolean dp(int s_i, int t_i){

        if(s_i == -1 && t_i == -1)
            return true;

        if(s_i < 0 && t_i >= 0 && !is_del){
            return false;
        }else if(s_i < 0 && t_i >= 0 && is_del){
            return true;
        }
        if(isUpper(s.charAt(s_i))){
            if(s.charAt(s_i) == t.charAt(t_i)){
                if(is_del = (s_i-1 >= 0 && t_i-1 < 0))
                    return true && dp(s_i-1, t_i);
                else
                    return true && dp(s_i-1, t_i-1)|| dp(s_i-1, t_i);
            }else{
    /* tidak dapat dihapus, maka string s tidak dapat diubah ke t*/
                return false;
            }
        }else{
            if(toUpper(s.charAt(s_i)) == t.charAt(t_i)){
                if(is_del = (s_i-1 >= 0 && t_i-1 < 0)){
                    return true && dp(s_i-1, t_i);
                }else {
                    return true && dp(s_i - 1, t_i - 1) || dp(s_i-1, t_i);
                }
            }else{
                return dp(s_i-1, t_i);
            }
        }
    }

    static boolean isUpper(char c){
        return c-65 >= 0 && c-65 <=25;
    }

    static int toUpper(int c){
        return c-32;
    }

    static long[] parseInt(String[] input, int n) {
        long[] input2 = new long[n];
        for (int i = 0; i < n; i++) {
            input2[n - i - 1] = getInput().nextLong();
        }
        return input2;
    }

    static BufferedReader getInput2() {
        reader = new BufferedReader(new InputStreamReader(System.in));
        return reader;
    }

    public static Scanner getInput() {
        return input;
	}
}