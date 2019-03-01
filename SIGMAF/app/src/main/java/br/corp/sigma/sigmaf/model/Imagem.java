package br.corp.sigma.sigmaf.model;

public class Imagem {

    private long idImagem;
    private String imagem;
    private long idPonto; //Fk do ponto

    public long getIdImagem() {
        return idImagem;
    }

    public void setIdImagem(long idImagem) {
        this.idImagem = idImagem;
    }

    public String getImagem() {
        return imagem;
    }

    public void setImagem(String imagem) {
        this.imagem = imagem;
    }

    public long getIdPonto() {
        return idPonto;
    }

    public void setIdPonto(long idPonto) {
        this.idPonto = idPonto;
    }
}
