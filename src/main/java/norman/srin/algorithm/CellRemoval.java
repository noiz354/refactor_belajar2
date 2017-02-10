package norman.srin.algorithm;

import norman.template.Template;

import java.util.ArrayList;
import java.util.List;


public class CellRemoval extends Template {

    int[] C;
    int head;
    List<List<Integer>> adjs;

    public CellRemoval() {
        super("CellRemoval", "CellRemoval", LINUX);
    }

    @Override
    public void doSomething() {
        int TC = getInput().nextInt();
        int total = TC;
        while (TC-- > 0) {
            System.out.println("Case #" + (total - TC));

            adjs = new ArrayList<List<Integer>>(100);
            for (int i = 0; i < 100; i++) {
                adjs.add(null);
            }

//			System.out.println(adjs.get(0).equals(adjs.equals(o)));

            int CSize = getInput().nextInt();
            C = new int[CSize];
            for (int i = 0; i < CSize; i++) {
                C[i] = getInput().nextInt();

                if (C[i] == -1) {
                    head = i;
                } else {
                    List<Integer> temp = null;
                    if (adjs.get(C[i]) == null) {
                        temp = new ArrayList<>();
                    } else {
                        temp = adjs.get(C[i]);
                    }

                    temp.add(i);

                    adjs.set(C[i], temp);
                }
            }
//			System.out.println(Arrays.toString(C));

//			System.out.println("before deletion");
//			for(int i=0;i<CSize;i++){
//				System.out.println("index ["+i+"] value "+ adjs.get(i)+"");
//			}
//			System.out.println("head " + head);
            int deletedCell = getInput().nextInt();
//			System.out.println(deletedCell);

            // performed deletedCell in here
            for (int i = 0; i < CSize; i++) {
                if (adjs.get(i) != null) {
                    List<Integer> temp = adjs.get(i);
                    for (int j = 0; j < temp.size(); j++) {
                        if (deletedCell == temp.get(j)) {
                            temp.remove(j);
                        }
                    }
                    adjs.set(i, temp);
                }
            }
//			System.out.println("after deletion");
//			for(int i=0;i<CSize;i++){
//				System.out.println("index ["+i+"] value "+ adjs.get(i)+"");
//			}

            // start transverse
            int result = getCount(head);
            System.out.println(result);
        }// end of test case
    }

    private int getCount(int index) {
        if (adjs.get(index) == null) {
            return 1;
        }

        int ans = 0;

        for (int i = 0; i < adjs.get(index).size(); i++) {
            ans += getCount(adjs.get(index).get(i));
        }
        return ans;
    }
}
