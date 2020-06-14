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

public class TelaInicial extends AppCompatActivity {
    Button cadastrar;
    Button alterar;
    Button deletar;
    Button consultar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela_inicial);
        cadastrar = (Button) findViewById(R.id.bCadastrar);
        alterar = (Button) findViewById(R.id.bAlterar);
        deletar = (Button) findViewById(R.id.bDeletar);
        consultar = (Button) findViewById(R.id.bConsultar);
        cadastrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(TelaInicial.this, TelaCadastrar.class);
                startActivity(intent);
            }
        });
        alterar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(TelaInicial.this, TelaAlterar.class);
                startActivity(intent);
            }
        });
        deletar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(TelaInicial.this, TelaDeletar.class);
                startActivity(intent);
            }
        });
        consultar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(TelaInicial.this, TelaConsultar.class);
                startActivity(intent);
            }
        });
    }
}