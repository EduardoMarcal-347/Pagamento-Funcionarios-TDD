package entity;

public class Funcionario {

    private String nome;
    private int horasTrabalhadas;
    private Double valorHora;


    public Funcionario() {
    }

    public Funcionario(String nome, int horasTrabalhadas, Double valorHora) {
        this.nome = nome;
        this.horasTrabalhadas = horasTrabalhadas;
        this.valorHora = valorHora;
    }


}
