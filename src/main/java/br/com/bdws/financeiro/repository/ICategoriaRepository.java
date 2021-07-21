package br.com.bdws.financeiro.repository;

import br.com.bdws.financeiro.entity.Categoria;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ICategoriaRepository extends JpaRepository<Categoria, String> {

    Optional<Categoria> findByIdAndClienteSistemaId(String id, String clienteId);

    List<Categoria> findAllByClienteSistemaId(String clienteId);
}
