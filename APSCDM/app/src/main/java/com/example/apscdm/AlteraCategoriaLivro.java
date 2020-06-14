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
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class AlteraCategoriaLivro extends AppCompatActivity {
    EditText descricao;
    EditText numeroMaximoDia;
    EditText taxaMultaAtrasoDevolucao;
    Cursor cursor;
    BancoController crud;
    String codigo;
    Button alterar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_altera_categoria_livro);
        codigo = this.getIntent().getStringExtra("Codigo");
        crud = new BancoController(getBaseContext());
        descricao = (EditText) findViewById(R.id.etDescricao);
        taxaMultaAtrasoDevolucao = (EditText) findViewById(R.id.etTaxaMultaAtrasoDevolucao);
        numeroMaximoDia = (EditText) findViewById(R.id.etNumeroMaximoDia);
        alterar = (Button) findViewById(R.id.bAlterar);
        cursor = crud.carregaDadosCategoriaLivroByCodigo(Integer.parseInt(codigo));
        descricao.setText(cursor.getString(cursor.getColumnIndexOrThrow(CriaBanco.getCategoriaLivroDescricao())));
        numeroMaximoDia.setText(cursor.getString(cursor.getColumnIndexOrThrow(CriaBanco.getCategoriaLivroNumeroMaximoDia())));
        taxaMultaAtrasoDevolucao.setText(cursor.getString(cursor.getColumnIndexOrThrow(CriaBanco.getCategoriaLivroTaxaMultaAtrasoDevolucao())));
        alterar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                crud.alteraRegistroCategoriaLivro(Integer.parseInt(codigo), descricao.getText().toString(),
                        Integer.parseInt(numeroMaximoDia.getText().toString()), Double.parseDouble(taxaMultaAtrasoDevolucao.getText().toString()));
                Intent intent = new Intent(AlteraCategoriaLivro.this, ConsultaDadosCategoriaLivroAlterar.class);
                startActivity(intent);
                finish();
            }
        });
    }
}