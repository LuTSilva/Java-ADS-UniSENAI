package com.gerenciamento.mecanica.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor

@Entity
@Table(name= "TBPEDIDO")
public class PedidoModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "CDPEDIDO")
    private Integer cdPedido;

    @Column(name = "STATUS", length = 20, nullable = false)
    private String status; // ABERTO, CONFIRMADO, PAGO

    @Column(name = "FORMAPAGAMENTO", length = 30)
    private String formaPagamento; // DINHEIRO, PIX, CARTAO_CREDITO, CARTAO_DEBITO

    @Column(name = "VLPAGAMENTO")
    private BigDecimal vlPagamento;

    @Column(name = "VLTROCADO")
    private BigDecimal vlTrocado;

    @CreationTimestamp
    @Column(name = "DTPEDIDO", nullable = false, updatable = false)
    private LocalDateTime dtPedido;

    @Column(name = "DTPAGAMENTO")
    private LocalDateTime dtPagamento;

    @ManyToOne
    @JoinColumn(name = "CDUSUARIO", nullable = false)
    private UsuarioModel usuario;

    @ManyToOne
    @JoinColumn(name = "CDCLIENTE", nullable = false)
    private ClienteModel cliente;

}
