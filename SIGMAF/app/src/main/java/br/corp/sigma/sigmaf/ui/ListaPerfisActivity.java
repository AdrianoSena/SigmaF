package br.corp.sigma.sigmaf.ui;

import android.content.Intent;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.List;

import br.corp.sigma.sigmaf.R;
import br.corp.sigma.sigmaf.dao.PerfilRoomDAO;
import br.corp.sigma.sigmaf.database.SigmaDatabaseRoom;
import br.corp.sigma.sigmaf.model.PerfilSolo;
import br.corp.sigma.sigmaf.ui.adapters.AdapterListaPerfis;

import static br.corp.sigma.sigmaf.ui.ConstantesActivities.CHAVE_PERFIL;

    public class ListaPerfisActivity extends AppCompatActivity {

    private PerfilRoomDAO perfilDao;
    private ListView listaPerfis;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_perfis);
        listaPerfis = findViewById(R.id.lista_perfis_lista);
        final List<PerfilSolo> listaPerfis;

        //Pegando a referência do banco
        SigmaDatabaseRoom db = SigmaDatabaseRoom.getInstance(this);
        perfilDao = db.getPerfilRoomDAO();
        carregaLista();
        configuraLista();

        FloatingActionButton botaoForm = findViewById(R.id.lista_perfis_botao_novo);
        botaoForm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentVaiProFormulario = new Intent(ListaPerfisActivity.this, FormularioPerfilSolo.class);
                startActivity(intentVaiProFormulario);
            }
        });
    }

    @Override
    protected void onResume() {
        super.onResume();
        carregaLista();
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        AdapterView.AdapterContextMenuInfo info = (AdapterView.AdapterContextMenuInfo) menuInfo;
        final PerfilSolo perfil = (PerfilSolo) listaPerfis.getItemAtPosition(info.position);

        MenuItem deletar = menu.add("Deletar");
        deletar.setOnMenuItemClickListener(new MenuItem.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {
                perfilDao.deleta(perfil);
                carregaLista();
                return false;
            }
        });


        MenuItem impactos = menu.add("Adicionar Impactos");
        impactos.setOnMenuItemClickListener(new MenuItem.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {
               Intent vaiParaTelaImpactos = new Intent(ListaPerfisActivity.this, FormularioImpactoActivity.class);
               vaiParaTelaImpactos.putExtra("perfil", perfil);
               startActivity(vaiParaTelaImpactos);
                return false;
            }
        });
//
        MenuItem tabelaImpactos = menu.add("Tabela de Impactos");
        tabelaImpactos.setOnMenuItemClickListener(new MenuItem.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {
                Intent vaiParaListaImpactos= new Intent(ListaPerfisActivity.this, ListaImpactosActivity.class);
                vaiParaListaImpactos.putExtra("perfil", perfil);
                startActivity(vaiParaListaImpactos);
                return false;
            }
        });
    }


//    @Override
//    public boolean onContextItemSelected(MenuItem item) {
//
//        int itemId = item.getItemId();
//        return super.onContextItemSelected(item);
//    }


    public void carregaLista(){
     List<PerfilSolo> perfis = perfilDao.buscaPerfis();
        ListView listaPerfis = findViewById(R.id.lista_perfis_lista);
        AdapterListaPerfis adapter = new AdapterListaPerfis(this, perfis);
        listaPerfis.setAdapter(adapter);
    }

    private void configuraLista() {
        ListView listaPerfis= findViewById(R.id.lista_perfis_lista);
        configuraListenerDeCliquePorItem(listaPerfis);
        registerForContextMenu(listaPerfis);
    }

    private void configuraListenerDeCliquePorItem(ListView listaPerfis) {
        listaPerfis.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int posicao, long id) {
                PerfilSolo perfilEscolhido = (PerfilSolo) adapterView.getItemAtPosition(posicao);
                ListaPerfisActivity.this.abreFormularioModoEditaPerfil(perfilEscolhido);
            }
        });
    }

        private void abreFormularioModoEditaPerfil(PerfilSolo perfil) {
        Intent vaiParaFormularioActivity = new Intent(ListaPerfisActivity.this, FormularioPerfilSolo.class);
        //Pendura o Aluno na intent para ser carregado no formulário
        vaiParaFormularioActivity.putExtra(CHAVE_PERFIL, perfil);
        startActivity(vaiParaFormularioActivity);
    }

}
