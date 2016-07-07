package cs1302.p2;

import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.image.ImageView;
import javafx.scene.image.Image;
import javafx.event.EventHandler;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.KeyCode;
import java.util.ArrayList;
import java.util.List;
import javafx.scene.layout.BorderPane;

public class KonamiCodeHandler implements EventHandler<KeyEvent> {
	
	private Image surpriseImage;
	private List<KeyCode> correctSequence;
	private List<KeyCode> keyInputs;
	
	private int index;
	
	/**
	 * Constructor for KonamiCodeHandler
	 */
	public KonamiCodeHandler() {
		this.surpriseImage = new Image("file:resources/surpriseImage.png",500,500, false, true); // path needs to be changed when in nike context
		this.correctSequence = new ArrayList<KeyCode>();
		this.keyInputs = new ArrayList<KeyCode>();
		this.index = 0;
		
		correctSequence.add(KeyCode.UP);
		correctSequence.add(KeyCode.UP);
		correctSequence.add(KeyCode.DOWN);
		correctSequence.add(KeyCode.DOWN);
		correctSequence.add(KeyCode.LEFT);
		correctSequence.add(KeyCode.RIGHT);
		correctSequence.add(KeyCode.LEFT);
		correctSequence.add(KeyCode.RIGHT);
		correctSequence.add(KeyCode.B);
		correctSequence.add(KeyCode.A);
		// this was the best way to initialize an ArrayList I could find. all other ways involved returning an immutable list
		 
	} // constructor
	
	@Override
	public void handle(KeyEvent event) {
		if(event.getCode() == correctSequence.get(index)) {
			keyInputs.add(event.getCode());
			index++;
		} else {
			keyInputs.clear();
			index = 0;
		}
		if(keyInputs.size() == correctSequence.size()) {
			keyInputs.clear();
			index = 0;
			showSurpriseImage();
		}
	} // handle
	
	//_____________Getters_________________
	
	public Image getSurpriseImage() {
		return this.surpriseImage;
	}
	
	public List<KeyCode> getCorrectSequence() {
		return this.correctSequence;
	}
	
	public List<KeyCode> getKeyInputs() {
		return this.keyInputs;
	}
	
	//______________Setters______________
	
	public void setSurpriseImage(Image surpriseImage) {
		this.surpriseImage = surpriseImage;
	}
	
	public void setCorrectSequence(List<KeyCode> correctSequence) {
		this.correctSequence = correctSequence;
	}
	
	public void setKeyInputs(List<KeyCode> keyInputs) {
		this.keyInputs = keyInputs;
	}
	
	//______________Other Methods________________
	
        /**
	 * Displays the stage that contains the surprise Konami image.
         */
	private void showSurpriseImage() {
		Stage stage = new Stage();
		
		ImageView display = new ImageView();
		display.setFitHeight(surpriseImage.getHeight());
		display.setFitWidth(surpriseImage.getWidth());
		display.setImage(surpriseImage);
		
		BorderPane root = new BorderPane();
		root.setCenter(display);
		
		
		stage.setScene(new Scene(root));
		stage.setTitle("GrUmPy CaT");
		stage.show();
	}
	
} // KonamiCodeHandler
