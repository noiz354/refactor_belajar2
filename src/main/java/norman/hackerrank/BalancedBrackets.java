package norman.hackerrank;

import norman.template.template;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Stack;

/**
 * Created by normansyahputa on 12/5/16.
 */
public class BalancedBrackets extends template {

    public BalancedBrackets() {
        super("BalancedBrackets", "BalancedBrackets", LINUX, true);
    }

    @Override
    public void doSomething() {
        int T = getInput().nextInt();
        getInput().nextLine();
        while (T-- > 0){
            String bracketString = getInput().nextLine();
            System.out.println(T + " >> "+bracketString);
            Deque<Character> chars = new ArrayDeque<>();
            for(int i=0;i<bracketString.length();i++){
                switch (bracketString.charAt(i)){
                    case '{':
//                        System.out.println("tambah {");
                        chars.addFirst('{');
                        break;
                    case '[':
//                        System.out.println("tambah [");
                        chars.addFirst('[');
                        break;
                    case '(':
//                        System.out.println("tambah (");
                        chars.addFirst('(');
                        break;
                    case '}':
                        Character first = chars.peek();
                        if(first != null && first.equals('{')){
//                            System.out.println("hapus }");
                            chars.poll();
                        }
                        break;
                    case ')':
                        first = chars.peek();
                        if(first != null && first.equals('(')){
//                            System.out.println("hapus )");
                            chars.poll();
                        }
                        break;
                    case ']':
                        first = chars.peek();
                        if(first != null && first.equals('[')){
//                            System.out.println("hapus [");
                            chars.poll();
                        }
                        break;
                }
            }
            if(chars.size()>0){
                System.out.println("NO");
            }else{
                System.out.println("YES");
            }
        }
    }
}
