package br.edu.up.recyclerlist01;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class DetalhesActivity extends AppCompatActivity {

    TextView txtNome;
    TextView txtFone;
    TextView txtEmail;
    TextView txtEndereco;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalhes);

        txtNome     = findViewById(R.id.txtNome);
        txtFone     = findViewById(R.id.txtFone);
        txtEmail    = findViewById(R.id.txtEmail);
        txtEndereco = findViewById(R.id.txtEndereco);

        Intent intent = getIntent();

        Bundle bundle = intent.getExtras();

        String nome     = bundle.getString("nome");
        String fone     = bundle.getString("fone");
        String email    = bundle.getString("email");
        String endereco = bundle.getString("endereco");

        txtNome.setText("Nome: " + nome);
        txtFone.setText("Telefone: " + fone);
        txtEmail.setText("E-mail: " + email);
        txtEndereco.setText("Endereço: " + endereco);




    }
}
