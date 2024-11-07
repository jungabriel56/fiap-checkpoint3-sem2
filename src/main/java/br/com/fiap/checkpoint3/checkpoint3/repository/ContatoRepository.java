package br.com.fiap.checkpoint3.checkpoint3.repository
;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.fiap.checkpoint3.checkpoint3.model.Contato;

@Repository
public interface ContatoRepository 
	extends JpaRepository<Contato, Long> {

	<T> T findByNome(String nome, Class<T> type);
	<T> List<T> findAllByNome(String nome, Class<T> type);
	<T> List<T> findAllByNomeContains(String nome, Class<T> type);
}

