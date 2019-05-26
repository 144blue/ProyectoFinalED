package interfaces;

import java.util.ArrayList;

	public interface IGraph<V, E> {
		public E getWeight(V v1,V v2);
		public boolean insertVertex(V v);
		public int getAmountVertices();
		public boolean insertEdge(E edge, V v1, V v2);
		public boolean isGraphUndirected();
		public ArrayList<V> getNeighbors(V v);
		public boolean thereIsVertex(V v);
		public boolean thereIsEdge(V v1,V v2);
		public boolean deleteVertex(V v);
		public ArrayList<Object[]> getEdges();
		public boolean deleteEdge(V v1, V v2);
		public ArrayList<V> getValues();
		public boolean graphIsConnected();
}