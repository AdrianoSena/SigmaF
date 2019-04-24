package br.corp.sigma.sigmaf.model;

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.ForeignKey;
import android.arch.persistence.room.Ignore;
import android.arch.persistence.room.PrimaryKey;


import static android.arch.persistence.room.ForeignKey.CASCADE;

@Entity(foreignKeys = @ForeignKey(entity = PerfilSolo.class,
                                    parentColumns = "id",
                                    childColumns = "perfil_id",
                                    onDelete = CASCADE))
public class Amostra {

    @PrimaryKey(autoGenerate = true)
    private long id;
    private int impacto;
    private double profundidade;
    private Long perfil_id;

    @Ignore
    public Amostra(int impacto, double profundidade, Long perfil_id) {

        this.impacto = impacto;
        this.profundidade = profundidade;
        this.perfil_id = perfil_id;
    }

    public Amostra(){

    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public int getImpacto() {
        return impacto;
    }

    public void setImpacto(int impacto) {
        this.impacto = impacto;
    }

    public double getProfundidade() {
        return profundidade;
    }

    public void setProfundidade(double profundidade) {
        this.profundidade = profundidade;
    }

    public Long getPerfil_id() {
        return perfil_id;
    }

    public void setPerfil_id(Long perfil_id) {
        this.perfil_id = perfil_id;
    }
}
