package com.superior.poo.dto;
// Define o pacote onde está localizado o DTO (Data Transfer Object),
// usado para transportar dados entre as camadas da aplicação.

// Importa as anotações de validação (Jakarta Validation / Bean Validation),
// que permitem aplicar regras de validação diretamente nos campos do DTO.

import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

// Declaração de um record em Java (similar a uma classe imutável),
// ideal para DTOs porque gera automaticamente construtor, getters, equals, hashCode e toString.
public record FuncionarioDto(

        @NotBlank(message="Não é possível cadastrar o Funcionário com o campo vazio")
        // Garante que o campo não pode ser nulo, vazio ou apenas espaços em branco.
        // O "message" define a mensagem de erro exibida em caso de falha de validação.
        String nmFuncionario, // Nome do Funcionario.

        @NotNull(message="Não é possível cadastro do Funcionario com telefone vazio")
        // Exige que a flag não seja nula.
        @NotBlank(message="Não é possível cadastrar o Funcionario com telefone em branco")
        String tlFuncionario,
        // Telefone do Funcionario. Aqui não há validação, ou seja, pode ser nulo ou vazio.

        @NotNull(message="Não é possível cadastrar o Funcionário com o campo vazio")
        // Garante que o campo não pode ser nulo.
        @DecimalMin(value="0.01", message = "Não é possível cadastrar o Funcionário com valor abaixo de 0,01")
        // Garante que o valor mínimo permitido seja 0.01.
        double salFuncionario, // Valor do Funcionario.

        @NotNull(message="Não é possível cadastro do Funcionario com a flag vazia")
        // Exige que a flag não seja nula.
        @NotBlank(message="Não é possível cadastrar o Funcionario com a flag em branco")
        // Exige que a flag não esteja vazia ou só com espaços.
        String flAtivo // Flag que indica se o Funcionario está ativo ou não (ex.: "S" ou "N").
) {
    // Como é um record, não precisamos escrever getters, setters ou construtor.
    // O compilador gera automaticamente esses métodos.
}
