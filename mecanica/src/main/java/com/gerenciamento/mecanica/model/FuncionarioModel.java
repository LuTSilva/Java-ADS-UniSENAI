package com.gerenciamento.mecanica.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "TBFUNCIONARIO")
public class FuncionarioModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    @Column(name = "CDFUNCIONARIO")
    private Integer cdFuncionario;

    @Column(name = "NMFUNCIONARIO", length = 50,  nullable = false)
    private String nmFuncionario;

    @Column(name = "NUCPF", length = 14, nullable = false, unique = true)
    private String nuCpf;

    @Column(name = "DSCARGO", length = 50, nullable = false)
    private String dsCargo;

    @Column(name = "VLSALARIO", nullable = false)
    private BigDecimal vlSalario;

    @OneToOne
            (mappedBy = "funcionario", cascade = CascadeType.ALL,
                    fetch = FetchType.LAZY, orphanRemoval = true)
    @JsonIgnore
    private UsuarioModel usuario;

    @ManyToOne
    @JoinColumn(name = "CDFILIAL", nullable = false)
    private FilialModel filial;
}
