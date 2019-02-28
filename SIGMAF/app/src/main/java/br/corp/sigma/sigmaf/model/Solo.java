package br.corp.sigma.sigmaf.model;

public class Solo {


    private long id;
    private Double ph;
    private int numeroAmostra;
    private String descricao;
    private Ponto ponto;

    public Double getPh() {
        return ph;
    }

    public void setPh(Double ph) {
        this.ph = ph;
    }

    public int getNumeroAmostra() {
        return numeroAmostra;
    }

    public void setNumeroAmostra(int numeroAmostra) {
        this.numeroAmostra = numeroAmostra;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public void setaLatitude(String latitude){
        ponto.setLatitude(latitude);
    }

    public void setaLongitude(String longitude){
        ponto.setLatitude(longitude);
    }

    public void setaNome(String nome){
        ponto.setNome(nome);
    }
}
