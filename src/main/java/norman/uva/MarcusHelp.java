package norman.uva;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import norman.template.template;

/**
 * Started and Finished at 30-3-2015, need to be tested
 * @author M Normansyah (m.normansyah@samsung.com)
 *
 */
public class MarcusHelp extends template {

	public MarcusHelp() {
		super("MarcusHelp", "MarcusHelp", LINUX);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void doSomething() {
		int nT = getInput().nextInt();// number of test case
		A : while(nT-->0){
//			System.out.println("nT "+nT);
			int l = getInput().nextInt();
			int w = getInput().nextInt();
			System.out.println("l "+l+" w "+w);
			m = new char[l][w];
			int[] start = new int[2], end = new int[2];
			List<String> temps = new ArrayList<String>();
			for(int i=0;i<l;i++){
				temps.add(getInput().next());
			}

			for(int i=0;i<l;i++){
				for(int j=0;j<w;j++){
					char temp = temps.get(i).charAt(j);
					m[i][j] = temp;
					if(temp == startEnd[1]){
						end[0] = i;
						end[1] = j;
						System.out.print("end "+Arrays.toString(end)+" ");
					}else if(temp == startEnd[0]){
						start[0] = i;
						start[1] = j;
						System.out.print("start "+Arrays.toString(start)+ " ");
					}else{
						System.out.print(m[i][j]+" ");
					}
				}
				System.out.println();
			}

			for(int i=0;i<engraved.length;i++){
				System.out.print(engraved[i]+ " ");
				engravedStatus[engraved[i]] = true;
			}System.out.println();

			// start processing
			transverse(start[0], start[1]);
		}// end of while A
	}

	private void transverse(int curX, int curY){
//		System.out.println("curX "+curX+" curY "+curY+ " values : "+m[curX][( curY )]);
		if(m[curX][curY] == startEnd[1]){
			System.out.println("reach end");
			return;
		}
//		for(int i=0;i<3;i++){
			// left, y--
		if(!(curY-1 < 0 && curY -1 > m[curX].length)){
			boolean left = engravedStatus[m[curX][( curY - 1 )]];
//			System.out.println("left Status : "+ left);
			if(left){
//				System.out.println("enter left ");
				System.out.print("left ");
				engravedStatus[m[curX][( curY - 1 )]] = false;
				transverse(curX, curY-1);
				return;
			}
		}

		if(!(curY+1 < 0 && curY +1 > m[curX].length)){
			// right, y++
			boolean right = engravedStatus[m[curX][( curY + 1 )]];
//			System.out.println("right Status : "+ right);
			if(right){
//				System.out.println("enter right ");
				System.out.print("right ");
				engravedStatus[m[curX][( curY + 1 )]] = false;
				transverse(curX, curY+1);
				return;
			}
		}

		if(!(curX-1 < 0 && curX -1 > m.length)){
			// forth, x--
			boolean forth =engravedStatus[m[curX - 1 ][( curY )]];
//			System.out.println("forth Status : "+ forth);
			if(forth){
//				System.out.println("enter forth ");
				System.out.print("forth ");
				engravedStatus[m[curX - 1 ][( curY )]] = false;
				transverse(curX-1, curY);
				return;
			}
		}
//		}
//		return;
	}
	boolean[] engravedStatus = new boolean[200];
	char[] startEnd = {
			'@' // start
			,'#' // destination
	};
	char[] engraved = {'I','E','H','O','V','A',startEnd[1]};
	char[][] m;

}
