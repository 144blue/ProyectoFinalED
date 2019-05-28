package application;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

import javax.swing.JOptionPane;

import graphV.Edge;
import graphV.GraphAlgorithms;
import graphV.ListGraph;
import graphV.Vertex;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextArea;
import model.TransportManager;

public class SampleController implements Initializable {
	
	@FXML
	private ObservableList<String> beginList = FXCollections.observableArrayList();
	@FXML
	private ObservableList<String> endList = FXCollections.observableArrayList();
	@FXML
	private ComboBox<String> list1;
	@FXML
	private ComboBox<String> list2;
	@FXML
	private TextArea rute;
	@FXML
	private Button ir;
	
	private boolean isList = true;
	private boolean isMatrix = false;
	
	private TransportManager tm;
	private GraphAlgorithms<String, Integer> ga;	
	public SampleController() {
		tm = new TransportManager();
		ga = new GraphAlgorithms<>();
	}
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		addStationList();
		
		list1.setItems(beginList);
		list1.setVisibleRowCount(8);
		
		list2.setItems(endList);
		list2.setVisibleRowCount(8);
	}
	
	public void addStationList() {
		beginList.add("Alpujarra");
		beginList.add("Barrio Col�n");
		beginList.add("Berlin");
		beginList.add("Buenos Aires");
		beginList.add("Caribe");
		beginList.add("Catedral Metropolitana");
		beginList.add("Cisneros");
		beginList.add("Estadio");
		beginList.add("F�tima");
		beginList.add("Gardel");
		beginList.add("La Aurora");
		beginList.add("Las Torres");
		beginList.add("Los Alpes");
		beginList.add("Miraflores");
		beginList.add("Niqu�a");
		beginList.add("Nutibarra");
		beginList.add("Oriente");
		beginList.add("Parque Aranjuez");
		beginList.add("Plaza Mayor");
		beginList.add("Poblado");
		beginList.add("Prado");
		beginList.add("San Diego");
		beginList.add("San Javier");
		beginList.add("San Jos�");
		beginList.add("Santa Luc�a");
		beginList.add("Trece de Noviembre");
		beginList.add("U. de M.");
		beginList.add("Vallejuelos");
		
		endList.add("Alpujarra");
		endList.add("Barrio Col�n");
		endList.add("Berlin");
		endList.add("Buenos Aires");
		endList.add("Caribe");
		endList.add("Catedral Metropolitana");
		endList.add("Cisneros");
		endList.add("Estadio");
		endList.add("F�tima");
		endList.add("Gardel");
		endList.add("La Aurora");
		endList.add("Las Torres");
		endList.add("Los Alpes");
		endList.add("Miraflores");
		endList.add("Niqu�a");
		endList.add("Nutibarra");
		endList.add("Oriente");
		endList.add("Parque Aranjuez");
		endList.add("Plaza Mayor");
		endList.add("Poblado");
		endList.add("Prado");
		endList.add("San Diego");
		endList.add("San Javier");
		endList.add("San Jos�");
		endList.add("Santa Luc�a");
		endList.add("Trece de Noviembre");
		endList.add("U. de M.");
		endList.add("Vallejuelos");
	}
	
	public void recomendedRute() {
		if(isList) {
			ListGraph<String, Integer> graph = (ListGraph<String, Integer>)ga.dijkstra(tm.getGraphNOCambas(), list2.getValue());
			Vertex<String, Integer> vertex = graph.getVertex(list1.getValue());
			String rute = "La ruta es la siguiente: ";
			int index = 1;
			int cont = 0;
			
			while(vertex != null) {
				rute += index + ") " + vertex.getValue() + " - " + "\n";
				Vertex<String, Integer> aux = vertex;
				vertex = vertex.getVertexPrevious();
				
				if(vertex != null) {
					ArrayList<Edge<String, Integer>> edge = aux.getEdges(vertex);
					for (int i = 0; i < edge.size(); i++) {
						cont += edge.get(i).getWeight().intValue();
					}
				} index++;
			}
			this.rute.setText(rute);
		} else if(isMatrix) {
			
		}
	}
	
	public void usingList() {
		isList = true;
		isMatrix = false;
		Alert a = new Alert(AlertType.INFORMATION);
		a.setTitle("Guardado");
		a.setHeaderText(null);
		a.setContentText("Se est� usando una Lista de Adyacencia ahora");
		a.showAndWait();
	}
	
	public void usingMatrix() {
		isList = false;
		isMatrix = true;
		Alert a = new Alert(AlertType.INFORMATION);
		a.setTitle("Guardado");
		a.setHeaderText(null);
		a.setContentText("Se est� usando una Matriz de Adyacencia ahora");
		a.showAndWait();
	}
}
