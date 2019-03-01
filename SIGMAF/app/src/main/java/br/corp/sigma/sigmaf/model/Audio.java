package br.corp.sigma.sigmaf.model;

public class Audio {

    private long idAudio;
    private String audio;
    private long idPonto; //Fk do ponto

    public long getIdAudio() {
        return idAudio;
    }

    public void setIdAudio(long idAudio) {
        this.idAudio = idAudio;
    }

    public String getAudio() {
        return audio;
    }

    public void setAudio(String audio) {
        this.audio = audio;
    }

    public long getIdPonto() {
        return idPonto;
    }

    public void setIdPonto(long idPonto) {
        this.idPonto = idPonto;
    }


}
