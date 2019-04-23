package br.corp.sigma.sigmaf.ui;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import br.corp.sigma.sigmaf.R;
import br.corp.sigma.sigmaf.dao.Database;
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

        Button botaoSalvar = findViewById(R.id.formulario_botao_salvar);
        botaoSalvar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                preenchePerfil();
                perfilDao.salva(perfil);
                Toast.makeText(FormularioPerfilSolo.this,"Perfil Criado Com sucesso",Toast.LENGTH_LONG ).show();
            }
        });
    }

    private void inicializacaoDosCampos() {
        campoNome = findViewById(R.id.formulario_nome_perfil);
        campoDescricao = findViewById(R.id.formulario_descricao);
    }

    private void preenchePerfil() {
        String nome = campoNome.getText().toString();
        String descricao = campoDescricao.getText().toString();

        perfil.setNome(nome);
        perfil.setDescricao(descricao);
    }
}
