package servico;

import modelo.Eleitor;
import java.util.HashMap;
import java.util.Map;

public class AutenticacaoService {
    private Map<String, Eleitor> eleitoresCadastrados;

    public AutenticacaoService() {
        eleitoresCadastrados = new HashMap<>();
        eleitoresCadastrados.put("11111111111", new Eleitor("11111111111", "Alice", false));
        eleitoresCadastrados.put("22222222222", new Eleitor("22222222222", "Bob", false));
        eleitoresCadastrados.put("00000000000", new Eleitor("00000000000", "Admin", true));
    }

    public Eleitor autenticar(String cpf) {
        return eleitoresCadastrados.get(cpf);
    }
}
