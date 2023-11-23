package prova_pratica_poo_2023;

import java.util.ArrayList;

public class VeiculoCarga extends Veiculo {
    int Carga;

    public VeiculoCarga() {
        super();
        Carga = 0;
    }

    public VeiculoCarga(short ano, ArrayList<Pessoa> passageiros, int carga) {
        super(ano, passageiros);
        Carga = carga;
    }

    public int getCarga() {
        return Carga;
    }

    public void setCarga(int carga) {
        Carga = carga;
    }
    @Override
    public String toString() {
        return "Veiculo de carga: ano "+getAno()+", Peso da carga (kg): "+getCarga()+", passageiros "+passageiros.toString()+"\n";
    }
}
