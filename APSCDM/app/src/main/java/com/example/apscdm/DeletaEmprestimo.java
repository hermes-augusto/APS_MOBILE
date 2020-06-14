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

public class DeletaEmprestimo extends AppCompatActivity {
    EditText cliente;
    EditText livro;
    EditText categoriaLivro;
    EditText dataInicial;
    EditText dataFinal;
    EditText status;
    Cursor cursor;
    BancoController crud;
    String codigo;
    Button deletar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_deleta_emprestimo);
        codigo = this.getIntent().getStringExtra("Codigo");
        crud = new BancoController(getBaseContext());
        cliente = (EditText) findViewById(R.id.etCliente);
        livro = (EditText) findViewById(R.id.etLivro);
        categoriaLivro = (EditText) findViewById(R.id.etCategoriaLivro);
        dataInicial = (EditText) findViewById(R.id.etDataInicial);
        dataFinal = (EditText) findViewById(R.id.etDataFinal);
        status = (EditText) findViewById(R.id.etStatus);
        deletar = (Button) findViewById(R.id.bDeletar);
        cursor = crud.carregaEmprestimoByCodigo(Integer.parseInt(codigo));
        cliente.setText(cursor.getString(cursor.getColumnIndexOrThrow(CriaBanco.getEmprestimoCliente())));
        livro.setText(cursor.getString(cursor.getColumnIndexOrThrow(CriaBanco.getEmprestimoLivro())));
        categoriaLivro.setText(cursor.getString(cursor.getColumnIndexOrThrow(CriaBanco.getEmprestimoCategoriaLivro())));
        dataInicial.setText(cursor.getString(cursor.getColumnIndexOrThrow(CriaBanco.getEmprestimoDataInicial())));
        dataFinal.setText(cursor.getString(cursor.getColumnIndexOrThrow(CriaBanco.getEmprestimoDataFinal())));
        status.setText(cursor.getString(cursor.getColumnIndexOrThrow(CriaBanco.getEmprestimoStatus())));
        deletar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                crud.deletaRegistroEmprestimo(Integer.parseInt(codigo));
                Intent intent = new Intent(DeletaEmprestimo.this, ConsultaDadosEmprestimoDeletar.class);
                startActivity(intent);
                finish();
            }
        });
    }
}