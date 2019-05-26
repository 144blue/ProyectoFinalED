package graphV;

	import java.util.ArrayList;
	import java.util.Collections;
	import java.util.HashMap;
	import java.util.Iterator;
	import java.util.LinkedList;
	import auxiliaries.ComparatorG;
	import auxiliaries.ExchangePair;
	import auxiliaries.UnionFind;
	import interfaces.IGraph;
	import minHeapG.MinHeapG;

	public class Graph<V,E extends Comparable<E>> {

	public ListGraph<V,E> dfs(IGraph<V, E> graph) {
		ListGraph<V,E> listsDFS = new ListGraph<V,E>( graph.isGraphUndirected());
		ArrayList<Object[]> edges = graph.getEdges();
		for (int i = 0; i < edges.size(); i++) {		
			listsDFS.insertEdge((E)edges.get(i)[0],(V)edges.get(i)[1],(V)edges.get(i)[2]);	
		}
		Iterator<V> iterator = listsDFS.valuesIterator();		
		while( iterator.hasNext()) {		
			V elementV = iterator.next();
			Vertex<V,E> vertexFirst = listsDFS.getVertex( elementV);			
			if( vertexFirst.getKey()==0) {		
				auxDFS( vertexFirst );
			}
		}
		return listsDFS;
	}
	
	public ListGraph<V,E> bfs(IGraph<V,E> graph ,V vertex) {
		ListGraph<V,E> listBFS = new ListGraph<V,E>( graph.isGraphUndirected());
		ArrayList<Object[]> edges = graph.getEdges();
		for (int i = 0; i < edges.size(); i++) {	
			listBFS.insertEdge((E)edges.get(i)[0],(V)edges.get(i)[1],(V)edges.get(i)[2]);	
		}
		LinkedList<Vertex<V,E>> queue = new LinkedList<Vertex<V,E>>();
		Vertex<V,E> init= listBFS.getVertex(vertex);
		init.setKey(1);
		queue.addFirst(init);	
		while(!queue.isEmpty()) {		
			Vertex<V,E> elementV =queue.removeLast();
			Iterator<Vertex<V,E>> iterator = elementV.neighborIterator();		
			while( iterator.hasNext()) {			
				Vertex<V,E> vertex2 = iterator.next();			
				if( vertex2.getKey()==0) {				
					vertex2.setVertexPrevious( elementV );
					vertex2.setKey(1);
					queue.addFirst( vertex2 );
				}
			}
		}
		return listBFS;
	}
	
	public ListGraph<V,E> dijkstra(IGraph<V, E> graph ,V vertex) {
		ListGraph<V,E> listDijkstra = new ListGraph<V,E>(graph.isGraphUndirected());
		ArrayList<Object[]> edges = graph.getEdges();		
		for (int i = 0; i < edges.size(); i++) {		
			listDijkstra.insertEdge((E)edges.get(i)[0],(V)edges.get(i)[1],(V)edges.get(i)[2]);	
		}		
		ArrayList<Vertex<V,E>> vertices = new ArrayList<Vertex<V,E>>();
		ArrayList<V>values = listDijkstra.getValues();		
		for (int i = 0; i < values.size(); i++) {		
			vertices.add( listDijkstra.getVertex(values.get(i)));
		}		
		listDijkstra.getVertex( vertex ).setInfinite(0);		
		MinHeapG<V,E> priority = new MinHeapG<V,E>(vertices);		
		while(!priority.isEmpty()) {		
			Vertex<V,E> vertex2 = priority.extractMin();
			Iterator<Vertex<V,E>> iterator = vertex2.neighborIterator();			
			while( iterator.hasNext()) {			
				Vertex<V,E> vertex3 = iterator.next();
				E lab= vertex2.getEdges( vertex3 ).get(0).getWeight();			
				if((Double.valueOf(lab.toString()))+ vertex2.getInfinite() < vertex3.getInfinite()) {				
					vertex3.setVertexPrevious( vertex2);
					priority.decreaseKey( vertex3,Double.valueOf(lab.toString())+ vertex2.getInfinite());
				}
			}
		}
		return listDijkstra;
	}

	public HashMap<ExchangePair<V,V>,Double> floydWarshall(IGraph<V, E> graph) {
		
		ArrayList<V> values = graph.getValues();
		HashMap<ExchangePair<V,V>,Double> matrix = new HashMap<>();		
		
		for (int i = 0; i < values.size(); i++) {	
			for (int j = 0; j < values.size(); j++) {			
				ExchangePair<V,V> pair = new ExchangePair<>(values.get(i),values.get(j));
				if(!matrix.containsKey(pair)) {	
					E label = graph.getWeight(values.get(i),values.get(j));
					double valueMAX = 0;					
					if(label == null) {					
						if(!values.get(i).equals(values.get(j))) {
							valueMAX = Double.MAX_VALUE;
						}
					}
					else {
						valueMAX = Double.parseDouble(label.toString());
					}					
					matrix.put(pair, valueMAX);
				}
			}
		}
		
		for (int k = 0; k < values.size(); k++) {		
		for (int i = 0; i < values.size(); i++) {	
		for (int j = 0; j < values.size(); j++) {				
		if(i!=j && k!=i && k!=j) {
					
		ExchangePair<V,V> exchange1 = new ExchangePair<>(values.get(i),values.get(j));
		ExchangePair<V,V> exchange2 = new ExchangePair<>(values.get(i),values.get(k));				
		ExchangePair<V,V> exchange3 = new ExchangePair<>(values.get(k),values.get(j));
						
		Double dis1 = matrix.get( exchange1 );
		Double dis2 = matrix.get( exchange2 );
		Double dis3 = matrix.get( exchange3 );
						
					if( dis1 > dis2+dis3 ) {						
					matrix.replace(exchange1 , dis2+dis3);
							}
						}
					}
				}
			}		
		return matrix;
	}

	/**
	 * This method is responsible for running the Kruskal algorithm within the graph.
	 * @param graph - The graph that we are using
	 * @return listKruskal - Returns a new graph (Graph adjacency list) with the algorithms already executed.
	 */
	public ListGraph<V,E> kruskal(IGraph<V, E> graph) {
	
		ListGraph<V,E> listKruskal = new ListGraph<V,E>( graph.isGraphUndirected() );	
		ArrayList<Object[]> edges = graph.getEdges();
		
		HashMap<V,Integer> theValuesToIntegers = new HashMap<V,Integer>();	
		Collections.sort(edges,new ComparatorG<E>());	
		int actVal=0;	
		UnionFind unionRelation = new UnionFind( graph.getAmountVertices());
	
		for (int i = 0; i < edges.size(); i++) {
			V firsElement = (V) edges.get(i)[1];
			V secondElement = (V) edges.get(i)[2];		
			int first = 0;
			int second = 0;			
			if(!theValuesToIntegers.containsKey( firsElement )) {			
				theValuesToIntegers.put(firsElement ,actVal);
				first = actVal;
				actVal++;
			}else {			
				first = theValuesToIntegers.get( firsElement );
			}			
			if(!theValuesToIntegers.containsKey( secondElement )) {				
				theValuesToIntegers.put( secondElement ,actVal);
				second = actVal;
				actVal++;
			}
			else {				
				second = theValuesToIntegers.get( secondElement );
			}			
			if( unionRelation.findElement(first) != unionRelation.findElement(second)) {			
				listKruskal.insertEdge((E) edges.get(i)[0],(V)edges.get(i)[1],(V)edges.get(i)[2]);	
				unionRelation.unite( first , second );
			}
		}
		return listKruskal;
	}

	/**
	 * This method is responsible for running the prim algorithm within the graph.
	 * @param graph - The graph that we are using
	 * @param vertex - Represents the vertex where you are going to start doing the prim
	 * @return listPrim - Returns a new graph (Graph adjacency list) with the algorithms already executed.
	 */

	public ListGraph<V,E> prim(IGraph<V, E> graph ,V vertex) {

		ListGraph<V,E> listPrim = new ListGraph<V,E>( graph.isGraphUndirected());
		ArrayList<Object[]> edges = graph.getEdges();
		for (int i = 0; i < edges.size(); i++) {
			listPrim.insertEdge((E)edges.get(i)[0],(V)edges.get(i)[1],(V)edges.get(i)[2]);	
		}	
		ArrayList<Vertex<V,E>>vertices=new ArrayList<Vertex<V,E>>();
		ArrayList<V>values = listPrim.getValues();		
		for (int i = 0; i < values.size(); i++) {		
			vertices.add( listPrim.getVertex(values.get(i)));
		}		
		listPrim.getVertex( vertex ).setInfinite(0);		
		MinHeapG<V,E> priorityQueue=new MinHeapG<V,E>(vertices);
		
		while(!priorityQueue.isEmpty()) {	
			Vertex<V,E> u=priorityQueue.extractMin();
			Iterator<Vertex<V,E>> it=u.neighborIterator();	
			while(it.hasNext()) {		
				Vertex<V,E> w=it.next();
				E lab=u.getEdges(w).get(0).getWeight();				
				if(priorityQueue.contains(w)&&Double.valueOf(lab.toString())<w.getInfinite()) {				
					w.setVertexPrevious(u);
					priorityQueue.decreaseKey(w,Double.valueOf(lab.toString()));
				}
			}
		}
		return listPrim;
	}

	private void auxDFS(Vertex<V, E> vertex) {	
		vertex.setKey(1);
		Iterator<Vertex<V,E>> iterator = vertex.neighborIterator();	
		while( iterator.hasNext()) {
			Vertex<V,E> vertexFirst = iterator.next();
			Vertex<V,E> vertexSecond = vertexFirst;			
			if(vertexSecond.getKey()==0) {	
				vertexSecond.setVertexPrevious( vertex );
				auxDFS( vertexSecond );
			}
			else if(vertexSecond.getKey() == 1 && vertex.getVertexPrevious() != vertexSecond){			
				vertexSecond.addAncestor(vertex);
			}
		}		
		vertex.setKey(2);
	}

}