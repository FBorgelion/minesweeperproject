package be.fborgelion.minesweeperproject;

import java.util.Random;

public class Grid {
	
	private int height;
	private int width;
	private int nBombs;
	private Box[][] board = null;
	private Box[] trappedBox;
	
	public Grid(int height, int width, int nBombs) {
		
		this.height = height;
		this.width = width;
		this.nBombs = nBombs;
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
	
	//will come back to check bombs have different coordinates
	protected void placeBombs() {		
		trappedBox = new Box[nBombs];
		
		int count = 0;
			
		do {
		
			int x = new Random().nextInt(width);
			int y = new Random().nextInt(height);
			
			Box box = new Box(x, y);
			box.setTrapped(true);
			trappedBox[count] = box;
			count += 1;
		} while(count < nBombs);
		
		//place bombs in board
		for(Box box : trappedBox) {
			board[box.getxLocation()][box.getyLocation()] = box;
		}
	}
	
	//must add checker/exception. This method must be called AFTER placeBombs()
	protected void placeBoxesInBoard() {
		for(Box bomb : trappedBox) {
			int x = bomb.getxLocation();
			int y = bomb.getyLocation();			
			//start on the previous square of a mine AND in grid
			int startX = Math.max(0, x - 1);
			int startY = Math.max(0, y - 1);
			for(int i = startX; i < width && i <= x + 1; i++) { // i <= x + 1 to reach the bomb's next square
				for(int j = startY; j < height && j <= y + 1; j++) {
					Box box = board[i][j];
					if(box == null) {
						board[i][j] = box = new Box(i, j);
					}
					else if(box.isTrapped()) {
						continue;
					}
					int countBombs = box.getSurroundingBombs() + 1;
					box.setSurroundingBombs(countBombs);
				}
			}			
		}
	}
}
