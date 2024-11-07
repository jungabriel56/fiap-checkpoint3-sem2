package br.com.fiap.checkpoint3.checkpoint3.mapper;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;

import br.com.fiap.checkpoint3.checkpoint3.dtos.ContatoRequestCreateDto;
import br.com.fiap.checkpoint3.checkpoint3.dtos.ContatoRequestUpdateDto;
import br.com.fiap.checkpoint3.checkpoint3.dtos.ContatoResponseDto;
import br.com.fiap.checkpoint3.checkpoint3.model.Contato;

public class ContatoMapper {
    @Autowired
    private ModelMapper modelMapper;

    public ContatoResponseDto toDto(Contato contato){
        return modelMapper.map(contato, ContatoResponseDto.class);
    }

    public Contato toModel(ContatoRequestCreateDto dto) {
        return modelMapper.map(dto, Contato.class);
    }

    public Contato toModel(Long id, ContatoRequestUpdateDto dto) {
        Contato result = modelMapper.map(dto, Contato.class);
        result.setId(id);
        return result;
    } 
}
