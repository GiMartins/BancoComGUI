package view;

import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.MenuBar;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import model.Cliente;
import model.Conta;

public class TelaCadastroDepositarRetirar {

    public VBox getTelaDepositarRetirar(Stage stage){
        Conta conta = new Conta( 123, 10.0);
        Cliente cliente = new Cliente( "Giovana", "12", conta);

        VBox raiz = new VBox(10);

        Label numeroConta = new Label("conta " + cliente.getConta().getNumero());
        Label nomeCliente = new Label( "Nome: " + cliente.getNome());
        TextField valorTransacao = new TextField();
        Button btnDepositer = new Button("Depositar");
        Button btnRetirar = new Button ("Retirar");
        Label saldoConta = new Label("Saldo: " + cliente.getConta().getSaldo());

        MenuBarView menuBarView = new MenuBarView();
        MenuBar menuBar = menuBarView.getMenuBar(stage);



        raiz.getChildren().addAll(menuBar, numeroConta, nomeCliente, valorTransacao, btnDepositer, btnRetirar, saldoConta);

        btnDepositer.setOnAction(event -> {
            conta.depositar(Double.valueOf(valorTransacao.getText()));
            saldoConta.setText("Saldo: " + cliente.getConta().getSaldo());

        });
        btnRetirar.setOnAction(event -> {
            conta.retirar(Double.valueOf(valorTransacao.getText()));
            saldoConta.setText(("Saldo: " + cliente.getConta().getSaldo()));
        });

        return raiz;
    }
}
