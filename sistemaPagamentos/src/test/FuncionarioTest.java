package test;

import entity.Funcionario;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class FuncionarioTest {

    //arrange
    //act
    //assign

    private Funcionario funcionario;
    @BeforeEach
    public void inicializaCenario(){
        try {
            funcionario = new Funcionario("Julia",39,60.0);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Test
    public void testaConstrutor() throws Exception {
        String nome = "Fernanda";
        int horasTrabalhadas = 40;
        Double valorHoras = 52.81;
        Funcionario funcionarioA = new Funcionario(nome, horasTrabalhadas, valorHoras);;

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
                Funcionario funcionarioA = new Funcionario(nome, horasTrabalhadas, valorHoras);
            });

    }

    @Test
    public void testaSetterNome(){
        try {
            funcionario.setNome("Julya");
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        Assertions.assertEquals("Julya", funcionario.getNome());
    }

    @Test
    public void testaSetterNomeParametroVazio(){
        Assertions.assertThrows(Exception.class, () -> {
            funcionario.setNome("");
        });
    }

    @Test
    public void testaSetterHorasTrabalhadas(){
        try {
            funcionario.setHorasTrabalhadas(140);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        Assertions.assertEquals(140, funcionario.getHorasTrabalhadas());
    }
    @Test
    public void testaSetterHorasTrabalhadasParametroNegativo(){
        Assertions.assertThrows(Exception.class, () -> {
            funcionario.setHorasTrabalhadas(-1);
        });
    }

    @Test
    public void testaSetterValorHora(){
        try {
            funcionario.setValorHora(200.00);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        Assertions.assertEquals(200.00,funcionario.getValorHora());
    }

    @Test
    public void testaSetterValorHoraParametroNegativo(){
        Assertions.assertThrows(Exception.class, () -> {
            funcionario.setValorHora(-1.0);
        });
    }

    @Test
    public void testaCalculoPagamento(){
        Double salarioEsperado = 2340.0;

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
