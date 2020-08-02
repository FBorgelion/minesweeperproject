package be.fborgelion.minesweeperproject;

import com.sun.javafx.geom.AreaOp.NZWindOp;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;

public class Main extends Application {
	
	Stage primaryStage;
	private String[] difficultyList = {"Easy", "Normal", "Hard"};
	
	public void setNewGame() {
		System.out.println("Launching new game");
	}
	
	public void loadSavedGame() {
		System.out.println("Launching game");
	}
	

	@Override
	public void start(Stage primaryStage) throws Exception {
		this.primaryStage = primaryStage;
		primaryStage.setTitle("MineSweeper");
		
		GridPane grid = new GridPane();
		grid.setAlignment(Pos.CENTER);
		grid.setHgap(10);
		grid.setVgap(10);
		grid.setPadding(new Insets(25, 25, 25, 25));
		
		Text welcomeText = new Text("Welcome");
		welcomeText.setFont(Font.font("Tahoma", FontWeight.BOLD, 30));
		grid.add(welcomeText, 0, 0, 2, 1);
		
		Label username = new Label("Username :");
		grid.add(username, 0, 1);
		
		TextField usernameTF = new TextField();
		grid.add(usernameTF, 1, 1);
		
		Label difficulty = new Label("Difficulty :") ;
		grid.add(difficulty, 0, 2);
		
		ChoiceBox<String> difficultyCB = new ChoiceBox<String>();
		difficultyCB.getItems().addAll(this.difficultyList[0], this.difficultyList[1], this.difficultyList[2]);
		grid.add(difficultyCB, 1, 2);
		
		Button newGameBtn = new Button("New Game");
		HBox hbNewGame = new HBox(10);
		hbNewGame.setAlignment(Pos.BOTTOM_LEFT);
		hbNewGame.getChildren().add(newGameBtn);
		grid.add(hbNewGame, 0, 8);
		
		newGameBtn.setOnAction((event) -> {
			setNewGame();
		});
		
		Button loadSaveBtn = new Button("Load Save");
		HBox hbLoadSave = new HBox(10);
		hbLoadSave.setAlignment(Pos.BOTTOM_RIGHT);
		hbLoadSave.getChildren().add(loadSaveBtn);
		grid.add(hbLoadSave, 1, 8);
		
		loadSaveBtn.setOnAction((event) -> {
			loadSavedGame();
		});
			
		Scene scene = new Scene(grid, 600, 525);
		primaryStage.setScene(scene);
		
		primaryStage.show();
		
	}
	
	public static void main(String args[]) {
		launch(args);
	}

}
