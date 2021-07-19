package br.com.bdws.financeiro.repository;

import br.com.bdws.financeiro.entity.Conta;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface IContaRepository extends JpaRepository<Conta, String> {

    List<Conta> findAllByClienteSistemaId(String cliente);

    Optional<Conta> findByIdAndClienteSistemaId(String id, String clienteId);
}
