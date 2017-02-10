package norman.unknown;

import norman.template.Template;

import java.util.ArrayList;
import java.util.List;

public class BSTExample extends Template {

	public BSTExample() {
		super("BSTExample", "BSTExample", WINDOWS);
	}

	@Override
	public void doSomething() {
		List<String> input = new ArrayList<String>();
		while(getInput().hasNext()){
			String next = getInput().next();
			input.add(next);
		}
		
		BST<String, Integer> st = new BST<>();
		for(int i=0;i<input.size();i++){
			st.put(input.get(i), i);
		}
		
		for(String s : st.levelOrder()){
			System.out.println(s + " "+st.get(s));
		}
		
		System.out.println();
		
		for(String s : st.keys()){
			System.out.println(s+" "+st.get(s));
		}
	}

}
