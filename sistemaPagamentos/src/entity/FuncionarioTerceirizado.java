package entity;

public class FuncionarioTerceirizado extends Funcionario{

    private Double despesasAdicionais;

    public FuncionarioTerceirizado() {
    }

    public FuncionarioTerceirizado(String nome, int horasTrabalhadas, Double valorHora, Double despesasAdicionais) throws Exception {
        super(nome, horasTrabalhadas, valorHora);
        this.despesasAdicionais = despesasAdicionais;
    }

    public Double getDespesasAdicionais() {
        return despesasAdicionais;
    }

    public void setDespesasAdicionais(Double despesasAdicionais) {
        this.despesasAdicionais = despesasAdicionais;
    }
}
