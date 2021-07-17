package br.com.bdws.financeiro.repository;

import br.com.bdws.financeiro.entity.Conta;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IContaRepository extends JpaRepository<Conta, String> {
}
