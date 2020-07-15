package be.fborgelion.minesweeperproject;

import java.util.Random;

public class Grid {
	
	private int height;
	private int width;
	private int nBombs = (height * width) / 10;
	private Box[][] board;
	
	public Grid(int height, int width) {
		
		this.height = height;
		this.width = width;
		
		board = new Box[width][height];
		for(int i = 0; i < height; i++) {
			for(int j = 0; j < width; j++){				
				board[i][j] = new Box(i, j);
			}
		}
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
	
	protected Box getBoxAt(int x, int y) {
		if(x < 0 || x > width || y < 0 || y >= height) {
			return null;
		}
		else {
			return board[x][y];
		}
	}
		
	protected void setBombs() {		
		for(int i = 0; i < nBombs; i++) {
		
			int x = new Random().nextInt(width);
			int y = new Random().nextInt(height);
			
			Box box = getBoxAt(x, y);
			
			if(!box.isTrapped()) {
				box.setTrapped(true);
			}
			else {
				setBombs();
			}
		}
	}
	
	
	public static void main(String[] args) {
		Grid grid = new Grid(5, 5);
		grid.setBombs();
	}

}
