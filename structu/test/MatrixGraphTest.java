package test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import graphV.ListGraph;
import graphV.MatrixGraph;
import interfaces.IGraph;

class MatrixGraphTest {
	
IGraph<Integer,Integer> graphL;
	
	public void scenario1() {
		graphL=new MatrixGraph<>(true);
	}
	
	public void scenario2() {
		graphL=new MatrixGraph<>(true);
		graphL.insertVertex(3);
		graphL.insertVertex(4);
	}
	

	@Test
	void test0() {
		scenario1();
		assertTrue(graphL.getAmountVertices()==0);
		graphL.insertVertex(3);
		graphL.insertVertex(1);
		assertTrue(graphL.getAmountVertices()==2);
	}
	

	@Test
	void testInserEdge() {
		scenario2();
		assertTrue(graphL.insertEdge(4,3,4));
		assertTrue(graphL.insertEdge(3,3,2));
	//	assertFalse(graphL.insertEdge(4,3,4));
		assertTrue(graphL.insertEdge(2,3,7));
		assertTrue(graphL.insertEdge(1,2,4));
		assertTrue(graphL.insertEdge(5,2,7));
		assertTrue(graphL.insertEdge(3,4,7));
		//assertFalse(graphL.insertEdge(4,4,3));
		assertTrue(graphL.insertEdge(7,5,7));
		assertTrue(graphL.getEdges().size()==7);
	}
	
	@Test
	void testInsertVertex() {
		scenario1();
		graphL.insertVertex(3);
		graphL.insertVertex(4);
		graphL.insertVertex(7);
		graphL.insertVertex(1);
		graphL.insertVertex(9);
		
		assertFalse(graphL.insertVertex(9));
		assertTrue(graphL.insertVertex(10));
		assertTrue(graphL.getAmountVertices()==6);
	}
	
}
