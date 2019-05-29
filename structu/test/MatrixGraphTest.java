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
	

}
