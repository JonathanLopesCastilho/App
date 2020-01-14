package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.myapplication.Uteis.LinhaConsultarEmpresaAdapter;
import com.example.myapplication.model.EmpresaModel;
import com.example.myapplication.repository.EmpresaRepository;

import java.util.List;

public class ConsultarActivity extends AppCompatActivity {

    //CRIANDO UM OBJETO DO TIPO ListView PARA RECEBER OS REGISTROS DE UM ADAPTER
    ListView lVEmpresas;

    //CRIANDO O BOTÃO VOLTAR PARA RETORNAR PARA A TELA COM AS OPÇÕES
    Button buttonVoltar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_consultar);

        //VINCULANDO O LISTVIEW DA TELA AO OBJETO CRIADO
        lVEmpresas = (ListView) this.findViewById(R.id.lVEmpresas);

        //VINCULANDO O BOTÃO VOLTAR DA TELA AO OBJETO CRIADO
        buttonVoltar = (Button) this.findViewById(R.id.buttonVoltar);


        //CHAMA O MÉTODO QUE CARREGA AS EMPRESAS CADASTRADAS NA BASE DE DADOS
        this.CarregarEmpresasCadastradas();

        //CHAMA O MÉTODO QUE CRIA O EVENTO PARA O BOTÃO VOLTAR
        this.CriarEvento();
    }

    //MÉTODO QUE CRIA EVENTO PARA O BOTÃO VOLTAR
    protected void CriarEvento() {

        buttonVoltar.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                //REDIRECIONA PARA A TELA PRINCIPAL
                Intent intentMainActivity = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(intentMainActivity);

                //FINALIZA A ATIVIDADE ATUAL
                finish();
            }
        });
    }

    //MÉTODO QUE CONSULTA AS PESSOAS CADASTRADAS
    protected void CarregarEmpresasCadastradas() {

        EmpresaRepository empresaRepository = new EmpresaRepository(this);

        //BUSCA AS PESSOAS CADASTRADAS
        List<EmpresaModel> empresas = empresaRepository.SelecionarTodos();

        //SETA O ADAPTER DA LISTA COM OS REGISTROS RETORNADOS DA BASE
        lVEmpresas.setAdapter(new LinhaConsultarEmpresaAdapter(this, empresas));
    }

    public void startActivity() {
    }
}


