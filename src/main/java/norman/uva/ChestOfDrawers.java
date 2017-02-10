package norman.uva;

import norman.template.Template;

import java.util.Arrays;

public class ChestOfDrawers extends Template {

    long arr[][][];

	public ChestOfDrawers() {
		super("ChestOfDrawers" ,"ChestOfDrawers", LINUX);
	}

	@Override
	public void doSomething() {
		int n,s;
		arr = new long[66][66][2];
		for(int i=0;i<arr.length;i++)
			for(int j=0;j<arr[i].length;j++)
				Arrays.fill(arr[i][j], -1);
		while(true){
			n = getInput().nextInt();
			s = getInput().nextInt();
			if(n<0&&s<0){
				break;
			}
			System.out.println(dp(n, s, 1));
		}
	}

	long dp(int n, int s, int x){
		System.out.println("n "+n+" s "+s+" x "+x);
		if(n == 1)
		{
			System.out.println("s "+s+" x "+x+" n==1");
			if(s == 0 && x == 1){
				return 1;
			}
			if(s == 0 && x == 0){
				return 2;
			}
			if(s == 1 && x ==1){
				return 1;
			}
			return 0;
		}
		if(n < s){
			System.out.println("n<s"+(n<s));
			return 0;
		}
		if(n == s && x == 0){
			System.out.println("n == s "+(n==s)+" x "+x);
			return 0;
		}
		if(arr[n][s < 0?(-1*s):s][x] != -1){
			System.out.println("n "+n+" s "+s+" x "+x+" : "+arr[n][s < 0?(-1*s):s][x]);
			return arr[n][s < 0?(-1*s):s][x];
		}
		if(x == 1){
			arr[n][s < 0?(-1*s):s][x] = dp(n-1,s-1,1)+dp(n-1,s,0);
		}else{
			arr[n][s < 0?(-1*s):s][x] = dp(n-1,s,1)+dp(n-1,s,0);
		}
		return arr[n][s < 0?(-1*s):s][x];
	}
}
