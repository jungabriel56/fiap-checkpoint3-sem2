package br.com.fiap.checkpoint3.checkpoint3.dtos;

import java.math.BigDecimal;

import lombok.Getter;
import lombok.Setter;
@Getter
@Setter
public class ContatoRequestCreateDto {
    private String nome;
	private BigDecimal valor;
}
