package br.corp.sigma.sigmaf.ui;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import br.corp.sigma.sigmaf.R;

public class NovaPesquisa extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nova_pesquisa);
        getSupportActionBar().setTitle("Nova Pesquisa");
    }
    public void iniciaPlanta(View view){
        Intent telaPlanta = new Intent(this,Planta.class);
        startActivity(telaPlanta);
    }
    public void iniciaSolo(View view){
        Intent telaSolo = new Intent(this,FormularioPerfilSolo.class);
        startActivity(telaSolo);
    }
    public void iniciaOutros(View view){
        Intent telaOutros = new Intent(this,Outros.class);
        startActivity(telaOutros);
    }
}
