package norman.hackerrank;

import java.util.Scanner;

import norman.template.template;

/**
 * http://blueocean-penn.blogspot.com/2014/12/count-luck-maz.html
 * @author M Normansyah (m.normansyah@samsung.com)
 *
 */
public class CountLuck extends template {

	public static class Node{
        int r;int c; Node pre;
        public Node(int r, int c){this.r = r; this.c = c;}
    }

	public static void visit(char[][] maz, int startR, int startC, boolean[][] seen,  Node pre, Node tail){
        if(startR<0 || startC<0 || startR>=maz.length || startC>=maz[0].length || seen[startR][startC])
            return;
        if(maz[startR][startC]=='X')
            return;
        if(maz[startR][startC]=='*'){
            tail.pre = pre;
            return;
        }
        seen[startR][startC] = true;
        Node n = new Node(startR, startC);
        n.pre = pre;
        visit(maz, startR-1, startC, seen,  n, tail);
        visit(maz, startR+1, startC, seen,  n, tail);
        visit(maz, startR, startC-1, seen,  n, tail);
        visit(maz, startR, startC+1, seen,  n, tail);
    }

	public CountLuck() {
		super("CountLuck", "CountLuck", LINUX);
	}

	@Override
	public void doSomething() {
		/* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */

            int t = getInput().nextInt();
            while(t-->0){
                int row = getInput().nextInt();
                int col = getInput().nextInt();
                int startR=0, startC=0;
                int endR=0, endC=0;
                char[][] maz = new char[row][col];
                for(int r=0; r<row; r++){
                    String str = getInput().next();
                    int index = str.indexOf("M");
                    if(index>=0){
                        startR=r;startC=index;
                    }
                    index = str.indexOf("*");
                    if(index>=0){
                        endR=r;endC=index;
                    }
                    maz[r] = str.toCharArray();
                }
                int k=getInput().nextInt();
                boolean[][] seen = new boolean[row][col];
                Node tail = new Node(endR, endC);
                Node head = null;
                visit(maz, startR, startC, seen, head, tail);
                int counter = 0;
                Node n = tail.pre;
                while(n!=null){
                    //System.out.println(n.r + "-" + n.c);
                    int option = 0;
                    if(n.r-1>=0 && n.r-1<row && maz[n.r-1][n.c]=='.')
                        option++;
                    if(n.r+1>=0 && n.r+1<row && maz[n.r+1][n.c]=='.')
                        option++;
                    if(n.c-1>=0 && n.c-1<col && maz[n.r][n.c-1]=='.')
                        option++;
                    if(n.c+1>=0 && n.c+1<col && maz[n.r][n.c+1]=='.')
                        option++;
                    if(option>2 || (n == tail.pre&&option>1) || (n.r==startR&&n.c==startC&&option>1) || (n.pre!=null && n.pre.r==startR&&n.pre.c==startC&&option>1))
                        counter++;
                    n = n.pre;
                }

                System.out.println(counter==k?"Impressed":"Oops!");
        }
	}

}
