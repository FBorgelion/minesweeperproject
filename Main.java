package be.fborgelion.minesweeperproject;


import javafx.application.Application;
import javafx.beans.Observable;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.ObservableList;


import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class Main extends Application{
	
	Stage primaryStage;
	private Rectangle rect;
	
	private Rectangle buildRectangle(int x, int y, int size) {
		Rectangle rect = new Rectangle();
		rect.setX(x * size);
		rect.setY(y * size);
		rect.setHeight(size);
		rect.setWidth(size);
		rect.setFill(Color.LIGHTGRAY);
		rect.setStroke(Color.BLACK);
		return rect;
	}
	
	private GridPane drawBoard(Grid board, Settings settings) {
		GridPane gameBoard = new GridPane();
		gameBoard.setHgap(1);
		gameBoard.setVgap(1);
		gameBoard.setAlignment(Pos.CENTER);
		for(int j = 0; j < board.getHeight(); j++) {
			for(int i = 0; i < board.getWidth(); i++) {
				this.rect = buildRectangle(i, j, (settings.getRectSize()));
				gameBoard.add(rect, j, i);
			}
		}
		return gameBoard;
	}
	
	public Rectangle getRect() {
		return this.rect;
	}

	
	@Override
	public void start(Stage primaryStage) throws Exception {
		this.primaryStage = primaryStage;
		
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
		
		Button easyBtn = new Button("Easy");
		Settings settings1 = new Settings("Easy");
		Grid easyGame = new Grid(settings1);
		easyGame.placeBombs();
		easyGame.placeBoxesInBoard();
		GridPane easyGameView = drawBoard(easyGame, settings1);
		Scene scene2 = new Scene(easyGameView, 600, 600);
		easyBtn.addEventHandler(ActionEvent.ACTION, new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {
				primaryStage.setScene(scene2);
				
			}
		});
		
		
		Button normalBtn = new Button("Normal");
		Settings settings2 = new Settings("Normal");
		Grid normalGame = new Grid(settings2);
		normalGame.placeBombs();
		normalGame.placeBoxesInBoard();
		GridPane normalGameView = drawBoard(normalGame, settings2);
		Scene scene3 = new Scene(normalGameView, 600, 600);
		normalBtn.addEventHandler(ActionEvent.ACTION, new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {
				primaryStage.setScene(scene3);
				
			}
		});
		
		
		VBox vbBtn = new VBox(5);
		vbBtn.getChildren().addAll(easyBtn, normalBtn);
		grid.add(vbBtn, 1, 2);
				
		
		Button loadSaveBtn = new Button("Load Save");
		HBox hbLoadSave = new HBox(10);
		hbLoadSave.setAlignment(Pos.BOTTOM_RIGHT);
		hbLoadSave.getChildren().add(loadSaveBtn);
		grid.add(hbLoadSave, 1, 8);
		
		Scene scene1 = new Scene(grid, 300, 275);		
			
		GridViewController easyGameViewCtrl = new GridViewController(easyGame, easyGameView);		
		GridViewController.BoxListener easyBoxListener = easyGameViewCtrl.new BoxListener();
		easyGameView.addEventHandler(MouseEvent.MOUSE_CLICKED, easyBoxListener);
		
		
		GridViewController normalGameCtrl = new GridViewController(normalGame, normalGameView);
		GridViewController.BoxListener normalBoxListener = normalGameCtrl.new BoxListener();
		normalGameView.addEventHandler(MouseEvent.MOUSE_CLICKED, normalBoxListener);
		
		
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
