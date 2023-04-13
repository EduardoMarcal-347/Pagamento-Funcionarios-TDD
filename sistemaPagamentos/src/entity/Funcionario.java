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

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getHorasTrabalhadas() {
        return horasTrabalhadas;
    }

    public void setHorasTrabalhadas(int horasTrabalhadas) throws Exception {
        validaEntradaNegativa(horasTrabalhadas);
        this.horasTrabalhadas = horasTrabalhadas;
    }

    public Double getValorHora() {
        return valorHora;
    }

    public void setValorHora(Double valorHora) throws Exception {
        validaEntradaNegativa(valorHora);
        this.valorHora = valorHora;
    }

    public Double calcularPagamento(){
        Double salario = horasTrabalhadas*valorHora;
        return salario;
    }

    public void validaEntradaNegativa(int valor) throws Exception {
        if (valor<0) throw new Exception();
    }

    public void validaEntradaNegativa(Double valor) throws Exception {
        if (valor<0) throw new Exception();
    }

}
