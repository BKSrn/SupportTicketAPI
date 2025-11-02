package SupportTicketAPI.SupportTicketAPI.model;

import SupportTicketAPI.SupportTicketAPI.dto.ChamadoRequestDTO;
import jakarta.persistence.*;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "chamados")
@AllArgsConstructor
@NoArgsConstructor
public class Chamado {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String titulo;
    private String descricao;
    @Enumerated(EnumType.STRING)
    private Categoria categoria;
    @Enumerated(EnumType.STRING)
    private Prioridade prioridade;
    @Enumerated(EnumType.STRING)
    private Status status;

    public Chamado(ChamadoRequestDTO chamadoRequestDTO) {
        this.titulo = chamadoRequestDTO.getTitulo();
        this.descricao = chamadoRequestDTO.getDescricao();

        this.categoria = Categoria.fromString(chamadoRequestDTO.getCategoria());
        this.prioridade = Prioridade.fromString(chamadoRequestDTO.getPrioridade());
        this.status = Status.fromString(chamadoRequestDTO.getStatus());
    }

    public Chamado(Long id, @Valid ChamadoRequestDTO chamadoRequestDTO) {
        this.id = id;
        this.titulo = chamadoRequestDTO.getTitulo();
        this.descricao = chamadoRequestDTO.getDescricao();

        this.categoria = Categoria.fromString(chamadoRequestDTO.getCategoria());
        this.prioridade = Prioridade.fromString(chamadoRequestDTO.getPrioridade());
        this.status = Status.fromString(chamadoRequestDTO.getStatus());
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }

    public Prioridade getPrioridade() {
        return prioridade;
    }

    public void setPrioridade(Prioridade prioridade) {
        this.prioridade = prioridade;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }
}
