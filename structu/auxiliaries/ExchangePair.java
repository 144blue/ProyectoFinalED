package auxiliaries;

import java.util.HashSet;

	public class ExchangePair<K,V> {
	
	private HashSet<Object> values;
	private K key;
	private V value;
	
	public ExchangePair(K key,V value) {		
		this.key=key;
		this.value=value;
		this.values=new HashSet<Object>();
		this.values.add(key);
		this.values.add(value);
	}
	
	public K getKey() {
		return key;
	}
	
	public void setKey(K key) {
		this.key = key;
	}

	public V getValue() {
		return value;
	}
	
	public void setValue(V value) {
		this.value = value;
	}
	
	@Override
	public int hashCode() {
		return values.hashCode();
	}
	
	public HashSet<Object> getValues() {
		return values;
	}

	public void setValues(HashSet<Object> values) {
		this.values = values;
	}
	
	@Override
	public boolean equals(Object object) {
		ExchangePair<K,V> p=(ExchangePair<K,V>)object;
		if((key.equals(p.key) && value.equals(p.value)) || (key.equals(p.value) && value.equals(p.key))) {			
			return true;
		}
		return false;
	}
	
}
