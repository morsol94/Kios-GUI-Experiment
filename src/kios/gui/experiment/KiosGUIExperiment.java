/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kios.gui.experiment;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.PasswordField;
import javafx.scene.control.SeparatorMenuItem;
import javafx.scene.control.TextField;
import javafx.scene.control.ToolBar;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

/**
 *
 * @author Morten
 */

 
public class KiosGUIExperiment extends Application
{
    
    @Override
    public void start(Stage primaryStage)
    {
        BorderPane root = new BorderPane();
        VBox topContainer = new VBox();
        MenuBar mainMenu = createMenues();
        ToolBar toolBar = creatToolBar();
        
        //Place the menubar in the topContainer
        topContainer.getChildren().add(mainMenu);
        
        //Place the top container in the top-section of the BorderPane
        root.setTop(topContainer);
        
        //Place the center content
        root.setCenter(creatCenterContent());
        
        //Creat the scene, adding the rootNode and setting the size
        Scene scene = new Scene(root, 400, 350);
        //Set the title of the stage and add the scene
        primaryStage.setTitle("NewsStand");
        primaryStage.setScene(scene);
        
        //Makes the stage visible
        primaryStage.show();
        
        
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args)
    {
        launch(args);
    }
    
    private Node creatCenterContent()
    {
        GridPane grid = new GridPane();
        grid.setAlignment(Pos.CENTER);
        grid.setHgap(10);
        grid.setVgap(10);
        grid.setPadding(new Insets(25, 25, 25, 25));
       
        
        Text scenetitle = new Text("Welcome");
        scenetitle.setFont(Font.font("Tahoma", FontWeight.NORMAL, 20));
        grid.add(scenetitle, 0, 0, 2, 1);
        
        Label userName = new Label("User Name:");
        grid.add(userName, 0, 1);
        
        TextField userTextField = new TextField();
        grid.add(userTextField, 1, 1);
        
        Label pw = new Label("Password:");
        grid.add(pw, 0, 2);
        
        PasswordField pwBox = new PasswordField();
        grid.add(pwBox, 1, 2);
        
        //Creating sign in button
        Button signInBtn = new Button("Sign in");
        grid.add(signInBtn, 2, 4);
        
        
        //Creating reset button
        Button resetBtn = new Button("reset");
        HBox hbReset = new HBox();
        hbReset.setAlignment(Pos.BOTTOM_RIGHT);
        hbReset.getChildren().add(resetBtn);
        grid.add(hbReset, 1, 4);
        
        //
        Text actiontarget = new Text();
        grid.add(actiontarget, 1, 6);
        
        
        
        signInBtn.setOnAction(new EventHandler<ActionEvent>(){
            
            @Override
            public void handle(ActionEvent e){
                actiontarget.setFill(Color.FIREBRICK);
                actiontarget.setText("Sign in button pressed");
            }
        });
        
        
        
        return grid;

    }
    
    //Creates the menubar
    private MenuBar createMenues()
    {
        //Creat the Menu Bar to hold the menues
        MenuBar menuBar = new MenuBar();
        
        //The File-menu
        Menu menuFile = new Menu("File");
        MenuItem openFile = new MenuItem("Open");
        MenuItem printFile = new MenuItem("Print");
        MenuItem exitApp = new MenuItem("Exit");
        menuFile.getItems().addAll(openFile, printFile);
        menuFile.getItems().add(new SeparatorMenuItem());
        menuFile.getItems().add(exitApp);
        
        // Add event handler
        openFile.setOnAction(new EventHandler<ActionEvent>()
        {
            @Override
            public void handle(ActionEvent event)
            {
                System.out.println("Open file was selected");
            }
        
        });
        
        printFile.setOnAction(new EventHandler<ActionEvent>()
        {
            @Override
            public void handle(ActionEvent event)
            {
                System.out.println("File was printed");
            }
        
        });
        
        exitApp.setOnAction(new EventHandler<ActionEvent>()
        {
            @Override
            public void handle(ActionEvent event)
            {
                System.out.println("Quiting application");
                stop();
            }
                
        });
        
        
        Menu menuEdit = new Menu("Edit");
        Menu menuView = new Menu("View");
        
        menuBar.getMenus().addAll(menuFile, menuEdit, menuView);
        
        return menuBar;
    }
    
    @Override
    public void stop()
    {
        System.exit(0);
    }

}
