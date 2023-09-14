package application;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import java.sql.*;


public class LoginController {

	@FXML private Button loginBut, menuBut;
	@FXML private TextField loginID;
	
    MenuController menuCont;

    Statement stmt;
    ResultSet rset;
    
    int lID;
    
    public LoginController(MenuController menuCont, Connection conn) throws SQLException{
    	this.menuCont = menuCont;
    	stmt = conn.createStatement();
    	
    }
    
    @FXML
    void login(ActionEvent event) throws Exception{
        try {
        	System.out.println(loginID.getText());
            lID = Integer.parseInt(loginID.getText());
        }
        catch(NumberFormatException e) {
            loginID.setText("Invalid ID");
            return;
        }
    	
    	rset = stmt.executeQuery("select * from users"
    			+ "where id =" + lID);
    	
    	if(rset.getString(3).equals("admin")) {
    		FXMLLoader loader = new FXMLLoader(getClass().getResource("adminMenu.fxml"));
    		AdminMenuController adCon = new AdminMenuController(menuCont, stmt.getConnection()); 
    		loader.setController(adCon);
    		Parent root = loader.load();
            Scene scene = new Scene(root, 550, 400 );
            Stage stage = (Stage) loginBut.getScene().getWindow();
            stage.setScene(scene);
            stage.show();
    	}
    	
    	else {
    		loginID.setText("Invalid ID");
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
