package prova_pratica_poo_2023;

import java.util.ArrayList;

public class Acidente {
    Rodovia RodoviaAcidente;
    int VitimasFatais;
    int Feridos;
    short Mes;
    ArrayList<Veiculo> Involvidos;

    public Rodovia getRodoviaAcidente() {
        return RodoviaAcidente;
    }

    public void setRodoviaAcidente(Rodovia rodoviaAcidente) {
        RodoviaAcidente = rodoviaAcidente;
    }

    public int getVitimasFatais() {
        return VitimasFatais;
    }

    public void setVitimasFatais(int vitimasFatais) {
        VitimasFatais = vitimasFatais;
    }

    public int getFeridos() {
        return Feridos;
    }

    public void setFeridos(int feridos) {
        Feridos = feridos;
    }

    public short getMes() {
        return Mes;
    }

    public boolean setMes(short mes) {
        if (mes < (short)1 || mes > (short)12) {
            return false;
        } else {
            Mes = mes;
            return true;
        }
    }

    public ArrayList<Veiculo> getInvolvidos() {
        return Involvidos;
    }

    public void setInvolvidos(ArrayList<Veiculo> involvidos) {
        Involvidos = involvidos;
    }

    public Acidente() {
        Veiculo v = new Veiculo();
        ArrayList<Veiculo> veiculoTeste = new ArrayList<>();
        veiculoTeste.add(v);
        RodoviaAcidente = new Rodovia("Teste", 1);
        VitimasFatais = 0;
        Feridos = 0;
        Mes = (short)1;
        Involvidos = veiculoTeste;
    }

    public Acidente(Rodovia rodoviaAcidente, int vitimasFatais, int feridos, short mes, ArrayList<Veiculo> involvidos) {
        RodoviaAcidente = rodoviaAcidente;
        VitimasFatais = vitimasFatais;
        Feridos = feridos;
        Mes = mes;
        Involvidos = involvidos;
    }

    @Override
    public String toString() {
        return "Rodovia: "+getRodoviaAcidente().getSigla()+
                "\n Vitimas Fatais: "+getVitimasFatais()+
                "\n Feridos: "+getFeridos()+
                "\n Mês: "+getMes()+
                "\n Veiculos envolvidos: \n" +
                getInvolvidos().toString()+"\n---\n";
    }

    public static String acidentesPorPericulosidade (ArrayList<Acidente> ListaDeAcidentes) {
        int Baixo = 0;
        int Medio = 0;
        int Alto = 0;
        for (Acidente a:ListaDeAcidentes) {
            switch (a.getRodoviaAcidente().getPericulosidade()) {
                case "Baixo":
                    Baixo++;
                    break;
                case "Médio":
                    Medio++;
                    break;
                case "Alto":
                    Alto++;
                    break;
                default:
                    break;
            }
        }
        return "Rodovias de baixo risco: "+Baixo+"\n" +
                "Rodovias de medio risco: "+Medio+"\n"+
                "Rodovias de alto risco: "+Alto+"\n";
    }

    public static String AcidentesComEmbreagues(ArrayList<Acidente> ListaDeAcidentes) {
        String retorno = "";
        for (Acidente a : ListaDeAcidentes) {
            for (Veiculo v : a.getInvolvidos()) {
                for (Pessoa p : v.passageiros) {
                    if (p.isCondutor() && p.isEmbreagado()) {
                        retorno = retorno + a.toString();
                    }
                }
            }
        }
        return "Acidentes com embreagues:\n"+ retorno;
    }
    public static String AcidentesComVeiculoDeCarga(ArrayList<Acidente> ListaDeAcidentes) {
        String retorno = "";
        for (Acidente a: ListaDeAcidentes) {
            for (Veiculo v:a.getInvolvidos()) {
                if (v instanceof VeiculoCarga) {
                    retorno = retorno + a.toString();
                }
            }
        }
        return retorno;
    }
    public static String AcidentesComVeiculosNovos(ArrayList<Acidente> ListaDeAcidentes) {
        int contador=0;
        for (Acidente a: ListaDeAcidentes) {
            for (Veiculo v:a.getInvolvidos()) {
                if (v.getAno() >= (short) 2013) {
                    contador++;
                }
            }
        }
        return "Acidentes com veiculos novos: "+contador;
    }
    public static String AcidentesComBicicletas(ArrayList<Acidente> ListaDeAcidentes) {
        String Rodovia = "";
        int ContadorAcidentes=0;
        for (Acidente a:ListaDeAcidentes) {
            int ContadorPorAcidente = 0;
            for (Veiculo v:a.Involvidos) {
                if (v instanceof Bicicleta) {
                    ContadorPorAcidente++;
                }
            }
            if( ContadorPorAcidente > ContadorAcidentes) {
                Rodovia = a.getRodoviaAcidente().getSigla();
                ContadorAcidentes = ContadorPorAcidente;
            }
            ContadorPorAcidente= 0;
        }
        return "Rodovia com mais acidentes de bicicleta: "+Rodovia+" com "+ContadorAcidentes+" acidentes";
    }
    public static String AcidentesComFatais(ArrayList<Acidente> ListaDeAcidentes) {
        ArrayList<String> ListaRodovias = new ArrayList<>();
        for (Acidente a : ListaDeAcidentes) {
            if (ListaRodovias.contains(a.getRodoviaAcidente().getSigla())) {
                break;
            } else {
                ListaRodovias.add(a.getRodoviaAcidente().getSigla());
            }
        }
        ArrayList<Integer> fatais = new ArrayList<Integer>(ListaRodovias.size());
        for (String s : ListaRodovias) {
            int contador = 0;
            for (Acidente a : ListaDeAcidentes) {
                if (a.getRodoviaAcidente().getSigla().equals(s)) {
                    contador = contador + a.getVitimasFatais();
                }
            }
            fatais.add(ListaRodovias.indexOf(s));
        }
        int MaiorValor = 0;
        for (int i : fatais) {
            if (i > MaiorValor) {
                MaiorValor = i;
            }
        }
        return "Rodovia com mais acidentes fatais é " + ListaRodovias.get(fatais.indexOf(MaiorValor)) +
                " com " + fatais.indexOf(MaiorValor) + " vitimas";
    }
public static String AcidentesNoCarnava(ArrayList<Acidente> ListaDeAcidentes) {
    String retorno = "";
    for (Acidente a : ListaDeAcidentes) {
        if (a.getMes() == 2) {
            retorno = retorno + a.getRodoviaAcidente().getSigla() + ",";
        }
    }
    return "Rodovias com acidentes no carnaval: "+retorno;
}
}
