package graphV;

	import java.util.ArrayList;
import java.util.HashMap;

import interfaces.IBasicMethodsGraph;
	
	public class MatrixGraph<V, E extends Comparable<E>> implements IBasicMethodsGraph<V,E> {

	
	private HashMap<Integer, V> intToValue;
	private HashMap<V, Integer> valueToint;
	private boolean undirected;
	private ArrayList<E>[][] edges;

	public MatrixGraph(boolean undirected) {	
		this.undirected = undirected;
		this.edges = new ArrayList[0][0];
		this.intToValue = new HashMap<Integer, V>();
		this.valueToint = new HashMap<V, Integer> ();
	}
	
	public boolean insertEdge(E edge, V vertice1, V vertice2) {
		if(!valueToint.containsKey(vertice1)) {			
			expandAdjacencyMatrix(vertice1);
		}if(!valueToint.containsKey(vertice2)) {		
			expandAdjacencyMatrix(vertice2);
		}		
			edges[ valueToint.get(vertice1) ][ valueToint.get(vertice2) ].add(edge);
		return true;
	}

	public void expandAdjacencyMatrix(V vertice) {	
		ArrayList<E>[][] matrixAux = new ArrayList[ this.edges.length+1 ][ this.edges.length+1 ] ;	
		valueToint.put(vertice, matrixAux.length-1);	
		intToValue.put(matrixAux.length-1, vertice);	
		for (int i = 0; i < matrixAux.length; i++) {		
			for (int j = 0; j < matrixAux.length; j++) {
				matrixAux[i][j] = new ArrayList<E>();
			}			
		}	
		for (int i = 0; i < edges.length; i++) {
			for (int j = 0; j < edges.length; j++) {			
				matrixAux[i][j]=edges[i][j];
			}
		}	
		edges=matrixAux;	
	}
	
	public V getValue(int vertice) {
		return intToValue.get(vertice);
	}

	public ArrayList<E>[][] getEdgesArray() {
		return this.edges;
	}
	
	public ArrayList<V> getValues() {	
		ArrayList<V> values = new ArrayList<V> ();	
		for (int i = 0; i < edges.length; i++) {		
			values.add(intToValue.get(i));	
		}
		return values;
	}
	
	public ArrayList<Object[]> getEdges() {		
		ArrayList<Object[]> auxiliar = new ArrayList<Object[]>();		
		for (int i = 0; i < edges.length; i++) {		
			 for (int j = 0; j < edges.length; j++) {			 
				 if(!edges[i][j].isEmpty()) {
					 auxiliar.add(new Object[]{edges[i][j].get(0),intToValue.get(i),intToValue.get(j)});					 
				 }
			}		
		}
		return auxiliar;
	}
	
	public int getInteger(V vertice) throws Exception{		
		if(valueToint.containsKey(vertice)) {			
			return valueToint.get(vertice);
		}else {		
			throw new Exception("El valor que busca dentro del grafo no se ha encontrado.");
		}
			
	}
	
	public boolean insertVertex(V vertice) {	
		if(!valueToint.containsKey( vertice)) {		
			this.expandAdjacencyMatrix( vertice);
			return true;
		}else		
		return false;
	}
	
	public E getWeight(V vertice1, V vertice2) {
		
		if(valueToint.containsKey(vertice1) && valueToint.containsKey(vertice2)) {		
			return (E) edges[valueToint.get(vertice1)][valueToint.get(vertice2)].get(0);
		}else		
			return null;
		
	}
	
	public boolean thereIsEdge(V vertice1, V vertice2) {		
		int i = valueToint.get(vertice1);
		int j = valueToint.get(vertice2);		
		return !edges[i][j].isEmpty();
	}
	
	public ArrayList<V> getNeighbors(V vertice) {
		ArrayList<V>  auxiliar = new ArrayList<V>();	
		int neighbor = valueToint.get(vertice);	
		for (int i = 0; i < edges.length; i++) {	
			if(edges[ neighbor ][i].size()!=0) {
				auxiliar.add(intToValue.get(i));
			}
		}	
		return auxiliar;
	}
	
	public boolean isGraphUndirected() {
		return undirected;
	}
	
	public int getAmountVertices() {
		return edges.length;
	}
	
	public boolean thereIsVertex(V vertice) {
		ArrayList<V> elementos = getValues();
		for (int i = 0; i < elementos.size(); i++) {
			if (  elementos.get(i).equals(vertice) ) {
				return true;
			}			
		}
		return true;
	}
	
	public boolean deleteEdge(V vertice1, V vertice2) {
		return false;
	}

	public boolean deleteVertex(V vertice) {
		return false;
	}

	public boolean graphIsConnected() {
		return false;
	}
	
	public HashMap<Integer, V> getIntToValue() {
		return intToValue;
	}

	public void setIntToValue(HashMap<Integer, V> intToValue) {
		this.intToValue = intToValue;
	}

	public HashMap<V, Integer> getValueToint() {
		return valueToint;
	}

	public void setValueToint(HashMap<V, Integer> valueToint) {
		this.valueToint = valueToint;
	}
	
	public void setUndirected(boolean undirected) {
		this.undirected = undirected;
	}

	public void setEdges(ArrayList<E>[][] edges) {
		this.edges = edges;
	}

	public boolean isUndirected() {
		return undirected;
	}
	
}