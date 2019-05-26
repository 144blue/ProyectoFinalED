package graphV;


/**
 * This class is a representation of a graph's edge.
 * @author juanmgarcia97, vardo159 & 144blue.
 * 
 *
 * @param <V> generic value for the initial vertex.
 * @param <E> generic value for the final vertex.
 */
public class Edge<V, E extends Comparable<E>> implements Comparable<Edge<V,E>>{

	private Vertex<V, E> initial;
	private Vertex<V, E> finall;
	private E weight;

	/**
	 * This constructor method creates an edge according to the entered attributes.
	 * @param weight value that represent the cost to travel throw the initial and the final vertex.
	 * @param initial vertex at the beginning of the edge.
	 * @param finall vertex at the end of the edge. 
	 */
	public Edge( E weight, Vertex<V, E> initial, Vertex<V, E> finall) {
		this.initial = initial;
		this.finall = finall;
		this.weight = weight;
	}

	/**
	 * This method returns the initial vertex of the edge.
	 * @return object representing the initial vertex of the edge.
	 */
	public Vertex<V, E> getInitial() {
		return initial;
	}

	/**
	 * This method replaces the initial vertex
	 * @param initial object that represent the new initial vertex.
	 */
	public void setInitial(Vertex<V, E> initial) {
		this.initial = initial;
	}


	/**
	 * This method returns the vertex at the end of the edge.
	 * @return final vertex at the edge's end.
	 */
	public Vertex<V, E> getFinall() {
		return finall;
	}


	/**
	 * This method replaces the vertex at the end of the edge.
	 * @param finall vertex at the edge's end.
	 */
	public void setFinall(Vertex<V, E> finall) {
		this.finall = finall;
	}

	/**
	 * This method returns the cost to travel throw this edge.
	 * @return generic value that represent the cost of the edge.
	 */
	public E getWeight() {
		return weight;
	}


	/**
	 * This method replaces the value of the edge's weight.
	 * @param weight generic value that represent the cost of the edge.
	 */
	public void setWeight(E weight) {
		this.weight = weight;
	}

	/* (non-Javadoc)
	 * @see java.lang.Comparable#compareTo(java.lang.Object)
	 */
	@Override
	public int compareTo(Edge<V, E> edgeElement) {
		return weight.compareTo(edgeElement.getWeight());
	}

}