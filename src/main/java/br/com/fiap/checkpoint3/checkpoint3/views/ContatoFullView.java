package br.com.fiap.checkpoint3.checkpoint3.views;

import java.math.BigDecimal;

import org.springframework.beans.factory.annotation.Value;

public interface ContatoFullView {
    String getNome();
    Long getId();
    
    @Value("#{target.id + '/' + target.nome}")
    String getDescricao();
    
    BigDecimal getValor();

    @Value("#{target.valor * 1.15}")
    String getResultado();
}
