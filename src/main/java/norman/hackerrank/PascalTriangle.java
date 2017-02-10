package norman.hackerrank;

import norman.template.Template;

public class PascalTriangle extends Template {

	public PascalTriangle() {
		super("PascalTriangle", "PascalTriangle", LINUX);
	}

	public static void triangle(int maximalBaris) {
	    int r, num;
	    for (int i = 0; i <= maximalBaris; i++) {
	        num = 1;
	        r = i + 1;
	        for (int col = 0; col <= i; col++) {
	            if (col > 0) {
                    num = num * (r - col) / col;
                }
                System.out.print(num + " ");
	        }
	        System.out.println();
	    }
	}

    @Override
    public void doSomething() {
        while (true) {
            if (!getInput().hasNext()) {
                break;
            }
            int maximalBaris = getInput().nextInt();
            triangle(maximalBaris - 1);
        }
    }

}
