package br.corp.sigma.sigmaf.ui;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import br.corp.sigma.sigmaf.R;
import br.corp.sigma.sigmaf.dao.AmostrasDao;
import br.corp.sigma.sigmaf.database.SigmaDatabaseRoom;
import br.corp.sigma.sigmaf.model.Amostra;
import br.corp.sigma.sigmaf.model.PerfilSolo;

public class FormularioImpactoActivity extends AppCompatActivity {

    private EditText campoProfundidade;
    private EditText campoImpacto;
    private PerfilSolo perfil;
    private Amostra amostra;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_formulario_impacto);
        amostra = new Amostra();
        SigmaDatabaseRoom db = SigmaDatabaseRoom.getInstance(this);
        final AmostrasDao amostraDao = db.getAmostrasDao();
        //Pegando o perfil que vem da lista
        Intent intent = getIntent();
        perfil = (PerfilSolo) intent.getSerializableExtra("perfil");
        inicializacaoDosCampos();

        Button botaoSalvar = findViewById(R.id.formulario_impacto_salvar);
        botaoSalvar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                preencheAmostra();
                amostraDao.insere(amostra);
                Toast.makeText(FormularioImpactoActivity.this,"Amostra salva com Sucesso! ",Toast.LENGTH_LONG ).show();
                finish();

            }
        });
    }

    private void inicializacaoDosCampos() {
        campoImpacto = findViewById(R.id.formulario_impacto_impacto);
        campoProfundidade = findViewById(R.id.formulario_impacto_profundidade);
    }

    private void preencheAmostra() {
        String impacto = campoImpacto.getText().toString();
        String profundidade = campoProfundidade.getText().toString();
//        amostra = new Amostra(Integer.parseInt(impacto),Double.parseDouble(profundidade), perfil.getId());
        amostra.setImpacto(Integer.parseInt(impacto));
        amostra.setProfundidade(Double.parseDouble(profundidade));
        amostra.setPerfil_id(perfil.getId());
    }


}
