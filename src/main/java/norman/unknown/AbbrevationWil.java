package norman.unknown;

import norman.template.Template;

/**
 * Created by normansyahputa on 6/16/17.
 */
public class AbbrevationWil extends Template{
    public AbbrevationWil() {
        super("AbbrevationWil", "AbbrevationWil", LINUX, true);
    }

    @Override
    public void doSomething() {
        String a = getInput().next().toLowerCase();
        String b = getInput().next().toLowerCase();

        char[] chars = b.toCharArray();

        for (int i=0;i<chars.length;i++) {
            if(!a.contains(chars[i]+"")){
                println("NO");
                break;
            }
        }
        println("YES");

    }
}
