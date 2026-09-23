package streams;

import modelo.Candidato;
import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStream;

public class CandidatoInputStream extends InputStream {
    private DataInputStream dataIn;

    public CandidatoInputStream(InputStream in) {
        this.dataIn = new DataInputStream(in);
    }

    public Candidato[] readCandidatos() throws IOException {
        int count = dataIn.readInt();
        Candidato[] lista = new Candidato[count];
        for (int i = 0; i < count; i++) {
            int id = dataIn.readInt();
            String nome = dataIn.readUTF();
            String partido = dataIn.readUTF();
            int votos = dataIn.readInt();
            
            Candidato c = new Candidato(id, nome, partido);
            for (int v = 0; v < votos; v++) {
                c.incrementarVoto();
            }
            lista[i] = c;
        }
        return lista;
    }

    @Override
    public int read() throws IOException {
        return dataIn.read();
    }
}
