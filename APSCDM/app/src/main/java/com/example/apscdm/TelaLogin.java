/*
    Erik Kaue Paroline Jose dos Santos - RA: 20960545
    Fernanda Pereira Umberto - RA: 20943426
    Guilherme Rodrigues de Miranda - RA: 20996393
    Matheus Marques de Souza - RA: 20981531
    Milena Basso - RA: 20956610
 */
package com.example.apscdm;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class TelaLogin extends AppCompatActivity {
    EditText usuario;
    EditText senha;
    BancoController crud;
    Button login;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela_login);
        crud = new BancoController(getBaseContext());
        usuario = (EditText) findViewById(R.id.etUsuario);
        senha = (EditText) findViewById(R.id.etSenha);
        login = (Button) findViewById(R.id.bLogin);
        final Context contexto = getApplicationContext();
        final String texto = "Senha incorreta.";
        final int duracao = Toast.LENGTH_LONG;
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                boolean usuarioAndSenha = crud.carregaClienteByUsuarioAndSenha(usuario.getText().toString(), senha.getText().toString());
                Intent intent;
                if (usuarioAndSenha == true) {
                    //Retirar CadastroCliente.class e colocar botões nas outras classes.
                    intent = new Intent(TelaLogin.this, TelaInicial.class);
                    startActivity(intent);
                    finish();
                } else {
                    boolean user = crud.carregaClienteByUsuario(usuario.getText().toString());
                    if (user == true) {
                        Toast toast = Toast.makeText(contexto, texto, duracao);
                        toast.show();
                    } else {
                        intent = new Intent(TelaLogin.this, CadastroCliente.class);
                        startActivity(intent);
                    }
                }
            }
        });
    }
}