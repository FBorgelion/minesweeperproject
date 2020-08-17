package be.fborgelion.minesweeper;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseButton;

public class TileButton extends ImageView{
	
	private final Image imageBox = new Image("block.png");
	private final Image imageFlag = new Image("redFlag.png");
	
	
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
}
