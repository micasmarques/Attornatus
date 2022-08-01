package com.micael.attornatus.endereco.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "Endereco")
public class Endereco {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_ENDERECO")
    @Getter
    @Setter
    private Integer id;

    @Column(name = "LOGRADOURO", nullable = false)
    @Getter
    @Setter
    private String logradouro;

    @Column(name = "CEP", nullable = false)
    @Getter
    @Setter
    private String cep;

    @Column(name = "NUMERO")
    @Getter
    @Setter
    private Integer numero;

    @Column(name = "CIDADE")
    @Getter
    @Setter
    private String cidade;

    @JsonIgnore
    @Getter
    @Setter
    private boolean principal;

}
