package prova_pratica_poo_2023;

public class Rodovia {
    private String sigla;

    private String periculosidade;

    public Rodovia() {
        this.sigla = "0";
        this.periculosidade = "Baixo";
    }

    public Rodovia(String sigla, int periculosidade) {
        this.sigla = sigla;
        setPericulosidade(periculosidade);
    }

    public String getSigla() {
        return sigla;
    }

    public void setSigla(String sigla) {
        this.sigla = sigla;
    }

    public String getPericulosidade() {
        return periculosidade;
    }

    public boolean setPericulosidade(int grau) {
        if (grau == 1) {
        this.periculosidade = "Baixo";
        return true;
        } else if (grau == 2) {
            this.periculosidade = "Médio";
            return true;
        } else if (grau == 3) {
            this.periculosidade = "Alto";
            return true;
        } else {
            return false;
        }
    }
}
