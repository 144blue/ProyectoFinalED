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

	
	private Station[] stations;
	private GraphAlgorithms<String, Integer> algoritms;
	
	private ListGraph<String, Integer> graphNOCambas;
	private MatrixGraph<String, Integer> graphMatrix;

	/**
	 * @return the stations
	 */
	public Station[] getStations() {
		return stations;
	}

	/**
	 * @param stations the stations to set
	 */
	public void setStations(Station[] stations) {
		this.stations = stations;
	}

	/**
	 * @return the algoritms
	 */
	public GraphAlgorithms<String, Integer> getAlgoritms() {
		return algoritms;
	}

	/**
	 * @param algoritms the algoritms to set
	 */
	public void setAlgoritms(GraphAlgorithms<String, Integer> algoritms) {
		this.algoritms = algoritms;
	}

	/**
	 * @return the graphNOCambas
	 */
	public ListGraph<String, Integer> getGraphNOCambas() {
		return graphNOCambas;
	}

	/**
	 * @param graphNOCambas the graphNOCambas to set
	 */
	public void setGraphNOCambas(ListGraph<String, Integer> graphNOCambas) {
		this.graphNOCambas = graphNOCambas;
	}

	/**
	 * @return the graphMatrix
	 */
	public MatrixGraph<String, Integer> getGraphMatrix() {
		return graphMatrix;
	}

	/**
	 * @param graphMatrix the graphMatrix to set
	 */
	public void setGraphMatrix(MatrixGraph<String, Integer> graphMatrix) {
		this.graphMatrix = graphMatrix;
	}

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
		graphNOCambas.insertEdge(5, "Cisneros", "San Jos�");
		graphNOCambas.insertEdge(5, "San Jos�", "Miraflores");
		graphNOCambas.insertEdge(4, "San Jos�", "Buenos Aires");
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
		graphNOCambas.insertEdge(3, "San Jos�", "Barrio Col�n");
		graphNOCambas.insertEdge(3, "San Jos�", "Catedral Metropolitana");
		graphNOCambas.insertEdge(1, "Barrio Col�n", "San Diego");
		graphNOCambas.insertEdge(3, "San Diego", "Nutibara");
		graphNOCambas.insertEdge(2, "Catedral Metropolitana", "Gardel");

		// BLUE LINE
		graphNOCambas.insertEdge(9, "Prado", "Alpujarra");
		graphNOCambas.insertEdge(4, "Alpujarra", "Poblado");
		graphNOCambas.insertEdge(7, "Alpujarra", "Nutibara");
		graphNOCambas.insertEdge(6, "Prado", "Gardel");
		graphNOCambas.insertEdge(5, "Prado", "Caribe");
		graphNOCambas.insertEdge(2, "Caribe", "Niqu�a");
		graphNOCambas.insertEdge(3, "Prado", "San Jos�");
		graphNOCambas.insertEdge(3, "Alpujarra", "San Jos�");
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
		graphMatrix.insertEdge(5, "Cisneros", "San Jos�");
		graphMatrix.insertEdge(5, "San Jos�", "Miraflores");
		graphMatrix.insertEdge(4, "San Jos�", "Buenos Aires");
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
		graphMatrix.insertEdge(3, "San Jos�", "Barrio Col�n");
		graphMatrix.insertEdge(3, "San Jos�", "Catedral Metropolitana");
		graphMatrix.insertEdge(1, "Barrio Col�n", "San Diego");
		graphMatrix.insertEdge(3, "San Diego", "Nutibara");
		graphMatrix.insertEdge(2, "Catedral Metropolitana", "Gardel");

		// BLUE LINE
		graphMatrix.insertEdge(9, "Prado", "Alpujarra");
		graphMatrix.insertEdge(4, "Alpujarra", "Poblado");
		graphMatrix.insertEdge(7, "Alpujarra", "Nutibara");
		graphMatrix.insertEdge(6, "Prado", "Gardel");
		graphMatrix.insertEdge(5, "Prado", "Caribe");
		graphMatrix.insertEdge(2, "Caribe", "Niqu�a");
		graphMatrix.insertEdge(3, "Prado", "San Jos�");
		graphMatrix.insertEdge(3, "Alpujarra", "San Jos�");
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
	
	

}
