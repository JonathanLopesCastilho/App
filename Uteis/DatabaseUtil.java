package com.example.myapplication.Uteis;

import android.app.AlertDialog;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.icu.text.UnicodeSetIterator;

public class DatabaseUtil extends SQLiteOpenHelper {

    //NOME DA BASE DE DADOS
    private static final String NOME_BASE_DE_DADOS   = "SISTEMA.db";

    //VERSÃO DO BANCO DE DADOS
    private static final int    VERSAO_BASE_DE_DADOS = 1;

    //CONSTRUTOR
    public DatabaseUtil(Context context){

        super(context,NOME_BASE_DE_DADOS,null,VERSAO_BASE_DE_DADOS);
    }

    /*NA INICIALIZAÇÃO DA CLASSE VAMOS CRIAR A TABELA QUE VAMOS USAR*/
    @Override
    public void onCreate(SQLiteDatabase db) {

        StringBuilder stringBuilderCreateTable = new StringBuilder();

        stringBuilderCreateTable.append(" CREATE TABLE tb_empresa (");
        stringBuilderCreateTable.append("        id_empresa     INTEGER PRIMARY KEY AUTOINCREMENT,   ");
        stringBuilderCreateTable.append("        ds_nomefantasia        TEXT    NOT NULL,            ");
        stringBuilderCreateTable.append("        ds_razaoSocial         TEXT    NOT NULL,            ");
        stringBuilderCreateTable.append("        ds_endereco            TEXT    NOT NULL,            ");
        stringBuilderCreateTable.append("        ds_bairro              TEXT    NOT NULL,            ");
        stringBuilderCreateTable.append("        ds_cep                 TEXT    NOT NULL,            ");
        stringBuilderCreateTable.append("        ds_cidade              TEXT    NOT NULL,            ");
        stringBuilderCreateTable.append("        ds_telefone            TEXT    NOT NULL,            ");
        stringBuilderCreateTable.append("        ds_fax                 TEXT    NOT NULL,            ");
        stringBuilderCreateTable.append("        ds_cnpj                TEXT    NOT NULL,            ");
        stringBuilderCreateTable.append("        ds_ie                  TEXT    NOT NULL,            ");
        stringBuilderCreateTable.append("        fl_ativo               INT     NOT NULL )           ");


        db.execSQL(stringBuilderCreateTable.toString());

        stringBuilderCreateTable.append(" CREATE TABLE tb_produto (");
        stringBuilderCreateTable.append("        id_produto             INTEGER PRIMARY KEY AUTOINCREMENT,   ");
        stringBuilderCreateTable.append("        ds_empresa             TEXT    NOT NULL,            ");
        stringBuilderCreateTable.append("        ds_nomeproduto         TEXT    NOT NULL,            ");
        stringBuilderCreateTable.append("        ds_descricao           TEXT    NOT NULL,            ");
        stringBuilderCreateTable.append("        ds_apelido             TEXT    NOT NULL,            ");
        stringBuilderCreateTable.append("        ds_grupo               TEXT    NOT NULL,            ");
        stringBuilderCreateTable.append("        ds_subgrupo            TEXT    NOT NULL,            ");
        stringBuilderCreateTable.append("        ds_colecao             TEXT    NOT NULL,            ");
        stringBuilderCreateTable.append("        ds_situacao            TEXT    NOT NULL,            ");
        stringBuilderCreateTable.append("        ds_pesoliq             TEXT    NOT NULL,            ");
        stringBuilderCreateTable.append("        ds_classfiscal         TEXT    NOT NULL,            ");
        stringBuilderCreateTable.append("        ds_codbar              TEXT    NOT NULL,            ");
        stringBuilderCreateTable.append("        fl_ativo               INT     NOT NULL )           ");


        db.execSQL(stringBuilderCreateTable.toString());

    }

    /*SE TROCAR A VERSÃO DO BANCO DE DADOS VOCÊ PODE EXECUTAR ALGUMA ROTINA
      COMO CRIAR COLUNAS, EXCLUIR ENTRE OUTRAS */
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

        db.execSQL("DROP TABLE IF EXISTS tb_empresa");
        onCreate(db);
        db.execSQL("DROP TABLE IF EXISTS tb_produto");
        onCreate(db);

    }

    /*MÉTODO QUE VAMOS USAR NA CLASSE QUE VAI EXECUTAR AS ROTINAS NO
    BANCO DE DADOS*/
    public SQLiteDatabase GetConexaoDataBase(){

        return this.getWritableDatabase();
    }
}
