package SupportTicketAPI.SupportTicketAPI.dto;

import SupportTicketAPI.SupportTicketAPI.model.Categoria;
import SupportTicketAPI.SupportTicketAPI.model.Prioridade;
import SupportTicketAPI.SupportTicketAPI.model.Status;

public record ChamadoDTO(String titulo,
                         String descricao,
                         Categoria categoria,
                         Prioridade prioridade,
                         Status status) {
}
