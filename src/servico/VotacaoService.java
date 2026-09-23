package servico;

import modelo.Candidato;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.HashMap;

public class VotacaoService {
    private Map<Integer, Candidato> candidatos;
    private boolean votacaoAberta;

    public VotacaoService() {
        this.candidatos = new HashMap<>();
        this.votacaoAberta = true;
        candidatos.put(1, new Candidato(1, "Candidato A", "Partido X"));
        candidatos.put(2, new Candidato(2, "Candidato B", "Partido Y"));
    }

    public synchronized List<Candidato> getListaCandidatos() {
        return new ArrayList<>(candidatos.values());
    }

    public synchronized boolean votar(int candidatoId) {
        if (!votacaoAberta) {
            return false;
        }
        Candidato c = candidatos.get(candidatoId);
        if (c != null) {
            c.incrementarVoto();
            return true;
        }
        return false;
    }

    public synchronized void encerrarVotacao() {
        this.votacaoAberta = false;
    }

    public synchronized boolean isVotacaoAberta() {
        return votacaoAberta;
    }
}
