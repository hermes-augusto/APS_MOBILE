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

public class AlteraLivro extends AppCompatActivity {
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
    Button alterar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_altera_livro);
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
        alterar = (Button) findViewById(R.id.bAlterar);
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
        alterar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                crud.alteraRegistroLivro(Integer.parseInt(codigo), Integer.parseInt(isbn.getText().toString()),
                        titulo.getText().toString(), categoriaLivro.getText().toString(),
                        autor.getText().toString(), palavraChave.getText().toString(),
                        dataPublicacao.getText().toString(), Integer.parseInt(numeroEdicao.getText().toString()),
                        editora.getText().toString(), Integer.parseInt(numeroPagina.getText().toString()));
                Intent intent = new Intent(AlteraLivro.this, ConsultaDadosLivroAlterar.class);
                startActivity(intent);
                finish();
            }
        });
    }
}