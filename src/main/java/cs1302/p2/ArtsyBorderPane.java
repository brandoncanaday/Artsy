package cs1302.p2;

import javafx.scene.layout.BorderPane;

public class ArtsyBorderPane extends BorderPane {
	
	private String styleString = "-fx-background-color: linear-gradient(#686868 0%, #232723 25%, #373837 75%, #757575 100%),"
				 									 + "linear-gradient(#020b02, #3a3a3a),"
				 									 + "linear-gradient(#9d9e9d 0%, #6b6a6b 20%, #343534 80%, #242424 100%),"
				 									 + "linear-gradient(#8a8a8a 0%, #6b6a6b 20%, #343534 80%, #262626 100%),"
				 									 + "linear-gradient(#777777 0%, #606060 50%, #505250 51%, #2a2b2a 100%)";

	private ArtsyVBox firstImageVBox;
	private ArtsyVBox secondImageVBox;
	private ArtsyVBox resultImageVBox;
	private MenuBarAndEffectsVBox menuBarAndEffectsVBox;
	
	public ArtsyBorderPane() {
		this.firstImageVBox = new ArtsyVBox(1);
		this.secondImageVBox = new ArtsyVBox(2);
		this.resultImageVBox = new ArtsyVBox();
		this.menuBarAndEffectsVBox = new MenuBarAndEffectsVBox(firstImageVBox, secondImageVBox, resultImageVBox);
		
		setLeft(firstImageVBox);
		setCenter(secondImageVBox);
		setRight(resultImageVBox);
		setTop(menuBarAndEffectsVBox);
		
		setStyle(styleString); 
	}
	
} // ArtsyBorderPane
