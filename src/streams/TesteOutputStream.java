package streams;

import modelo.Candidato;
import java.io.FileOutputStream;

public class TesteOutputStream {
    public static void main(String[] args) throws Exception {
        Candidato[] lista = new Candidato[] {
            new Candidato(1, "Maria", "Partido 1"),
            new Candidato(2, "João", "Partido 2")
        };

        new CandidatoOutputStream(System.out, lista, lista.length);

        try (FileOutputStream fos = new FileOutputStream("candidatos.bin")) {
            new CandidatoOutputStream(fos, lista, lista.length);
        }
    }
}
