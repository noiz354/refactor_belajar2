import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;


/**
 * hackerrank submit template
 * @author M. Normansyah
 * 2:56:28 PM
 */
public class Solution {


    public static void main(String[] args) throws IOException{
		int q = getInput().nextInt();
		while(q-- > 0){
			int m = getInput().nextInt();
			int n = getInput().nextInt();

			String s = getInput().nextLine();

			List<List<Integer>> v = new ArrayList<>();
			v.add(new ArrayList<>());
			v.add(new ArrayList<>());

			List<Integer> cost = new ArrayList<>();
			for(long i=0;i<m-1;i++){
//                List<Integer> integers = v.get(1);
				cost.add(getInput().nextInt());
			}
			Collections.sort(cost, (o1,o2)->(o2-o1));
			v.set(1, cost);

			cost = v.get(0);
			for(long i=0;i<n-1;i++){
				cost.add(getInput().nextInt());
			}
			Collections.sort(cost, (o1,o2)->(o2-o1));
			v.set(0, cost);


			int ym = 0, xm = 1;
			long y=0,x=0;
			long total = 0;
			while (true){
				if(v.get(ym).isEmpty() && v.get(xm).isEmpty()){
					break;
				}else if(v.get(ym).isEmpty() && !v.get(xm).isEmpty()){
//                    println(String.format("xm filled && ym empty %d * %d", v.get(ym).get(0), y+1));
					total += (v.get(xm).get(0)*(x+1));
					remove(v, xm, 0);
					y++;
				}else if(v.get(xm).isEmpty() && !v.get(ym).isEmpty()){
//                    println(String.format("xm empty && ym filled %d * %d", v.get(xm).get(0), x+1));
					total += (v.get(ym).get(0) * (y+1));
					remove(v, ym, 0);
					x++;
				}else if(v.get(ym).get(0) > v.get(xm).get(0)){
					total += (v.get(ym).get(0) * (y+1));
					remove(v, ym, 0);
					x++;
				}else if(v.get(ym).get(0) < v.get(xm).get(0)){
					total += (v.get(xm).get(0)*(x+1));
					remove(v, xm, 0);
					y++;
				}else if(v.get(ym).get(0).equals(v.get(xm).get(0))){
					total += (v.get(ym).get(0) * (y+1));
					remove(v, ym, 0);
					x++;
				}
			}

			int x1 = (int) (total % (Math.pow(10, 9) + 7));
			System.out.println(x1);
		}
    }

	/**
	 * some how not really good looking
	 * @param data
	 * @param index
	 * @param innerIndex
	 */
	static void remove(List<List<Integer>> data, int index, int innerIndex){
		List<Integer> integers = data.get(index);
		integers.remove(innerIndex);
		data.set(index, integers);
	}
    
	// setup below here
	static Scanner input = new Scanner(System.in);
	
	public static Scanner getInput() {
		return input;
	}
}