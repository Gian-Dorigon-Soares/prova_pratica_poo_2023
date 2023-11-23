package prova_pratica_poo_2023;

import java.util.ArrayList;

public class Veiculo {
    short ano;
    ArrayList<Pessoa> passageiros = new ArrayList<>();

    public short getAno() {
        return ano;
    }

    public void setAno(short ano) {
        this.ano = ano;
    }

    public ArrayList<Pessoa> getPassageiros() {
        return passageiros;
    }

    public boolean setPassageiros(ArrayList<Pessoa> passageiros) {
        byte condutor = 0;
        for (Pessoa p: passageiros) {
            if (p.isCondutor()) {
                condutor++;
            }
        }
        if (condutor == 1) {
            this.passageiros = passageiros;
            return true;
        } else {
            return false;
        }
    }

    public Veiculo() {
        Pessoa p = new Pessoa("Dummy",'M',20,true,false);
        this.ano = 0;
        this.passageiros.add(p);
    }

    public Veiculo(short ano, ArrayList<Pessoa> passageiros) {
        this.ano = ano;
        this.passageiros = passageiros;
    }

    @Override
    public String toString() {
        return "Veiculo: ano "+getAno()+", passageiros "+passageiros.toString()+"\n";
    }
}
