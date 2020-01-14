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

import com.example.myapplication.Uteis.LinhaConsultarEmpresaAdapter;
import com.example.myapplication.Uteis.Uteis;
import com.example.myapplication.model.EmpresaModel;
import com.example.myapplication.repository.EmpresaRepository;

public class EditarEmpresaActivity extends AppCompatActivity {


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

                Intent intentMainActivity = new Intent(getApplicationContext(), LinhaConsultarEmpresaAdapter.class);
                startActivity(intentMainActivity);
                finish();
            }
        });
    }

    //ALTERA UM REGISTRO
    protected void Alterar_onClick() {

        //VALIDA SE OS CAMPOS ESTÃO VAZIOS ANTES DE ALTERAR O REGISTRO
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

        } else {


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

            /*ALTERANDO O REGISTRO*/
            new EmpresaRepository(this).Atualizar(empresaModel);

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

        EmpresaRepository empresaRepository = new EmpresaRepository(this);


        //PEGA O ID Empresa QUE FOI PASSADO COMO PARAMETRO ENTRE AS TELAS
        Bundle extra = this.getIntent().getExtras();
        int id_empresa = extra.getInt("id_empresa");

        //CONSULTA UMA EMPRESA POR ID
        EmpresaModel empresaModel = empresaRepository.GetEmpresa(id_empresa);

        //SETA O CÓDIGO NA VIEW
        edtCodigo.setText(String.valueOf(empresaModel.getCodigo()));

        //SETA O NOME NA VIEW
        edtNome.setText(empresaModel.getNomefantasia());

        //SETA A RAZÃO SOCIAL NA VIEW
        edtRazaoSocial.setText(empresaModel.getRazaoSocial());

        //SETA O ENDEREÇO NA VIEW
        edtEndereco.setText(empresaModel.getEndereco());

        //SETA O BAIRRO NA VIEW
        edtBairro.setText(empresaModel.getBairro());

        //SETA O CEP NA VIEW
        edtCep.setText(empresaModel.getCep());

        //SETA A CIDADE NA VIEW
        edtCidade.setText(empresaModel.getCidade());

        //SETA O TELEFONE NA VIEW
        edtTelefone.setText(empresaModel.getTelefone());

        //SETA O FAX NA VIEW
        edtFax.setText(empresaModel.getFax());

        //SETA O CNPJ NA VIEW
        edtCnpj.setText(empresaModel.getCnpj());

        //SETA O IE NA VIEW
        edtIE.setText(empresaModel.getIe());

        //SETA SE O  REGISTRO ESTÁ ATIVO
        if (empresaModel.getAtivo() == 1)
            checkBoxRegistroAtivo.setChecked(true);
    }
}
