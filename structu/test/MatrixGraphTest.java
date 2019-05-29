package test;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;

import graphV.ListGraph;
import graphV.MatrixGraph;
import interfaces.IGraph;

class MatrixGraphTest {
	
IGraph<Integer,Integer> graphM;
	
	public void scenario1() {
		graphM=new MatrixGraph<>(true);
	}
	
	public void scenario2() {
		graphM=new MatrixGraph<>(true);
		graphM.insertVertex(3);
		graphM.insertVertex(4);
	}
	
	public void scenario3() {
		graphM=new ListGraph<Integer,Integer>(true);
		graphM.insertEdge(4,3,4);
		graphM.insertEdge(3,3,2);
		graphM.insertEdge(2,3,5);
		graphM.insertEdge(1,2,4);
		graphM.insertEdge(3,4,7);
	}
	
	public void scenario4() {
		graphM=new ListGraph<Integer,Integer>(true);
		graphM.insertVertex(3);
		graphM.insertVertex(2);
		graphM.insertVertex(1);
		graphM.insertVertex(6);
		graphM.insertVertex(9);
	}


	@Test
	void test0() {
		scenario1();
		assertTrue(graphM.getAmountVertices()==0);
		graphM.insertVertex(3);
		graphM.insertVertex(1);
		assertTrue(graphM.getAmountVertices()==2);
	}
	
	@Test
	void testIsGraphUndirected() {
		scenario1();
		assertTrue(graphM.isGraphUndirected());
	}
	

	@Test
	void testInserEdge() {
		scenario2();
		assertTrue(graphM.insertEdge(4,3,4));
		assertTrue(graphM.insertEdge(3,3,2));
	//	assertFalse(graphL.insertEdge(4,3,4));
		assertTrue(graphM.insertEdge(2,3,7));
		assertTrue(graphM.insertEdge(1,2,4));
		assertTrue(graphM.insertEdge(5,2,7));
		assertTrue(graphM.insertEdge(3,4,7));
		//assertFalse(graphL.insertEdge(4,4,3));
		assertTrue(graphM.insertEdge(7,5,7));
		assertTrue(graphM.getEdges().size()==7);
	}
	
	@Test
	void testThereIsVertex() {
		scenario3();
		assertTrue(graphM.thereIsVertex(3));
		assertTrue(graphM.thereIsVertex(4));
		assertTrue(graphM.thereIsVertex(7));
		assertTrue(graphM.thereIsVertex(5));
		assertFalse(graphM.thereIsVertex(10));
		assertFalse(graphM.thereIsVertex(1));
		
	}
	
	@Test
	void testThereIsEdge() {
		scenario3();
		assertTrue(graphM.thereIsEdge(3,2));
		assertTrue(graphM.thereIsEdge(2,4));
		assertTrue(graphM.thereIsEdge(4,2));
		assertTrue(graphM.thereIsEdge(4,7));
		assertFalse(graphM.thereIsEdge(2,7));
		assertFalse(graphM.thereIsEdge(5,7));
		
	}
	
	@Test
	void testInsertVertex() {
		scenario1();
		graphM.insertVertex(3);
		graphM.insertVertex(4);
		graphM.insertVertex(7);
		graphM.insertVertex(1);
		graphM.insertVertex(9);
		
		assertFalse(graphM.insertVertex(9));
		assertTrue(graphM.insertVertex(10));
		assertTrue(graphM.getAmountVertices()==6);
	}
	
	@Test
	void testGetAmountVertices() {
		scenario4();
		assertTrue(graphM.getAmountVertices()==5);
	}
	
	@Test
	void testgetValues() {
		scenario4();
		ArrayList<Integer> elems= graphM.getValues();
		int[] expected= {1,2,3,6,9};
		
		for(int i=0;i<elems.size();i++)
			assertTrue(elems.get(i).intValue()==expected[i]);
	}
	
}
