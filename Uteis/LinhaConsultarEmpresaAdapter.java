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
import com.example.myapplication.R;
import com.example.myapplication.model.EmpresaModel;
import com.example.myapplication.repository.EmpresaRepository;

import java.util.ArrayList;
import java.util.List;


public class LinhaConsultarEmpresaAdapter extends BaseAdapter {

    //CRIANDO UM OBJETO LayoutInflater PARA FAZER LINK A NOSSA VIEW(activity_linha_consultar_empresa.xml)
    private static LayoutInflater layoutInflater = null;

    //CRIANDO UMA LISTA DE EMPRESAS
    List<EmpresaModel> empresaModels = new ArrayList<EmpresaModel>();

    //CIRANDO UM OBJETO DA NOSSA CLASSE QUE FAZ ACESSO AO BANCO DE DADOS
    EmpresaRepository empresaRepository;

    //CRIANDO UM OBJETO DA NOSSA ATIVIDADE QUE CONTEM A LISTA
    private ConsultarActivity consultarActivity;

    //CONSTRUTOR QUE VAI RECEBER A NOSSA ATIVIDADE COMO PARAMETRO E A LISTA DE EMPRESAS
    //QUE VAI RETORNAR DA NOSSA BASE DE DADOS
    public LinhaConsultarEmpresaAdapter(ConsultarActivity consultarActivity, List<EmpresaModel> empresaModels) {

        this.empresaModels = empresaModels;
        this.consultarActivity = consultarActivity;
        this.layoutInflater = (LayoutInflater) this.consultarActivity.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        this.empresaRepository = new EmpresaRepository(consultarActivity);
    }

    //RETORNA A QUANTIDADE DE REGISTROS DA LISTA
    @Override
    public int getCount() {

        return empresaModels.size();
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
        final View viewLinhaLista = layoutInflater.inflate(R.layout.activity_linha_consultar_empresa, null);

        //VINCULANDO OS CAMPOS DO ARQUIVO DE LAYOUT(activity_linha_consultar.xml) AOS OBJETOS DECLARADOS.

        //CAMPO QUE VAI MOSTRAR O CÓDIGO DA EMPRESA
        TextView txtCodigo = (TextView) viewLinhaLista.findViewById(R.id.txtCodigo);

        //CAMPO QUE VAI MOSTRAR O NOME DA EMPRESA
        TextView txtNome = (TextView) viewLinhaLista.findViewById(R.id.txtNome);

        //CAMPO QUE VAI MOSTRAR A RAZÃO SOCIAL DA EMPRESA
        TextView txtRazaoSocial = (TextView) viewLinhaLista.findViewById(R.id.txtRazaoSocial);

        //CAMPO QUE VAI MOSTRAR O ENDEREÇO DA EMPRESA
        TextView txtEndereco = (TextView) viewLinhaLista.findViewById(R.id.txtEndereco);

        //CAMPO QUE VAI MOSTRAR O BAIRRO DA EMPRESA
        TextView txtBairro = (TextView) viewLinhaLista.findViewById(R.id.txtBairro);

        //CAMPOS QUE VAI MOSTRAR O CEP DA EMPRESA
        TextView txtCep = (TextView) viewLinhaLista.findViewById(R.id.txtCep);

        //CAMPO QUE VAI MOSTRAR A CIDADE DA EMPRESA
        TextView txtCidade = (TextView) viewLinhaLista.findViewById(R.id.txtCidade);

        //CAMPO QUE VAI MOSTRAR O TELEFONE DA EMPRESA
        TextView txtTelefone = (TextView) viewLinhaLista.findViewById(R.id.txtTelefone);

        //CAMPO QUE VAI MOSTRAR O FAX DA EMPRESA
        TextView txtFax = (TextView) viewLinhaLista.findViewById(R.id.txtFax);

        //CAMPO QUE VAI MOSTRAR O CNPJ DA EMPRESA
        TextView txtCnpj = (TextView) viewLinhaLista.findViewById(R.id.txtCnpj);

        //CAMPO QUE VAI MOSTRAR O IE DA EMPRESA
        TextView txtIE = (TextView) viewLinhaLista.findViewById(R.id.txtIe);

        //CAMPOS QUE VAI MOSTRAR SE O REGISTRO ESTÁ ATIVO OU NÃO
        TextView textViewRegsitroAtivo = (TextView) viewLinhaLista.findViewById(R.id.textViewRegistroAtivo);

        //CRIANDO O BOTÃO  EXCLUIR PARA DELETARMOS UM REGISTRO DO BANCO DE DADOS
        Button buttonVoltar = (Button) viewLinhaLista.findViewById(R.id.buttonVoltar);

        //CRIANDO O BOTÃO  EXCLUIR PARA DELETARMOS UM REGISTRO DO BANCO DE DADOS
        Button buttonExcluir = (Button) viewLinhaLista.findViewById(R.id.buttonExcluir);

        //CRIANDO O BOTÃO PARA EDITAR UM REGISTRO CADASTRADO
        final Button buttonEditar = (Button) viewLinhaLista.findViewById(R.id.buttonEditar);


        //SETANDO O CÓDIGO NO CAMPO DA NOSSA VIEW
        txtCodigo.setText(String.valueOf(empresaModels.get(position).getCodigo()));

        //SETANDO O NOME NO CAMPO DA NOSSA VIEW
        txtNome.setText(empresaModels.get(position).getNomefantasia());

        //SETANDO A RAZÃO SOCIAL NO CAMPO DA NOSSA VIEW
        txtRazaoSocial.setText(empresaModels.get(position).getRazaoSocial());

        //SETANDO O ENDEREÇO NO CAMPO DA NOSSA VIEW
        txtEndereco.setText(empresaModels.get(position).getEndereco());

        //SETANDO O BAIRRO NO CAMPO DA NOSSA VIEW
        txtBairro.setText(empresaModels.get(position).getBairro());

        //SETANDO O CEP NO CAMPO DA NOSSA VIEW
        txtCep.setText(empresaModels.get(position).getCep());

        //SETANDO A CIDADE NO CAMPO DA NOSSA VIEW
        txtCidade.setText(empresaModels.get(position).getCidade());

        //SETANDO O TELEFONE NO CAMPO DA NOSSA VIEW
        txtTelefone.setText(empresaModels.get(position).getTelefone());

        //SETANDO O FAX NO CAMPO DA NOSSA VIEW
        txtFax.setText(empresaModels.get(position).getFax());

        //SETANDO O CNPJ NO CAMPO DA NOSSA VIEW
        txtCnpj.setText(empresaModels.get(position).getCnpj());

        //SETANDO O IE NO CAMPO DA NOSSA VIEW
        txtIE.setText(empresaModels.get(position).getIe());

        //SETANDO SE O REGISTRO ESTA ATIVO OU NÃO
        if (empresaModels.get(position).getAtivo() == 1)
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
                empresaRepository.Excluir(empresaModels.get(position).getCodigo());

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


                        Intent intentRedirecionar = new Intent(consultarActivity, EditarEmpresaActivity.class);

                        intentRedirecionar.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);

                        intentRedirecionar.putExtra("id_pessoa", empresaModels.get(position).getCodigo());

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

        this.empresaModels.clear();
        this.empresaModels = empresaRepository.SelecionarTodos();
        this.notifyDataSetChanged();
    }
}
