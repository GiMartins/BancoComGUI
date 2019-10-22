package model;

public class Funcionario {
    private String nome;
    private String area;
    private String codigo;
    private String lider;

    public Funcionario(String nome, String area, String codigo, String lider) {
        this.nome = nome;
        this.area = area;
        this.codigo = codigo;
        this.lider = lider;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getLider() {
        return lider;
    }

    public void setLider(String lider) {
        this.lider = lider;
    }

    @Override
    public String toString() {
        return "Funcionario{" +
                "nome='" + nome + '\'' +
                ", area='" + area + '\'' +
                ", codigo='" + codigo + '\'' +
                ", lider='" + lider + '\'' +
                '}';
    }
}
