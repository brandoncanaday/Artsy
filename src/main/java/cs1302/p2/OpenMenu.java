package cs1302.p2;

import javafx.scene.control.Menu;
import javafx.scene.control.MenuItem;
import javafx.stage.Stage;
import javafx.scene.image.Image;
import javafx.stage.FileChooser;
import java.io.File;
import java.net.MalformedURLException;

public class OpenMenu extends Menu {

	private MenuItem openFirstImage;
	private MenuItem openSecondImage;
	private ArtsyVBox firstImageVBox; 
	private ArtsyVBox secondImageVBox; 
	private FileChooser fileChooser;
	
	/**
	 * Constructor for OpenMenu
	 * @param firstImageVBox the first ArtsyVBox to which the open menu needs access
	 * @param secondImageVBox the second ArtsyVBox to which the open menu needs access
	 */
	public OpenMenu(ArtsyVBox firstImageVBox, ArtsyVBox secondImageVBox) {
		super("Open");
		this.firstImageVBox = firstImageVBox;
		this.secondImageVBox = secondImageVBox;
		this.fileChooser = new FileChooser();
		this.fileChooser.getExtensionFilters().addAll(new FileChooser.ExtensionFilter("PNG", "*.png"),
													  new FileChooser.ExtensionFilter("JPG", "*.jpg"),
                									  new FileChooser.ExtensionFilter("GIF", "*.gif"),
                									  new FileChooser.ExtensionFilter("BMP", "*.bmp")); 
		
		this.openFirstImage = new MenuItem("Open Image 1");
		this.openFirstImage.setOnAction(event -> {
			fileChooser.setTitle("Select Image 1");
			File chosenFile = fileChooser.showOpenDialog(new Stage());
			if(chosenFile != null) {
				try {
					Image chosenImage = new Image(chosenFile.toURI().toURL().toString());
					firstImageVBox.getImageDisplay().setOriginalImage(chosenImage); // sets original image of image view to chosen image
					firstImageVBox.getImageDisplay().setImage(chosenImage); // sets current image of image view to chosen image
				} catch(MalformedURLException ex) {
					UserInputView.showErrorPopUp("Invalid file path/URL. This file may not exist.");
				} 
			} 
		}); // functionality for Open Image 1 button
		
		this.openSecondImage = new MenuItem("Open Image 2");
		this.openSecondImage.setOnAction(event -> {
			fileChooser.setTitle("Select Image 2");
			File chosenFile = fileChooser.showOpenDialog(new Stage());
			if(chosenFile != null) {
				try {
					Image chosenImage = new Image(chosenFile.toURI().toURL().toString());
					secondImageVBox.getImageDisplay().setOriginalImage(chosenImage); // sets original image of image view to chosen image
					secondImageVBox.getImageDisplay().setImage(chosenImage); // sets current image of image view to chosen image
				} catch(MalformedURLException ex) {
					UserInputView.showErrorPopUp("Invalid file path/URL. This file may not exist.");
				} 
			} 
		}); // functionality for Open Image 2 button
		
		getItems().addAll(openFirstImage, openSecondImage);
	} // constructor
	
	//__________________Getters___________________
	
	public MenuItem getOpenFirstImage() {
		return this.openFirstImage;
	}
	
	public MenuItem getOpenSecondImage() {
		return this.openSecondImage;
	}
	
	public ArtsyVBox getFirstImageVBox() {
		return this.firstImageVBox;
	}
	
	public ArtsyVBox getSecondImageVBox() {
		return this.secondImageVBox;
	}
	
	public FileChooser getFileChooser() {
		return this.fileChooser;
	}
	
	//_______________Setters___________________
	
	public void setOpenFirstImage(MenuItem openFirstImageItem) {
		this.openFirstImage = openFirstImageItem;
	}
	
	public void setOpenSecondImageItem(MenuItem openSecondImageItem) {
		this.openSecondImage = openSecondImageItem;
	}
	
	public void setFirstImageVBox(ArtsyVBox firstImageVBox) {
		this.firstImageVBox = firstImageVBox;
	}
	
	public void setSecondImageVBox(ArtsyVBox secondImageVBox) {
		this.secondImageVBox = secondImageVBox;
	}
	
	public void setFileChooser(FileChooser fileChooser) {
		this.fileChooser = fileChooser;
	}
	
} // OpenMenu
