package cs1302.p2;

import javafx.scene.control.MenuBar;

public class ArtsyMenuBar extends MenuBar {
	
	private FileMenu fileMenu;
	
	/**
	 * Constructor for ArtsyMenuBar
	 * @param firstImageVBox the first ArtsyVBox to which the menu bar needs access
	 * @param secondImageVBox the second ArtsyVBox to which the menu bar needs access
	 * @param resultImageVBox the result ArtsyVBox to which the menu bar needs access
	 */
	public ArtsyMenuBar(ArtsyVBox firstImageVBox, ArtsyVBox secondImageVBox, ArtsyVBox resultImageVBox) {
		super();
		this.fileMenu = new FileMenu(firstImageVBox, secondImageVBox, resultImageVBox);
		getMenus().add(this.fileMenu);
		setStyle("-fx-background-color: linear-gradient(#ffffff, #b31507)"); 
	} // constructor
	
	//________________Getters___________________
	
	public FileMenu getFileMenu() {
		return this.fileMenu;
	}
	
	//______________Setters__________________
	
	public void setFileMenu(FileMenu fileMenu) {
		this.fileMenu = fileMenu;
	}
	
} // ArtsyMenuBar
