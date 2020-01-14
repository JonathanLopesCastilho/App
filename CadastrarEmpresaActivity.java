package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

import com.example.myapplication.Uteis.Uteis;
import com.example.myapplication.model.EmpresaModel;
import com.example.myapplication.repository.EmpresaRepository;

public class CadastrarEmpresaActivity extends AppCompatActivity {


    /*COMPONENTES DA TELA*/
    EditText edtCodigo;
    EditText edtNome;
    EditText edtRazaoSocial;
    EditText edtEndereco;
    EditText edtBairro;
    EditText edtCep;
    EditText edtCidade;
    EditText edtTelefone;
    EditText edtFax;
    EditText edtCnpj;
    EditText edtIE;
    CheckBox checkBoxRegistroAtivo;
    Button buttonSalvar;
    Button buttonVoltar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_editar_empresa);


        //VINCULA OS COMPONENTES DA TELA COM OS DA ATIVIDADE
        this.CriarComponentes();

        //CRIA OS EVENTOS DOS COMPONENTES
        this.CriarEventos();

    }

    //VINCULA OS COMPONENTES DA TELA COM OS DA ATIVIDADE
    protected void CriarComponentes() {

        edtCodigo = (EditText) this.findViewById(R.id.edtCodigo);

        edtNome = (EditText) this.findViewById(R.id.edtNome);

        edtRazaoSocial = (EditText) this.findViewById(R.id.edtRazaoSocial);

        edtEndereco = (EditText) this.findViewById(R.id.edtEndereco);

        edtBairro = (EditText) this.findViewById(R.id.edtBairro);

        edtCep = (EditText) this.findViewById(R.id.edtCep);

        edtCidade = (EditText) this.findViewById(R.id.edtCidade);

        edtTelefone = (EditText) this.findViewById(R.id.edtTelefone);

        edtFax = (EditText) this.findViewById(R.id.edtFax);

        edtCnpj = (EditText) this.findViewById(R.id.edtCnpj);

        edtIE = (EditText) this.findViewById(R.id.edtIE);

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

        if (edtNome.getText().toString().trim().equals("")) {

            Uteis.Alert(this, this.getString(R.string.nome_obrigatorio));

            //FOCO NO CAMPO
            edtNome.requestFocus();
        } else if (edtRazaoSocial.getText().toString().trim().equals("")) {

            Uteis.Alert(this, this.getString(R.string.razao_obrigatorio));

            edtRazaoSocial.requestFocus();

        } else if (edtEndereco.getText().toString().trim().equals("")) {

            Uteis.Alert(this, this.getString(R.string.endereco_obrigatorio));

            edtEndereco.requestFocus();
        } else if (edtBairro.getText().toString().trim().equals("")) {

            Uteis.Alert(this, this.getString(R.string.bairro_obrigatorio));

            edtBairro.requestFocus();
        } else if (edtCep.getText().toString().trim().equals("")) {

            Uteis.Alert(this, this.getString(R.string.cep_obrigatorio));

            edtCep.requestFocus();
        } else if (edtCidade.getText().toString().trim().equals("")) {

            Uteis.Alert(this, this.getString(R.string.cidade_obrigatorio));

            edtCidade.requestFocus();
        } else if (edtTelefone.getText().toString().trim().equals("")) {

            Uteis.Alert(this, this.getString(R.string.telefone_obrigatorio));

            edtTelefone.requestFocus();
        } else if (edtCnpj.getText().toString().trim().equals("")) {

            Uteis.Alert(this, this.getString(R.string.cnpj_obrigatorio));

            edtCnpj.requestFocus();
        } else if (edtIE.getText().toString().trim().equals("")) {

            Uteis.Alert(this, this.getString(R.string.ie_obrigatorio));

            edtIE.requestFocus();

        }else {


            /*CRIANDO UM OBJETO EMPRESA*/
            EmpresaModel empresaModel = new EmpresaModel();

            empresaModel.setCodigo(Integer.parseInt(edtCodigo.getText().toString()));

            /*SETANDO O VALOR DO CAMPO NOME*/
            empresaModel.setNomefantasia(edtNome.getText().toString().trim());

            /*SETANDO VALOR NO CAMPO RAZÃO SOCIAL*/
            empresaModel.setRazaoSocial(edtRazaoSocial.getText().toString().trim());

            /*SETANDO O ENDEREÇO*/
            empresaModel.setEndereco(edtEndereco.getText().toString().trim());

            /*SETANDO O BAIRRO*/
            empresaModel.setBairro(edtBairro.getText().toString().trim());

            /*SETANDO O CEP*/
            empresaModel.setCep(edtCep.getText().toString().trim());

            /*SETANDO O CIDADE*/
            empresaModel.setCidade(edtCidade.getText().toString().trim());

            /*SETANDO O TELEFONE*/
            empresaModel.setTelefone(edtTelefone.getText().toString().trim());

            /*SETANDO O FAX*/
            empresaModel.setFax(edtFax.getText().toString().trim());

            /*SETANDO O CNPJ*/
            empresaModel.setCnpj(edtCnpj.getText().toString().trim());

            /*SETANDO O IE*/
            empresaModel.setIe(edtIE.getText().toString().trim());

            /*SETA O REGISTRO COMO INATIVO*/
            empresaModel.setAtivo((byte) 0);

            /*SE TIVER SELECIONADO SETA COMO ATIVO*/
            if (checkBoxRegistroAtivo.isChecked())
                empresaModel.setAtivo((byte) 1);

            /*SALVANDO UM NOVO REGISTRO*/
            new EmpresaRepository(this).Salvar(empresaModel);

            /*MENSAGEM DE SUCESSO!*/
            Uteis.Alert(this, this.getString(R.string.registro_salvo_sucesso));

            LimparCampos();
        }


    }

    //LIMPA OS CAMPOS APÓS SALVAR AS INFORMAÇÕES
    protected void LimparCampos() {

         edtNome.setText(null);
         edtRazaoSocial.setText(null);
         edtEndereco.setText(null);
         edtBairro.setText(null);
         edtCep.setText(null);
         edtCidade.setText(null);
         edtTelefone.setText(null);
         edtFax.setText(null);
         edtCnpj.setText(null);
         edtIE.setText(null);


        checkBoxRegistroAtivo.setChecked(false);
    }



}
