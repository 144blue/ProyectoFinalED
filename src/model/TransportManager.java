package model;

import java.util.HashMap;

import graphV.GraphAlgorithms;
import graphV.ListGraph;
import graphV.MatrixGraph;
import graphV.Vertex;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;

public class TransportManager {

	@FXML
	private ObservableList<String> beginList = FXCollections.observableArrayList();
	@FXML
	private ObservableList<String> endList = FXCollections.observableArrayList();
	private Station[] stations;
	private GraphAlgorithms<String, Integer> algoritms;
	private ListGraph<String, Integer> graphNOCambas;
	private MatrixGraph<String, Integer> graphMatrix;

	public TransportManager() {
		initializeGraphS();

	}

	public void initializeGraphS() {
		algoritms = new GraphAlgorithms<>();
		graphNOCambas = new ListGraph<>(true);
		graphMatrix = new MatrixGraph<>(true);

		// *******************LIST GRAPH*************************
		// YELLOW LINE
		graphNOCambas.insertEdge(3, "La Aurora", "Vallejuelos");
		graphNOCambas.insertEdge(3, "Vallejuelos", "San Javier");

		// ORANGE LINE
		graphNOCambas.insertEdge(2, "San Javier", "Santa Lucia");
		graphNOCambas.insertEdge(4, "Santa Lucia", "Estadio");
		graphNOCambas.insertEdge(4, "Estadio", "Cisneros");
		graphNOCambas.insertEdge(15, "Cisneros", "Prado");

		// GREEN LINE
		graphNOCambas.insertEdge(5, "Cisneros", "San José");
		graphNOCambas.insertEdge(5, "San José", "Miraflores");
		graphNOCambas.insertEdge(4, "San José", "Buenos Aires");
		graphNOCambas.insertEdge(4, "Miraflores", "Oriente");
		graphNOCambas.insertEdge(5, "Miraflores", "Buenos Aires");
		graphNOCambas.insertEdge(5, "Buenos Aires", "Trece de Noviembre");
		graphNOCambas.insertEdge(1, "Oriente", "Las Torres");

		// DARK-BLUE/GREE LINE
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

		// TUEQUOISE LINE
		graphNOCambas.insertEdge(3, "San José", "Barrio Colón");
		graphNOCambas.insertEdge(3, "San José", "Catedral Metropolitana");
		graphNOCambas.insertEdge(1, "Barrio Colón", "San Diego");
		graphNOCambas.insertEdge(3, "San Diego", "Nutibara");
		graphNOCambas.insertEdge(2, "Catedral Metropolitana", "Gardel");

		// BLUE LINE
		graphNOCambas.insertEdge(9, "Prado", "Alpujarra");
		graphNOCambas.insertEdge(4, "Alpujarra", "Poblado");
		graphNOCambas.insertEdge(7, "Alpujarra", "Nutibara");
		graphNOCambas.insertEdge(6, "Prado", "Gardel");
		graphNOCambas.insertEdge(5, "Prado", "Caribe");
		graphNOCambas.insertEdge(2, "Caribe", "Niquía");
		graphNOCambas.insertEdge(3, "Prado", "San José");
		graphNOCambas.insertEdge(3, "Alpujarra", "San José");
		graphNOCambas.insertEdge(2, "Alpujarra", "Cisneros");

		// ********************MATRIX GRAPH*************************
		// YELLOW LINE
		graphMatrix.insertEdge(3, "La Aurora", "Vallejuelos");
		graphMatrix.insertEdge(3, "Vallejuelos", "San Javier");

		// ORANGE LINE
		graphMatrix.insertEdge(2, "San Javier", "Santa Lucia");
		graphMatrix.insertEdge(4, "Santa Lucia", "Estadio");
		graphMatrix.insertEdge(4, "Estadio", "Cisneros");
		graphMatrix.insertEdge(15, "Cisneros", "Prado");

		// GREEN LINE
		graphMatrix.insertEdge(5, "Cisneros", "San José");
		graphMatrix.insertEdge(5, "San José", "Miraflores");
		graphMatrix.insertEdge(4, "San José", "Buenos Aires");
		graphMatrix.insertEdge(4, "Miraflores", "Oriente");
		graphMatrix.insertEdge(5, "Miraflores", "Buenos Aires");
		graphMatrix.insertEdge(5, "Buenos Aires", "Trece de Noviembre");
		graphMatrix.insertEdge(1, "Oriente", "Las Torres");

		// DARK-BLUE/GREE LINE
		graphMatrix.insertEdge(14, "Cisneros", "Gardel");
		graphMatrix.insertEdge(14, "Cisneros", "Caribe");
		graphMatrix.insertEdge(4, "Gardel", "Berlin");
		graphMatrix.insertEdge(1, "Berlin", "Parque Aranjuez");
		graphMatrix.insertEdge(3, "Cisneros", "Plaza Mayor");
		graphMatrix.insertEdge(2, "Plaza Mayor", "Nutibara");
		graphMatrix.insertEdge(1, "Nutibara", "Fatima");
		graphMatrix.insertEdge(1, "Fatima", "Los Alpes");
		graphMatrix.insertEdge(1, "Los Alpes", "U. de M.");
		graphMatrix.insertEdge(20, "Gardel", "Plaza Mayor");

		// TUEQUOISE LINE
		graphMatrix.insertEdge(3, "San José", "Barrio Colón");
		graphMatrix.insertEdge(3, "San José", "Catedral Metropolitana");
		graphMatrix.insertEdge(1, "Barrio Colón", "San Diego");
		graphMatrix.insertEdge(3, "San Diego", "Nutibara");
		graphMatrix.insertEdge(2, "Catedral Metropolitana", "Gardel");

		// BLUE LINE
		graphMatrix.insertEdge(9, "Prado", "Alpujarra");
		graphMatrix.insertEdge(4, "Alpujarra", "Poblado");
		graphMatrix.insertEdge(7, "Alpujarra", "Nutibara");
		graphMatrix.insertEdge(6, "Prado", "Gardel");
		graphMatrix.insertEdge(5, "Prado", "Caribe");
		graphMatrix.insertEdge(2, "Caribe", "Niquía");
		graphMatrix.insertEdge(3, "Prado", "San José");
		graphMatrix.insertEdge(3, "Alpujarra", "San José");
		graphMatrix.insertEdge(2, "Alpujarra", "Cisneros");
	}

	public static void main(String[] args) {
		TransportManager tp = new TransportManager();
		tp.initializeGraphS();
		System.out.println(tp.giveBestRouteList("Prado", "La Aurora"));

	}

	public String giveBestRouteList(String end, String origin) {

		ListGraph<String, Integer> tempo = algoritms.dijkstra(graphNOCambas, origin);
		Vertex<String, Integer> destination = tempo.getVertex(end);
		String result = "";
		while (destination != null) {
			result += destination.getValue() + "-";
			destination = destination.getVertexPrevious();
		}

		return result;

	}
	
	public void addStationList() {
		beginList.add("Alpujarra");
		beginList.add("Barrio Colón");
		beginList.add("Berlin");
		beginList.add("Buenos Aires");
		beginList.add("Caribe");
		beginList.add("Catedral Metropolitana");
		beginList.add("Cisneros");
		beginList.add("Estadio");
		beginList.add("Fátima");
		beginList.add("Gardel");
		beginList.add("La Aurora");
		beginList.add("Las Torres");
		beginList.add("Los Alpes");
		beginList.add("Miraflores");
		beginList.add("Niquía");
		beginList.add("Nutibarra");
		beginList.add("Oriente");
		beginList.add("Parque Aranjuez");
		beginList.add("Plaza Mayor");
		beginList.add("Poblado");
		beginList.add("Prado");
		beginList.add("San Diego");
		beginList.add("San Javier");
		beginList.add("San José");
		beginList.add("Santa Lucía");
		beginList.add("Trece de Noviembre");
		beginList.add("U. de M.");
		beginList.add("Vallejuelos");
		
		endList.add("Alpujarra");
		endList.add("Barrio Colón");
		endList.add("Berlin");
		endList.add("Buenos Aires");
		endList.add("Caribe");
		endList.add("Catedral Metropolitana");
		endList.add("Cisneros");
		endList.add("Estadio");
		endList.add("Fátima");
		endList.add("Gardel");
		endList.add("La Aurora");
		endList.add("Las Torres");
		endList.add("Los Alpes");
		endList.add("Miraflores");
		endList.add("Niquía");
		endList.add("Nutibarra");
		endList.add("Oriente");
		endList.add("Parque Aranjuez");
		endList.add("Plaza Mayor");
		endList.add("Poblado");
		endList.add("Prado");
		endList.add("San Diego");
		endList.add("San Javier");
		endList.add("San José");
		endList.add("Santa Lucía");
		endList.add("Trece de Noviembre");
		endList.add("U. de M.");
		endList.add("Vallejuelos");
		
	}

}
