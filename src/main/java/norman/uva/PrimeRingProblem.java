package norman.uva;

import norman.template.Template;

import java.util.*;

/**
 *
 * @author M Normansyah (m.normansyah@samsung.com)
 * finished ata 12-9-2014, masih ada bug lagi kalau 10 langsung jadi 0 perlu cari tahu kenapa ??
 * finised bug fix 14-09-2014, Minggu.
 */
public class PrimeRingProblem extends Template {

    int[] result;
    int count = 1;
    private int num;
    private List<Pair<int[], int[]>> filter;

    public PrimeRingProblem() {
        super("PrimeRingProblem", "PrimeRingProblem", LINUX);
	}

	@Override
	public void doSomething() {
		//+ demo code
				// contoh kalau prime number
				/*
				result = new int[7];
				result[1] = 1;
				result[2] = 4;
				System.out.println(isPrime(2));
				// contoh kalau tidak prime number
				result[1] = 1;
				result[2] = 5;
				System.out.println(isPrime(2));
				System.out.println(isPrime(1));// jika diawal mula, indeks 1
				result[1] = 1;
				result[2] = 2;
				System.out.println(isAlreadyInArray(2));
				// demo filter
				filter = new ArrayList<>();
				int[][] compareTest = new int[][]{
						{1, 2, 3, 8, 5, 6, 7, 4},// ini #1
						{1, 2, 3, 4, 7, 6, 5, 8},
						{1, 2, 5, 6, 7, 4, 3, 8},
						{1, 2, 5, 8, 3, 4, 7, 6},// ini #2
						{1, 4, 7, 6, 5, 8, 3, 2},// ini #1
						{1, 4, 7, 6, 5, 2, 3, 8},
						{1, 6, 7, 4, 3, 2, 5, 8},
						{1, 6, 7, 4, 3, 8, 5, 2}// ini #2
						};
				for (int i = 0; i < compareTest.length; i++) {
					filter(compareTest[i]);
				}
				System.out.println("before filter size : "+ filter.size());
				for (Iterator iterator = filter.iterator(); iterator.hasNext();) {
					Pair<int[], int[]> pair = (Pair<int[], int[]>) iterator.next();
					if(pair.getSecond() == null){
						iterator.remove();
					}
				}
				System.out.println("filter size : "+ filter.size());
				int value[] = {0, 1, 10, 9, 8, 5, 6, 7, 4, 3, 2};
				System.out.println(arrToInt2(value));
				System.out.println(Arrays.toString(calculateDigit(convIntArrayToLongArray(value))));
				// Key : 12349856710 Value : [1, 1, 1, 1, 1, 1, 1, 1, 1, 2]
				long value= 12349856710l;
				int[] digit = {1, 1, 1, 1, 1, 1, 1, 1, 1, 2};
				// 0, digit[0]
				// digit[0], digit[0]+digit[1]
				// digit[0]+digit[1], digit[0]+digit[1]+digit[2]
				// digit[0]+digit[1]+digit[2], digit[0]+digit[1]+digit[2]+digit[3]
				System.out.println((value+"").substring(0, digit[0]));
				System.out.println(Arrays.toString(IntToArr2(value, digit)));
				*/
				//- demo code

				//+ work code

        while (true) {
            filter = new ArrayList<>();
            num = getInput().nextInt();
            //+ delete this code before submit
            if (num == 0) {
                break;
            }
            //- delete this code before submit
            result = new int[num + 1];
            result[1] = 1;// indeks 1 selalu 1
            System.out.println("Case " + count++ + ":");
            backtrack(2);
//					System.out.println("before filter size : "+ filter.size());
            removeFilter();
//					System.out.println("filter size : "+ filter.size());
            print();
            if (!getInput().hasNext()) {
                break;
            }
        }

				//- work code

	}

	/**
	 * This method is buggy
	 */
	void print(){
        Map<Long, int[]> map = new TreeMap<>(Comparator.reverseOrder());
        for (Pair<int[], int[]> aFilter : filter) {
            map.put(arrToInt2(aFilter.getFirst()), calculateDigit(convIntArrayToLongArray(aFilter.getFirst())));
            map.put(arrToInt2(aFilter.getSecond()), calculateDigit(convIntArrayToLongArray(aFilter.getSecond())));
        }

		for (Map.Entry<Long, int[]> entry : map.entrySet()) {
			// below for demo
//			System.out.println("Key : " + entry.getKey() + " Value : "
//					+ Arrays.toString(entry.getValue()));
			int[] conv = IntToArr2(entry.getKey(), entry.getValue());
            for (int aConv : conv) {
                System.out.print(aConv + " ");
            }
            System.out.println();
        }
    }

    private long[] convIntArrayToLongArray(int[] array) {
        long[] returnResult = new long[array.length - 1];
        for (int i = 0, j= 1; i < returnResult.length; i++, j++) {
			returnResult[i] = array[j];
		}
		return returnResult;
	}

    private int[] calculateDigit(long[] array) {
        int[] returnResult = new int[array.length];
        for (int i = 0; i < returnResult.length; i++) {
			returnResult[i] = getLength(array[i]);
		}
		return returnResult;
	}

    private int getLength(Long value) {
        Long temp = value;// temporary
        int len=0;// panjang
		// hitung panjang integer
		while(temp != 0){
			temp = temp / 10;
			len++;
		}
		return len;
	}

//	int arrToInt(int[] array){
//		int returnResult = 0;
//		for (int i = array.length-1, j=0; i >= 0; i--, j++) {
//			LearnRB.CommonUtility.printParams(Constant.inputNameRecBac,
//					j, array[j], i, (int)Math.pow(10, i)
//					, returnResult);
//			returnResult += array[j] * (int)Math.pow(10, i);
//			LearnRB.CommonUtility.printParams(Constant.inputNameRecBac2,
//					j, array[j], i, (int)Math.pow(10, i)
//					, returnResult);
//		}
//		return returnResult;
//	}

    private long arrToInt2(int[] array) {
        long returnResult;
        String temp = "";
        for (int i = 1; i < array.length; i++) {
			temp += array[i];
		}
		returnResult = Long.parseLong(temp);
		return returnResult;
	}

	/**
     * gak ngerti ini buat apaan ya?
     * @param value nilai
     * @return hahaha apa ini ya?
     */
    @Deprecated
    int[] IntToArr(int value) {
        String temp = Integer.valueOf(value).toString();
		int[] returnResult = new int[temp.length()];
		for (int j=0; j < returnResult.length; j++) {
			returnResult[j] = Integer.parseInt(temp.charAt(j)+"");
		}
		return returnResult;
	}

	/**
	 * need to get fix digit
     * @param value nilai
     * @param digit digit dari nilai
     * @return hasilnya
     */
    private int[] IntToArr2(long value, int[] digit) {
        // TODO Fix This Things
        String temp = Long.valueOf(value).toString();
		int[] returnResult = new int[digit.length];
		int ind = 0;
		for (int j=0; j < returnResult.length; j++) {
            int innerTemp;
            if (j == 0)
                innerTemp = Integer.parseInt(temp.substring(0, ind+digit[j])+"");
			else
				innerTemp = Integer.parseInt(temp.substring(ind, ind+digit[j])+"");
			returnResult[j] = innerTemp;
			ind = ind+digit[j];// set for next index
		}
		return returnResult;
	}


    private void removeFilter() {
        for (Iterator<Pair<int[], int[]>> iterator = filter.iterator(); iterator.hasNext(); ) {
            Pair<int[], int[]> pair = iterator.next();
            if (pair.getSecond() == null) {
                iterator.remove();
			}
		}
	}

    private boolean isPrime(int i) {
        if (result[i] == 1) {
            return true;
		}
		int temp = result[i] + result[i-1];
		for (int j = 2; j < temp; j++) {
			if (temp % j == 0) {// this need fix
				return false;
			}
		}
		return true;
	}

	/**
	 * Cara ini digunakan karena cuma 16 bilangan
     * @param indexValue hahaha what this for
     * @return false jika sudah ada yang sama, true jika tidak ada yang sama.
     */
    private boolean isAlreadyInArray(int indexValue) {
        for (int i = 1; i < indexValue; i++) {
            if(result[i] == result[indexValue]){
				return false;
			}
		}
		return true;
	}

	/**
     * @param input input of something
     * @return false jika ditambahkan sebagai pasangannya dan true jika membuat baru.
     */
    private boolean filter(int[] input) {
        boolean isAlreadyAdd = false;
        int index =0;
		// menggunakan linear searh
        for (int i = 0; i < filter.size(); i++) {// 0-jumlah data
            int[] temp = filter.get(i).getFirst();

            for (int j = 2, k = temp.length - 1; j < temp.length; j++, k--) {
//				System.out.println(""+input[k] + " != "+ temp[j] + " "+ (input[k] != temp[j]));
                if (input[k] != temp[j]) {
                    isAlreadyAdd = false;
                    break;
                }
                isAlreadyAdd = true;
            }

            if (isAlreadyAdd) {// jika sama
                index = i;
                break;
            }
        }
		if(!isAlreadyAdd){
            Pair<int[], int[]> temp = new Pair<>(input, null);
            filter.add(temp);
            return true;
		}else{
			filter.get(index).setSecond(input);
			return false;
		}
	}

	/**
	 * This is buggy to save data
     * @param i wow what this for
     */
    private void backtrack(int i) {
//		if(i == result.length){
//			result[i-1] = 0;// this will zeroed last index
//			return;
//		}
		for (int j = 2; j <= num; j++) {
			result[i] = j;// save if prime
			//+ this for demo
			/*
			System.out.print(Arrays.toString(result));
			System.out.println();
			System.out.println(isAlreadyInArray(i));
			System.out.print(" prime : "+ isPrime(i) + " \n");
			*/
			//- this for demo
			if(isPrime(i) && isAlreadyInArray(i)){
				if(i == result.length-1){
					/*
					System.out.println("filter size : "+ filter.size());
					for (int j2 = 0; j2 < filter.size(); j2++) {
						System.out.println(
								Arrays.toString(filter.get(j2).getFirst())
								+ " & "+
								Arrays.toString(filter.get(j2).getSecond())
								);
					}
					System.out.println(filter(tempresult) ? "create new one" : "set second");
					*/
					int[] tempresult = new int[result.length];
                    System.arraycopy(result, 0, tempresult, 0, result.length);
                    filter(tempresult);
//					System.out.print(Arrays.toString(result));// "masuk sini : "+
//					System.out.println();
					result[i] = 0;
				}else{
					backtrack(i+1);
				}
			}else{
				result[i] = 0;
			}
		}
	}

	class Pair<A, B> {
	    private A first;
	    private B second;

	    public Pair(A first, B second) {
	    	super();
	    	this.first = first;
	    	this.second = second;
	    }

	    public int hashCode() {
	    	int hashFirst = first != null ? first.hashCode() : 0;
	    	int hashSecond = second != null ? second.hashCode() : 0;

	    	return (hashFirst + hashSecond) * hashSecond + hashFirst;
	    }

	    public boolean equals(Object other) {
	    	if (other instanceof Pair) {
	    		Pair otherPair = (Pair) other;
	    		return
	    		((  this.first == otherPair.first ||
	    			( this.first != null && otherPair.first != null &&
	    			  this.first.equals(otherPair.first))) &&
	    		 (	this.second == otherPair.second ||
	    			( this.second != null && otherPair.second != null &&
	    			  this.second.equals(otherPair.second))) );
	    	}

	    	return false;
	    }

	    public String toString()
	    {
	           return "(" + first + ", " + second + ")";
	    }

	    public A getFirst() {
	    	return first;
	    }

	    public void setFirst(A first) {
	    	this.first = first;
	    }

	    public B getSecond() {
	    	return second;
	    }

	    public void setSecond(B second) {
	    	this.second = second;
	    }
	}
}
