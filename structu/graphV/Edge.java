package graphV;


public class Edge<V, E extends Comparable<E>> implements Comparable<Edge<V,E>>{

	private Vertex<V, E> initial;
	private Vertex<V, E> finall;
	private E weight;

	public Edge( E weight, Vertex<V, E> initial, Vertex<V, E> finall) {
		this.initial = initial;
		this.finall = finall;
		this.weight = weight;
	}

	public Vertex<V, E> getInitial() {
		return initial;
	}

	public void setInitial(Vertex<V, E> initial) {
		this.initial = initial;
	}


	public Vertex<V, E> getFinall() {
		return finall;
	}


	public void setFinall(Vertex<V, E> finall) {
		this.finall = finall;
	}

	public E getWeight() {
		return weight;
	}


	public void setWeight(E weight) {
		this.weight = weight;
	}

	@Override
	public int compareTo(Edge<V, E> edgeElement) {
		return weight.compareTo(edgeElement.getWeight());
	}

}