package br.corp.sigma.sigmaf.model;

public class Pesquisa {

    private Long idPesquisa;
    private String nome_pesquisa;
    private String tipo_pesquisa;
    private Usuario usuario;

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

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }
}
