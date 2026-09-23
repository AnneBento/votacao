package streams;

import modelo.Candidato;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.OutputStream;

public class CandidatoOutputStream extends OutputStream {
    private OutputStream targetStream;

    public CandidatoOutputStream(OutputStream out, Candidato[] candidatos, int count) throws IOException {
        this.targetStream = out;
        DataOutputStream dos = new DataOutputStream(out);
        dos.writeInt(count);
        for (int i = 0; i < count; i++) {
            dos.writeInt(candidatos[i].getId());
            dos.writeUTF(candidatos[i].getNome());
            dos.writeUTF(candidatos[i].getPartido());
            dos.writeInt(candidatos[i].getVotos());
        }
        dos.flush();
    }

    @Override
    public void write(int b) throws IOException {
        targetStream.write(b);
    }
}
