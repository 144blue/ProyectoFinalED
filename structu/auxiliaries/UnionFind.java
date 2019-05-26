package auxiliaries;

/**
 * @author juanmgarcia97, vardo159 & 144blue This class is responsible for
 *         making the union of sets.
 *
 */
public class UnionFind {

	private int[] parent;

	/**
	 * This is the constructor method for the class that initialize the parent array.
	 * @param numberVertices integer that represent the number of vertices in the graph.
	 */
	public UnionFind(int numberVertices) {
		this.parent = new int[numberVertices];
		for (int i = 0; i < parent.length; i++) {
			parent[i] = i;
		}
	}

	/**
	 * Recursive method that searches for the vertex in the set.
	 * @param element integer that represent the vertex number in the set.
	 * @return element integer that represent the vertex in the set.
	 */
	public int findElement(int element) {
		if (parent[element] == element) {
			return element;
		} else {
			parent[element] = findElement(parent[element]);
			return parent[element];
		}
	}

	/**
	 * This method unite two different sets.
	 * @param nodo1 
	 * @param nodo2
	 */
	public void unite(int nodo1, int nodo2) {
		parent[findElement(nodo1)] = findElement(nodo2);
	}

	/**
	 * This method returns the parent array
	 * @return integer array that represent the sets.
	 */
	public int[] getParent() {
		return parent;
	}

	/**
	 * This method replaces the sets.
	 * @param parent integer array.
	 */
	public void setParent(int[] parent) {
		this.parent = parent;
	}

}
