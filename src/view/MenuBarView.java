package view;

import javafx.scene.Scene;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.stage.Stage;

public class MenuBarView {

    public MenuBar getMenuBar(Stage stage) {
        MenuBar menuBar = new MenuBar();
        Menu cadastrar = new Menu ("Cadastrar");
        MenuItem cadastrarCliente = new MenuItem("Cliente");
        Menu operaçoes = new Menu("Operações");
        MenuItem depRet = new MenuItem("Depositar/Retirar");
        Menu sobre = new Menu ("Sobre");
        MenuItem desenvolvimento = new MenuItem("Densenvolvimento");
        MenuItem produto = new MenuItem("Produto");
        MenuItem funcionario = new MenuItem("Funcionário");


        cadastrar.getItems().addAll(cadastrarCliente, produto, funcionario);
        operaçoes.getItems().addAll(depRet);
        menuBar.getMenus().addAll(cadastrar, operaçoes, sobre);
        sobre.getItems().addAll(desenvolvimento);


        //Abrir tela de cadastro de cliente
        cadastrarCliente.setOnAction(event -> {
            stage.setTitle("Cadastrar Cliente");
            TelaCadastroCliente telaCadastroClienteView = new TelaCadastroCliente();
            stage.setScene(new Scene(telaCadastroClienteView.getTelaCadastro(stage), 500, 275));
            stage.show();

        });

        depRet.setOnAction(event -> {
            stage.setTitle("Depositar/Rtirar");
            TelaCadastroCliente telaCadastroClienteView = new TelaCadastroCliente();
            stage.setScene(new Scene(telaCadastroClienteView.getTelaCadastro(stage), 500, 275));
            stage.show();
        });

        desenvolvimento.setOnAction(event -> {
            stage.setTitle("Desenvolvimento");
            TelaCadastroSobre telaCadastroSobreView = new TelaCadastroSobre();
            stage.setScene(new Scene(telaCadastroSobreView.getTelaSobre(stage), 500,275));
            stage.show();
        });

        produto.setOnAction(event -> {
            stage.setTitle("Produto");
            TelaCadastroProduto telaCadastroProdutoView = new TelaCadastroProduto();
            stage.setScene(new Scene(telaCadastroProdutoView.getTelaProduto(stage), 500, 275));
            stage.show();
        });

        funcionario.setOnAction(event -> {
            stage.setTitle("Funcionário");
            TelaCadastroFuncionario telaCadastroFuncionarioView = new TelaCadastroFuncionario();
            stage.setScene(new Scene(telaCadastroFuncionarioView.getTelaFuncionario(stage), 500, 400));
            stage.show();
        });




        return menuBar;
    }
}
