package norman.hackerrank;

import norman.template.Template;

/**
 * https://www.hackerrank.com/challenges/diagonal-difference
 * @author M. Normansyah
 * 2:58:15 PM
 */
public class DiagonalDifference extends Template {

	public DiagonalDifference() {
		super("DiagonalDifference", "DiagonalDifference", LINUX);
	}

	@Override
	public void doSomething() {
		while(true){
			if(!getInput().hasNext()){
				break;
			}
			
			int N = getInput().nextInt();
			int[][] matrix= new int[N][N];
			for(int i=0;i<N;i++){
				for(int j=0;j<N;j++){
					matrix[i][j]= getInput().nextInt();
				}
			}
			int result = 0;
			
			// calculate first diagonal
			int i=0, j=0, sum =0;
			while(i<N&&j<N){
//				TemplateUtility.print(getOutput(), matrix[i][j]+"", true);
                sum += matrix[i][j];
                i++; j++;
			}
			result = sum;
//			TemplateUtility.print(getOutput(), "sum 1 : "+result+"", true);

            // calculate second diagonal
            i = 0; j = N-1; sum = 0;
			while(j>=0&&i<=N-1){
//				TemplateUtility.print(getOutput(), matrix[i][j]+"", true);
                sum += matrix[i][j];
                i++; j--;
			}
//			TemplateUtility.print(getOutput(), "sum 2 : "+sum+"", true);
            result = Math.abs(result - sum);

//			TemplateUtility.print(getOutput(), result+"", true);// print to a file
            System.out.println(result);
        }
	}

}
