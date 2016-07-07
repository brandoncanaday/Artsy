package cs1302.p2;

import javafx.scene.layout.VBox;
import cs1302.p2.MyArtsy.OperationType;
import javafx.geometry.Insets;
import javafx.scene.layout.HBox;

public class MenuBarAndEffectsVBox extends VBox {

	private ArtsyVBox firstImageVBox;
	private ArtsyVBox secondImageVBox;
	private ArtsyVBox resultImageVBox;
	// the ArtsyVBoxes that need to be accessed by both the menu bar and the effect buttons
	
	private EffectButton checkersButton;
	private EffectButton horizontalStripesButton;
	private EffectButton verticalStripesButton;
	// the effect buttons 
	
	private ArtsyMenuBar artsyMenuBar;
	private HBox effectButtonHBox;
	// the containers
	
	/**
	 * Constructor for MenuBarAndEffectsVBox
	 * @param firstImageVBox the first ArtsyVBox to which the VBox needs access
	 * @param secondImageVBox the second ArtsyVBox to which the VBox needs access
	 * @param resultImageVBox the result ArtsyVBox to which the VBox needs access
	 */
	public MenuBarAndEffectsVBox(ArtsyVBox firstImageVBox, ArtsyVBox secondImageVBox, ArtsyVBox resultImageVBox) {
		this.firstImageVBox = firstImageVBox; // first image container
		this.secondImageVBox = secondImageVBox; // second image container
		this.resultImageVBox = resultImageVBox; // result image container
		// image containers
		
		this.checkersButton = new EffectButton(OperationType.CHECKERS, 
											   firstImageVBox.getImageDisplay(), 
											   secondImageVBox.getImageDisplay(), 
											   resultImageVBox.getImageDisplay());
		this.horizontalStripesButton = new EffectButton(OperationType.H_STRIPES, 
				   										firstImageVBox.getImageDisplay(), 
				   										secondImageVBox.getImageDisplay(), 
				   										resultImageVBox.getImageDisplay());
		this.verticalStripesButton = new EffectButton(OperationType.V_STRIPES, 
				   									  firstImageVBox.getImageDisplay(), 
				   									  secondImageVBox.getImageDisplay(), 
				   									  resultImageVBox.getImageDisplay());
		// effect buttons
		
		this.artsyMenuBar = new ArtsyMenuBar(firstImageVBox, secondImageVBox, resultImageVBox);
		
		effectButtonHBox = new HBox(10);
		effectButtonHBox.getChildren().addAll(checkersButton, horizontalStripesButton, verticalStripesButton);
		effectButtonHBox.setPadding(new Insets(8, 8, 0, 8));
		getChildren().addAll(artsyMenuBar, effectButtonHBox);
	} // constructor
	
} // MenuBarAndEffectsVBox
