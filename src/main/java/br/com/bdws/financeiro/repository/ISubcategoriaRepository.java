package br.com.bdws.financeiro.repository;

import br.com.bdws.financeiro.entity.Subcategoria;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ISubcategoriaRepository extends JpaRepository<Subcategoria, String> {

    Optional<Subcategoria> findByIdAndClienteSistemaId(String id, String clienteId);

    List<Subcategoria> findAllByClienteSistemaId(String clienteId);
}
