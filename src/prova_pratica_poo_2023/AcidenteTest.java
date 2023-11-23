package prova_pratica_poo_2023;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class AcidenteTest {
    Pessoa p;
    Rodovia r,r2,r3;
    Veiculo v,vc,b;
    Acidente a,a2,a3,a4;
    ArrayList<Veiculo> envolvidos;
    ArrayList<Veiculo> envolvidos2;
    ArrayList<Pessoa> passageiros;
    ArrayList<Acidente> acidentes;

    @BeforeEach
    void setUp() {
        p = new Pessoa("TesteA", 'M',20,true,true);
        passageiros = new ArrayList<>();
        passageiros.add(p);
        r = new Rodovia("Teste1", 3);
        r2 = new Rodovia("Teste2", 2);
        r3 = new Rodovia("Teste3", 1);
        v =new Veiculo();
        vc =new VeiculoCarga((short) 2014,passageiros,1000);
        b =new Bicicleta();
        envolvidos = new ArrayList<>();
        envolvidos.add(v);
        envolvidos.add(b);
        a = new Acidente(r,1,3,(short)02,envolvidos);
        a2 = new Acidente(r2,3,6,(short)06,envolvidos);
        a3 = new Acidente(r3,0,2,(short)12,envolvidos);
        a4 = new Acidente(r3,0,2,(short)12,envolvidos);
        envolvidos2 = new ArrayList<>();
        envolvidos2.add(vc);
        envolvidos2.add(b);
        a = new Acidente(r,1,3,(short)02,envolvidos2);
        acidentes = new ArrayList<>();
        acidentes.add(a);
        acidentes.add(a2);
        acidentes.add(a3);
        acidentes.add(a4);
    }

    @Test
    void getRodoviaAcidente() {
        assertEquals(r,a.getRodoviaAcidente());
    }

    @Test
    void setRodoviaAcidente() {
        Rodovia r2 = new Rodovia("Teste1", 3);
        a.setRodoviaAcidente(r2);
        assertEquals(r2, a.getRodoviaAcidente());
    }

    @Test
    void getVitimasFatais() {
        assertEquals(1, a.getVitimasFatais());
    }

    @Test
    void setVitimasFatais() {
        a.setVitimasFatais(3);
        assertEquals(3, a.getVitimasFatais());
    }

    @Test
    void getFeridos() {
        assertEquals(3,a.getFeridos());
    }

    @Test
    void setFeridos() {
        a.setFeridos(4);
        assertEquals(4,a.getFeridos());
    }

    @Test
    void getMes() {
        assertEquals((short)02, a.getMes());
    }

    @Test
    void setMes() {
        assertTrue(a.setMes((short) 03));
        assertFalse(a.setMes((short) 13));
        assertFalse(a.setMes((short) -1));
    }

    @Test
    void getInvolvidos() {
        assertEquals(envolvidos2, a.getInvolvidos());
    }

    @Test
    void setInvolvidos() {
        ArrayList<Veiculo> envolvidos2 = new ArrayList<>();
        a.setInvolvidos(envolvidos2);
        assertEquals(envolvidos2, a.getInvolvidos());
    }

    @Test
    void acidentesPorPericulosidade() {
        assertEquals("Rodovias de baixo risco: 2\n" +
                "Rodovias de medio risco: 1\n" +
                "Rodovias de alto risco: 1\n", Acidente.acidentesPorPericulosidade(acidentes));
    }

    @Test
    void acidentesComEmbreagues() {
        assertEquals("""
                        Acidentes com embreagues:
                        Rodovia: Teste1
                         Vitimas Fatais: 1
                         Feridos: 3
                         Mês: 2
                         Veiculos envolvidos:\s
                        [Veiculo de carga: ano 2014, Peso da carga (kg): 1000, passageiros [Nome: TesteA, Idade: 20, Sexo: M, Era o condutor?: true e estava embreagado?: true | ]
                        , Bicicleta: ano 0, passageiros [Nome: Dummy, Idade: 20, Sexo: M, Era o condutor?: true e estava embreagado?: false | ]
                        ]
                        ---
                        """, Acidente.AcidentesComEmbreagues(acidentes));
    }

    @Test
    void acidentesComVeiculoDeCarga() {
        assertEquals("""
                Rodovia: Teste1
                 Vitimas Fatais: 1
                 Feridos: 3
                 Mês: 2
                 Veiculos envolvidos:\s
                [Veiculo de carga: ano 2014, Peso da carga (kg): 1000, passageiros [Nome: TesteA, Idade: 20, Sexo: M, Era o condutor?: true e estava embreagado?: true | ]
                , Bicicleta: ano 0, passageiros [Nome: Dummy, Idade: 20, Sexo: M, Era o condutor?: true e estava embreagado?: false | ]
                ]
                ---
                """, Acidente.AcidentesComVeiculoDeCarga(acidentes));
    }

    @Test
    void acidentesComVeiculosNovos() {
        assertEquals("""
                Acidentes com veiculos novos: 1""", Acidente.AcidentesComVeiculosNovos(acidentes));
    }

    @Test
    void acidentesComBicicletas() {
        assertEquals("""
                        Rodovia com mais acidentes de bicicleta: Teste1 com 1 acidentes""",
                Acidente.AcidentesComBicicletas(acidentes));
    }

    @Test
    void acidentesNoCarnava() {
        assertEquals("Rodovias com acidentes no carnaval: Teste1,",Acidente.AcidentesNoCarnava(acidentes));
    }

    @Test
    void acodentesComFatais() {
        assertEquals("Rodovia com mais acidentes fatais é Teste3 com 2 vitimas",Acidente.AcidentesComFatais(acidentes));

    }
    @Test
    void setUpVazio() {
        a = new Acidente();
        assertEquals(0, a.getVitimasFatais());
        assertEquals(0, a.getFeridos());
        assertEquals((short) 1, a.getMes());
    }
}