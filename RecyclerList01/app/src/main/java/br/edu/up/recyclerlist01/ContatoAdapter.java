package br.edu.up.recyclerlist01;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import java.util.ArrayList;

public class ContatoAdapter extends RecyclerView.Adapter {

    private ArrayList<Contato> listaContatos;
    private Context context;

    public ContatoAdapter(ArrayList<Contato> listaContatos, Context context) {
        this.listaContatos = listaContatos;
        this.context = context;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(context).inflate(R.layout.celula_contato, parent, false);
        ContatoHolder holder = new ContatoHolder(view);

        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, final int position) {

        final ContatoHolder contatoHolder = (ContatoHolder)holder;
        contatoHolder.txtNomeCel.setText(listaContatos.get(position).getNome());
        contatoHolder.txtFoneCel.setText(listaContatos.get(position).getFone());

        contatoHolder.txtNomeCel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               // Toast.makeText(context, "Posição: " + position, Toast.LENGTH_SHORT).show();

                Contato c = ContatoLista.getContato(position);

                Bundle detalhes = new Bundle();
                detalhes.putInt("index",position);
                detalhes.putString("nome", c.getNome());
                detalhes.putString("fone", c.getFone());
                detalhes.putString("email", c.getEmail());
                detalhes.putString("endereco", c.getEndereco());

                Intent intent = new Intent(context, DetalhesActivity.class);

                intent.putExtras(detalhes);

                context.startActivity(intent);

            }
        });


    }

    @Override
    public int getItemCount() {
        return listaContatos.size();
    }
}
