package norman.srin.algorithm;

import norman.template.Template;

import java.io.IOException;

public class Jojoba extends Template {

    boolean[][] data;
    int[] result;

	public Jojoba() {
		super("Jojoba", "Jojoba", LINUX);
	}

	@Override
	public void doSomething() {
		int TC = getInput().nextInt();
		int total = TC;
		while(TC-->0){
			System.out.println("Test Case #"+(total-TC));
			int line = getInput().nextInt();
			data = new boolean[line][200];
			result = new int[200];
			for(int i=0;i<=line;i++){
				String temp = getInput().nextLine();
				if(!temp.equals("")){
					int plusSign = temp.indexOf("+");
					int negSign = temp.indexOf("-");
					int spaceSign = temp.indexOf(" ");
					String plus = "*", neg = "*";
					if(plusSign!= -1 & spaceSign != -1){
						plus = temp.substring(plusSign+1, spaceSign);
						for(int plus_index=0;plus_index<plus.length();plus_index++){
							data[i-1][plus.charAt(plus_index)] = true;
						}
					}else{
						plus = temp.substring(plusSign+1);
						for(int plus_index=0;plus_index<plus.length();plus_index++){
							data[i-1][plus.charAt(plus_index)] = true;
						}
					}

					if(negSign != -1){
						neg = temp.substring(negSign+1);
						for(int neg_index=0;neg_index<neg.length();neg_index++){
							data[i-1][neg.charAt(neg_index)] = false;
						}
					}
				}
			}// end of for

			for(int i=0;i<data.length;i++)
				for(int j=0;j<data[i].length;j++)
						if(data[i][j])
							result[j]++;

			String temp = "";
			for(int test=0;test<result.length;test++)
				if(result[test] == line)
					temp += Character.toString((char)test);

			if(temp.equals("")){
				System.out.println("-1");
			}else{
				System.out.println(temp);
			}
		}// end of while
	}

	private void printToFile(String text){
		try {
			getOutput().write(text+"\n");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
