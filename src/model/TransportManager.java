package model;

import graphV.GraphAlgorithms;
import graphV.MatrixGraph;

public class TransportManager {

	private Station[] stations;
	private GraphAlgorithms<Integer, Integer> algoritms; 
	private MatrixGraph<Integer, Integer> graphNOCambas;
	
	public TransportManager() {
		
		algoritms =new GraphAlgorithms<>();
		graphNOCambas= new MatrixGraph<>(true);
		
		
	}
	
	public static void main(String[] args) {
		
	
	}
	
	public void giveBestRoute() {
		
	}
	
	
	
}
