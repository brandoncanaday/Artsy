package cs1302.p2;

import javafx.scene.control.Button;
import javafx.scene.text.Font;

public class ResetButton extends Button {
	
	private ArtsyImageView display;

	public ResetButton(ArtsyImageView display) {
		super("Reset");
		this.display = display;
		setOnAction(event -> display.setImage(display.getOriginalImage()));
		setStyle("-fx-background-color: linear-gradient(#ffffff 0%, #fa8e82 37%, #f02f17 71%, #b31507 90%, #b31507 100%)"); 
		setFont(new Font("Verdana", 18)); 
	}
	
	//___________Getters_______________
	
	public ArtsyImageView getDisplay() {
		return this.display;
	}
	
	//___________Setters_____________
	
	public void setDisplay(ArtsyImageView view) {
		this.display = view;
	}
	
} // ResetButton
