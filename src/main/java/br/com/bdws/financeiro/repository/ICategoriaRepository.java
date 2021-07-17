package br.com.bdws.financeiro.repository;

import br.com.bdws.financeiro.entity.Categoria;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ICategoriaRepository extends JpaRepository<Categoria, String> {
}
