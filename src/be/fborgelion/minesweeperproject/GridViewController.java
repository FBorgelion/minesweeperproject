package be.fborgelion.minesweeperproject;

import javafx.event.EventHandler;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;

/**
 * This class provides methods to react to game events.
 * @author Florent Borgelion
 *
 */
public class GridViewController {
	
	private Grid grid;
	private GridPane gameBoard;
	private BoxListener boxLstn;
	private int lastMouseX;
	private int lastMouseY;
	
	private final int BORDER_SIZE = 96 ;
	
	/**
	 * GridViewController reacts to game events.
	 * Also linked UI and logic.
	 * @param grid
	 * @param gameBoard
	 */
	public GridViewController(Grid grid, GridPane gameBoard) {
		this.gameBoard = gameBoard;
		this.grid = grid;
	}
	
	/**
	 * This method takes the mouse coordinates (when user clicked)
	 *  and get the associated box in the grid.
	 * If the clicked is out of the grid, return a Box on (-1, -1) coordinates.
	 * @return the right box in the grid.
	 */
	public Box getBoxByMouseCoords() {
		int rectSize = 0;
		if(grid.getHeight() == 10) {
			rectSize = 40;
		}
		else if(grid.getHeight() == 20) {
			rectSize = (int) (40 / 2);
		}
		else if(grid.getHeight() == 40) {
			rectSize = 40 / 4;
		}
		int normalizedX = (lastMouseX - BORDER_SIZE) / (rectSize+ 1);
		int normalizedY = (lastMouseY - BORDER_SIZE) /(rectSize + 1);
		if(normalizedX > grid.getHeight() || normalizedY > grid.getHeight()) {
			return new Box(-1, -1);
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
	
	/**
	 * This method set the clicked box visible and check if the box is trapped.
	 * If the box is trapped set the game lost.
	 * Call the getBoxByMouseCoords method witch return the associated box.
	 */
	public void setGridStatus() {
		Box clickedBox = getBoxByMouseCoords();
		clickedBox.setClicked(true);
		if(clickedBox.isTrapped()) {
			grid.setHasLost(true);
		//must update view
		}
		System.out.println(clickedBox.isTrapped());
		grid.isEnd();
	}
	
	/**
	 * This method change the state of the box if the player
	 * guessed this box is trapped (set a flag).
	 */
	public void setBoxFlagged() {
		Box clickedBox = getBoxByMouseCoords();
		clickedBox.setFlagged(true);
			//must update view
	}

	public BoxListener getBoxLstn() {
		return boxLstn;
	}
	
	/**
	 * Create inner class to handle mouse events.
	 * When a square is clicked, the instance of BoxListener call this method.
	 * If the click is the left one, setGridStatus method is called and reveals the box.
	 * If it's the right one, setBoxFlagged is called and put a flag on the box.
	 * @author Florent Borgelion
	 *
	 */
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
				System.out.println("flagged");
			}
		}
	}

	

}








