package br.com.tech4tenis.tech4tenis.view.model;

public class TenisResponseDTO {
    private String id;
    private String produto;
    private String nomeDoProduto;
    private Integer tamanho;
    private String modelo;
    private String cor;

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
    public String getCor() {
        return cor;
    }
    public void setCor(String cor) {
        this.cor = cor;
    }
    public String getModelo() {
        return modelo;
    }
    public void setModelo(String modelo) {
        this.modelo = modelo;
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
}
