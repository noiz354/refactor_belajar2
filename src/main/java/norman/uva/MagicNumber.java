package norman.uva;

import java.math.BigInteger;

import norman.template.template;

/**
 * Solution Manual : http://f0rth3r3c0rd.wordpress.com/2011/09/12/uva-471-magic-numbers/
 * @author M Normansyah (m.normansyah@samsung.com)
 * created at 20-8-2014, sometimes good is not enough, you need to sacrifice to value things.
 *
 * TODO perlu untuk mencari tahu kenapa max/N; tanya kenapa ?
 */
public class MagicNumber extends template {
	BigInteger N = BigInteger.valueOf(9876543210l);

	public MagicNumber() {
		super("MagicNumber", "MagicNumber", LINUX);
	}

	@Override
	public void doSomething() {
		//+ demo code
				/*
				System.out.println("N.intValue() : "+ N.intValue() + " N : "+ N);
				System.out.println(cek_beda(N, 10));
				BigInteger min = BigInteger.valueOf(1l);
				BigInteger max = BigInteger.valueOf(2l);
				  for (BigInteger bi = BigInteger.valueOf(5);
				            bi.compareTo(BigInteger.ZERO) > 0;
				            bi = bi.subtract(BigInteger.ONE)) {

				        System.out.println(bi);
				    }
				for (BigInteger i = min; i.compareTo(max) < 0 || i.compareTo(max) == 0; i = i.add(BigInteger.ONE)) {// || i.compareTo(max) == 0
					System.out.println(i+" # "+i);
				}
				System.out.println(cek_beda(BigInteger.valueOf(10l), getLength(BigInteger.valueOf(10l))));
				System.out.println(1665+"");
				System.out.println(cek_beda(BigInteger.valueOf(1665), getLength(BigInteger.valueOf(1665))));
				System.out.println(14253+"");
				System.out.println(cek_beda(BigInteger.valueOf(14253), getLength(BigInteger.valueOf(14253))));// getLength(BigInteger.valueOf(1665l)
				 */
				//- demo code

				//+ work code

				int nilai = getInput().nextInt();
				while(nilai-- > 0){
					BigInteger searchValue = getInput().nextBigInteger();
					BigInteger max = N.divide(searchValue);//BigInteger.valueOf(20l);
					BigInteger min = BigInteger.valueOf(1l);
					System.out.println("max : "+max+ " min : "+ min + " searchValue : "+ searchValue);
					// maximal 10 digit karena 10 digit itu mencerminkan perbedaan nilai
					int count = 0;
					for (BigInteger i = min; i.compareTo(max) < 0 || i.compareTo(max) == 0; i = i.add(BigInteger.ONE)) {
//					BigInteger i = BigInteger.valueOf(549);
						BigInteger iTemp,iTemp2;
//						System.out.println("#"+i);
//						System.out.println(cek_beda(iTemp = (i), getLength(iTemp)));
//						System.out.println("i : "+ i + " : " + cek_beda(iTemp = (i), getLength(i)));
//						iTemp2 = searchValue.multiply(iTemp);
//						System.out.println("iTemp2 : "+ iTemp2 + " : "+ cek_beda(iTemp2, getLength(iTemp2)));
//						System.out.println();
						boolean iStatus = cek_beda((i), getLength(i));
						if(!iStatus)
							continue;
						iTemp = searchValue.multiply(i);
						boolean largerThanMax = iTemp.compareTo(N) < 0 || iTemp.compareTo(N) == 0;
						if(!largerThanMax){
							break;
						}
						boolean iTempStatus = cek_beda(iTemp, getLength(iTemp));
//						System.out.println(iTempStatus);
						if (iTempStatus)// && iStatus largerThanMax &&
						{
							System.out.println("["+count+"] "+iTemp + " / "
									+ i + " = " + searchValue);
							count++;
//							if(count > 134){
//								break;
//							}
						}
//						System.out.println();
					}// end of for
				}

				//- work code

	}

	/**
	 * @param a
	 * @param digit -1 for ignoring digit number
	 * @return true kalau beda, false jika sama
	 */
	boolean cek_beda(BigInteger a, int digit){

		if(getLength(a) == 1){
			return true;
		}
		if(digit == -1){
			return true;
		}
		if(getLength(a)>10){
			return false;
		}

		int simpan[] = new int[10];
		for (int i = digit-1; i >= 0; i--) {
			simpan[a.mod(BigInteger.valueOf(10)).intValue()]++;
			a = a.divide(BigInteger.valueOf(10));
		}
//		System.out.println(Arrays.toString(simpan));
		for (int i = 10-1; i >= 0; i--) {
			if(simpan[i] > 1)
				return false;
		}
		return true;
	}

	int getLength(BigInteger value){
		BigInteger temp=value;// temporary
		int len=0;// panjang
		// hitung panjang integer
		while(!temp.equals(BigInteger.valueOf(0l))){
			temp = temp.divide(BigInteger.valueOf(10));
			len++;
		}
		return len;
	}

}
