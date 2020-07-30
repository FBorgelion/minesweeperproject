package be.fborgelion.minesweeperproject;

public class DisplayGrid {
	
	
	public static void displayGrid(Grid grid) {
		System.out.println();
		for(int i = 0; i < grid.getHeight(); i++) {
			for(int j = 0; j < grid.getHeight(); j++) {
				//System.out.println(" | " + grid[i][j] );
			}
			System.out.println(" | ");
		}
		System.out.println();
	}

	public static void main(String[] args) {
		
		Grid grid = new Grid(20, 20, 5);
		displayGrid(grid);

	}

}
