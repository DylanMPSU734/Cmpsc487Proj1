package application;

import java.sql.Connection;
import java.sql.Statement;

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
import java.sql.*;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;

public class SwipeController {
	
	@FXML private Button swipeBut, menuBut;
	@FXML private TextField swipeID;
    MenuController menuCont;

    Statement stmt;
    ResultSet rset;
    
	public SwipeController(MenuController menuCont,Connection conn) throws SQLException{
		this.menuCont = menuCont;
		stmt = conn.createStatement();
	}
	
	@FXML
	void swipe(ActionEvent event) throws Exception{
		String sId = swipeID.getText();
		int id = Integer.parseInt(sId.substring(2,10));
		Timestamp timestamp = new Timestamp(System.currentTimeMillis());
		
	    rset = stmt.executeQuery("select * from users"
	    	+ "where id =" + id);
	    	
	    if(rset.getString(4).equals("active")) {
	    	
	    	stmt.executeUpdate("insert into timestamps values(" +
	    						id + ", " + timestamp);
	    }
	    	
	    else {
	    	swipeID.setText("Invalid ID");
	    }
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
}
