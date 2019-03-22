package br.corp.sigma.sigmaf.model;

import android.widget.EditText;

import br.corp.sigma.sigmaf.R;
import br.corp.sigma.sigmaf.ui.FormularioSoloActivity;

public class FormularioPontoHelper {

    private Ponto ponto;

    private EditText nomePonto;
    private EditText numeroAmostra;
    private EditText latitude;
    private EditText longitude;


    public FormularioPontoHelper(FormularioSoloActivity formulario){
        ponto = new Ponto();
        nomePonto = (EditText) formulario.findViewById(R.id.form_nome_amostra);
        numeroAmostra = (EditText) formulario.findViewById(R.id.form_nome_amostra);
        latitude = (EditText) formulario.findViewById(R.id.form_latitute);
        longitude = (EditText) formulario.findViewById(R.id.form_longitude);

    }

    public Ponto pegaPonto(){
        ponto.setNome(nomePonto.getText().toString());
        ponto.setNumeroAmostra(numeroAmostra.getText().toString());
        ponto.setLatitude(latitude.getText().toString());
        ponto.setLongitude(longitude.getText().toString());
        return ponto;
    }

}
