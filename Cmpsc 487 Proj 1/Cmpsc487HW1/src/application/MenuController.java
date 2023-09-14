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
import oracle.jdbc.*;
import oracle.jdbc.pool.OracleDataSource;


public class MenuController extends Application{
	public OracleDataSource ods;
	public Connection conn;
	
	private    @FXML Button loginMenuBut, swipeMenuBut;
	private    @FXML AnchorPane menuPane;
    @FXML TextField username,password;
    @FXML Button signIn;
	
    @Override
    public void start(Stage stage) throws Exception {
   	
        FXMLLoader loader = new FXMLLoader(getClass().getResource("dbLogin.fxml"));
        loader.setController(this);
        Parent root = loader.load();
        Scene scene = new Scene(root, 330, 250 );
        stage.setScene(scene);
        stage.show();
    }
    
    //Logging In
    @FXML 
    void signInAction(ActionEvent event) throws Exception{
        ods = new OracleDataSource();
        ods.setURL("jdbc:oracle:thin:@h3oracle.ad.psu.edu:1521/orclpdb.ad.psu.edu");
        ods.setUser(username.getText());
        ods.setPassword(password.getText());
	    conn = ods.getConnection();
	    
        FXMLLoader loader = new FXMLLoader(getClass().getResource("menu.fxml"));
        loader.setController(this);
        Parent root = loader.load();
        Scene scene = new Scene(root, 290, 196 );
        Stage stage = (Stage) signIn.getScene().getWindow();
        stage.setScene(scene);
        stage.show();	

    }
	
    @FXML
    void loginMenu(ActionEvent event) throws Exception{
        FXMLLoader loader = new FXMLLoader(getClass().getResource("login.fxml"));
        LoginController logCon = new LoginController(this, conn);
        loader.setController(logCon);
        Parent root = loader.load();
        Scene scene = new Scene(root, 800, 700 );
        Stage stage = (Stage) loginMenuBut.getScene().getWindow();
        stage.setScene(scene);
        stage.show();
    }
    
    @FXML
    void swipeMenu(ActionEvent event) throws Exception{
    	FXMLLoader loader = new FXMLLoader(getClass().getResource("swipe.fxml"));
    	SwipeController swipeCon = new SwipeController(this, conn);
    	loader.setController(swipeCon);
    	Parent root = loader.load();
    	Scene scene = new Scene(root, 800, 700);
    	Stage stage = (Stage) swipeMenuBut.getScene().getWindow();
    	stage.setScene(scene);
    	stage.show();
    }
    
    
    public static void main(String[] args) throws Exception{

    	launch();

    }
}
