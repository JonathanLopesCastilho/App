package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.myapplication.Uteis.Uteis;
import com.example.myapplication.model.EmpresaModel;
import com.example.myapplication.repository.EmpresaRepository;

public class CadastrarActivity extends AppCompatActivity {

    ListView listViewOpcoes;


    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);


        setContentView(R.layout.activity_cadastrar);


        this.CriarComponentes();

        this.CriarEventos();


        this.CarregaOpcoesLista();

    }


    protected void CriarEventos() {

        listViewOpcoes.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                String opcaoMenu = ((TextView) view).getText().toString();

                RedirecionaTela(opcaoMenu);


            }
        });
    }

    //REDIRECIONA PARA A TELA SELECIONADA NO MENU
    protected void RedirecionaTela(String opcaoMenu) {

        Intent intentRedirecionar;

        if (opcaoMenu.equals("Cadastrar Empresa")) {

            intentRedirecionar = new Intent(this, CadastrarEmpresaActivity.class);
            startActivity(intentRedirecionar);
            finish();
        } else if (opcaoMenu.equals("Cadastrar Produto")) {

            intentRedirecionar = new Intent(this, CadastrarProdutoActivity.class);
            startActivity(intentRedirecionar);
            finish();
        } else
            Toast.makeText(getApplicationContext(), "Opção inválida!", Toast.LENGTH_SHORT).show();

    }


    //VINCULA O COMPONENTE DA NOSSA TELA AO OBJETO DA NOSSA ATIVIDADE
    protected void CriarComponentes() {

        //VINCULANDO A LISTA DA TELA AO LISTVIEW QUE DECLARAMOS
        listViewOpcoes = (ListView) this.findViewById(R.id.lVOpcoes);
    }

    //CRIA A OPÇÕES DA NOSSA LISTA E ADICIONA AO LISTVIEW DA NOSSA TELA.
    protected void CarregaOpcoesLista() {

        String[] itens = new String[2];

        itens[0] = "Cadastrar Empresa";
        itens[1] = "Cadastrar Produto";

        ArrayAdapter<String> arrayItens = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, itens);


        listViewOpcoes.setAdapter(arrayItens);

    }

}