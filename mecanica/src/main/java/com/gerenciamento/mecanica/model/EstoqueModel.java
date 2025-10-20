package com.gerenciamento.mecanica.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "TBESTOQUE")
public class EstoqueModel {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "CDESTOQUE")
    private Integer cdEstoque;

    @Column(name = "DSTIPO")
    private String dsTipo;

    @Column(name = "QTESTOQUE")
    private Integer qtEstoque;


    @ManyToOne
    @JoinColumn(name = "CDPRODUTO", nullable = false)
    private ProdutoModel produto;

}
