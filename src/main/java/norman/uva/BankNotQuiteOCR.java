package norman.uva;

import norman.template.Template;

import java.util.*;
import java.util.Map.Entry;

/**
 * 
 * @author m.normansyah
 * 17-10-2015, sabtu
 * uva 433
 *
 */
public class BankNotQuiteOCR extends Template {

	int[][] input;
	private List<Integer> possible;
	private int[] inputInt;
	private String line;
	private Map<Integer, Integer> codeDig;
	
	public BankNotQuiteOCR() {
		super("BankNotQuiteOCR", "BankNotQuiteOCR", WINDOWS);
	}

	//Method for sorting the TreeMap based on values
	public static <K, V extends Comparable<V>> Map<K, V>
	sortByValues(final Map<K, V> map) {
		Comparator<K> valueComparator =
				(k1, k2) -> {
					int compare =
							map.get(k1).compareTo(map.get(k2));
					if (compare == 0)
						return 1;
					else
						return compare;
				};

		Map<K, V> sortedByValues =
				new TreeMap<>(valueComparator);
		sortedByValues.putAll(map);
		return sortedByValues;
	}

	@Override
	public void doSomething() {
		int TC = getInput().nextInt();
		getInput().nextLine();


		for(int z=0;z<TC;z++){
			input = new int[9][7];

			// code digit
			codeDig = new TreeMap<>();
			codeDig.put(126, 0);
			codeDig.put(48, 1);
			codeDig.put(109, 2);
			codeDig.put(121, 3);
			codeDig.put(51, 4);
			codeDig.put(91, 5);
			codeDig.put(95, 6);
			codeDig.put(112, 7);
			codeDig.put(127, 8);
			codeDig.put(123, 9);
//			codeDig = sortByValues(codeDig);
//			System.out.println(codeDig);
//			System.out.println(codeDig.containsKey(48));

			for(int i=0;i<3;i++){
				line = getInput().nextLine();
				if(line.length()<=27){
					int j2 = 27-line.length();
					for(int j=0;j<j2;j++)
						line = line+ " ";
				}

				parseInput(i, 1, 0);
			}
//			int tot = 0;
			inputInt = new int[9];
			for(int i=0;i<9;i++){
				inputInt[i] = 0;
				for(int j=0, k=6;j<7;j++,k--){
					inputInt[i] += Math.pow(2, k)*input[i][j];
				}
//				System.out.println(">> "+codeDig.containsKey(inputInt[i]));
//				if(!codeDig.containsKey(inputInt[i])){
//					tot++;
//					for(Iterator<Entry<Integer,Integer>> k=codeDig.entrySet().iterator();k.hasNext();){
//						Entry<Integer, Integer> temp = k.next();
//						int res = (inputInt[i] ^ temp.getKey()) & inputInt[i];
//						System.out.println("temp.getKey() : "+temp.getKey()+" xor "+inputInt[i]+" = "+Integer.toBinaryString(res));
//					}
//				}
//				System.out.println(i+" "+Integer.toBinaryString(inputInt[i])+" : "+inputInt[i]+" : "+codeDig.get(inputInt[i]));
			}
//			System.out.println(tot);

			System.out.println("valid "+Valid());
			if(Valid()){
//				System.out.println("valid hehehe");
				System.out.println(CodeToInt());
			}else{
//				System.out.println("tidak valid hehehe");
				Solve();
			}


//			System.out.println(CanFixGarbled(121, 121));
//			System.out.println(CanFixGarbled(121, 127));
//			System.out.println(CanFixGarbled(121, 123));
//			System.out.println(CanFixGarbled(121, 51));
//			System.out.println(CanFixGarbled(121, 48));
//			System.out.println("1 << 0 "+(1 << 0));
//			System.out.println(121 >> 1);
//			System.out.println(121 >> 2);
//			System.out.println(121 >> 8);
//			System.out.println(121 << 1);

		}
	}

	private void SolveImpl(int i)
	{
		int orig = inputInt[i];
		for (Entry<Integer, Integer> temp : codeDig.entrySet()) {
			if (orig == temp.getKey())
				continue;

			if (!CanFixGarbled(orig, temp.getKey()))
				continue;

			inputInt[i] = temp.getKey();
			if (Valid()) {
				possible.add(CodeToInt());
				if (possible.size() > 1)
					return;
			}
		}
	}

	private int CodeToInt() {
		int ret = 0;
		int m = 1;
		for(int i=8;i>=0;i--){
			ret += codeDig.get(inputInt[i]) *m;
			m *= 10;
		}
		return ret;
	}
	
	boolean CanFixGarbledV2(int src, int dst){
		return ((src ^ dst)&src)==0;
	}

	private boolean CanFixGarbled(int src, int dst) {
		int diff = src ^ dst;// ambil perbedaannya
//		System.out.println("#1 diff "+Integer.toBinaryString(diff)
//				+ " src "+Integer.toBinaryString(src)
//				+" dst "+Integer.toBinaryString(dst));
		while(diff >0){
			boolean b = test(diff, 0) !=0;
			boolean c = test(src, 0) !=0;
//			System.out.println("b "+b+" c "+c);
			if(b && c)
				return false;

//			System.out.println("src "+Integer.toBinaryString(src)
//					+" dst "+Integer.toBinaryString(dst)
//					+" diff "+Integer.toBinaryString(diff));
			src = src >> 1;
			dst = dst >> 1;
			diff = diff >> 1;

		}
		return true;
	}

	private int test(int v, @SuppressWarnings("unused") int i) {
//		System.out.println(
//				"v "+Integer.toBinaryString(v)
//				+" i "+Integer.toBinaryString(i)
//				+" : "+Integer.toBinaryString((v & (1 << i))));
		return (v & (1 << i));
	}

	private void Solve() {
		possible = new ArrayList<>();

		for(int i=0;i<9;i++)
			SolveImpl(i);

		if(possible.isEmpty())
			System.out.println("failure");
		else if(possible.size()>1)
			System.out.println("ambigious");
		else
			System.out.println(possible.get(0));
	}

	private boolean Valid() {
		int ret = 0;
		for(int i=8;i>=0;--i){
			if(!codeDig.containsKey(inputInt[i]))
				return false;
			ret += codeDig.get(inputInt[i])*(9-i);
		}
		System.out.println("ret%11==0 "+(ret%11 == 0));
		return ret%11 == 0;
	}

	private void parseInput(int i, int iter, int start) {
		if(iter>9)
			return;
		switch (i) {
		case 0:
			String temp = line.substring(start,3*iter);
			if(temp.charAt(1) == '_')
				input[iter-1][0] = 1;
			parseInput(i, iter+1, start+3);
			break;
		case 1:
			temp = line.substring(start, 3*iter);
			if(temp.charAt(0)=='|')
				input[iter-1][5] = 1;
			if(temp.charAt(1)=='_')
				input[iter-1][6] = 1;
			if(temp.charAt(2)=='|')
				input[iter-1][1] = 1;
			parseInput(i, iter+1, start+3);
			break;
		case 2:
			temp = line.substring(start, 3*iter);
			if(temp.charAt(0)=='|')
				input[iter-1][4] = 1;
			if(temp.charAt(1)=='_')
				input[iter-1][3] = 1;
			if(temp.charAt(2)=='|')
				input[iter-1][2] = 1;
			parseInput(i, iter+1, start+3);
			break;
		}
	}

}
