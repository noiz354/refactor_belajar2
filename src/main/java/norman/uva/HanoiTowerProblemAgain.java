package norman.uva;

import norman.template.Template;

import java.util.ArrayList;
import java.util.List;

/**
 * started at 24-3-2015
 * @author M Normansyah (m.normansyah@samsung.com)
 * converted from
 * https://saicheems.wordpress.com/2013/08/06/uva-10276-hanoi-tower-troubles-again/
 */
public class HanoiTowerProblemAgain extends Template {

    int T, N, tot;
    int peg[];
    List<List<Integer>> pegMap;

    public HanoiTowerProblemAgain() {
        super("HanoiTowerProblemAgain", "HanoiTowerProblemAgain", LINUX);
	}

	@Override
	public void doSomething() {
//		A: while(true){
//		if(!getInput().hasNext()){
//			break A;
//		}
		T = getInput().nextInt();
		while(T-->0){
			N = getInput().nextInt();
			tot = 0;
			peg = new int[100];
			pegMap = new ArrayList<List<Integer>>(100);
			for(int i=0;i<100;i++){
				pegMap.add(i, new ArrayList<Integer>());
			}
			simul(1,0);
			System.out.println(tot);
			for(int i=0;i<N;i++){
				System.out.println(pegMap.get(i));
			}
		}
//	}
	}

	void simul(int v, int p){
		if(p == N) return;

		if(peg[p] == 0){
			System.out.println("[peg - empty] - [v - ball number] "+v+" [peg index] "+p);
			peg[p] = v;
			List<Integer> temp;
			(temp = pegMap.get(p)).add(v);
			pegMap.set(p, temp);
			tot++;
			simul(v+1, p);
			return;
		}

		System.out.println("[range of iterate] 0 to "+p);
		for(int i=0;i<=p;i++){
			System.out.println("[peg - fill] - [v - ball number] "+v+" [peg index] "+p+ " [current peg index] "+i);
			int root = (int) Math.sqrt(peg[i]+v);
			System.out.println("[temporary total] "+(peg[i]+v)+" [root integer] "+root);
			System.out.println("is allow to continue : "+((root * root) == (peg[i]+v)));
			if((root * root) == (peg[i]+v)){
				peg[i] = v;
				List<Integer> temp;
				(temp = pegMap.get(i)).add(v);
				pegMap.set(i, temp);
				tot++;
				simul(v+1, p);
				return;
			}
		}

		System.out.println("[move peg from "+p+" to "+(p+1)+"]");
		simul(v, p+1);
	}
}
