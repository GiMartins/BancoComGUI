package view;

import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.MenuBar;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import model.Funcionario;

public class TelaCadastroFuncionario {

    public VBox getTelaFuncionario(Stage stage){
        VBox raiz = new VBox(10);

        Label lblNomeFuncionario = new Label("Nome Funcionário");
        Label lblArea = new Label("Área");
        Label lblCodigo = new Label("Código");
        Label lblLider = new Label("Lider");
        Label lblCadastroSucesso = new Label("");

        TextField txtNomeFuncionaro = new TextField();
        TextField txtArea = new TextField();
        TextField txtCodigo = new TextField();
        TextField txtLider = new TextField();

        Button btnCadastrar = new Button("Cadastrar");
        Button btnLimpar = new Button("Limpar");

        MenuBarView menuBarView = new MenuBarView();
        MenuBar menuBar = menuBarView.getMenuBar(stage);

        raiz.getChildren().addAll(menuBar,lblCadastroSucesso, lblNomeFuncionario, txtNomeFuncionaro, lblArea, txtArea, lblCodigo, txtCodigo, lblLider,txtLider, btnCadastrar, btnLimpar);


        btnCadastrar.setOnAction(event -> {
            Funcionario funcionario = new Funcionario(txtNomeFuncionaro.getText(), txtArea.getText(), txtCodigo.getText(), txtLider.getText());
            lblCadastroSucesso.setText("Cadastrado com Sucesso");

            System.out.println(funcionario);
        });

        btnLimpar.setOnAction(event -> {
            txtNomeFuncionaro.setText("");
            txtArea.setText("");
            txtCodigo.setText("");
            txtLider.setText("");

        });


        return raiz;
    }
}

