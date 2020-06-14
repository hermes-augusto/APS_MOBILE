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

public class CadastroEmprestimo extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastro_emprestimo);
        Button botao = (Button) findViewById(R.id.bCadastrar);
        botao.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                BancoController crud = new BancoController(getBaseContext());
                EditText cliente = (EditText) findViewById(R.id.etCliente);
                EditText livro = (EditText) findViewById((R.id.etLivro));
                EditText categoriaLivro = (EditText) findViewById(R.id.etCategoriaLivro);
                EditText dataInicial = (EditText) findViewById(R.id.etDataInicial);
                EditText dataFinal = (EditText) findViewById(R.id.etDataFinal);
                EditText status = (EditText) findViewById((R.id.etStatus));
                String clienteString = cliente.getText().toString();
                String livroString = livro.getText().toString();
                String categoriaLivroString = categoriaLivro.getText().toString();
                String dataInicialString = dataInicial.getText().toString();
                String dataFinalString = dataFinal.getText().toString();
                int statusInt = Integer.parseInt(status.getText().toString());
                String resultado;
                resultado = crud.insereEmprestimo(clienteString, livroString,
                        categoriaLivroString, dataInicialString,
                        dataFinalString, statusInt);
                Toast.makeText(getApplicationContext(), resultado, Toast.LENGTH_LONG).show();
            }
        });
    }
}