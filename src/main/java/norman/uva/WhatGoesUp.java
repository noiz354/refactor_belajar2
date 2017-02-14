package norman.uva;

import norman.template.Template2;

import java.io.IOException;
import java.util.Arrays;

/**
 * Created on 2/10/17.
 *
 * @author normansyahputa
 *         <p>
 *         uva 481 - failed
 *         converted from cpp but failed.
 */
public class WhatGoesUp extends Template2 {

    Integer[] A, M, M_id, P;

    public WhatGoesUp() {
        super("WhatGoesUp", "WhatGoesUp", LINUX, true);
    }

    public static int lower_bound(Comparable[] arr, Comparable key) {
        int len = arr.length;
        int lo = 0;
        int hi = len - 1;
        int mid = (lo + hi) / 2;
        while (true) {
            int cmp = arr[mid].compareTo(key);
            if (cmp == 0 || cmp > 0) {
                hi = mid - 1;
                if (hi < lo)
                    return mid;
            } else {
                lo = mid + 1;
                if (hi < lo)
                    return mid < len - 1 ? mid + 1 : -1;
            }
            mid = (lo + hi) / 2;
        }
    }

    public static int upper_bound(Comparable[] arr, Comparable key) {
        int len = arr.length;
        int lo = 0;
        int hi = len - 1;
        int mid = (lo + hi) / 2;
        while (true) {
            int cmp = arr[mid].compareTo(key);
            if (cmp == 0 || cmp < 0) {
                lo = mid + 1;
                if (hi < lo)
                    return mid < len - 1 ? mid + 1 : -1;
            } else {
                hi = mid - 1;
                if (hi < lo)
                    return mid;
            }
            mid = (lo + hi) / 2;
        }
    }

    @Override
    public void doSomething() {
        A = new Integer[1_000_000];
        M = new Integer[1_000_000];
        M_id = new Integer[1_000_000];
        P = new Integer[1_000_000];
        Arrays.fill(A, new Integer(0));
        Arrays.fill(M, new Integer(0));
        Arrays.fill(M_id, new Integer(0));
        Arrays.fill(P, new Integer(0));

        String line;

        int L = 0, L_end = 0, i = 0;
        try {
            while ((line = getInput2().readLine()) != null) {
                println("\"" + line + "\"");
                A[i] = Integer.parseInt(line);

                int pos = lower_bound(M, A[i]);
                if (pos != -1) {
                    M[pos] = A[i];
                    M_id[pos] = i;
                    P[i] = pos > 0 ? M_id[pos - 1] : -1;
                    if (pos == L) {
                        L++;
                        L_end = i;
                    }
                }

                i++;
            }
            print(String.format("%d\n-\n", L));
            localPrint(L_end);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    void localPrint(int end) {
        if (end < 0)
            return;

        print(P[end] + "");
        print(String.format("%d\n", A[end]));
    }
}
