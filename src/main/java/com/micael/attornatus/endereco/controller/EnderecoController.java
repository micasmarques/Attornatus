package com.micael.attornatus.endereco.controller;

import com.micael.attornatus.endereco.domain.Endereco;
import com.micael.attornatus.endereco.repository.EnderecoRepository;
import com.micael.attornatus.pessoa.domain.Pessoa;
import com.micael.attornatus.pessoa.repository.PessoaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class EnderecoController {
    @Autowired
    private final EnderecoRepository enderecoRepository;
    @Autowired
    private final PessoaRepository pessoaRepository;

    public EnderecoController(EnderecoRepository enderecoRepository, PessoaRepository pessoaRepository) {
        this.enderecoRepository = enderecoRepository;
        this.pessoaRepository = pessoaRepository;
    }

    @GetMapping("/endereco")
    public List<Endereco> listar() {
        return enderecoRepository.findAll();
    }

    @GetMapping("/endereco/{id}")
    public List<Endereco> listarPorPessoa(@PathVariable Integer id) {
        Pessoa p = pessoaRepository.findById(id).get();
        return p.getListaEnderecos();
    }

    @PostMapping("/endereco")
    public Endereco cadastrar(@RequestBody Endereco endereco) {
        return enderecoRepository.save(endereco);
    }

    @PutMapping("/endereco")
    public Endereco alterar(@RequestBody Endereco endereco) {
        return enderecoRepository.save(endereco);
    }

    @PostMapping("/endereco/{id}/{codigo}")
    public Endereco enderecoPrincipal(@PathVariable Integer id, @PathVariable Boolean codigo) {
        Endereco e = enderecoRepository.findById(id).get();
        e.setPrincipal(codigo);
        return e;
    }
}
