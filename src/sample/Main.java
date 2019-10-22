package sample;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import model.Cliente;
import model.Conta;
import model.Funcionario;
import model.Produto;


public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        VBox raiz = new VBox();

        raiz.getChildren().addAll(getMenuBar(primaryStage));



        primaryStage.setTitle("Página Inicial");
        primaryStage.setScene(new Scene(raiz, 500, 275));
        primaryStage.show();
    }

    private VBox getTelaCadastro(Stage stage) {
        VBox raiz = new VBox();

        Label lblCliente = new Label ("Nome");
        TextField txtCliente = new TextField();
        Label lblCpf = new Label ("CPF");
        TextField txtCpf = new TextField();
        Label lblNumeroConta = new Label("Numero da Conta");
        TextField txtNumeroConta = new TextField();
        Button btnCadastrar = new Button ("Cadastrar");
        Button btnLimpar = new Button ("Limpar");

        MenuBar menuBar = getMenuBar(stage);


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

    private  VBox getTelaDepositarRetirar(Stage stage){
        Conta conta = new Conta( 123, 10.0);
        Cliente cliente = new Cliente( "Giovana", "12", conta);

        VBox raiz = new VBox(10);

        Label numeroConta = new Label("conta " + cliente.getConta().getNumero());
        Label nomeCliente = new Label( "Nome: " + cliente.getNome());
        TextField valorTransacao = new TextField();
        Button btnDepositer = new Button("Depositar");
        Button btnRetirar = new Button ("Retirar");
        Label saldoConta = new Label("Saldo: " + cliente.getConta().getSaldo());

        MenuBar menuBar = getMenuBar(stage);


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

    private VBox getTelaSobre(Stage stage){

        VBox raiz = new VBox(10 );

        Label lblsobre = new Label("Desenvolvido por Giovana");

        MenuBar menuBar = getMenuBar(stage);

        raiz.getChildren().addAll(menuBar, lblsobre);


        return raiz;

    }

    private VBox getTelaProduto(Stage stage) {

        VBox raiz = new VBox(10);

        Label lblNomeProduto = new Label("Nome");
        Label lblpreçoProduto = new Label ("Preço");

        TextField txtNome = new TextField();
        TextField txtPreço = new TextField();

        Button btnCadastrar = new Button("Cadastrar");
        Button btnLimpar = new Button("Limpar");

        MenuBar menuBar = getMenuBar(stage);

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

    private VBox getTelaFuncionario(Stage stage){
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

        MenuBar menuBar = getMenuBar(stage);

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

    private MenuBar getMenuBar(Stage stage) {
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
            stage.setScene(new Scene(getTelaCadastro(stage), 500, 275));
            stage.show();

        });

        depRet.setOnAction(event -> {
            stage.setTitle("Depositar/Rtirar");
            stage.setScene(new Scene(getTelaDepositarRetirar(stage), 500, 275));
            stage.show();
        });

        desenvolvimento.setOnAction(event -> {
            stage.setTitle("Desenvolvimento");
            stage.setScene(new Scene(getTelaSobre(stage), 500,275));
            stage.show();
        });

        produto.setOnAction(event -> {
            stage.setTitle("Produto");
            stage.setScene(new Scene(getTelaProduto(stage), 500, 275));
            stage.show();
        });

        funcionario.setOnAction(event -> {
            stage.setTitle("Funcionário");
            stage.setScene(new Scene(getTelaFuncionario(stage), 500, 400));
            stage.show();
        });




        return menuBar;
    }


    public static void main(String[] args) {
        launch(args);
    }
}
