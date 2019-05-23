package graphV;

	import java.util.ArrayList;
	import java.util.HashMap;
	import java.util.HashSet;
	import java.util.Iterator;
	import interfaces.IBasicMethodsGraph;


	public class ListGraph<V, E extends Comparable<E>> implements IBasicMethodsGraph<V,E> {

	private boolean undirected;
	private HashMap<V,Vertex<V,E>> graph;
	private HashSet<Edge<V,E>> edges;
	
	public ListGraph(boolean undirected) {
		this.graph = new HashMap<V,Vertex<V,E>>();
		this.edges = new HashSet<Edge<V,E>>();
		this.undirected = undirected;
	}
	
	public boolean insertVertex(V vertice) {
		Vertex<V,E> verticeFirst = null;	
		if(graph.containsKey(vertice)) {	
			return false;
		}else {			
			verticeFirst=new Vertex<V,E>(vertice);
			graph.put(vertice,verticeFirst);
			return true;		
		}	
	}

	public boolean insertEdge(E egde, V vertice1, V vertice2) {
		Vertex<V,E> verticeFirst = null;
		Vertex<V,E> verticeSecond = null;		
		if(graph.containsKey(vertice1)) {		
			verticeFirst = graph.get(vertice1);
		}else {			
			verticeFirst = new Vertex<V,E>(vertice1);
			graph.put(vertice1, verticeFirst);
		}
		if(graph.containsKey(vertice2)) {			
			verticeSecond = graph.get(vertice2);
		}else {			
			verticeSecond = new Vertex<V,E>(vertice2);	
			graph.put(vertice2, verticeSecond);
		}
		if(verticeFirst.containsEdge(egde, verticeSecond)) {			
			return false;
		}else {			
			Edge<V,E> edge1=new Edge<V,E>(egde,verticeFirst,verticeSecond);			
			verticeFirst.addEdge(edge1,verticeSecond);
			edges.add(edge1);	
			if( undirected ) {			
				Edge<V,E> edge2=new Edge<V,E>(egde,verticeSecond,verticeFirst);
				verticeSecond.addEdge(edge2,verticeFirst);				
			}
			return true;
		}
	}

	public ArrayList<V> getValues() {
		ArrayList<V>vers=new ArrayList<V>();
		Iterator<V>it=valuesIterator();	
		while(it.hasNext()) {
			vers.add(it.next());
		}	
		return vers;
	}

	public ArrayList<Object[]> getEdges() {
		ArrayList<Object[]> arrayList =new ArrayList<Object[]>(); 
		Iterator<Edge<V,E>> getEdges = edgeIterator();	
		while(getEdges.hasNext()) {		
			Edge<V,E> edge = getEdges.next();
			Object[] element =new Object[3];		
			element[0]= edge.getWeight();
			element[1]= edge.getInitial().getValue();
			element[2]= edge.getFinall().getValue();			
			arrayList.add(element);
		}
		return arrayList;
	}

	public boolean thereIsEdge(V vertice1, V vertice2) {		
		Vertex<V,E> verticeFirst = getVertex(vertice1);
		Vertex<V,E> verticeSecond = getVertex(vertice2);		
		ArrayList<Edge<V,E>> edges = verticeFirst.getEdges( verticeSecond);		
		if(edges!=null) {
			return true;
		}		
		return false;
	}
	
	@Override
	public boolean isGraphUndirected() {
		return undirected;
	}

	@Override
	public int getAmountVertices() {
		return graph.size();
	}


	public HashMap<V, Vertex<V, E>> getGraph() {
		return graph;
	}

	public void setGraph(HashMap<V, Vertex<V, E>> graph) {
		this.graph = graph;
	}

	public void setUndirected(boolean undirected) {
		this.undirected = undirected;
	}
	
	public boolean isUndirected() {
		return undirected;
	}

	public void setEdges(HashSet<Edge<V, E>> edges) {
		this.edges = edges;
	}
	
	public Iterator<V> valuesIterator() {
		return graph.keySet().iterator();
	}
	
	public Iterator<Edge<V,E>> edgeIterator(){
		return edges.iterator();
	}
	
	public Vertex<V, E> getVertex(V vertex) {
		return graph.get(vertex);
	}
	
	public boolean deleteEdge(V vertice1, V vertice2) {
		return false;
	}

	public boolean deleteVertex(V vertice) {
		return false;
	}

	public boolean thereIsVertex(V vertice) {		
		ArrayList<V> vertex = getValues();
		for (int i = 0; i < vertex.size(); i++) {					
			if (vertex.get(i).equals(vertice)) {
				return true;
			}

		}

		return false;
	}

	public boolean graphIsConnected() {
		return false;
	}
	

	public E getWeight(V vertice1, V vertice2) {		
		if(getVertex(vertice1)==null || getVertex(vertice2)==null) {		
			return null;
		}		
		ArrayList<Edge<V,E>> edges = getVertex(vertice1).getEdges(getVertex(vertice2));		
		if(edges == null) {		
			return null;
		}else {			
			return edges.get(0).getWeight();			
		}
	}
	
	/**
	 * This method is in charge of obtaining all the neighbors given a vertex.
	 * @param vertice - Vertex that you want to know your neighbors.
	 * @return ArrayList<V> - Returns all the neighbors of the given vertex.
	 */
	@Override
	public ArrayList<V> getNeighbors(V vertice) {	
		Vertex<V,E> vertex =graph.get(vertice);
		ArrayList<V> neighbors =new ArrayList<V>();	
		Iterator<Vertex<V,E>> iterator = vertex.neighborIterator();	
		while(iterator.hasNext()) {	
			neighbors.add(iterator.next().getValue());
		}		
		return neighbors;
	}
	
}