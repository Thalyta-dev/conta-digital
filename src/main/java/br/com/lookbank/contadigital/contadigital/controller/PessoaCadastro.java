package br.com.lookbank.contadigital.contadigital.controller;


import br.com.lookbank.contadigital.contadigital.domain.Pessoa;
import br.com.lookbank.contadigital.contadigital.dto.PessoaRequest;
import br.com.lookbank.contadigital.contadigital.repository.PessoaPersistencia;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import javax.validation.Valid;
import java.util.Map;
import java.util.UUID;

import static org.springframework.http.ResponseEntity.created;
import static org.springframework.web.util.UriComponentsBuilder.fromUriString;

@RestController
@RequestMapping("/pessoas")
public class PessoaCadastro {

    private final PessoaPersistencia pessoaPersistencia;

    private final static String PATH = "/pessoas/{id}";

    public PessoaCadastro(PessoaPersistencia pessoaPersistencia) {
        this.pessoaPersistencia = pessoaPersistencia;
    }

    @PostMapping
    public ResponseEntity cadastrarPessoa(@RequestBody @Valid final PessoaRequest pessoaRequest) {

        final Pessoa pessoa = pessoaPersistencia.save(pessoaRequest.mapPessoa());

        final  UUID id = pessoa.getCodigoIdentificadorPessoa();

        return created(fromUriString(PATH).buildAndExpand(id).toUri()).
                body(Map.of("proximoPasso", fromUriString(PATH + "/endereco").buildAndExpand(id).toUri()));

    }
}
