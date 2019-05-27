package test;

import static org.junit.jupiter.api.Assertions.*;

import java.util.HashMap;

import org.junit.jupiter.api.Test;

import auxiliaries.ExchangePair;
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
	
	public void scenario2() {
		graph=new ListGraph<Integer, Integer>(true);
		meths=new GraphAlgorithms<Integer,Integer>();
		graph.insertEdge(1,1,2);
		graph.insertEdge(4,1,3);
		graph.insertEdge(3,2,4);
		graph.insertEdge(1,3,4);
		graph.insertEdge(2,5,1); 
		graph.insertEdge(3,5,2);
		graph.insertEdge(3,5,3);
		graph.insertEdge(2,5,4);
	}

	public void scenario3() {
		graph=new ListGraph<Integer, Integer>(true);
		meths=new GraphAlgorithms<Integer,Integer>();
		graph.insertEdge(100,0,1);
		graph.insertEdge(200,0,2);
		graph.insertEdge(25,0,4);
		graph.insertEdge(96,0,3);
		graph.insertEdge(87,1,3);
		graph.insertEdge(78,1,2);
		graph.insertEdge(85,2,4);
		graph.insertEdge(312,3,4);
	}
	
	public void scenario4() {
		graph=new ListGraph<Integer, Integer>(true);
		meths=new GraphAlgorithms<Integer,Integer>();
		graph.insertEdge(15,1,7);
		graph.insertEdge(14,1,3);
		graph.insertEdge(12,3,5);
		graph.insertEdge(3,1,5);
		graph.insertEdge(4,5,8);
		graph.insertEdge(3,5,2);
	}

	@Test
	void bfsTest() {
		scenario1();
		ListGraph<Integer, Integer> aux=meths.bfs(graph, 1);
		Vertex<Integer,Integer> ver = aux.getVertex(3);
		int[] expc= {3,5,1};
		int cont=0;
		
	//	System.out.println(ver.getVertexPrevious().getValue());
		
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
		Vertex<Integer,Integer> ver = aux.getVertex(2);
		Vertex<Integer,Integer> init = ver.getAncestors().get(0);
		int i=0;
		
		while( i<3) {		
			System.out.println(init.getValue());
			init=init.getVertexPrevious();
			i++;
		}
	}
	
	@Test
	void dijkstraTest() {
		scenario4();
		ListGraph<Integer, Integer> aux=meths.dijkstra(graph, 8);
		Vertex<Integer,Integer> ver = aux.getVertex(1);
		int[] expc= {1,5,8,8};
		int cont=0;

		while( ver!=null) {		
			assertTrue(ver.getValue()==expc[cont]);
			ver=ver.getVertexPrevious();
			cont++;
		}
	}
	
	@Test 
	void floydWarshallTest() {
		scenario3();
		HashMap<ExchangePair<Integer,Integer>,Double> aux=meths.floydWarshall(graph);
		double[][] matrixExpc= {{0,100,110,96,25}, {100,0,78,87,125},{110,78,0,165,85},{96,87,165,0,121},{25,125,85,121,0}};
		
		for (int i = 0; i < matrixExpc.length; i++) {
			for (int j = 0; j < matrixExpc.length; j++) {
				assertTrue(matrixExpc[i][j]==aux.get(new ExchangePair<Integer,Integer>(i,j)));
			}
		}	
	}
	
	@Test
	void primTest() {
		scenario2();
		ListGraph<Integer, Integer> aux=meths.prim(graph,1);
		Vertex<Integer,Integer> ver = aux.getVertex(3);
		int[] expc= {3,4,5,1};
		int cont=0;
		
		while( ver!=null) {		
			assertTrue(ver.getValue()==expc[cont]);
			ver=ver.getVertexPrevious();
			cont++;
		}
	}
	
	@Test
	void kruskalTest() {
		scenario2();
		ListGraph<Integer, Integer> aux=meths.bfs(meths.kruskal(graph), 1);
		Vertex<Integer,Integer> ver = aux.getVertex(2);
		int[] expc= {2,1};
		int cont=0;
		
		while( ver!=null) {		
			assertTrue(ver.getValue()==expc[cont]);
			ver=ver.getVertexPrevious();
			cont++;
		}
	}
	

}
