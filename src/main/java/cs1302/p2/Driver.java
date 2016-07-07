package cs1302.p2;

import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.image.Image;

public class Driver extends Application {

	@Override
	public void start(Stage primaryStage) {
		KonamiCodeHandler konamiHandler = new KonamiCodeHandler();
		
		ArtsyBorderPane root = new ArtsyBorderPane();
		
		Scene scene = new Scene(root);
		scene.setOnKeyPressed(konamiHandler);
		
		primaryStage.setTitle("Artsy!");
		primaryStage.setScene(scene);
		primaryStage.sizeToScene();
		primaryStage.setResizable(false);
		primaryStage.getIcons().add(new Image("file:resources/ArtsyGrumpyCatIcon.png"));
		primaryStage.show();
	} // start

	public static void main(String[] args) {
		launch(args);
	} // main
	
} // Driver
