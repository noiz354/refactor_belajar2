package norman.unknown;

import norman.template.Template;

/**
 * Created @author normansyahputa  on 12/11/16.
 * demonstration of maximum sum subarray
 */
public class MaximalSubArray extends Template {
    public MaximalSubArray() {
        super("MaximalSubArray", "MaximalSubArray", LINUX, true);
    }

    @Override
    public void doSomething() {
        while (true) {
            String[] data = getInput().nextLine().split(" ");
            int[] datas = new int[data.length];
            int i = 0;
            for (String datum : data) {
                datas[i] = Integer.parseInt(datum);
                i++;
            }

            System.out.println(maximalSubarraySpace(datas, datas.length));

            // using util below
            long[] sum = ContiguousArraySum.findSum(datas, datas.length);
            System.out.printf("%d - non %d", sum[1], sum[0]);

            if (!getInput().hasNext())
                break;
        }
    }

    int maximalSubarraySpace(int[] array, int n) {
        // build out solution array
        int[] subproblems = new int[n];
        if (array[0] > 0) {
            subproblems[0] = array[0];
        } else {
            subproblems[0] = 0;
        }
        System.out.print((subproblems[0]));
//        subproblems[0] = max(array[0], 0);
        for (int i = 1; i < n; i++) {
            if (subproblems[i - 1] + array[i] > 0) {
                subproblems[i] = (subproblems[i - 1] + array[i]);
            } else {
                subproblems[i] = 0;
            }
            System.out.print(" " + (subproblems[i]));
//            subproblems[i] = max(subproblems[i-1] + array[i], 0);
        }
        System.out.println();

        // iterate through to find the maximum
        int max = 0;
        for (int i = 0; i < n; i++) {
            if (subproblems[i] > max) {
//                System.out.print(" i ["+i+"] "+(array[i]));
                max = subproblems[i];
            }
//            max = max(max, subproblems[i]);
        }
//        System.out.println();
        return max;
    }

    public static class ContiguousArraySum {

        /**
         * @param a input array
         * @param n number of elements in the array
         * @return returns the array of size 2, element at 0 gives sum of contiguous elements
         * while element at 1 gives sum of non-contiguous elements.
         */
        private static long[] findSum(int[] a, int n) {
            long[] result = new long[2];
            long contSum = a[0];
            long prevContSum = a[0];
            long nonContSum = a[0];

            for (int i = 1; i < n; i++) {
                if (contSum < 0 && a[i] >= 0) {
                    contSum = a[i];
                } else {
                    contSum += a[i];
                }
                if (nonContSum < 0 && a[i] >= 0) {
                    nonContSum = a[i];
                } else if (nonContSum + a[i] > nonContSum) {
                    nonContSum += a[i];
                } else if (nonContSum < a[i] && nonContSum + a[i] < nonContSum) {
                    nonContSum = a[i];
                }
                if (contSum >= prevContSum) {
                    prevContSum = contSum;
                } else if (contSum < 0) {
                    contSum = a[i];
                }
            }

            result[0] = contSum > prevContSum ? contSum : prevContSum;
            result[1] = nonContSum;
            return result;
        }

    }
}
