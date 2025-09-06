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
@Table(name = "TBFUNCIONARIO") // Especifica o nome da tabela no banco que esta entidade representa.
public class FuncionarioModel {
    @Id // Define este campo como chave primária (Primary Key) da tabela.
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    // Indica que o valor da chave primária será gerado automaticamente pelo banco (auto incremento).
    @Column(name = "CDFUNCIONARIO") // Mapeia o atributo da classe para a coluna "CDFUNCIONARIO" da tabela "TBFUNCIONARIO".
    private int cdFuncionario;
    @Column(name= "NMFUNCIONARIO")
    private String nmFuncionario;
    @Column(name= "TLFUNCIONARIO")
    private String tlFuncionario;
    @Column(name= "SALFUNCIONARIO")
    private double salFuncionario;
    @Column(name= "FLATIVO")
    private String flAtivo;
}
