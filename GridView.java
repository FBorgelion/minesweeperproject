package be.fborgelion.minesweeperproject;

import java.awt.Color;
import java.awt.Graphics;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.RowConstraints;
import javafx.scene.layout.TilePane;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class GridView extends Application{
	
	private int x = 0;
	private int y = 0;
	
	private Grid grid = new Grid(10, 10, 10);
	private GridPane gameBoard;
	
	
	@Override
	public void start(Stage primaryStage) throws Exception {
		primaryStage.setTitle("MineSweeper");
		
		gameBoard = new GridPane();
		gameBoard.setHgap(5);
		gameBoard.setVgap(5);
		gameBoard.setAlignment(Pos.CENTER);
		for(int j = 0; j < grid.getHeight(); j++) {
			for(int i = 0; i < grid.getWidth(); i++) {
				gameBoard.add(new Rectangle(40, 40), j, i);
			}
		}
		
		Scene scene = new Scene(gameBoard, 500, 475);
		primaryStage.setScene(scene);
		
		primaryStage.show();
		
	}

	public Grid getGrid() {
		return grid;
	}

	public void setGrid(Grid grid) {
		this.grid = grid;
	}

	
	class BoardTile{
		
		public void paintComponent(Graphics g) {
			g.setColor(Color.LIGHT_GRAY);
			g.fillRect(x, y, 25, 25);
			
		}
		
	}
	
	public static void main(String args[]) {
		launch(args);
	}

	
}
