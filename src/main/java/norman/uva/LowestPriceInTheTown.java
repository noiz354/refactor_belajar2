package norman.uva;

import norman.template.Template;

import java.util.Arrays;

/**
 * started at 5/4/2015, using common backtrack, non-recursive backtrack unable to solve problem
 * converted from https://algorithmcafe.wordpress.com/2013/07/08/10980-lowest-price-in-town/
 * @author M Normansyah (m.normansyah@samsung.com)
 *
 */
public class LowestPriceInTheTown extends Template {

	int[] a;
	double[][] dp;

	/* non-recursive wrong answer
	double[] prices;// use index 1-100
    List<Price> results;
    int[] itemNumbers;
    int count, testCase_count;
    static class Price implements Comparable<Price>{
        int itemNumber;
        double price;
        public Price(int i, double j){
            itemNumber = i;
            price = j;
        }
        @Override
        public int compareTo(Price o) {
            return (int)(price-o.price);
        }
        @Override
        public String toString() {
            return "Price [itemNumber=" + itemNumber + ", price=" + price + "]";
        }
    }*/
	double[] b;
	private int MAX = 1_000_000_000;

	public LowestPriceInTheTown() {
		super("LowestPriceInTheTown", "LowestPriceInTheTown", LINUX);
	}

	@Override
	public void doSomething() {
		// converted from web
				int tCases = 1;
				 while(true){
						if(!getInput().hasNext()){
							break ;
						}
						double x = getInput().nextDouble();
						int m = getInput().nextInt();
						a = new int[m+1];
						b = new double[m+1];
						a[0] = 1;
						b[0] = x;
						for(int i=1;i<a.length;i++){
							a[i] = getInput().nextInt();
							b[i] = getInput().nextDouble();
							System.out.println(a[i]+" "+b[i]);
						}
						dp = new double[a.length][101];
						for(int i=0;i<dp.length;i++)
							Arrays.fill(dp[i], -1);
						System.out.printf("Case %d:\n", tCases++);
						B: while(true){
							if(getInput().hasNextDouble() && !getInput().hasNextInt()){
								break B;
							}
							if(!getInput().hasNext()){
								break B;
							}
							int items = getInput().nextInt();
							double min = go(0, items);
							System.out.printf("Buy %d for %.2f\n", items, min);
						}
				 }

				/* -- non recursive wrong answer
				A : while(true){
					testCase_count++;
					if(!getInput().hasNext()){
						break A;
					}
					prices = new double[101];
					itemNumbers = new int[101];
					results = new ArrayList<>();
					for(int i=0;i<prices.length;i++) prices[i] = -1;
					for(int i=0;i<itemNumbers.length;i++) itemNumbers[i] = -1;
					prices[1] = getInput().nextDouble();
					int datasNumber = getInput().nextInt();
					for(int i=0;i<datasNumber;i++){
						int index = getInput().nextInt();
						double price = getInput().nextDouble();
						prices[index] = price;
						System.out.println("index "+index+" value ["+prices[index]+"]");
					}

					count = 0;
					B: while(true){
						if(getInput().hasNextDouble() && !getInput().hasNextInt()){
							break B;
						}
						if(!getInput().hasNext()){
							break B;
						}
						int data = getInput().nextInt();
						itemNumbers[count] = data;
						System.out.println("count "+count+" value["+itemNumbers[count]+"] ");
						count++;
					}
					System.out.println(count);

					// result
					System.out.println("Case "+testCase_count+":");
					for(int i=0;i<count;i++){
						int itemNumber = itemNumbers[i];
						for(int j=1;j<prices.length;j++){
							if(prices[j]!=-1){
								boolean isEven = (itemNumber%j>0)?false:true;
								double price_temp = -1;
								if(itemNumber/j==0 &&itemNumber%j==itemNumber ){
									price_temp = ((itemNumber+1)/j)*prices[j];
								}else if(itemNumber/j>0 &&itemNumber%j>0 ){
									price_temp = ((itemNumber)/j)*prices[j] + prices[j];
								}else if(itemNumber/j>0 &&itemNumber%j==0 ){
									price_temp = ((itemNumber)/j)*prices[j];
								}
								System.out.println("Buy "+itemNumber+" index ke-"+j+" price temp : "+ price_temp+ " isEven "+isEven);
								if(price_temp>0)
									results.add(new Price(j, price_temp));

							}
						}
						Collections.sort(results);
//						for(Price p : results){
//							System.out.println(p);
//						}
						System.out.println(results.remove(0));
					}

				}*/

	}

	 private double go(int index, int items) {
		 System.out.println("index "+index+" items "+items);
        if (items <= 0)
            return 0;
        else if (index == a.length)
            return MAX;
        else if (dp[index][items] != -1)
            return dp[index][items];
        else {
            double min = go(index, items - a[index]) + b[index];
            min = Math.min(min, go(index + 1, items));
            return dp[index][items] = min;
        }
    }

}
