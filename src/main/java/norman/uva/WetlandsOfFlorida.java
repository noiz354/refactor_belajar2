package norman.uva;

import norman.template.Template;
import norman.template.TemplateUtility;

import java.util.ArrayList;
import java.util.List;

/**
 * 
 * @author Normansyah Putra
 * started at 23-8-2015, minggu
 * problem, 
 * diberikan titik koordinat wet land ( char 'W' )
 * di matrix yang diberikan ( isinya char 'W' untuk wet dan 'L' untuk land )
 * cari tahu berapa jumlah titik W ?
 * 
 * solusi : flood fill ( labeling connected component )
 */
public class WetlandsOfFlorida extends Template {

    static int dr[] = {1, 1, 0, -1, -1, -1, 0, 1};
    static int dc[] = {0, 1, 1, 1, 0, -1, -1, -1};
    List<char[]> grid;
    int C, R;

    public WetlandsOfFlorida() {
        super("WetlandsOfFlorida", "WetlandsOfFlorida", WINDOWS);
	}

	@Override
	public void doSomething() {
		int testCase = getInput().nextInt();
		for(int i=0;i<testCase;i++){
			grid = new ArrayList<>();
			String readTemp = "";
			while(true){
				readTemp = getInput().next();
				if(readTemp.charAt(0) != 'W' && readTemp.charAt(0) != 'L'){
					break;
				}
				grid.add(readTemp.toCharArray());
			}
			C = grid.size();
			R = grid.get(0).length;

			int startX = Integer.parseInt(readTemp);
			boolean firstTime = true;
            TemplateUtility.print(getOutput(), startX + "", true);

			while(true){
				if(firstTime)
				{
					firstTime = false;
				}else{
					startX = getInput().nextInt();
				}
				int startY = getInput().nextInt();
                TemplateUtility.print(getOutput(), "r " + startX + " c " + startY, true);
                int result = floodfill(--startX, --startY, 'W', '.');
                TemplateUtility.print(getOutput(), result + "", true);
                if (!getInput().hasNext()) {
                    break;
				}
			}

        }
	}
	
	int floodfill(int r, int c, char c1, char c2){// return the size of CC
        TemplateUtility.print(getOutput(), "r " + r + " c " + c + " c1 " + c1 + " c2 " + c2, true);
        if (r < 0 || r >= R || c < 0 || c >= C) return 0;// outside grid
        TemplateUtility.print(getOutput(), "outside grid pass", true);
        if (grid.get(r)[c] != c1) return 0;// does not have color c1
        TemplateUtility.print(getOutput(), "does not have color c1 pass", true);
        int ans = 1;
        grid.get(r)[c] = c2;
		for(int d=0;d<8;d++)
			ans += floodfill(
					r+dr[d],
					c+dc[d],
					c1,
					c2);
		return ans;
	}
}
