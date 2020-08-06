package be.fborgelion.minesweeperproject;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class WelcomeScreenView extends Application {
	
	Stage primaryStage;
	private String[] difficultyList = {"Easy", "Normal", "Hard"};

	
	@Override
	public void start(Stage primaryStage) throws Exception {
		this.primaryStage = primaryStage;
		
		
		Grid board = new Grid(10, 10, 10);
		board.placeBombs();
		board.placeBoxesInBoard();
		
		
		primaryStage.setTitle("Minesweeper");		
		
			
			//build scene1 (welcome screen)
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
				
		
		Button loadSaveBtn = new Button("Load Save");
		HBox hbLoadSave = new HBox(10);
		hbLoadSave.setAlignment(Pos.BOTTOM_RIGHT);
		hbLoadSave.getChildren().add(loadSaveBtn);
		grid.add(hbLoadSave, 1, 8);
		
		Scene scene1 = new Scene(grid, 300, 275);
		
		
		//build scene2 (board game)
		GridPane gameBoard = new GridPane();
		gameBoard.setHgap(1);
		gameBoard.setVgap(1);
		gameBoard.setAlignment(Pos.CENTER);
		for(int j = 0; j < board.getHeight(); j++) {
			for(int i = 0; i < board.getWidth(); i++) {
				gameBoard.add(new Rectangle(40, 40), j, i);
			}
		}
		
		Scene scene2 = new Scene(gameBoard, 600, 600);
		
		newGameBtn.addEventHandler(ActionEvent.ACTION, new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {
				primaryStage.setScene(scene2);
				
			}
		});			
			
		GridViewController gridViewCtrl = new GridViewController(board, gameBoard);		
		GridViewController.BoxListener boxListener = gridViewCtrl.new BoxListener();
		gameBoard.addEventHandler(MouseEvent.MOUSE_CLICKED,boxListener);
		
		primaryStage.setScene(scene1);
	
/*	//build end game view
		GridPane endView = new GridPane();
		Text endMessage = new Text();
		endView.setAlignment(Pos.CENTER);
		if(board.isHasLost()) {
			endMessage.setText("You lose.");
			}
			if(board.isHasWon()) {
				endMessage.setText("Congratulations, you win !");
			}
			endView.add(endMessage, 0, 0);
			
			Scene scene3 = new Scene(endView, 300, 275);
			if(board.isEnd()) {
				primaryStage.setScene(scene3);
			} */
			
			primaryStage.show();
			
		}
	
	public static void main(String args[]) {
		launch(args);
		
		
	}

}
