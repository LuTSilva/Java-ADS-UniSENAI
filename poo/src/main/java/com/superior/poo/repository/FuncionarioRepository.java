package com.superior.poo.repository;
// Define o pacote onde está localizada a interface, ajudando na organização do projeto.

// Importa a classe ProdutoModel, que será usada no repositório.

import com.superior.poo.model.FuncionarioModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
// Indica que esta interface é um repositório Spring Data JPA.
// O Spring fará a injeção automática e criará a implementação em tempo de execução.
public interface FuncionarioRepository extends JpaRepository<FuncionarioModel, Integer> {
    // Extende JpaRepository, recebendo:
    // 1º parâmetro: a entidade que será gerenciada (ProdutoModel).
    // 2º parâmetro: o tipo da chave primária da entidade (Integer).

    Optional<FuncionarioModel> findByCdFuncionario(int cdFuncionario);
    // Cria um método de consulta derivado do nome.
    // O Spring Data JPA irá gerar automaticamente uma query
    // que busca um Funcionario pelo campo "cdFuncionario".

    Optional<FuncionarioModel> findByNmFuncionario(String nmFuncionario);
    // Cria uma consulta automática para buscar um Funcionario pelo nome (nmFuncionario).

    Optional<FuncionarioModel> findAllByCdFuncionario(int cdFuncionario);
    // Cria uma consulta que busca todos os Funcionarios com determinado código.
    // OBS: normalmente "findAllBy" retorna uma lista (List<FuncionarioModel>),
    // mas aqui está definido como Optional, o que pode ser ajustado dependendo da necessidade.
}
