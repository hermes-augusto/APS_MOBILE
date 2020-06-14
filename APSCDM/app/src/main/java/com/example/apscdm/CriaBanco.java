/*
    Erik Kaue Paroline Jose dos Santos - RA: 20960545
    Fernanda Pereira Umberto - RA: 20943426
    Guilherme Rodrigues de Miranda - RA: 20996393
    Matheus Marques de Souza - RA: 20981531
    Milena Basso - RA: 20956610
 */
package com.example.apscdm;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class CriaBanco extends SQLiteOpenHelper {
    private static final String NOME_BANCO = "BDAPSCDM.db";
    private static final String CATEGORIA_LEITOR = "CategoriaLeitor";
    private static final String CATEGORIA_LEITOR_CODIGO = "_id";
    private static final String CATEGORIA_LEITOR_DESCRICAO = "Descricao";
    private static final String CATEGORIA_LEITOR_NUMERO_MAXIMO_DIA = "NumeroMaximoDia";
    private static final String CLIENTE = "Cliente";
    private static final String CLIENTE_CODIGO = "_id";
    private static final String CLIENTE_NOME = "Nome";
    private static final String CLIENTE_USUARIO = "Usuario";
    private static final String CLIENTE_ENDERECO = "Endereco";
    private static final String CLIENTE_CELULAR = "Celular";
    private static final String CLIENTE_EMAIL = "Email";
    private static final String CLIENTE_CPF = "Cpf";
    private static final String CLIENTE_DATA_NASCIMENTO = "DataNascimento";
    private static final String CLIENTE_CATEGORIA_LEITOR = "CategoriaLeitor";
    private static final String CLIENTE_SENHA = "Senha";
    private static final String CATEGORIA_LIVRO = "CategoriaLivro";
    private static final String CATEGORIA_LIVRO_CODIGO = "_id";
    private static final String CATEGORIA_LIVRO_DESCRICAO = "Descricao";
    private static final String CATEGORIA_LIVRO_NUMERO_MAXIMO_DIA = "NumeroMaximoDia";
    private static final String CATEGORIA_LIVRO_TAXA_MULTA_ATRASO_DEVOLUCAO = "TaxaMultaAtrasoDevolucao";
    private static final String LIVRO = "Livro";
    private static final String LIVRO_CODIGO = "_id";
    private static final String LIVRO_ISBN = "Isbn";
    private static final String LIVRO_TITULO = "Titulo";
    private static final String LIVRO_CATEGORIA_LIVRO = "CategoriaLivro";
    private static final String LIVRO_AUTOR = "Autor";
    private static final String LIVRO_PALAVRACHAVE = "PalavraChave";
    private static final String LIVRO_DATA_PUBLICACAO = "DataPublicacao";
    private static final String LIVRO_NUMERO_EDICAO = "NumeroEdicao";
    private static final String LIVRO_EDITORA = "Editora";
    private static final String LIVRO_NUMERO_PAGINA = "NumeroPagina";
    private static final String EMPRESTIMO = "Emprestimo";
    private static final String EMPRESTIMO_CODIGO = "_id";
    private static final String EMPRESTIMO_CLIENTE = "Cliente";
    private static final String EMPRESTIMO_LIVRO = "Livro";
    private static final String EMPRESTIMO_CATEGORIA_LIVRO = "CategoriaLivro";
    private static final String EMPRESTIMO_DATA_INICIAL = "DataInicial";
    private static final String EMPRESTIMO_DATA_FINAL = "DataFinal";
    private static final String EMPRESTIMO_STATUS = "Status";
    private static final int VERSAO = 1;

    public CriaBanco(Context context) {
        super(context, getNomeBanco(), null, getVERSAO());
    }

    public static String getNomeBanco() {
        return NOME_BANCO;
    }

    public static String getCategoriaLeitor() {
        return CATEGORIA_LEITOR;
    }

    public static String getCategoriaLeitorCodigo() {
        return CATEGORIA_LEITOR_CODIGO;
    }

    public static String getCategoriaLeitorDescricao() {
        return CATEGORIA_LEITOR_DESCRICAO;
    }

    public static String getCategoriaLeitorNumeroMaximoDia() {
        return CATEGORIA_LEITOR_NUMERO_MAXIMO_DIA;
    }

    public static String getCLIENTE() {
        return CLIENTE;
    }

    public static String getClienteCodigo() {
        return CLIENTE_CODIGO;
    }

    public static String getClienteNome() {
        return CLIENTE_NOME;
    }

    public static String getClienteEndereco() {
        return CLIENTE_ENDERECO;
    }

    public static String getClienteUsuario() {
        return CLIENTE_USUARIO;
    }

    public static String getClienteCelular() {
        return CLIENTE_CELULAR;
    }

    public static String getClienteEmail() {
        return CLIENTE_EMAIL;
    }

    public static String getClienteCpf() {
        return CLIENTE_CPF;
    }

    public static String getClienteDataNascimento() {
        return CLIENTE_DATA_NASCIMENTO;
    }

    public static String getClienteCategoriaLeitor() {
        return CLIENTE_CATEGORIA_LEITOR;
    }

    public static String getClienteSenha() {
        return CLIENTE_SENHA;
    }

    public static String getCategoriaLivro() {
        return CATEGORIA_LIVRO;
    }

    public static String getCategoriaLivroCodigo() {
        return CATEGORIA_LIVRO_CODIGO;
    }

    public static String getCategoriaLivroDescricao() {
        return CATEGORIA_LIVRO_DESCRICAO;
    }

    public static String getCategoriaLivroNumeroMaximoDia() {
        return CATEGORIA_LIVRO_NUMERO_MAXIMO_DIA;
    }

    public static String getCategoriaLivroTaxaMultaAtrasoDevolucao() {
        return CATEGORIA_LIVRO_TAXA_MULTA_ATRASO_DEVOLUCAO;
    }

    public static String getLIVRO() {
        return LIVRO;
    }

    public static String getLivroCodigo() {
        return LIVRO_CODIGO;
    }

    public static String getLivroIsbn() {
        return LIVRO_ISBN;
    }

    public static String getLivroTitulo() {
        return LIVRO_TITULO;
    }

    public static String getLivroCategoriaLivro() {
        return LIVRO_CATEGORIA_LIVRO;
    }

    public static String getLivroAutor() {
        return LIVRO_AUTOR;
    }

    public static String getLivroPalavrachave() {
        return LIVRO_PALAVRACHAVE;
    }

    public static String getLivroDataPublicacao() {
        return LIVRO_DATA_PUBLICACAO;
    }

    public static String getLivroNumeroEdicao() {
        return LIVRO_NUMERO_EDICAO;
    }

    public static String getLivroEditora() {
        return LIVRO_EDITORA;
    }

    public static String getLivroNumeroPagina() {
        return LIVRO_NUMERO_PAGINA;
    }

    public static int getVERSAO() {
        return VERSAO;
    }

    public static String getEMPRESTIMO() {
        return EMPRESTIMO;
    }

    public static String getEmprestimoCodigo() {
        return EMPRESTIMO_CODIGO;
    }

    public static String getEmprestimoCliente() {
        return EMPRESTIMO_CLIENTE;
    }

    public static String getEmprestimoLivro() {
        return EMPRESTIMO_LIVRO;
    }

    public static String getEmprestimoCategoriaLivro() {
        return EMPRESTIMO_CATEGORIA_LIVRO;
    }

    public static String getEmprestimoDataInicial() {
        return EMPRESTIMO_DATA_INICIAL;
    }

    public static String getEmprestimoDataFinal() {
        return EMPRESTIMO_DATA_FINAL;
    }

    public static String getEmprestimoStatus() {
        return EMPRESTIMO_STATUS;
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        String sql = "CREATE TABLE " + CATEGORIA_LEITOR + "("
                + CATEGORIA_LEITOR_CODIGO + " integer primary key autoincrement, "
                + CATEGORIA_LEITOR_DESCRICAO + " text, "
                + CATEGORIA_LEITOR_NUMERO_MAXIMO_DIA + " integer "
                + ")";
        sqLiteDatabase.execSQL(sql);
        sql = "CREATE TABLE " + CLIENTE + "("
                + CLIENTE_CODIGO + " integer primary key autoincrement, "
                + CLIENTE_NOME + " text, "
                + CLIENTE_USUARIO + " text unique, "
                + CLIENTE_ENDERECO + " text, "
                + CLIENTE_CELULAR + " text, "
                + CLIENTE_EMAIL + " text, "
                + CLIENTE_CPF + " text, "
                + CLIENTE_DATA_NASCIMENTO + " text, "
                + CLIENTE_CATEGORIA_LEITOR + " text, "
                + CLIENTE_SENHA + " text "
                + ")";
        sqLiteDatabase.execSQL(sql);
        sql = "CREATE TABLE " + CATEGORIA_LIVRO + "("
                + CATEGORIA_LIVRO_CODIGO + " integer primary key autoincrement, "
                + CATEGORIA_LIVRO_DESCRICAO + " text, "
                + CATEGORIA_LIVRO_NUMERO_MAXIMO_DIA + " integer, "
                + CATEGORIA_LIVRO_TAXA_MULTA_ATRASO_DEVOLUCAO + " real "
                + ")";
        sqLiteDatabase.execSQL(sql);
        sql = "CREATE TABLE " + LIVRO + "("
                + LIVRO_CODIGO + " integer primary key autoincrement, "
                + LIVRO_ISBN + " integer, "
                + LIVRO_TITULO + " text, "
                + LIVRO_CATEGORIA_LIVRO + " text, "
                + LIVRO_AUTOR + " text, "
                + LIVRO_PALAVRACHAVE + " text, "
                + LIVRO_DATA_PUBLICACAO + " text, "
                + LIVRO_NUMERO_EDICAO + " integer, "
                + LIVRO_EDITORA + " text, "
                + LIVRO_NUMERO_PAGINA + " integer "
                + ")";
        sqLiteDatabase.execSQL(sql);
        sql = "CREATE TABLE " + EMPRESTIMO + "("
                + EMPRESTIMO_CODIGO + " integer primary key autoincrement, "
                + EMPRESTIMO_CLIENTE + " text, "
                + EMPRESTIMO_LIVRO + " text, "
                + EMPRESTIMO_CATEGORIA_LIVRO + " text, "
                + EMPRESTIMO_DATA_INICIAL + " text, "
                + EMPRESTIMO_DATA_FINAL + " text, "
                + EMPRESTIMO_STATUS + " integer "
                + ")";
        sqLiteDatabase.execSQL(sql);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " + CATEGORIA_LEITOR);
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " + CLIENTE);
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " + CATEGORIA_LIVRO);
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " + LIVRO);
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " + EMPRESTIMO);
        onCreate(sqLiteDatabase);
    }
}