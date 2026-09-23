package modelo;

import java.io.Serializable;

public class Candidato implements Serializable {
    private static final long serialVersionUID = 1L;
    
    private int id;
    private String nome;
    private String partido;
    private int votos;

    public Candidato(int id, String nome, String partido) {
        this.id = id;
        this.nome = nome;
        this.partido = partido;
        this.votos = 0;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getPartido() {
        return partido;
    }

    public void setPartido(String partido) {
        this.partido = partido;
    }

    public int getVotos() {
        return votos;
    }

    public void incrementarVoto() {
        this.votos++;
    }

    @Override
    public String toString() {
        return "Candidato{" +
                "id=" + id +
                ", nome='" + nome + ''' +
                ", partido='" + partido + ''' +
                ", votos=" + votos +
                '}';
    }
}
