/**
 * 
 */
package edu.cnm.deepdive.security.ui;

import java.util.ResourceBundle;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

/**
 * @author David Martinez
 *
 */
public class GuardUI extends Application {

	private static final String STYLE_SHEET = "/styles/application.css";
	private static final String LAYOUT_RESOURCE = "/layouts/Generate.fxml";
	private static final String UI_BUNDLE = "resources/ui";
	private static final String WINDOW_TITLE_KEY = "window.title";

	
	
	
		
	
	/* (non-Javadoc)
	
	 * @see javafx.application.Application#start(javafx.stage.Stage)
	 */
	@Override
	public void start(Stage primaryStage) throws Exception {
		ResourceBundle uiBundle = ResourceBundle.getBundle(UI_BUNDLE);
		Pane pane = FXMLLoader.load(getClass().getResource(LAYOUT_RESOURCE), uiBundle);
		Scene scene = new Scene(pane, 400, 450);
		scene.getStylesheets().add(getClass().getResource(STYLE_SHEET).toExternalForm());
		primaryStage.setScene(scene);
		primaryStage.setTitle(uiBundle.getString(WINDOW_TITLE_KEY));
		primaryStage.show();
	
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		launch(args);

	}

}
