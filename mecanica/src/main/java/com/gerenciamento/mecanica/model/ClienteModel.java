package com.gerenciamento.mecanica.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table (name = "TBCLIENTE")
public class ClienteModel {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)

    @Column(name = "CDCLIENTE")
    private Integer cdCliente;

    @Column(name = "NOMECLIENTE")
    private String nomeCliente;

    @Column(name = "EMAILCLIENTE", unique = true)
    private String emailCliente;

    @Column(name = "TELEFONECLIENTE")
    private String telefoneCliente;

    @Column(name = "SENHACLIENTE")
    private String senhaCliente;

    @Column(name = "CPFCLIENTE", unique = true)
    private String cpfCliente;

    @Column(name = "CEPCLIENTE")
    private String cepCliente;

    @Column(name = "CIDADECLIENTE")
    private String cidadeCliente;

    @Column(name = "BAIRROCLIENTE")
    private String bairroCliente;

    @Column(name = "RUACLIENTE")
    private String ruaCliente;

    @Column(name = "NUMEROENDERECOCLIENTE")
    private String numeroEnderecoCliente;

    @OneToMany(mappedBy = "cliente", cascade = CascadeType.ALL,
    fetch = FetchType.LAZY, orphanRemoval = true)

    @JsonIgnore
    private List<VeiculoModel> veiculos;

}
