package norman.uva;

import norman.template.template;

/**
 *
 * @author M Normansyah (m.normansyah@samsung.com)
 * 927 - Integer Sequences from Addition of Terms
 * Time limit: 3.000 seconds
 * "Soalnya susah dimengerti !!"
 * jawaban dari internet :
 * http://saicheems.wordpress.com/2013/07/16/uva-927-integer-sequences-from-addition-of-terms/
 */
public class IntegerSequence extends template {

	public IntegerSequence() {
		super("integersequence","integersequence", LINUX);
	}

	@Override
	public void doSomething() {
		int c = getInput().nextInt();
		for (int i = 0; i < c; i++) {
			int coefs[] = new int[30];
			long an, d, k;//nilai itu sendiri, integer numbers, k-th integer (indeksnya)

			int coefsL = getInput().nextInt();// get coeficient length
			coefsL++;
			for (int j = 0; j < coefsL; j++) {
				coefs[j] = getInput().nextInt();
			}
			d = getInput().nextLong();
			k = getInput().nextLong();
			long dd = 0;
			for(int m=1;;m++){
				dd += d * m;
				an = 0;
				for(int l = 0; l < coefsL; l++){
					an += coefs[l] * Math.pow(m, l);
				}

				if(dd >= m){
					System.out.println(an);
					break;
				}
			}
		}
	}

}
