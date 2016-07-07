package cs1302.p2;

import javafx.scene.control.Button;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.scene.Scene;
import javafx.scene.text.Font;

public class EffectButton extends Button {
	
	private MyArtsy modifier;
	private MyArtsy.OperationType operationType;
	private ArtsyImageView[] displays;
	
	/**
	 * Constructor for EffectButton
	 * @param operationType the type of effect the button will perform on the image
	 * @param displays the number of displays to which the button will need to have access
	 */
	public EffectButton(MyArtsy.OperationType operationType, ArtsyImageView... displays) {
		super();
		this.operationType = operationType;
		this.displays = displays;
		this.modifier = new MyArtsy();
		
		switch(operationType) {
			case CHECKERS:
				setText("Checkers");
				break;
			case H_STRIPES:
				setText("Horizontal Stripes");
				break;
			case V_STRIPES:
				setText("Vertical Stripes");
				break;
			case ROTATE:
				setText("Rotate");
		} // easy way to set text depending on operation type
		
		setOnAction(event -> showUserInputView(operationType)); 
		setStyle("-fx-background-color: linear-gradient(#ffffff 0%, #fa8e82 37%, #f02f17 71%, #b31507 90%, #b31507 100%)"); 
		setFont(new Font("Verdana", 18)); 
	} // constructor 
	
	//______________Getters_________________
	
	public MyArtsy getModifier() {
		return this.modifier;
	}
	
	public ArtsyImageView[] getDisplays() {
		return this.displays;
	}
	
	public MyArtsy.OperationType getOperationType() {
		return this.operationType;
	}
	
	//_____________Setters___________________
	
	public void setModifier(MyArtsy modifier) {
		this.modifier = modifier;
	}
	
	public void setDisplay(ArtsyImageView... views) {
		this.displays = views;
	}
	
	public void setOperationType(MyArtsy.OperationType operationType) {
		this.operationType = operationType;
	}
	
	//____________Other Methods______________
	
	/**
	 * Displays a differing user input view, depending on the specified operation type.
	 * @param operationType the specified operation for which to take user input
	 */
	private void showUserInputView(MyArtsy.OperationType operationType) {
		Stage newStage = new Stage(StageStyle.UTILITY);
		
		UserInputView root = null;
		String stageTitle = "";
		// had to initialize both to please compiler, even though switching on enum values should remove need for default case
		
		switch(operationType) {
			case ROTATE:
				root = new UserInputView(newStage, modifier, operationType, displays[0], displays[0].getImage());
				stageTitle = "Rotate Options";
				break;
			case CHECKERS:
				root = new UserInputView(newStage, modifier, operationType, displays[2], displays[0].getImage(), displays[1].getImage());
				stageTitle = "Checker Options";
				break;
			case H_STRIPES:
				root = new UserInputView(newStage, modifier, operationType, displays[2], displays[0].getImage(), displays[1].getImage());
				stageTitle = "Horizontal Stripe Options";
				break;
			case V_STRIPES:
				root = new UserInputView(newStage, modifier, operationType, displays[2], displays[0].getImage(), displays[1].getImage());
				stageTitle = "Vertical Stripe Options";
		} // easy way to display differing user input window, depending on operation type
		
		newStage.setScene(new Scene(root));
		newStage.setTitle(stageTitle);
		newStage.initModality(Modality.APPLICATION_MODAL);
		newStage.show();
	}
	
} // EffectButton
