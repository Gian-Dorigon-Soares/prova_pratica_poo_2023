package prova_pratica_poo_2023;

import java.util.ArrayList;

public class Bicicleta extends Veiculo {
    public Bicicleta() {
        super();
    }

    public Bicicleta(short ano, ArrayList<Pessoa> passageiros) {
        super(ano, passageiros);
    }
    @Override
    public String toString() {
        return "Bicicleta: ano "+getAno()+", passageiros "+passageiros.toString()+"\n";
    }
}
