package br.com.bdws.financeiro.repository;

import br.com.bdws.financeiro.entity.Titulo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ITituloRepository extends JpaRepository<Titulo, String> {
}
