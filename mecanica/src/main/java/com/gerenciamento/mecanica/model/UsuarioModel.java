package com.gerenciamento.mecanica.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

@Entity
@Table(name= "TBUSUARIO")
public class UsuarioModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "CDUSUARIO")
    private Integer cdUsuario;
    @Column(name = "DSLOGIN", length = 100, nullable = false, unique = true)
    private String dsLogin;
    @Column(name = "DSSENHA", length = 100, nullable = false)
    private String dsSenha;
    @Column(name = "FLATIVO", length = 1, nullable = false)
    private String flAtivo;

    @ManyToOne
    @JoinColumn(name = "CDFILIAL", nullable = false)
    private FilialModel filial;

    @OneToOne
    @JoinColumn(name="CDFUNCIONARIO")
    private FuncionarioModel funcionario;

}
