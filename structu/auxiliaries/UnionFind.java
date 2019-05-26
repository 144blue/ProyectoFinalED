package auxiliaries;

	public class UnionFind{
	
	private int[] parent;

	public UnionFind(int numberVertices) {
		this.parent = new int[numberVertices];
		for (int i = 0; i < parent.length; i++) {
			parent[i] = i;
		}	
	}
	
	public int findElement(int element) {	
		if (parent[ element ] == element)
		{
			return element;
		} 
		else {
			parent[ element ] = findElement(parent[ element ]);
			return parent[ element ];
		}
	}

	public void unite(int nodo1, int nodo2) {	
		parent[findElement(nodo1)] = findElement(nodo2);
	}
	public int[] getParent() {
		return parent;
	}
	public void setParent(int[] parent) {
		this.parent = parent;
	}
		
}
