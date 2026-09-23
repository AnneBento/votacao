package modelo;

import java.io.Serializable;

public class Eleitor implements Serializable {
    private static final long serialVersionUID = 1L;

    private String cpf;
    private String nome;
    private boolean jaVotou;
    private boolean eAdmin;

    public Eleitor(String cpf, String nome, boolean eAdmin) {
        this.cpf = cpf;
        this.nome = nome;
        this.jaVotou = false;
        this.eAdmin = eAdmin;
    }

    public String getCpf() {
        return cpf;
    }

    public String getNome() {
        return nome;
    }

    public boolean isJaVotou() {
        return jaVotou;
    }

    public void setJaVotou(boolean jaVotou) {
        this.jaVotou = jaVotou;
    }

    public boolean iseAdmin() {
        return eAdmin;
    }

    @Override
    public String toString() {
        return "Eleitor{" +
                "cpf='" + cpf + ''' +
                ", nome='" + nome + ''' +
                ", jaVotou=" + jaVotou +
                ", eAdmin=" + eAdmin +
                '}';
    }
}
