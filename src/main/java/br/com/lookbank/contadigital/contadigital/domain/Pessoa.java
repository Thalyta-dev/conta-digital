package br.com.lookbank.contadigital.contadigital.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.UUID;

@Entity
public class Pessoa {

    @Id
    @GeneratedValue
    private UUID codigoIdentificadorPessoa;

    @Column(nullable = false)
    private String nome;

    @Column(nullable = false)
    private String sobrenome;

    @Column(nullable = false)
    private String email;

    @Column(nullable = false)
    private LocalDate dataNascimento;

    @Column(nullable = false)
    private String cpf;

    @Column(nullable = false)
    private LocalDateTime dataCriacao;

    public Pessoa() {
    }


    public UUID getCodigoIdentificadorPessoa() {
        return codigoIdentificadorPessoa;
    }

    public Pessoa(String nome, String sobrenome, LocalDate dataNascimento, String email, String cpf) {
        this.nome = nome;
        this.sobrenome = sobrenome;
        this.email = email;
        this.cpf = cpf;
        this.dataNascimento = dataNascimento;
        dataCriacao = LocalDateTime.now();
    }

}
