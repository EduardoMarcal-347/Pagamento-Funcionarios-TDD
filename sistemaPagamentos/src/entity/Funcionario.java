package entity;

public class Funcionario {

    private String nome;
    private int horasTrabalhadas;
    private Double valorHora;


    public Funcionario() {
    }

    public Funcionario(String nome, int horasTrabalhadas, Double valorHora) throws Exception {
        try {
            Validacao.validaEntradaVazia(nome);
            Validacao.validaHorasTrabalhadas(horasTrabalhadas);
            Validacao.validaValorHoras(valorHora);
        } catch (Exception e) {
            throw e;
        }
        this.nome = nome;
        this.horasTrabalhadas = horasTrabalhadas;
        this.valorHora = valorHora;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) throws Exception {
        Validacao.validaEntradaVazia(nome);
        this.nome = nome;
    }

    public int getHorasTrabalhadas() {
        return horasTrabalhadas;
    }

    public void setHorasTrabalhadas(int horasTrabalhadas) throws Exception {
        Validacao.validaEntradaNegativa(horasTrabalhadas);
        this.horasTrabalhadas = horasTrabalhadas;
    }

    public Double getValorHora() {
        return valorHora;
    }

    public void setValorHora(Double valorHora) throws Exception {
        Validacao.validaEntradaNegativa(valorHora);
        this.valorHora = valorHora;
    }

    public Double calcularPagamento(){
        Double salario = horasTrabalhadas*valorHora;
        return salario;
    }



}
