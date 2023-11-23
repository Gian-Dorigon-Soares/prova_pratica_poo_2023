package prova_pratica_poo_2023;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PessoaTest {
    Pessoa p;

    @BeforeEach
    void setUpVazio () {
        p = new Pessoa();
    }

    @Test
    void getNome() {
        assertEquals("*", p.getNome());
    }

    @Test
    void setNome() {
        p.setNome("Teste");
        assertEquals("Teste", p.getNome());
        assertNotEquals("Erro", p.getNome());
    }

    @Test
    void getSexo() {
        assertEquals('M', p.getSexo());
    }

    @Test
    void setSexo() {
        assertTrue(p.setSexo('F'));
        assertFalse(p.setSexo('A'));
    }

    @Test
    void getIdade() {
        assertEquals(0, p.getIdade());
    }

    @Test
    void setIdade() {
        assertTrue(p.setIdade(20));
        assertFalse(p.setIdade(-10));
    }

    @Test
    void isCondutor() {
        assertEquals(false, p.isCondutor());
        assertNotEquals(true, p.isCondutor());
    }

    @Test
    void setCondutor() {
        p.setCondutor(true);
        assertEquals(true, p.isCondutor());
    }

    @Test
    void setCondutorErro () {
        p.setCondutor(true);
        assertNotEquals(false, p.isCondutor());
    }

    @Test
    void isEmbreagado() {
        assertEquals(false, p.isEmbreagado());
        assertNotEquals(true, p.isEmbreagado());
    }

    @Test
    void setEmbreagado() {
        p.setEmbreagado(true);
        assertEquals(true, p.isEmbreagado());

    }

    @Test
    void setUpNaoVazio() {
        p = new Pessoa("Teste",'F',20,true,false);
        assertEquals("Teste", p.getNome());
        assertNotEquals("A", p.getNome());
        assertEquals('F', p.getSexo());
        assertNotEquals('A', p.getSexo());
        assertEquals(20, p.getIdade());
        assertNotEquals(10, p.getIdade());
        assertEquals(true, p.isCondutor());
        assertNotEquals(false, p.isCondutor());
        assertEquals(false, p.isEmbreagado());
        assertNotEquals(true, p.isEmbreagado());
    }
}