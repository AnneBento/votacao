package serializacao;

import java.io.Serializable;

public class Reply implements Serializable {
    private static final long serialVersionUID = 1L;

    private boolean sucesso;
    private Object resultado;
    private String mensagem;

    public Reply(boolean sucesso, Object resultado, String mensagem) {
        this.sucesso = sucesso;
        this.resultado = resultado;
        this.mensagem = mensagem;
    }

    public boolean isSucesso() {
        return sucesso;
    }

    public Object getResultado() {
        return resultado;
    }

    public String getMensagem() {
        return mensagem;
    }
}
