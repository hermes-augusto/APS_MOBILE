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

public class TelaCadastrar extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela_cadastrar);
        Button cliente = (Button) findViewById(R.id.bCliente);
        Button categoriaLeitor = (Button) findViewById(R.id.bCategoriaLeitor);
        Button categoriaLivro = (Button) findViewById(R.id.bCategoriaLivro);
        Button livro = (Button) findViewById(R.id.bLivro);
        Button emprestimo = (Button) findViewById(R.id.bEmprestimo);
        cliente.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(TelaCadastrar.this, CadastroCliente.class);
                startActivity(intent);
            }
        });
        categoriaLeitor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(TelaCadastrar.this, CadastroCategoriaLeitor.class);
                startActivity(intent);
            }
        });
        categoriaLivro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(TelaCadastrar.this, CadastroCategoriaLivro.class);
                startActivity(intent);
            }
        });
        livro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(TelaCadastrar.this, CadastroLivro.class);
                startActivity(intent);
            }
        });
        emprestimo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(TelaCadastrar.this, CadastroEmprestimo.class);
                startActivity(intent);
            }
        });
    }
}