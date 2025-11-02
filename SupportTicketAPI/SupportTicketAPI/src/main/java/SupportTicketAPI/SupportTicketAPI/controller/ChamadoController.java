package SupportTicketAPI.SupportTicketAPI.controller;

import SupportTicketAPI.SupportTicketAPI.dto.ChamadoDTO;
import SupportTicketAPI.SupportTicketAPI.dto.ChamadoRequestDTO;
import SupportTicketAPI.SupportTicketAPI.model.Chamado;
import SupportTicketAPI.SupportTicketAPI.service.ChamadoService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/chamados")
public class ChamadoController {

    @Autowired
    private ChamadoService chamadoService;

    @PostMapping
    public ResponseEntity<ChamadoDTO> insert(@RequestBody ChamadoRequestDTO chamadoRequestDTO, UriComponentsBuilder builder) {
        return chamadoService.insert(chamadoRequestDTO, builder);

    }

    @GetMapping
    public ResponseEntity<List<ChamadoDTO>> findAll() {
        return ResponseEntity.ok(chamadoService.findAll());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        chamadoService.delete(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<ChamadoDTO> update(@PathVariable Long id, @RequestBody ChamadoRequestDTO chamadoRequestDTO) {

    return ResponseEntity.ok(chamadoService.update(id, chamadoRequestDTO));
    }
}
