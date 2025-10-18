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
@Table(name = "TBFUNCIONARIO")
public class FuncionarioModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    @Column(name = "CDFUNCIONARIO")
    private Integer cdFuncionario;

    @Column(name = "NOMEFUNCIONARIO")
    private String nomeFuncionario;

    @Column(name = "CPFFUNCIONARIO", unique = true)
    private String cpfFuncionario;

    @Column(name = "EMAILFUNCIONARIO", unique = true)
    private String emailFuncionario;

    @Column(name = "SENHAFUNCIONARIO")
    private String senhaFuncionario;

    @Column(name = "CARGOFUNCIONARIO")
    private String cargoFuncionario;

    @Column(name = "SALARIOFUNCIONARIO")
    private String salarioFuncionario;

    @OneToOne
            (mappedBy = "funcionario", cascade = CascadeType.ALL,
                    fetch = FetchType.LAZY, orphanRemoval = true)

    @JsonIgnore
    private UsuarioModel usuario;
}
