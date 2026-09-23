package serializacao;

import java.io.Serializable;

public class Request implements Serializable {
    private static final long serialVersionUID = 1L;

    private String operacao;
    private Object parametro;

    public Request(String operacao, Object parametro) {
        this.operacao = operacao;
        this.parametro = parametro;
    }

    public String getOperacao() {
        return operacao;
    }

    public Object getParametro() {
        return parametro;
    }
}
