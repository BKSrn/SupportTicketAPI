package SupportTicketAPI.SupportTicketAPI.service;

import SupportTicketAPI.SupportTicketAPI.dto.ChamadoDTO;
import SupportTicketAPI.SupportTicketAPI.dto.ChamadoRequestDTO;
import SupportTicketAPI.SupportTicketAPI.model.Chamado;
import SupportTicketAPI.SupportTicketAPI.repository.ChamadoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;


@Service
public class ChamadoService {
    @Autowired
    private ChamadoRepository chamadoRepository;

    public ResponseEntity<ChamadoDTO> insert(ChamadoRequestDTO chamadoRequestDTO, UriComponentsBuilder builder){
        Chamado chamado = chamadoRepository.save(new Chamado(chamadoRequestDTO));

        URI uri = builder.path("/chamado/{id}").buildAndExpand(chamado.getId()).toUri();

        ChamadoDTO chamadoDTO = converterParaDTO(chamado);
        return ResponseEntity.created(uri).body(chamadoDTO);
    }

    public List<ChamadoDTO> findAll(){
        List<Chamado> chamados = chamadoRepository.findAll();

        return converterListParaDTO(chamados);
    }

    public void delete(Long id){

        chamadoRepository.deleteById(id);
    }

    public ChamadoDTO update(Long id, ChamadoRequestDTO chamadoRequestDTO){
        ChamadoDTO chamadoDTO = converterParaDTO(chamadoRepository.save(new Chamado(id, chamadoRequestDTO)));

        return chamadoDTO;
    }

    private List<ChamadoDTO> converterListParaDTO(List<Chamado> chamados){

        return chamados.stream()
                .map(c -> new ChamadoDTO(c.getTitulo(),
                        c.getDescricao(),
                        c.getCategoria(),
                        c.getPrioridade(),
                        c.getStatus()))
                .collect(Collectors.toList());
    }

    private ChamadoDTO converterParaDTO(Chamado chamado){

        return new ChamadoDTO(chamado.getTitulo(),
                chamado.getDescricao(),
                chamado.getCategoria(),
                chamado.getPrioridade(),
                chamado.getStatus());
    }
}
