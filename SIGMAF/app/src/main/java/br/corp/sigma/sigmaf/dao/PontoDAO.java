package br.corp.sigma.sigmaf.dao;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

import br.corp.sigma.sigmaf.model.Ponto;

public class PontoDAO  {
    private Database banco;

    public PontoDAO(Context context){
        banco = new Database(context);
    }

    public void insere(Ponto ponto) {
        //pegando o banco no qual os dados serão inseridos
        SQLiteDatabase db = banco.getWritableDatabase();
        ContentValues dados = pegaDadosPonto(ponto);
        db.insert("Alunos", null, dados);

    }


    private ContentValues pegaDadosPonto(Ponto ponto) {
        //O content Values é um map que faz as validações contra sql Injection
        ContentValues dados = new ContentValues();
        dados.put("nome", ponto.getNome());
        dados.put("numeroAmostra", ponto.getNumeroAmostra());
        dados.put("latitude", ponto.getLatitude());
        dados.put("longitude", ponto.getLongitude());
        return dados;
    }

    public void fechaConexao() {
        banco.close();
    }
}
