package minHeapG;

	import java.util.ArrayList;
	import java.util.HashMap;
	import graphV.Vertex;

	public class MinHeapG<V,E extends Comparable<E>>{
		
	private HashMap<Vertex<V,E>,Integer> vertexGraph;
	private Vertex<V,E>[] vertex;	
	private int size;

	public MinHeapG(ArrayList<Vertex<V,E>> arrayVertex){
		this.vertex = new Vertex[ arrayVertex.size() ];		
		this.size = arrayVertex.size()-1;		
		this.vertexGraph = new HashMap<Vertex<V,E>,Integer>();
		for (int i = 0; i < vertex.length; i++) {
			vertex[i] = arrayVertex.get(i);	
			vertexGraph.put(arrayVertex.get(i),i);
		}
		createMinHeap();
	}
	
	public Vertex<V,E> extractMin() {
		Vertex<V,E> min = vertex [0];
		vertexGraph.remove(min);
		vertex[0] = vertex[ size ];
		size--;		
		minHeapify(0);
		return min;
	}
	
	private void minHeapify(int data) {
		int left = 2*data+1;		
		int right =2*data+2;
		int elementMoreSmall = -1;
		if( left <= size && vertex[ left ].getInfinite() < vertex[ data ].getInfinite()){
			elementMoreSmall = left;
		}else{
			elementMoreSmall = data;
		}
		if( right <= size && vertex[ right ].getInfinite()<vertex[elementMoreSmall].getInfinite()){
			elementMoreSmall = right;
		}
		if(elementMoreSmall!= data){	
			vertexGraph.replace(vertex[ data ],  elementMoreSmall);
			vertexGraph.replace(vertex[ elementMoreSmall ], data);
			Vertex<V,E> temp=vertex[ data ];
			vertex[ data ]=vertex[ elementMoreSmall ];
			vertex[ elementMoreSmall ]=temp;
			minHeapify(  elementMoreSmall );
		}
	}
	
	public boolean contains(Vertex<V,E> vertex) {
		return vertexGraph.containsKey(vertex);
	}
	
	public void decreaseKey(Vertex<V,E> v, double d){
		int i = vertexGraph.get(v);	
		vertex[i].setInfinite(d);
		int parent=(int) Math.ceil((i/2.0)-1);
		while(i > 0 && vertex[parent].getInfinite( )> vertex[i].getInfinite()){
			vertexGraph.replace(vertex[parent],i);		
			vertexGraph.replace(vertex[i],parent);
			Vertex<V,E> temp= vertex[parent];
			vertex[parent]=vertex[i];
			vertex[i] = temp;
			i=parent;
			parent=(int) Math.ceil((parent/2.0)-1);
		}
	}

	private void createMinHeap(){
		for (int i = (vertex.length/2)-1 ; i >= 0; i--) {
			minHeapify(i);
		}
	}
	
	public boolean isEmpty() {
		return size == -1;
	}

	public HashMap<Vertex<V, E>, Integer> getVertexGraph() {
		return vertexGraph;
	}

	public void setVertexGraph(HashMap<Vertex<V, E>, Integer> vertexGraph) {
		this.vertexGraph = vertexGraph;
	}

	public Vertex<V, E>[] getVertex() {
		return vertex;
	}

	public void setVertex(Vertex<V, E>[] vertex) {
		this.vertex = vertex;
	}

	public int getSize() {
		return size;
	}

	public void setSize(int size) {
		this.size = size;
	}
	
}