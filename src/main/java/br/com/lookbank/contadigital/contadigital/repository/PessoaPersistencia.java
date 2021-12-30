package br.com.lookbank.contadigital.contadigital.repository;

import br.com.lookbank.contadigital.contadigital.domain.Pessoa;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface PessoaPersistencia extends JpaRepository<Pessoa, UUID> {
    Optional<Pessoa> findByCpf(String cpf);
}
