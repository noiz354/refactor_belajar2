package norman.uva;

import java.util.Arrays;

import norman.template.template;

public class JimAndTheOrders extends template {

	public JimAndTheOrders() {
		super("JimAndTheOrders", "JimAndTheOrders", LINUX);
	}

	@Override
	public void doSomething() {
		A: while(true){
			if(!getInput().hasNext()){
				break A;
			}
			int numberOfOrders = getInput().nextInt();
			orders = new Order[numberOfOrders];
			for(int i=0;i<orders.length;i++)
				orders[i] = new Order(getInput().nextInt(), getInput().nextInt(),(i+1));

			for(Order o : orders)
				System.out.println(o.time +" " +o.procTime+" "+o.id);

			Arrays.sort(orders);

//			System.out.println(Arrays.toString(orders));
			System.out.println("\nsolution : ");
			for(Order o : orders)
				System.out.println(o.time +" " +o.procTime+" "+o.id);
//				System.out.print(o.id+" ");// (o.time+o.procTime)
			System.out.println();
		}
	}

	Order[] orders;
	class Order implements Comparable<Order>{
		int id;
		int time;
		int procTime;
		int totalTime;
		public Order(int time, int procTime, int id){
			this.time = time;
			this.procTime = procTime;
			this.id = id;
			totalTime += procTime+time;
		}
		@Override
		public int compareTo(Order other) {
//			if(!(Integer.valueOf(time).compareTo(other.time)==0))
//				return Integer.valueOf(time).compareTo(other.time);
//			return Integer.valueOf(procTime).compareTo(other.procTime);
			return Integer.valueOf(totalTime).compareTo(other.totalTime);
		}
		@Override
		public String toString() {
			return "Order [time=" + time + ", procTime=" + procTime + "]";
		}

	}

}
