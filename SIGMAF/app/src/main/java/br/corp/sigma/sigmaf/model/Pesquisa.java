package br.corp.sigma.sigmaf.model;

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;

@Entity
public class Pesquisa {

    @PrimaryKey(autoGenerate = true)
    private Long idPesquisa;
    private String nome_pesquisa;
    private String tipo_pesquisa;

    public Long getIdPesquisa() {
        return idPesquisa;
    }

    public void setIdPesquisa(Long idPesquisa) {
        this.idPesquisa = idPesquisa;
    }

    public String getNome_pesquisa() {
        return nome_pesquisa;
    }

    public void setNome_pesquisa(String nome_pesquisa) {
        this.nome_pesquisa = nome_pesquisa;
    }

    public String getTipo_pesquisa() {
        return tipo_pesquisa;
    }

    public void setTipo_pesquisa(String tipo_pesquisa) {
        this.tipo_pesquisa = tipo_pesquisa;
    }

}
