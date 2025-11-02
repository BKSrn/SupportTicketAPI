package SupportTicketAPI.SupportTicketAPI.model;

public enum Status {
    ABERTO("Aberto", ""),
    EM_ANDAMENTO("Em Andamento", "Em Progresso"),
    FINALIZADO("Finalizado", "Concluído");

    private String status;
    private String outroStatus;

    Status(String status, String outroStatus) {
        this.status = status;
        this.outroStatus = outroStatus;
    }

    public static Status fromString (String texto){
        if (texto.isEmpty() || texto == null){
            return ABERTO;
        }

        for (Status s: Status.values()){
            if (s.status.equalsIgnoreCase(texto)){
                return s;
            }
        }
        throw new IllegalArgumentException("Status não encontrado: " + texto);
    }
}
