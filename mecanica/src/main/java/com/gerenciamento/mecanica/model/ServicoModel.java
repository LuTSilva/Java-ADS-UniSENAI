package com.gerenciamento.mecanica.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "TBSERVICO")
public class ServicoModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    @Column(name = "CDSERVICO")
    private Integer cdServico;

    @Column(name = "NMSERVICO", length = 100,  nullable = false)
    private String nmServico;

    @Column(name = "DSSERVICO", length = 100, nullable = false)
    private String dsServico;

    @Column(name = "DSTIPO", length = 50, nullable = false)
    private String dsTipo;

    @Column(name = "QTDURACAO", nullable = false)
    private Integer qtDuracao;

    @Column(name = "VLSERVICO", nullable = false)
    private BigDecimal vlServico;

    @ManyToOne
    @JoinColumn(name = "CDFUNCIONARIO", nullable = false)
    private FuncionarioModel funcionario;

    /*
    @OneToMany
    (mappedBy = "servico", cascade = CascadeType.ALL,
    fetch = FetchType.LAZY, orphanRemoval = true)

    @JsonIgnore
    private List<ItensPedidosModel> itensPedidos;

     */
}
