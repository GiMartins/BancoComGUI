package model;

public class Conta {

    private int numero;
    private Double saldo;

    public Conta(int numero, Double saldo) {
        this.numero = numero;
        this.saldo = saldo;
    }

    public void depositar (Double quantia){
        this.saldo += quantia;


    }

    public void  retirar(Double quantia){
        this.saldo -= quantia;
    }

    public Double getSaldo() {
        return saldo;
    }

    public int getNumero() {
        return numero;
    }

    @Override
    public String toString() {
        return "Conta{" +
                "numero=" + numero +
                ", saldo=" + saldo +
                '}';
    }
}

