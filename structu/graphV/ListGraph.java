package graphV;

	import java.util.ArrayList;
	import java.util.HashMap;
	import java.util.HashSet;
	import java.util.Iterator;
	import interfaces.IGraph;

	/**
	 * This class is a representation of a graph with an Adjacency List.
	 * @author juanmgarcia97, vardo159 & 144blue.
	 *
	 * @param <V> generic value representing the vertex of a graph.
	 * @param <E> generic value representing the edge of a graph.
	 */
	public class ListGraph<V, E extends Comparable<E>> implements IGraph<V,E> {

	private boolean undirected;
	private HashMap<V,Vertex<V,E>> graph;
	private HashSet<Edge<V,E>> edges;
	
	/**
	 * This is the constructor of the class, it creates a graph list and initializes all the attributes and relationships it has.
	 * @param undirected true or false, defining whether the graph is undirected or directed, respectively.
	 */
	public ListGraph(boolean undirected) {
		this.graph = new HashMap<V,Vertex<V,E>>();
		this.edges = new HashSet<Edge<V,E>>();
		this.undirected = undirected;
	}
	
	/* (non-Javadoc)
	 * @see interfaces.IGraph#insertVertex(java.lang.Object)
	 */
	public boolean insertVertex(V vert) {
		Vertex<V,E> vertFirst = null;	
		if(graph.containsKey(vert)) {	
			return false;
		}else {			
			vertFirst=new Vertex<V,E>(vert);
			graph.put(vert,vertFirst);
			return true;		
		}	
	}

	/* (non-Javadoc)
	 * @see interfaces.IGraph#insertEdge(java.lang.Object, java.lang.Object, java.lang.Object)
	 */
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

	/* (non-Javadoc)
	 * @see interfaces.IGraph#getValues()
	 */
	public ArrayList<V> getValues() {
		ArrayList<V>vers=new ArrayList<V>();
		Iterator<V>it=valuesIterator();	
		while(it.hasNext()) {
			vers.add(it.next());
		}	
		return vers;
	}

	/* (non-Javadoc)
	 * @see interfaces.IGraph#getEdges()
	 */
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

	/* (non-Javadoc)
	 * @see interfaces.IGraph#thereIsEdge(java.lang.Object, java.lang.Object)
	 */
	public boolean thereIsEdge(V vertice1, V vertice2) {		
		Vertex<V,E> verticeFirst = getVertex(vertice1);
		Vertex<V,E> verticeSecond = getVertex(vertice2);		
		ArrayList<Edge<V,E>> edges = verticeFirst.getEdges( verticeSecond);		
		if(edges!=null) {
			return true;
		}		
		return false;
	}
	
	/* (non-Javadoc)
	 * @see interfaces.IGraph#isGraphUndirected()
	 */
	@Override
	public boolean isGraphUndirected() {
		return undirected;
	}

	/* (non-Javadoc)
	 * @see interfaces.IGraph#getAmountVertices()
	 */
	@Override
	public int getAmountVertices() {
		return graph.size();
	}


	/**
	 * This method returns the HashMap that stores all the vertices of the graph.
	 * @return returns the vertices present in the graph.
	 */
	public HashMap<V, Vertex<V, E>> getGraph() {
		return graph;
	}

	/**
	 * This method modifies the HashMap that contains all the vertices of the graph.
	 * @param graph new HashMap that contains all the vertices of the graph.
	 */
	public void setGraph(HashMap<V, Vertex<V, E>> graph) {
		this.graph = graph;
	}

	/**
	 * @param undirected
	 */
	public void setUndirected(boolean undirected) {
		this.undirected = undirected;
	}
	
	/**
	 * @return
	 */
	public boolean isUndirected() {
		return undirected;
	}

	/**
	 * @param edges
	 */
	public void setEdges(HashSet<Edge<V, E>> edges) {
		this.edges = edges;
	}
	
	/**
	 * @return
	 */
	public Iterator<V> valuesIterator() {
		return graph.keySet().iterator();
	}
	
	/**
	 * @return
	 */
	public Iterator<Edge<V,E>> edgeIterator(){
		return edges.iterator();
	}
	
	/**
	 * @param vertex
	 * @return
	 */
	public Vertex<V, E> getVertex(V vertex) {
		return graph.get(vertex);
	}
	
	/* (non-Javadoc)
	 * @see interfaces.IGraph#deleteEdge(java.lang.Object, java.lang.Object)
	 */
	public boolean deleteEdge(V vertice1, V vertice2) {
		return false;
	}

	/* (non-Javadoc)
	 * @see interfaces.IGraph#deleteVertex(java.lang.Object)
	 */
	public boolean deleteVertex(V vertice) {
		return false;
	}

	/* (non-Javadoc)
	 * @see interfaces.IGraph#thereIsVertex(java.lang.Object)
	 */
	public boolean thereIsVertex(V vertice) {		
		ArrayList<V> vertex = getValues();
		for (int i = 0; i < vertex.size(); i++) {					
			if (vertex.get(i).equals(vertice)) {
				return true;
			}

		}

		return false;
	}

	/* (non-Javadoc)
	 * @see interfaces.IGraph#graphIsConnected()
	 */
	public boolean graphIsConnected() {
		return false;
	}
	

	/* (non-Javadoc)
	 * @see interfaces.IGraph#getWeight(java.lang.Object, java.lang.Object)
	 */
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
	/* (non-Javadoc)
	 * @see interfaces.IGraph#getNeighbors(java.lang.Object)
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