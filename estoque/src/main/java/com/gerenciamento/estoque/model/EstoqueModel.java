package com.gerenciamento.estoque.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor

@Entity
@Table(name= "TBESTOQUE")
public class EstoqueModel {
    @Id@GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="CDESTOQUE")
    private Integer cdEstoque;
    @Column(name="CDLOCALESTOQUE")
    private Integer cdLocalEstoque;
    @Column(name="QTESTOQUE")
    private Integer qtEstoque;
    @Column(name="FLATIVO")
    private String flAtivo;
}
