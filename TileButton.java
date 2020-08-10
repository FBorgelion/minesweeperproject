package be.fborgelion.minesweeperproject;

import java.io.File;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseButton;
import javafx.scene.layout.GridPane;

public class TileButton extends ImageView {
	
	private final String imURIBox = new File("C:\\Users\\Florent\\Desktop\\Dev\\workspace\\MinesweeperProject\\Image\\block.png").toURI().toString();
	private final String imURIRedFlag = new File("C:\\Users\\Florent\\Desktop\\Dev\\workspace\\MinesweeperProject\\Image\\redFlag.png").toURI().toString();
	private final Image imageBox = new Image(imURIBox);
	private final Image imageFlag = new Image(imURIRedFlag);
	
	private Grid board;
	TileButton tile;
	//display to hide number/bomb
	public TileButton(Settings settings) {
		setImage(imageBox);
		setFitHeight(settings.getRectSize());
		setFitWidth(settings.getRectSize());
		
		setOnMouseClicked(e -> {
			if(e.getButton() == MouseButton.PRIMARY) {
				setVisible(false);
			}
			else if(e.getButton() == MouseButton.SECONDARY) {
				setImage(imageFlag);
			}
			
		});
	}
	//must reveal adjacent empty boxes but idk where to hold it
	public void revealEmptyBox(int x, int y) {
		Box box = board.getBoxStatus(x, y);
		if(x < 0 || x > board.getWidth() || y < 0 || y > board.getHeight()) {			
			return;		
		}
		if(box.getSurroundingBombs() != 0) {
			return;
		}
		if(box.isClicked()) {
			return;
		}
		tile.setVisible(false);
		revealEmptyBox(x + 1, y);
		revealEmptyBox(x - 1, y);
		revealEmptyBox(x, y + 1);
		revealEmptyBox(x, y - 1);;
	}

}
