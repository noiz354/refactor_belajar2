package norman.uva;

import norman.template.Template;

import java.util.Arrays;

/**
 * source :
 * https://github.com/sfmunera/uva/blob/master/UVa00437_TheTowerofBabylon.java
 * http://uva.onlinejudge.org/external/4/437.html
 * http://tafhim.blogspot.com/2012/06/uva-437-tower-of-babylon.html
 * https://13codes.wordpress.com/2013/02/03/uva-437-the-tower-of-babylon/
 * @author M Normansyah (m.normansyah@samsung.com)
 *
 */
public class TowerOfBabylon extends Template {

	public TowerOfBabylon() {
		super("TowerOfBabylon", "TowerOfBabylon", LINUX);
	}

	@Override
	public void doSomething() {
		int kase = 1;
		A: while(true){
			int input_length = getInput().nextInt();
			if(input_length==0)
				break A;
			/*lst = new ArrayList<blk>();
			lis = new int[1000];

			for(int i=0;i<input_length;i++){
				int x = getInput().nextInt();
				int y = getInput().nextInt();
				int z = getInput().nextInt();

				lst.add(new blk(x, y, z));
				lst.add(new blk(x, z, y));
				lst.add(new blk(y, x, z));
				lst.add(new blk(y, z, x));
				lst.add(new blk(z, x, y));
				lst.add(new blk(z, y, x));
			}

			Collections.sort(lst);
			int res = LIS(lst.size());
			System.out.println("Case "+kase++ +": maximum height = "+res);
			*/
			blk[] blocks = new blk[input_length * 6];
			int k = 0;
			for (int i = 0; i < input_length; ++i) {
				int x = getInput().nextInt();
				int y = getInput().nextInt();
				int z = getInput().nextInt();
				blocks[k++] = new blk(x, y, z);
				blocks[k++] = new blk(x, z, y);
				blocks[k++] = new blk(y, x, z);
				blocks[k++] = new blk(y, z, x);
				blocks[k++] = new blk(z, x, y);
				blocks[k++] = new blk(z, y, x);
			}

			Arrays.sort(blocks);

			int[] dp = new int[input_length * 6];
			int ans = 0;
			for (int i = 0; i < input_length * 6; ++i) {
				int max = 0;
				for (int j = 0; j < i; ++j)
					if (blocks[i].x > blocks[j].x && blocks[i].y > blocks[j].y)
						max = Math.max(max, dp[j]);
				dp[i] = max + blocks[i].z;
				ans = Math.max(ans, dp[i]);
			}

			System.out.println("Case " + kase++ + ": maximum height = " + ans);
		}
	}

	/*int LIS(int n){
	int max_lis = -1, i, j,k;
	for (i=0 ; i<n ; i++) {
	  lis[i] = lst.get(i).z;
	  for (j=0 ; j<i ; j++) {
	   if (( (lst.get(i).x > lst.get(j).x
			   && lst.get(i).y > lst.get(j).y)
			   ||
		   (lst.get(i).x > lst.get(j).y
				   && lst.get(i).y > lst.get(j).x) ) ) {
	    lis[i] = Math.max ( lis[i] , lis[j]+lst.get(j).z );
	   }
	  }
	  max_lis = Math.max( lis[i] , max_lis );
	 }
	 return max_lis;
}

List<blk> lst;
int lis[];*/
static class blk implements Comparable<blk>{
	int x,y,z;

	public blk(int x, int y, int z) {
		super();
		this.x = x;
		this.y = y;
		this.z = z;
	}

	@Override
	public int compareTo(blk o) {
		if(x != o.x)
			return x-o.x;
		else if(y != o.y)
			return y-o.y;
		else
			return z-o.z;
	}

}

}
