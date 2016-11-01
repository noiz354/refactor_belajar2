package norman.java8;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * Lambda Example, replacement of anonymous inner class, 
 * example using java provided class 
 * @author M. Normansyah
 * 11:27:20 AM
 */
public class LambdaEx {
	public static void main(String[] args) {
		sortWithLambda();
		interfaceLambda();
	}
	
	public static void anotherEx(){
		class Book{
			String name, author;
			public Book(String Name, String Author){ name = Name; author = Author;}
		}
		List<Book> books = new ArrayList<>();
		books.add(new Book("a", "b"));
		books.add(new Book("a", "b"));
		books.add(new Book("E", "f"));
		books.add(new Book("d", "c"));
		
//		books.stream().map(b -> [b.name,b.author]);
	}
	
	/**
	 * Functional Interface same with anonymous inner class
	 * tidak ada argument jadi empty ()
	 */
	public static void interfaceLambda(){
		// runnable hanya 1 metode yang perlu di override.
		new Thread(() -> System.out.println("masuk sini")) ;
	}
	
	public static void sortWithLambda(){
		class People{
			String name;
			int age;
			public People(String Name, int Age){
				name = Name;
				age = Age;
			}
			
			public String getName() {
				return name;
			}
			
			public int getAge() {
				return age;
			}
			
			@Override
			public String toString() {
				return "["+name+","+age+"]";
			}
		}
		
		List<People> peoples = new ArrayList<>();
		peoples.add(new People("Winu Konyol", 31));
		peoples.add(new People("Pbo Bangsat", 28));
		peoples.add(new People("Nman Gaul", 23));
		peoples.add(new People("Adhi Gendut", 36));
		
		System.out.println("before sort");
//		printList(peoples);// old print 
		
		// new lamba print expression
		peoples.forEach(p -> System.out.println(p));
		
		Collections.sort(peoples, (p1, p2) -> Integer.valueOf(p1.age).compareTo(p2.age));
		System.out.println("\nafter sort");
//		printList(peoples); // old print 
		peoples.forEach(p -> System.out.println(p));
		
		// ada contoh menarik
		peoples.removeIf(p -> "Pbo Bangsat".equals(p.name));
		peoples.forEach(p -> System.out.println(p));
		
		peoples.replaceAll(p -> new People(p.name.toUpperCase(), p.age));
		peoples.forEach(p -> System.out.println(p));
		
		// function dalam function 
		System.out.println("\nremove and add all again");
		peoples.removeAll(peoples);
		
		peoples.add(new People("Winu Konyol", 31));
		peoples.add(new People("Pbo Bangsat", 28));
		peoples.add(new People("Nman Gaul", 23));
		peoples.add(new People("Adhi Gendut", 36));
		
		System.out.println("\ncomparing dengan function dalam function");
		peoples.sort(Comparator.comparing(p -> p.getName()));
		peoples.forEach(p -> System.out.println(p));
		
		// using method references
		System.out.println("\nremove and add all again");
		peoples.removeAll(peoples);
		
		peoples.add(new People("Winu Konyol", 31));
		peoples.add(new People("Pbo Bangsat", 28));
		peoples.add(new People("Nman Gaul", 23));
		peoples.add(new People("Adhi Gendut", 36));
		
		System.out.println("\ncomparing dengan method references");
		peoples.sort(Comparator.comparing(People::getName));
		peoples.forEach(p -> System.out.println(p));
		
		System.out.println("\n2 level comparing");
		peoples.add(new People("Adrian Bangkong", 23));
		peoples.sort(Comparator.comparing(People::getAge).thenComparing(People::getName));
		peoples.forEach(p -> System.out.println(p));
	}
	
	public static void printList(List<? extends Object> list){
		for(Object a : list){
			System.out.println(a);
		}
	}
}
