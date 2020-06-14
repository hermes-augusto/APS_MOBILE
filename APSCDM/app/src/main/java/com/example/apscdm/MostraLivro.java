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

public class MostraLivro extends AppCompatActivity {
    EditText isbn;
    EditText titulo;
    EditText categoriaLivro;
    EditText autor;
    EditText palavraChave;
    EditText dataPublicacao;
    EditText numeroEdicao;
    EditText editora;
    EditText numeroPagina;
    Cursor cursor;
    BancoController crud;
    String codigo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mostra_livro);
        codigo = this.getIntent().getStringExtra("Codigo");
        crud = new BancoController(getBaseContext());
        isbn = (EditText) findViewById(R.id.etIsbn);
        titulo = (EditText) findViewById(R.id.etTitulo);
        categoriaLivro = (EditText) findViewById(R.id.etCategoriaLivro);
        autor = (EditText) findViewById(R.id.etAutor);
        palavraChave = (EditText) findViewById(R.id.etPalavraChave);
        dataPublicacao = (EditText) findViewById(R.id.etDataPublicacao);
        numeroEdicao = (EditText) findViewById(R.id.etNumeroEdicao);
        editora = (EditText) findViewById(R.id.etEditora);
        numeroPagina = (EditText) findViewById(R.id.etNumeroPagina);
        cursor = crud.carregaDadosLivroByCodigo(Integer.parseInt(codigo));
        isbn.setText(cursor.getString(cursor.getColumnIndexOrThrow(CriaBanco.getLivroIsbn())));
        titulo.setText(cursor.getString(cursor.getColumnIndexOrThrow(CriaBanco.getLivroTitulo())));
        categoriaLivro.setText(cursor.getString(cursor.getColumnIndexOrThrow(CriaBanco.getLivroCategoriaLivro())));
        autor.setText(cursor.getString(cursor.getColumnIndexOrThrow(CriaBanco.getLivroAutor())));
        palavraChave.setText(cursor.getString(cursor.getColumnIndexOrThrow(CriaBanco.getLivroPalavrachave())));
        dataPublicacao.setText(cursor.getString(cursor.getColumnIndexOrThrow(CriaBanco.getLivroDataPublicacao())));
        numeroEdicao.setText(cursor.getString(cursor.getColumnIndexOrThrow(CriaBanco.getLivroNumeroEdicao())));
        editora.setText(cursor.getString(cursor.getColumnIndexOrThrow(CriaBanco.getLivroEditora())));
        numeroPagina.setText(cursor.getString(cursor.getColumnIndexOrThrow(CriaBanco.getLivroNumeroPagina())));
    }
}