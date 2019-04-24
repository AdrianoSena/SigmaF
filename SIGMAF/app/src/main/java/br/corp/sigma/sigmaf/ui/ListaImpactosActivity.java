package br.corp.sigma.sigmaf.ui;

import android.content.Intent;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ListView;

import java.util.List;

import br.corp.sigma.sigmaf.R;
import br.corp.sigma.sigmaf.dao.AmostrasDao;
import br.corp.sigma.sigmaf.database.SigmaDatabaseRoom;
import br.corp.sigma.sigmaf.model.Amostra;
import br.corp.sigma.sigmaf.model.PerfilSolo;
import br.corp.sigma.sigmaf.ui.adapters.AdapterListaImpactos;

public class ListaImpactosActivity extends AppCompatActivity {


    private AmostrasDao amostraDao;
    private ListView listaAmostras;
    private PerfilSolo perfilSolo;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_impactos);
        listaAmostras = findViewById(R.id.lista_amostras_lista);
        final List<Amostra> amostras;

        //Recupera o perfil da lista anterior
        Intent intent = getIntent();
        perfilSolo = (PerfilSolo) intent.getSerializableExtra("perfil");

        //Instancia a base de dados
        SigmaDatabaseRoom db = SigmaDatabaseRoom.getInstance(this);
        amostraDao = db.getAmostrasDao();
        carregaLista(perfilSolo);

        FloatingActionButton botaoForm = findViewById(R.id.lista_impacto_botao_novo);
        botaoForm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentVaiProFormulario = new Intent(ListaImpactosActivity.this, FormularioImpactoActivity.class);
                intentVaiProFormulario.putExtra("perfil", perfilSolo);
                startActivity(intentVaiProFormulario);
            }
        });


    }

    @Override
    protected void onResume() {
        super.onResume();
        carregaLista(perfilSolo);
    }

    public void carregaLista(PerfilSolo perfilSolo){
        List<Amostra> amostras = amostraDao.buscaAmostrasPeloId(perfilSolo.getId());
        ListView listaAmostra = findViewById(R.id.lista_amostras_lista);
        AdapterListaImpactos adapter = new AdapterListaImpactos(amostras, this);
        listaAmostra.setAdapter(adapter);
    }
}
