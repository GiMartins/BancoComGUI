package view;

import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.MenuBar;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import model.Produto;

public class TelaCadastroProduto {

    public VBox getTelaProduto(Stage stage) {

        VBox raiz = new VBox(10);

        Label lblNomeProduto = new Label("Nome");
        Label lblpreçoProduto = new Label ("Preço");

        TextField txtNome = new TextField();
        TextField txtPreço = new TextField();

        Button btnCadastrar = new Button("Cadastrar");
        Button btnLimpar = new Button("Limpar");

        MenuBarView menuBarView = new MenuBarView();
        MenuBar menuBar = menuBarView.getMenuBar(stage);

        raiz.getChildren().addAll(menuBar, lblNomeProduto,txtNome, lblpreçoProduto, txtPreço, btnCadastrar, btnLimpar);

        btnCadastrar.setOnAction(event -> {
            Produto produto = new Produto(txtNome.getText(), Double.valueOf(txtPreço.getText()));

            System.out.println(produto);
        });

        btnLimpar.setOnAction(event -> {
            txtNome.setText("");
            txtPreço.setText("");
        });

        return raiz;

    }
}
