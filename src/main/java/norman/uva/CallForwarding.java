package norman.uva;

import java.util.ArrayList;
import java.util.List;

import norman.template.template;
import norman.template.template_utility;

public class CallForwarding extends template {

	public CallForwarding() {
		super("CallForwarding", "CallForwarding", LINUX	);
	}

	@Override
	public void doSomething() {
		template_utility.print(getOutput(), "CALL FORWARDING OUTPUT", true);
		N = getInput().nextInt();
		A: for(int n = 1;n <= N; n++){
			intervals = new ArrayList[10000];
			B: for(;;){
				int ti, du, ta;
				source = getInput().nextInt();
				if(source ==0)
					break B;
				List<Integer> temp = new ArrayList<>();
				ti = getInput().nextInt();
				du = getInput().nextInt();
				ta = getInput().nextInt();
//				System.out.println("target "+source +" "+ti +" "+du+" "+ta);
//				Utility.print(getOutput(), "target "+source +" "+ti +" "+du+" "+ta, true);
				temp.add(source);
				temp.add(ti);
				temp.add(du);
				temp.add(ta);

				if(intervals[source]==null){
					intervals[source] = new ArrayList<>();
//					System.out.println("index "+ source);
//					Utility.print(getOutput(), "index "+ source, true);
				}

				intervals[source].add(temp);
			}
			template_utility.print(getOutput(), "SYSTEM "+n, true);
			C: while(true){
				if(!getInput().hasNext()){
					break A;
				}
				dtime = getInput().nextInt();
				if(dtime == 9000){
					break C;
				}
				dext = getInput().nextInt();
				template_utility.printf(getOutput(), "AT %04d CALL TO RINGS %04d RINGS %04d", new Object[]{dtime, dext, transverse(0, dext, dtime, dext)}, true);
			}
		}
	}

	private int transverse(int n, int o, int t, int e){
//		System.out.println("n "+n+" o "+o+" t "+t+" e "+e);
//		Utility.print(getOutput(), "n "+n+" o "+o+" t "+t+" e "+e, true);
		if(n > 0 && o == e)
			return 9999;
		if(intervals[e] != null){
			for(int i=0;i<intervals[e].size();i++){
				int start = intervals[e].get(i).get(1);
				int end = intervals[e].get(i).get(2)+start;
				if(t >= start && t <= end){
					return transverse(n+1, o, t, intervals[e].get(i).get(3));
				}
			}
		}
		return e;
	}

	int N, source, dtime, dext;
	List<List<Integer>>[] intervals;


}
