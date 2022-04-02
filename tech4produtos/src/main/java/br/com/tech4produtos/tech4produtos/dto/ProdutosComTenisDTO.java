package br.com.tech4produtos.tech4produtos.dto;

import java.util.List;

import br.com.tech4produtos.tech4produtos.shared.Tenis;

public class ProdutosComTenisDTO {
    private String id;
    private String marca;
    private String genero;
    private String indicadoPara;
    private List<Tenis> tenis;
    
    public String getId() {
        return id;
    }
    public String getIndicadoPara() {
        return indicadoPara;
    }
    public void setIndicadoPara(String indicadoPara) {
        this.indicadoPara = indicadoPara;
    }
    public String getMarca() {
        return marca;
    }
    public void setMarca(String marca) {
        this.marca = marca;
    }
    public List<Tenis> getTenis() {
        return tenis;
    }
    public void setTenis(List<Tenis> tenis) {
        this.tenis = tenis;
    }
    public void setId(String id) {
        this.id = id;
    }
    public String getGenero() {
        return genero;
    }
    public void setGenero(String genero) {
        this.genero = genero;
    }
}
