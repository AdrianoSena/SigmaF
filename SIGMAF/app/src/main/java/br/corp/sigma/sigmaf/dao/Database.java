package br.corp.sigma.sigmaf.dao;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class Database extends SQLiteOpenHelper {

    public Database(Context context,  String name,  SQLiteDatabase.CursorFactory factory, int version) {
        super(context, "sigma",null, 1);
    }


    //Criando todas as tabelas do banco aqui
    @Override
    public void onCreate(SQLiteDatabase db) {
        String sql = "CREATE TABLE pesquisa_solo (id INTEGER PRIMARY KEY, nome_amostra text NOT NULL, numero_amostra text not null, descricao text, latitude text, longitude text)";
        db.execSQL(sql);
    }


    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}