package br.corp.sigma.sigmaf.model;

import android.arch.persistence.room.Entity;

import java.util.List;

@Entity

public class PerfilSolo extends Ponto {

    private List<Amostra> amostras;
}
