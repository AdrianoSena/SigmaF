package br.corp.sigma.sigmaf.ui;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Environment;
import android.provider.MediaStore;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.content.FileProvider;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import br.corp.sigma.sigmaf.R;
import br.corp.sigma.sigmaf.dao.PerfilRoomDAO;
import br.corp.sigma.sigmaf.database.SigmaDatabaseRoom;
import br.corp.sigma.sigmaf.model.PerfilSolo;

public class FormularioPerfilSolo extends AppCompatActivity {


    private EditText campoNome;
    private EditText campoDescricao;
    private PerfilSolo perfil;
    private PerfilRoomDAO perfilDao;
    private String caminhoFoto;
    public static final int CODIGO_CAMERA = 1;
    private ImageView campoFoto;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_formulario_perfil_solo);
        SigmaDatabaseRoom database = SigmaDatabaseRoom.getInstance(this);
        perfilDao = database.getPerfilRoomDAO();
        inicializacaoDosCampos();
        perfil = new PerfilSolo();

        //Recebe a intent para preencher o formulário
        Intent intent = getIntent();
        perfil = (PerfilSolo) intent.getSerializableExtra("perfil");
        if (perfil != null) {
            preencheFormulario(perfil);
        }

        inicializacaoDosCampos();

        FloatingActionButton botaoFoto = findViewById(R.id.formulario_botao_imagem);
        botaoFoto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentCamera = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);

                File arquivoFoto = null;
                try {
                    arquivoFoto = criarImagem();
                } catch (IOException ex) {
                    //Tratar Erro caso a imagem não seja lida
                }
                // Continue only if the File was successfully created
                if (arquivoFoto != null) {
                    Uri photoURI = FileProvider.getUriForFile(FormularioPerfilSolo.this,
                            "br.corp.sigma.sigmaf.fileprovider",
                            arquivoFoto);
                    intentCamera.putExtra(MediaStore.EXTRA_OUTPUT, photoURI);
                    startActivityForResult(intentCamera, CODIGO_CAMERA);
                }
            }
        });


    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (resultCode == Activity.RESULT_OK) {
            if (requestCode == CODIGO_CAMERA) {
                carregaImagem(caminhoFoto);
            }
        }

    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_formulario, menu);

        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.menu_formulario_ok:
                preenchePerfil();
                if (Long.valueOf(perfil.getId()) != null) {
                    perfilDao.edita(perfil);
                    Toast.makeText(FormularioPerfilSolo.this,"Perfil editado Com sucesso",Toast.LENGTH_LONG ).show();

                } else {
                    perfilDao.salva(perfil);
                    Toast.makeText(FormularioPerfilSolo.this,"Perfil Criado Com sucesso",Toast.LENGTH_LONG ).show();
                }
                finish();
                break;
        }
        return super.onOptionsItemSelected(item);
    }

    private void inicializacaoDosCampos() {
        campoNome = findViewById(R.id.formulario_perfil_nome);
        campoDescricao = findViewById(R.id.formulario_perfil_descricao);
        campoFoto = findViewById(R.id.formulario_imagem);
    }

    private void preenchePerfil() {
        String nome = campoNome.getText().toString();
        String descricao = campoDescricao.getText().toString();
        perfil.setNome(nome);
        perfil.setDescricao(descricao);
        perfil.setFoto(caminhoFoto);
    }

    public void preencheFormulario(PerfilSolo perfil) {
        campoNome.setText(perfil.getNome());
        campoDescricao.setText(perfil.getDescricao());
        carregaImagem(perfil.getFoto());
        this.perfil = perfil;
    }


    private File criarImagem() throws IOException {
        // Create an image file name
        String timeStamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
        String imageFileName = "JPEG_" + timeStamp + "_";
        File storageDir = getExternalFilesDir(Environment.DIRECTORY_PICTURES);
        File image = File.createTempFile(
                imageFileName,  /* prefix */
                ".jpg",         /* suffix */
                storageDir      /* directory */
        );
        // Save a file: path for use with ACTION_VIEW intents
        caminhoFoto = image.getAbsolutePath();
        System.out.println(caminhoFoto);
        return image;
    }

//    private void carregaImagem() {
//        // Get the dimensions of the View
//        int targetW = campoFoto.getWidth();
//        int targetH = campoFoto.getHeight();
//
//        // Get the dimensions of the bitmap
//        BitmapFactory.Options bmOptions = new BitmapFactory.Options();
//        bmOptions.inJustDecodeBounds = true;
//        BitmapFactory.decodeFile(caminhoFoto, bmOptions);
//        int photoW = bmOptions.outWidth;
//        int photoH = bmOptions.outHeight;
//
//        // Determine how much to scale down the image
//        int scaleFactor = Math.min(photoW/targetW, photoH/targetH);
//        // Decode the image file into a Bitmap sized to fill the View
//        bmOptions.inJustDecodeBounds = false;
//        bmOptions.inSampleSize = scaleFactor;
//        bmOptions.inPurgeable = true;
//
//        Bitmap bitmap = BitmapFactory.decodeFile(caminhoFoto, bmOptions);
//        campoFoto.setImageBitmap(bitmap);
//    }

    public void carregaImagem(String caminhoFoto){
        if (caminhoFoto != null) {
            Bitmap bitmap = BitmapFactory.decodeFile(caminhoFoto);
            Bitmap bitmapReduzido = Bitmap.createScaledBitmap(bitmap, 300, 300, true);
            campoFoto.setImageBitmap(bitmapReduzido);
            campoFoto.setScaleType(ImageView.ScaleType.FIT_XY);
            campoFoto.setTag(caminhoFoto);
        }
    }

}
