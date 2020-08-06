package be.fborgelion.minesweeperproject;

import javafx.event.EventHandler;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class GridViewController {
	
	private Grid grid = new Grid(10, 10, 10);
	private GridPane gameBoard;
	private Box processBox;
	private BoxListener boxLstn;
	private Stage stage;
	
	private int lastMouseX;
	private int lastMouseY;
	
	private int nBoxes = grid.getHeight();
	
	private int BORDER_SIZE = 96;
	private int BOX_SIZE = 41;
	
	public GridViewController(Grid grid, GridPane gameBoard) {
		this.gameBoard = gameBoard;
		this.grid = grid;
	}
	//here we normalize mouse coords to get the right box in board game
	public Box getBoxByMouseCoords() {
		int normalizedX = (lastMouseX - BORDER_SIZE) / BOX_SIZE;
		int normalizedY = (lastMouseY - BORDER_SIZE) / BOX_SIZE;
		if(normalizedX > nBoxes || normalizedY > nBoxes) {
			return null;
		}
		else {			
			Box box = grid.getBoxStatus(normalizedX, normalizedY);
			return box;	
		}
	}

	public GridPane getGameBoard() {
		return gameBoard;
	}

	public Grid getGrid() {
		return grid;
	}

	public int getLastMouseX() {
		return lastMouseX;
	}

	public void setLastMouseX(int lastMouseX) {
		this.lastMouseX = lastMouseX;
	}

	public int getLastMouseY() {
		return lastMouseY;
	}

	public void setLastMouseY(int lastMouseY) {
		this.lastMouseY = lastMouseY;
	}
	
	public void setGridStatus() {
		Box clickedBox = getBoxByMouseCoords();
		clickedBox.setClicked(true);
		if(clickedBox.isTrapped()) {
			grid.setHasLost(true);
			System.out.println(clickedBox.isTrapped());
		//must update view
		}
		grid.isEnd();
	}
	
	public void setBoxFlagged() {
		Box clickedBox = getBoxByMouseCoords();
		clickedBox.setFlagged(true);
		//must update view
	}
	
	public Box getProcessBox() {
		return processBox;
	}

	public BoxListener getBoxLstn() {
		return boxLstn;
	}

	public int getnBoxes() {
		return nBoxes;
	}
	
	
	class BoxListener implements EventHandler<MouseEvent>{

		@Override
		public void handle(MouseEvent event) {
			int xClick = (int) event.getX();
			int yClick = (int) event.getY();
			
			GridViewController.this.setLastMouseX(xClick);
			GridViewController.this.setLastMouseY(yClick);;
			
			if(event.getButton() == MouseButton.PRIMARY) {
				setGridStatus();
				System.out.println("yop");
			}
			if(event.getButton() == MouseButton.SECONDARY) {
				setBoxFlagged();
			}
		}
	}

	

}








