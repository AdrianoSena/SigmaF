package br.corp.sigma.sigmaf.model;

import android.arch.persistence.room.Entity;

import java.util.ArrayList;
import java.util.List;

@Entity
public class PerfilSolo extends Ponto {

    @Override
    public String toString(){
        return super.getId() + " - " + super.getNome();
    }
}
