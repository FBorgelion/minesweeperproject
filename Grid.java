package be.fborgelion.minesweeperproject;

public class Grid {
	
	private int height;
	private int width;
	Box[][] board;
	
	public Grid(int height, int width) {
		this.height = height;
		this.width = width;
		board = new Box[height][width];
		for(int i = 0; i < height; i++) {
			for(int j = 0; j < width; j++){				
				board[i][j] = null;
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
	
	public static void main(String[] args) {
		
		Grid grid = new Grid(20, 20);
		System.out.println(grid);
		
	}

}
