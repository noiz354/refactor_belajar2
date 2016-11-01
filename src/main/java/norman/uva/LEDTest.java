package norman.uva;

import norman.template.template;
import norman.template.template_utility;

/**
 * uva 416 ( recursive backtracking )
 * @author admin 
 * sekarang perlu dipelajari 
 * 
 * A complete search problem with a confusing description.

Take nInput sequences and store them in an integer array. 
We’ll represent each LED configuration by an int. 1 for 'Y' and 0 for 'N'.
Now, we start guessing the countdown sequence by determining the first digit. 
So, we try the initial digits from 9 down-to nInput - 1.
If the current digit matches the input and the burned-out LED’s –if there’s any–, 
we move to the previous digit, and so on. 
For a guess digit to match the input:
The guess digit should not contradict the burned segments.
Any difference –between a guess digit and an input– 
should be an input segment that’s off not vice-versa.
If we reach the nInputth digit, that’s a match. Otherwise, mismatch.
 */
public class LEDTest extends template{

	public LEDTest() {
		super("LEDTest", "LEDTest", WINDOWS);
	}

	@Override
	public void doSomething() {
		while(( n  = getInput().nextInt())!= 0){
			// input 	
			input = new char[16][];
			line = new int[16];
			for(int i = 0;i<n;i++){
				String temp = "";
				input[i] = (temp = getInput().next()).toCharArray();
//				System.out.println("temp "+temp);
				template_utility.print(getOutput(), "#"+(i+1)+" : "+temp, true);
				int tot = 0;
				for(int j=6,k=0;j>=0;j--,k++){// input[i].length-1
//					System.out.println("j "+j+" k "+k+" input[i][k] "+(char)input[i][k]);
					if(input[i][k] == 'Y'){
//						System.out.println("x "+Math.pow(2, j));
						tot += Math.pow(2, j);
					}
				}
				line[i] = tot;
//				System.out.println("hex "+Integer.toHexString(line[i]));
			}
			match = false;
			for(int digitI = 9; digitI >= n-1 && !match; --digitI){
				solve(0, digitI, 0);
			}
//			System.out.println(ans[match?1:0]);
			template_utility.print(getOutput(), ans[match?1:0], true);
		}
	}
	
	void solve(int inputI, int digitI, int badMask){
//		System.out.println(line[inputI]+" "+badMask+" "+((line[inputI] & badMask)==0));
		template_utility.print(getOutput(), inputI+" line[inputI] "+Integer.toBinaryString(line[inputI])+" (line[inputI] & badMask) "+Integer.toBinaryString((line[inputI] & badMask))+"", true);
		template_utility.print(getOutput(), inputI+" inputI "+Integer.toBinaryString(inputI)
					+" digitI "+Integer.toBinaryString(digitI)
					+" badMask "+ Integer.toBinaryString(badMask), true);
		// finished 
		if(inputI == n)
			match = true;
		// more input
		else if((line[inputI] & badMask)==0){// match old burn
			template_utility.print(getOutput(), " [masuk sini] "
					+Integer.toBinaryString((digit[digitI]))
					+" xor "
					+Integer.toBinaryString(line[inputI])
					+" = "
					+Integer.toBinaryString((digit[digitI] ^ line[inputI]))
					+" dan "
					+Integer.toBinaryString((digit[digitI] ^ line[inputI]))
					+" and "
					+Integer.toBinaryString(line[inputI])
					+" = "
					+Integer.toBinaryString(((digit[digitI] ^ line[inputI])& line[inputI])), true);
			if(((digit[digitI] ^ line[inputI])& line[inputI])==0)// new burns not revivals
				{
				template_utility.print(getOutput(), " [masuk sini#2] "+Integer.toBinaryString((line[inputI] ^ digit[digitI]) | badMask), true);
				solve(inputI+1,digitI-1, (line[inputI] ^ digit[digitI]) | badMask);
				}
//			System.out.println("masuk sini");
		}
//		System.out.println((line[inputI] & badMask));
	}

	final static int[] digit = { 0x7E, 0x30, 0x6D, 0x79, 0x33, 0x5B, 0x5F, 0x70, 0x7F, 0x7B };
	int n;
	char[][] input;
	int[] line;
	boolean match;
	final static String ans[] = {"MISMATCH", "MATCH"};
}
