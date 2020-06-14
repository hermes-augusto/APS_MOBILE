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

public class CadastroCliente extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastro_cliente);
        Button botao = (Button) findViewById(R.id.bCadastrar);
        botao.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                BancoController crud = new BancoController(getBaseContext());
                EditText nome = (EditText) findViewById(R.id.etNome);
                EditText usuario = (EditText) findViewById((R.id.etUsuario));
                EditText endereco = (EditText) findViewById(R.id.etEndereco);
                EditText celular = (EditText) findViewById(R.id.etCelular);
                EditText email = (EditText) findViewById((R.id.etEmail));
                EditText cpf = (EditText) findViewById(R.id.etCpf);
                EditText dataNascimento = (EditText) findViewById(R.id.etDataNascimento);
                EditText categoriaLeitor = (EditText) findViewById((R.id.etUsuario));
                EditText senha = (EditText) findViewById(R.id.etSenha);
                String nomeString = nome.getText().toString();
                String usuarioString = usuario.getText().toString();
                String enderecoString = endereco.getText().toString();
                String celularString = celular.getText().toString();
                String emailString = email.getText().toString();
                String cpfString = cpf.getText().toString();
                String dataNascimentoString = dataNascimento.getText().toString();
                String categoriaLeitorString = categoriaLeitor.getText().toString();
                String senhaString = senha.getText().toString();
                String resultado;
                resultado = crud.insereCliente(nomeString, usuarioString, enderecoString,
                        celularString, emailString, cpfString,
                        dataNascimentoString, categoriaLeitorString, senhaString);
                Toast.makeText(getApplicationContext(), resultado, Toast.LENGTH_LONG).show();
            }
        });
    }
}