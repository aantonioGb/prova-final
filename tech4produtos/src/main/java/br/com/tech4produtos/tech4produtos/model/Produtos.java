package br.com.tech4produtos.tech4produtos.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
@Document("produtos")
public class Produtos {
    @Id
    private String id;
    private String marca;
    private String genero;
    private String indicadoPara;
    
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
