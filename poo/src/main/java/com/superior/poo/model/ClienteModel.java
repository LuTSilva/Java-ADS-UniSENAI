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
@Table(name = "TBCLIENTE") // Especifica o nome da tabela no banco que esta entidade representa.
public class ClienteModel {
    @Id // Define este campo como chave primária (Primary Key) da tabela.
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    // Indica que o valor da chave primária será gerado automaticamente pelo banco (auto incremento).
    @Column(name = "CDCLIENTE") // Mapeia o atributo da classe para a coluna "CDCLIENTE" da tabela "TBCLIENTE".
    private int cdCliente;
    @Column(name= "NMCLIENTE")
    private String nmCliente;
    @Column(name= "TLCLIENTE")
    private String tlCliente;
    @Column(name= "IDADECLIENTE")
    private int idadeCliente;
    @Column(name= "CMALTURA")
    private int cmAltura;
    @Column(name = "RUACLIENTE")
    private String ruaCliente;
    @Column(name= "FLATIVO")
    private String flAtivo;
}
