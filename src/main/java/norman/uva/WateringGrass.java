package norman.uva;

import java.util.Arrays;

import norman.template.template;

/**
 *
 * @author Normansyah Putra
 * started at 22-2-2015
 * finished converted at 24-2-2015
 */
public class WateringGrass extends template {

	public WateringGrass() {
		super("WateringGrass", "WateringGrass", LINUX);
	}

	@Override
	public void doSomething() {
		// start of testing Sprinkler
				/*Random ran = new Random();
				Sprinkler sprinklers[] = new Sprinkler[20];
				for(int i=0;i<sprinklers.length;i++){
					int randomInt = 4 + ran.nextInt(100);
					sprinklers[i] = new Sprinkler(ran.nextDouble()*randomInt, ran.nextDouble()*randomInt);
				}
//				System.out.println(Arrays.toString(sprinklers));
				Arrays.sort(sprinklers);
//				for(Sprinkler temp : sprinklers){
//					System.out.println(temp.l + " & "+ temp.r);
//				}
				* */
				// end of testing Sprinkler

				while(true){
					int n,// jumlah sprinklers
						l,// panjang papan
						w;// lebar papan
					n = getInput().nextInt();
					l = getInput().nextInt();
					w = getInput().nextInt();
					Sprinkler sprinklers[] = new Sprinkler[n+1];
					sprinklers[0] = new Sprinkler(
							-9,
							-9);
					for(int i=1;i<=n;i++){
						double pos, radius;
						pos = getInput().nextInt();
						radius = getInput().nextInt();
						// menghitung efektif lingkaran
						// soal ini sama dengan minimal coverage 10020
						double range = Math.sqrt((radius*radius) - ((w/2.0)*(w/2.0)));
//						System.out.println(range);
						sprinklers[i] = new Sprinkler(
								pos - range,
								pos + range);
					}

					// Sort lingakarang dengan peningkatan left endpoint
					Arrays.sort(sprinklers);
//					for(Sprinkler temp : sprinklers){
//						System.out.println(temp.l + " & "+ temp.r);
//					}

					double curL =0, rReach = 0;
					int i = 1;
					int nSprinklers = 0;
					while(rReach < l){
						double newCurl = curL;
						int farthest = 0;
						System.out.println("before newCurl "+ newCurl+" farthest "+farthest);
						// Take the interval that covers as far right as possible
						for(;i<sprinklers.length;++i){
							System.out.print("i "+i
									+" sprinklers[i].l "+ sprinklers[i].l
									+" sprinklers[i].r "+sprinklers[i].r
									+" curL "+curL
									+" newCurl "+newCurl
									);
							System.out.print(" sprinklers[i].l > curL "+ (sprinklers[i].l > curL));
							if(sprinklers[i].l > curL){
								System.out.println();
								break;
							}
							System.out.println(" sprinklers[i].r >= newCurl "+ (sprinklers[i].r >= newCurl));
							if(sprinklers[i].r >= newCurl)
							{
								newCurl = sprinklers[i].r;
								farthest = i;
							}
						}
						System.out.println("after newCurl "+ newCurl+" farthest "+farthest);
						if(farthest ==0){
							break;
						}
						++nSprinklers;
						rReach = curL = newCurl;
					}
					if(rReach < l){
						System.out.println("-1");
					}else{
						System.out.println("hasil "+nSprinklers);
					}

					if(!getInput().hasNext()){
						break;
					}
				}
	}

	private class Sprinkler implements Comparable<Sprinkler>{
		double l, r;

		/**
		 * @param l
		 * @param r
		 */
		public Sprinkler(double l, double r) {
			this.l = l;
			this.r = r;
		}
		@Override
		public int compareTo(Sprinkler o) {
			return Double.valueOf(l).compareTo(Double.valueOf(o.l));
		}
		@Override
		public String toString() {
			return "Sprinkler [l=" + l + ", r=" + r + "]";
		}
	}

}
