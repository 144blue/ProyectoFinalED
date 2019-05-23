package graphV;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
	
	public class Vertex<V, E extends Comparable<E>> {

		private HashMap<Vertex<V,E>,ArrayList<Edge<V,E>>> edges;

		private ArrayList<Vertex<V,E>> ancestors;
		private Vertex<V,E> vertexPrevious;
		private V value;
		private int key;
		private double infinite;

	public Vertex(V vertice) {		
		this.edges = new HashMap<Vertex<V,E>,ArrayList<Edge<V,E>>>();
		this.ancestors = new ArrayList<Vertex<V,E>>();
		this.vertexPrevious = null;
		this.infinite = Double.MAX_VALUE;
		this.value = vertice;
	}

	public int getKey() {
		return key;
	}

	public void setKey(int key) {
		this.key = key;
	}

	public HashMap<Vertex<V, E>, ArrayList<Edge<V, E>>> getEdges() {
		return edges;
	}
	
	public void setEdges(HashMap<Vertex<V, E>, ArrayList<Edge<V, E>>> edges) {
		this.edges = edges;
	}

	public V getValue() {
		return value;
	}

	public void setValue(V value) {
		this.value = value;
	}

	public Iterator<Vertex<V,E>> neighborIterator() {
		return edges.keySet().iterator();
	}

	public ArrayList<Edge<V,E>> getEdges(Vertex<V,E> vertex) {
		return edges.get(vertex);
	}
	
	public double getInfinite() {
		return infinite;
	}

	public void setInfinite(double infinite) {
		this.infinite = infinite;
	}

	public void addAncestor(Vertex<V,E> vertex) {
		ancestors.add(vertex);
	}

	public ArrayList<Vertex<V, E>> getAncestors() {
		return ancestors;
	}

	public void setAncestors(ArrayList<Vertex<V, E>> ancestors) {
		this.ancestors = ancestors;
	}

	public Vertex<V, E> getVertexPrevious() {
		return vertexPrevious;
	}

	public void setVertexPrevious(Vertex<V, E> vertexPrevious) {
		this.vertexPrevious = vertexPrevious;
	}

	public void addEdge(Edge<V, E> edge, Vertex<V, E> vertex) {		
		ArrayList<Edge<V, E>> node = null;
		if(edges.containsKey(vertex)){		
			node = edges.get(vertex);
			node.add(edge);			
		}else{
			node = new ArrayList<Edge<V, E>>();
			node.add(edge);
			edges.put(vertex, node );
		}
	}
	
	public boolean containsEdge(E edgeToSearch, Vertex<V, E> vertex) {		
		if(!edges.containsKey(vertex)) {
			return false;
		}		
		ArrayList<Edge<V, E>> edge = edges.get(vertex);		
		boolean contains=false;		
		for (int i = 0; i < edge.size() && !contains; i++) {			
			if(edge.get(i).getWeight().equals( edgeToSearch )) {
				return true;
			}
		}
		return contains;
	}
	
}