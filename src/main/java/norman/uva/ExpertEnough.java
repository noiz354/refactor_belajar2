package norman.uva;

import norman.template.Template;


/**
 * 1237 - Expert Enough?
 * @author M Normansyah (m.normansyah@samsung.com)
 * Accepted wkwk
 */
public class ExpertEnough extends Template {

	public ExpertEnough() {
		super("expertenough","expertenough", LINUX);
	}

	@Override
	public void doSomething() {
		String undetermined = "UNDETERMINED";
		A : while(true){
			int numberofTest = getInput().nextInt();
			for (int i = 0; i < numberofTest; i++) {
				int sizeOfDatabase = getInput().nextInt();
				String[] names = new String[sizeOfDatabase];
				int[] lowestPrices = new int[sizeOfDatabase];
				int[] highestPrices = new int[sizeOfDatabase];
				for (int j = 0; j < sizeOfDatabase; j++) {
					names[j] = getInput().next();
					lowestPrices[j] = getInput().nextInt();
					highestPrices[j] = getInput().nextInt();
//					System.out.println("j : "+ j + " names[i] : "+ names[j]
//							+ " lowestPrices[i] : "+ lowestPrices[j] + " highestPrices[i] : "+ highestPrices[j]);
				}
				int sizeOfQuery = getInput().nextInt();
				for (int j = 0; j < sizeOfQuery; j++) {
					int query = getInput().nextInt();
//					System.out.println("j : "+ j + " query : "+ query);

					int index = -1;
					for (int k = 0; k < names.length; k++) {
						if(query >= lowestPrices[k] && query <= highestPrices[k]){
							if(index < 0){
								index = k;
							}else{
								index = -1;
								break;
							}
						}
					}

					if(index <0){
						System.out.println(undetermined);
					}else{
						System.out.println(names[index]);
					}
				}
				if(!getInput().hasNext())
					break A;

				System.out.println();
			}
			break A;
		}

	}

}
