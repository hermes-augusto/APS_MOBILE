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

public class TelaConsultar extends AppCompatActivity {
    Button livro;
    Button emprestimo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela_consultar);
        livro = (Button) findViewById(R.id.bLivro);
        emprestimo = (Button) findViewById(R.id.bEmprestimo);
        livro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(TelaConsultar.this, ConsultaLivro.class);
                startActivity(intent);
            }
        });
        emprestimo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(TelaConsultar.this, CarregaEmprestimo.class);
                startActivity(intent);
            }
        });
    }
}