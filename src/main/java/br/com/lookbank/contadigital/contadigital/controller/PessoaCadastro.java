package br.com.lookbank.contadigital.contadigital.controller;


import br.com.lookbank.contadigital.contadigital.domain.Pessoa;
import br.com.lookbank.contadigital.contadigital.dto.PessoaRequest;
import br.com.lookbank.contadigital.contadigital.repository.PessoaPersistencia;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.Map;
import java.util.UUID;

import static org.springframework.http.ResponseEntity.created;
import static org.springframework.web.util.UriComponentsBuilder.fromUriString;

@RestController(value = "/pessoas")
public class PessoaCadastro {

    final PessoaPersistencia pessoaPersistencia;

    final static String PATH = "/pessoas/{id}";

    public PessoaCadastro(PessoaPersistencia pessoaPersistencia) {
        this.pessoaPersistencia = pessoaPersistencia;
    }

    @PostMapping
    public ResponseEntity cadastrarPessoa(@RequestBody final PessoaRequest pessoaRequest) {

        pessoaPersistencia.findByCpf(pessoaRequest.getCpf()).orElseThrow(
                () -> new ResponseStatusException(HttpStatus.UNPROCESSABLE_ENTITY, "Cpf já cadastrado no sistema"));

        final Pessoa pessoa = pessoaPersistencia.save(pessoaRequest.mapPessoa());

        final UUID id = pessoa.getCodigoIdentificadorPessoa();


        return created(fromUriString(PATH).buildAndExpand(id).toUri()).
                body(Map.of("proximoPasso", fromUriString(PATH + "/endereco").buildAndExpand(id).toUri()));

    }
}
