package br.corp.sigma.sigmaf.ui;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import br.corp.sigma.sigmaf.R;
import br.corp.sigma.sigmaf.dao.PontoDAO;
import br.corp.sigma.sigmaf.model.FormularioPontoHelper;
import br.corp.sigma.sigmaf.model.Ponto;

public class FormularioSoloActivity extends AppCompatActivity {

    private FormularioPontoHelper helper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_formulario_solo);
        helper = new FormularioPontoHelper(this);

    }

    public boolean onCreateOptionsMenu(Menu menu){
        //Preenchendo o conteudo do menu com um XML
        getMenuInflater().inflate(R.menu.menu_formulario_ponto,menu); //inflando o menu com o xml
        return super.onCreateOptionsMenu(menu);
    }

    //Define o que acontece em cada item de menu selecionado
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case R.id.menu_formulario_ok:
                Ponto ponto = helper.pegaPonto();
                //Instanciando um Dao e salvando o aluno no banco ou atualizando os dados
                PontoDAO pontoDAO = new PontoDAO(this);
                pontoDAO.insere(ponto);

                Toast.makeText(FormularioSoloActivity.this, "Ponto " +ponto.getNome()+"Salvo com sucesso!", Toast.LENGTH_SHORT).show();
                pontoDAO.fechaConexao();//Fechando a conexão, método herdado de SQLiteOpenHelper
//                finish();//finalizando a activity
                break;
        }
        return super.onOptionsItemSelected(item);
    }
}
