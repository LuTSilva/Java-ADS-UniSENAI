package com.gerenciamento.mecanica.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "TBVEICULO")
public class VeiculoModel {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)

    @Column(name = "CDVEICULO")
    private Integer cdVeiculo;

    @Column(name = "DSMARCA")
    private String dsMarca;

    @Column(name = "DSMODELO")
    private String dsModelo;

    @Column(name = "DSTIPO")
    private String dsTipo;

    @Column(name = "NUANO")
    private Integer nuAno;

    @Column(name = "DSPLACA", unique = true)
    private String dsPlaca;


    @ManyToOne
    @JoinColumn(name = "CDCLIENTE", nullable = false)
    private ClienteModel cliente;
    @ManyToOne
    @JoinColumn(name= "NUCPF", nullable = false)
    private ClienteModel nuCpf;
}
