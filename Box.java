package be.fborgelion.minesweeperproject;

/**
 * This class contains all the logic of a board square.
 * Box object is set in the board.
 * @author Florent Borgelion
 *
 */
public  class Box {
	
	private int xLocation;
	private int yLocation;
	
	/**
	 * Counter for adjacent bombs of a box.
	 */
	private int surroundingBombs;
	
	/**
	 * Say if a box is a bomb or not.
	 */
	private boolean isTrapped = false;
	
	/**
	 * Say if box is flagged.
	 */
	private boolean isFlagged = false;
	
	/**
	 * Say if the box must be visible.
	 */
	private boolean isClicked = false;
	
	/**
	 * Constructor set boolean on false and set the coordinates of a box.
	 * @param xLocation : x location in the board.
	 * @param yLocation : y location in the board.
	 */
	public Box(int xLocation, int yLocation) {
		this.xLocation = xLocation;
		this.yLocation = yLocation;
	}
	
	
	public int getxLocation() {
		return xLocation;
	}

	public void setxLocation(int xLocation) {
		this.xLocation = xLocation;
	}

	public int getyLocation() {
		return yLocation;
	}

	public void setyLocation(int yLocation) {
		this.yLocation = yLocation;
	}

	public boolean isFlagged() {
		return isFlagged;
	}

	public void setFlagged(boolean isFlagged) {
		this.isFlagged = isFlagged;
	}

	public boolean isClicked() {
		return isClicked;
	}

	public void setClicked(boolean isClicked) {
		this.isClicked = isClicked;
	}


	public boolean isTrapped() {
		return isTrapped;
	}


	public void setTrapped(boolean isTrapped) {
		this.isTrapped = isTrapped;
	}


	public int getSurroundingBombs() {
		return surroundingBombs;
	}


	public void setSurroundingBombs(int surroundingBombs) {
		this.surroundingBombs = surroundingBombs;
	}
	
}

