package norman.uva;

import norman.template.Template;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class GrandDinner extends Template {

	int m, n, i, j, temp, temp1;
	boolean flag;
	Seat[] s;
	Team[] t;
	List<List<Integer>> ans;

	public GrandDinner() {
		super("GrandDinner", "GrandDinner", LINUX);
	}

	@Override
	public void doSomething() {
		while(true){
			m = getInput().nextInt();
			n = getInput().nextInt();
			if(m==0&&n==0){
				break;
			}
			s = new Seat[75];
			t = new Team[75];
			ans = new ArrayList<List<Integer>>(1000);
			for(int i=0;i<1000;i++){
				ans.add(new ArrayList<Integer>());
			}
			flag = true;
			System.out.println("m "+m+" n "+n);
			for(i=0;i<m;i++){
				t[i] = new Team(getInput().nextInt(), i+1);
			}
			for(i=0;i<n;i++){
				s[i] = new Seat(getInput().nextInt(), i+1);
			}
			Arrays.sort(t, 0, m);// sort decreasing
			Arrays.sort(s, 0, n);
			for(i=0;i<m;i++){
				temp = t[i].val;
//				System.out.println("temp "+temp);
				for(j=0;j<n;j++){
					System.out.printf("j %d\n", j);
					// ini dari codingan c, tidak pengaruh apa-apa
					if(temp<=0)
						break;
//					System.out.println("skip if(!(temp==0))");
					if(s[j].val != 0){
						// TODO need checker to verify that team member is already at table or not
						List<Integer> v = ans.get(t[i].id-1);
						System.out.println("before "+v+" index "+(t[i].id-1));
						v.add(s[j].id);
						ans.set(t[i].id-1, v);
						System.out.println("after "+ans.get(t[i].id-1)+" index "+(t[i].id-1));
						temp--;
						s[j].val--;
					}
					else
						continue;
				}
//				System.out.println("after loop temp "+temp);
				if(temp!=0){
					flag = false;
					break;
				}
			}
			if(!flag){
				System.out.println("0");
			}else{
				System.out.println("1");
				for(i=0;i<m;i++){
					Collections.sort(ans.get(i));
					for(j=0;j<ans.get(i).size();j++){
						System.out.print(ans.get(i).get(j)+" ");
					}
					System.out.println();
				}
			}
		}
	}

	class Seat implements Comparable<Seat>{
		int val, id;
		public Seat(int val, int id){
			this.val = val;
			this.id = id;
		}
		@Override
		public int compareTo(Seat o) {
			return Integer.valueOf(o.val).compareTo(val);
		}
	}

	class Team implements Comparable<Team>{
		int val, id;
		public Team(int val, int id){
			this.val = val;
			this.id = id;
		}
		@Override
		public int compareTo(Team o) {
			return Integer.valueOf(o.val).compareTo(val);
		}
	}
}
