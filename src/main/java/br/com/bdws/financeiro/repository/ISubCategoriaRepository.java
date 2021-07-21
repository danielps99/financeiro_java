package br.com.bdws.financeiro.repository;

import br.com.bdws.financeiro.entity.SubCategoria;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ISubCategoriaRepository extends JpaRepository<SubCategoria, String> {

    Optional<SubCategoria> findByIdAndClienteSistemaId(String id, String clienteId);

    List<SubCategoria> findAllByClienteSistemaId(String clienteId);
}
