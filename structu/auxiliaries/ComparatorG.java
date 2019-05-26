package auxiliaries;


	import java.util.Comparator;

	/**
	 * @author juanmgarcia97, vardo159 & 144blue.
	 * This generic class compares two objects in order to the lexicographic content.
	 * @param <E> generic value that represent the object.
	 */
	public class ComparatorG<E extends Comparable<E>> implements Comparator<Object[]>{

	/* (non-Javadoc)
	 * @see java.util.Comparator#compare(java.lang.Object, java.lang.Object)
	 */
	@Override
	public int compare(Object[] objeto1, Object[] objeto2) {		
		E a=(E)objeto1[0];
		E b=(E)objeto2[0];
		return a.compareTo(b);
	}
	
	/**
	 * This method compares two objects and returns an integer 
	 * @param object1
	 * @param object2
	 * @return a negative integer, zero, or a positive integer as this object
     *          is less than, equal to, or greater than the specified object.
	 */
	public int compare2(E object1, E object2) {	
		int same = object1.compareTo(object2);
		return same;
	}
}
