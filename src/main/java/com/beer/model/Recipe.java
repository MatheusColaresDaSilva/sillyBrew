package com.beer.model;

import javax.persistence.Column;
import javax.persistence.Entity;

@Entity(name = "REPICE")
public class Recipe extends AbstractEntity{

    @Column(name = "name")
    private String name;

    @Column(name = "cervejeiro")
    private String cervejeiro;

    @Column(name = "tipo")
    private String estilo;

    @Column(name = "tamanho_lote")
    private String tamanhoLote;

    @Column(name = "eficencia")
    private Long eficiencia;

    Recipe(){}

    public Recipe(String name, String cervejeiro, String tipo, String tamanhoLote, Long eficiencia) {
        this.name = name;
        this.cervejeiro = cervejeiro;
        this.estilo = tipo;
        this.tamanhoLote = tamanhoLote;
        this.eficiencia = eficiencia;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCervejeiro() {
        return cervejeiro;
    }

    public void setCervejeiro(String cervejeiro) {
        this.cervejeiro = cervejeiro;
    }

    public String getEstilo() {
        return estilo;
    }

    public void setEstilo(String estilo) {
        this.estilo = estilo;
    }

    public String getTamanhoLote() {
        return tamanhoLote;
    }

    public void setTamanhoLote(String tamanhoLote) {
        this.tamanhoLote = tamanhoLote;
    }

    public Long getEficiencia() {
        return eficiencia;
    }

    public void setEficiencia(Long eficiencia) {
        this.eficiencia = eficiencia;
    }

    public void updateRecipe(Recipe newRecipe) {
        this.name = newRecipe.getName();
        this.cervejeiro = newRecipe.getCervejeiro();
        this.estilo = newRecipe.getEstilo();
        this.tamanhoLote = newRecipe.getTamanhoLote();
        this.eficiencia = newRecipe.getEficiencia();
    }

    @Override
    public String toString() {
        return "Recipe{" + "id=" +  this.getId() + ","  + "cervejeiro=" + this.cervejeiro + "," + "estilo=" + this.estilo + "," + "nome=" + this.name  + "," + "lote=" + this.tamanhoLote + "," + "eficiencia=" + this.eficiencia + "}";
    }
}
