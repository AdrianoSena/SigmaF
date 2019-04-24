package br.corp.sigma.sigmaf.database;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;
import android.content.Context;

import br.corp.sigma.sigmaf.dao.AmostrasDao;
import br.corp.sigma.sigmaf.dao.PerfilRoomDAO;
import br.corp.sigma.sigmaf.model.Amostra;
import br.corp.sigma.sigmaf.model.PerfilSolo;

@Database(entities = {PerfilSolo.class, Amostra.class}, version = 2, exportSchema = false)
public abstract class SigmaDatabaseRoom  extends RoomDatabase {

    private static final String NOME_BANCO_DE_DADOS = "sigma.db";

    public abstract PerfilRoomDAO getPerfilRoomDAO();
    public abstract AmostrasDao getAmostrasDao();

    private static SigmaDatabaseRoom instance;

    public static synchronized SigmaDatabaseRoom getInstance(Context context){
        if (instance == null){
            instance = Room.databaseBuilder(context, SigmaDatabaseRoom.class, NOME_BANCO_DE_DADOS)
                    .allowMainThreadQueries()
                    .fallbackToDestructiveMigration()//Destrói a estrutura do banco de dados
                    .build();
        }
        return instance;
    }
}
