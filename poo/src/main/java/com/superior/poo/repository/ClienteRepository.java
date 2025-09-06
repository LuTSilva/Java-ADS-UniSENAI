package com.superior.poo.repository;
// Define o pacote onde está localizada a interface, ajudando na organização do projeto.

// Importa a classe ClienteModel, que será usada no repositório.

import com.superior.poo.model.ClienteModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
// Indica que esta interface é um repositório Spring Data JPA.
// O Spring fará a injeção automática e criará a implementação em tempo de execução.
public interface ClienteRepository extends JpaRepository<ClienteModel, Integer> {
    // Extende JpaRepository, recebendo:
    // 1º parâmetro: a entidade que será gerenciada (ClienteModel).
    // 2º parâmetro: o tipo da chave primária da entidade (Integer).

    Optional<ClienteModel> findByCdCliente(int cdCliente);
    // Cria um método de consulta derivado do nome.
    // O Spring Data JPA irá gerar automaticamente uma query
    // que busca um Cliente pelo campo "cdCliente".

    Optional<ClienteModel> findByNmCliente(String nmCliente);
    // Cria uma consulta automática para buscar um Cliente pelo nome (nmCliente).

    Optional<ClienteModel> findAllByCdCliente(int cdCliente);
    // Cria uma consulta que busca todos os Clientes com determinado código.
    // OBS: normalmente "findAllBy" retorna uma lista (List<ClienteModel>),
    // mas aqui está definido como Optional, o que pode ser ajustado dependendo da necessidade.
}
