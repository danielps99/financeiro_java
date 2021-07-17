package br.com.bdws.financeiro.repository;

import br.com.bdws.financeiro.entity.SubCategoria;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ISubCategoriaRepository extends JpaRepository<SubCategoria, String> {
}
