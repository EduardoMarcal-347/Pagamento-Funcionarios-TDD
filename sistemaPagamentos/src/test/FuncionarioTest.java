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
        Funcionario funcionario = new Funcionario("Fernanda",200,125.50);
        Assertions.assertEquals("Fernanda", funcionario.getNome());
        Assertions.assertEquals(200, funcionario.getHorasTrabalhadas());
        Assertions.assertEquals(125.50, funcionario.getValorHora());
    }

    @Test
    public void testaSetterNome(){
        funcionario.setNome("Julya");
        Assertions.assertEquals("Julya", funcionario.getNome());
    }

    @Test
    public void testaSetterHorasTrabalhadas(){
        funcionario.setHorasTrabalhadas(140);
        Assertions.assertEquals(140, funcionario.getHorasTrabalhadas());
    }

    @Test
    public void testaSetterValorHora(){
        funcionario.setValorHora(200.00);
        Assertions.assertEquals(200.00,funcionario.getValorHora());
    }
    

}
