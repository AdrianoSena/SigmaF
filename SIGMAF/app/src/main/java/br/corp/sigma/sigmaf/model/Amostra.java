package br.corp.sigma.sigmaf.model;

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.ForeignKey;
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
    private final int perfil_id;

    public Amostra(int impacto, double profundidade, int perfil_id) {

        this.impacto = impacto;
        this.profundidade = profundidade;
        this.perfil_id = perfil_id;
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

    public int getPerfil_id() {
        return perfil_id;
    }
}
