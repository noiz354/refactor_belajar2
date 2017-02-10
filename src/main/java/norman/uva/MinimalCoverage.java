package norman.uva;

import norman.template.Template;

import java.util.ArrayList;
import java.util.List;

public class MinimalCoverage extends Template {

	public MinimalCoverage(String inputFileName, String outputFileName,
			int envType) {
		super("MinimalCoverage", "MinimalCoverage", envType);
	}

	@Override
	public void doSomething() {
		A: while(true){
			int testCase = getInput().nextInt();
			System.out.println("testCase "+testCase);
			while(testCase-- > 0){
				int M = getInput().nextInt();
				System.out.println("M "+M);
				int l_temp = 0, r_temp = 0;
				List<Coordinate> coordinate = new ArrayList<Coordinate>();
				int g = 0;
				C : while(true){
					l_temp = getInput().nextInt();
					r_temp = getInput().nextInt();
					System.out.println("l_temp "+l_temp+" & r_temp "+r_temp+" g "+ g++);
					if(l_temp == 0 && r_temp == 0){
						break C;
					}
					coordinate.add(new Coordinate(l_temp, r_temp));
				}

				doMinimalCoverage(coordinate, M);
			}// end of testCase-- > 0
			if(testCase <= 0){
				break A;
			}
		}
	}

	private void doMinimalCoverage(List<Coordinate> data, int length){
		int curL = 0, rReach = 0;
		int i = 0;
		int count = 0;
		List<Coordinate> result = new ArrayList<>();
		while(rReach < length){
			int newCurl = curL;
			int terjauh = 0;
			for(;i < data.size();i++){
				if(data.get(i).l > curL){
					break;
				}
				if(data.get(i).r>=newCurl){
					newCurl = (int) data.get(i).r;
					terjauh = i;
					result.add(count, data.get(i));
					System.out.println("newCurl "+ data.get(i)+ " terjauh "+i);
				}
			}
			System.out.println(">>>");
//			if(i==data.size()){
//				System.out.println("coordinate-"+(i-2)+" : "+ data.get(i-2));
//			}else{
//				System.out.println("coordinate-"+(i-2)+" : "+ data.get(i-2));
//			}
//			System.out.println("i "+i);
			if(terjauh == 0){
				break;
			}
			++count;
			rReach = curL = newCurl;
		}
		System.out.println("count "+count);
		for (Coordinate coordinate : result) {
			System.out.println(coordinate);
		}
	}

	private class Coordinate implements Comparable<Coordinate>{
		double l, r;

		/**
		 * double constructor
		 * @param l
		 * @param r
		 */
		public Coordinate(double l, double r) {
			this.l = l;
			this.r = r;
		}

		/**
		 * int constructor
		 * @param l
		 * @param r
		 */
		public Coordinate(int l, int r){
			this.l = l;
			this.r = r;
		}

		@Override
		public int compareTo(Coordinate o) {
			return Double.valueOf(l).compareTo(Double.valueOf(o.l));
		}

		@Override
		public String toString() {
			return "Coordinate [l=" + l + ", r=" + r + "]";
		}
	}

}
