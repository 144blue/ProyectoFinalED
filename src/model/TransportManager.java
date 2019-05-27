package model;

import java.util.HashMap;

import graphV.GraphAlgorithms;
import graphV.ListGraph;
import graphV.MatrixGraph;
import graphV.Vertex;

public class TransportManager {

	private Station[] stations;
	private GraphAlgorithms<String, Integer> algoritms; 
	private ListGraph<String, Integer> graphNOCambas;
	
	
	public TransportManager() {
		initializeGraphS();

	}
	
	public void initializeGraphS() {
		algoritms =new GraphAlgorithms<>();
		graphNOCambas= new ListGraph<>(true);
		
				//YELLOW LINE
				graphNOCambas.insertEdge(3, "La Aurora", "Vallejuelos");
				graphNOCambas.insertEdge(3, "Vallejuelos", "San Javier");
				
				//ORANGE LINE
				graphNOCambas.insertEdge(2, "San Javier", "Santa Lucia");
				graphNOCambas.insertEdge(4, "Santa Lucia", "Estadio");
				graphNOCambas.insertEdge(4, "Estadio", "Cisneros");
				graphNOCambas.insertEdge(15, "Cisneros", "Prado");
				
				//GREEN LINE
				graphNOCambas.insertEdge(5, "Cisneros", "San José");
				graphNOCambas.insertEdge(5, "San José", "Miraflores");
				graphNOCambas.insertEdge(4, "San José", "Buenos Aires");
				graphNOCambas.insertEdge(4, "Miraflores", "Oriente");
				graphNOCambas.insertEdge(5, "Miraflores", "Buenos Aires");
				graphNOCambas.insertEdge(5, "Buenos Aires", "Trece de Noviembre");
				graphNOCambas.insertEdge(1, "Oriente", "Las Torres");
				
				//DARK-BLUE/GREE LINE
				graphNOCambas.insertEdge(14, "Cisneros", "Gardel");
				graphNOCambas.insertEdge(14, "Cisneros", "Caribe");
				graphNOCambas.insertEdge(4, "Gardel", "Berlin");
				graphNOCambas.insertEdge(1, "Berlin", "Parque Aranjuez");
				graphNOCambas.insertEdge(3, "Cisneros", "Plaza Mayor");
				graphNOCambas.insertEdge(2, "Plaza Mayor", "Nutibara");
				graphNOCambas.insertEdge(1, "Nutibara", "Fatima");
				graphNOCambas.insertEdge(1, "Fatima", "Los Alpes");
				graphNOCambas.insertEdge(1, "Los Alpes", "U. de M.");
				graphNOCambas.insertEdge(20, "Gardel", "Plaza Mayor");
					
				//TUEQUOISE LINE
				graphNOCambas.insertEdge(3, "San José", "Barrio Colón");
				graphNOCambas.insertEdge(3, "San José", "Catedral Metropolitana");
				graphNOCambas.insertEdge(1, "Barrio Colón", "San Diego");
				graphNOCambas.insertEdge(3, "San Diego", "Nutibara");
				graphNOCambas.insertEdge(2, "Catedral Metropolitana", "Gardel");
				
				//BLUE LINE
				graphNOCambas.insertEdge(9, "Prado", "Alpujarra");
				graphNOCambas.insertEdge(4, "Alpujarra", "Poblado");
				graphNOCambas.insertEdge(7, "Alpujarra", "Nutibara");
				graphNOCambas.insertEdge(6, "Prado", "Gardel");
				graphNOCambas.insertEdge(5, "Prado", "Caribe");
				graphNOCambas.insertEdge(2, "Caribe", "Niquía");
				graphNOCambas.insertEdge(3, "Prado", "San José");
				graphNOCambas.insertEdge(3, "Alpujarra", "San José");
				graphNOCambas.insertEdge(2, "Alpujarra", "Cisneros");
	}
	
	public static void main(String[] args) {
		TransportManager tp=new TransportManager();
		tp.initializeGraphS();
		System.out.println(tp.giveBestRoute("Prado","La Aurora"));
		
		
	}
	
	public String giveBestRoute(String end, String origin) {
		
		ListGraph<String, Integer> tempo= algoritms.dijkstra(graphNOCambas, origin);
		Vertex<String, Integer> destination= tempo.getVertex(end);
		String result="";
		while (destination!=null) {
			result+= destination.getValue()+"-";
			destination =destination.getVertexPrevious();
		}
		
		return result;
	
	}
	
	
	
}
