package br.com.tech4tenis.tech4tenis.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
@Document("tenis")
public class Tenis {
    @Id
    private String id;
    private String produto;
    private String nomeDoProduto;
    private Integer tamanho;
    private Integer anoLancamento;
    private String modelo;
    private String cor;
    private Double valor;
    
    public String getId() {
        return id;
    }
    public String getNomeDoProduto() {
        return nomeDoProduto;
    }
    public void setNomeDoProduto(String nomeDoProduto) {
        this.nomeDoProduto = nomeDoProduto;
    }
    public String getProduto() {
        return produto;
    }
    public void setProduto(String produto) {
        this.produto = produto;
    }
    public Double getValor() {
        return valor;
    }
    public void setValor(Double valor) {
        this.valor = valor;
    }
    public void setId(String id) {
        this.id = id;
    }
    public Integer getTamanho() {
        return tamanho;
    }
    public void setTamanho(Integer tamanho) {
        this.tamanho = tamanho;
    }
    public Integer getAnoLancamento() {
        return anoLancamento;
    }
    public void setAnoLancamento(Integer anoLancamento) {
        this.anoLancamento = anoLancamento;
    }
    public String getModelo() {
        return modelo;
    }
    public void setModelo(String modelo) {
        this.modelo = modelo;
    }
    public String getCor() {
        return cor;
    }
    public void setCor(String cor) {
        this.cor = cor;
    }
}
