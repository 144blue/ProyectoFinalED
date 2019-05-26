package auxiliaries;

import java.util.HashSet;

	/**
	 * @author juanmgarcia97, vardo159 & 144blue.
	 * 
	 * This is an auxiliary class for the Floyd-Warshall algorithm.
	 * It's job is to exchange the value of two objects (vertex) within the adjacency matrix.
	 *
	 * @param <K> generic value for the Key.
	 * @param <V> generic value for the Value.
	 */
	public class ExchangePair<K,V> {
	
	private HashSet<Object> values;
	private K key;
	private V value;
	
	/**
	 * Constructor for the class in which the attributes are initialized.
	 * @param key generic value for the Key
	 * @param value generic value for the Value
	 */
	public ExchangePair(K key,V value) {		
		this.key=key;
		this.value=value;
		this.values=new HashSet<Object>();
		this.values.add(key);
		this.values.add(value);
	}
	
	/**
	 * This method returns the Key value.
	 * @return key generic Key value.
	 */
	public K getKey() {
		return key;
	}
	
	/**
	 * This method modifies the value of the Key.
	 * @param key generic value that replaces the old Key value.
	 */
	public void setKey(K key) {
		this.key = key;
	}

	/**
	 * This method returns the value of Value.
	 * @return value generic value of Value.
	 */
	public V getValue() {
		return value;
	}
	
	/**
	 * This method replaces the value of Value.
	 * @param value generic value that replaces the old value of Value.
	 */
	public void setValue(V value) {
		this.value = value;
	}
	
	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		return values.hashCode();
	}
	
	/**
	 * This method returns all the Values available.
	 * @return
	 */
	public HashSet<Object> getValues() {
		return values;
	}

	/**
	 * This method replaces the Values.
	 * @param values HashSet of values.
	 */
	public void setValues(HashSet<Object> values) {
		this.values = values;
	}
	
	/* (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object object) {
		ExchangePair<K,V> p=(ExchangePair<K,V>)object;
		if((key.equals(p.key) && value.equals(p.value)) || (key.equals(p.value) && value.equals(p.key))) {			
			return true;
		}
		return false;
	}
	
}
