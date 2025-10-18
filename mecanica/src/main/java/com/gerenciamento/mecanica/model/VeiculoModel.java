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
    private int cdVeiculo;

    @Column(name = "MARCAVEICULO")
    private String marcaVeiculo;

    @Column(name = "MODELOVEICULO")
    private String modeloVeiculo;

    @Column(name = "TIPOVEICULO")
    private String tipoVeiculo;

    @Column(name = "ANOVEICULO")
    private int anoVeiculo;

    @Column(name = "PLACAVEICULO", unique = true)
    private String placaVeiculo;


    @ManyToOne
    @JoinColumn(name = "CDCLIENTE", nullable = false)
    private ClienteModel cliente;

}
