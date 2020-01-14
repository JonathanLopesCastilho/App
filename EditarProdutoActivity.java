package com.example.myapplication;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

import com.example.myapplication.Uteis.LinhaConsultarProdutoAdapter;
import com.example.myapplication.Uteis.Uteis;
import com.example.myapplication.model.ProdutoModel;
import com.example.myapplication.repository.ProdutoRepository;

public class EditarProdutoActivity extends AppCompatActivity {


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
        setContentView(R.layout.activity_editar_produto);


        //CHAMA O MÉTODO PARA CRIAR OS COMPONENTES DA TELA
        this.CriarComponentes();

        //CHAMA O MÉTODO QUE CRIA EVENTOS PARA OS COMPONENTES
        this.CriarEventos();

        //CARREGA OS VALORES NOS CAMPOS DA TELA.
        this.CarregaValoresCampos();
    }

    //VINCULA OS COMPONENTES DA TELA(VIEW) AOS OBJETOS DECLARADOS.
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

    //MÉTODO CRIA OS EVENTOS PARA OS COMPONENTES
    protected void CriarEventos() {

        //CRIANDO EVENTO CLICK PARA O BOTÃO ALTERAR
        buttonSalvar.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                Alterar_onClick();
            }
        });

        //CRIANDO EVENTO CLICK PARA O BOTÃO VOLTAR
        buttonVoltar.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                Intent intentMainActivity = new Intent(getApplicationContext(), LinhaConsultarProdutoAdapter.class);
                startActivity(intentMainActivity);
                finish();
            }
        });
    }

    //ALTERA UM REGISTRO
    protected void Alterar_onClick() {

        //VALIDA SE OS CAMPOS ESTÃO VAZIOS ANTES DE ALTERAR O REGISTRO
        if (edtEmpresa.getText().toString().trim().equals("")) {

            Uteis.Alert(this, this.getString(R.string.nome_obrigatorio));

            //FOCO NO CAMPO
            edtNomeProduto.requestFocus();
        }else if(edtNomeProduto.getText().toString().trim().equals("")) {

            Uteis.Alert(this, this.getString(R.string.nome_obrigatorio));


            edtNomeProduto.requestFocus();
        } else if (edtDescricao.getText().toString().trim().equals("")) {

            Uteis.Alert(this, this.getString(R.string.razao_obrigatorio));

            edtDescricao.requestFocus();

        } else if (edtGrupo.getText().toString().trim().equals("")) {

            Uteis.Alert(this, this.getString(R.string.bairro_obrigatorio));

            edtGrupo.requestFocus();
        } else if (edtSubGrupo.getText().toString().trim().equals("")) {

            Uteis.Alert(this, this.getString(R.string.cep_obrigatorio));

            edtSubGrupo.requestFocus();
        } else if (edtSituacao.getText().toString().trim().equals("")) {

            Uteis.Alert(this, this.getString(R.string.cidade_obrigatorio));

            edtSituacao.requestFocus();
        } else {


            /*CRIANDO UM OBJETO PRODUTO*/
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

            /*ALTERANDO O REGISTRO*/
            new ProdutoRepository(this).Atualizar(produtoModel);

            /*MENSAGEM DE SUCESSO!*/

            AlertDialog.Builder alertDialog = new AlertDialog.Builder(this);

            //ADICIONANDO UM TITULO A NOSSA MENSAGEM DE ALERTA
            alertDialog.setTitle(R.string.app_name);

            //MENSAGEM A SER EXIBIDA
            alertDialog.setMessage("Registro alterado com sucesso! ");

            //CRIA UM BOTÃO COM O TEXTO OK SEM AÇÃO
            alertDialog.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int id) {

                    //RETORNA PARA A TELA DE CONSULTA
                    Intent intentRedirecionar = new Intent(getApplicationContext(), ConsultarActivity.class);

                    startActivity(intentRedirecionar);

                    finish();
                }
            });

            //MOSTRA A MENSAGEM NA TELA
            alertDialog.show();


        }


    }



    //CARREGA OS VALORES NOS CAMPOS APÓS RETORNAR DO SQLITE
    protected void CarregaValoresCampos() {

        ProdutoRepository produtoRepository = new ProdutoRepository(this);


        //PEGA O ID Empresa QUE FOI PASSADO COMO PARAMETRO ENTRE AS TELAS
        Bundle extra = this.getIntent().getExtras();
        int id_produto = extra.getInt("id_produto");

        //CONSULTA UMA EMPRESA POR ID
        ProdutoModel produtoModel = produtoRepository.GetPessoa(id_produto);

        //SETA O CÓDIGO NA VIEW
        edtCodigo.setText(String.valueOf(produtoModel.getCodigo()));

        //SETA A EMPRESA NA VIEW
        edtEmpresa.setText(produtoModel.getEmpresa());

        //SETA O NOME DO PRODUTO NA VIEW
        edtNomeProduto.setText(produtoModel.getNomeProduto());

        //SETA A DESCRIÇÃO NA VIEW
        edtDescricao.setText(produtoModel.getDescricao());

        //SETA O APELIDO NA VIEW
        edtApelido.setText(produtoModel.getApelido());

        //SETA O GRUPO NA VIEW
        edtGrupo.setText(produtoModel.getGrupo());

        //SETA O SUBGRUPO NA VIEW
        edtSubGrupo.setText(produtoModel.getSubGrupo());

        //SETA A SITUAÇÃO NA VIEW
        edtSituacao.setText(produtoModel.getSituacao());

        //SETA O PESO lIQUIDO NA VIEW
        edtPesoLiq.setText(produtoModel.getPesoLiq());

        //SETA A CLASSIFICAÇÃO FISCAL NA VIEW
        edtClassFiscal.setText(produtoModel.getClassFiscal());

        //SETA O CODIGO DE BARRAS NA VIEW
        edtCodBar.setText(produtoModel.getCodBar());

        //SETA A COLEÇÃO NA VIEW
        edtColecao.setText(produtoModel.getColecao());

        //SETA SE O  REGISTRO ESTÁ ATIVO
        if (produtoModel.getAtivo() == 1)
            checkBoxRegistroAtivo.setChecked(true);
    }
}
