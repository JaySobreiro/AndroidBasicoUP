package com.example.ti.cadastrobd;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    private Button btnCadastrar;
    private RecyclerView rclDisciplinas;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnCadastrar = findViewById(R.id.btnCadastrar);
        rclDisciplinas = findViewById(R.id.rclDisciplinas);


        // se a lista nao está vazia
        if (ListaDisciplinas.getListaDisciplinas().size() > 0)
        {
            // limpar lista:
            ListaDisciplinas.getListaDisciplinas().clear();
        }

        // carrega a lista com os dados da tabela 'disciplinas':
        DisciplinaDAO dao = new DisciplinaDAO(MainActivity.this);
        dao.getDisciplinas();

        DisciplinasAdapter adapter = new DisciplinasAdapter(
                ListaDisciplinas.getListaDisciplinas(),
                MainActivity.this
        );

        rclDisciplinas.setAdapter(adapter);

        RecyclerView.LayoutManager layout = new LinearLayoutManager(
                MainActivity.this,
                LinearLayoutManager.VERTICAL,
                false
        );


        rclDisciplinas.setLayoutManager(layout);

        btnCadastrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(), CadastrarActivity.class));
            }
        });




    }
}
