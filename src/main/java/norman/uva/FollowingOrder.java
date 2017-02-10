package norman.uva;

import norman.template.Template;
import norman.template.TemplateUtility;

import java.util.Arrays;
import java.util.LinkedList;

/**
 * 
 * @author m.normansyah
 * https://f0rth3r3c0rd.wordpress.com/2012/01/25/uva-124-following-orders/
 */
public class FollowingOrder extends Template {

    static int[] map = new int[128];
    LinkedList<Integer>[] G;
    int[] indegree;
	 char[] unmap;
	 int n;
	 StringBuilder out;
	 char[] res;

    public FollowingOrder() {
        super("FollowingOrder", "FollowingOrder", LINUX);
    }

	public  void dfs(int left) {
		if (left == 0)
			out.append(new String(res) + '\n');
		for (int i = 0; i < n; i++) {
			if (indegree[i] == 0) {
				indegree[i] = -1;
				res[n - left] = unmap[i];
				for (int j : G[i])
					indegree[j]--;
				dfs(left - 1);
				for (int j : G[i])
					indegree[j]++;
				indegree[i] = 0;
			}
		}
	}

	@Override
	public void doSomething() {
		boolean flag = false;
		while (getInput().hasNext()) {
			if (flag)
				System.out.println();
			flag = true;
			String[] symb = getInput().nextLine().split(" ");
			String[] comp = getInput().nextLine().split(" ");
			Arrays.sort(symb);
			out = new StringBuilder();
			n = symb.length;
			unmap = new char[n];
			G = new LinkedList[symb.length];
			indegree = new int[symb.length];
			for (int i = 0; i < G.length; i++)
				G[i] = new LinkedList<Integer>();
			for (int i = 0; i < symb.length; i++) {
				map[symb[i].charAt(0)] = i;
				unmap[i] = symb[i].charAt(0);
			}
			res = new char[n];
			for (int i = 0; i < comp.length; i += 2) {
				int s = map[comp[i].charAt(0)];
				int t = map[comp[i + 1].charAt(0)];
				indegree[t]++;
				G[s].add(t);
			}
			dfs(n);
			System.out.print(out);
		}
	}

	private void print(Object o){
        TemplateUtility.print(getOutput(), o.toString(), false, true);
    }

	private void println(Object o){
        TemplateUtility.print(getOutput(), o.toString(), true, true);
    }

}
