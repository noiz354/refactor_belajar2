package norman.unknown;

/**
 * 
 * @author Normansyah Putra
 * Learn bisection method, pendekatan matematis
 * http://www.mathcs.emory.edu/~cheung/Courses/170/Syllabus/07/bisection.html
 */
public class Bisection02 {
	public static void main(String args[]){
		final double epsilon = 0.00001;
		double a, b, m, y_m, y_a;
		
		a = 0; b=4;
		
		while((b-a) > epsilon){
			m = (a+b)/2;
			
			y_m = m*m- 3.0; // y_m = f(m)
			y_a = a*a- 3.0; // y_a = f(a)
			
			if((y_m > 0 && y_a < 0) || (y_m < 0 && y_a > 0))
			{ // f(a) and f(m) have different signs: move b
				b = m;
			}else{// f(a) and f(m) have same signs: move a
				a = m;
			}
			System.out.println("New interval: ["+a+" .. "+b+"]");// print progress
		}
	}
}
