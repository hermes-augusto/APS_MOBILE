/*
    Erik Kaue Paroline Jose dos Santos - RA: 20960545
    Fernanda Pereira Umberto - RA: 20943426
    Guilherme Rodrigues de Miranda - RA: 20996393
    Matheus Marques de Souza - RA: 20981531
    Milena Basso - RA: 20956610
 */
package com.example.apscdm;

import android.content.ContentValues;
import android.database.Cursor;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

public class BancoController {
    private SQLiteDatabase db;
    private CriaBanco banco;

    public BancoController(Context context) {
        banco = new CriaBanco(context);
    }

    public String insereCategoriaLeitor(String descricao, int numeroMaximoDia) {
        ContentValues valores;
        long resultado;
        db = banco.getWritableDatabase();
        valores = new ContentValues();
        valores.put(CriaBanco.getCategoriaLeitorDescricao(), descricao);
        valores.put(CriaBanco.getCategoriaLeitorNumeroMaximoDia(), numeroMaximoDia);
        resultado = db.insert(CriaBanco.getCategoriaLeitor(), null, valores);
        db.close();
        if (resultado == -1)
            return "Erro ao inserir registro!";
        else
            return "Registro inserido com sucesso!";
    }

    public String insereCliente(String nome, String usuario,
                                String endereco, String celular,
                                String email, String cpf,
                                String dataNascimento, String categoriaLeitor,
                                String senha) {
        ContentValues valores;
        long resultado;
        db = banco.getWritableDatabase();
        valores = new ContentValues();
        valores.put(CriaBanco.getClienteNome(), nome);
        valores.put(CriaBanco.getClienteUsuario(), usuario);
        valores.put(CriaBanco.getClienteEndereco(), endereco);
        valores.put(CriaBanco.getClienteCelular(), celular);
        valores.put(CriaBanco.getClienteEmail(), email);
        valores.put(CriaBanco.getClienteCpf(), cpf);
        valores.put(CriaBanco.getClienteDataNascimento(), dataNascimento);
        valores.put(CriaBanco.getClienteCategoriaLeitor(), categoriaLeitor);
        valores.put(CriaBanco.getClienteSenha(), senha);
        resultado = db.insert(CriaBanco.getCLIENTE(), null, valores);
        db.close();
        if (resultado == -1)
            return "Erro ao inserir registro!";
        else
            return "Registro inserido com sucesso!";
    }

    public String insereCategoriaLivro(String descricao, int numeroMaximoDia,
                                       double taxaMultaAtrasoDevolucao) {
        ContentValues valores;
        long resultado;
        db = banco.getWritableDatabase();
        valores = new ContentValues();
        valores.put(CriaBanco.getCategoriaLivroDescricao(), descricao);
        valores.put(CriaBanco.getCategoriaLivroNumeroMaximoDia(), numeroMaximoDia);
        valores.put(CriaBanco.getCategoriaLivroTaxaMultaAtrasoDevolucao(), taxaMultaAtrasoDevolucao);
        resultado = db.insert(CriaBanco.getCategoriaLivro(), null, valores);
        db.close();
        if (resultado == -1)
            return "Erro ao inserir registro!";
        else
            return "Registro inserido com sucesso!";
    }

    public String insereLivro(int isbn, String titulo,
                              String categoriaLivro, String autor,
                              String palavraChave, String dataPublicacao,
                              int numeroEdicao, String editora,
                              int numeroPagina) {
        ContentValues valores;
        long resultado;
        db = banco.getWritableDatabase();
        valores = new ContentValues();
        valores.put(CriaBanco.getLivroIsbn(), isbn);
        valores.put(CriaBanco.getLivroTitulo(), titulo);
        valores.put(CriaBanco.getLivroCategoriaLivro(), categoriaLivro);
        valores.put(CriaBanco.getLivroAutor(), autor);
        valores.put(CriaBanco.getLivroPalavrachave(), palavraChave);
        valores.put(CriaBanco.getLivroDataPublicacao(), dataPublicacao);
        valores.put(CriaBanco.getLivroNumeroEdicao(), numeroEdicao);
        valores.put(CriaBanco.getLivroEditora(), editora);
        valores.put(CriaBanco.getLivroNumeroPagina(), numeroPagina);
        resultado = db.insert(CriaBanco.getLIVRO(), null, valores);
        db.close();
        if (resultado == -1)
            return "Erro ao inserir registro!";
        else
            return "Registro inserido com sucesso!";
    }

    public String insereEmprestimo(String cliente, String livro,
                                   String categoriaLivro, String dataInicial,
                                   String dataFinal, int status) {
        ContentValues valores;
        long resultado;
        db = banco.getWritableDatabase();
        valores = new ContentValues();
        valores.put(CriaBanco.getEmprestimoCliente(), cliente);
        valores.put(CriaBanco.getEmprestimoLivro(), livro);
        valores.put(CriaBanco.getEmprestimoCategoriaLivro(), categoriaLivro);
        valores.put(CriaBanco.getEmprestimoDataInicial(), dataInicial);
        valores.put(CriaBanco.getEmprestimoDataFinal(), dataFinal);
        valores.put(CriaBanco.getEmprestimoStatus(), status);
        resultado = db.insert(CriaBanco.getEMPRESTIMO(), null, valores);
        db.close();
        if (resultado == -1)
            return "Erro ao inserir registro!";
        else
            return "Registro inserido com sucesso!";
    }

    public Cursor carregaDadosCategoriaLeitor() {
        Cursor cursor;
        String[] campos = {CriaBanco.getCategoriaLeitorCodigo(), CriaBanco.getCategoriaLeitorDescricao(),
                CriaBanco.getCategoriaLeitorNumeroMaximoDia()};
        db = banco.getReadableDatabase();
        cursor = db.query(CriaBanco.getCategoriaLeitor(), campos, null, null, null, null, null, null);
        if (cursor != null) {
            cursor.moveToFirst();
        }
        db.close();
        return cursor;
    }

    public Cursor carregaDadosCliente() {
        Cursor cursor;
        String[] campos = {CriaBanco.getClienteCodigo(), CriaBanco.getClienteNome(),
                CriaBanco.getClienteUsuario(), CriaBanco.getClienteEndereco(),
                CriaBanco.getClienteCelular(), CriaBanco.getClienteEmail(),
                CriaBanco.getClienteCpf(), CriaBanco.getClienteDataNascimento(),
                CriaBanco.getClienteCategoriaLeitor(), CriaBanco.getClienteSenha()};
        db = banco.getReadableDatabase();
        cursor = db.query(CriaBanco.getCLIENTE(), campos, null, null, null, null, null, null);
        if (cursor != null) {
            cursor.moveToFirst();
        }
        db.close();
        return cursor;
    }

    public Cursor carregaDadosCategoriaLivro() {
        Cursor cursor;
        String[] campos = {CriaBanco.getCategoriaLivroCodigo(), CriaBanco.getCategoriaLivroDescricao(),
                CriaBanco.getCategoriaLivroNumeroMaximoDia(), CriaBanco.getCategoriaLivroTaxaMultaAtrasoDevolucao()};
        db = banco.getReadableDatabase();
        cursor = db.query(CriaBanco.getCategoriaLivro(), campos, null, null, null, null, null, null);
        if (cursor != null) {
            cursor.moveToFirst();
        }
        db.close();
        return cursor;
    }

    public Cursor carregaDadosLivro() {
        Cursor cursor;
        String[] campos = {CriaBanco.getLivroCodigo(), CriaBanco.getLivroIsbn(),
                CriaBanco.getLivroTitulo(), CriaBanco.getLivroCategoriaLivro(),
                CriaBanco.getLivroAutor(), CriaBanco.getLivroPalavrachave(),
                CriaBanco.getLivroDataPublicacao(), CriaBanco.getLivroNumeroEdicao(),
                CriaBanco.getLivroEditora(), CriaBanco.getLivroNumeroPagina()};
        db = banco.getReadableDatabase();
        cursor = db.query(CriaBanco.getLIVRO(), campos, null, null, null, null, null, null);
        if (cursor != null) {
            cursor.moveToFirst();
        }
        db.close();
        return cursor;
    }

    public Cursor carregaDadosEmprestimo() {
        Cursor cursor;
        String[] campos = {CriaBanco.getEmprestimoCodigo(), CriaBanco.getEmprestimoCliente(),
                CriaBanco.getEmprestimoLivro(), CriaBanco.getEmprestimoCategoriaLivro(),
                CriaBanco.getEmprestimoDataInicial(), CriaBanco.getEmprestimoDataFinal(),
                CriaBanco.getEmprestimoStatus()};
        db = banco.getReadableDatabase();
        cursor = db.query(CriaBanco.getEMPRESTIMO(), campos, null, null, null, null, null, null);
        if (cursor != null) {
            cursor.moveToFirst();
        }
        db.close();
        return cursor;
    }

    public void alteraRegistroCategoriaLeitor(int codigo, String descricao,
                                              int numeroMaximoDia) {
        ContentValues valores;
        String where;
        db = banco.getWritableDatabase();
        where = CriaBanco.getCategoriaLeitorCodigo() + "=" + codigo;
        valores = new ContentValues();
        valores.put(CriaBanco.getCategoriaLeitorDescricao(), descricao);
        valores.put(CriaBanco.getCategoriaLeitorNumeroMaximoDia(), numeroMaximoDia);
        db.update(CriaBanco.getCategoriaLeitor(), valores, where, null);
        db.close();
    }

    public void alteraRegistroCliente(int codigo, String nome,
                                      String usuario, String endereco,
                                      String celular, String email,
                                      String cpf, String dataNascimento,
                                      String categoriaLeitor, String senha) {
        ContentValues valores;
        String where;
        db = banco.getWritableDatabase();
        where = CriaBanco.getClienteCodigo() + "=" + codigo;
        valores = new ContentValues();
        valores.put(CriaBanco.getClienteNome(), nome);
        valores.put(CriaBanco.getClienteUsuario(), usuario);
        valores.put(CriaBanco.getClienteEndereco(), endereco);
        valores.put(CriaBanco.getClienteCelular(), celular);
        valores.put(CriaBanco.getClienteEmail(), email);
        valores.put(CriaBanco.getClienteCpf(), cpf);
        valores.put(CriaBanco.getClienteDataNascimento(), dataNascimento);
        valores.put(CriaBanco.getClienteCategoriaLeitor(), categoriaLeitor);
        valores.put(CriaBanco.getClienteSenha(), senha);
        db.update(CriaBanco.getCLIENTE(), valores, where, null);
        db.close();
    }

    public void alteraRegistroEmprestimo(int codigo, String cliente,
                                         String livro, String categoriaLivro,
                                         String dataInicial, String dataFinal,
                                         int status) {
        ContentValues valores;
        String where;
        db = banco.getWritableDatabase();
        where = CriaBanco.getEmprestimoCodigo() + "=" + codigo;
        valores = new ContentValues();
        valores.put(CriaBanco.getEmprestimoCliente(), cliente);
        valores.put(CriaBanco.getEmprestimoLivro(), livro);
        valores.put(CriaBanco.getEmprestimoCategoriaLivro(), categoriaLivro);
        valores.put(CriaBanco.getEmprestimoDataInicial(), dataInicial);
        valores.put(CriaBanco.getEmprestimoDataFinal(), dataFinal);
        valores.put(CriaBanco.getEmprestimoStatus(), status);
        db.update(CriaBanco.getEMPRESTIMO(), valores, where, null);
        db.close();
    }

    public void alteraRegistroCategoriaLivro(int codigo, String descricao,
                                             int numeroMaximoDia, double taxaMultaAtrasoDevolucao) {
        ContentValues valores;
        String where;
        db = banco.getWritableDatabase();
        where = CriaBanco.getCategoriaLivroCodigo() + "=" + codigo;
        valores = new ContentValues();
        valores.put(CriaBanco.getCategoriaLivroDescricao(), descricao);
        valores.put(CriaBanco.getCategoriaLivroNumeroMaximoDia(), numeroMaximoDia);
        valores.put(CriaBanco.getCategoriaLivroTaxaMultaAtrasoDevolucao(), taxaMultaAtrasoDevolucao);
        db.update(CriaBanco.getCategoriaLivro(), valores, where, null);
        db.close();
    }

    public void alteraRegistroLivro(int codigo, int isbn,
                                    String titulo, String categoriaLivro,
                                    String autor, String palavraChave,
                                    String dataPublicacao, int numeroEdicao,
                                    String editora, int numeroPagina) {
        ContentValues valores;
        String where;
        db = banco.getWritableDatabase();
        where = CriaBanco.getLivroCodigo() + "=" + codigo;
        valores = new ContentValues();
        valores.put(CriaBanco.getLivroIsbn(), isbn);
        valores.put(CriaBanco.getLivroTitulo(), titulo);
        valores.put(CriaBanco.getLivroCategoriaLivro(), categoriaLivro);
        valores.put(CriaBanco.getLivroAutor(), autor);
        valores.put(CriaBanco.getLivroPalavrachave(), palavraChave);
        valores.put(CriaBanco.getLivroDataPublicacao(), dataPublicacao);
        valores.put(CriaBanco.getLivroNumeroEdicao(), numeroEdicao);
        valores.put(CriaBanco.getLivroEditora(), editora);
        valores.put(CriaBanco.getLivroNumeroPagina(), numeroPagina);
        db.update(CriaBanco.getLIVRO(), valores, where, null);
        db.close();
    }

    public void deletaRegistroCategoriaLeitor(int codigo) {
        String where = CriaBanco.getCategoriaLeitorCodigo() + "=" + codigo;
        db = banco.getReadableDatabase();
        db.delete(CriaBanco.getCategoriaLeitor(), where, null);
        db.close();
    }

    public void deletaRegistroCliente(int codigo) {
        String where = CriaBanco.getClienteCodigo() + "=" + codigo;
        db = banco.getReadableDatabase();
        db.delete(CriaBanco.getCLIENTE(), where, null);
        db.close();
    }

    public void deletaRegistroCategoriaLivro(int codigo) {
        String where = CriaBanco.getCategoriaLivroCodigo() + "=" + codigo;
        db = banco.getReadableDatabase();
        db.delete(CriaBanco.getCategoriaLivro(), where, null);
        db.close();
    }

    public void deletaRegistroLivro(int codigo) {
        String where = CriaBanco.getLivroCodigo() + "=" + codigo;
        db = banco.getReadableDatabase();
        db.delete(CriaBanco.getLIVRO(), where, null);
        db.close();
    }

    public void deletaRegistroEmprestimo(int codigo) {
        String where = CriaBanco.getEmprestimoCodigo() + "=" + codigo;
        db = banco.getReadableDatabase();
        db.delete(CriaBanco.getEMPRESTIMO(), where, null);
        db.close();
    }

    public Cursor carregaLivroByTituloAutorEditora(String string) {
        Cursor cursor;
        String[] campos = {CriaBanco.getLivroCodigo(), CriaBanco.getLivroIsbn(),
                CriaBanco.getLivroTitulo(), CriaBanco.getLivroCategoriaLivro(),
                CriaBanco.getLivroAutor(), CriaBanco.getLivroPalavrachave(),
                CriaBanco.getLivroDataPublicacao(), CriaBanco.getLivroNumeroEdicao(),
                CriaBanco.getLivroEditora(), CriaBanco.getLivroNumeroPagina()};
        String where = CriaBanco.getLivroTitulo() + "='" + string + "' OR "
                + CriaBanco.getLivroAutor() + "='" + string
                + "' OR " + CriaBanco.getLivroEditora() + "='"
                + string + "'";
        db = banco.getReadableDatabase();
        cursor = db.query(CriaBanco.getLIVRO(), campos, where, null, null, null, null, null);
        if (cursor != null) {
            cursor.moveToFirst();
        }
        db.close();
        return cursor;
    }

    public Cursor carregaEmprestimo() {
        Cursor cursor;
        String[] campos = {CriaBanco.getEmprestimoCodigo(), CriaBanco.getEmprestimoLivro(),
                CriaBanco.getEmprestimoCategoriaLivro(), CriaBanco.getEmprestimoCliente(),
                CriaBanco.getEmprestimoDataInicial(), CriaBanco.getEmprestimoDataFinal()};
        db = banco.getReadableDatabase();
        cursor = db.query(CriaBanco.getEMPRESTIMO(), campos, null, null, CriaBanco.getEmprestimoCategoriaLivro(), null, null, null);
        if (cursor != null) {
            cursor.moveToFirst();
        }
        db.close();
        return cursor;
    }

    public boolean carregaClienteByUsuario(String usuario) {
        boolean bool = false;
        Cursor cursor;
        String[] campos = {CriaBanco.getClienteUsuario()};
        String where = CriaBanco.getClienteUsuario() + "='" + usuario + "'";
        db = banco.getReadableDatabase();
        cursor = db.query(CriaBanco.getCLIENTE(), campos, where, null, null, null, null, null);
        if (cursor != null) {
            boolean result = cursor.moveToFirst();
            if (result == true) {
                bool = true;
            }
        }
        db.close();
        return bool;
    }

    public boolean carregaClienteByUsuarioAndSenha(String usuario, String senha) {
        boolean bool = false;
        Cursor cursor;
        String[] campos = {CriaBanco.getClienteUsuario(), CriaBanco.getClienteSenha()};
        String where = CriaBanco.getClienteUsuario() + "='" + usuario + "' AND " + CriaBanco.getClienteSenha() + "='" + senha + "'";
        db = banco.getReadableDatabase();
        cursor = db.query(CriaBanco.getCLIENTE(), campos, where, null, null, null, null, null);
        if (cursor != null) {
            boolean result = cursor.moveToFirst();
            if (result == true) {
                bool = true;
            }
        }
        db.close();
        return bool;
    }

    public Cursor carregaDadosCategoriaLeitorByCodigo(int codigo) {
        Cursor cursor;
        String[] campos = {CriaBanco.getCategoriaLeitorCodigo(), CriaBanco.getCategoriaLeitorDescricao(),
                CriaBanco.getCategoriaLeitorNumeroMaximoDia()};
        String where = CriaBanco.getCategoriaLeitorCodigo() + "=" + codigo;
        db = banco.getReadableDatabase();
        cursor = db.query(CriaBanco.getCategoriaLeitor(), campos, where, null, null, null, null, null);
        if (cursor != null) {
            cursor.moveToFirst();
        }
        db.close();
        return cursor;
    }

    public Cursor carregaDadosCategoriaLivroByCodigo(int codigo) {
        Cursor cursor;
        String[] campos = {CriaBanco.getCategoriaLivroCodigo(), CriaBanco.getCategoriaLivroDescricao(),
                CriaBanco.getCategoriaLivroNumeroMaximoDia(),
                CriaBanco.getCategoriaLivroTaxaMultaAtrasoDevolucao()};
        String where = CriaBanco.getCategoriaLeitorCodigo() + "=" + codigo;
        db = banco.getReadableDatabase();
        cursor = db.query(CriaBanco.getCategoriaLivro(), campos, where, null, null, null, null, null);
        if (cursor != null) {
            cursor.moveToFirst();
        }
        db.close();
        return cursor;
    }

    public Cursor carregaDadosClienteByCodigo(int codigo) {
        Cursor cursor;
        String[] campos =
                {CriaBanco.getClienteCodigo(), CriaBanco.getClienteNome(),
                        CriaBanco.getClienteUsuario(), CriaBanco.getClienteEndereco(),
                        CriaBanco.getClienteCelular(), CriaBanco.getClienteEmail(),
                        CriaBanco.getClienteCpf(), CriaBanco.getClienteDataNascimento(),
                        CriaBanco.getClienteCategoriaLeitor(), CriaBanco.getClienteSenha()};
        String where = CriaBanco.getClienteCodigo() + "=" + codigo;
        db = banco.getReadableDatabase();
        cursor = db.query(CriaBanco.getCLIENTE(), campos, where, null, null, null, null, null);
        if (cursor != null) {
            cursor.moveToFirst();
        }
        db.close();
        return cursor;
    }

    public Cursor carregaDadosLivroByCodigo(int codigo) {
        Cursor cursor;
        String[] campos = {CriaBanco.getLivroCodigo(), CriaBanco.getLivroIsbn(),
                CriaBanco.getLivroTitulo(), CriaBanco.getLivroCategoriaLivro(),
                CriaBanco.getLivroAutor(), CriaBanco.getLivroPalavrachave(),
                CriaBanco.getLivroDataPublicacao(), CriaBanco.getLivroNumeroEdicao(),
                CriaBanco.getLivroEditora(), CriaBanco.getLivroNumeroPagina()};
        String where = CriaBanco.getLivroCodigo() + "=" + codigo;
        db = banco.getReadableDatabase();
        cursor = db.query(CriaBanco.getLIVRO(), campos, where, null, null, null, null, null);
        if (cursor != null) {
            cursor.moveToFirst();
        }
        db.close();
        return cursor;
    }

    public Cursor carregaEmprestimoByCodigo(int codigo) {
        Cursor cursor;
        String[] campos = {CriaBanco.getEmprestimoCodigo(), CriaBanco.getEmprestimoLivro(),
                CriaBanco.getEmprestimoCategoriaLivro(), CriaBanco.getEmprestimoCliente(),
                CriaBanco.getEmprestimoDataInicial(), CriaBanco.getEmprestimoDataFinal(),
                CriaBanco.getEmprestimoStatus()};
        String where = CriaBanco.getEmprestimoCodigo() + "=" + codigo;
        db = banco.getReadableDatabase();
        cursor = db.query(CriaBanco.getEMPRESTIMO(), campos, where, null, CriaBanco.getEmprestimoCategoriaLivro(), null, null, null);
        if (cursor != null) {
            cursor.moveToFirst();
        }
        db.close();
        return cursor;
    }
}