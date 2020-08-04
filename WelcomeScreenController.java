package be.fborgelion.minesweeperproject;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class WelcomeScreenController{
	
	private final TextField usernameTF;
	private final Button newGameBtn;
	private final Button loadSaveBtn;
	
	
	public WelcomeScreenController(TextField usernameTF, Button newGameBtn, Button loadSaveBtn) {
		this.usernameTF = usernameTF;
		this.newGameBtn = newGameBtn;
		this.loadSaveBtn = loadSaveBtn;
	}

	public Button getLoadSaveBtn() {
		return loadSaveBtn;
	}

	public Button getNewGameBtn() {
		return newGameBtn;
	}

	public TextField getUsernameTF() {
		return usernameTF;
	}
	
	
	
	//inner class to handle newGameBtn
	class NewGameListener implements EventHandler<ActionEvent>{

		@Override
		public void handle(ActionEvent event) {
			// display next screen from the mediator
			
		}
		
	}
	
	//inner class to handle loadSaveBtn
	class LoadSaveListener implements EventHandler<ActionEvent>{

		@Override
		public void handle(ActionEvent event) {
			// display next screen from the mediator
			
		}
		
	}


}
