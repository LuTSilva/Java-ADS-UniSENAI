package com.superior.poo.dto;
// Define o pacote onde está localizado o DTO (Data Transfer Object),
// usado para transportar dados entre as camadas da aplicação.

// Importa as anotações de validação (Jakarta Validation / Bean Validation),
// que permitem aplicar regras de validação diretamente nos campos do DTO.
import jakarta.validation.constraints.*;

// Declaração de um record em Java (similar a uma classe imutável),
// ideal para DTOs porque gera automaticamente construtor, getters, equals, hashCode e toString.
public record ProdutoDto(

        @NotBlank(message="")
        // Garante que o campo não pode ser nulo, vazio ou apenas espaços em branco.
        // O "message" define a mensagem de erro exibida em caso de falha de validação.
        String nmProduto, // Nome do produto.

        String dsProduto,
        // Descrição do produto. Aqui não há validação, ou seja, pode ser nulo ou vazio.

        @NotNull(message="Não é possível cadastrar o produto com o campo vazio")
        // Garante que o campo não pode ser nulo.
        @DecimalMin(value="0.01", message = "Não é possível cadastrar o produto com valor abaixo de 0,01")
        // Garante que o valor mínimo permitido seja 0.01.
        double vlProduto, // Valor do produto.

        @NotNull(message="Não é possível cadastro do produto com a flag vazia")
        // Exige que a flag não seja nula.
        @NotBlank(message="Não é possível cadastrar o produto com a flag em branco")
        // Exige que a flag não esteja vazia ou só com espaços.
        String flAtivo // Flag que indica se o produto está ativo ou não (ex.: "S" ou "N").
) {
    // Como é um record, não precisamos escrever getters, setters ou construtor.
    // O compilador gera automaticamente esses métodos.
}
