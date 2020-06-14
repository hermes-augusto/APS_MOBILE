/*
    Erik Kaue Paroline Jose dos Santos - RA: 20960545
    Fernanda Pereira Umberto - RA: 20943426
    Guilherme Rodrigues de Miranda - RA: 20996393
    Matheus Marques de Souza - RA: 20981531
    Milena Basso - RA: 20956610
 */
package com.example.apscdm;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class CadastroLivro extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastro_livro);
        Button botao = (Button) findViewById(R.id.bCadastrar);
        botao.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                BancoController crud = new BancoController(getBaseContext());
                EditText isbn = (EditText) findViewById(R.id.etIsbn);
                EditText titulo = (EditText) findViewById(R.id.etTitulo);
                EditText categoriaLivro = (EditText) findViewById(R.id.etCategoriaLivro);
                EditText autor = (EditText) findViewById(R.id.etAutor);
                EditText palavraChave = (EditText) findViewById((R.id.etPalavraChave));
                EditText dataPublicacao = (EditText) findViewById(R.id.etDataPublicacao);
                EditText numeroEdicao = (EditText) findViewById(R.id.etNumeroEdicao);
                EditText editora = (EditText) findViewById(R.id.etEditora);
                EditText numeroPaginas = (EditText) findViewById(R.id.etNumeroPagina);
                int isbnInt = Integer.parseInt(isbn.getText().toString());
                String tituloString = titulo.getText().toString();
                String categoriaLivroString = categoriaLivro.getText().toString();
                String autorString = autor.getText().toString();
                String palavraChaveString = palavraChave.getText().toString();
                String dataPublicacaoString = dataPublicacao.getText().toString();
                int numeroEdicaoInt = Integer.parseInt(numeroEdicao.getText().toString());
                String editoraString = editora.getText().toString();
                int numeroPaginasString = Integer.parseInt(numeroPaginas.getText().toString());
                String resultado;
                resultado = crud.insereLivro(isbnInt, tituloString, categoriaLivroString,
                        autorString, palavraChaveString, dataPublicacaoString,
                        numeroEdicaoInt, editoraString, numeroPaginasString);
                Toast.makeText(getApplicationContext(), resultado, Toast.LENGTH_LONG).show();
            }
        });
    }
}