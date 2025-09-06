package com.superior.poo.dto;
// Define o pacote onde está localizado o DTO (Data Transfer Object),
// usado para transportar dados entre as camadas da aplicação.

// Importa as anotações de validação (Jakarta Validation / Bean Validation),
// que permitem aplicar regras de validação diretamente nos campos do DTO.

import jakarta.validation.constraints.DecimalMax;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

// Declaração de um record em Java (similar a uma classe imutável),
// ideal para DTOs porque gera automaticamente construtor, getters, equals, hashCode e toString.
public record ClienteDto(

        @NotBlank(message="Não é possível cadastrar o cliente com nome em branco")
        // Garante que o campo não pode ser nulo, vazio ou apenas espaços em branco.
        // O "message" define a mensagem de erro exibida em caso de falha de validação.
        String nmCliente, // Nome do Cliente.

        @NotBlank(message="Não é possível cadastrar o cliente com telefone em branco")
        @NotNull(message="Não é possível cadastrar o cliente com telefone vazio")
        String tlCliente,

        @NotNull(message="Não é possível cadastrar o cliente com campo idade vazio")
        // Garante que o campo não pode ser nulo.
        @DecimalMin(value="1", message = "Não é possível cadastrar o cliente com idade abaixo de 1")
        int idadeCliente,

        @NotNull(message="Não é possível cadastrar o cliente com campo idade vazio")
        @DecimalMin(value="3", message="Esse campo deve ser preenchido em centimetros")
        @DecimalMax(value="240", message="Esse campo deve ser preenchido com uma altura válida")
        int cmAltura,

        @NotNull(message="Não é possível cadastro do cliente com o campo rua vazio")
        @NotBlank(message="Não é possível cadastrar o cliente com rua do endereco em branco")
        String ruaCliente,

        @NotNull(message="Não é possível cadastro do cliente com a flag vazia")
        // Exige que a flag não seja nula.
        @NotBlank(message="Não é possível cadastrar o cliente com a flag em branco")
        // Exige que a flag não esteja vazia ou só com espaços.
        String flAtivo // Flag que indica se o cliente está ativo ou não (ex.: "S" ou "N").
) {
    // Como é um record, não precisamos escrever getters, setters ou construtor.
    // O compilador gera automaticamente esses métodos.
}
