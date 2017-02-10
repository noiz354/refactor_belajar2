package norman.hackerrank;

import norman.template.Template;

/**
 *
 * @author M Normansyah (m.normansyah@samsung.com)
 * start at 3-6-2015, masih wrong answer soalnya belum dikasih table untuk eempercepat.
 * TODO untuk menghitung contigous perlu table kayaknya
 * https://www.hackerrank.com/challenges/maxsubarray
 * coba baca dari hackerranknya
 *
 * 4/6/2015 fix kadane algorithm
 * only get 20/30
 */
public class MaximumSubArray extends Template {

    int[] data;

	public MaximumSubArray() {
		super("MaximumSubArray", "MaximumSubArray", LINUX);
	}

	@Override
	public void doSomething() {
		int TC = getInput().nextInt();
		for(int tc=1;tc<=TC;tc++){
			int len = getInput().nextInt();
			data = new int[len];
			boolean isAllNegative = true;
			for(int i=0;i<len;i++){
				data[i] = getInput().nextInt();
                isAllNegative = isAllNegative && data[i] < 0;
            }
//			System.out.println(Arrays.toString(data)+" isAllNegative "+isAllNegative);

			int sum =-9999, ans =0;

			int max_ending_here = 0, max_so_far = 0;
			if(isAllNegative){
				for(int i=0;i<data.length;i++){
					sum = Math.max(data[i], sum);
				}
				System.out.print(sum+" ");
			}else{
				for(int i=0;i<data.length;i++){
					max_ending_here = Math.max(0, max_ending_here+data[i]);
					max_so_far = Math.max(max_so_far, max_ending_here);
				}
				System.out.print(max_so_far +" ");
			}


			/*
			 * calculate non-contigous below
			 */
			if(isAllNegative)
				sum = -9999;
			else
				sum = 0;
			ans =0;
			for(int i=0;i<data.length;i++){
				if(isAllNegative){
					ans += data[i];
					sum = Math.max(ans, sum);
				}else if(!isAllNegative)
					if(data[i] >= 0){
						sum += data[i];
					}
			}
			System.out.println(sum);
		}
	}

}
