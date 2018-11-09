package br.edu.up.recyclerlist01;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class DetalhesActivity extends AppCompatActivity {

    TextView txtNome;
    TextView txtFone;
    TextView txtEmail;
    TextView txtEndereco;
    Button   btnDeletar;
    Button   btnEditar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalhes);

        txtNome     = findViewById(R.id.txtNome);
        txtFone     = findViewById(R.id.txtFone);
        txtEmail    = findViewById(R.id.txtEmail);
        txtEndereco = findViewById(R.id.txtEndereco);
        btnDeletar  = findViewById(R.id.btnDeletar);
        btnEditar   = findViewById(R.id.btnEditar);

        final Intent intent = getIntent();

        final Bundle bundle = intent.getExtras();

        final int index       = bundle.getInt("index");
        String nome     = bundle.getString("nome");
        String fone     = bundle.getString("fone");
        String email    = bundle.getString("email");
        String endereco = bundle.getString("endereco");

        txtNome.setText("Nome: " + nome);
        txtFone.setText("Telefone: " + fone);
        txtEmail.setText("E-mail: " + email);
        txtEndereco.setText("Endereço: " + endereco);

        btnDeletar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                ContatoLista.deletarContato(index);
                Toast.makeText(DetalhesActivity.this, "Contato Excluído!", Toast.LENGTH_SHORT).show();
                startActivity(new Intent(DetalhesActivity.this, MainActivity.class));
            }
        });

        btnEditar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent editar = new Intent(DetalhesActivity.this, CadastroActivity.class);
                editar.putExtras(bundle);
                startActivity(editar);
            }
        });



    }
}
