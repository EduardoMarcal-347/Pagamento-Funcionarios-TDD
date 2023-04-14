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
        FuncionarioTerceirizado funcionarioA = new FuncionarioTerceirizado("Fernanda", 40, 52.81,1000.00);;
        Assertions.assertEquals(1000, funcionario.getDespesasAdicionais());

    }

    @Test
    public void testaConstrutorDadosNaoSatisfazem(){
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            FuncionarioTerceirizado funcionarioA = new FuncionarioTerceirizado("Fernanda", 40, 52.81,1001.00);
        });
    }

    @Test
    public void testaSetterDespesasAdicionais(){
        Assertions.assertEquals(1000.0,funcionario.getDespesasAdicionais());
    }

    @Test
    public void testaSetterDespesasAdicionaisInvalida(){
        Assertions.assertThrows(Exception.class, () -> {
            funcionario.setDespesasAdicionais(1001.0);
        });
    }

    @Test
    public void testaCalculoPagamento() throws Exception {
        Double salarioEsperado = 3340.0;

        Assertions.assertEquals(salarioEsperado, funcionario.calcularPagamento());
    }

    @Test
    public void testaCalculoPagamentoMenorSalarioMinimo() throws Exception {
        Double salarioMinimo = 1320.0;

        //valores que resultarão em um salario abaixo do minimo
        int horas = 40;
        double valorHoras = 60;
        FuncionarioTerceirizado funcionarioA = new FuncionarioTerceirizado("func", horas, valorHoras,0.0);
        funcionarioA.setValorHora(32.0);

        Assertions.assertThrows(Exception.class, () -> {
            funcionarioA.calcularPagamento();
        });
    }
}
