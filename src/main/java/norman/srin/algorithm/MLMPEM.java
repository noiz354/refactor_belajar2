package norman.srin.algorithm;

import norman.template.Template;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MLMPEM extends Template {

	int[][] map;
	List<List<Integer>> adjLists;
	int[] memo;

	public MLMPEM() {
		super("MLMPEM", "MLMPEM", LINUX);
	}

	@Override
	public void doSomething() {
		int TC = getInput().nextInt();
		int total = TC;
		while(TC-->0){
			System.out.print("Case #"+(total-TC)+" : ");
			int N = getInput().nextInt();
			map = new int[N][N];
			memo = new int[N];
			Arrays.fill(memo, -1);
			adjLists = new ArrayList<List<Integer>>(N);
			for(int i=0;i<N;i++){
				adjLists.add(new ArrayList<Integer>());
			}
			for(int i=0;i<N;i++){
				String temp  = getInput().next();
				List<Integer> temps = adjLists.get(i);
				for(int j=0;j<temp.length();j++){
					map[i][j] = Integer.parseInt(temp.charAt(j)+"");
					if(map[i][j] == 1){
						temps.add(j);
					}
				}
				adjLists.set(i, temps);
			}
//			System.out.println();
//			for(List<Integer> t : adjLists){
//				System.out.println(t);
//			}
			int ans = 0;
			for(int i=0;i<adjLists.size();i++){
				ans += calc(i);
			}
			System.out.println("$"+ans);
		}
	}

	int calc(int index){
//		System.out.println("index "+index);
		if(memo[index]!=-1){
			return memo[index];
		}
		if(adjLists.get(index).size()==0){
			return memo[index] = 1;
		}
		int res = 0;
		for(int i=0;i<adjLists.get(index).size();i++){
//			System.out.println("goto : "+adjLists.get(index).get(i));
			res += calc(adjLists.get(index).get(i));
//			System.out.println("finish : "+adjLists.get(index).get(i));
		}
//		System.out.println("index "+index+" ans "+res);
		return memo[index] = res;
	}
}
