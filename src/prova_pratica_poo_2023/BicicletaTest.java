package prova_pratica_poo_2023;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class BicicletaTest {
Bicicleta b;
Pessoa p;
ArrayList<Pessoa> passageiros;
    @BeforeEach
    void setUpVazio() {
        p = new Pessoa("Teste",'F',18,true,false);
        passageiros = new ArrayList<>();
        passageiros.add(p);
        b = new Bicicleta();
    }

    @Test
    void setUp() {
        b = new Bicicleta((short)2000,passageiros);
    }

    @Test
    void toStringteste () {
        System.out.println(b.toString());
    }
}