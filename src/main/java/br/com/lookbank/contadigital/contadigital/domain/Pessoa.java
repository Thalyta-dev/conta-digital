package br.com.lookbank.contadigital.contadigital.domain;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

import static javax.persistence.CascadeType.*;

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

    @OneToMany(mappedBy = "pessoa", cascade = MERGE)
    private Set<Endereco> enderecos = new HashSet<>();

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

    public void adicionar(Endereco endereco) {
        this.enderecos.add(endereco);
    }
}
