package com.example.myapplication.repository;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;

import com.example.myapplication.Uteis.DatabaseUtil;
import com.example.myapplication.model.ProdutoModel;

import java.util.ArrayList;
import java.util.List;



public class ProdutoRepository {

    DatabaseUtil databaseUtil;

    /***
     * CONSTRUTOR
     * @param context
     */
    public ProdutoRepository(Context context){

        databaseUtil =  new DatabaseUtil(context);

    }

    /***
     * SALVA UM NOVO REGISTRO NA BASE DE DADOS
     * @param produtoModel
     */
    public void Salvar(ProdutoModel produtoModel){

        ContentValues contentValues =  new ContentValues();
        /*MONTANDO OS PARAMETROS PARA SEREM SALVOS*/

        contentValues.put("ds_empresa    ",    produtoModel.getEmpresa());
        contentValues.put("ds_nomeproduto",    produtoModel.getNomeProduto());
        contentValues.put("ds_descricao  ",    produtoModel.getDescricao());
        contentValues.put("ds_apelido    ",    produtoModel.getApelido());
        contentValues.put("ds_grupo      ",    produtoModel.getGrupo());
        contentValues.put("ds_subgrupo   ",    produtoModel.getSubGrupo());
        contentValues.put("ds_colecao    ",    produtoModel.getColecao());
        contentValues.put("ds_situacao   ",    produtoModel.getSituacao());
        contentValues.put("ds_pesoliq    ",    produtoModel.getPesoLiq());
        contentValues.put("ds_classfiscal",    produtoModel.getClassFiscal());
        contentValues.put("ds_codbar     ",    produtoModel.getCodBar());
        contentValues.put("fl_ativo      ",    produtoModel.getAtivo());

        /*EXECUTANDO INSERT DE UM NOVO REGISTRO*/
        databaseUtil.GetConexaoDataBase().insert("tb_produto",null,contentValues);

    }

    /***
     * ATUALIZA UM REGISTRO JÁ EXISTENTE NA BASE
     * @param produtoModel
     */
    public void Atualizar(ProdutoModel produtoModel){

        ContentValues contentValues =  new ContentValues();

        /*MONTA OS PARAMENTROS PARA REALIZAR UPDATE NOS CAMPOS*/
        contentValues.put("ds_empresa    ",    produtoModel.getEmpresa());
        contentValues.put("ds_nomeproduto",    produtoModel.getNomeProduto());
        contentValues.put("ds_descricao  ",    produtoModel.getDescricao());
        contentValues.put("ds_apelido    ",    produtoModel.getApelido());
        contentValues.put("ds_grupo      ",    produtoModel.getGrupo());
        contentValues.put("ds_subgrupo   ",    produtoModel.getSubGrupo());
        contentValues.put("ds_colecao    ",    produtoModel.getColecao());
        contentValues.put("ds_situacao   ",    produtoModel.getSituacao());
        contentValues.put("ds_pesoliq    ",    produtoModel.getPesoLiq());
        contentValues.put("ds_classfiscal",    produtoModel.getClassFiscal());
        contentValues.put("ds_codbar     ",    produtoModel.getCodBar());
        contentValues.put("fl_ativo      ",    produtoModel.getAtivo());


        /*REALIZANDO UPDATE PELA CHAVE DA TABELA*/
        databaseUtil.GetConexaoDataBase().update("tb_produto", contentValues, "id_produto = ?", new String[]{Integer.toString(produtoModel.getCodigo())});
    }

    /***
     * EXCLUI UM REGISTRO PELO CÓDIGO
     * @param codigo
     * @return
     */
    public Integer Excluir(int codigo){

        //EXCLUINDO  REGISTRO E RETORNANDO O NÚMERO DE LINHAS AFETADAS
        return databaseUtil.GetConexaoDataBase().delete("tb_produto","id_produto = ?", new String[]{Integer.toString(codigo)});
    }

    /***
     * CONSULTA UMA EMPRESA CADASTRADA PELO CÓDIGO
     * @param codigo
     * @return
     */
    public ProdutoModel GetPessoa(int codigo){


        Cursor cursor =  databaseUtil.GetConexaoDataBase().rawQuery("SELECT * FROM tb_produto WHERE id_produto= "+ codigo,null);

        cursor.moveToFirst();

        ///CRIANDO UMA NOVA PESSOAS
        ProdutoModel produtoModel =  new ProdutoModel();

        //ADICIONANDO OS DADOS DA PESSOA
        produtoModel.setCodigo(cursor.getInt(cursor.getColumnIndex("id_produto")));
        produtoModel.setEmpresa(cursor.getString(cursor.getColumnIndex("ds_empresa")));
        produtoModel.setNomeProduto(cursor.getString(cursor.getColumnIndex("ds_nomeproduto")));
        produtoModel.setDescricao(cursor.getInt(cursor.getColumnIndex("ds_descricao")));
        produtoModel.setApelido(cursor.getString(cursor.getColumnIndex("ds_apelido")));
        produtoModel.setGrupo(cursor.getString(cursor.getColumnIndex("ds_grupo")));
        produtoModel.setSubGrupo(cursor.getString(cursor.getColumnIndex("ds_subgrupo")));
        produtoModel.setColecao(cursor.getInt(cursor.getColumnIndex("ds_colecao")));
        produtoModel.setSituacao(cursor.getString(cursor.getColumnIndex("ds_situacao")));
        produtoModel.setPesoLiq(cursor.getString(cursor.getColumnIndex("ds_pesoliq")));
        produtoModel.setClassFiscal(cursor.getInt(cursor.getColumnIndex("ds_classfiscal")));
        produtoModel.setCodBar(cursor.getInt(cursor.getColumnIndex("ds_codbar")));
        produtoModel.setAtivo((byte)cursor.getShort(cursor.getColumnIndex("fl_ativo")));

        //RETORNANDO A EMPRESA
        return produtoModel;

    }

    /***
     * CONSULTA TODAS AS EMPRESAS CADASTRADAS NA BASE
     * @return
     */
    public List<ProdutoModel> SelecionarTodos(){

        List<ProdutoModel> produtos = new ArrayList<ProdutoModel>();


        //MONTA A QUERY A SER EXECUTADA
        StringBuilder stringBuilderQuery = new StringBuilder();
        stringBuilderQuery.append(" SELECT id_produto,       ");
        stringBuilderQuery.append("        ds_empresa, ");
        stringBuilderQuery.append("        ds_nomeproduto, ");
        stringBuilderQuery.append("  FROM  tb_produto       ");
        stringBuilderQuery.append(" ORDER BY ds_nomeproduto        ");


        //CONSULTANDO OS REGISTROS CADASTRADOS
        Cursor cursor = databaseUtil.GetConexaoDataBase().rawQuery(stringBuilderQuery.toString(), null);

        /*POSICIONA O CURSOR NO PRIMEIRO REGISTRO*/
        cursor.moveToFirst();


        ProdutoModel produtoModel;

        //REALIZA A LEITURA DOS REGISTROS ENQUANTO NÃO FOR O FIM DO CURSOR
        while (!cursor.isAfterLast()){

            /* CRIANDO UMA NOVA PESSOAS */
            produtoModel =  new ProdutoModel();

            //ADICIONANDO OS DADOS DA EMPRESA
            produtoModel.setCodigo(cursor.getInt(cursor.getColumnIndex("id_produto")));
            produtoModel.setEmpresa(cursor.getString(cursor.getColumnIndex("ds_empresa")));
            produtoModel.setNomeProduto(cursor.getString(cursor.getColumnIndex("ds_nomeproduto")));
            produtoModel.setDescricao(cursor.getInt(cursor.getColumnIndex("ds_descricao")));
            produtoModel.setApelido(cursor.getString(cursor.getColumnIndex("ds_apelido")));
            produtoModel.setGrupo(cursor.getString(cursor.getColumnIndex("ds_grupo")));
            produtoModel.setSubGrupo(cursor.getString(cursor.getColumnIndex("ds_subgrupo")));
            produtoModel.setColecao(cursor.getInt(cursor.getColumnIndex("ds_colecao")));
            produtoModel.setSituacao(cursor.getString(cursor.getColumnIndex("ds_situacao")));
            produtoModel.setPesoLiq(cursor.getString(cursor.getColumnIndex("ds_pesoliq")));
            produtoModel.setClassFiscal(cursor.getInt(cursor.getColumnIndex("ds_classfiscal")));
            produtoModel.setCodBar(cursor.getInt(cursor.getColumnIndex("ds_codbar")));
            produtoModel.setAtivo((byte)cursor.getShort(cursor.getColumnIndex("fl_ativo")));


            //ADICIONANDO UMA PESSOA NA LISTA
            produtos.add(produtoModel);

            //VAI PARA O PRÓXIMO REGISTRO
            cursor.moveToNext();
        }

        //RETORNANDO A LISTA DE PESSOAS
        return produtos;

    }
}