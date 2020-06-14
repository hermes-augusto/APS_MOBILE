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

public class CarregaLivro extends AppCompatActivity {
    private ListView lista;
    private String txt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Intent intentRecebida = getIntent();
        Bundle bundle = intentRecebida.getExtras();
        txt = bundle.getString(ConsultaLivro.KEY_INFO_TEXTO).toString();
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_carrega_livro);
        BancoController crud = new BancoController(getBaseContext());
        final Cursor cursor = crud.carregaLivroByTituloAutorEditora(txt);
        String[] nomeCampos = new String[]{CriaBanco.getLivroTitulo(), CriaBanco.getLivroAutor(), CriaBanco.getLivroEditora()};
        int[] idViews = new int[]{R.id.livroTitulo, R.id.livroAutor, R.id.livroEditora};
        SimpleCursorAdapter adaptador = new SimpleCursorAdapter(getBaseContext(),
                R.layout.activity_carrega_livro, cursor, nomeCampos, idViews, 0);
        lista = (ListView) findViewById(R.id.listView);
        lista.setAdapter(adaptador);
        lista.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String codigo;
                cursor.moveToPosition(position);
                codigo = cursor.getString(cursor.getColumnIndexOrThrow(CriaBanco.getLivroCodigo()));
                Intent intent = new Intent(CarregaLivro.this, MostraLivro.class);
                intent.putExtra("Codigo", codigo);
                startActivity(intent);
                finish();
            }
        });
    }
}