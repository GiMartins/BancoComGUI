package view;

import javafx.scene.control.Label;
import javafx.scene.control.MenuBar;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class TelaCadastroSobre {

    public VBox getTelaSobre(Stage stage){

        VBox raiz = new VBox(10 );

        Label lblsobre = new Label("Desenvolvido por Giovana");

        MenuBarView menuBarView = new MenuBarView();
        MenuBar menuBar = menuBarView.getMenuBar(stage);

        raiz.getChildren().addAll(menuBar, lblsobre);


        return raiz;

    }

}
