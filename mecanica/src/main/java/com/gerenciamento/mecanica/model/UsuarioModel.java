package com.gerenciamento.mecanica.model;

import com.fasterxml.jackson.annotation.JsonIncludeProperties;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

@Entity
@Table(name= "TBUSUARIO")
@JsonIncludeProperties({"cdUsuario", "dsEmail", "flAtivo", "funcionario"})
public class UsuarioModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "CDUSUARIO")
    private Integer cdUsuario;
    @Column(name = "DSEMAIL", length = 100, nullable = false, unique = true)
    private String dsEmail;
    @Column(name = "DSSENHA", length = 100, nullable = false)
    private String dsSenha;
    @Column(name = "FLATIVO", length = 1, nullable = false)
    private String flAtivo;  // "S" = ativo, "N" = inativo
    @Column(name = "FLADMINISTRADOR", length = 1, nullable = false)
    private String flAdministrador; // "S" = ativo, "N" = inativo

    @OneToOne
    @JoinColumn(name="CDFUNCIONARIO")
    private FuncionarioModel funcionario;

}
