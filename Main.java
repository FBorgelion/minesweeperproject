package be.fborgelion.minesweeper;


import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class Main extends Application{
	
	Stage primaryStage;
	private Rectangle rect;
	
	private GridPane drawBoard(Grid board, Settings settings) {
		GridPane gameBoard = new GridPane();
		gameBoard.setAlignment(Pos.CENTER);
		for(int j = 0; j < board.getHeight(); j++) {
			for(int i = 0; i < board.getWidth(); i++) {
				Box box = board.getBoxStatus(i, j);
				StackPane pane = new StackPane();
				if(box.isTrapped() == true) {
					pane.getChildren().add(new Label("X"));
				}
				else {
					pane.getChildren().add(new Label(String.valueOf(box.getSurroundingBombs())));				
				}
				pane.getChildren().add(new TileButton(settings));
				gameBoard.add(pane, i, j);
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
		Scene scene2 = new Scene(easyGameView, 400, 400);
		easyBtn.addEventHandler(ActionEvent.ACTION, new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {
				primaryStage.setScene(scene2);
			}
		});
		
		GridViewController easyGameViewCtrl = new GridViewController(easyGame, easyGameView);		
		GridViewController.BoxListener easyBoxListener = easyGameViewCtrl.new BoxListener();
		easyGameView.addEventHandler(MouseEvent.MOUSE_CLICKED, easyBoxListener);
		
		//build normal game scene
		Button normalBtn = new Button("Normal");
		Settings settings2 = new Settings("Normal");
		Grid normalGame = new Grid(settings2);
		normalGame.placeBombs();
		normalGame.placeBoxesInBoard();
		GridPane normalGameView = drawBoard(normalGame, settings2);
		Scene scene3 = new Scene(normalGameView, 400, 400);
		normalBtn.addEventHandler(ActionEvent.ACTION, new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {
				primaryStage.setScene(scene3);
				
			}
		});
				
		GridViewController normalGameCtrl = new GridViewController(normalGame, normalGameView);
		GridViewController.BoxListener normalBoxListener = normalGameCtrl.new BoxListener();
		normalGameView.addEventHandler(MouseEvent.MOUSE_CLICKED, normalBoxListener);
		
		//build scene4
		Button hardBtn = new Button("Hard");
		Settings settings3 = new Settings("Hard");
		Grid hardGame = new Grid(settings3);
		hardGame.placeBombs();
		hardGame.placeBoxesInBoard();
		GridPane hardGameView = drawBoard(hardGame, settings3);
		Scene scene4 = new Scene(hardGameView, 800, 800);
		hardBtn.addEventHandler(ActionEvent.ACTION, new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {
				primaryStage.setScene(scene4);
				
			}
		});
		
		GridViewController hardGameCtrl = new GridViewController(hardGame, hardGameView);
		GridViewController.BoxListener hardBoxListener = hardGameCtrl.new BoxListener();
		hardGameView.addEventHandler(MouseEvent.MOUSE_CLICKED, hardBoxListener);
		
		
		VBox vbBtn = new VBox(5);
		vbBtn.getChildren().addAll(easyBtn, normalBtn, hardBtn);
		grid.add(vbBtn, 1, 3);
						
		
		Scene scene1 = new Scene(grid, 300, 275);				
		
		
		primaryStage.setScene(scene1);			
		primaryStage.show();
			
		}
	
	public static void main(String args[]) {
		launch(args);
		
		
	}

}
