package norman.uva;

import norman.template.template;

/**
 * uva 628, Passwords
 * @author M Normansyah (m.normansyah@samsung.com)
 * started at 9/3/2015
 * started to solve 10/3/2015, stuck at pattern with length 1.
 * -----------------------------------------------
 * @author M Normansyah (m.normansyah@samsung.com)
 * Finished at 11/3/2015, 4:33 PM
 */
public class Passwords extends template {

	public Passwords() {
		super("Passwords", "Passwords", LINUX);
	}

	@Override
	public void doSomething() {
		A: while(true){
			if(!getInput().hasNext()){
				break A;
			}
			nWord = getInput().nextInt();
			words = new String[nWord];
			for(int i=0;i<nWord;i++){
				words[i] = getInput().next();
				System.out.println(words[i]);
			}
			nPattern = getInput().nextInt();
			patterns = new String[nPattern];
			for(int i=0;i<nPattern;i++){
				patterns[i] = getInput().next();
				System.out.println(patterns[i]);
			}

			for(String pattern : patterns){
				password(0,0, pattern, "");
			}
		}
	}

	private void password(int n, int pattern_index, String pattern, String result){
		if(n == pattern.length()){
			System.out.println(result);
			return;
		}
		char pat = pattern.charAt(pattern_index);
		switch (pat) {
		case '#':
			for(int i=0;i<words.length;i++){
				password(n+1, pattern_index+1, pattern, result+"\""+words[i]+"\"");
			}
			break;
		case '0':
			for(int i=0;i<numbers.length;i++){
				password(n+1, pattern_index+1, pattern, result+"\""+numbers[i]+"\"");
			}
			break;
		default:
			// do nothing
			break;
		}
	}

	int nWord, nPattern, lastIndex;
	String[] words, patterns;
	int[] numbers = {0,1,2,3,4,5,6,7,8,9};

}
