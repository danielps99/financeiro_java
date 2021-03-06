package br.com.bdws.financeiro.repository;

import br.com.bdws.financeiro.entity.Movimento;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IMovimentoRepository extends JpaRepository<Movimento, String> {
}
