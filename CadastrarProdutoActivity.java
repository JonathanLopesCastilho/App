package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

import com.example.myapplication.Uteis.Uteis;
import com.example.myapplication.model.ProdutoModel;
import com.example.myapplication.repository.ProdutoRepository;

public class CadastrarProdutoActivity extends AppCompatActivity {


    /*COMPONENTES DA TELA*/
    EditText edtCodigo;
    EditText edtEmpresa;
    EditText edtNomeProduto;
    EditText edtDescricao;
    EditText edtApelido;
    EditText edtGrupo;
    EditText edtSubGrupo;
    EditText edtSituacao;
    EditText edtPesoLiq;
    EditText edtClassFiscal;
    EditText edtCodBar;
    EditText edtColecao;
    CheckBox checkBoxRegistroAtivo;
    Button buttonSalvar;
    Button buttonVoltar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastrar_produto);


        //VINCULA OS COMPONENTES DA TELA COM OS DA ATIVIDADE
        this.CriarComponentes();

        //CRIA OS EVENTOS DOS COMPONENTES
        this.CriarEventos();

    }

    //VINCULA OS COMPONENTES DA TELA COM OS DA ATIVIDADE
    protected void CriarComponentes() {

        edtCodigo = (EditText) this.findViewById(R.id.edtCodigo);

        edtEmpresa = (EditText) this.findViewById(R.id.edtEmpresa);

        edtNomeProduto = (EditText) this.findViewById(R.id.edtNomeProduto);

        edtDescricao = (EditText) this.findViewById(R.id.edtDescricao);

        edtApelido = (EditText) this.findViewById(R.id.edtApelido);

        edtGrupo = (EditText) this.findViewById(R.id.edtGrupo);

        edtSubGrupo = (EditText) this.findViewById(R.id.edtSubGrupo);

        edtSituacao = (EditText) this.findViewById(R.id.edtSituacao);

        edtPesoLiq = (EditText) this.findViewById(R.id.edtPesoLiq);

        edtClassFiscal = (EditText) this.findViewById(R.id.edtClassFiscal);

        edtCodBar = (EditText) this.findViewById(R.id.edtCodBar);

        edtColecao = (EditText) this.findViewById(R.id.edtColecao);

        checkBoxRegistroAtivo = (CheckBox) this.findViewById(R.id.checkBoxRegistroAtivo);

        buttonSalvar = (Button) this.findViewById(R.id.buttonSalvar);

        buttonVoltar = (Button) this.findViewById(R.id.buttonVoltar);

    }

    //CRIA OS EVENTOS DOS COMPONENTES
    protected void CriarEventos() {


        //CRIANDO EVENTO NO BOTÃO SALVAR
        buttonSalvar.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                Salvar_onClick();
            }
        });

        //CRIANDO EVENTO NO BOTÃO VOLTAR
        buttonVoltar.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                Intent intentMainActivity = new Intent(getApplicationContext(), CadastrarActivity.class);
                startActivity(intentMainActivity);
                finish();
            }
        });
    }

    //VALIDA OS CAMPOS E SALVA AS INFORMAÇÕES NO BANCO DE DADOS
    protected void Salvar_onClick() {

        if (edtEmpresa.getText().toString().trim().equals("")) {

            Uteis.Alert(this, this.getString(R.string.empresa_obrigatorio));

            //FOCO NO CAMPO
            edtNomeProduto.requestFocus();
        }else if(edtNomeProduto.getText().toString().trim().equals("")) {

            Uteis.Alert(this, this.getString(R.string.nome_obrigatorio));


            edtNomeProduto.requestFocus();
        } else if (edtDescricao.getText().toString().trim().equals("")) {

            Uteis.Alert(this, this.getString(R.string.descricao_obrigatorio));

            edtDescricao.requestFocus();

        } else if (edtGrupo.getText().toString().trim().equals("")) {

            Uteis.Alert(this, this.getString(R.string.grupo_obrigatorio));

            edtGrupo.requestFocus();
        } else if (edtSubGrupo.getText().toString().trim().equals("")) {

            Uteis.Alert(this,this.getString(R.string.subgrupo_obrigatorio));

            edtSubGrupo.requestFocus();
        } else if (edtSituacao.getText().toString().trim().equals("")) {

            Uteis.Alert(this, this.getString(R.string.situacao_obrigatorio));

            edtSituacao.requestFocus();
        } else {


            /*CRIANDO UM OBJETO EMPRESA*/
            ProdutoModel produtoModel = new ProdutoModel();

            produtoModel.setCodigo(Integer.parseInt(edtCodigo.getText().toString()));

            /*SETANDO O VALOR DO CAMPO EMPRESA*/
            produtoModel.setEmpresa(edtEmpresa.getText().toString().trim());

            /*SETANDO VALOR NO CAMPO NOME DO PRODUTO*/
            produtoModel.setNomeProduto(edtNomeProduto.getText().toString().trim());

            /*SETANDO A DESCRIÇÃO*/
            produtoModel.setDescricao(edtDescricao.getText().toString().trim());

            /*SETANDO O APELIDO*/
            produtoModel.setApelido(edtApelido.getText().toString().trim());

            /*SETANDO O GRUPO*/
            produtoModel.setGrupo(edtGrupo.getText().toString().trim());

            /*SETANDO O SUBGRUPO*/
            produtoModel.setSubGrupo(edtSubGrupo.getText().toString().trim());

            /*SETANDO A SITUAÇÃO*/
            produtoModel.setSituacao(edtSituacao.getText().toString().trim());

            /*SETANDO O PESO LIQUIDO*/
            produtoModel.setPesoLiq(edtPesoLiq.getText().toString().trim());

            /*SETANDO A CLASSIFICAÇÃO FISCAL*/
            produtoModel.setClassFiscal(edtClassFiscal.getText().toString().trim());

            /*SETANDO O CODIGO DE BARRAS*/
            produtoModel.setCodBar(edtCodBar.getText().toString().trim());

            /*SETANDO A COLEÇÃO*/
            produtoModel.setColecao(edtColecao.getText().toString().trim());

            /*SETA O REGISTRO COMO INATIVO*/
            produtoModel.setAtivo((byte) 0);

            /*SE TIVER SELECIONADO SETA COMO ATIVO*/
            if (checkBoxRegistroAtivo.isChecked())
                produtoModel.setAtivo((byte) 1);

            /*SALVANDO UM NOVO REGISTRO*/
            new ProdutoRepository(this).Salvar(produtoModel);

            /*MENSAGEM DE SUCESSO!*/
            Uteis.Alert(this, this.getString(R.string.registro_salvo_sucesso));

            LimparCampos();
        }


    }

    //LIMPA OS CAMPOS APÓS SALVAR AS INFORMAÇÕES
    protected void LimparCampos() {


         edtCodigo.setText(null);
         edtEmpresa.setText(null);
         edtNomeProduto.setText(null);
         edtDescricao.setText(null);
         edtApelido.setText(null);
         edtGrupo.setText(null);
         edtSubGrupo.setText(null);
         edtSituacao.setText(null);
         edtPesoLiq.setText(null);
         edtClassFiscal.setText(null);
         edtCodBar.setText(null);
         edtColecao.setText(null);

        checkBoxRegistroAtivo.setChecked(false);
    }



}
