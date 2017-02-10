package norman.uva;

import norman.template.Template;

import java.util.ArrayDeque;
import java.util.Queue;

/**
 * UVa 439: Knight moves
 * @author Normansyah Putra
 * convert from : https://saicheems.wordpress.com/2013/11/13/uva-439-knight-moves/
 *
 */
public class KnightMoves extends Template {

    char a, b;
    int sx, sy, ex, ey;
    int kx[] = {-1, -1, 1, 1, -2, -2, 2, 2};
    int ky[] = {2, -2, 2, -2, 1, -1, 1, -1};
    int A[][];

    public KnightMoves() {
        super("KnightMoves", "KnightMoves", LINUX);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void doSomething() {
		do{
			String temp = getInput().next();
			a = temp.charAt(0);
			sy = Integer.valueOf(Character.valueOf(temp.charAt(1)).toString());
			String temp2 = getInput().next();
			System.out.print("["+temp+"] & ["+temp2+"] ");
			b = temp2.charAt(0);
			ey = Integer.valueOf(Character.valueOf(temp2.charAt(1)).toString());

			A = new int[8][8];

			sx = a - 'a';
			sy--;

			ex = b - 'a';
			ey--;
			System.out.println("["+ex+"] & ["+ey+"]");

			Queue<Pair> q = new ArrayDeque<>();
			q.offer(new Pair(sx, sy));
			while(!q.isEmpty()){
				Pair c = q.peek();
				int x = c.getX(), y = c.getY();
				if(x==ex && y==ey)
					break;
				q.poll();
				for(int i=0;i<8;i++){
					if(x+kx[i]>=0 && x + kx[i]<8
							&& y+ky[i]>=0&&y+ky[i]<8){
						q.offer(new Pair(x+kx[i], y+ky[i]));
						A[x+kx[i]][y+ky[i]] = A[x][y]+1;
					}
				}
			}
            System.out.println("To get from " + a + "" + (sy + 1)
                    + " to " + b + "" + (ey + 1) + " takes " +
                    A[ex][ey] + " knights moves\n");
            // takes %d knights moves, ,A[ex][ey]
		}while(getInput().hasNext());
	}

	class Pair{
		int x,y;
		public Pair(int mX, int mY) {
			x = mX;
			y = mY;
		}
		public int getX() {
			return x;
		}

		public void setX(int x) {
			this.x = x;
		}

        public int getY() {
            return y;
        }

		public void setY(int y) {
			this.y = y;
		}
	}
}
