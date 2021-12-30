package br.com.lookbank.contadigital.contadigital.controller;

import br.com.lookbank.contadigital.contadigital.domain.Endereco;
import br.com.lookbank.contadigital.contadigital.domain.Pessoa;
import br.com.lookbank.contadigital.contadigital.dto.EnderecoRequest;
import br.com.lookbank.contadigital.contadigital.repository.PessoaPersistencia;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import javax.validation.Valid;

import java.net.URI;
import java.util.Map;
import java.util.UUID;

import static org.springframework.http.HttpStatus.*;
import static org.springframework.http.ResponseEntity.*;
import static org.springframework.web.util.UriComponentsBuilder.*;

@RestController
@RequestMapping("/pessoas/{id}/endereco")
public class CadastrarNovoEnderecoDaPessoaController {
    private final PessoaPersistencia repository;

    public CadastrarNovoEnderecoDaPessoaController(PessoaPersistencia repository) {
        this.repository = repository;
    }

    @PostMapping
    public ResponseEntity<?> cadastrar(@PathVariable UUID id, @RequestBody @Valid EnderecoRequest request) {
        Pessoa pessoa = repository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(NOT_FOUND, "Pessoa nao cadastrada."));

        Endereco endereco = request.paraEndereco(pessoa);

        pessoa.adicionar(endereco);

        repository.save(pessoa);

        URI cadastroFotoDocumento = fromUriString("/pessoas/{id}/documento").buildAndExpand(pessoa.getCodigoIdentificadorPessoa()).toUri();
        URI location = fromUriString("/pessoas/{id}/").buildAndExpand(pessoa.getCodigoIdentificadorPessoa()).toUri();

        return created(location).body(Map.of("proximoPasso", cadastroFotoDocumento));
    }
}
