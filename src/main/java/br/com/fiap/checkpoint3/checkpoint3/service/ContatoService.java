package br.com.fiap.checkpoint3.checkpoint3.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import br.com.fiap.checkpoint3.checkpoint3.model.Contato;
import br.com.fiap.checkpoint3.checkpoint3.repository.ContatoRepository;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ContatoService {
    private final ContatoRepository contatoRepository;

    public List<Contato> list() {
        return contatoRepository.findAll();
    }

    public Contato save(Contato contato) {        
        return contatoRepository.save(contato);
    }

    public boolean existsById(Long id) {        
        return contatoRepository.existsById(id);
    }

    public void delete(Long id) {
        contatoRepository.deleteById(id);
    }

    public Optional<Contato> findById(Long id) {
        return contatoRepository.findById(id);
    }
   
}
