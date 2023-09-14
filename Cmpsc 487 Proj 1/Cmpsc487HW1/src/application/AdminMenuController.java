package application;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.fxml.Initializable;

import java.net.URL;
import java.sql.*;
import java.util.ResourceBundle;



public class AdminMenuController implements Initializable{

	@FXML private Button loginBut, menuBut;
	@FXML private TextField IDField;
	
	@FXML private TableView<ID> iDs;
	@FXML private TableColumn<ID, Integer> userID;
    @FXML private TableColumn<ID, String> name;
    @FXML private TableColumn<ID, String> type;
    @FXML private TableColumn<ID, String> active;
	
    ObservableList<ID> list = FXCollections.observableArrayList();
    
    MenuController menuCont;

    Statement stmt;
    ResultSet rset;
	
    public AdminMenuController(MenuController menuCont, Connection conn) throws SQLException {
        this.menuCont = menuCont;
        stmt = conn.createStatement();
    }
    
    @FXML
    void addID(ActionEvent event)throws SQLException{
    	stmt.executeUpdate("insert into users values(" +
    						IDField.getText() + ", " + name.getText()+
    						", " + type.getText() +", active");
    }
    
    void delID(ActionEvent event)throws SQLException{
    	
    }
    
    void togID(ActionEvent event)throws SQLException{
    	
    }
    
    
    
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        userID.setCellValueFactory(new PropertyValueFactory<ID, Integer>("userID"));
        name.setCellValueFactory(new PropertyValueFactory<ID, String>("name"));
        type.setCellValueFactory(new PropertyValueFactory<ID, String>("type"));
        active.setCellValueFactory(new PropertyValueFactory<ID, String>("active"));

        iDs.setItems(list);
    }
    
    @FXML
    void returnToMenu(ActionEvent event) throws Exception{
        FXMLLoader loader = new FXMLLoader(getClass().getResource("menu.fxml"));
        loader.setController(menuCont);
        Parent root = loader.load();
        Scene scene = new Scene(root, 290, 196 );
        Stage stage = (Stage) menuBut.getScene().getWindow();
        stage.setScene(scene);
        stage.show();
    }
    
    public void addID(ID id) {
    	list.add(id);
    }
}
