/*
    Erik Kaue Paroline Jose dos Santos - RA: 20960545
    Fernanda Pereira Umberto - RA: 20943426
    Guilherme Rodrigues de Miranda - RA: 20996393
    Matheus Marques de Souza - RA: 20981531
    Milena Basso - RA: 20956610
 */
package com.example.apscdm;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class ConsultaLivro extends AppCompatActivity {
    public static final String KEY_INFO_TEXTO = "KEY_INFO_TEXTO";
    Button consultar;
    EditText consulta;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_consulta_livro);
        consultar = (Button) findViewById(R.id.bConsultar);
        consulta = (EditText) findViewById(R.id.etConsulta);
        consultar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Bundle bundleInf = new Bundle();
                String msg = consulta.getText().toString();
                bundleInf.putString(KEY_INFO_TEXTO, msg);
                Intent intent = new Intent(ConsultaLivro.this, CarregaLivro.class);
                intent.putExtras(bundleInf);
                startActivity(intent);
            }
        });
    }
}