# Trabalho 1 - Comunicação entre Processos (Sistemas Distribuídos)

## Estrutura do Projeto
- `modelo/`: POJOs (Candidato, Eleitor)
- `servico/`: Regras de negócio do sistema
- `streams/`: Implementação de PojoEscolhidoOutputStream e PojoEscolhidoInputStream
- `serializacao/`: Representação externa de dados via Sockets TCP (Marshalling customizado)
- `multicast/`: Comunicação Multicast via Sockets UDP
