package cs1302.p2;

import javafx.scene.layout.HBox;
import javafx.scene.control.Label;
import javafx.geometry.Pos;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;

public class ImageLabelHBox extends HBox {
	
	private Label defaultLabel;
	private Label imageLabel;
	
	/**
	 * Constructor for ImageLabelHBox
	 * @param panePosition the location of the HBox. 1 if in first ArtsyVBox, 2 if in second ArtsyVBox. If in result ArtsyVBox, default constructor
	 * 		  			   is called instead
	 */
	public ImageLabelHBox(int panePosition) {
		super(); // sets spacing between default label and the label that is based on image class path to 5 pixels
		String defaultLabelText = "Image " + panePosition + ": ";
		String defaultImageLabelText = "default.png";
		defaultLabel = new Label(defaultLabelText);
		defaultLabel.setFont(Font.font("Verdana", FontWeight.BOLD, 12)); 
		imageLabel = new Label(defaultImageLabelText);
		imageLabel.setFont(Font.font("Verdana", FontWeight.BOLD, 12)); 
		getChildren().addAll(defaultLabel, imageLabel);
		setAlignment(Pos.CENTER); 
	} // constructor for chosen images' labels
	
	/**
	 * Constructor for ImageLabelHBox
	 */
	public ImageLabelHBox() {
		super();
		String defaultLabelText = "Result";
		defaultLabel = new Label(defaultLabelText);
		defaultLabel.setFont(Font.font("Verdana", FontWeight.BOLD, 12)); 
		imageLabel = null;
		getChildren().add(defaultLabel);
		setAlignment(Pos.CENTER); 
	} // constructor for result image label
	
	//_________Getters________________
	
	public Label getDefaultLabel() {
		return this.defaultLabel;
	}
	
	public Label getImageLabel() throws NullPointerException { // if the ImageLabelHBox was constructed with default constructor
		return this.imageLabel;
	}
	
	//______________Setters___________________
	
	public void setDefaultLabel(Label label) {
		this.defaultLabel = label;
	}
	
	public void setImageLabel(Label label) {
		this.imageLabel = label;
	}
	
} // ImageLabelHBox
