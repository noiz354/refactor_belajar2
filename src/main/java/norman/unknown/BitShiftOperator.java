package norman.unknown;

import norman.template.Template;
import norman.template.TemplateUtility;

/**
 * Created  on 1/26/17.
 *
 * @author normansyahputa
 */
public class BitShiftOperator {
    public static void main(String[] args) {
        fromTutorial();
        forCD();
        uniqueY2K();
        uniqueY2K_2();
        new BitShiftOperatorTest().doSomething();
    }

    private static void uniqueY2K_2() {
        int i = 1 << 2;
        for (int j = 0; j < 12; ++j) {
            int k = i & (1 << i);
            System.out.println("hello3 " + k);
        }
    }

    // https://github.com/morris821028/UVa/blob/master/volume105/10576%20-%20Y2K%20Accounting%20Bug.cpp
    private static void uniqueY2K() {
        int i = 1 << 12;
        System.out.println("halo #" + i);
        for (int j = 0; j < 12; j++)
            System.out.println("halo 2#" + ((i >> j) & 1));
    }

    /**
     * this is demo of bit shifting used at this class
     * {@link norman.uva.CD2}
     */
    private static void forCD() {
        for (int i = 0; i < 4; i++) {
            System.out.println(0 | 1 << i);
        }

        System.out.println("#### ini demo sebagai pengganti boolean array ");
        int selection = 5; // bit representation 101, index 2,1,0
        System.out.println(Integer.toBinaryString(selection));
        // then move to 4

        // if get selected then
        int ifSelected = selection | 1 << 3;
        System.out.println("if get selected for position-4 : " + Integer.toBinaryString(ifSelected));

        // if not get selected then do nothing
        System.out.println("if not get selected for position-4 then do nothing : " + Integer.toBinaryString(selection));

        // the way for get index based on set
        for (int i = 0; i < 4; i++) {
            //[START] this is what show binary format.
            int binary = (ifSelected >> i) % 2;
            //[END] this is what show binary format.
            if (binary != 0) {
                System.out.print("1");
            } else {
                System.out.print("0");
            }
        }
        System.out.println();
    }

    // http://javarevisited.blogspot.co.id/2013/03/bitwise-and-bitshift-operators-in-java-and-or-xor-left-right-shift-example-tutorial.html
    private static void fromTutorial() {
        int number = 8; //0000 1000
        System.out.println("Original number : " + number);

        //left shifting bytes with 1 position
        number = number << 1; //should be 16 i.e. 0001 0000

        //equivalent of multiplication of 2
        System.out.println("value of number after left shift: " + number);

        number = -8;
        //right shifting bytes with sign 1 position
        number = number >> 1; //should be 16 i.e. 0001 0000

        //equivalent of division of 2
        System.out.println("value of number after right shift with sign: " + number);

        number = -8;
        //right shifting bytes without sign 1 position
        number = number >>> 1; //should be 16 i.e. 0001 0000

        //equivalent of division of 2
        System.out.println("value of number after right shift with sign: " + number);
    }

    private static class BitShiftOperatorTest extends Template {

        public BitShiftOperatorTest() {
            super("BitShiftOperatorTest", "BitShiftOperatorTest", LINUX, true);
        }

        @Override
        public void doSomething() {
            for (int year = (1 << 12) - 1; year >= 0; year--) {
                TemplateUtility.print(getOutput(), String.format("hello #4 %d\n", year), true, true);
                int tot = 0, flag = 1;
                for (int i = 0; i < 12; i++) {
                    TemplateUtility.print(getOutput(), String.format("hello #5 %d %d --> %d\n", year, i, ((year >> i) & 1)), true, true);
                }
            }
        }
    }
}
