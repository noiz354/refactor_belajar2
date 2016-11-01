package norman.uva;

import java.util.Arrays;

import norman.template.template;

public class DragonOfLoowater extends template {

	public DragonOfLoowater() {
		super("DragonOfLoowater", "DragonOfLoowater", LINUX);
	}

	@Override
	public void doSomething() {
		A: while(true){
			int nDragon = getInput().nextInt();
			int nKnight = getInput().nextInt();
			if(nDragon ==0&&nKnight==0){
				break A;
			}
			int[] dragons = new int[nDragon];
			int[] knights = new int[nKnight];
			for(int i=0;i<dragons.length;i++){
				dragons[i] = getInput().nextInt();
			}
			for(int i=0;i<knights.length;i++){
				knights[i] = getInput().nextInt();
			}
			System.out.println("dragon :");
			System.out.println(Arrays.toString(dragons));
			System.out.println("knight :");
			System.out.println(Arrays.toString(knights));

			int gold, d, k;
			gold = d = k = 0;
			while(d < nDragon && k < nKnight){
				while(dragons[d] > knights[k] && k < nKnight) k++;
				if(k==nKnight) break;
				gold += knights[k];
				d++; k++;
			}
			if(d ==nDragon){
				System.out.println(gold);
			}else{
				System.out.println("Loowater is doomed!\n");
			}
		}
	}

}
