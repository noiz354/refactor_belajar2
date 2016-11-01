package norman.srin.algorithm;

import java.util.Arrays;

import norman.template.template;

public class BugHunters extends template {

	public BugHunters() {
		super("BugHunters", "BugHunters", LINUX);
	}

	@Override
	public void doSomething() {
		int TC = getInput().nextInt();
		int total = TC;
		while(TC-- > 0){
			int N = getInput().nextInt();
			coors = new Coor[N+1];
			str = 1000;
			fin = 0;
			coors[0] = new Coor(-1, -1);
			for(int i=1;i<=N;i++){
				int x = getInput().nextInt();
				str = Math.min(x, str);
				int y = getInput().nextInt();
				fin = Math.max(y, fin);
				coors[i] = new Coor(x,y);
			}
//			System.out.println("str "+str+" fin "+fin);
			l = fin-str;
			Arrays.sort(coors);
			System.out.println("Input ");
			for(Coor c : coors){
				System.out.println(c);
			}

			System.out.println("start processing ");
			int nCount=0, max = 0;
			for(int i=0;i<coors.length-1;i++){
				nCount = 0;
				System.out.println("\nstart iterate-"+i);
				for(int j=i+1;j<coors.length-1;j++){
					if(coors[j].x >= coors[i].x && coors[j].x <= coors[i].y){
						// do nothing
						System.out.println("cur "+coors[j]+" prev "+coors[i]);
					}else{
						System.out.println("cur "+coors[j]+" prev "+coors[i]+" increment ");
						nCount++;
					}
				}
				max = Math.max(nCount, max);
			}

			System.out.println("Case # "+(total-TC)+" : "+max);

		}// end of test case
	}

	Coor[] coors;
	int str, fin, l;
	static class Coor implements Comparable<Coor>{
		int x, y, length;
		public Coor(int x, int y){
			this.x = x;
			this.y = y;
			length = y -x;
		}
		@Override
		public int compareTo(Coor o) {
//			int i =0;
//			i = Integer.valueOf(length).compareTo(o.length);
//			if(i!=0)
//				return i;
//			i = Integer.valueOf(y).compareTo(o.y);
//			if(i!=0)
//				return i;
			return Integer.valueOf(o.x).compareTo(x);
		}
		@Override
		public String toString() {
			return "Coor [x=" + x + ", y=" + y + "]";
		}
	}
}
