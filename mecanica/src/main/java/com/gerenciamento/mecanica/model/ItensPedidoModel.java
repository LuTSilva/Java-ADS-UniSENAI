package com.gerenciamento.mecanica.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "TBITENSPEDIDO")
public class ItensPedidoModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "CDITENSPEDIDO")
    private Integer cdItensPedido;

    @Column(name = "QTPRODUTO")
    private Integer qtProduto;

    @Column(name = "VLUNITARIO", nullable = false)
    private BigDecimal vlUnitario;

    @Column(name = "VLSUBTOTAL", nullable = false)
    private BigDecimal vlSubtotal;

    @ManyToOne
    @JoinColumn(name = "CDPEDIDO", nullable = false)
    private PedidoModel pedido;

    @ManyToOne
    @JoinColumn(name = "CDPRODUTO")
    private ProdutoModel produto;

    @ManyToOne
    @JoinColumn(name = "CDSERVICO")
    private ServicoModel servico;
}
