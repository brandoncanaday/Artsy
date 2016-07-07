package cs1302.p2;

import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class UserInputView extends VBox {
	
	private VBox inputVBox = new VBox(8);
	private HBox cancelOKHBox = new HBox(10);
	private Button cancelButton = new Button("Cancel");
	private Button okButton = new Button("OK");
	// always the same
	
	private Label instructionsLabel;
	private TextField userInputField;
	// change based on operation type
	
	private Stage stage;
	private MyArtsy modifier;
	private MyArtsy.OperationType operation;
	private ArtsyImageView display;
	private Image[] images;
	// come from constructor
	
	/**
	 * Constructor for UserInputView
	 * @param stage the stage to which this view will need access
	 * @param modifier the instance of MyArtsy which will do the modifying
	 * @param operation the type of operation for which user input information will be displayed
	 * @param display the image view to which the performOperation method will need access
	 * @param images the number of images to which the performOperation method will need access
	 */
	public UserInputView(Stage stage, MyArtsy modifier, MyArtsy.OperationType operation, ArtsyImageView display, Image...images) {
		super(15); // sets vertical spacing between the inputVBox and the cancelOKHBox
		
		this.stage = stage;
		this.modifier = modifier;
		this.operation = operation;
		this.display = display;
		this.images = images;
		// allows methods to access without passing them all in as parameters
		
		switch(operation) {
			case CHECKERS:
				instructionsLabel = new Label("Enter desired checker size, in pixels:");
				userInputField = new TextField("(2, 10, 15, 30, etc.)");
				break;
			case H_STRIPES:
				instructionsLabel = new Label("Enter desired stripe height, in pixels:");
				userInputField = new TextField("(2, 10, 15, 30, etc.)");
				break;
			case V_STRIPES:
				instructionsLabel = new Label("Enter desired stripe width, in pixels:");
				userInputField = new TextField("(2, 10, 15, 30, etc.)");
				break;
			case ROTATE:
				instructionsLabel = new Label("Enter desired rotation angle, in degrees:");
				userInputField = new TextField("(45, 90, 180, 270, etc.)");
		} // easy way to set text depending on operation type
		
		cancelButton.setOnAction(event -> stage.close());
		okButton.setOnAction(event -> {
			try {
				performImageOperation();
			} // if parsing degrees was successful
			catch(NumberFormatException ex) {
				showErrorPopUp("Invalid input. Please enter an integer value > 0.");
			} // if parsing degrees was unsuccessful
		}); 
		
		inputVBox.getChildren().addAll(instructionsLabel, userInputField);
		cancelOKHBox.getChildren().addAll(cancelButton, okButton);
		getChildren().addAll(inputVBox, cancelOKHBox);
		setPadding(new Insets(10, 50, 10, 50));
	} // constructor
	
	//__________Getters__________________
	
	public VBox getInputVBox() {
		return this.inputVBox;
	}
	
	public HBox getCancelOKHBox() {
		return this.cancelOKHBox;
	}
	
	public Button getCancelButton() {
		return this.cancelButton;
	}
	
	public Button getOKButton() {
		return this.okButton;
	}
	
	public Label getInstructions() {
		return this.instructionsLabel;
	}
	
	public TextField getUserInputField() {
		return this.userInputField;
	}
	
	public Stage getStage() {
		return this.stage;
	}
	
	public MyArtsy getModifier() {
		return this.modifier;
	}
	
	public MyArtsy.OperationType getOperation() {
		return this.operation;
	}
	
	public ArtsyImageView getDisplay() {
		return this.display;
	}
	
	public Image[] getImages() {
		return this.images;
	}
	
	//_________Setters_________________ 
	
	public void setInputVBox(VBox box) {
		this.inputVBox = box;
	}
	
	public void setCancelOKHBox(HBox box) {
		this.cancelOKHBox = box;
	}
	
	public void setCancelButton(Button btn) {
		this.cancelButton = btn;
	}
	
	public void setOKButton(Button btn) {
		this.okButton = btn;
	}
	
	public void setInstructions(Label label) {
		this.instructionsLabel = label;
	}
	
	public void setUserInputField(TextField field) {
		this.userInputField = field;
	}
	
	public void setStage(Stage stage) {
		this.stage = stage;
	}
	
	public void setModifier(MyArtsy modifier) {
		this.modifier = modifier;
	}
	
	public void setOperation(MyArtsy.OperationType operationType) {
		this.operation = operationType;
	}
	
	public void setDisplay(ArtsyImageView display) {
		this.display = display;
	}
	
	public void setImages(Image[] images) {
		this.images = images;
	}
	
	//___________Other Methods_______________
	
	/**
	 * Utility method that displays an error pop-up window, prompting user to enter a numeric value.
	 * @param errorMessage the message to be displayed
	 */
	public static void showErrorPopUp(String errorMessage) {
		Stage errorStage = new Stage(StageStyle.UTILITY);
		
		BorderPane root = new BorderPane();
		root.setCenter(new Label(errorMessage));
		root.setPadding(new Insets(20, 50, 20, 50));
		
		Scene scene = new Scene(root);
		
		errorStage.setScene(scene);
		errorStage.setTitle("ERROR");
		errorStage.initModality(Modality.APPLICATION_MODAL);
		errorStage.show();
	}
	
	/**
	 * Performs differing operations on target image, depending on operation type specified in class constructor, then closes the stage.
	 */
	private void performImageOperation() {
		String input = userInputField.getCharacters().toString();
		int numericValue = Integer.parseInt(input); // takes numeric input from user
		if(numericValue > 0) {
			switch(this.operation) {
			case CHECKERS:
				display.setImage(modifier.doCheckers(images[0], images[1], numericValue));
				break;
			case H_STRIPES:
				display.setImage(modifier.doHorizontalStripes(images[0], images[1], numericValue));
				break;
			case V_STRIPES:
				display.setImage(modifier.doVerticalStripes(images[0], images[1], numericValue));
				break;
			case ROTATE:
				display.setImage(modifier.doRotate(images[0], numericValue));
		} // performs operation on image depending on operation type
		stage.close();
		} else {
			showErrorPopUp("Invalid input. Please enter an integer value > 0."); 
		}
	}
	
} // UserInputView
