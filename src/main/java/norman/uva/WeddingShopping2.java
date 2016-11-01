package norman.uva;

import norman.template.template;

/**
 * @author M Normansyah (m.normansyah@samsung.com)
 * Bottom-up Dynamic Programming, still learning about this
 */
public class WeddingShopping2 extends template {

	public WeddingShopping2() {
		super("WeddingShopping", "WeddingShopping", LINUX);
	}

	@Override
	public void doSomething() {
		TC = getInput().nextInt();
		while(TC-- > 0){
			M = getInput().nextInt();
			C = getInput().nextInt();
			price = new int[25][25];// ready to fill
			for(g =0;g<C;g++){
				price[g][0] = getInput().nextInt();
				for(money = 1; money <= price[g][0]; money++){
					price[g][money] = getInput().nextInt();
				}
			}

			reachable = new boolean[25][210];// clear everything
			for(g =1;g<=price[0][0];g++){// initial values ( base cases )
				if(M-price[0][g] >= 0){// to prevent array index out of bond
					reachable[0][M-price[0][g]] = true;// using first garment g = 0
				}
			}

			for(g =1;g <C; g++){// for each remaining garment
				for(money=0;money<M;money++){
					if(reachable[g-1][money]){
						for(k=1;k<=price[g][0];k++){
							if(money-price[g][k] >= 0){// also reachable now
								reachable[g][money-price[g][k]] = true; // also reachable now
							}
						}
					}
				}
			}

			for(money=0;money <= M && !reachable[C-1][money];money++);

			if(money == M+1){
				System.out.println("no solution");// last row has no on bit
			}else{
				System.out.println((M-money));
			}
		}// end of while
	}

	int g, money, k, TC, M, C;
	int price[][];
	boolean reachable[][];
}
