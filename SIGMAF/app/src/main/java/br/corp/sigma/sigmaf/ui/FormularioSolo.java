package br.corp.sigma.sigmaf.ui;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;

import br.corp.sigma.sigmaf.R;

public class FormularioSolo extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_formulario_solo);
    }

    public boolean onCreateOptionsMenu(Menu menu){
        //Preenchendo o conteudo do menu com um XML
        getMenuInflater().inflate(R.menu.menu_formulario_ponto,menu); //inflando o menu com o xml
        return super.onCreateOptionsMenu(menu);
    }
}
