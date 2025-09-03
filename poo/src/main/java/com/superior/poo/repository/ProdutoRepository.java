package com.superior.poo.repository;
// Define o pacote onde está localizada a interface, ajudando na organização do projeto.

// Importa a classe ProdutoModel, que será usada no repositório.
import com.superior.poo.model.ProdutoModel;

// Importa a interface JpaRepository, responsável por fornecer métodos prontos
// de CRUD (Create, Read, Update, Delete) e consultas no banco.
import org.springframework.data.jpa.repository.JpaRepository;

// Importa a anotação Repository, que marca esta interface como um componente
// de persistência no Spring (será gerenciado pelo Spring Container).
import org.springframework.stereotype.Repository;

// Importa a classe Optional, usada para representar retornos que podem ou não existir,
// evitando problemas com valores nulos (NullPointerException).
import java.util.Optional;

@Repository
// Indica que esta interface é um repositório Spring Data JPA.
// O Spring fará a injeção automática e criará a implementação em tempo de execução.
public interface ProdutoRepository extends JpaRepository<ProdutoModel, Integer> {
    // Extende JpaRepository, recebendo:
    // 1º parâmetro: a entidade que será gerenciada (ProdutoModel).
    // 2º parâmetro: o tipo da chave primária da entidade (Integer).

    Optional<ProdutoModel> findByCdProduto(int cdProduto);
    // Cria um método de consulta derivado do nome.
    // O Spring Data JPA irá gerar automaticamente uma query
    // que busca um produto pelo campo "cdProduto".

    Optional<ProdutoModel> findByNmProduto(String nmProduto);
    // Cria uma consulta automática para buscar um produto pelo nome (nmProduto).

    Optional<ProdutoModel> findAllByCdProduto(int cdProduto);
    // Cria uma consulta que busca todos os produtos com determinado código.
    // OBS: normalmente "findAllBy" retorna uma lista (List<ProdutoModel>),
    // mas aqui está definido como Optional, o que pode ser ajustado dependendo da necessidade.
}
