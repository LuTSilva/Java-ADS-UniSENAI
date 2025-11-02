package com.gerenciamento.mecanica.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIncludeProperties;
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
@JsonIncludeProperties({"cdCliente", "nmCliente"})
public class ClienteModel {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)

    @Column(name = "CDCLIENTE")
    private Integer cdCliente;

    @Column(name = "NMCLIENTE", nullable = false, length = 100)
    private String nmCliente;

    @Column(name = "DSEMAIL", length = 100, nullable = false, unique = true)
    private String dsEmail;

    @Column(name = "NUTELEFONE", length = 15)
    private String nuTelefone;

    @Column(name = "NUCPF", length = 14, nullable = false, unique = true)
    private String nuCpf;

    @OneToMany(mappedBy = "cliente", cascade = CascadeType.ALL,
            fetch = FetchType.LAZY, orphanRemoval = true)
    @JsonIgnore
    private List<VeiculoModel> veiculos;

    @OneToMany(mappedBy = "cliente", cascade = CascadeType.ALL,
            fetch = FetchType.LAZY, orphanRemoval = true)
    @JsonIgnore
    private List<PedidoModel> pedidos;
}
