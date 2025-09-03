package com.superior.poo.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

//Model = O arquivo serve como espelho do banco de dados
@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity // Indica que a classe é uma entidade JPA (será mapeada para uma tabela no banco).
@Table(name = "TBPRODUTO") // Especifica o nome da tabela no banco que esta entidade representa.
public class ProdutoModel {
    @Id // Define este campo como chave primária (Primary Key) da tabela.
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    // Indica que o valor da chave primária será gerado automaticamente pelo banco (auto incremento).
    @Column(name = "CDPRODUTO") // Mapeia o atributo da classe para a coluna "CDPRODUTO" da tabela "TBPRODUTO".
    private int cdProduto;
    @Column(name= "NMPRODUTO")
    private String nmProduto;
    @Column(name= "DSPRODUTO")
    private String dsProduto;
    @Column(name= "VLPRODUTO")
    private double vlProduto;
    @Column(name= "FLATIVO")
    private String flAtivo;
}
