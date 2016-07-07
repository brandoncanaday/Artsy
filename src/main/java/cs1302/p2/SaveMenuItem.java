package cs1302.p2;

import javafx.embed.swing.SwingFXUtils;
import javafx.scene.control.MenuItem;
import javafx.stage.Stage;
import javafx.scene.image.Image;
import javafx.stage.FileChooser;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

public class SaveMenuItem extends MenuItem {
	
	private ArtsyVBox resultImageVBox;
	private FileChooser fileChooser;
	
	/**
	 * Constructor for SaveMenuItem
	 * @param resultImageVBox the result ArtsyVBox to which the save item needs access
	 */
	public SaveMenuItem(ArtsyVBox resultImageVBox) {
		super("Save Result As");
		this.resultImageVBox = resultImageVBox;
		this.fileChooser = new FileChooser();
		this.fileChooser.setTitle("Save Result Image");
		fileChooser.getExtensionFilters().addAll(new FileChooser.ExtensionFilter("PNG", "*.png"),
											     new FileChooser.ExtensionFilter("JPG", "*.jpg"),
                								 new FileChooser.ExtensionFilter("GIF", "*.gif"),
                								 new FileChooser.ExtensionFilter("BMP", "*.bmp"));
		setOnAction(event -> {
			File chosenFilePath = fileChooser.showSaveDialog(new Stage());
			if(chosenFilePath != null) {
				String savedFileName = chosenFilePath.getName();
				String savedFileExtension = savedFileName.substring(savedFileName.indexOf(".") + 1, savedFileName.length());
				Image resultImage = resultImageVBox.getImageDisplay().getImage();
				try {
					ImageIO.write(SwingFXUtils.fromFXImage(resultImage, null), savedFileExtension, chosenFilePath);
				} catch(IOException ex) {
					UserInputView.showErrorPopUp("Error. Could not save image to desired location.");
				} 
			} 
		}); 
	} // constructor
	
	//________________Getters_________________
	
	public ArtsyVBox getResultImageVBox() {
		return this.resultImageVBox;
	}
	
	public FileChooser getFileChooser() {
		return this.fileChooser;
	}
	
	//_____________Setters_________________
	
	public void setResultImageVBox(ArtsyVBox resultImageVBox) {
		this.resultImageVBox = resultImageVBox;
	}
	
	public void setFileChooser(FileChooser fileChooser)	{
		this.fileChooser = fileChooser;
	}
	
} // SaveMenuItem
