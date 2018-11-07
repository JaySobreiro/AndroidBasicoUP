package br.edu.up.recyclerlist01;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    Button btnAddContato;
    RecyclerView rclContatos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnAddContato = findViewById(R.id.btnAddContato);
        rclContatos   = findViewById(R.id.rclContatos);

        // se a lista de contatos estiver vazia:
        if(ContatoLista.getLista().isEmpty()){
            ContatoLista.gerarLista();
        }

        // criar um novo adaptador para a recycler view
        ContatoAdapter contatoAdapter = new ContatoAdapter
                (
                       ContatoLista.getLista(),
               MainActivity.this
                );

        // setar adaptador criado para a recycler view
        rclContatos.setAdapter(contatoAdapter);

        // definir o layout de exibição
        RecyclerView.LayoutManager meuLayout = new LinearLayoutManager
                (
                 MainActivity.this,
                  LinearLayoutManager.VERTICAL,
                 false
                );

        // setar o layout de exibição para a recycler view
        rclContatos.setLayoutManager(meuLayout);


    }
}
