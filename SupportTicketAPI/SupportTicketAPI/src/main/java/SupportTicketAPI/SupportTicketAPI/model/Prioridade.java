package SupportTicketAPI.SupportTicketAPI.model;

public enum Prioridade {
    BAIXA("Baixa"),
    MEDIA("Media"),
    ALTA("Alta");

    private String prioridade;

    Prioridade(String prioridade) {
        this.prioridade = prioridade;
    }

    public static Prioridade fromString(String prioridade) {

        for (Prioridade p : Prioridade.values()) {
            if (p.prioridade.equalsIgnoreCase(prioridade)) {
                return p;
            }
        }
        throw new IllegalArgumentException("Prioridade não encontrada: " + prioridade);
    }
}
