package test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import graphV.GraphAlgorithms;
import graphV.ListGraph;
import graphV.Vertex;
import interfaces.IGraph;

class GraphAlgorithmsTest {
	
	private GraphAlgorithms<String, Integer> meths2;
	private IGraph<String, Integer> graph2;
	
	private GraphAlgorithms<Integer, Integer> meths;
	private IGraph<Integer, Integer> graph;
	
	public void scenario1() {
		graph=new ListGraph<Integer, Integer>(true);
		meths=new GraphAlgorithms<Integer,Integer>();
		graph.insertEdge(4,3,4);
		graph.insertEdge(3,3,2);
		graph.insertEdge(2,3,5);
		graph.insertEdge(1,2,4);
		graph.insertEdge(5,2,7); 
		graph.insertEdge(3,4,7);
		graph.insertEdge(7,5,7);
		graph.insertEdge(2,1,7);
		graph.insertEdge(2,1,5);
	}

	@Test
	void bfsTest() {
		scenario1();
		ListGraph<Integer, Integer> aux=meths.bfs(graph, 1);
		Vertex<Integer,Integer> ver = aux.getVertex(3);
		int[] expc= {3,5,1};
		int cont=0;
		
		System.out.println(ver.getVertexPrevious().getValue());
		
		while( ver!=null) {		
			assertTrue(ver.getValue()==expc[cont]);
			ver=ver.getVertexPrevious();
			cont++;
		}
	}
	
	@Test
	void dfsTest() {
		scenario1();
		ListGraph<Integer, Integer> aux=meths.dfs(graph);
		Vertex<Integer,Integer> ver = aux.getVertex(3);
		int i=0;
		
	}
	

}
