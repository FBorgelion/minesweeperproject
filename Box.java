package be.fborgelion.minesweeperproject;

public class Box {
	
	private int xLocation;
	private int yLocation;
	
	//player put a red flag on the box (display)
	private boolean isFlagged;
	
	//player has guessed this box (display)
	private boolean isClicked;
	
	
	public Box(int xLocation, int yLocation) {
		this.xLocation = xLocation;
		this.yLocation = yLocation;
		isFlagged = false;
		isClicked = false;
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
	
}

