package be.fborgelion.minesweeperproject;

import java.util.Random;

/**
 * This class contains the board game logic.
 * This class provides methods to generate bombs on the board.
 * @author Florent Borgelion
 *
 */

public class Grid {
	
	/**
	 * Grid's dimensions.
	 */
	private int height;
	private int width;
	
	/**
	 * Number of trapped boxes in the grid;
	 */
	private int nBombs;
	
	private Settings settings;
	
	/**
	 * 2D array board contains all the Boxes and Bombs.
	 * @see Box
	 */
	private Box[][] board;
	
	/**
	 * trappedBox array is used to stock bombs to be used in methods.
	 */
	private Box[] trappedBox;
	
	/**
	 * boolean variables for check the end of the game.
	 */
	private boolean hasLost = false;;
	private boolean hasWon = false;
	
	/**
	 * Grid constructor.
	 * Grid's dimensions are fixed in view of the difficulty.
	 * When created set Box objects with coordinates in board.
	 * @param settings : the difficulty of the game.
	 * @see Settings
	 * @see Box
	 */
	public Grid(Settings settings) {
		
		this.height = settings.getSize();
		this.width = settings.getSize();
		this.nBombs = (height * width) / 10;
		this.board = new Box[width][height];
		for(int i = 0; i < width; i++) {
			for(int j = 0; j < height; j++) {
				board[i][j] = new Box(i, j);
			}
		}
	}
	
	public int getNBombs() {
		return nBombs;
	}
	
	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
	}

	public int getWidth() {
		return width;
	}

	public void setWidth(int width) {
		this.width = width;
	}
	
	public Box[][] getBoard(){
		return board;
	}
	
	public Box getBoxStatus(int x, int y) {
		return board[x][y];
	}
	
	/**
	 * This method set trapped boxes in board.
	 * Trapped boxes are stocked in an array to be reused for next method.
	 */
	public void placeBombs() {
		this.trappedBox = new Box[nBombs];
		
		int count = 0;
			
		do {
		
			int x = new Random().nextInt(width);
			int y = new Random().nextInt(height);
			
			Box box = board[x][y];
			box.setTrapped(true);
			this.trappedBox[count] = box;
			count += 1;
		} while(count < nBombs);
	}
	
	/**
	 * This method count the adjacent bombs of a box.
	 * For each bomb in the board the method increments counter
	 * of adjacent bombs' boxes.
	 * @see Box
	 */
	protected void placeBoxesInBoard() {
		for(Box bomb : trappedBox) {
			int x = bomb.getxLocation();
			int y = bomb.getyLocation();			
			//start on the previous square of a mine AND in grid
			int startX = Math.max(0, x - 1);
			int startY = Math.max(0, y - 1);
			for(int i = startX; i < width && i <= x + 1; i++) { // i <= x + 1 to reach the bomb's next square
				for(int j = startY; j < height && j <= y + 1; j++) {
					Box box = board[j][i];
					if(box.isTrapped()) {
						continue;
					} else {
					int countBombs = box.getSurroundingBombs() + 1;
					box.setSurroundingBombs(countBombs);
					}
				}
			}			
		}
	}
	
	public boolean isEnd() {
		boolean end = false;
		if(isHasLost() || isHasWon()) {
			end = true;
		}
		return end;
	}

	public boolean isHasLost() {
		return hasLost;
	}

	public void setHasLost(boolean hasLost) {
		this.hasLost = hasLost;
	}

	public boolean isHasWon() {
		return hasWon;
	}

	public void setHawWon(boolean hawWon) {
		this.hasWon = hawWon;
	}
	
	
	public static void main(String[] args) {
		
	}

	public Settings getSettings() {
		return settings;
	}

	public void setSettings(Settings settings) {
		this.settings = settings;
	}
}











