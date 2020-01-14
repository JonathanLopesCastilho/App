package com.example.myapplication.model;

public class ProdutoModel {

    private  Integer   Codigo;
    private  String   Empresa;
    private  String   NomeProduto;
    private int Descricao;
    private  String   Apelido;
    private  String   Grupo;
    private  String   SubGrupo;
    private  String   Situacao;
    private  String   PesoLiq;
    private int ClassFiscal;
    private int CodBar;
    private int Colecao;
    private byte Ativo;

    public Integer getCodigo() {
        return Codigo;
    }

    public void setCodigo(Integer codigo) {
        Codigo = codigo;
    }

    public String getEmpresa() {
        return Empresa;
    }

    public void setEmpresa(String empresa) {
        Empresa = empresa;
    }

    public String getNomeProduto() {
        return NomeProduto;
    }

    public void setNomeProduto(String nomeProduto) {
        NomeProduto = nomeProduto;
    }

    public int getDescricao() {
        return Descricao;
    }

    public void setDescricao(String descricao) {
        Descricao = descricao;
    }

    public String getApelido() {
        return Apelido;
    }

    public void setApelido(String apelido) {
        Apelido = apelido;
    }

    public String getGrupo() {
        return Grupo;
    }

    public void setGrupo(String grupo) {
        Grupo = grupo;
    }

    public String getSubGrupo() {
        return SubGrupo;
    }

    public void setSubGrupo(String subGrupo) {
        SubGrupo = subGrupo;
    }

    public String getSituacao() {
        return Situacao;
    }

    public void setSituacao(String situacao) {
        Situacao = situacao;
    }

    public String getPesoLiq() {
        return PesoLiq;
    }

    public void setPesoLiq(String pesoLiq) {
        PesoLiq = pesoLiq;
    }

    public int getClassFiscal() {
        return ClassFiscal;
    }

    public void setClassFiscal(String classFiscal) {
        ClassFiscal = classFiscal;
    }

    public int getCodBar() {
        return CodBar;
    }

    public void setCodBar(String codBar) {
        CodBar = codBar;
    }

    public int getColecao() {
        return Colecao;
    }

    public void setColecao(String colecao) {
        Colecao = colecao;
    }

    public byte getAtivo() {
        return Ativo;
    }

    public void setAtivo(byte ativo) {
        Ativo = ativo;
    }


}
