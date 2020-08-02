package be.fborgelion.minesweeperproject;

import javafx.scene.layout.GridPane;

public class GridView {
	
	private GridPane grid;
	private Grid board;
	
	private int gridWidth;
	private int gridHeight;
	
	public void setNewGrid() {
		gridWidth = board.getWidth();
		gridHeight = board.getHeight();
		
	}

	public int getGridWidth() {
		return gridWidth;
	}

	public void setGridWidth(int gridWidth) {
		this.gridWidth = gridWidth;
	}

	public int getGridHeight() {
		return gridHeight;
	}

	public void setGridHeight(int gridHeight) {
		this.gridHeight = gridHeight;
	}
	
}
