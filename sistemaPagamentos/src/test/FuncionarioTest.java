package test;

import entity.Funcionario;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class FuncionarioTest {

    //arrange
    //act
    //assign

    private Funcionario funcionario;
    @BeforeEach
    public void inicializaCenario(){
        funcionario = new Funcionario("Julia",160,250.50);
    }

    @Test
    public void testaConstrutor(){
        String nome = "Fernanda";
        int horasTrabalhadas = 40;
        Double valorHoras = 52.8;

        Funcionario funcionarioA = new Funcionario(nome, horasTrabalhadas, valorHoras);

        Assertions.assertEquals("Fernanda", funcionarioA.getNome());
        Assertions.assertEquals(40, funcionarioA.getHorasTrabalhadas());
        Assertions.assertEquals(52.8, funcionarioA.getValorHora());
    }

    @Test
    public void testaConstrutorDadosNaoSatisfazem(){
        String nome = "funcionario";

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
        funcionario.setNome("Julya");
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
        funcionario.setHorasTrabalhadas(140);
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
        funcionario.setValorHora(200.00);
        Assertions.assertEquals(200.00,funcionario.getValorHora());
    }

    @Test
    public void testaSetterValorHoraParametroNegativo(){
        Assertions.assertThrows(Exception.class, () -> {
            funcionario.setValorHora(-1.0);
        });
    }


}
