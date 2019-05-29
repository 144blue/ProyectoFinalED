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
