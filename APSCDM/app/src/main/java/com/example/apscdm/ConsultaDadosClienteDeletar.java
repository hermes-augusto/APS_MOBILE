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
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;

public class ConsultaDadosClienteDeletar extends AppCompatActivity {
    ListView lista;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_consulta_dados_cliente_deletar);
        BancoController crud = new BancoController(getBaseContext());
        final Cursor cursor = crud.carregaDadosCliente();
        String[] nomeCampos = new String[]{CriaBanco.getClienteCodigo(), CriaBanco.getClienteUsuario()};
        int[] idViews = new int[]{R.id.tvCodigo, R.id.tvUsuario};
        SimpleCursorAdapter adaptador = new SimpleCursorAdapter(getBaseContext(),
                R.layout.activity_consulta_dados_cliente_deletar, cursor, nomeCampos, idViews, 0);
        lista = (ListView) findViewById(R.id.lvCliente);
        lista.setAdapter(adaptador);
        lista.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String codigo;
                cursor.moveToPosition(position);
                codigo = cursor.getString(cursor.getColumnIndexOrThrow(CriaBanco.getClienteCodigo()));
                Intent intent = new Intent(ConsultaDadosClienteDeletar.this, DeletaCliente.class);
                intent.putExtra("Codigo", codigo);
                startActivity(intent);
                finish();
            }
        });
    }
}