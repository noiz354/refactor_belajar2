package norman.unknown;

public class Pair<T extends Comparable<T>,S extends Comparable<S>>  implements Comparable<Pair<T, S>>{
	private T first;
	private S second;
	
	/**
	 * membangun sepasang 2 nilai 
	 * @param firstElement elmen pertama
	 * @param secondElement elemen kedua
	 */
	public Pair(T firstElement, S secondElement){
		first = firstElement;
		second = secondElement;
	}
	
	public Pair(){
		// do nothing
	}
	
	/**
	 * mendapatkan elemen pertama dari pasangan ini
	 * @return elemen pertama
	 */
	public T getFirst(){ return first; }
	
	/**
	 * mendapatkan elemen kedua dari pasangan ini
	 * @return elemen kedua
	 */
	public S getSecond(){ return second; }
	
	@Override
	public String toString() {
		return "("+first+", "+second+")";
	}
	
	@Override
	public int compareTo(Pair<T, S> o) {
		if(o == this){
			return 0;
		}
		if(o == null){
			throw new IllegalArgumentException("Other must not be null");
		}
		if(first != null)
			return first.compareTo(o.getFirst());
		else
			return second.compareTo(o.getSecond());
	}

	public void setFirst(T a) {
		this.first = a;
	}
	
	public void setSecond(S b){
		this.second = b;
	}
}
