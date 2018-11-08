package br.edu.up.recyclerlist01;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


public class CadastroActivity extends AppCompatActivity {

    private EditText edtNome;
    private EditText edtFone;
    private EditText edtEmail;
    private EditText edtEndereco;
    private Button btnSalvar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastro);

        edtNome     = findViewById(R.id.edtNome);
        edtFone     = findViewById(R.id.edtFone);
        edtEmail    = findViewById(R.id.edtEmail);
        edtEndereco = findViewById(R.id.edtEndereco);
        btnSalvar   = findViewById(R.id.btnSalvar);

        btnSalvar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if(edtNome.getText().toString().isEmpty()  ||
                   edtFone.getText().toString().isEmpty()  ||
                   edtEmail.getText().toString().isEmpty() ||
                   edtEndereco.getText().toString().isEmpty() )
                {
                    Toast.makeText(CadastroActivity.this, "Preencha todos os campos", Toast.LENGTH_SHORT).show();
                }
                else
                {
                    String nome  = edtNome.getText().toString();
                    String fone  = edtFone.getText().toString();
                    String email = edtEmail.getText().toString();
                    String ende  = edtEndereco.getText().toString();

                    Contato c = new Contato(nome, fone, email, ende);

                    ContatoLista.addContato(c);

                    Toast.makeText(CadastroActivity.this, "Contato salvo!", Toast.LENGTH_SHORT).show();

                    startActivity(new Intent(CadastroActivity.this, MainActivity.class));

                }
            }
        });



    }
}
