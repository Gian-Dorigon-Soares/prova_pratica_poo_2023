package prova_pratica_poo_2023;

public class Pessoa {
    private String nome;
    private char sexo;
    private int idade;
    private boolean condutor;
    private boolean embreagado;

    public Pessoa(String nome, char sexo, int idade, boolean condutor, boolean embreagado) {
        this.nome = nome;
        this.sexo = sexo;
        this.idade = idade;
        this.condutor = condutor;
        this.embreagado = embreagado;
    }

    public Pessoa() {
        this.nome = "*";
        this.sexo = 'M';
        this.idade = 0;
        this.condutor = false;
        this.embreagado = false;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public char getSexo() {
        return sexo;
    }

    public boolean setSexo(char sexo) {
        if (sexo == 'M' || sexo == 'F') {
            this.sexo = sexo;
            return true;
        } else {
            return false;
        }
    }

    public int getIdade() {
        return idade;
    }

    public boolean setIdade(int idade) {
        if (idade > 0) {
            this.idade = idade;
            return true;
        } else {
            return false;
        }
    }

    public boolean isCondutor() {
        return condutor;
    }

    public void setCondutor(boolean condutor) {
        this.condutor = condutor;
    }

    public boolean isEmbreagado() {
        return embreagado;
    }

    public void setEmbreagado(boolean embreagado) {
        this.embreagado = embreagado;
    }

    @Override
    public String toString() {
        String retorno =
                "Nome: "+getNome()+
                        ", Idade: " +getIdade()+
                        ", Sexo: " +getSexo()+
                        ", Era o condutor?: "+isCondutor()+
                        " e estava embreagado?: "+isEmbreagado()+" | ";
        return retorno;
    }
}
