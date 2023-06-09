package entity;

public class Validacao{

    public static void validaEntradaNegativa(int valor) throws Exception {
        if (valor<0) throw new IllegalArgumentException("A entrada não pode ser negativa");
    }

    public static void validaEntradaNegativa(Double valor) throws Exception {
        if (valor<0) throw new IllegalArgumentException("A entrada não pode ser negativa");
    }

    public static void validaEntradaVazia(String valor) throws Exception {
        if(valor.equals("")) throw new IllegalArgumentException("O nome não pode ser vazio");
    }

    public static void validaHorasTrabalhadas(int entrada) throws Exception{
        if(entrada > 40) throw new IllegalArgumentException("As horas trabalhadas devem ser no máximo 40");
    }

    public static void validaValorHoras(Double entrada) throws Exception{
        if(entrada<1320*0.04 || entrada>1320*0.10) throw new IllegalArgumentException("O valor das horas deve estar entre 4% e 10% do salario minimo(R$1320)");
    }

    public static void validaDespesasAdicionais(Double entrada) throws Exception {
        if(entrada>1000) throw new IllegalArgumentException("As despesas devem ser no máximo R$1000");
    }

    public static void validaSalario(Double salario) throws Exception {
        if(salario<1320) throw new IllegalArgumentException("O salário deve ser maior que R$1320");
    }
}
