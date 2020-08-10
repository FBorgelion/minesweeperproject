package be.fborgelion.minesweeperproject;

import java.io.File;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseButton;

public class TileButton extends ImageView {
	
	private final String imURIBox = new File("C:\\Users\\Florent\\Desktop\\Dev\\workspace\\MinesweeperProject\\Image\\block.png").toURI().toString();
	private final String imURIRedFlag = new File("C:\\Users\\Florent\\Desktop\\Dev\\workspace\\MinesweeperProject\\Image\\redFlag.png").toURI().toString();
	private final Image imageBox = new Image(imURIBox);
	private final Image imageFlag = new Image(imURIRedFlag);
	
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

}
