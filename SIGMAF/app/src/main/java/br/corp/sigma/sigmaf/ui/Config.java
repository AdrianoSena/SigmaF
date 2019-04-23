package br.corp.sigma.sigmaf.ui;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import br.corp.sigma.sigmaf.R;

public class Config extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_config);
        getSupportActionBar().setTitle("Configurações");
    }
}
