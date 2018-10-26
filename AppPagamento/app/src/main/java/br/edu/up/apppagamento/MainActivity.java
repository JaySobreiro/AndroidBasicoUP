package br.edu.up.apppagamento;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity {

    private EditText edtNome;
    private EditText edtHorasTrab;
    private EditText edtValorHora;
    private Button   btnCalcular;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        edtNome      = findViewById(R.id.edtNome);
        edtHorasTrab = findViewById(R.id.edtHorasTrab);
        edtValorHora = findViewById(R.id.edtValorHora);
        btnCalcular  = findViewById(R.id.btnCalcular);


        btnCalcular.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if(edtNome.getText().toString().isEmpty() ||
                        edtHorasTrab.getText().toString().isEmpty() ||
                        edtValorHora.getText().toString().isEmpty())
                {
                    Toast.makeText(MainActivity.this, "Preencha todos os campos", Toast.LENGTH_SHORT).show();
                }else{

                    String nome = edtNome.getText().toString();
                    int horastrab = Integer.parseInt(edtHorasTrab.getText().toString());
                    float valorHora = Float.parseFloat(edtValorHora.getText().toString());

                    Bundle bundle = new Bundle();
                    bundle.putString("nome", nome);
                    bundle.putInt("horasTrab", horastrab);
                    bundle.putFloat("valorHora", valorHora);

                    Intent intentPagamento = new Intent(MainActivity.this, PagamentoActivity.class);
                    intentPagamento.putExtras(bundle);

                    edtNome.setText("");
                    edtValorHora.setText("");
                    edtHorasTrab.setText("");

                    startActivity(intentPagamento);

                }

            }
        });




    }
}
