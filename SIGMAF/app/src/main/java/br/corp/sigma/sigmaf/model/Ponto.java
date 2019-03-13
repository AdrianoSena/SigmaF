package br.corp.sigma.sigmaf.model;

public class Ponto {

    private long idPonto;
    //Tipo ponto fk tipo do ponto
    private String nome;
    private String numeroAmostra;
    private String latitude;
    private String longitude;
    private long idPesquisa; //FK pesquisa

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

    public long getIdPesquisa() {
        return idPesquisa;
    }

    public void setIdPesquisa(long idPesquisa) {
        this.idPesquisa = idPesquisa;
    }

    public String getNumeroAmostra() {
        return numeroAmostra;
    }

    public void setNumeroAmostra(String numeroAmostra) {
        this.numeroAmostra = numeroAmostra;
    }
}
