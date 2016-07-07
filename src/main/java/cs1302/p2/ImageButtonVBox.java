package cs1302.p2;

import cs1302.p2.MyArtsy.OperationType;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.layout.VBox;

public class ImageButtonVBox extends VBox {

	private EffectButton rotateButton;
	private ResetButton resetButton;
	private ArtsyImageView display;
	
	public ImageButtonVBox(ArtsyImageView display) {
		super(8); // sets vertical spacing between the rotate and reset buttons to 8 pixels
		this.display = display;
		this.rotateButton = new EffectButton(OperationType.ROTATE,this.display);
		this.rotateButton.setMaxWidth(Double.MAX_VALUE); 
		this.resetButton = new ResetButton(this.display);
		this.resetButton.setMaxWidth(Double.MAX_VALUE); 
		getChildren().addAll(this.rotateButton, this.resetButton);
		setAlignment(Pos.CENTER); 
		setPadding(new Insets(0, 30, 0, 30)); 
	} // constructor
	
	//___________Getters__________________
	
	public EffectButton getRotateButton() {
		return this.rotateButton;
	}
	
	public ResetButton getResetButton() {
		return this.resetButton;
	}
	
	public ArtsyImageView getDisplay() {
		return this.display;
	}
	
	//_________________Setters_________________________
	
	public void setRotateButton(EffectButton button) {
		this.rotateButton = button;
	}
	
	public void setResetButton(ResetButton button) {
		this.resetButton = button;
	}
	
	public void setDisplay(ArtsyImageView display) {
		this.display = display;
	}
	
} // ImageButtonVBox
