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

public class ConsultaDadosEmprestimoDeletar extends AppCompatActivity {
    ListView lista;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_consulta_dados_emprestimo_deletar);
        BancoController crud = new BancoController(getBaseContext());
        final Cursor cursor = crud.carregaDadosEmprestimo();
        String[] nomeCampos = new String[]{CriaBanco.getEmprestimoCodigo(), CriaBanco.getEmprestimoStatus()};
        int[] idViews = new int[]{R.id.tvCodigo, R.id.tvStatus};
        SimpleCursorAdapter adaptador = new SimpleCursorAdapter(getBaseContext(),
                R.layout.activity_consulta_dados_emprestimo_deletar, cursor, nomeCampos, idViews, 0);
        lista = (ListView) findViewById(R.id.lvEmprestimo);
        lista.setAdapter(adaptador);
        lista.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String codigo;
                cursor.moveToPosition(position);
                codigo = cursor.getString(cursor.getColumnIndexOrThrow(CriaBanco.getEmprestimoCodigo()));
                Intent intent = new Intent(ConsultaDadosEmprestimoDeletar.this, DeletaEmprestimo.class);
                intent.putExtra("Codigo", codigo);
                startActivity(intent);
                finish();
            }
        });
    }
}