package graphV;


	import java.util.Comparator;

	public class ComparatorG<E extends Comparable<E>> implements Comparator<Object[]>{

	@Override
	public int compare(Object[] objeto1, Object[] objeto2) {		
		E a=(E)objeto1[0];
		E b=(E)objeto2[0];
		return a.compareTo(b);
	}
	
	public int compare2(E object1, E object2) {	
		int same = object1.compareTo(object2);
		return same;
	}
}
