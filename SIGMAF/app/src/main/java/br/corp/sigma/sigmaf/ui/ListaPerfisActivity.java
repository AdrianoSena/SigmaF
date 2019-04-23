package br.corp.sigma.sigmaf.ui;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;

import java.util.List;

import br.corp.sigma.sigmaf.R;
import br.corp.sigma.sigmaf.model.PerfilSolo;
import br.corp.sigma.sigmaf.ui.adapters.AdapterListaPerfis;

public class ListaPerfisActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_perfis);
        final List<PerfilSolo> listaPerfis;

//        listaPerfis.setOnItemClickListener(new AdapterView.OnItemClickListener() {
//            @Override
//            public void onItemClick(AdapterView<?>  lista, View item, int position, long id) {
//                PerfilSolo perfil = (PerfilSolo) listaPerfis.getItemAtPosition(position);
//
//                Intent intentVaiProFormulario = new Intent(ListaPerfisActivity.this, FormularioPeffilSolo.this, FormularioPeffilSolo.class);
//                intentVaiProFormulario.putExtra("perfil", perfil);
//                startActivity(intentVaiProFormulario);
//            }
//
//        }

    }





    // TODO: 22/04/2019 método para puxar a lista do banco toda vez que resumir a activity
    public void carregaLista(){
//        PerfilDAO dao = new PerfilDAO(this);
////        List<Perfil> perfis = dao.buscaAlunos();
////        dao.close();
//          AdapterListaPerfis adapter = new AdapterListaPerfis();
//        .setAdapter(adapter);
    }
}
