package norman.uva;

import norman.template.Template;
import norman.unknown.Pair;

import java.util.ArrayList;
import java.util.List;

public class ThroughTheDesert extends Template {

	final static double EPS = 0.000_001;
	List<Pair<Integer, Pair<String, Integer>>> road;

	public ThroughTheDesert() {
		super("ThroughTheDesert", "ThroughTheDesert", LINUX);
	}

	@Override
	public void doSomething() {
		int p, t = 1, nLeak, maxT;
		String s = null;
		while(true){
			//input
			road = new ArrayList<>();
			maxT = nLeak = 0;
			do{
				p = getInput().nextInt();
				s = getInput().next();
				if(s.charAt(0) == 'L'){
					++nLeak;
				}else if(s.charAt(0) == 'G' && s.charAt(1) == 'a'){
					s += " "+getInput().next();
				}else if(s.charAt(0)=='F'){
					s += " "+getInput().next();
					t = getInput().nextInt();
					if(t == 0){
						return;
					}
					maxT = Math.max(maxT, t);
				}
				System.out.println(p+" "+s+" "+t);
				road.add(new Pair<Integer, Pair<String,Integer>>(p,
						new Pair<>(s, t)));
			}while(s.charAt(0) != 'G' || s.charAt(1) != 'o');

			// solve
			double lV = 0, mV
					, hV = p * (maxT/100.0 + nLeak) // high, why this ?
					,j;
			System.out.println("hV "+hV);
			do{
				mV = ( hV +lV )/2;
				if((j=journeySuccess(mV))> 0){
					hV = mV;
				}else{
					lV = mV;
				}
				System.out.println("mV "+mV+" j "+j);
			}while(hV-lV > EPS || j < 0);
			System.out.println("hV "+ hV + " lV "+lV);
			System.out.println((hV+lV)/2);
		}
	}

	double journeySuccess(double v){
		double g = v, c =0, l =0, prevPos = 0;
		for(int i =0;i<road.size();i++){
			g -= (road.get(i).getFirst()-prevPos) * (l + c/100.0);
			if(i < road.size()-1){
				switch (road.get(i).getSecond().getFirst().charAt(0)) {
				case 'F':
					c = road.get(i).getSecond().getSecond();
					break;
				case 'L':
					++l;
					break;
				case 'G':
					g = ( g >= 0 ? v : g);
					break;
				case 'M':
					l = 0;
					break;
				default:
					break;
				}
			}
			prevPos = road.get(i).getFirst();
		}
		return g;
	}

}
