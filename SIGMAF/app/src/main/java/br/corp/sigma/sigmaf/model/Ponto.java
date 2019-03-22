package br.corp.sigma.sigmaf.model;

import android.arch.persistence.room.PrimaryKey;

public class Ponto {

    @PrimaryKey(autoGenerate = true)
    private long idPonto;
    private String nome;
    private String numeroAmostra;
    private String latitude;
    private String longitude;
    private String descricao;
    //private long idPesquisa; //FK pesquisa

    public long getIdPonto() {
        return idPonto;
    }

    public void setIdPonto(long idPonto) {
        this.idPonto = idPonto;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getLatitude() {
        return latitude;
    }

    public void setLatitude(String latitude) {
        this.latitude = latitude;
    }

    public String getLongitude() {
        return longitude;
    }

    public void setLongitude(String longitude) {
        this.longitude = longitude;
    }

    public String getNumeroAmostra() {
        return numeroAmostra;
    }

    public void setNumeroAmostra(String numeroAmostra) {
        this.numeroAmostra = numeroAmostra;
    }
}
