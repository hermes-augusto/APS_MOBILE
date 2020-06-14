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

public class CadastroCategoriaLivro extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastro_categoria_livro);
        Button botao = (Button) findViewById(R.id.bCadastrar);
        botao.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                BancoController crud = new BancoController(getBaseContext());
                EditText descricao = (EditText) findViewById(R.id.etDescricao);
                EditText numeroMaximoDia = (EditText) findViewById((R.id.etNumeroMaximoDia));
                EditText taxaMultaAtrasoDevolucao = (EditText) findViewById(R.id.etTaxaMultaAtrasoDevolucao);
                String descricaoString = descricao.getText().toString();
                int numeroMaximoDiaInt = Integer.parseInt(numeroMaximoDia.getText().toString());
                double taxaMultaAtrasoDevolucaoDouble = Double.parseDouble(taxaMultaAtrasoDevolucao.getText().toString());
                String resultado;
                resultado = crud.insereCategoriaLivro(descricaoString, numeroMaximoDiaInt, taxaMultaAtrasoDevolucaoDouble);
                Toast.makeText(getApplicationContext(), resultado, Toast.LENGTH_LONG).show();
            }
        });
    }
}