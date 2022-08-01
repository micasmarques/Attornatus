package com.micael.attornatus.pessoa.controller;

import com.micael.attornatus.pessoa.domain.Pessoa;
import com.micael.attornatus.pessoa.repository.PessoaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class PessoaController {
    @Autowired
    private final PessoaRepository pessoaRepository;

    public PessoaController(PessoaRepository pessoaRepository) {
        this.pessoaRepository = pessoaRepository;
    }

    @GetMapping("/pessoa")
    public List<Pessoa> listar() {
        return pessoaRepository.findAll();
    }

    @PostMapping("/pessoa")
    public Pessoa cadastrar(@RequestBody Pessoa usuario) {
        return pessoaRepository.save(usuario);
    }

    @GetMapping("/pessoa/{codigo}")
    public Pessoa filtrar(@PathVariable Integer codigo) {
        return pessoaRepository.findById(codigo)
                .orElseThrow(() -> new RuntimeException("Usuario não encontrado"));
    }

    @PutMapping("/pessoa")
    public Pessoa alterar(@RequestBody Pessoa user) {
        return pessoaRepository.save(user);
    }
}