package br.com.lookbank.contadigital.contadigital.dto;

import br.com.lookbank.contadigital.contadigital.anotattion.MaiorIdade;
import br.com.lookbank.contadigital.contadigital.anotattion.UniqueValue;
import br.com.lookbank.contadigital.contadigital.domain.Pessoa;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.hibernate.validator.constraints.br.CPF;

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
    @MaiorIdade
    private LocalDate dataNascimento;

    @JsonProperty("email")
    @NotNull
    @Email
    @UniqueValue(fieldName = "email", domainClass = Pessoa.class, message = "email duplicado")
    private String email;

    @JsonProperty("cpf")
    @NotBlank
    @CPF
    @UniqueValue(fieldName = "cpf", domainClass = Pessoa.class, message = "cpf duplicado")
    private String cpf;

    public Pessoa mapPessoa(){
        return new Pessoa(nome,sobrenome,dataNascimento,email,cpf);
    }

    public String getEmail() {
        return email;
    }

    public String getCpf() {
        return cpf;
    }
}
