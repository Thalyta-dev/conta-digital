package br.com.lookbank.contadigital.contadigital.dto;

import br.com.lookbank.contadigital.contadigital.domain.Endereco;
import br.com.lookbank.contadigital.contadigital.domain.Pessoa;
import com.fasterxml.jackson.annotation.JsonProperty;

import javax.validation.constraints.NotBlank;

public class EnderecoRequest {
    @NotBlank
    @JsonProperty
    private String rua;
    @NotBlank
    @JsonProperty
    private String bairro;
    @NotBlank
    @JsonProperty
    private String complemento;
    @NotBlank
    @JsonProperty
    private String cidade;
    @JsonProperty
    @NotBlank
    private String estado;
    @JsonProperty
    @NotBlank
    private String cep;

    public EnderecoRequest(String rua, String bairro, String complemento, String cidade, String estado, String cep) {
        this.rua = rua;
        this.bairro = bairro;
        this.complemento = complemento;
        this.cidade = cidade;
        this.estado = estado;
        this.cep = cep;
    }

    public Endereco paraEndereco(Pessoa pessoa){
        return new Endereco(rua,bairro,complemento,cidade,estado,cep,pessoa);
    }
}
