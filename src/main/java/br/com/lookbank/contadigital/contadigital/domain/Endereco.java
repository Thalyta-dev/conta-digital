package br.com.lookbank.contadigital.contadigital.domain;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

import static javax.persistence.GenerationType.*;

@Entity
public class Endereco {
    @Id
    @GeneratedValue(strategy = IDENTITY)
    private Long id;
    @Column(nullable = false)
    private String rua;
    @Column(nullable = false)
    private String bairro;
    @Column(nullable = false)
    private String complemento;
    @Column(nullable = false)
    private String cidade;
    @Column(nullable = false)
    private String estado;
    @Column(nullable = false)
    private String cep;

    @ManyToOne(optional = false)
    private Pessoa pessoa;

    public Endereco(@NotBlank String rua, @NotBlank String bairro, @NotBlank String complemento, @NotBlank String cidade, @NotBlank String estado, @NotBlank String cep, Pessoa pessoa) {
        this.rua=rua;
        this.bairro=bairro;
        this.complemento=complemento;
        this.cidade=cidade;
        this.estado=estado;
        this.cep=cep;
    }

    /**
     * para uso do hibernate
      */
    @Deprecated
    public Endereco() {

    }
}
