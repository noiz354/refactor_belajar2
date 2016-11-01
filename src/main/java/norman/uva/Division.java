package norman.uva;

import java.io.IOException;
import java.util.HashSet;

import norman.template.template;

public class Division extends template {

	public Division() {
		super("Division", "Division", LINUX);
	}

	@Override
	public void doSomething() {
		try{
		boolean isLoop = true;
		//+ demo code here
//		int nilai = 72;
		//- demo code here
		A : while(isLoop){
			//+ demo code here
			/*
			int[] min = convIntArray(20654);//new int[]{0,0,1,2,3,4,1};
			int[] key = convIntArray(10327);//new int[]{-1,8,7,15,18,19,20};
			int[] alwaysTrue = new int[]{-1,8,7,15,18,19};
			for (int i = 0; i < min.length; i++) {
				int[] temp;
				System.out.println("array size : "+ (temp = substractArray(min, i)).length+" : "+Arrays.toString(temp));
			}
			isDigitSame(min);
			System.out.println(isDigitSame(min, key, 5));
			System.out.println(isDigitSame(min, alwaysTrue, min.length));
			*/
			//- demo code here

			//+ enter code here

			int nilai ;
			if((nilai = getInput().nextInt()) == 0){
				break A;
			}
			int count = 0;
			int[] min = new int[]{0,1,2,3,4};
			int[] max = new int[]{9,8,7,6,5};
			int minValue = convIntArray(min);
			int maxValue = convIntArray(max);
			for(int i=minValue;i<=maxValue;i++){//i<=minValue+200;i++){

				//+ demo code here
//				String printString = "";
//				if(isDigitSame(convIntArray(i)))
//					{ printString +=i; System.out.println(i + " & " + printString);}
//				else
//					printString +="non";
//				System.out.println(i + " & " + printString);
				//- demo code here

				int multiplyValue = i* nilai;
//				int[] value = convIntArray(multiplyValue);
//				int[] denom = convIntArray(i);
				boolean isInRange = isInRange(multiplyValue, minValue, maxValue);
				boolean isMulsDigitSame = cek_beda(multiplyValue);//!isDigitSame(value);
				boolean isDenomSame = cek_beda(i);//!isDigitSame(denom);
				if(isInRange && isMulsDigitSame && isDenomSame){
					boolean isVODigitSame = cek2_beda(multiplyValue, i);//!isDigitSame(value, denom, 5);// jika yang dibagi dan pembagi tidak ada digit yang sama
					if(isVODigitSame){
						String stringDenom = "";
//						if(denom.length < 5){
						if(Integer.valueOf(i).toString().length() < 5){
							stringDenom += "0"+ i;
						}else{
							stringDenom += i;
						}
//						System.out.printf("%d / %s = %d\n", multiplyValue, stringDenom, nilai);
						count++;
						getOutput().write(String.format("%d / %s = %d\n", multiplyValue, stringDenom, nilai));
					}
				}
			}
			if(count ==0){
//				System.out.printf("%s = %d.\n", "There are no solutions for", nilai);
				getOutput().write(String.format("%s = %d.\n", "There are no solutions for", nilai));
			}

			//- enter code here

			if(!getInput().hasNext()){
				isLoop = false;
			}
			//+ demo code here

//			nilai++;
//			if(nilai >78){
//				isLoop = false;
//			}

//			System.out.println();
			getOutput().write("masuk sini\n");
			//- demo code here
		}
		}catch(IOException ioe){}
	}

	public boolean isInRange(int value, int min, int max){
		return (value >= min && value <= max);
	}

	/**
	 *
	 * @param value key yang ingin mencari
	 * @param other_value yang dicari
	 * @param digitNumber jumlah digit
	 * @return
	 */
	public boolean isDigitSame(int[] value, int[] other_value, int digitNumber){

		int[] newValue = value, newOtherValue = other_value;
		if(value.length < digitNumber){
			newValue = convIntArray(value, digitNumber);
		}
		if(other_value.length < digitNumber){
			newOtherValue = convIntArray(other_value, digitNumber);
		}
		int[] joinedArray = joinIntArray(newValue, newOtherValue);
		HashSet<Integer> hash = new HashSet<>();
		for (int i = 0; i < joinedArray.length; i++) {
			if(!hash.add(joinedArray[i])){
				return true;
			}
		}
		if(hash.size() == joinedArray.length){
			return false;
		}
		return true;
		/*
		Arrays.sort(newOtherValue);// yang dicari disort
		for (int i = 0; i < newValue.length; i++) {
			int temp = newValue[i];
//			System.out.println(i+" : "+temp);
			int index = Arrays.binarySearch(newOtherValue, temp);
			if(index >= 0){
//				System.out.println(index + " : " + true);
				return true;
			}
//			System.out.println(index + " : " + false);
		}
		return false;
		*/
	}

	public int[] joinIntArray(int[] value, int[] other_value){
		int[] returnResult = new int[value.length + other_value.length];
		for (int i = 0; i < value.length; i++) {
			returnResult[i] = value[i];
		}
		for (int i = 0; i < other_value.length; i++) {
			returnResult[value.length + i] = other_value[i];
		}
		return returnResult;
	}

	/**
	 * @param a nilai pertama
	 * @param b nilai kedua
	 * @return false kalau ada yang sama, true kalau semua digit berbeda2
	 */
	public boolean cek2_beda(int a, int b){
		int simpan[] = new int[10];
		for (int i = 4; i >= 0; i--) {
			simpan[a%10]++;
			a/=10;
		}
		for (int i = 4; i >=0; i--) {
			simpan[b%10]++;
			b/=10;
		}

		for (int i = 0; i < simpan.length; i++) {
			if(simpan[i] > 1)
				return false;
		}
		return true;
	}

	/**
	 * @param a nilai
	 * @return false jika ada digit yang sama, true kalau tidak ada yang sama.
	 */
	public boolean cek_beda(int a){
		int temp=a;
		int len=0;
		while(temp !=0){
			temp/=10;
			len++;
		}
		if(len>5) return false;
		int simpan[] = new int[10];
		for (int i = 4; i >= 0; i--) {
			simpan[a%10]++;
			a/=10;
		}

		for (int i = 4; i >= 0; i--) {
			if(simpan[i] > 1)
				return false;
		}
		return true;
	}

	public boolean isDigitSame(int[] value){

		HashSet<Integer> hash = new HashSet<>();
		for (int i = 0; i < value.length; i++) {
			if(!hash.add(Integer.valueOf(value[i])))
				return true;
		}

		if(hash.size() == value.length){
			return false;
		}
		return true;

		/*
		for (int i = 0; i < value.length; i++) {
			int[] temp = substractArray(value, i);// 1. potong array
//			System.out.println(Arrays.toString(temp = substractArray(value, i)));
			Arrays.sort(temp);//2. sort terlebih dahulu
			int index = Arrays.binarySearch(temp, value[i]);// 3. cari menggunakan binarySearch
			if(index >= 0){// jika ketemu digit yang sama
//				System.out.println(false + " : "+ index);
				return true;
			}else{// jika tidak ketemu digit yang sama
//				System.out.println(true + " : "+ index);
//				return false;
			}
		}

		return false;
		*/
	}



	public int[] substractArray(int[] value, int skippedIndex){
		int[] returnResult = new int[value.length-1];
//		System.out.println("returnResult.size() : "+ returnResult.length);
		for (int i = 0,j=0; i < value.length; i++) {
			if(skippedIndex == i){
				continue;
			}
			returnResult[j] = value[i];
			j++;
		}
		return returnResult;
	}

	public int convIntArray(int[] value){
		int returnResult = 0;
//		System.out.println("value.size() : "+ value.length);
		for (int i = value.length-1, j=0; i >= 0; i--, j++) {
//			System.out.println(i);
			returnResult += value[j] * (int)Math.pow(10, i);
		}
		return returnResult;
	}

	public int[] convIntArray(int value){
		String temp = Integer.valueOf(value).toString();
		int[] returnResult = new int[temp.length()];
		for (int j=0; j < returnResult.length; j++) {
			returnResult[j] = Integer.parseInt(temp.charAt(j)+"");
		}
		return returnResult;
	}

	public int[] convIntArray(int[] value, int digitNumber){
		if(value.length == digitNumber){
			return value;
		}
		int[] returnResult = new int[digitNumber];
		A : for (int i = digitNumber-1, j=value.length-1; i >= 0; i--, j--) {
			if(j < 0)
				break A;
			returnResult[i] = value[j];
		}
		return returnResult;
	}

}
