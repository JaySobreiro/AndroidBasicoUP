package br.edu.up.recyclerlist01;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;


public class CadastroActivity extends AppCompatActivity {

    private EditText edtNome;
    private EditText edtFone;
    private EditText edtEmail;
    private EditText edtEndereco;
    private TextView txtTitulo;
    private Button btnSalvar;

    private boolean editar; // VERIFICARÁ SE É EDIÇÃO OU CADASTRO
    private int index; // RECEBERÁ POSIÇÃO NA LISTA DO OBJETO A SER EDITADO

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastro);

        edtNome = findViewById(R.id.edtNome);
        edtFone = findViewById(R.id.edtFone);
        edtEmail = findViewById(R.id.edtEmail);
        edtEndereco = findViewById(R.id.edtEndereco);
        txtTitulo = findViewById(R.id.txtTitulo);
        btnSalvar = findViewById(R.id.btnSalvar);

        Intent intent = getIntent(); // RECEBE UMA INTENT
        Bundle bundle = intent.getExtras(); // TENTA RECEBER UM BUNDLE DESSA INTENT


        // ESTA ACTIVITY PODE SER ACESSADA ATRAVÉS DE DUAS ASCTIVITIES: MAIN ou DETALHES.
        // SE VIER DA MAIN, NÃO RECEBERÁ NENHUM DADO EXTRA (BUNDLE). LOGO, O BUNDLE CRIADO ACIMA SERÁ NULO.
        // SE VIER DA DETALHES, RECEBERÁ EXTRA COM OS DADOS DO OBJETO QUE SERÁ EDITADO.

        if (bundle != null) {
            // SE RECEBEU UM BUNDLE, ENTÃO A AÇÃO DESEJADA É 'EDITAR'
            editar = true;

            // CARREGA DADOS DO BUNDLE PARA VARIAVEIS LOCAIS
            index = bundle.getInt("index");
            String nome = bundle.getString("nome");
            String fone = bundle.getString("fone");
            String email = bundle.getString("email");
            String endereco = bundle.getString("endereco");

            /// SETA O VALOR DOS  CAMPOS DE TEXTO COM OS VALORES DO OBJETO QUE SE DESEJA ALTERAR
            edtNome.setText(nome);
            edtFone.setText(fone);
            edtEmail.setText(email);
            edtEndereco.setText(endereco);
            // ALTERA TEXTOS DO TITULO E DO BOTÃO, PARA CONDIZER COM A AÇÃO DE EDITAR, E NÃO CADASTRAR
            btnSalvar.setText("ATUALIZAR CONTATO");
            txtTitulo.setText("EDITAR CONTATO");

        } else {
            editar = false; // SE O BUNDLE RETORNOU NULO, ENTÃO A AÇÃO É CADASTRAR, NÃO EDITAR
        }


        btnSalvar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                // SE ALGUM CAMPO ESTIVER VAZIO
                if (edtNome.getText().toString().isEmpty() ||
                        edtFone.getText().toString().isEmpty() ||
                        edtEmail.getText().toString().isEmpty() ||
                        edtEndereco.getText().toString().isEmpty()) {
                    // MSG DE ERRO
                    Toast.makeText(CadastroActivity.this, "Preencha todos os campos", Toast.LENGTH_SHORT).show();

                } else {//SENAO

                    // VARIAVEIS LOCAIS RECEBEM DADOS DOS CAMPOS DE EDIÇÃO
                    String nome = edtNome.getText().toString();
                    String fone = edtFone.getText().toString();
                    String email = edtEmail.getText().toString();
                    String ende = edtEndereco.getText().toString();

                    if (editar) { // SE A AÇÃO FOR EDITAR, O COMPORTAMENTO DO BTN SALVAR SERÁ DIFERENTE

                        // RECEBE OBJETO DA LISTA NA POSIÇÃO ESPECIFICADA PELA VARIAVEL INDEX
                        Contato edt = ContatoLista.getContato(index);

                        // SETA OBJETO RECEBIDO COM OS VALORES PREENCHIDOS NOS CAMPOS DE EDIÇÃO.
                        // COMO ESTE OBJETO 'edt' É UM CLONE DO OBJETO NA POSIÇÃO 'index' DA LISTA DE CONTATOS,
                        // AO ALTERAR O OBJETO 'edt" O OBJETO ORIGINAL NA LISTA TAMBÉM SERÁ ALTERADO!
                        edt.setNome(nome);
                        edt.setFone(fone);
                        edt.setEmail(email);
                        edt.setEndereco(ende);
                        // MSG DE SUCESSO
                        Toast.makeText(CadastroActivity.this, "Contato editado!", Toast.LENGTH_SHORT).show();
                        // VOLTA PRA MAIN
                        startActivity(new Intent(CadastroActivity.this, MainActivity.class));

                    } else { // SENÃO, A AÇÃO DO BOTÃO É DE CADASTRAR

                        Contato c = new Contato(nome, fone, email, ende);

                        ContatoLista.addContato(c);

                        Toast.makeText(CadastroActivity.this, "Contato salvo!", Toast.LENGTH_SHORT).show();

                        startActivity(new Intent(CadastroActivity.this, MainActivity.class));
                    }
                }
            }
        });


    }
}
