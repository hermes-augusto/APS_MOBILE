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

public class DeletaCliente extends AppCompatActivity {
    EditText nome;
    EditText usuario;
    EditText endereco;
    EditText celular;
    EditText email;
    EditText cpf;
    EditText dataNascimento;
    EditText categoriaLeitor;
    EditText senha;
    Cursor cursor;
    BancoController crud;
    String codigo;
    Button deletar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_deleta_cliente);
        codigo = this.getIntent().getStringExtra("Codigo");
        crud = new BancoController(getBaseContext());
        nome = (EditText) findViewById(R.id.etNome);
        usuario = (EditText) findViewById(R.id.etUsuario);
        endereco = (EditText) findViewById(R.id.etEndereco);
        celular = (EditText) findViewById(R.id.etCelular);
        email = (EditText) findViewById(R.id.etEmail);
        cpf = (EditText) findViewById(R.id.etCpf);
        dataNascimento = (EditText) findViewById(R.id.etDataNascimento);
        categoriaLeitor = (EditText) findViewById(R.id.etCategoriaLeitor);
        senha = (EditText) findViewById(R.id.etSenha);
        deletar = (Button) findViewById(R.id.bDeletar);
        cursor = crud.carregaDadosClienteByCodigo(Integer.parseInt(codigo));
        nome.setText(cursor.getString(cursor.getColumnIndexOrThrow(CriaBanco.getClienteNome())));
        usuario.setText(cursor.getString(cursor.getColumnIndexOrThrow(CriaBanco.getClienteUsuario())));
        endereco.setText(cursor.getString(cursor.getColumnIndexOrThrow(CriaBanco.getClienteEndereco())));
        celular.setText(cursor.getString(cursor.getColumnIndexOrThrow(CriaBanco.getClienteCelular())));
        email.setText(cursor.getString(cursor.getColumnIndexOrThrow(CriaBanco.getClienteEmail())));
        cpf.setText(cursor.getString(cursor.getColumnIndexOrThrow(CriaBanco.getClienteCpf())));
        dataNascimento.setText(cursor.getString(cursor.getColumnIndexOrThrow(CriaBanco.getClienteDataNascimento())));
        categoriaLeitor.setText(cursor.getString(cursor.getColumnIndexOrThrow(CriaBanco.getClienteCategoriaLeitor())));
        senha.setText(cursor.getString(cursor.getColumnIndexOrThrow(CriaBanco.getClienteSenha())));
        deletar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                crud.deletaRegistroCliente(Integer.parseInt(codigo));
                Intent intent = new Intent(DeletaCliente.this, ConsultaDadosClienteDeletar.class);
                startActivity(intent);
                finish();
            }
        });
    }
}