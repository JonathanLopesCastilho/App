package com.example.myapplication.Uteis;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.myapplication.ConsultarActivity;
import com.example.myapplication.EditarEmpresaActivity;
import com.example.myapplication.EditarProdutoActivity;
import com.example.myapplication.R;
import com.example.myapplication.model.ProdutoModel;
import com.example.myapplication.repository.ProdutoRepository;

import java.util.ArrayList;
import java.util.List;


public class LinhaConsultarProdutoAdapter extends BaseAdapter {

    //CRIANDO UM OBJETO LayoutInflater PARA FAZER LINK A NOSSA VIEW(activity_linha_consultar_empresa.xml)
    private static LayoutInflater layoutInflater = null;

    //CRIANDO UMA LISTA DE PRODUTOS
    List<ProdutoModel> produtoModels = new ArrayList<ProdutoModel>();

    //CIRANDO UM OBJETO DA NOSSA CLASSE QUE FAZ ACESSO AO BANCO DE DADOS
    ProdutoRepository produtoRepository;

    //CRIANDO UM OBJETO DA NOSSA ATIVIDADE QUE CONTEM A LISTA
    private ConsultarActivity consultarActivity;

    //CONSTRUTOR QUE VAI RECEBER A NOSSA ATIVIDADE COMO PARAMETRO E A LISTA DE EMPRESAS
    //QUE VAI RETORNAR DA NOSSA BASE DE DADOS
    public LinhaConsultarProdutoAdapter(ConsultarActivity consultarActivity, List<ProdutoModel> produtoModels) {

        this.produtoModels = produtoModels;
        this.consultarActivity = consultarActivity;
        this.layoutInflater = (LayoutInflater) this.consultarActivity.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        this.produtoRepository = new ProdutoRepository(consultarActivity);
    }

    //RETORNA A QUANTIDADE DE REGISTROS DA LISTA
    @Override
    public int getCount() {

        return produtoModels.size();
    }

    @Override
    public Object getItem(int position) {
        return position;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    //ESSE MÉTODO SETA OS VALORES DE UM ITEM DA NOSSA LISTA DE EMPRESAS PARA UMA LINHA DO NOSSO LISVIEW
    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {


        //CRIANDO UM OBJETO DO TIPO View PARA ACESSAR O NOSSO ARQUIVO DE LAYOUT activity_linha_consultar.xml
        final View viewLinhaLista = layoutInflater.inflate(R.layout.activity_linha_consultar_produto, null);

        //VINCULANDO OS CAMPOS DO ARQUIVO DE LAYOUT(activity_linha_consultar.xml) AOS OBJETOS DECLARADOS.

        //CAMPO QUE VAI MOSTRAR O CÓDIGO DO PRODUTO
        TextView txtCodigo = (TextView) viewLinhaLista.findViewById(R.id.txtCodigo);

        //CAMPO QUE VAI MOSTRAR A EMPRESA DO PRODUTO
        TextView txtEmpresa = (TextView) viewLinhaLista.findViewById(R.id.txtEmpresa);

        //CAMPO QUE VAI MOSTRAR NOME DO PRODUTO
        TextView txtnomeproduto = (TextView) viewLinhaLista.findViewById(R.id.txtNomeProduto);

        //CAMPO QUE VAI MOSTRAR DESCRIÇÃO DO PRODUTO
        TextView txtdescricao = (TextView) viewLinhaLista.findViewById(R.id.txtDescricao);

        //CAMPO QUE VAI MOSTRAR O APELIDO DO PRODUTO
        TextView txtApelido = (TextView) viewLinhaLista.findViewById(R.id.txtApelido);

        //CAMPOS QUE VAI MOSTRAR O GRUPO DO PRODUTO
        TextView txtGrupo = (TextView) viewLinhaLista.findViewById(R.id.txtGrupo);

        //CAMPO QUE VAI MOSTRAR O SUBGRUPO DO PRODUTO
        TextView txtSubGrupo = (TextView) viewLinhaLista.findViewById(R.id.txtSubGroupo);

        //CAMPO QUE VAI MOSTRAR A COLOEÇÃO
        TextView txtColecao = (TextView) viewLinhaLista.findViewById(R.id.txtColecao);

        //CAMPO QUE VAI MOSTRAR A SITUAÇÃO DO PRODUTO
        TextView txtSituacao = (TextView) viewLinhaLista.findViewById(R.id.txtSituacao);

        //CAMPO QUE VAI MOSTRAR O PESO LIQUIDO
        TextView txtPesoLiq = (TextView) viewLinhaLista.findViewById(R.id.txtPesoLiq);

        //CAMPO QUE VAI MOSTRAR A CLASSIFICAÇÃO FISCAL DO PRODUTO
        TextView txtClassFiscal = (TextView) viewLinhaLista.findViewById(R.id.txtClassFiscal);

        //CAMPO QUE VAI MOSTRAR O CODIGO DE BARRAS DO PRODUTO
        TextView txtCodBar = (TextView) viewLinhaLista.findViewById(R.id.txtCodBar);

        //CAMPOS QUE VAI MOSTRAR SE O REGISTRO ESTÁ ATIVO OU NÃO
        TextView textViewRegsitroAtivo = (TextView) viewLinhaLista.findViewById(R.id.textViewRegistroAtivo);

        //CRIANDO O BOTÃO  EXCLUIR PARA DELETARMOS UM REGISTRO DO BANCO DE DADOS
        Button buttonVoltar = (Button) viewLinhaLista.findViewById(R.id.buttonVoltar);

        //CRIANDO O BOTÃO  EXCLUIR PARA DELETARMOS UM REGISTRO DO BANCO DE DADOS
        Button buttonExcluir = (Button) viewLinhaLista.findViewById(R.id.buttonExcluir);

        //CRIANDO O BOTÃO PARA EDITAR UM REGISTRO CADASTRADO
        final Button buttonEditar = (Button) viewLinhaLista.findViewById(R.id.buttonEditar);

        //SETANDO O CÓDIGO NO CAMPO DA NOSSA VIEW
        txtCodigo.setText(String.valueOf(produtoModels.get(position).getCodigo()));

        //SETANDO EMPRESA NO CAMPO DA NOSSA VIEW
        txtEmpresa.setText(produtoModels.get(position).getEmpresa());

        //SETANDO O NOME DO PRODUTO NO CAMPO DA NOSSA VIEW
        txtnomeproduto.setText(produtoModels.get(position).getNomeProduto());

        //SETANDO A DESCRIÇÃO NO CAMPO DA NOSSA VIEW
        txtdescricao.setText(produtoModels.get(position).getDescricao());

        //SETANDO O APELIDO NO CAMPO DA NOSSA VIEW
        txtApelido.setText(produtoModels.get(position).getApelido());

        //SETANDO O GRUPO NO CAMPO DA NOSSA VIEW
        txtGrupo.setText(produtoModels.get(position).getGrupo());

        //SETANDO O SUBGRUPO NO CAMPO DA NOSSA VIEW
        txtSubGrupo.setText(produtoModels.get(position).getSubGrupo());

        //SETANDO A COLEÇÃO NO CAMPO DA NOSSA VIEW
        txtColecao.setText(produtoModels.get(position).getColecao());

        //SETANDO A SITUAÇÃO NO CAMPO DA NOSSA VIEW
        txtSituacao.setText(produtoModels.get(position).getSituacao());

        //SETANDO O PESO LIQUIDO NO CAMPO DA NOSSA VIEW
        txtPesoLiq.setText(produtoModels.get(position).getPesoLiq());

        //SETANDO A CLASSIFICAÇÃO FISCAL CAMPO DA NOSSA VIEW
        txtClassFiscal.setText(produtoModels.get(position).getClassFiscal());

        //SETANDO O CODIGO DE BARRAS NO CAMPO DA NOSSA VIEW
        txtCodBar.setText(produtoModels.get(position).getCodBar());

        //SETANDO SE O REGISTRO ESTA ATIVO OU NÃO
        if (produtoModels.get(position).getAtivo() == 1)
            textViewRegsitroAtivo.setText("Registro Ativo:Sim");
        else
            textViewRegsitroAtivo.setText("Registro Ativo:Não");

        //CRIANDO EVENTO CLICK PARA O BOTÃO DE VOLTAR
        buttonVoltar.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                //REDIRECIONA PARA A TELA PRINCIPAL
                Intent intentMainActivity = new Intent(consultarActivity.getApplicationContext(), ConsultarActivity.class);
                consultarActivity.startActivity();

                //FINALIZA A ATIVIDADE ATUAL
                consultarActivity.finish();
            }
        });

        //CRIANDO EVENTO CLICK PARA O BOTÃO DE EXCLUIR REGISTRO
        buttonExcluir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                //EXCLUINDO UM REGISTRO
                produtoRepository.Excluir(produtoModels.get(position).getCodigo());

                //MOSTRA A MENSAGEM APÓS EXCLUIR UM REGISTRO
                Toast.makeText(consultarActivity, "Registro excluido com sucesso!", Toast.LENGTH_LONG).show();

                //CHAMA O MÉTODO QUE ATUALIZA A LISTA COM OS REGISTROS QUE AINDA ESTÃO NA BASE
                AtualizarLista();

            }
        });

        //CRIANDO EVENTO CLICK PARA O BOTÃO QUE VAI REDIRECIONAR PARA A TELA DE EDIÇÃO
        // DO REGISTRO.
        buttonEditar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                buttonEditar.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {


                        Intent intentRedirecionar = new Intent(consultarActivity, EditarProdutoActivity.class);

                        intentRedirecionar.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);

                        intentRedirecionar.putExtra("id_produto", produtoModels.get(position).getCodigo());

                        consultarActivity.startActivity(intentRedirecionar);

                        consultarActivity.finish();


                    }
                });


            }
        });


        return viewLinhaLista;
    }


    //ATUALIZA A LISTTA DEPOIS DE EXCLUIR UM REGISTRO
    public void AtualizarLista() {

        this.produtoModels.clear();
        this.produtoModels = produtoRepository.SelecionarTodos();
        this.notifyDataSetChanged();
    }
}
