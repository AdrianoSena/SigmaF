package br.corp.sigma.sigmaf.dao;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Update;

import java.util.List;

import br.corp.sigma.sigmaf.model.PerfilSolo;

@Dao
public interface PerfilRoomDAO  {

    @Insert
    void salva(PerfilSolo perfilSolo);

    @Update
    void edita(PerfilSolo perfilSolo);

    @Delete
    void deleta(PerfilSolo perfilSolo);

    @Query("Select * from PerfilSolo")
    List<PerfilSolo> buscaPerfis();
}
