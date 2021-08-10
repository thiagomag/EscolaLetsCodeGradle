package br.com.letscode.service;

import br.com.letscode.entity.TelefoneProfessor;
import br.com.letscode.exception.IdDoTelefoneNaoExisteException;
import br.com.letscode.repository.TelefoneProfessorRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class TelefoneProfessorService {

    private final TelefoneProfessorRepository telefoneProfessorRepository;
    private final ProfessorService professorService;

    public Iterable<TelefoneProfessor> buscarTelefones() {
        return telefoneProfessorRepository.findAll();
    }

    public Iterable<TelefoneProfessor> buscarTelefonesProfessor(Integer registroProfessor) {
        var professor = professorService.buscarPorId(registroProfessor);
        return telefoneProfessorRepository.getTelefoneProfessorByRegistroProfessor(professor);
    }

    public TelefoneProfessor cadastrarTelefone(TelefoneProfessor telefoneProfessor) {
        return telefoneProfessorRepository.save(telefoneProfessor);
    }

    public TelefoneProfessor buscarTelefonePorId(Integer idTelefone) {
        return telefoneProfessorRepository.findById(idTelefone)
                .orElseThrow(() -> new IdDoTelefoneNaoExisteException(idTelefone));
    }

    public void deletarTelefone(Integer idTelefone) {
        if(telefoneProfessorRepository.findById(idTelefone).isPresent()) {
            telefoneProfessorRepository.deleteById(idTelefone);
        } else {
            throw new IdDoTelefoneNaoExisteException(idTelefone);
        }
    }

    public TelefoneProfessor atualizarTelefone(TelefoneProfessor telefone, Integer idTelefone) {
        var telefonePesquisado = telefoneProfessorRepository.findById(idTelefone)
                .orElseThrow(() -> new IdDoTelefoneNaoExisteException(idTelefone));
        if(telefone.getRegistroProfessor() != null) {
            telefonePesquisado.setRegistroProfessor(telefone.getRegistroProfessor());
        }
        if(telefone.getNumero() != null) {
            telefonePesquisado.setNumero(telefone.getNumero());
        }
        return telefoneProfessorRepository.save(telefonePesquisado);
    }
}