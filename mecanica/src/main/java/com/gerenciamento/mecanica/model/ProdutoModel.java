package com.gerenciamento.mecanica.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "TBPRODUTO")
public class ProdutoModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    @Column(name = "CDPRODUTO")
    private Integer cdProduto;

    @Column(name = "NMPRODUTO", length = 100,  nullable = false)
    private String nmProduto;

    @Column(name = "DSPRODUTO", length = 100, nullable = false)
    private String dsProduto;

    @Column(name = "DSMARCA", length = 50, nullable = false)
    private String dsMarca;

    @Column(name = "DSCATEGORIA", length = 50, nullable = false)
    private String dsCategoria;

    @Column(name = "VLPRODUTO", nullable = false)
    private BigDecimal vlProduto;

    /*
    @OneToMany
    (mappedBy = "produto", cascade = CascadeType.ALL,
    fetch = FetchType.LAZY, orphanRemoval = true)

    @JsonIgnore
    private List<ItensPedidosModel> itensPedidos;

     */

}
