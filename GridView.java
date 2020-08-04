package be.fborgelion.minesweeperproject;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.MenuBar;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

public class GridView extends Application{
	
	private Grid grid = new Grid(10, 10, 10);
	private GridPane gameBoard;
	private MenuBar menuBar;
	private Stage primaryStage;
	
	@Override
	public void start(Stage primaryStage) throws Exception {
		
		this.primaryStage = primaryStage;
		primaryStage.setTitle("Minesweeper");
		
		gameBoard = new GridPane();
		gameBoard.setHgap(1);
		gameBoard.setVgap(1);
		gameBoard.setAlignment(Pos.CENTER);
		for(int j = 0; j < grid.getHeight(); j++) {
			for(int i = 0; i < grid.getWidth(); i++) {
				gameBoard.add(new Rectangle(40, 40), j, i);
			}
		}
		
		GridViewController gridViewCtrl = new GridViewController(grid, gameBoard);
		
		GridViewController.BoxListener boxListener = gridViewCtrl.new BoxListener();
		gameBoard.addEventHandler(MouseEvent.MOUSE_CLICKED,boxListener);
		
		Scene scene = new Scene(gameBoard, 600, 600);
		primaryStage.setScene(scene);
		
		primaryStage.show();
		
	}

	public Grid getGrid() {
		return grid;
	}

	public void setGrid(Grid grid) {
		this.grid = grid;
	}
	
	public MenuBar getMenuBar() {
		return menuBar;
	}

	public Stage getPrimaryStage() {
		return primaryStage;
	}
		
	
	public static void main(String args[]) {
		launch(args);
	}

	

	
}
