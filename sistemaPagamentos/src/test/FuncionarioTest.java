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
    public void testaSetterNome(){
        funcionario.setNome("Julya");
        Assertions.assertEquals("Julya", funcionario.getNome());
    }



}
