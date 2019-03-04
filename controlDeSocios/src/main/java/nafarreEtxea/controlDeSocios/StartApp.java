package nafarreEtxea.controlDeSocios;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

/**
 * Hello world!
 *
 */
public class StartApp extends Application
{
	
	private final String ID_CSS = "background";
	private final String ICON_APP = "icons/icon.png";
	private final String TITLE = "Control de Socios";
	
    public static void main( String[] args )
    {
       launch();
    }

	@Override
	public void start(Stage stage) throws Exception {
		try {
		
		generateTitle(stage);
        
		Scene scene = generateStackPane();
		
		scene.getStylesheets().addAll(this.getClass().getClassLoader().getResource("css/styleSheet.css").toExternalForm());
		
        stage.setScene(scene);
        stage.setMaximized(true); 
        stage.show();
		} catch (Exception exception) {
			throw new Exception("Ha surgido un problema al abrir la aplicación", exception);
		}
		
		/**
		 * https://wimdeblauwe.wordpress.com/2017/09/18/using-spring-boot-with-javafx/
		 * Example SpringBoot and JavaFX
		 */
		
	}

	private Scene generateStackPane() {
		
		String javaVersion = System.getProperty("java.version");
        String javafxVersion = System.getProperty("javafx.version");
        Label l = new Label("Hello, JavaFX " + javafxVersion + ", running on Java " + javaVersion + ".");
		
        StackPane root = new StackPane(l);
        root.setId(ID_CSS);
        
        return new Scene(root, 1020, 768);
		
	}

	private void generateTitle(final Stage stage) {
		stage.setTitle(TITLE);
		stage.getIcons().add(new Image(this.getClass().getClassLoader().getResourceAsStream(ICON_APP)));
	}
}
