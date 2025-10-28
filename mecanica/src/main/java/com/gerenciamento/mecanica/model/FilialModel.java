package com.gerenciamento.mecanica.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor

@Entity
@Table(name= "TBFILIAL")
public class FilialModel {
@Id@GeneratedValue(strategy = GenerationType.IDENTITY)
@Column(name = "CDFILIAL")
private Integer cdFilial;
@Column(name="NMRAZAO", length = 100, nullable = false)
private String nmRazao;
@Column(name="NMFANTASIA", length = 100)
private String nmFantasia;
@Column(name="NUCNPJ", length = 20, nullable = false, unique = true)
private String nuCnpj;
@Column(name="DSLOCAL", length = 200)
private String dsLocal;
@Column(name="NUTELEFONE", length = 14)
private String nuTelefone;
@Column(name="FLATIVO", length=1, nullable=false)
private String flAtivo;  // "S" = ativo, "N" = inativo

@OneToMany (mappedBy = "filial", cascade = CascadeType.ALL,
fetch = FetchType.LAZY, orphanRemoval = true)

@JsonIgnore
private List<FuncionarioModel> funcionarios;

}
