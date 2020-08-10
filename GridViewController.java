package be.fborgelion.minesweeperproject;


import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

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
	
	private int openedBoxes = 0;
	
	
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
		int normalizedX = (int) (lastMouseX) / (rectSize);
		int normalizedY = (int) (lastMouseY) /(rectSize);
		if(normalizedX > grid.getHeight() || normalizedY > grid.getHeight()) {
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
	
	/**
	 * This method set the clicked box visible and check if the box is trapped.
	 * If the box is trapped set the game lost.
	 * Call the getBoxByMouseCoords method witch return the associated box.
	 */
	public void setGridStatus() {
		Box clickedBox = getBoxByMouseCoords();
		if(clickedBox.isTrapped()) {
			grid.setHasLost(true);
		}
		if(grid.isHasLost()) {
			setLoseScreen();
		}
		if(!clickedBox.isClicked()) {
			clickedBox.setClicked(true);
			openedBoxes = getOpenedBoxes() + 1;
			if(openedBoxes  == ((grid.getHeight()*grid.getWidth()) - grid.getNBombs())) {
				grid.setHasWon(true);
			}
			if(grid.isHasWon()) {
				setLoseScreen();
			}
		}
		System.out.println(clickedBox.isTrapped());
	}
	
	public void setLoseScreen() {
		Stage stage = new Stage();
		stage.setTitle("Minesweeper");
		
		GridPane endView = new GridPane();
		endView.setAlignment(Pos.CENTER);
		endView.setHgap(10);
		endView.setVgap(10);
		endView.setPadding(new Insets(25, 25, 25, 25));
		
		Text endText = new Text();
		if(grid.isHasLost()) {
			endText.setText("You lose.");
		}
		if(grid.isHasWon()) {
			endText.setText("Victory !");
		}
		endText.setFont(Font.font("Tahoma", FontWeight.EXTRA_BOLD, 30));
		endView.add(endText, 0, 0);
		
		Button exitBtn = new Button("Exit");
		HBox hbBtn = new HBox();
		hbBtn.getChildren().add(exitBtn);
		endView.add(hbBtn, 1, 2);
		
		exitBtn.addEventHandler(ActionEvent.ACTION, new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {
				System.exit(0);
				
			}
		});
		
		Scene scene = new Scene(endView, 250, 200);
		stage.setScene(scene);
		stage.show();
			
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
	
	public int getOpenedBoxes() {
		return openedBoxes;
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
			}
			if(event.getButton() == MouseButton.SECONDARY) {
				setBoxFlagged();
				System.out.println("flagged");
			}
		}
	}

	

}








