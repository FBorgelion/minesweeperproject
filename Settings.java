package be.fborgelion.minesweeper;

/**
 * This class set the difficulty of the game.
 * This class set the board game dimensions.
 * @author Florent Borgelion
 */
public class Settings{
	
	/**
	 * size of the grid following the difficulty.
	 */
	private int size;
	
	private int rectSize = 0;
	
	private String difficulty;

	/**
	 * Following the string set in the constructor,
	 * the size is changed.
	 * @param difficulty : the difficulty of the game
	 */
	public Settings(String difficulty) {
		if(difficulty == "Easy") {
			this.size = 10;
			this.rectSize = 40;
		}
		if(difficulty == "Normal") {
			this.size = 20;
			this.rectSize = (40 / 2);
		}
		if(difficulty == "Hard") {
			this.size = 40;
			this.rectSize = (40 / 2);
		}
		this.difficulty = difficulty;
	}

	
	public int getSize() {
		return size;
	}

	public void setSize(int size) {
		this.size = size;
	}


	public String getDifficulty() {
		return difficulty;
	}


	public void setDifficulty(String difficulty) {
		this.difficulty = difficulty;
	}


	public int getRectSize() {
		return rectSize;
	}


	public void setRectSize(int rectSize) {
		this.rectSize = rectSize;
	}


}
