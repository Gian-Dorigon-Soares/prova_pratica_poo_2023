package prova_pratica_poo_2023;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class VeiculoCargaTest {
VeiculoCarga vc;
    @BeforeEach
    void setUpVazio() {
        vc = new VeiculoCarga();
    }

    @Test
    void getCarga() {
        assertEquals(0, vc.Carga);
    }

    @Test
    void setCarga() {
        vc.setCarga(100);
        assertEquals(100, vc.getCarga());
    }
    @Test
    void Construtor () {
        Pessoa p = new Pessoa();
        ArrayList<Pessoa> passageiros = new ArrayList<>();
        passageiros.add(p);
        vc = new VeiculoCarga((short)2000, passageiros, 100);
        assertEquals((short)2000, vc.getAno());
        assertEquals(passageiros, vc.getPassageiros());
        assertEquals(100, vc.getCarga());
    }
    @Test
    void toStringteste () {
        System.out.println(vc.toString());
    }
}