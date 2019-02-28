package br.corp.sigma.sigmaf.model;

import android.widget.EditText;

import br.corp.sigma.sigmaf.R;
import br.corp.sigma.sigmaf.ui.FormularioSolo;

public class FormularioSoloHelper {

    private Solo solo;

    private EditText nomePonto;
    private EditText numeroAmostra;
    private EditText latitude;
    private EditText longitude;


    public FormularioSoloHelper(FormularioSolo formulario){
        solo = new Solo();
        nomePonto = (EditText) formulario.findViewById(R.id.form_nome_amostra);
        numeroAmostra = (EditText) formulario.findViewById(R.id.form_nome_amostra);
        latitude = (EditText) formulario.findViewById(R.id.form_latitute);
        longitude = (EditText) formulario.findViewById(R.id.form_longitude);

    }

    public Solo pegaSolo(){
        solo.setaNome(nomePonto.getText().toString());
        solo.setNumeroAmostra(Integer.getInteger(numeroAmostra.getText().toString()));
        solo.setaLatitude(latitude.getText().toString());
        solo.setaLongitude(longitude.getText().toString());
        return solo;
    }



}
