package entity;

public class FuncionarioTerceirizado extends Funcionario{

    private Double despesasAdicionais;

    public FuncionarioTerceirizado() {
    }

    public FuncionarioTerceirizado(String nome, int horasTrabalhadas, Double valorHora, Double despesasAdicionais) throws Exception {
        super(nome, horasTrabalhadas, valorHora);
        try {
            Validacao.validaDespesasAdicionais(despesasAdicionais);
        } catch (Exception e) {
            throw e;
        }
        this.despesasAdicionais = despesasAdicionais;
    }

    public Double getDespesasAdicionais() {
        return despesasAdicionais;
    }

    public void setDespesasAdicionais(Double despesasAdicionais) throws Exception {
        Validacao.validaDespesasAdicionais(despesasAdicionais);
        this.despesasAdicionais = despesasAdicionais;
    }
}
