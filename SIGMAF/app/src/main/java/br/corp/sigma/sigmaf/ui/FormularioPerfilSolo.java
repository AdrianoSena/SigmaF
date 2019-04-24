package br.corp.sigma.sigmaf.ui;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import br.corp.sigma.sigmaf.R;
import br.corp.sigma.sigmaf.dao.PerfilRoomDAO;
import br.corp.sigma.sigmaf.database.SigmaDatabaseRoom;
import br.corp.sigma.sigmaf.model.PerfilSolo;

public class FormularioPerfilSolo extends AppCompatActivity {


    private EditText campoNome;
    private EditText campoDescricao;
    private PerfilSolo perfil;
    private PerfilRoomDAO perfilDao;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_formulario_perfil_solo);
        SigmaDatabaseRoom database = SigmaDatabaseRoom.getInstance(this);
        perfilDao = database.getPerfilRoomDAO();
        inicializacaoDosCampos();
        perfil = new PerfilSolo();

        Intent intent = getIntent();
//        perfil = (PerfilSolo) intent.getSerializableExtra("perfil");
//        if (perfil != null) {
//            preencheFormulario(perfil);
//        }

        inicializacaoDosCampos();

        Button botaoSalvar = findViewById(R.id.formulario_impacto_salvar);
        botaoSalvar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                preenchePerfil();
                if (Long.valueOf(perfil.getId()) == null) {
                    perfilDao.edita(perfil);
                } else {
                    perfilDao.salva(perfil);
                }
                Toast.makeText(FormularioPerfilSolo.this,"Perfil Criado Com sucesso",Toast.LENGTH_LONG ).show();
                finish();

            }
        });
    }

    private void inicializacaoDosCampos() {
        campoNome = findViewById(R.id.formulario_impacto_impacto);
        campoDescricao = findViewById(R.id.formulario_impacto_profundidade);
    }

    private void preenchePerfil() {
        String nome = campoNome.getText().toString();
        String descricao = campoDescricao.getText().toString();
        perfil.setNome(nome);
        perfil.setDescricao(descricao);
    }

    public void preencheFormulario(PerfilSolo perfil) {
        campoNome.setText(perfil.getNome());
        campoDescricao.setText(perfil.getDescricao());
        this.perfil = perfil;
    }

}
