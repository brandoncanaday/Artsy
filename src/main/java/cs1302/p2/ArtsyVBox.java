package cs1302.p2;

import javafx.scene.layout.VBox;
import javafx.scene.image.Image;
import javafx.geometry.Insets;

public class ArtsyVBox extends VBox {
	
	private ImageLabelHBox imageLabelHBox; // top of VBox
	private ArtsyImageView imageDisplay; // middle of VBox
	private ImageButtonVBox rotateResetButtons; // bottom of VBox
	
        /**
         * Constructor for ArtsyVBox.
         * @param panePosition the position (left, center) of the ArtsyVBox in the ArtsyBorderPane 
         */
	public ArtsyVBox(int panePosition) {
		super(8);
		this.imageLabelHBox = new ImageLabelHBox(panePosition);
		this.imageDisplay = new ArtsyImageView(new Image("file:resources/default.png",300,300, false, true));
		this.rotateResetButtons = new ImageButtonVBox(this.imageDisplay);
		getChildren().addAll(this.imageLabelHBox, this.imageDisplay, this.rotateResetButtons);
		setPadding(new Insets(8));
	} // constructor for first and second image VBox
 	
        /**
         * Constructor for ArtsyVBox. This is called instead if the ArtsyVBox is intended to be the result image's ArtsyVBox 
         */
	public ArtsyVBox() {
		super(8);
		this.imageLabelHBox = new ImageLabelHBox();
		this.imageDisplay = new ArtsyImageView(new Image("file:resources/default.png",300,300, false, true));
		this.rotateResetButtons = new ImageButtonVBox(this.imageDisplay);
		getChildren().addAll(this.imageLabelHBox, this.imageDisplay, this.rotateResetButtons);
		setPadding(new Insets(8));
	} // constructor for the result image VBox
	
	//_______________Getters_____________________
	
	public ImageLabelHBox getImageLabelHBox() {
		return this.imageLabelHBox;
	}
	
	public ArtsyImageView getImageDisplay() {
		return this.imageDisplay;
	}
	
	public ImageButtonVBox getRotateResetButtons() {
		return this.rotateResetButtons;
	}
	
	//_______________Setters__________________
	
	public void setImageLabelHBox(ImageLabelHBox hBox) {
		this.imageLabelHBox = hBox;
	}
	
	public void setImageDisplay(ArtsyImageView display) {
		this.imageDisplay = display;
	}
	
	public void setRotateResetButtons(ImageButtonVBox vBox) {
		this.rotateResetButtons = vBox;
	}
	
} // ArtsyVBox
