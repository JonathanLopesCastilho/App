package com.example.myapplication.repository;


import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;

import com.example.myapplication.Uteis.DatabaseUtil;
import com.example.myapplication.model.EmpresaModel;

import java.util.ArrayList;
import java.util.List;



public class EmpresaRepository {

    DatabaseUtil databaseUtil;

    /***
     * CONSTRUTOR
     * @param context
     */
    public EmpresaRepository(Context context){

        databaseUtil =  new DatabaseUtil(context);

    }

    /***
     * SALVA UM NOVO REGISTRO NA BASE DE DADOS
     * @param empresaModel
     */
    public void Salvar(EmpresaModel empresaModel){

        ContentValues contentValues =  new ContentValues();
        /*MONTANDO OS PARAMETROS PARA SEREM SALVOS*/
        contentValues.put("ds_nomefantasia",         empresaModel.getNomefantasia());
        contentValues.put("ds_razaoSocial",          empresaModel.getRazaoSocial());
        contentValues.put("ds_endereco",             empresaModel.getEndereco());
        contentValues.put("ds_bairro",               empresaModel.getBairro());
        contentValues.put("ds_cep",                  empresaModel.getCep());
        contentValues.put("ds_cidade",               empresaModel.getCidade());
        contentValues.put("ds_telefone",             empresaModel.getTelefone());
        contentValues.put("ds_fax",                  empresaModel.getFax());
        contentValues.put("ds_cnpj",                 empresaModel.getCnpj());
        contentValues.put("ds_ie",                   empresaModel.getIe());
        contentValues.put("fl_ativo",                empresaModel.getAtivo());

        /*EXECUTANDO INSERT DE UM NOVO REGISTRO*/
        databaseUtil.GetConexaoDataBase().insert("tb_pessoa",null,contentValues);

    }

    /***
     * ATUALIZA UM REGISTRO JÁ EXISTENTE NA BASE
     * @param empresaModel
     */
    public void Atualizar(EmpresaModel empresaModel){

        ContentValues contentValues =  new ContentValues();

        /*MONTA OS PARAMENTROS PARA REALIZAR UPDATE NOS CAMPOS*/
        contentValues.put("ds_nomefantasia",         empresaModel.getNomefantasia());
        contentValues.put("ds_razaoSocial",          empresaModel.getRazaoSocial());
        contentValues.put("ds_endereco",             empresaModel.getEndereco());
        contentValues.put("ds_bairro",               empresaModel.getBairro());
        contentValues.put("ds_cep",                  empresaModel.getCep());
        contentValues.put("ds_cidade",               empresaModel.getCidade());
        contentValues.put("ds_telefone",             empresaModel.getTelefone());
        contentValues.put("ds_fax",                  empresaModel.getFax());
        contentValues.put("ds_cnpj",                 empresaModel.getCnpj());
        contentValues.put("ds_ie",                   empresaModel.getIe());
        contentValues.put("fl_ativo",                empresaModel.getAtivo());


        /*REALIZANDO UPDATE PELA CHAVE DA TABELA*/
        databaseUtil.GetConexaoDataBase().update("tb_empresa", contentValues, "id_empresa = ?", new String[]{Integer.toString(empresaModel.getCodigo())});
    }

    /***
     * EXCLUI UM REGISTRO PELO CÓDIGO
     * @param codigo
     * @return
     */
    public Integer Excluir(int codigo){

        //EXCLUINDO  REGISTRO E RETORNANDO O NÚMERO DE LINHAS AFETADAS
        return databaseUtil.GetConexaoDataBase().delete("tb_empresa","id_empresa = ?", new String[]{Integer.toString(codigo)});
    }

    /***
     * CONSULTA UMA EMPRESA CADASTRADA PELO CÓDIGO
     * @param codigo
     * @return
     */
    public EmpresaModel GetEmpresa(int codigo){


        Cursor cursor =  databaseUtil.GetConexaoDataBase().rawQuery("SELECT * FROM tb_empresa WHERE id_empresa= "+ codigo,null);

        cursor.moveToFirst();

        ///CRIANDO UMA NOVA EMPRESA
        EmpresaModel empresaModel =  new EmpresaModel();

        //ADICIONANDO OS DADOS DA EMPRESA
        empresaModel.setCodigo(cursor.getInt(cursor.getColumnIndex("id_empresa")));
        empresaModel.setNomefantasia(cursor.getString(cursor.getColumnIndex("ds_nomefantasia")));
        empresaModel.setRazaoSocial(cursor.getString(cursor.getColumnIndex("ds_razaoSocial")));
        empresaModel.setEndereco(cursor.getInt(cursor.getColumnIndex("ds_endereco")));
        empresaModel.setBairro(cursor.getString(cursor.getColumnIndex("ds_bairro")));
        empresaModel.setCep(cursor.getString(cursor.getColumnIndex("ds_cep")));
        empresaModel.setCidade(cursor.getString(cursor.getColumnIndex("ds_cidade")));
        empresaModel.setTelefone(cursor.getInt(cursor.getColumnIndex("ds_telefone")));
        empresaModel.setFax(cursor.getString(cursor.getColumnIndex("ds_fax")));
        empresaModel.setCnpj(cursor.getString(cursor.getColumnIndex("ds_cnpj")));
        empresaModel.setIe(cursor.getInt(cursor.getColumnIndex("ds_ie")));
        empresaModel.setAtivo((byte)cursor.getShort(cursor.getColumnIndex("fl_ativo")));

        //RETORNANDO A EMPRESA
        return empresaModel;

    }

    /***
     * CONSULTA TODAS AS EMPRESAS CADASTRADAS NA BASE
     * @return
     */
    public List<EmpresaModel> SelecionarTodos(){

        List<EmpresaModel> empresas = new ArrayList<EmpresaModel>();


        //MONTA A QUERY A SER EXECUTADA
        StringBuilder stringBuilderQuery = new StringBuilder();
        stringBuilderQuery.append(" SELECT id_pessoa,       ");
        stringBuilderQuery.append("        ds_nomefantasia, ");
        stringBuilderQuery.append("        ds_cidade, ");
        stringBuilderQuery.append("  FROM  tb_empresa       ");
        stringBuilderQuery.append(" ORDER BY ds_nome        ");


        //CONSULTANDO OS REGISTROS CADASTRADOS
        Cursor cursor = databaseUtil.GetConexaoDataBase().rawQuery(stringBuilderQuery.toString(), null);

        /*POSICIONA O CURSOR NO PRIMEIRO REGISTRO*/
        cursor.moveToFirst();


        EmpresaModel empresaModel;

        //REALIZA A LEITURA DOS REGISTROS ENQUANTO NÃO FOR O FIM DO CURSOR
        while (!cursor.isAfterLast()){

            /* CRIANDO UMA NOVA PESSOAS */
            empresaModel =  new EmpresaModel();

            //ADICIONANDO OS DADOS DA EMPRESA
            empresaModel.setCodigo(cursor.getInt(cursor.getColumnIndex("id_empresa")));
            empresaModel.setNomefantasia(cursor.getString(cursor.getColumnIndex("ds_nomefantasia")));
            empresaModel.setRazaoSocial(cursor.getString(cursor.getColumnIndex("ds_razaoSocial")));
            empresaModel.setEndereco(cursor.getInt(cursor.getColumnIndex("ds_endereco")));
            empresaModel.setBairro(cursor.getString(cursor.getColumnIndex("ds_bairro")));
            empresaModel.setCep(cursor.getString(cursor.getColumnIndex("ds_cep")));
            empresaModel.setCidade(cursor.getString(cursor.getColumnIndex("ds_cidade")));
            empresaModel.setTelefone(cursor.getInt(cursor.getColumnIndex("ds_telefone")));
            empresaModel.setFax(cursor.getString(cursor.getColumnIndex("ds_fax")));
            empresaModel.setCnpj(cursor.getString(cursor.getColumnIndex("ds_cnpj")));
            empresaModel.setIe(cursor.getInt(cursor.getColumnIndex("ds_ie")));
            empresaModel.setAtivo((byte)cursor.getShort(cursor.getColumnIndex("fl_ativo")));


            //ADICIONANDO UMA PESSOA NA LISTA
            empresas.add(empresaModel);

            //VAI PARA O PRÓXIMO REGISTRO
            cursor.moveToNext();
        }

        //RETORNANDO A LISTA DE PESSOAS
        return empresas;

    }
}