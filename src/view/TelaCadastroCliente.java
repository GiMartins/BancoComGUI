package view;

import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.MenuBar;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import model.Cliente;
import model.Conta;

public class TelaCadastroCliente {

    public VBox getTelaCadastro(Stage stage) {
        VBox raiz = new VBox();

        Label lblCliente = new Label ("Nome");
        TextField txtCliente = new TextField();
        Label lblCpf = new Label ("CPF");
        TextField txtCpf = new TextField();
        Label lblNumeroConta = new Label("Numero da Conta");
        TextField txtNumeroConta = new TextField();
        Button btnCadastrar = new Button ("Cadastrar");
        Button btnLimpar = new Button ("Limpar");

        MenuBarView menuBarView = new MenuBarView();
        MenuBar menuBar = menuBarView.getMenuBar(stage);


        raiz.getChildren().addAll(menuBar, lblCliente, txtCliente, lblCpf, txtCpf, lblNumeroConta, txtNumeroConta, btnCadastrar, btnLimpar);


        btnCadastrar.setOnAction(event -> {
            Conta conta = new Conta(Integer.valueOf(txtNumeroConta.getText()), 0.0);
            Cliente cliente = new Cliente(txtCliente.getText(), txtCpf.getText(), conta);
            System.out.println(cliente);

        });

        btnLimpar.setOnAction(Event -> {
            txtCliente.setText("");
            txtCpf.setText("");
            txtNumeroConta.setText("");

        });
        return raiz;
    }
}
