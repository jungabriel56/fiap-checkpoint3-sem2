package br.com.fiap.checkpoint3.checkpoint3.dtos;

import java.math.BigDecimal;

public class ContatoRequestUpdateDto {
	private String nome;
	private BigDecimal valor;
    
    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }

    
    public BigDecimal getValor() {
        return valor;
    }
    public void setValor(BigDecimal valor) {
        this.valor = valor;
    }
   
}
