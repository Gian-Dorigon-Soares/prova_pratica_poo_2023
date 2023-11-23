package prova_pratica_poo_2023;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RodoviaTest {
Rodovia r;
    @BeforeEach
    void setUpVazio() {
        r = new Rodovia();
    }

    @Test
    void getSigla() {
        assertEquals("0", r.getSigla());
    }

    @Test
    void setSigla() {
        r.setSigla("SC108");
        assertEquals("SC108", r.getSigla());
        assertNotEquals("SC100", r.getSigla());
    }

    @Test
    void getPericulosidade() {
        assertEquals("Baixo",r.getPericulosidade());
        assertNotEquals("Alto",r.getPericulosidade());
    }

    @Test
    void setPericulosidadeBaixo() {
    r.setPericulosidade(1);
    assertEquals("Baixo", r.getPericulosidade());
    }

    @Test
    void setPericulosidadeMedio() {
        r.setPericulosidade(2);
        assertEquals("Médio", r.getPericulosidade());
    }

    @Test
    void setPericulosidadeAlto() {
        r.setPericulosidade(3);
        assertEquals("Alto", r.getPericulosidade());
    }

    @Test
    void setPericulosidadeQueNaoExiste() {
        assertFalse(r.setPericulosidade(4));
    }

    @Test
    void setUpConstrutor() {
        r = new Rodovia("A",1);
        assertEquals("A", r.getSigla());
        assertEquals("Baixo", r.getPericulosidade());
    }
}