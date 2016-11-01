package norman.srin.algorithm;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import norman.template.template;

public class RoadRunner extends template {

	public RoadRunner() {
		super("RoadRunner", "RoadRunner", LINUX);
	}

	@Override
	public void doSomething() {
		T = getInput().nextInt();
		C = getInput().nextInt();
		width = new int[T];
		for(int i=0;i<T;i++){
			width[i] = getInput().nextInt();
		}
		coordinates = new ArrayList<Pair>();
		for(int i=0;i<C;i++){
			coordinates.add(new Pair(getInput().nextInt(), getInput().nextInt()));
		}

		for(int i=1;i<=C;i++){
			System.out.println("Case #"+i);
			Pair co= coordinates.get(i-1);
			int[] temp = Arrays.copyOfRange(width, co.getX(), co.getY());
			Arrays.sort(temp);
			System.out.println(temp[0]);
//			switch (temp[0]) {
//			case 1:
//				System.out.println("motor");
//				break;
//			case 2:
//				System.out.println("mobil");
//				break;
//			case 3:
//				System.out.println("truck");
//				break;
//			default:
//				break;
//			}
		}
	}
	int T, C;
	int[] width;
	List<Pair> coordinates;

	private static class Pair{
		int x,y;
		public Pair(int x,int y){this.x = x; this.y = y;}
		public int getX() {
			return x;
		}
		public int getY() {
			return y;
		}
		public void setX(int x) {
			this.x = x;
		}
		public void setY(int y) {
			this.y = y;
		}
	}
}
