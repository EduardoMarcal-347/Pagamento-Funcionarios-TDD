package test;

import entity.Funcionario;
import entity.FuncionarioTerceirizado;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class FuncionarioTerceirizadoTest {

    private FuncionarioTerceirizado funcionario;

    @BeforeEach
    public void inicializaCenario(){
        try {
            funcionario = new FuncionarioTerceirizado("Julia",39,60.0,1000.0);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Test
    public void testaConstrutor() throws Exception {
        String nome = "Fernanda";
        int horasTrabalhadas = 40;
        Double valorHoras = 52.81;
        FuncionarioTerceirizado funcionarioA = new FuncionarioTerceirizado(nome, horasTrabalhadas, valorHoras);;

        Assertions.assertEquals("Fernanda", funcionarioA.getNome());
        Assertions.assertEquals(40, funcionarioA.getHorasTrabalhadas());
        Assertions.assertEquals(52.81, funcionarioA.getValorHora());
    }

    @Test
    public void testaConstrutorDadosNaoSatisfazem(){
        //o nome não pode estar vazio
        String nome = "";

        //valor maximo de horas é 40
        int horasTrabalhadas = 41;

        //valor valido por hora trabalhada está entre 4% e 10% de um salário minimo (R$1320)
        Double valorHoras = 39.6;

        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            FuncionarioTerceirizado funcionarioA = new FuncionarioTerceirizado(nome, horasTrabalhadas, valorHoras);
        });

    }

    public void testaSetterDespesasAdicionais(){
        Assertions.assertEquals(1000.0,funcionario.getDespesasAdicionais());
    }

    public void testaSetterDespesasAdicionaisInvalida(){
        Assertions.assertThrows(Exception.class, () -> {
            funcionario.setDespesasAdicionais(1001.0);
        });
    }

    @Test
    public void testaCalculoPagamento(){
        Double salarioEsperado = 3340.0;

        Assertions.assertEquals(salarioEsperado, funcionario.calcularPagamento());
    }

    public void testaCalculoPagamentoMenorSalarioMinimo() throws Exception {
        Double salarioMinimo = 1320.0;

        //valores que resultarão em um salario abaixo do minimo
        int horas = 40;
        double valorHoras = 32.0;
        Funcionario funcionarioA = new Funcionario("func", horas, valorHoras);


        Assertions.assertThrows(Exception.class, () -> {
            funcionarioA.calcularPagamento();
        });
    }
}
