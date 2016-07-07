package cs1302.p2;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class ArtsyImageView extends ImageView {
	
	private Image originalImage;
	
	public ArtsyImageView(Image original) {
		super(original);
		this.originalImage = original;
		setFitHeight(300); 
		setFitWidth(300); 
	} // constructor
	
	//_________Getters________________
	
	public Image getOriginalImage() {
		return this.originalImage;
	}
	
	//__________Setters____________
	
	public void setOriginalImage(Image original) {
		this.originalImage = original;
	}
	
} // ArtsyImageView
