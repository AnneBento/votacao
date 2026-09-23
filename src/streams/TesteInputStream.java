package streams;

import modelo.Candidato;
import java.io.FileInputStream;

public class TesteInputStream {
    public static void main(String[] args) throws Exception {
        try (FileInputStream fis = new FileInputStream("candidatos.bin")) {
            CandidatoInputStream cis = new CandidatoInputStream(fis);
            Candidato[] candidatos = cis.readCandidatos();
            for (Candidato c : candidatos) {
                System.out.println(c);
            }
        }
    }
}
