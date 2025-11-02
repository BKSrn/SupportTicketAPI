package SupportTicketAPI.SupportTicketAPI.model;

public enum Categoria {
    SISTEMA("Sistema"),
    REDE("Rede"),
    HARDWARE("Hardware"),
    SOFTWARE("Software"),
    ACESSO("Acesso"),
    EMAIL("Email"),
    IMPRESSORA("Impressora"),
    BANCO_DE_DADOS("Banco de Dados"),
    SERVIDOR("Servidor"),
    OUTROS("Outros");

    private String descricao;

    Categoria(String descricao) {
        this.descricao = descricao;
    }

    public static Categoria fromString(String text) {

        for (Categoria categoria : Categoria.values()) {
            if (categoria.descricao.equalsIgnoreCase(text)) {
                return categoria;
            }
        }

        throw new IllegalArgumentException("Categoria não encontrada: " + text);
    }
}
