package br.com.letscode.controller;

import br.com.letscode.request.TelefoneProfessorReqAtualizar;
import br.com.letscode.request.TelefoneProfessorRequest;
import br.com.letscode.response.TelefoneProfessorResponse;
import br.com.letscode.service.TelefoneProfessorService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("telefoneProfessor")
public class TelefoneProfessorController {

    private final TelefoneProfessorService telefoneProfessorService;

    @GetMapping
    private List<TelefoneProfessorResponse> buscarTelefones() {
        return telefoneProfessorService.buscarTelefones();
    }

    @GetMapping("/buscarTelefone/{idtelefone}")
    private TelefoneProfessorResponse buscarTelefonePorId(Integer idTelefone) {
        return telefoneProfessorService.buscarTelefonePorId(idTelefone);
    }

    @GetMapping("/buscarTelefone/{registroProfessor}")
    private TelefoneProfessorResponse buscarTelefonesProfessor(Integer registroProfessor) {
        return telefoneProfessorService.buscarTelefonesProfessor(registroProfessor);
    }

    @PostMapping("/cadastrarTelefone")
    private ResponseEntity<TelefoneProfessorResponse> cadastrarTelefone(
            @RequestBody TelefoneProfessorRequest telefoneProfessorRequest,
            UriComponentsBuilder uriComponentsBuilder) {
        return telefoneProfessorService.cadastrarTelefone(telefoneProfessorRequest, uriComponentsBuilder);
    }

    @DeleteMapping("/deletarTelefone/{idTelefone}")
    private ResponseEntity<?> deletarTelefone(Integer idTelefone) {
        return telefoneProfessorService.deletarTelefone(idTelefone);
    }

    @PatchMapping("/atualizarTelefone/{idTelefone}")
    private ResponseEntity<TelefoneProfessorResponse> atualizarTelefone(@RequestBody TelefoneProfessorReqAtualizar telefone,
                                                                        @PathVariable Integer idTelefone) {
        return telefoneProfessorService.atualizarTelefone(telefone, idTelefone);
    }
}