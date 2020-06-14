/*
    Erik Kaue Paroline Jose dos Santos - RA: 20960545
    Fernanda Pereira Umberto - RA: 20943426
    Guilherme Rodrigues de Miranda - RA: 20996393
    Matheus Marques de Souza - RA: 20981531
    Milena Basso - RA: 20956610
 */
package com.example.apscdm;

import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.os.Bundle;
import android.widget.EditText;

public class MostraEmprestimo extends AppCompatActivity {
    EditText cliente;
    EditText livro;
    EditText categoriaLivro;
    EditText dataInicial;
    EditText dataFinal;
    EditText status;
    Cursor cursor;
    BancoController crud;
    String codigo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mostra_emprestimo);
        codigo = this.getIntent().getStringExtra("Codigo");
        crud = new BancoController(getBaseContext());
        cliente = (EditText) findViewById(R.id.etCliente);
        livro = (EditText) findViewById(R.id.etLivro);
        categoriaLivro = (EditText) findViewById(R.id.etCategoriaLivro);
        dataInicial = (EditText) findViewById(R.id.etDataInicial);
        dataFinal = (EditText) findViewById(R.id.etDataFinal);
        status = (EditText) findViewById(R.id.etStatus);
        cursor = crud.carregaEmprestimoByCodigo(Integer.parseInt(codigo));
        cliente.setText(cursor.getString(cursor.getColumnIndexOrThrow(CriaBanco.getEmprestimoCliente())));
        livro.setText(cursor.getString(cursor.getColumnIndexOrThrow(CriaBanco.getEmprestimoLivro())));
        categoriaLivro.setText(cursor.getString(cursor.getColumnIndexOrThrow(CriaBanco.getEmprestimoCategoriaLivro())));
        dataInicial.setText(cursor.getString(cursor.getColumnIndexOrThrow(CriaBanco.getEmprestimoDataInicial())));
        dataFinal.setText(cursor.getString(cursor.getColumnIndexOrThrow(CriaBanco.getEmprestimoDataFinal())));
        status.setText(cursor.getString(cursor.getColumnIndexOrThrow(CriaBanco.getEmprestimoStatus())));
    }
}