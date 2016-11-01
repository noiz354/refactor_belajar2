package norman.unknown;

import java.util.ArrayList;
import java.util.List;

import norman.template.template;

public class BSTExample extends template {

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
