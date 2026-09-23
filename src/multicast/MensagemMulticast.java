package multicast;

import java.io.Serializable;

public class MensagemMulticast implements Serializable {
    private static final long serialVersionUID = 1L;

    private String tipo;
    private String mensagem;
    private long timestamp;

    public MensagemMulticast(String tipo, String mensagem) {
        this.tipo = tipo;
        this.mensagem = mensagem;
        this.timestamp = System.currentTimeMillis();
    }

    public String getTipo() {
        return tipo;
    }

    public String getMensagem() {
        return mensagem;
    }

    public long getTimestamp() {
        return timestamp;
    }

    @Override
    public String toString() {
        return "{" +
                "\"tipo\": \"" + tipo + '\"' +
                ", \"mensagem\": \"" + mensagem + '\"' +
                ", \"timestamp\": " + timestamp +
                '}';
    }
}
