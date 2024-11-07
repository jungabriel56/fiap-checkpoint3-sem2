package br.com.fiap.checkpoint3.checkpoint3.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.com.fiap.checkpoint3.checkpoint3.dtos.ContatoRequestCreateDto;
import br.com.fiap.checkpoint3.checkpoint3.dtos.ContatoRequestUpdateDto;
import br.com.fiap.checkpoint3.checkpoint3.dtos.ContatoResponseDto;
import br.com.fiap.checkpoint3.checkpoint3.mapper.ContatoMapper;
import br.com.fiap.checkpoint3.checkpoint3.repository.ContatoRepository;
import br.com.fiap.checkpoint3.checkpoint3.service.ContatoService;
import br.com.fiap.checkpoint3.checkpoint3.views.ContatoFullView;
import br.com.fiap.checkpoint3.checkpoint3.views.ContatoSimpleView;
import br.com.fiap.checkpoint3.checkpoint3.views.ContatoViewType;
import io.swagger.v3.oas.annotations.parameters.RequestBody;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/contatos")
@RequiredArgsConstructor
public class ContatoController {    
    private final ContatoService contatoService;
    private final ContatoMapper contatoMapper;
    private final ContatoRepository contatoRepository;

    @GetMapping
    public ResponseEntity<List<ContatoResponseDto>> list() {
        List<ContatoResponseDto> dtos = contatoService.list()
            .stream()
            .map(e -> contatoMapper.toDto(e))
            .toList();
        
        return ResponseEntity.ok().body(dtos);
    }

    @PostMapping
    public ResponseEntity<ContatoResponseDto> create(@RequestBody ContatoRequestCreateDto dto) {        

        return ResponseEntity
        		.status(HttpStatus.CREATED)
        		.body(
        			contatoMapper.toDto(
        					contatoService.save(contatoMapper.toModel(dto)))
        			);
    }

    @PutMapping("{id}")
    public ResponseEntity<ContatoResponseDto> update(
                        @PathVariable Long id, 
                        @RequestBody ContatoRequestUpdateDto dto) {
        if (! contatoService.existsById(id)){
            throw new RuntimeException("Id inexistente");
        }                
        return ResponseEntity.ok()
        		.body(
        			contatoMapper.toDto(
        				contatoService.save(contatoMapper.toModel(id, dto)))
        		);
    }
    
    @DeleteMapping("{id}")
    public void delete(@PathVariable Long id) {
        if (! contatoService.existsById(id)){
        	throw new RuntimeException("Id inexistente");
        }

        contatoService.delete(id);
    }

    @GetMapping("{id}")
    public ResponseEntity<ContatoResponseDto> findById(@PathVariable Long id) {    	
    	return ResponseEntity.ok()
    			.body(
    				contatoService
    					.findById(id)
    					.map(e -> contatoMapper.toDto(e))
    					.orElseThrow(() -> new RuntimeException("Id inexistente"))
    			);    	  		     
    }
    
    @GetMapping("/find")
    public  ResponseEntity<?> findByNome(
                @RequestParam String nome, 
                ContatoViewType type) { 

        switch (type) {
            case FULL:
                return ResponseEntity.ok().body(contatoRepository.findAllByNomeContains(nome, ContatoFullView.class));                
            case SIMPLE:
                return ResponseEntity.ok().body(contatoRepository.findAllByNomeContains(nome, ContatoSimpleView.class));            
        }
        return ResponseEntity.noContent().build();
    }
}
