package com.gerenciamento.mecanica.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

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

    @Column(name="FLPGTOCONFIRMADO", length=1, nullable=false)
    private String flPgtoConfirmado;

    @CreationTimestamp
    @Column(name = "DTPEDIDO", nullable = false, updatable = false)
    private LocalDateTime dtPedido;

    @ManyToOne
    @JoinColumn(name = "CDUSUARIO", nullable = false)
    private UsuarioModel usuario;

    @ManyToOne
    @JoinColumn(name = "CDCLIENTE", nullable = false)
    private ClienteModel cliente;

}
