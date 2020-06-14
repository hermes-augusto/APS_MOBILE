/*
    Erik Kaue Paroline Jose dos Santos - RA: 20960545
    Fernanda Pereira Umberto - RA: 20943426
    Guilherme Rodrigues de Miranda - RA: 20996393
    Matheus Marques de Souza - RA: 20981531
    Milena Basso - RA: 20956610
 */
package com.example.apscdm;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

public class DeletaCategoriaLeitor extends AppCompatActivity {
    EditText descricao;
    EditText numeroMaximoDia;
    Cursor cursor;
    BancoController crud;
    String codigo;
    Button deletar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_deleta_categoria_leitor);
        codigo = this.getIntent().getStringExtra("Codigo");
        crud = new BancoController(getBaseContext());
        descricao = (EditText) findViewById(R.id.etDescricao);
        numeroMaximoDia = (EditText) findViewById(R.id.etNumeroMaximoDia);
        deletar = (Button) findViewById(R.id.bDeletar);
        cursor = crud.carregaDadosCategoriaLeitorByCodigo(Integer.parseInt(codigo));
        descricao.setText(cursor.getString(cursor.getColumnIndexOrThrow(CriaBanco.getCategoriaLeitorDescricao())));
        numeroMaximoDia.setText(cursor.getString(cursor.getColumnIndexOrThrow(CriaBanco.getCategoriaLeitorNumeroMaximoDia())));
        deletar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                crud.deletaRegistroCategoriaLeitor(Integer.parseInt(codigo));
                Intent intent = new Intent(DeletaCategoriaLeitor.this, ConsultaDadosCategoriaLeitorDeletar.class);
                startActivity(intent);
                finish();
            }
        });
    }
}