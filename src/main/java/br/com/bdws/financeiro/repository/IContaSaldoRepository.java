package br.com.bdws.financeiro.repository;

import br.com.bdws.financeiro.entity.ContaSaldo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IContaSaldoRepository extends JpaRepository<ContaSaldo, String> {
}
