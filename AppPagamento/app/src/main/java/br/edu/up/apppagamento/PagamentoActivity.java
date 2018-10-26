package br.edu.up.apppagamento;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import java.util.Locale;

public class PagamentoActivity extends AppCompatActivity {

    TextView txtNomeCad;
    TextView txtHorasTrabCad;
    TextView txtValorHoraCad;
    TextView txtSalBruto;
    TextView txtIR;
    TextView txtINSS;
    TextView txtFGTS;
    TextView txtSalLiq;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pagamento);

        txtNomeCad      = findViewById(R.id.txtNomeCad);
        txtValorHoraCad = findViewById(R.id.txtValorHoraCad);
        txtHorasTrabCad = findViewById(R.id.txtHorasTrabCad);
        txtSalBruto     = findViewById(R.id.txtSalBruto);
        txtIR           = findViewById(R.id.txtIR);
        txtINSS         = findViewById(R.id.txtINSS);
        txtFGTS         = findViewById(R.id.txtFGTS);
        txtSalLiq       = findViewById(R.id.txtSalLiq);

        Intent intent = getIntent();
        Bundle bundle = intent.getExtras();

        String nome     = bundle.getString("nome");
        int horasTrab   = bundle.getInt("horasTrab");
        float valorHora = bundle.getFloat("valorHora");

        Folha folha = new Folha(nome, horasTrab, valorHora);
        folha.calcSalario();

        txtNomeCad.setText(txtNomeCad.getText().toString() + nome);
        txtHorasTrabCad.setText(txtHorasTrabCad.getText().toString() + String.valueOf(horasTrab));
        txtValorHoraCad.setText(txtValorHoraCad.getText().toString() + converter(valorHora));
        txtSalBruto.setText(txtSalBruto.getText().toString() + converter(folha.getSalBruto()));
        txtIR.setText(txtIR.getText().toString() + converter(folha.getIr()));
        txtINSS.setText(txtINSS.getText().toString() + converter(folha.getInss()));
        txtFGTS.setText(txtFGTS.getText().toString() + converter(folha.getFgts()));
        txtSalLiq.setText(txtSalLiq.getText().toString() + converter(folha.getSalLiq()));

    }// fim onCreate

    public String converter(float valor){
        String texto = String.format(Locale.FRANCE, "%.2f", valor);
        return texto;
    }
}
