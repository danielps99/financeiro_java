package br.com.bdws.financeiro.repository;

import br.com.bdws.financeiro.entity.ClienteSistema;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IClienteSistemaRepository extends JpaRepository<ClienteSistema, String> {
}