package br.com.lookbank.contadigital.contadigital.dto;

import br.com.lookbank.contadigital.contadigital.domain.Pessoa;
import com.fasterxml.jackson.annotation.JsonProperty;

import javax.validation.constraints.Email;
import javax.validation.constraints.Future;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;

public class PessoaRequest {



    @JsonProperty("nome")
    @NotBlank
    private String nome;

    @JsonProperty("sobrenome")
    @NotBlank
    private String sobrenome;

    @JsonProperty("data_nascimento")
    @NotNull
    @Future
    private LocalDate dataNascimento; //TODO VALIDACAO DE VAIOR DE 18

    @JsonProperty("email")
    @NotNull
    @Email
    private String email;

    @JsonProperty("cpf")
    @NotNull
    @Email
    private String cpf;

    public Pessoa mapPessoa(){
        return new Pessoa(nome,sobrenome,dataNascimento,email,cpf);
    }

    public String getCpf() {
        return cpf;
    }
}
