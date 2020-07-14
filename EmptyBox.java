package be.fborgelion.minesweeperproject;

public class EmptyBox extends Box{
	
	//contains the number of TrappedBox's in the surrounding of this EmptyBox
	private int[] distanceArray;
		
	
	public EmptyBox(int xLocation, int yLocation) {
		super(xLocation, yLocation);
		distanceArray = new int[1];
	}
	

	public int[] getDistanceArray() {
		return distanceArray;
	}

	public void setDistanceArray(int[] distanceArray) {
		this.distanceArray = distanceArray;
	}

}
