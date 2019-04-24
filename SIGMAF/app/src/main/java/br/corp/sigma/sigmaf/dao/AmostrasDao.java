package br.corp.sigma.sigmaf.dao;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;

import java.util.List;

import br.corp.sigma.sigmaf.model.Amostra;

@Dao
public interface AmostrasDao {

    @Insert
    void insere(Amostra amostra);

    @Delete
    void deleta(Amostra amostra);

// TODO: 03/04/2019 Criar método listar amostras pelo Id do Perfil
    @Query("Select * from amostra where perfil_id = :perfilId")
    List<Amostra> buscaAmostrasPeloId(long perfilId);
}
