package br.corp.sigma.sigmaf.dao;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class Database extends SQLiteOpenHelper {

    public Database(Context context) {
        super(context, "sigmaf",null, 1);
    }


    //Criando todas as tabelas do banco aqui
    @Override
    public void onCreate(SQLiteDatabase db) {
        String sql = "CREATE TABLE ponto (id INTEGER PRIMARY KEY, nome_amostra text NOT NULL, numero_amostra text not null, latitude text, longitude text)";
        db.execSQL(sql);
    }


    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
