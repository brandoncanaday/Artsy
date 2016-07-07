package cs1302.p2;

import javafx.scene.control.Menu;
import javafx.scene.control.MenuItem;
import javafx.application.Platform;

public class FileMenu extends Menu {
	
	private OpenMenu openMenu;
	private SaveMenuItem saveResultAsItem;
	private MenuItem exitItem;
	
	/**
	 * Constructor for FileMenu
	 * @param firstImageVBox the first ArtsyVBox to which the file menu needs access
	 * @param secondImageVBox the second ArtsyVBox to which the file menu needs access
	 * @param resultImageVBox the result ArtsyVBox to which the file menu needs access
	 */
	public FileMenu(ArtsyVBox firstImageVBox, ArtsyVBox secondImageVBox, ArtsyVBox resultImageVBox) {
		super("File");
		this.openMenu = new OpenMenu(firstImageVBox, secondImageVBox);
		this.saveResultAsItem = new SaveMenuItem(resultImageVBox);
		this.exitItem = new MenuItem("Exit");
		this.exitItem.setOnAction(event -> Platform.exit()); // quits entire program
		getItems().addAll(this.openMenu, this.saveResultAsItem, this.exitItem);
	} // constructor
	
	//______________Getters________________
	
	public OpenMenu getOpenMenu() {
		return this.openMenu;
	}
	
	public SaveMenuItem getSaveResultAsItem() {
		return this.saveResultAsItem;
	}
	
	public MenuItem getExitItem() {
		return this.exitItem;
	}
	
	//______________Setters_______________
	
	public void setOpenMenu(OpenMenu openMenu) {
		this.openMenu = openMenu;
	}
	
	public void setSaveResultAsItem(SaveMenuItem saveMenuItem) {
		this.saveResultAsItem = saveMenuItem;
	}
	
	public void setExitItem(MenuItem exitItem) {
		this.exitItem = exitItem;
	}
	
} // FileMenu
