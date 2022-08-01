package com.micael.attornatus.pessoa.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.micael.attornatus.endereco.domain.Endereco;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "Pessoa")
public class Pessoa {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    @Getter
    @Setter
    private Integer id;

    @Column(name = "NOME", nullable = false)
    @Getter
    @Setter
    private String nome;

    @Column(name = "DATA_NASCIMENTO", nullable = false)
    @Getter
    @Setter
    private LocalDate dataNascimento;

    @OneToMany
    @JoinColumn(name = "ID_ENDERECO")
    @Getter
    @Setter
    private Endereco endereco;

    @JsonIgnore
    @Getter
    @Setter
    private List<Endereco> listaEnderecos;

    public Pessoa() {
    }

}