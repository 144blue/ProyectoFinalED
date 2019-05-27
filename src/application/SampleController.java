package application;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;

public class SampleController {
	
	@FXML
	private ObservableList<String> beginList = FXCollections.observableArrayList();
	@FXML
	private ObservableList<String> endList = FXCollections.observableArrayList();
	@FXML
	private ComboBox<String> list1;
	@FXML
	private ComboBox<String> list2;
	
	@FXML
	public void intialize() {
		addStationList();
		
		list1.setItems(beginList);
		list1.setVisible(true);
		
		list2.setItems(endList);
		list2.setVisible(true);
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
