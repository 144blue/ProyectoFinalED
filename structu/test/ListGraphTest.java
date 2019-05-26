package test;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;

import graphV.ListGraph;
import interfaces.IGraph;

class ListGraphTest {
	
	IGraph<Integer,Integer> graphL;
	
	public void scenario1() {
		graphL=new ListGraph<Integer,Integer>(true);
	}
	
	public void scenario2() {
		graphL=new ListGraph<Integer,Integer>(true);
		graphL.insertVertex(3);
		graphL.insertVertex(4);
	}
	
	public void scenario3() {
		graphL=new ListGraph<Integer,Integer>(true);
		graphL.insertEdge(4,3,4);
		graphL.insertEdge(3,3,2);
		graphL.insertEdge(2,3,5);
		graphL.insertEdge(1,2,4);
		graphL.insertEdge(3,4,7);
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
	
	@Test
	void testInserEdge() {
		scenario2();
		assertTrue(graphL.insertEdge(4,3,4));
		assertTrue(graphL.insertEdge(3,3,2));
		assertFalse(graphL.insertEdge(4,3,4));
		assertTrue(graphL.insertEdge(2,3,7));
		assertTrue(graphL.insertEdge(1,2,4));
		assertTrue(graphL.insertEdge(5,2,7));
		assertTrue(graphL.insertEdge(3,4,7));
		assertFalse(graphL.insertEdge(4,4,3));
		assertTrue(graphL.insertEdge(7,5,7));
		assertTrue(graphL.getEdges().size()==7);
	}
	
	@Test
	void testThereIsEdge() {
		scenario3();
		assertTrue(graphL.thereIsEdge(3,2));
		assertTrue(graphL.thereIsEdge(2,4));
		assertTrue(graphL.thereIsEdge(4,2));
		assertTrue(graphL.thereIsEdge(4,7));
		assertFalse(graphL.thereIsEdge(2,7));
		assertFalse(graphL.thereIsEdge(5,7));
		
	}
	
	@Test
	void testThereIsVertex() {
		scenario3();
		assertTrue(graphL.thereIsVertex(3));
		assertTrue(graphL.thereIsVertex(4));
		assertTrue(graphL.thereIsVertex(7));
		assertTrue(graphL.thereIsVertex(5));
		assertFalse(graphL.thereIsVertex(10));
		assertFalse(graphL.thereIsVertex(1));
		
	}
	
	

}
