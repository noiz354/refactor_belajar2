package norman.uva;

import norman.template.template;

/**
 *
 * @author M Normansyah (m.normansyah@samsung.com)
 * uva 11703
 *
 * ada bug nih setelah masuk 390 keatas.
 */
public class SqrtLogSin extends template {

	public SqrtLogSin() {
		super("SqrtLogSin", "SqrtLogSin", LINUX);
	}

	@Override
	public void doSomething() {
		A: while(true){
			if(!getInput().hasNext()){
				break A;
			}

			int i = getInput().nextInt();
			if(i== -1){
				break A;
			}

			table = new int[2_000_200];
			table[0] = 1;
//			for(int k=1;k<table.length;k++){
//				table[k] = -1;
//			}

			int result = SqrtLogSinCalc2(i)%1_000_000;
			System.out.println("result "+result);
		}
	}

	private int SqrtLogSinCalc2(int index){
		if(index == 0){
			return table[0];
		}
		if(table[index] != 0){
			return table[index];
		}
		int ans = 0;
		ans = SqrtLogSinCalc2((int)Math.floor(index-Math.sqrt(index)))
				+ SqrtLogSinCalc2((int)Math.floor(Math.log(index)))
				+ SqrtLogSinCalc2((int)Math.floor(index * Math.pow(Math.sin(index), 2)));
		table[index] = ans%1_000_000;
		return ans;
	}

	int[] table;
	private int SqrtLogSinCalc(int index){
//		System.out.println("enter index "+index);
		if(index == 0){
//			System.out.println("return 0");
			return table[0];
		}

		if(table[index] != -1){
			return table[index];
		}
		int ans = 0;
//		System.out.println("miss 0");
		for(int i=0;i<3;i++){
			double temp = 0, ansTemp =0;
			int indexTemp = 0;
			switch (i) {
			case 0:
				temp = index-Math.sqrt(index);
				indexTemp = (int)Math.floor(index-Math.sqrt(index));
//				System.out.println("index "+ index+" i "+i+" move to index "+ temp+" indexTemp "+indexTemp);
				ans += ( ansTemp = SqrtLogSinCalc(indexTemp));
//				System.out.println("index "+ index+" i "+i+" temp "+ temp+" ansTemp "+ ansTemp+" ans "+ ans);
				break;
			case 1:
				temp = Math.log(index);
				indexTemp = (int)Math.floor(Math.log(index));
//				System.out.println("index "+ index+" i "+i+" move to index "+ temp);
				ans += ( ansTemp = SqrtLogSinCalc(indexTemp));
//				System.out.println("index "+ index+" i "+i+" temp "+ temp+" ansTemp "+ ansTemp+" ans "+ ans);
				break;
			case 2:
				temp = (index * Math.pow(Math.sin(index), 2));
				indexTemp = (int)Math.floor(index * Math.sin(index)* Math.sin(index));
//				System.out.println("index "+ index+" i "+i+" move to index "+ temp);
				ans += ( ansTemp = SqrtLogSinCalc((indexTemp)));
//				System.out.println("index "+ index+" i "+i+" temp "+ temp+" ansTemp "+ ansTemp+" ans "+ ans);
				break;
			default:
				break;
			}
		}
//		System.out.println("leave index "+index+" result "+ans);
		table[index] = ans%1_000_000;
		return ans%1_000_000;
	}

}
