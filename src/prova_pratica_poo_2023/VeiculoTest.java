package prova_pratica_poo_2023;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class VeiculoTest {
Veiculo v;
Pessoa p;
    ArrayList<Pessoa> arraytest;
    @BeforeEach
    void setUp() {
        v = new Veiculo();
        p = new Pessoa("Dummy",'M',20,true,false);
        arraytest = new ArrayList<>();
        arraytest.add(p);
    }

    @Test
    void getAno() {
        assertEquals((short)0, v.getAno());
    }

    @Test
    void setAno() {
        v.setAno((short)2000);
        assertEquals((short)2000, v.getAno());
    }

    @Test
    void getPassageiros() {
        ArrayList<Pessoa> aaa = new ArrayList<>();
        aaa.add(p);
        v.setPassageiros(aaa);
        assertEquals(aaa, v.getPassageiros());
    }

    @Test
    void setPassageiros() {
        Pessoa a = new Pessoa("A",'F',20,true,false);
        arraytest.clear();
        arraytest.add(a);
        assertTrue(v.setPassageiros(arraytest));
        Pessoa b = new Pessoa("B",'M',20,false,false);
        arraytest.clear();
        arraytest.add(b);
        assertFalse(v.setPassageiros(arraytest));
    }

    @Test
    void toStringteste () {
        System.out.println(v.toString());
    }
}