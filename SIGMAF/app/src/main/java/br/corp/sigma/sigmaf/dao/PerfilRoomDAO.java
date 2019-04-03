package br.corp.sigma.sigmaf.dao;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Update;

import br.corp.sigma.sigmaf.model.PerfilSolo;

@Dao
public interface PerfilRoomDAO  {

    @Insert
    void salva(PerfilSolo perfilSolo);

    @Update
    void edita(PerfilSolo perfilSolo);

    @Delete
    void deleta(PerfilSolo perfilSolo);
}
